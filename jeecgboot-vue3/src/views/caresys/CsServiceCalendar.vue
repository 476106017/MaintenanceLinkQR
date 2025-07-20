<template>
  <div class="p-2">
    <div class="mb-2">
      <a-radio-group v-model:value="viewMode">
        <a-radio-button value="calendar">日历视图</a-radio-button>
        <a-radio-button value="resident">利用者视图</a-radio-button>
      </a-radio-group>
    </div>

    <div v-show="viewMode === 'calendar'">
      <a-calendar v-model:value="current" :fullscreen="true">
        <template #dateCellRender="{ current: date }">
          <div class="cell-wrapper">
            <div class="event-list">
              <div
                class="event-item"
                v-for="item in getDateEvents(date)"
                :key="item.id"
                :class="item.type"
                @click="handleView(item)"
              >
                <a-tooltip :title="item.residentName + ' - ' + item.title">
                  <span>{{ item.title }}</span>
                </a-tooltip>
              </div>
            </div>
            <PlusOutlined class="add-icon" @click.stop="handleAdd(date)" />
          </div>
        </template>
      </a-calendar>
    </div>

    <div v-show="viewMode === 'resident'" class="resident-wrapper">
      <table class="resident-table">
        <thead>
          <tr>
            <th class="resident-name-col">利用者</th>
            <th v-for="day in monthDays" :key="day.format('YYYY-MM-DD')">
              {{ day.format('MM/DD') }}
            </th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="res in residents" :key="res.id">
            <td class="resident-name">{{ res.name }}</td>
            <td
              v-for="day in monthDays"
              :key="res.id + '-' + day.format('YYYY-MM-DD')"
            >
              <div class="cell-wrapper">
                <div class="event-list">
                  <div
                    class="event-item"
                    v-for="item in getResidentDateEvents(res.id, day)"
                    :key="item.id"
                    :class="item.type"
                    @click="handleView(item)"
                  >
                    <a-tooltip :title="item.title">
                      <span>{{ item.title }}</span>
                    </a-tooltip>
                  </div>
                </div>
                <PlusOutlined
                  class="add-icon"
                  @click.stop="handleAddForResident(res.id, day)"
                />
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <CsCareRecordModal ref="recordModal" @success="loadEvents" />
    <CsCarePlanModal ref="planModal" @success="loadEvents" />
  </div>
</template>

<script lang="ts" setup>
import { ref, onMounted, computed, watch } from 'vue';
import dayjs from 'dayjs';
import { list as listPlan } from './CsCarePlan.api';
import { list as listRecord } from './CsCareRecord.api';
import { list as listResident } from './CsResident.api';
import CsCareRecordModal from './components/CsCareRecordModal.vue';
import CsCarePlanModal from './components/CsCarePlanModal.vue';
import { PlusOutlined } from '@ant-design/icons-vue';

interface CalendarEvent {
  id: string;
  date: string;
  residentId: string;
  residentName: string;
  type: 'plan' | 'record';
  title: string;
  raw: any;
}

const current = ref(dayjs());
const events = ref<CalendarEvent[]>([]);
const residents = ref<any[]>([]);
const recordModal = ref();
const planModal = ref();
const viewMode = ref<'calendar' | 'resident'>('calendar');

const monthDays = computed(() => {
  const start = current.value.startOf('month');
  const end = current.value.endOf('month');
  const days: dayjs.Dayjs[] = [];
  for (let d = start; d.isBefore(end) || d.isSame(end, 'day'); d = d.add(1, 'day')) {
    days.push(d);
  }
  return days;
});

watch(
  () => current.value.format('YYYY-MM'),
  () => {
    loadEvents();
  }
);

onMounted(() => {
  loadAll();
});

async function loadAll() {
  await loadResidents();
  await loadEvents();
}

async function loadResidents() {
  const res = await listResident({ pageNo: 1, pageSize: 999 });
  residents.value = res?.result?.records || [];
}

async function loadEvents() {
  const monthStart = current.value.startOf('month').format('YYYY-MM-DD 00:00:00');
  const monthEnd = current.value.endOf('month').format('YYYY-MM-DD 23:59:59');
  const [planRes, recordRes] = await Promise.all([
    listPlan({
      pageNo: 1,
      pageSize: 999,
      planDate_begin: monthStart,
      planDate_end: monthEnd,
    }),
    listRecord({
      pageNo: 1,
      pageSize: 999,
      recordTime_begin: monthStart,
      recordTime_end: monthEnd,
    }),
  ]);
  events.value = [];

  if (planRes?.result?.records) {
    events.value.push(
      ...planRes.result.records.map((p: any) => ({
        id: p.id,
        date: dayjs(p.planDate).format('YYYY-MM-DD'),
        residentId: p.residentId,
        residentName: getResidentName(p.residentId),
        type: 'plan',
        title: p.serviceItems || '计划',
        raw: p,
      }))
    );
  }

  if (recordRes?.result?.records) {
    events.value.push(
      ...recordRes.result.records.map((r: any) => ({
        id: r.id,
        date: dayjs(r.recordTime).format('YYYY-MM-DD'),
        residentId: r.residentId,
        residentName: getResidentName(r.residentId),
        type: 'record',
        title: r.serviceContent || '记录',
        raw: r,
      }))
    );
  }
}

function getDateEvents(date: dayjs.Dayjs) {
  const d = date.format('YYYY-MM-DD');
  return events.value.filter((e) => e.date === d);
}

function getResidentDateEvents(residentId: string, date: dayjs.Dayjs) {
  const d = date.format('YYYY-MM-DD');
  return events.value.filter((e) => e.date === d && e.residentId === residentId);
}

function handleView(item: CalendarEvent) {
  if (item.type === 'record') {
    recordModal.value.disableSubmit = true;
    recordModal.value.edit(item.raw);
  } else {
    planModal.value.disableSubmit = true;
    planModal.value.edit(item.raw);
  }
}

function handleAdd(date: dayjs.Dayjs) {
  const dt = date.format('YYYY-MM-DD 00:00:00');
  recordModal.value.disableSubmit = false;
  recordModal.value.edit({ recordTime: dt });
}

function handleAddForResident(residentId: string, date: dayjs.Dayjs) {
  const dt = date.format('YYYY-MM-DD 00:00:00');
  recordModal.value.disableSubmit = false;
  recordModal.value.edit({ recordTime: dt, residentId });
}

function getResidentName(id: string) {
  const r = residents.value.find((m) => m.id === id);
  return r ? r.name : '';
}
</script>

<style scoped>
.event-list {
  margin: 0;
  padding: 0;
  list-style: none;
}
.event-item {
  font-size: 12px;
  margin-bottom: 2px;
  padding: 2px 4px;
  border-radius: 2px;
  background-color: #f0f2f5;
}
.event-item.record {
  background-color: #fde2e2;
}
.event-item.plan {
  background-color: #e6f7ff;
}

.cell-wrapper {
  position: relative;
}

.add-icon {
  position: absolute;
  right: 2px;
  bottom: 2px;
  font-size: 12px;
  cursor: pointer;
  color: #1890ff;
}

.resident-wrapper {
  overflow: auto;
}

.resident-table {
  border-collapse: collapse;
  width: max-content;
}

.resident-table th,
.resident-table td {
  border: 1px solid #f0f0f0;
  min-width: 100px;
  padding: 4px;
  vertical-align: top;
}

.resident-name-col {
  position: sticky;
  left: 0;
  background: #fafafa;
  z-index: 2;
}

.resident-name {
  background: #fafafa;
  white-space: nowrap;
  position: sticky;
  left: 0;
  z-index: 1;
}
</style>
