import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
  {
    title: '设备编号（唯一）',
    align: "center",
    dataIndex: 'deviceNo'
  },
  {
    title: '生产批次',
    align: "center",
    dataIndex: 'productionBatch'
  },
  {
    title: '生产日期',
    align: "center",
    dataIndex: 'productionDate'
  },
  {
    title: '生产人员姓名',
    align: "center",
    dataIndex: 'productionPerson'
  },
  {
    title: '维保联系电话',
    align: "center",
    dataIndex: 'maintenanceTel'
  },
  {
    title: '生产图纸 PDF 存储路径',
    align: "center",
    dataIndex: 'drawingPdfUrl',
    customRender: render.renderImage,
  },
  {
    title: '出货状态',
    align: "center",
    dataIndex: 'status_dictText'
  },
  {
    title: '出货日期',
    align: "center",
    dataIndex: 'shippedDate'
  },
  {
    title: '出货去向',
    align: "center",
    dataIndex: 'shippedTo'
  },
];

// 高级查询数据
export const superQuerySchema = {
  deviceNo: {title: '设备编号（唯一）',order: 0,view: 'text', type: 'string',},
  productionBatch: {title: '生产批次',order: 1,view: 'text', type: 'string',},
  productionDate: {title: '生产日期',order: 2,view: 'datetime', type: 'string',},
  productionPerson: {title: '生产人员姓名',order: 3,view: 'text', type: 'string',},
  maintenanceTel: {title: '维保联系电话',order: 4,view: 'text', type: 'string',},
  drawingPdfUrl: {title: '生产图纸 PDF 存储路径',order: 5,view: 'image', type: 'string',},
  status: {title: '出货状态',order: 6,view: 'list', type: 'string',dictCode: 'qr-status',},
  shippedDate: {title: '出货日期',order: 7,view: 'datetime', type: 'string',},
  shippedTo: {title: '出货去向',order: 8,view: 'text', type: 'string',},
};
