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
    title: '发布者（老人）',
    align:"center",
    dataIndex: 'residentId'
   },
   {
    title: '内容',
    align:"center",
    dataIndex: 'content'
   },
   {
    title: '图片列表(JSON)',
    align:"center",
    dataIndex: 'imageUrls'
   },
   {
    title: '发布时间',
    align:"center",
    dataIndex: 'postTime'
   },
];