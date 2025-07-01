import { render } from '@/common/renderUtils';
//列表数据
export const columns = [
    {
    title: '关联交易ID',
    align:"center",
    dataIndex: 'tradeId'
   },
   {
    title: '评价人ID',
    align:"center",
    dataIndex: 'reviewerId'
   },
   {
    title: '被评价人ID',
    align:"center",
    dataIndex: 'targetUserId'
   },
   {
    title: '评分 1-5',
    align:"center",
    dataIndex: 'rating'
   },
   {
    title: '评价内容',
    align:"center",
    dataIndex: 'comment'
   },
];