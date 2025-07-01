import { render } from '@/common/renderUtils';
//列表数据
export const columns = [
    {
    title: '发起人',
    align:"center",
    dataIndex: 'fromUserId'
   },
   {
    title: '响应人',
    align:"center",
    dataIndex: 'toUserId'
   },
   {
    title: '发起人提供物品',
    align:"center",
    dataIndex: 'fromItemId'
   },
   {
    title: '响应人提供物品',
    align:"center",
    dataIndex: 'toItemId'
   },
   {
    title: '状态',
    align:"center",
    dataIndex: 'status'
   },
   {
    title: '留言',
    align:"center",
    dataIndex: 'message'
   },
   {
    title: '达成交易时间',
    align:"center",
    dataIndex: 'dealTime'
   },
];