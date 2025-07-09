<template>
  <BasicModal v-bind="$attrs" @register="registerModal" :title="'打印二维码'" width="360px" :footer="null">
    <div id="bizDeviceQr" style="text-align: center">
      <div style="margin-bottom: 8px">{{ deviceType }}</div>
      <QrCode :value="qrUrl" :width="260" />
      <div style="margin-top: 8px">扫码了解更多信息</div>
    </div>
  </BasicModal>
</template>
<script lang="ts" setup>
  import { ref, nextTick } from 'vue';
  import { BasicModal, useModalInner } from '/@/components/Modal';
  import { QrCode } from '/@/components/Qrcode';
  import { printJS } from '/@/hooks/web/usePrintJS';

  const qrUrl = ref('');
  const deviceType = ref('');
  const [registerModal, { setModalProps }] = useModalInner((data: { url: string; deviceType: string }) => {
    qrUrl.value = data?.url || '';
    deviceType.value = data?.deviceType || '';
    setModalProps({ visible: true });
    nextTick(() => {
      printJS({ printable: 'bizDeviceQr', type: 'html' });
    });
  });
</script>
