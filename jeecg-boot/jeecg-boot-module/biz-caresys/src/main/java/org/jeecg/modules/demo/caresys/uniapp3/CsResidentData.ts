import { render } from '@/common/renderUtils';
//列表数据
export const columns = [
    {
    title: '编号',
    align:"center",
    dataIndex: 'residentCode'
   },
   {
    title: '姓名',
    align:"center",
    dataIndex: 'name'
   },
   {
    title: '姓名假名',
    align:"center",
    dataIndex: 'nameKana'
   },
   {
    title: '性别（M:男, F:女）',
    align:"center",
    dataIndex: 'gender'
   },
   {
    title: '出生日期',
    align:"center",
    dataIndex: 'birthDate',
   },
   {
    title: '死亡日期',
    align:"center",
    dataIndex: 'deathDate',
   },
   {
    title: '年龄（冗余字段）',
    align:"center",
    dataIndex: 'age'
   },
   {
    title: '联系电话',
    align:"center",
    dataIndex: 'phoneNumber'
   },
   {
    title: '居住地址',
    align:"center",
    dataIndex: 'address'
   },
   {
    title: '头像照片URL',
    align:"center",
    dataIndex: 'photoUrl'
   },
   {
    title: '监护人姓名',
    align:"center",
    dataIndex: 'guardianName'
   },
   {
    title: '与被照护者关系',
    align:"center",
    dataIndex: 'guardianRelationship'
   },
   {
    title: '监护人联系电话',
    align:"center",
    dataIndex: 'guardianPhone'
   },
   {
    title: '要介护等级',
    align:"center",
    dataIndex: 'careLevel'
   },
   {
    title: '介护认证编号',
    align:"center",
    dataIndex: 'careCertNumber'
   },
   {
    title: '开始照护日期',
    align:"center",
    dataIndex: 'careStartDate',
   },
   {
    title: '居住类型（独居/与家人同住/机构等）',
    align:"center",
    dataIndex: 'residenceType'
   },
   {
    title: '是否有认知症',
    align:"center",
    dataIndex: 'isDementia'
   },
   {
    title: '疾病备注',
    align:"center",
    dataIndex: 'diseaseNotes'
   },
   {
    title: '过敏信息',
    align:"center",
    dataIndex: 'allergyNotes'
   },
   {
    title: '状态（active/disabled/deceased）',
    align:"center",
    dataIndex: 'status'
   },
   {
    title: '逻辑删除标识',
    align:"center",
    dataIndex: 'deleteFlag'
   },
];