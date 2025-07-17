<route lang="json5" type="page">
{
layout: 'default',
style: {
navigationStyle: 'custom',
navigationBarTitleText: 'cs_resident',
},
}
</route>

<template>
  <PageLayout :navTitle="navTitle" :backRouteName="backRouteName">
    <scroll-view class="scrollArea" scroll-y>
      <view class="form-container">
        <wd-form ref="form" :model="myFormData">
          <wd-cell-group border>
          <view class="{ 'mt-14px': 0 == 0 }">
              <wd-input
                  label-width="100px"
                  v-model="myFormData['residentCode']"
                  :label="get4Label('编号')"
                  name='residentCode'
                  prop='residentCode'
                  placeholder="请选择编号"
                  :rules="[
                                  { required: true, message: '请输入编号!'},
                  ]"
                  clearable
              />
        </view>
          <view class="{ 'mt-14px': 1 == 0 }">
              <wd-input
                  label-width="100px"
                  v-model="myFormData['name']"
                  :label="get4Label('姓名')"
                  name='name'
                  prop='name'
                  placeholder="请选择姓名"
                  :rules="[
                                  { required: true, message: '请输入姓名!'},
                  ]"
                  clearable
              />
        </view>
          <view class="{ 'mt-14px': 0 == 0 }">
              <wd-input
                  label-width="100px"
                  v-model="myFormData['nameKana']"
                  :label="get4Label('姓名假名')"
                  name='nameKana'
                  prop='nameKana'
                  placeholder="请选择姓名假名"
                  :rules="[
                  ]"
                  clearable
              />
        </view>
          <view class="{ 'mt-14px': 1 == 0 }">
              <wd-input
                  label-width="100px"
                  v-model="myFormData['gender']"
                  :label="get4Label('性别（M:男, F:女）')"
                  name='gender'
                  prop='gender'
                  placeholder="请选择性别（M:男, F:女）"
                  :rules="[
                  ]"
                  clearable
              />
        </view>
          <view class="{ 'mt-14px': 0 == 0 }">
              <online-date
                  :label="get4Label('出生日期')"
                  labelWidth="100px"
                  type="date"
                  name='birthDate'
                  v-model:value="myFormData['birthDate']"
              ></online-date>
        </view>
          <view class="{ 'mt-14px': 1 == 0 }">
              <online-date
                  :label="get4Label('死亡日期')"
                  labelWidth="100px"
                  type="date"
                  name='deathDate'
                  v-model:value="myFormData['deathDate']"
              ></online-date>
        </view>
          <view class="{ 'mt-14px': 0 == 0 }">
               <wd-input
                   label-width="100px"
                   v-model="myFormData['age']"
                   :label="get4Label('年龄（冗余字段）')"
                   name='age'
                   prop='age'
                   placeholder="请选择年龄（冗余字段）"
                   inputMode="numeric"
                   :rules="[
                   ]"
                   clearable
              />
        </view>
          <view class="{ 'mt-14px': 1 == 0 }">
              <wd-input
                  label-width="100px"
                  v-model="myFormData['phoneNumber']"
                  :label="get4Label('联系电话')"
                  name='phoneNumber'
                  prop='phoneNumber'
                  placeholder="请选择联系电话"
                  :rules="[
                  ]"
                  clearable
              />
        </view>
          <view class="{ 'mt-14px': 0 == 0 }">
              <wd-textarea
                :label="get4Label('居住地址')"
                 labelWidth="100px"
                 type="textarea"
                 name='address'
                 prop='address'
                 clearable
                 :maxlength="300"
                v-model="myFormData['address']"
              ></wd-textarea>
        </view>
          <view class="{ 'mt-14px': 1 == 0 }">
              <wd-textarea
                :label="get4Label('头像照片URL')"
                 labelWidth="100px"
                 type="textarea"
                 name='photoUrl'
                 prop='photoUrl'
                 clearable
                 :maxlength="300"
                v-model="myFormData['photoUrl']"
              ></wd-textarea>
        </view>
          <view class="{ 'mt-14px': 0 == 0 }">
              <wd-input
                  label-width="100px"
                  v-model="myFormData['guardianName']"
                  :label="get4Label('监护人姓名')"
                  name='guardianName'
                  prop='guardianName'
                  placeholder="请选择监护人姓名"
                  :rules="[
                  ]"
                  clearable
              />
        </view>
          <view class="{ 'mt-14px': 1 == 0 }">
              <wd-input
                  label-width="100px"
                  v-model="myFormData['guardianRelationship']"
                  :label="get4Label('与被照护者关系')"
                  name='guardianRelationship'
                  prop='guardianRelationship'
                  placeholder="请选择与被照护者关系"
                  :rules="[
                  ]"
                  clearable
              />
        </view>
          <view class="{ 'mt-14px': 0 == 0 }">
              <wd-input
                  label-width="100px"
                  v-model="myFormData['guardianPhone']"
                  :label="get4Label('监护人联系电话')"
                  name='guardianPhone'
                  prop='guardianPhone'
                  placeholder="请选择监护人联系电话"
                  :rules="[
                  ]"
                  clearable
              />
        </view>
          <view class="{ 'mt-14px': 1 == 0 }">
              <wd-input
                  label-width="100px"
                  v-model="myFormData['careLevel']"
                  :label="get4Label('要介护等级')"
                  name='careLevel'
                  prop='careLevel'
                  placeholder="请选择要介护等级"
                  :rules="[
                  ]"
                  clearable
              />
        </view>
          <view class="{ 'mt-14px': 0 == 0 }">
              <wd-input
                  label-width="100px"
                  v-model="myFormData['careCertNumber']"
                  :label="get4Label('介护认证编号')"
                  name='careCertNumber'
                  prop='careCertNumber'
                  placeholder="请选择介护认证编号"
                  :rules="[
                  ]"
                  clearable
              />
        </view>
          <view class="{ 'mt-14px': 1 == 0 }">
              <online-date
                  :label="get4Label('开始照护日期')"
                  labelWidth="100px"
                  type="date"
                  name='careStartDate'
                  v-model:value="myFormData['careStartDate']"
              ></online-date>
        </view>
          <view class="{ 'mt-14px': 0 == 0 }">
              <wd-input
                  label-width="100px"
                  v-model="myFormData['residenceType']"
                  :label="get4Label('居住类型（独居/与家人同住/机构等）')"
                  name='residenceType'
                  prop='residenceType'
                  placeholder="请选择居住类型（独居/与家人同住/机构等）"
                  :rules="[
                  ]"
                  clearable
              />
        </view>
          <view class="{ 'mt-14px': 1 == 0 }">
               <wd-input
                   label-width="100px"
                   v-model="myFormData['isDementia']"
                   :label="get4Label('是否有认知症')"
                   name='isDementia'
                   prop='isDementia'
                   placeholder="请选择是否有认知症"
                   inputMode="numeric"
                   :rules="[
                   ]"
                   clearable
              />
        </view>
          <view class="{ 'mt-14px': 0 == 0 }">
              <wd-textarea
                :label="get4Label('疾病备注')"
                 labelWidth="100px"
                 type="textarea"
                 name='diseaseNotes'
                 prop='diseaseNotes'
                 clearable
                 :maxlength="300"
                v-model="myFormData['diseaseNotes']"
              ></wd-textarea>
        </view>
          <view class="{ 'mt-14px': 1 == 0 }">
              <wd-textarea
                :label="get4Label('过敏信息')"
                 labelWidth="100px"
                 type="textarea"
                 name='allergyNotes'
                 prop='allergyNotes'
                 clearable
                 :maxlength="300"
                v-model="myFormData['allergyNotes']"
              ></wd-textarea>
        </view>
          <view class="{ 'mt-14px': 0 == 0 }">
              <wd-input
                  label-width="100px"
                  v-model="myFormData['status']"
                  :label="get4Label('状态（active/disabled/deceased）')"
                  name='status'
                  prop='status'
                  placeholder="请选择状态（active/disabled/deceased）"
                  :rules="[
                  ]"
                  clearable
              />
        </view>
          <view class="{ 'mt-14px': 1 == 0 }">
               <wd-input
                   label-width="100px"
                   v-model="myFormData['deleteFlag']"
                   :label="get4Label('逻辑删除标识')"
                   name='deleteFlag'
                   prop='deleteFlag'
                   placeholder="请选择逻辑删除标识"
                   inputMode="numeric"
                   :rules="[
                   ]"
                   clearable
              />
        </view>
          </wd-cell-group>
        </wd-form>
      </view>
    </scroll-view>
    <view class="footer">
      <wd-button :disabled="loading" block :loading="loading" @click="handleSubmit">提交</wd-button>
    </view>
  </PageLayout>
