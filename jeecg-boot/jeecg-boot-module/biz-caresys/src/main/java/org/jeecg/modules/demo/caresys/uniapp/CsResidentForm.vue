<template>
    <view>
        <!--标题和返回-->
		<cu-custom :bgColor="NavBarColor" isBack :backRouterName="backRouteName">
			<block slot="backText">返回</block>
			<block slot="content">cs_resident</block>
		</cu-custom>
		 <!--表单区域-->
		<view>
			<form>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">编号：</text></view>
                  <input  placeholder="请输入编号" v-model="model.residentCode"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">姓名：</text></view>
                  <input  placeholder="请输入姓名" v-model="model.name"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">姓名假名：</text></view>
                  <input  placeholder="请输入姓名假名" v-model="model.nameKana"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">性别（M:男, F:女）：</text></view>
                  <input  placeholder="请输入性别（M:男, F:女）" v-model="model.gender"/>
                </view>
              </view>
              <my-date label="出生日期：" fields="day" v-model="model.birthDate" placeholder="请输入出生日期"></my-date>
              <my-date label="死亡日期：" fields="day" v-model="model.deathDate" placeholder="请输入死亡日期"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">年龄（冗余字段）：</text></view>
                  <input type="number" placeholder="请输入年龄（冗余字段）" v-model="model.age"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">联系电话：</text></view>
                  <input  placeholder="请输入联系电话" v-model="model.phoneNumber"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">居住地址：</text></view>
                  <input  placeholder="请输入居住地址" v-model="model.address"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">头像照片URL：</text></view>
                  <input  placeholder="请输入头像照片URL" v-model="model.photoUrl"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">监护人姓名：</text></view>
                  <input  placeholder="请输入监护人姓名" v-model="model.guardianName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">与被照护者关系：</text></view>
                  <input  placeholder="请输入与被照护者关系" v-model="model.guardianRelationship"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">监护人联系电话：</text></view>
                  <input  placeholder="请输入监护人联系电话" v-model="model.guardianPhone"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">要介护等级：</text></view>
                  <input  placeholder="请输入要介护等级" v-model="model.careLevel"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">介护认证编号：</text></view>
                  <input  placeholder="请输入介护认证编号" v-model="model.careCertNumber"/>
                </view>
              </view>
              <my-date label="开始照护日期：" fields="day" v-model="model.careStartDate" placeholder="请输入开始照护日期"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">居住类型（独居/与家人同住/机构等）：</text></view>
                  <input  placeholder="请输入居住类型（独居/与家人同住/机构等）" v-model="model.residenceType"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否有认知症：</text></view>
                  <input type="number" placeholder="请输入是否有认知症" v-model="model.isDementia"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">疾病备注：</text></view>
                  <input  placeholder="请输入疾病备注" v-model="model.diseaseNotes"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">过敏信息：</text></view>
                  <input  placeholder="请输入过敏信息" v-model="model.allergyNotes"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">状态（active/disabled/deceased）：</text></view>
                  <input  placeholder="请输入状态（active/disabled/deceased）" v-model="model.status"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">逻辑删除标识：</text></view>
                  <input type="number" placeholder="请输入逻辑删除标识" v-model="model.deleteFlag"/>
                </view>
              </view>
				<view class="padding">
					<button class="cu-btn block bg-blue margin-tb-sm lg" @click="onSubmit">
						<text v-if="loading" class="cuIcon-loading2 cuIconfont-spin"></text>提交
					</button>
				</view>
			</form>
		</view>
    </view>
</template>

<script>
    import myDate from '@/components/my-componets/my-date.vue'

    export default {
        name: "CsResidentForm",
        components:{ myDate },
        props:{
          formData:{
              type:Object,
              default:()=>{},
              required:false
          }
        },
        data(){
            return {
				CustomBar: this.CustomBar,
				NavBarColor: this.NavBarColor,
				loading:false,
                model: {},
                backRouteName:'index',
                url: {
                  queryById: "/caresys/csResident/queryById",
                  add: "/caresys/csResident/add",
                  edit: "/caresys/csResident/edit",
                },
            }
        },
        created(){
             this.initFormData();
        },
        methods:{
           initFormData(){
               if(this.formData){
                    let dataId = this.formData.dataId;
                    this.$http.get(this.url.queryById,{params:{id:dataId}}).then((res)=>{
                        if(res.data.success){
                            console.log("表单数据",res);
                            this.model = res.data.result;
                        }
                    })
                }
            },
            onSubmit() {
                let myForm = {...this.model};
                this.loading = true;
                let url = myForm.id?this.url.edit:this.url.add;
				this.$http.post(url,myForm).then(res=>{
				   console.log("res",res)
				   this.loading = false
				   this.$Router.push({name:this.backRouteName})
				}).catch(()=>{
					this.loading = false
				});
            }
        }
    }
</script>
