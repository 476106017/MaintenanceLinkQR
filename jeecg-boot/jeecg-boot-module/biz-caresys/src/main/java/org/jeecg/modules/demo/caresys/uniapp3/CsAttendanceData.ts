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
    title: '工作日期',
    align:"center",
    dataIndex: 'workDate',
   },
   {
    title: '打卡上班时间',
    align:"center",
    dataIndex: 'clockIn'
   },
   {
    title: '打卡下班时间',
    align:"center",
    dataIndex: 'clockOut'
   },
   {
    title: '是否迟到',
    align:"center",
    dataIndex: 'late'
   },
   {
    title: '是否早退',
    align:"center",
    dataIndex: 'earlyLeave'
   },
];