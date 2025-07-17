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
    title: '标题',
    align:"center",
    dataIndex: 'title'
   },
   {
    title: '内容',
    align:"center",
    dataIndex: 'content'
   },
   {
    title: '发布级别（system/company/office）',
    align:"center",
    dataIndex: 'level'
   },
   {
    title: '可见截止时间',
    align:"center",
    dataIndex: 'visibleUntil'
   },
];