import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '发起人',
    align:"center",
    dataIndex: 'fromUserId'
   },
   {
    title: '响应人',
    align:"center",
    dataIndex: 'toUserId'
   },
   {
    title: '发起人提供物品',
    align:"center",
    dataIndex: 'fromItemId'
   },
   {
    title: '响应人提供物品',
    align:"center",
    dataIndex: 'toItemId'
   },
   {
    title: '状态',
    align:"center",
    dataIndex: 'status'
   },
   {
    title: '留言',
    align:"center",
    dataIndex: 'message'
   },
   {
    title: '达成交易时间',
    align:"center",
    dataIndex: 'dealTime'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '发起人',
    field: 'fromUserId',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入发起人!'},
          ];
     },
  },
  {
    label: '响应人',
    field: 'toUserId',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入响应人!'},
          ];
     },
  },
  {
    label: '发起人提供物品',
    field: 'fromItemId',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入发起人提供物品!'},
          ];
     },
  },
  {
    label: '响应人提供物品',
    field: 'toItemId',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入响应人提供物品!'},
          ];
     },
  },
  {
    label: '状态',
    field: 'status',
    component: 'Input',
  },
  {
    label: '留言',
    field: 'message',
    component: 'InputTextArea',
  },
  {
    label: '达成交易时间',
    field: 'dealTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
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
  fromUserId: {title: '发起人',order: 0,view: 'text', type: 'string',},
  toUserId: {title: '响应人',order: 1,view: 'text', type: 'string',},
  fromItemId: {title: '发起人提供物品',order: 2,view: 'text', type: 'string',},
  toItemId: {title: '响应人提供物品',order: 3,view: 'text', type: 'string',},
  status: {title: '状态',order: 4,view: 'text', type: 'string',},
  message: {title: '留言',order: 5,view: 'textarea', type: 'string',},
  dealTime: {title: '达成交易时间',order: 6,view: 'datetime', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}