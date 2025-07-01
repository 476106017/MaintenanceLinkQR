import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '物主ID',
    align:"center",
    dataIndex: 'userId'
   },
   {
    title: '物品名称',
    align:"center",
    dataIndex: 'itemName'
   },
   {
    title: '物品描述',
    align:"center",
    dataIndex: 'itemDesc'
   },
   {
    title: '图片URL',
    align:"center",
    dataIndex: 'imageUrls'
   },
   {
    title: '状态',
    align:"center",
    dataIndex: 'status'
   },
   {
    title: '分类',
    align:"center",
    dataIndex: 'category'
   },
   {
    title: '物品所在地',
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
    label: '物主ID',
    field: 'userId',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入物主ID!'},
          ];
     },
  },
  {
    label: '物品名称',
    field: 'itemName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入物品名称!'},
          ];
     },
  },
  {
    label: '物品描述',
    field: 'itemDesc',
    component: 'InputTextArea',
  },
  {
    label: '图片URL',
    field: 'imageUrls',
    component: 'InputTextArea',
  },
  {
    label: '状态',
    field: 'status',
    component: 'Input',
  },
  {
    label: '分类',
    field: 'category',
    component: 'Input',
  },
  {
    label: '物品所在地',
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
  userId: {title: '物主ID',order: 0,view: 'text', type: 'string',},
  itemName: {title: '物品名称',order: 1,view: 'text', type: 'string',},
  itemDesc: {title: '物品描述',order: 2,view: 'textarea', type: 'string',},
  imageUrls: {title: '图片URL',order: 3,view: 'textarea', type: 'string',},
  status: {title: '状态',order: 4,view: 'text', type: 'string',},
  category: {title: '分类',order: 5,view: 'text', type: 'string',},
  location: {title: '物品所在地',order: 6,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}