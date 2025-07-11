<template>
  <BasicModal v-bind="$attrs" @register="registerModal" :title="'打印二维码'" width="460px" :footer="null">
    <div id="bizDeviceQr" style="text-align: center;">
      <div style="font-size: 32px;">{{ typeNo }}</div>
      <QrCode :value="qrUrl" :width="200" />
      <div style="font-size: 32px;">扫码获取设备售后服务信息</div>
    </div>
    <div style="text-align: center; margin-top: 10px;">
      <a-button type="primary" @click="onPrint">打印</a-button>
    </div>
  </BasicModal>
</template>
<script lang="ts" setup>
import { ref, nextTick } from 'vue';
import { BasicModal, useModalInner } from '/@/components/Modal';
import { QrCode } from '/@/components/Qrcode';
import { printJS } from '/@/hooks/web/usePrintJS';

const qrUrl = ref('');
const typeNo = ref('');
const [registerModal, { setModalProps }] = useModalInner((data: { url: string; typeNo?: string }) => {
  qrUrl.value = data?.url || '';
  typeNo.value = data?.typeNo || '';
  setModalProps({ visible: true });
});

function onPrint() {
  printJS({ printable: 'bizDeviceQr', type: 'html' });
}
</script>
