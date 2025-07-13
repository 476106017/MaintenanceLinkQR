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
    title: '工资月份',
    align: "center",
    dataIndex: 'salaryMonth'
  },
  {
    title: '工时数',
    align: "center",
    dataIndex: 'workingHours'
  },
  {
    title: '基础工资',
    align: "center",
    dataIndex: 'baseSalary'
  },
  {
    title: '奖金',
    align: "center",
    dataIndex: 'bonus'
  },
];

// 高级查询数据
export const superQuerySchema = {
  companyId: {title: '所属公司',order: 0,view: 'text', type: 'string',},
  officeId: {title: '所属事务所',order: 1,view: 'text', type: 'string',},
  employeeId: {title: '员工ID',order: 2,view: 'text', type: 'string',},
  salaryMonth: {title: '工资月份',order: 3,view: 'text', type: 'string',},
  workingHours: {title: '工时数',order: 4,view: 'number', type: 'number',},
  baseSalary: {title: '基础工资',order: 5,view: 'number', type: 'number',},
  bonus: {title: '奖金',order: 6,view: 'number', type: 'number',},
};
