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
    title: '来源（家属/员工）',
    align: "center",
    dataIndex: 'source'
  },
  {
    title: '关联老人或员工',
    align: "center",
    dataIndex: 'targetId'
  },
  {
    title: '反馈内容',
    align: "center",
    dataIndex: 'content'
  },
  {
    title: '反馈时间',
    align: "center",
    dataIndex: 'feedbackTime'
  },
];

// 高级查询数据
export const superQuerySchema = {
  companyId: {title: '所属公司',order: 0,view: 'text', type: 'string',},
  officeId: {title: '所属事务所',order: 1,view: 'text', type: 'string',},
  source: {title: '来源（家属/员工）',order: 2,view: 'text', type: 'string',},
  targetId: {title: '关联老人或员工',order: 3,view: 'text', type: 'string',},
  content: {title: '反馈内容',order: 4,view: 'textarea', type: 'string',},
  feedbackTime: {title: '反馈时间',order: 5,view: 'datetime', type: 'string',},
};
