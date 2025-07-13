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
    title: '员工ID',
    align: "center",
    dataIndex: 'employeeId'
  },
  {
    title: '工作日期',
    align: "center",
    dataIndex: 'workDate',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
  },
  {
    title: '打卡上班时间',
    align: "center",
    dataIndex: 'clockIn'
  },
  {
    title: '打卡下班时间',
    align: "center",
    dataIndex: 'clockOut'
  },
  {
    title: '是否迟到',
    align: "center",
    dataIndex: 'late'
  },
  {
    title: '是否早退',
    align: "center",
    dataIndex: 'earlyLeave'
  },
];

// 高级查询数据
export const superQuerySchema = {
  companyId: {title: '所属公司',order: 0,view: 'text', type: 'string',},
  officeId: {title: '所属事务所',order: 1,view: 'text', type: 'string',},
  employeeId: {title: '员工ID',order: 2,view: 'text', type: 'string',},
  workDate: {title: '工作日期',order: 3,view: 'date', type: 'string',},
  clockIn: {title: '打卡上班时间',order: 4,view: 'datetime', type: 'string',},
  clockOut: {title: '打卡下班时间',order: 5,view: 'datetime', type: 'string',},
  late: {title: '是否迟到',order: 6,view: 'number', type: 'number',},
  earlyLeave: {title: '是否早退',order: 7,view: 'number', type: 'number',},
};
