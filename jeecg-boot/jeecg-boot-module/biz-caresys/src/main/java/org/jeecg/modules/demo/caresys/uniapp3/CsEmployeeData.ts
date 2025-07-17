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
    title: '系统用户ID（关联sys_user.id）',
    align:"center",
    dataIndex: 'userId'
   },
   {
    title: '员工编号',
    align:"center",
    dataIndex: 'employeeCode'
   },
   {
    title: '员工姓名',
    align:"center",
    dataIndex: 'name'
   },
   {
    title: '性别',
    align:"center",
    dataIndex: 'gender'
   },
   {
    title: '出生日期',
    align:"center",
    dataIndex: 'birthDate',
   },
   {
    title: '联系电话',
    align:"center",
    dataIndex: 'phoneNumber'
   },
   {
    title: '雇佣形态（全职/兼职等）',
    align:"center",
    dataIndex: 'employmentType'
   },
];