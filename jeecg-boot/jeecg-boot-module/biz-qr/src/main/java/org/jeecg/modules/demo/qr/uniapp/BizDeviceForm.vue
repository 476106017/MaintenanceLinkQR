<template>
    <view>
        <!--标题和返回-->
		<cu-custom :bgColor="NavBarColor" isBack :backRouterName="backRouteName">
			<block slot="backText">返回</block>
			<block slot="content">设备二维码管理</block>
		</cu-custom>
		 <!--表单区域-->
		<view>
			<form>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">设备编号：</text></view>
                  <input  placeholder="请输入设备编号" v-model="model.no"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">设备名：</text></view>
                  <input  placeholder="请输入设备名" v-model="model.name"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">生产批次：</text></view>
                  <input  placeholder="请输入生产批次" v-model="model.productionBatch"/>
                </view>
              </view>
              <my-date label="生产日期：" v-model="model.productionDate" placeholder="请输入生产日期"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">生产人员：</text></view>
                  <input  placeholder="请输入生产人员" v-model="model.productionPerson"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">设备照片：</text></view>
                  <input  placeholder="请输入设备照片" v-model="model.picture"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">生产图纸：</text></view>
                  <input  placeholder="请输入生产图纸" v-model="model.drawingPdfUrl"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">出货状态：</text></view>
                  <input  placeholder="请输入出货状态" v-model="model.status"/>
                </view>
              </view>
              <my-date label="出货日期：" v-model="model.shippedDate" placeholder="请输入出货日期"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">出货去向：</text></view>
                  <input  placeholder="请输入出货去向" v-model="model.shippedTo"/>
                </view>
              </view>
              <my-date label="创建时间：" fields="day" v-model="model.createTime" placeholder="请输入创建时间"></my-date>
              <my-date label="更新时间：" fields="day" v-model="model.updateTime" placeholder="请输入更新时间"></my-date>
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
        name: "BizDeviceForm",
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
                  queryById: "/qr/bizDevice/queryById",
                  add: "/qr/bizDevice/add",
                  edit: "/qr/bizDevice/edit",
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
