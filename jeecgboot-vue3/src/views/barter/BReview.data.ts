import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '关联交易ID',
    align:"center",
    dataIndex: 'tradeId'
   },
   {
    title: '评价人ID',
    align:"center",
    dataIndex: 'reviewerId'
   },
   {
    title: '被评价人ID',
    align:"center",
    dataIndex: 'targetUserId'
   },
   {
    title: '评分 1-5',
    align:"center",
    dataIndex: 'rating'
   },
   {
    title: '评价内容',
    align:"center",
    dataIndex: 'comment'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '关联交易ID',
    field: 'tradeId',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入关联交易ID!'},
          ];
     },
  },
  {
    label: '评价人ID',
    field: 'reviewerId',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入评价人ID!'},
          ];
     },
  },
  {
    label: '被评价人ID',
    field: 'targetUserId',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入被评价人ID!'},
          ];
     },
  },
  {
    label: '评分 1-5',
    field: 'rating',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入评分 1-5!'},
          ];
     },
  },
  {
    label: '评价内容',
    field: 'comment',
    component: 'InputTextArea',
  },
	// TODO 主键隐藏字段，目前写死为ID
	{
	  label: '',
	  field: 'id',
	  component: 'Input',
	  show: false
	},
];

// 高级查询数据
export const superQuerySchema = {
  tradeId: {title: '关联交易ID',order: 0,view: 'text', type: 'string',},
  reviewerId: {title: '评价人ID',order: 1,view: 'text', type: 'string',},
  targetUserId: {title: '被评价人ID',order: 2,view: 'text', type: 'string',},
  rating: {title: '评分 1-5',order: 3,view: 'number', type: 'number',},
  comment: {title: '评价内容',order: 4,view: 'textarea', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}