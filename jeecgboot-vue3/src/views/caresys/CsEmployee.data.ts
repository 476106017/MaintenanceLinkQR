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
    title: '系统用户ID（关联sys_user.id）',
    align: "center",
    dataIndex: 'userId'
  },
  {
    title: '员工编号',
    align: "center",
    dataIndex: 'employeeCode'
  },
  {
    title: '员工姓名',
    align: "center",
    dataIndex: 'name'
  },
  {
    title: '性别',
    align: "center",
    dataIndex: 'gender'
  },
  {
    title: '出生日期',
    align: "center",
    dataIndex: 'birthDate',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
  },
  {
    title: '联系电话',
    align: "center",
    dataIndex: 'phoneNumber'
  },
  {
    title: '雇佣形态（全职/兼职等）',
    align: "center",
    dataIndex: 'employmentType'
  },
];

// 高级查询数据
export const superQuerySchema = {
  companyId: {title: '所属公司',order: 0,view: 'text', type: 'string',},
  officeId: {title: '所属事务所',order: 1,view: 'text', type: 'string',},
  userId: {title: '系统用户ID（关联sys_user.id）',order: 2,view: 'text', type: 'string',},
  employeeCode: {title: '员工编号',order: 3,view: 'text', type: 'string',},
  name: {title: '员工姓名',order: 4,view: 'text', type: 'string',},
  gender: {title: '性别',order: 5,view: 'text', type: 'string',},
  birthDate: {title: '出生日期',order: 6,view: 'date', type: 'string',},
  phoneNumber: {title: '联系电话',order: 7,view: 'text', type: 'string',},
  employmentType: {title: '雇佣形态（全职/兼职等）',order: 8,view: 'text', type: 'string',},
};
