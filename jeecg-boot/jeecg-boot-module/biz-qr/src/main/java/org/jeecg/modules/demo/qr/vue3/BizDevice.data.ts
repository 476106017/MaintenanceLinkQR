import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '设备编号',
    align:"center",
    dataIndex: 'no'
   },
   {
    title: '设备名',
    align:"center",
    dataIndex: 'name'
   },
   {
    title: '生产批次',
    align:"center",
    dataIndex: 'productionBatch'
   },
   {
    title: '生产日期',
    align:"center",
    dataIndex: 'productionDate'
   },
   {
    title: '生产人员',
    align:"center",
    dataIndex: 'productionPerson'
   },
   {
    title: '设备照片',
    align:"center",
    dataIndex: 'picture',
    customRender:render.renderImage,
   },
   {
    title: '生产图纸',
    align:"center",
    dataIndex: 'drawingPdfUrl',
   },
   {
    title: '出货状态',
    align:"center",
    dataIndex: 'status_dictText'
   },
   {
    title: '出货日期',
    align:"center",
    dataIndex: 'shippedDate'
   },
   {
    title: '出货去向',
    align:"center",
    dataIndex: 'shippedTo'
   },
   {
    title: '创建时间',
    align:"center",
    dataIndex: 'createTime',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '更新时间',
    align:"center",
    dataIndex: 'updateTime',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
  {
    label: "设备编号",
    field: "no",
    component: 'JInput',
  },
	{
      label: "设备名",
      field: 'name',
      component: 'Input',
      //colProps: {span: 6},
 	},
  {
    label: "生产批次",
    field: "productionBatch",
    component: 'JInput',
  },
     {
      label: "生产日期",
      field: "productionDate",
      component: 'RangePicker',
      componentProps: {
          valueType: 'Date',
          showTime:true
      },
      //colProps: {span: 6},
	},
  {
    label: "生产人员",
    field: "productionPerson",
    component: 'JInput',
  },
	{
      label: "出货状态",
      field: 'status',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"qr-status"
      },
      //colProps: {span: 6},
 	},
     {
      label: "出货日期",
      field: "shippedDate",
      component: 'RangePicker',
      componentProps: {
          valueType: 'Date',
          showTime:true
      },
      //colProps: {span: 6},
	},
     {
      label: "创建时间",
      field: "createTime",
      component: 'RangePicker',
      componentProps: {
        valueType: 'Date',
      },
      //colProps: {span: 6},
	},
     {
      label: "更新时间",
      field: "updateTime",
      component: 'RangePicker',
      componentProps: {
        valueType: 'Date',
      },
      //colProps: {span: 6},
	},
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '设备编号',
    field: 'no',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入设备编号!'},
          ];
     },
  },
  {
    label: '设备名',
    field: 'name',
    component: 'Input',
  },
  {
    label: '生产批次',
    field: 'productionBatch',
    component: 'Input',
  },
  {
    label: '生产日期',
    field: 'productionDate',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '生产人员',
    field: 'productionPerson',
    component: 'Input',
  },
  {
    label: '设备照片',
    field: 'picture',
     component: 'JImageUpload',
     componentProps:{
        fileMax: 0
      },
  },
  {
    label: '生产图纸',
    field: 'drawingPdfUrl',
    component: 'JUpload',
    componentProps:{
     },
  },
  {
    label: '出货状态',
    field: 'status',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"qr-status"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入出货状态!'},
          ];
     },
  },
  {
    label: '出货日期',
    field: 'shippedDate',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '出货去向',
    field: 'shippedTo',
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
  no: {title: '设备编号',order: 0,view: 'text', type: 'string',},
  name: {title: '设备名',order: 1,view: 'text', type: 'string',},
  productionBatch: {title: '生产批次',order: 2,view: 'text', type: 'string',},
  productionDate: {title: '生产日期',order: 3,view: 'datetime', type: 'string',},
  productionPerson: {title: '生产人员',order: 4,view: 'text', type: 'string',},
  picture: {title: '设备照片',order: 5,view: 'image', type: 'string',},
  drawingPdfUrl: {title: '生产图纸',order: 6,view: 'file', type: 'string',},
  status: {title: '出货状态',order: 7,view: 'list', type: 'string',dictCode: 'qr-status',},
  shippedDate: {title: '出货日期',order: 8,view: 'datetime', type: 'string',},
  shippedTo: {title: '出货去向',order: 9,view: 'text', type: 'string',},
  createTime: {title: '创建时间',order: 10,view: 'date', type: 'string',},
  updateTime: {title: '更新时间',order: 11,view: 'date', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}