<template>
  <a-spin :spinning="confirmLoading">
    <JFormContainer :disabled="disabled">
      <template #detail>
        <a-form ref="formRef" class="antd-modal-form" :labelCol="labelCol" :wrapperCol="wrapperCol" name="BizDeviceForm">
          <a-row>
						<a-col :span="12">
							<a-form-item label="设备编号（唯一）" v-bind="validateInfos.deviceNo" id="BizDeviceForm-deviceNo" name="deviceNo">
								<a-input v-model:value="formData.deviceNo" placeholder="请输入设备编号（唯一）"  allow-clear ></a-input>
							</a-form-item>
						</a-col>
						<a-col :span="12">
							<a-form-item label="生产批次" v-bind="validateInfos.productionBatch" id="BizDeviceForm-productionBatch" name="productionBatch">
								<a-input v-model:value="formData.productionBatch" placeholder="请输入生产批次"  allow-clear ></a-input>
							</a-form-item>
						</a-col>
						<a-col :span="12">
							<a-form-item label="生产日期" v-bind="validateInfos.productionDate" id="BizDeviceForm-productionDate" name="productionDate">
								<a-date-picker placeholder="请选择生产日期"  v-model:value="formData.productionDate" showTime value-format="YYYY-MM-DD HH:mm:ss" style="width: 100%"  allow-clear />
							</a-form-item>
						</a-col>
						<a-col :span="12">
							<a-form-item label="生产人员姓名" v-bind="validateInfos.productionPerson" id="BizDeviceForm-productionPerson" name="productionPerson">
								<a-input v-model:value="formData.productionPerson" placeholder="请输入生产人员姓名"  allow-clear ></a-input>
							</a-form-item>
						</a-col>
						<a-col :span="12">
							<a-form-item label="维保联系电话" v-bind="validateInfos.maintenanceTel" id="BizDeviceForm-maintenanceTel" name="maintenanceTel">
								<a-input v-model:value="formData.maintenanceTel" placeholder="请输入维保联系电话"  allow-clear ></a-input>
							</a-form-item>
						</a-col>
						<a-col :span="12">
							<a-form-item label="生产图纸 PDF 存储路径" v-bind="validateInfos.drawingPdfUrl" id="BizDeviceForm-drawingPdfUrl" name="drawingPdfUrl">
								<j-image-upload :fileMax="0" v-model:value="formData.drawingPdfUrl" ></j-image-upload>
							</a-form-item>
						</a-col>
						<a-col :span="12">
							<a-form-item label="出货状态" v-bind="validateInfos.status" id="BizDeviceForm-status" name="status">
								<j-dict-select-tag v-model:value="formData.status" dictCode="qr-status" placeholder="请选择出货状态"  allow-clear />
							</a-form-item>
						</a-col>
						<a-col :span="12">
							<a-form-item label="出货日期" v-bind="validateInfos.shippedDate" id="BizDeviceForm-shippedDate" name="shippedDate">
								<a-date-picker placeholder="请选择出货日期"  v-model:value="formData.shippedDate" showTime value-format="YYYY-MM-DD HH:mm:ss" style="width: 100%"  allow-clear />
							</a-form-item>
						</a-col>
						<a-col :span="12">
							<a-form-item label="出货去向" v-bind="validateInfos.shippedTo" id="BizDeviceForm-shippedTo" name="shippedTo">
								<a-input v-model:value="formData.shippedTo" placeholder="请输入出货去向"  allow-clear ></a-input>
							</a-form-item>
						</a-col>
          </a-row>
        </a-form>
      </template>
    </JFormContainer>
  </a-spin>
</template>

<script lang="ts" setup>
  import { ref, reactive, defineExpose, nextTick, defineProps, computed, onMounted } from 'vue';
  import { defHttp } from '/@/utils/http/axios';
  import { useMessage } from '/@/hooks/web/useMessage';
  import JDictSelectTag from '/@/components/Form/src/jeecg/components/JDictSelectTag.vue';
  import JImageUpload from '/@/components/Form/src/jeecg/components/JImageUpload.vue';
  import { getValueType } from '/@/utils';
  import { saveOrUpdate } from '../BizDevice.api';
  import { Form } from 'ant-design-vue';
  import JFormContainer from '/@/components/Form/src/container/JFormContainer.vue';
  const props = defineProps({
    formDisabled: { type: Boolean, default: false },
    formData: { type: Object, default: () => ({})},
    formBpm: { type: Boolean, default: true }
  });
  const formRef = ref();
  const useForm = Form.useForm;
  const emit = defineEmits(['register', 'ok']);
  const formData = reactive<Record<string, any>>({
    id: '',
    deviceNo: '',   
    productionBatch: '',   
    productionDate: '',   
    productionPerson: '',   
    maintenanceTel: '',   
    drawingPdfUrl: '',   
    status: '',   
    shippedDate: '',   
    shippedTo: '',   
  });
  const { createMessage } = useMessage();
  const labelCol = ref<any>({ xs: { span: 24 }, sm: { span: 5 } });
  const wrapperCol = ref<any>({ xs: { span: 24 }, sm: { span: 16 } });
  const confirmLoading = ref<boolean>(false);
  //表单验证
  const validatorRules = reactive({
    deviceNo: [{ required: true, message: '请输入设备编号（唯一）!'},],
    status: [{ required: true, message: '请输入出货状态!'},],
  });
  const { resetFields, validate, validateInfos } = useForm(formData, validatorRules, { immediate: false });

  // 表单禁用
  const disabled = computed(()=>{
    if(props.formBpm === true){
      if(props.formData.disabled === false){
        return false;
      }else{
        return true;
      }
    }
    return props.formDisabled;
  });

  
  /**
   * 新增
   */
  function add() {
    edit({});
  }

  /**
   * 编辑
   */
  function edit(record) {
    nextTick(() => {
      resetFields();
      const tmpData = {};
      Object.keys(formData).forEach((key) => {
        if(record.hasOwnProperty(key)){
          tmpData[key] = record[key]
        }
      })
      //赋值
      Object.assign(formData, tmpData);
    });
  }

  /**
   * 提交数据
   */
  async function submitForm() {
    try {
      // 触发表单验证
      await validate();
    } catch ({ errorFields }) {
      if (errorFields) {
        const firstField = errorFields[0];
        if (firstField) {
          formRef.value.scrollToField(firstField.name, { behavior: 'smooth', block: 'center' });
        }
      }
      return Promise.reject(errorFields);
    }
    confirmLoading.value = true;
    const isUpdate = ref<boolean>(false);
    //时间格式化
    let model = formData;
    if (model.id) {
      isUpdate.value = true;
    }
    //循环数据
    for (let data in model) {
      //如果该数据是数组并且是字符串类型
      if (model[data] instanceof Array) {
        let valueType = getValueType(formRef.value.getProps, data);
        //如果是字符串类型的需要变成以逗号分割的字符串
        if (valueType === 'string') {
          model[data] = model[data].join(',');
        }
      }
    }
    await saveOrUpdate(model, isUpdate.value)
      .then((res) => {
        if (res.success) {
          createMessage.success(res.message);
          emit('ok');
        } else {
          createMessage.warning(res.message);
        }
      })
      .finally(() => {
        confirmLoading.value = false;
      });
  }


  defineExpose({
    add,
    edit,
    submitForm,
  });
</script>

<style lang="less" scoped>
  .antd-modal-form {
    padding: 14px;
  }
</style>
