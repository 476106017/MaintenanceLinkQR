<template>
  <a-spin :spinning="confirmLoading">
    <JFormContainer :disabled="disabled">
      <template #detail>
        <a-form ref="formRef" class="antd-modal-form" :labelCol="labelCol" :wrapperCol="wrapperCol" name="CsSalaryForm">
          <a-row>
						<a-col :span="24">
							<a-form-item label="所属公司" v-bind="validateInfos.companyId" id="CsSalaryForm-companyId" name="companyId">
								<a-input v-model:value="formData.companyId" placeholder="请输入所属公司"  allow-clear ></a-input>
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="所属事务所" v-bind="validateInfos.officeId" id="CsSalaryForm-officeId" name="officeId">
								<a-input v-model:value="formData.officeId" placeholder="请输入所属事务所"  allow-clear ></a-input>
							</a-form-item>
						</a-col>
						<a-col :span="24">
                                                        <a-form-item label="员工ID" v-bind="validateInfos.employeeId" id="CsSalaryForm-employeeId" name="employeeId">
                                                                <JSearchSelect dict="cs_employee,name,id" v-model:value="formData.employeeId" placeholder="请选择员工" allow-clear />
                                                        </a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="工资月份" v-bind="validateInfos.salaryMonth" id="CsSalaryForm-salaryMonth" name="salaryMonth">
								<a-input v-model:value="formData.salaryMonth" placeholder="请输入工资月份"  allow-clear ></a-input>
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="工时数" v-bind="validateInfos.workingHours" id="CsSalaryForm-workingHours" name="workingHours">
								<a-input-number v-model:value="formData.workingHours" placeholder="请输入工时数" style="width: 100%" />
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="基础工资" v-bind="validateInfos.baseSalary" id="CsSalaryForm-baseSalary" name="baseSalary">
								<a-input-number v-model:value="formData.baseSalary" placeholder="请输入基础工资" style="width: 100%" />
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="奖金" v-bind="validateInfos.bonus" id="CsSalaryForm-bonus" name="bonus">
								<a-input-number v-model:value="formData.bonus" placeholder="请输入奖金" style="width: 100%" />
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
  import { saveOrUpdate } from '../CsSalary.api';
  import { Form } from 'ant-design-vue';
  import JFormContainer from '/@/components/Form/src/container/JFormContainer.vue';
  import JSearchSelect from '/@/components/Form/src/jeecg/components/JSearchSelect.vue';
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
    employeeId: '',   
    salaryMonth: '',   
    workingHours: undefined,
    baseSalary: undefined,
    bonus: undefined,
  });
  const { createMessage } = useMessage();
  const labelCol = ref<any>({ xs: { span: 24 }, sm: { span: 5 } });
  const wrapperCol = ref<any>({ xs: { span: 24 }, sm: { span: 16 } });
  const confirmLoading = ref<boolean>(false);
  //表单验证
  const validatorRules = reactive({
    employeeId: [{ required: true, message: '请输入员工ID!'},],
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
