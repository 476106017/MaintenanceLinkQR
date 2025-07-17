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
    title: '关联老人',
    align: "center",
    dataIndex: 'residentId'
  },
  {
    title: '计划开始日期',
    align: "center",
    dataIndex: 'planDate',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
  },
  {
    title: '重复类型（日/周）',
    align: "center",
    dataIndex: 'repeatType'
  },
  {
    title: '服务内容（JSON）',
    align: "center",
    dataIndex: 'serviceItems'
  },
];

// 高级查询数据
export const superQuerySchema = {
  companyId: {title: '所属公司',order: 0,view: 'text', type: 'string',},
  officeId: {title: '所属事务所',order: 1,view: 'text', type: 'string',},
  residentId: {title: '关联老人',order: 2,view: 'text', type: 'string',},
  planDate: {title: '计划开始日期',order: 3,view: 'date', type: 'string',},
  repeatType: {title: '重复类型（日/周）',order: 4,view: 'text', type: 'string',},
  serviceItems: {title: '服务内容（JSON）',order: 5,view: 'textarea', type: 'string',},
};
