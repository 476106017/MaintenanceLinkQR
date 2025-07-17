import { render } from '@/common/renderUtils';
//列表数据
export const columns = [
    {
    title: '所属公司',
    align:"center",
    dataIndex: 'companyId'
   },
   {
    title: '所属事务所',
    align:"center",
    dataIndex: 'officeId'
   },
   {
    title: '关联老人',
    align:"center",
    dataIndex: 'residentId'
   },
   {
    title: '报告类型（跌倒等）',
    align:"center",
    dataIndex: 'reportType'
   },
   {
    title: '报告时间',
    align:"center",
    dataIndex: 'reportTime'
   },
   {
    title: '详情描述',
    align:"center",
    dataIndex: 'description'
   },
];