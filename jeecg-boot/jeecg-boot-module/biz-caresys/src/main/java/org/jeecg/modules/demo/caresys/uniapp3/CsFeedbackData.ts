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
    title: '来源（家属/员工）',
    align:"center",
    dataIndex: 'source'
   },
   {
    title: '关联老人或员工',
    align:"center",
    dataIndex: 'targetId'
   },
   {
    title: '反馈内容',
    align:"center",
    dataIndex: 'content'
   },
   {
    title: '反馈时间',
    align:"center",
    dataIndex: 'feedbackTime'
   },
];