import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
  {
    title: '所属公司',
    align: "center",
    dataIndex: 'companyId'
  },
  {
    title: '所属事务所',
    align: "center",
    dataIndex: 'officeId'
  },
  {
    title: '事件标题',
    align: "center",
    dataIndex: 'title'
  },
  {
    title: '事件类型（访视/培训/检修等）',
    align: "center",
    dataIndex: 'eventType'
  },
  {
    title: '事件日期',
    align: "center",
    dataIndex: 'eventDate',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
  },
  {
    title: '描述',
    align: "center",
    dataIndex: 'description'
  },
];

// 高级查询数据
export const superQuerySchema = {
  companyId: {title: '所属公司',order: 0,view: 'text', type: 'string',},
  officeId: {title: '所属事务所',order: 1,view: 'text', type: 'string',},
  title: {title: '事件标题',order: 2,view: 'text', type: 'string',},
  eventType: {title: '事件类型（访视/培训/检修等）',order: 3,view: 'text', type: 'string',},
  eventDate: {title: '事件日期',order: 4,view: 'date', type: 'string',},
  description: {title: '描述',order: 5,view: 'textarea', type: 'string',},
};
