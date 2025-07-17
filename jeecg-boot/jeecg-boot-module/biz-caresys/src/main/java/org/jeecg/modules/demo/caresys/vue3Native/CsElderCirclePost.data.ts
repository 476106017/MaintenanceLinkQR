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
    title: '发布者（老人）',
    align: "center",
    dataIndex: 'residentId'
  },
  {
    title: '内容',
    align: "center",
    dataIndex: 'content'
  },
  {
    title: '图片列表(JSON)',
    align: "center",
    dataIndex: 'imageUrls'
  },
  {
    title: '发布时间',
    align: "center",
    dataIndex: 'postTime'
  },
];

// 高级查询数据
export const superQuerySchema = {
  companyId: {title: '所属公司',order: 0,view: 'text', type: 'string',},
  officeId: {title: '所属事务所',order: 1,view: 'text', type: 'string',},
  residentId: {title: '发布者（老人）',order: 2,view: 'text', type: 'string',},
  content: {title: '内容',order: 3,view: 'textarea', type: 'string',},
  imageUrls: {title: '图片列表(JSON)',order: 4,view: 'textarea', type: 'string',},
  postTime: {title: '发布时间',order: 5,view: 'datetime', type: 'string',},
};
