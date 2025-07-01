import { render } from '@/common/renderUtils';
//列表数据
export const columns = [
    {
    title: '物主ID',
    align:"center",
    dataIndex: 'userId'
   },
   {
    title: '物品名称',
    align:"center",
    dataIndex: 'itemName'
   },
   {
    title: '物品描述',
    align:"center",
    dataIndex: 'itemDesc'
   },
   {
    title: '图片URL',
    align:"center",
    dataIndex: 'imageUrls'
   },
   {
    title: '状态',
    align:"center",
    dataIndex: 'status'
   },
   {
    title: '分类',
    align:"center",
    dataIndex: 'category'
   },
   {
    title: '物品所在地',
    align:"center",
    dataIndex: 'location'
   },
];