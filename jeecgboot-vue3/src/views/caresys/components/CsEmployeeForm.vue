<template>
  <a-spin :spinning="confirmLoading">
    <JFormContainer :disabled="disabled">
      <template #detail>
        <a-form ref="formRef" class="antd-modal-form" :labelCol="labelCol" :wrapperCol="wrapperCol" name="CsEmployeeForm">
          <a-row>
						<a-col :span="24">
							<a-form-item label="所属公司" v-bind="validateInfos.companyId" id="CsEmployeeForm-companyId" name="companyId">
								<a-input v-model:value="formData.companyId" placeholder="请输入所属公司"  allow-clear ></a-input>
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="所属事务所" v-bind="validateInfos.officeId" id="CsEmployeeForm-officeId" name="officeId">
								<a-input v-model:value="formData.officeId" placeholder="请输入所属事务所"  allow-clear ></a-input>
							</a-form-item>
						</a-col>
						<a-col :span="24">
                                                        <a-form-item label="系统用户ID（关联sys_user.id）" v-bind="validateInfos.userId" id="CsEmployeeForm-userId" name="userId">
                                                                <JSearchSelect dict="sys_user,realname,id" v-model:value="formData.userId" placeholder="请选择系统用户" allow-clear />
                                                        </a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="员工编号" v-bind="validateInfos.employeeCode" id="CsEmployeeForm-employeeCode" name="employeeCode">
								<a-input v-model:value="formData.employeeCode" placeholder="请输入员工编号"  allow-clear ></a-input>
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="员工姓名" v-bind="validateInfos.name" id="CsEmployeeForm-name" name="name">
								<a-input v-model:value="formData.name" placeholder="请输入员工姓名"  allow-clear ></a-input>
							</a-form-item>
						</a-col>
						<a-col :span="24">
                                                        <a-form-item label="性别" v-bind="validateInfos.gender" id="CsEmployeeForm-gender" name="gender">
                                                                <a-select v-model:value="formData.gender" :options="genderOptions" placeholder="请选择性别" allow-clear />
                                                        </a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="出生日期" v-bind="validateInfos.birthDate" id="CsEmployeeForm-birthDate" name="birthDate">
								<a-date-picker placeholder="请选择出生日期"  v-model:value="formData.birthDate" value-format="YYYY-MM-DD"  style="width: 100%"  allow-clear />
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="联系电话" v-bind="validateInfos.phoneNumber" id="CsEmployeeForm-phoneNumber" name="phoneNumber">
								<a-input v-model:value="formData.phoneNumber" placeholder="请输入联系电话"  allow-clear ></a-input>
							</a-form-item>
						</a-col>
						<a-col :span="24">
                                                        <a-form-item label="雇佣形态（全职/兼职等）" v-bind="validateInfos.employmentType" id="CsEmployeeForm-employmentType" name="employmentType">
                                                                <a-select v-model:value="formData.employmentType" :options="employmentTypeOptions" placeholder="请选择雇佣形态" allow-clear />
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
  import { saveOrUpdate } from '../CsEmployee.api';
  import { Form } from 'ant-design-vue';
  import JFormContainer from '/@/components/Form/src/container/JFormContainer.vue';
  import JSearchSelect from '/@/components/Form/src/jeecg/components/JSearchSelect.vue';
  import { genderOptions, employmentTypeOptions } from '/@/enums/careSysEnum';
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
    userId: '',   
    employeeCode: '',   
    name: '',   
    gender: '',   
    birthDate: '',   
    phoneNumber: '',   
    employmentType: '',   
  });
  const { createMessage } = useMessage();
  const labelCol = ref<any>({ xs: { span: 24 }, sm: { span: 5 } });
  const wrapperCol = ref<any>({ xs: { span: 24 }, sm: { span: 16 } });
  const confirmLoading = ref<boolean>(false);
  //表单验证
  const validatorRules = reactive({
    employeeCode: [{ required: true, message: '请输入员工编号!'},],
    name: [{ required: true, message: '请输入员工姓名!'},],
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
