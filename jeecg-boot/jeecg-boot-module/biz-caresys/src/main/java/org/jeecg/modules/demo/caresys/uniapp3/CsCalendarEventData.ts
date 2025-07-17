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
    title: '事件标题',
    align:"center",
    dataIndex: 'title'
   },
   {
    title: '事件类型（访视/培训/检修等）',
    align:"center",
    dataIndex: 'eventType'
   },
   {
    title: '事件日期',
    align:"center",
    dataIndex: 'eventDate',
   },
   {
    title: '描述',
    align:"center",
    dataIndex: 'description'
   },
];