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
    title: '执行员工',
    align:"center",
    dataIndex: 'employeeId'
   },
   {
    title: '服务时间',
    align:"center",
    dataIndex: 'recordTime'
   },
   {
    title: '服务内容',
    align:"center",
    dataIndex: 'serviceContent'
   },
   {
    title: '备注',
    align:"center",
    dataIndex: 'note'
   },
];