<template>
  <BasicModal v-bind="$attrs" @register="registerModal" :title="'打印二维码'" width="360px" :footer="null">
    <div id="bizDeviceQr" style="text-align: center;">
      <QrCode :value="qrUrl" :width="260" />
    </div>
    <div style="text-align: center; margin-top: 10px;">
      <a-button type="primary" @click="onPrint">打印</a-button>
    </div>
  </BasicModal>
</template>
<script lang="ts" setup>
import { ref } from 'vue';
import { BasicModal, useModalInner } from '/@/components/Modal';
import { QrCode } from '/@/components/Qrcode';
import { printJS } from '/@/hooks/web/usePrintJS';

const qrUrl = ref('');
const [registerModal, { setModalProps }] = useModalInner((data: { url: string }) => {
  qrUrl.value = data?.url || '';
  setModalProps({ visible: true });
});

function onPrint() {
  printJS({ printable: 'bizDeviceQr', type: 'html' });
}
</script>
