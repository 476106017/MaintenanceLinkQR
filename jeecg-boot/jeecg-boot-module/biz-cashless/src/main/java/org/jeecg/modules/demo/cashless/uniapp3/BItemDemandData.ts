import { render } from '@/common/renderUtils';
//列表数据
export const columns = [
    {
    title: '需求发起人',
    align:"center",
    dataIndex: 'userId'
   },
   {
    title: '需求标题',
    align:"center",
    dataIndex: 'title'
   },
   {
    title: '详细描述',
    align:"center",
    dataIndex: 'description'
   },
   {
    title: '分类',
    align:"center",
    dataIndex: 'expectedCategory'
   },
   {
    title: '物品名称关键词',
    align:"center",
    dataIndex: 'expectedName'
   },
   {
    title: '状态',
    align:"center",
    dataIndex: 'status'
   },
   {
    title: '期望地区',
    align:"center",
    dataIndex: 'location'
   },
];