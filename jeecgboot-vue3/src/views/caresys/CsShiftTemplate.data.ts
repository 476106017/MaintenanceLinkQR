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
    title: '班次模板名称',
    align: "center",
    dataIndex: 'templateName'
  },
  {
    title: '工作日设定（JSON）',
    align: "center",
    dataIndex: 'workingDays'
  },
  {
    title: '休息日设定（JSON）',
    align: "center",
    dataIndex: 'restDays'
  },
];

// 高级查询数据
export const superQuerySchema = {
  companyId: {title: '所属公司',order: 0,view: 'text', type: 'string',},
  officeId: {title: '所属事务所',order: 1,view: 'text', type: 'string',},
  templateName: {title: '班次模板名称',order: 2,view: 'text', type: 'string',},
  workingDays: {title: '工作日设定（JSON）',order: 3,view: 'textarea', type: 'string',},
  restDays: {title: '休息日设定（JSON）',order: 4,view: 'textarea', type: 'string',},
};