</template>

<script lang="ts" setup>
import { onLoad } from '@dcloudio/uni-app'
import { http } from '@/utils/http'
import { useToast } from 'wot-design-uni'
import { useRouter } from '@/plugin/uni-mini-router'
import { ref, onMounted, computed,reactive } from 'vue'
import OnlineImage from '@/components/online/view/online-image.vue'
import OnlineFile from '@/components/online/view/online-file.vue'
import OnlineFileCustom from '@/components/online/view/online-file-custom.vue'
import OnlineSelect from '@/components/online/view/online-select.vue'
import OnlineTime from '@/components/online/view/online-time.vue'
import OnlineDate from '@/components/online/view/online-date.vue'
import OnlineRadio from '@/components/online/view/online-radio.vue'
import OnlineCheckbox from '@/components/online/view/online-checkbox.vue'
import OnlineMulti from '@/components/online/view/online-multi.vue'
import OnlinePopupLinkRecord from '@/components/online/view/online-popup-link-record.vue'
import SelectDept from '@/components/SelectDept/SelectDept.vue'
import SelectUser from '@/components/SelectUser/SelectUser.vue'
defineOptions({
  name: 'CsResidentForm',
  options: {
    styleIsolation: 'shared',
  },
})
const toast = useToast()
const router = useRouter()
const form = ref(null)
// 定义响应式数据
const myFormData = reactive({})
const loading = ref(false)
const navTitle = ref('新增')
const dataId = ref('')
const backRouteName = ref('CsResidentList')
// 定义 initForm 方法
const initForm = (item) => {
  console.log('initForm item', item)
  if(item?.dataId){
    dataId.value = item.dataId;
    navTitle.value = item.dataId?'编辑':'新增';
    initData();
  }
}
// 初始化数据
const initData = () => {
  http.get("/caresys/csResident/queryById",{id:dataId.value}).then((res) => {
    if (res.success) {
      let obj = res.result
      Object.assign(myFormData, { ...obj })
    }else{
      toast.error(res?.message || '表单加载失败！')
    }
  })
}
const handleSuccess = () => {
  uni.$emit('refreshList');
  router.back()
}
// 提交表单
const handleSubmit = () => {
  let url = dataId.value?'/caresys/csResident/edit':'/caresys/csResident/add';
  form.value
    .validate()
    .then(({ valid, errors }) => {
      if (valid) {
        loading.value = true;
        http.post(url,myFormData).then((res) => {
          loading.value = false;
          if (res.success) {
            toast.success('保存成功');
            handleSuccess()
          }else{
            toast.error(res?.message || '表单保存失败！')
          }
        })
      }
    })
    .catch((error) => {
      console.log(error, 'error')
      loading.value = false;
    })
}
// 标题
const get4Label = computed(() => {
  return (label) => {
    return label && label.length > 4 ? label.substring(0, 4) : label;
  }
})

// 标题
const getFormSchema = computed(() => {
  return (dictTable,dictCode,dictText) => {
    return {
      dictCode,
      dictTable,
      dictText
    };
  }
})
/**
 * 获取日期控件的扩展类型
 * @param picker
 * @returns {string}
 */
const getDateExtendType = (picker: string) => {
    let mapField = {
      month: 'year-month',
      year: 'year',
      quarter: 'quarter',
      week: 'week',
      day: 'date',
    }
    return picker && mapField[picker]
      ? mapField[picker]
      : 'date'
}
//设置pop返回值
const setFieldsValue = (data) => {
   Object.assign(myFormData, {...data })
}
// onLoad 生命周期钩子
onLoad((option) => {
  initForm(option)
})
</script>

<style lang="scss" scoped>
.footer {
  width: 100%;
  padding: 10px 20px;
  padding-bottom: calc(constant(safe-area-inset-bottom) + 10px);
  padding-bottom: calc(env(safe-area-inset-bottom) + 10px);
}
</style>
