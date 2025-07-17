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
    title: '执行员工',
    align: "center",
    dataIndex: 'employeeId'
  },
  {
    title: '服务时间',
    align: "center",
    dataIndex: 'recordTime'
  },
  {
    title: '服务内容',
    align: "center",
    dataIndex: 'serviceContent'
  },
  {
    title: '备注',
    align: "center",
    dataIndex: 'note'
  },
];

// 高级查询数据
export const superQuerySchema = {
  companyId: {title: '所属公司',order: 0,view: 'text', type: 'string',},
  officeId: {title: '所属事务所',order: 1,view: 'text', type: 'string',},
  residentId: {title: '关联老人',order: 2,view: 'text', type: 'string',},
  employeeId: {title: '执行员工',order: 3,view: 'text', type: 'string',},
  recordTime: {title: '服务时间',order: 4,view: 'datetime', type: 'string',},
  serviceContent: {title: '服务内容',order: 5,view: 'textarea', type: 'string',},
  note: {title: '备注',order: 6,view: 'textarea', type: 'string',},
};
