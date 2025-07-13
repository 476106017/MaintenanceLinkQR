<template>
  <a-spin :spinning="confirmLoading">
    <JFormContainer :disabled="disabled">
      <template #detail>
        <a-form ref="formRef" class="antd-modal-form" :labelCol="labelCol" :wrapperCol="wrapperCol" name="CsResidentForm">
          <a-row>
						<a-col :span="24">
							<a-form-item label="编号" v-bind="validateInfos.residentCode" id="CsResidentForm-residentCode" name="residentCode">
								<a-input v-model:value="formData.residentCode" placeholder="请输入编号"  allow-clear ></a-input>
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="姓名" v-bind="validateInfos.name" id="CsResidentForm-name" name="name">
								<a-input v-model:value="formData.name" placeholder="请输入姓名"  allow-clear ></a-input>
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="姓名假名" v-bind="validateInfos.nameKana" id="CsResidentForm-nameKana" name="nameKana">
								<a-input v-model:value="formData.nameKana" placeholder="请输入姓名假名"  allow-clear ></a-input>
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="性别（M:男, F:女）" v-bind="validateInfos.gender" id="CsResidentForm-gender" name="gender">
								<a-input v-model:value="formData.gender" placeholder="请输入性别（M:男, F:女）"  allow-clear ></a-input>
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="出生日期" v-bind="validateInfos.birthDate" id="CsResidentForm-birthDate" name="birthDate">
								<a-date-picker placeholder="请选择出生日期"  v-model:value="formData.birthDate" value-format="YYYY-MM-DD"  style="width: 100%"  allow-clear />
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="死亡日期" v-bind="validateInfos.deathDate" id="CsResidentForm-deathDate" name="deathDate">
								<a-date-picker placeholder="请选择死亡日期"  v-model:value="formData.deathDate" value-format="YYYY-MM-DD"  style="width: 100%"  allow-clear />
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="年龄（冗余字段）" v-bind="validateInfos.age" id="CsResidentForm-age" name="age">
								<a-input-number v-model:value="formData.age" placeholder="请输入年龄（冗余字段）" style="width: 100%" />
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="联系电话" v-bind="validateInfos.phoneNumber" id="CsResidentForm-phoneNumber" name="phoneNumber">
								<a-input v-model:value="formData.phoneNumber" placeholder="请输入联系电话"  allow-clear ></a-input>
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="居住地址" v-bind="validateInfos.address" id="CsResidentForm-address" name="address">
								<a-textarea v-model:value="formData.address" :rows="4" placeholder="请输入居住地址" />
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="头像照片URL" v-bind="validateInfos.photoUrl" id="CsResidentForm-photoUrl" name="photoUrl">
								<a-textarea v-model:value="formData.photoUrl" :rows="4" placeholder="请输入头像照片URL" />
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="监护人姓名" v-bind="validateInfos.guardianName" id="CsResidentForm-guardianName" name="guardianName">
								<a-input v-model:value="formData.guardianName" placeholder="请输入监护人姓名"  allow-clear ></a-input>
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="与被照护者关系" v-bind="validateInfos.guardianRelationship" id="CsResidentForm-guardianRelationship" name="guardianRelationship">
								<a-input v-model:value="formData.guardianRelationship" placeholder="请输入与被照护者关系"  allow-clear ></a-input>
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="监护人联系电话" v-bind="validateInfos.guardianPhone" id="CsResidentForm-guardianPhone" name="guardianPhone">
								<a-input v-model:value="formData.guardianPhone" placeholder="请输入监护人联系电话"  allow-clear ></a-input>
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="要介护等级" v-bind="validateInfos.careLevel" id="CsResidentForm-careLevel" name="careLevel">
								<a-input v-model:value="formData.careLevel" placeholder="请输入要介护等级"  allow-clear ></a-input>
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="介护认证编号" v-bind="validateInfos.careCertNumber" id="CsResidentForm-careCertNumber" name="careCertNumber">
								<a-input v-model:value="formData.careCertNumber" placeholder="请输入介护认证编号"  allow-clear ></a-input>
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="开始照护日期" v-bind="validateInfos.careStartDate" id="CsResidentForm-careStartDate" name="careStartDate">
								<a-date-picker placeholder="请选择开始照护日期"  v-model:value="formData.careStartDate" value-format="YYYY-MM-DD"  style="width: 100%"  allow-clear />
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="居住类型（独居/与家人同住/机构等）" v-bind="validateInfos.residenceType" id="CsResidentForm-residenceType" name="residenceType">
								<a-input v-model:value="formData.residenceType" placeholder="请输入居住类型（独居/与家人同住/机构等）"  allow-clear ></a-input>
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="是否有认知症" v-bind="validateInfos.isDementia" id="CsResidentForm-isDementia" name="isDementia">
								<a-input-number v-model:value="formData.isDementia" placeholder="请输入是否有认知症" style="width: 100%" />
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="疾病备注" v-bind="validateInfos.diseaseNotes" id="CsResidentForm-diseaseNotes" name="diseaseNotes">
								<a-textarea v-model:value="formData.diseaseNotes" :rows="4" placeholder="请输入疾病备注" />
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="过敏信息" v-bind="validateInfos.allergyNotes" id="CsResidentForm-allergyNotes" name="allergyNotes">
								<a-textarea v-model:value="formData.allergyNotes" :rows="4" placeholder="请输入过敏信息" />
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="状态（active/disabled/deceased）" v-bind="validateInfos.status" id="CsResidentForm-status" name="status">
								<a-input v-model:value="formData.status" placeholder="请输入状态（active/disabled/deceased）"  allow-clear ></a-input>
							</a-form-item>
						</a-col>
						<a-col :span="24">
							<a-form-item label="逻辑删除标识" v-bind="validateInfos.deleteFlag" id="CsResidentForm-deleteFlag" name="deleteFlag">
								<a-input-number v-model:value="formData.deleteFlag" placeholder="请输入逻辑删除标识" style="width: 100%" />
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
  import { saveOrUpdate } from '../CsResident.api';
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
    residentCode: '',   
    name: '',   
    nameKana: '',   
    gender: '',   
    birthDate: '',   
    deathDate: '',   
    age: undefined,
    phoneNumber: '',   
    address: '',   
    photoUrl: '',   
    guardianName: '',   
    guardianRelationship: '',   
    guardianPhone: '',   
    careLevel: '',   
    careCertNumber: '',   
    careStartDate: '',   
    residenceType: '',   
    isDementia: undefined,
    diseaseNotes: '',   
    allergyNotes: '',   
    status: '',   
    deleteFlag: undefined,
  });
  const { createMessage } = useMessage();
  const labelCol = ref<any>({ xs: { span: 24 }, sm: { span: 5 } });
  const wrapperCol = ref<any>({ xs: { span: 24 }, sm: { span: 16 } });
  const confirmLoading = ref<boolean>(false);
  //表单验证
  const validatorRules = reactive({
    residentCode: [{ required: true, message: '请输入编号!'},],
    name: [{ required: true, message: '请输入姓名!'},],
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
