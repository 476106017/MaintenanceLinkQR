<template>
  <a-spin :spinning="confirmLoading">
    <JFormContainer :disabled="disabled">
      <template #detail>
        <a-form ref="formRef" class="antd-modal-form" :labelCol="labelCol" :wrapperCol="wrapperCol" name="CsRiskReportForm">
          <a-row>
						<a-col :span="24">
							<a-form-item label="所属公司" v-bind="validateInfos.companyId" id="CsRiskReportForm-companyId" name="companyId">
								<a-input v-model:value="formData.companyId" placeholder="请输入所属公司"  allow-clear ></a-input>
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="所属事务所" v-bind="validateInfos.officeId" id="CsRiskReportForm-officeId" name="officeId">
								<a-input v-model:value="formData.officeId" placeholder="请输入所属事务所"  allow-clear ></a-input>
							</a-form-item>
						</a-col>
						<a-col :span="24">
                                                        <a-form-item label="关联老人" v-bind="validateInfos.residentId" id="CsRiskReportForm-residentId" name="residentId">
                                                                <JSearchSelect dict="cs_resident,name,id" v-model:value="formData.residentId" placeholder="请选择关联老人" allow-clear />
                                                        </a-form-item>
						</a-col>
						<a-col :span="24">
                                                        <a-form-item label="报告类型（跌倒等）" v-bind="validateInfos.reportType" id="CsRiskReportForm-reportType" name="reportType">
                                                                <a-select v-model:value="formData.reportType" :options="reportTypeOptions" placeholder="请选择报告类型" allow-clear />
                                                        </a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="报告时间" v-bind="validateInfos.reportTime" id="CsRiskReportForm-reportTime" name="reportTime">
								<a-date-picker placeholder="请选择报告时间"  v-model:value="formData.reportTime" showTime value-format="YYYY-MM-DD HH:mm:ss" style="width: 100%"  allow-clear />
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="详情描述" v-bind="validateInfos.description" id="CsRiskReportForm-description" name="description">
								<a-textarea v-model:value="formData.description" :rows="4" placeholder="请输入详情描述" />
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
  import { getValueType } from '/@/utils';
  import { saveOrUpdate } from '../CsRiskReport.api';
  import { Form } from 'ant-design-vue';
  import JFormContainer from '/@/components/Form/src/container/JFormContainer.vue';
  import JSearchSelect from '/@/components/Form/src/jeecg/components/JSearchSelect.vue';
  import { reportTypeOptions } from '/@/enums/careSysEnum';
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
    companyId: '',   
    officeId: '',   
    residentId: '',   
    reportType: '',   
    reportTime: '',   
    description: '',   
  });
  const { createMessage } = useMessage();
  const labelCol = ref<any>({ xs: { span: 24 }, sm: { span: 5 } });
  const wrapperCol = ref<any>({ xs: { span: 24 }, sm: { span: 16 } });
  const confirmLoading = ref<boolean>(false);
  //表单验证
  const validatorRules = reactive({
    residentId: [{ required: true, message: '请输入关联老人!'},],
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
