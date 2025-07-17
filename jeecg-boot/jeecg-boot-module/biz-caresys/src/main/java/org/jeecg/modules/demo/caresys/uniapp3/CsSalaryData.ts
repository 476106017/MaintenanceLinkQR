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
    title: '员工ID',
    align:"center",
    dataIndex: 'employeeId'
   },
   {
    title: '工资月份',
    align:"center",
    dataIndex: 'salaryMonth'
   },
   {
    title: '工时数',
    align:"center",
    dataIndex: 'workingHours'
   },
   {
    title: '基础工资',
    align:"center",
    dataIndex: 'baseSalary'
   },
   {
    title: '奖金',
    align:"center",
    dataIndex: 'bonus'
   },
];