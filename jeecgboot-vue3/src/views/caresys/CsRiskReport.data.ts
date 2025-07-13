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
    title: '报告类型（跌倒等）',
    align: "center",
    dataIndex: 'reportType'
  },
  {
    title: '报告时间',
    align: "center",
    dataIndex: 'reportTime'
  },
  {
    title: '详情描述',
    align: "center",
    dataIndex: 'description'
  },
];

// 高级查询数据
export const superQuerySchema = {
  companyId: {title: '所属公司',order: 0,view: 'text', type: 'string',},
  officeId: {title: '所属事务所',order: 1,view: 'text', type: 'string',},
  residentId: {title: '关联老人',order: 2,view: 'text', type: 'string',},
  reportType: {title: '报告类型（跌倒等）',order: 3,view: 'text', type: 'string',},
  reportTime: {title: '报告时间',order: 4,view: 'datetime', type: 'string',},
  description: {title: '详情描述',order: 5,view: 'textarea', type: 'string',},
};
