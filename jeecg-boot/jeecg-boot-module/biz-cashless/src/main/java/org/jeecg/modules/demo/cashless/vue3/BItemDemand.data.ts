import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '需求发起人',
    align:"center",
    dataIndex: 'userId'
   },
   {
    title: '需求标题',
    align:"center",
    dataIndex: 'title'
   },
   {
    title: '详细描述',
    align:"center",
    dataIndex: 'description'
   },
   {
    title: '分类',
    align:"center",
    dataIndex: 'expectedCategory'
   },
   {
    title: '物品名称关键词',
    align:"center",
    dataIndex: 'expectedName'
   },
   {
    title: '状态',
    align:"center",
    dataIndex: 'status'
   },
   {
    title: '期望地区',
    align:"center",
    dataIndex: 'location'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '需求发起人',
    field: 'userId',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入需求发起人!'},
          ];
     },
  },
  {
    label: '需求标题',
    field: 'title',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入需求标题!'},
          ];
     },
  },
  {
    label: '详细描述',
    field: 'description',
    component: 'InputTextArea',
  },
  {
    label: '分类',
    field: 'expectedCategory',
    component: 'Input',
  },
  {
    label: '物品名称关键词',
    field: 'expectedName',
    component: 'Input',
  },
  {
    label: '状态',
    field: 'status',
    component: 'Input',
  },
  {
    label: '期望地区',
    field: 'location',
    component: 'Input',
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
  userId: {title: '需求发起人',order: 0,view: 'text', type: 'string',},
  title: {title: '需求标题',order: 1,view: 'text', type: 'string',},
  description: {title: '详细描述',order: 2,view: 'textarea', type: 'string',},
  expectedCategory: {title: '分类',order: 3,view: 'text', type: 'string',},
  expectedName: {title: '物品名称关键词',order: 4,view: 'text', type: 'string',},
  status: {title: '状态',order: 5,view: 'text', type: 'string',},
  location: {title: '期望地区',order: 6,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}