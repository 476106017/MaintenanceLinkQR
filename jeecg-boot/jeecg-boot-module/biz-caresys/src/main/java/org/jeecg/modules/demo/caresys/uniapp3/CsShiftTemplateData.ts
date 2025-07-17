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
    title: '班次模板名称',
    align:"center",
    dataIndex: 'templateName'
   },
   {
    title: '工作日设定（JSON）',
    align:"center",
    dataIndex: 'workingDays'
   },
   {
    title: '休息日设定（JSON）',
    align:"center",
    dataIndex: 'restDays'
   },
];