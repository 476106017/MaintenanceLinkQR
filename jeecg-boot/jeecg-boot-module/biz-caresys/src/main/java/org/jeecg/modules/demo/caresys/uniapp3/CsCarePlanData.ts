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
    title: '计划开始日期',
    align:"center",
    dataIndex: 'planDate',
   },
   {
    title: '重复类型（日/周）',
    align:"center",
    dataIndex: 'repeatType'
   },
   {
    title: '服务内容（JSON）',
    align:"center",
    dataIndex: 'serviceItems'
   },
];