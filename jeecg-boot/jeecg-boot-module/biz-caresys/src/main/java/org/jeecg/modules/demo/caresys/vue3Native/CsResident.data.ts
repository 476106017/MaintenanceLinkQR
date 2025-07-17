import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
  {
    title: '编号',
    align: "center",
    dataIndex: 'residentCode'
  },
  {
    title: '姓名',
    align: "center",
    dataIndex: 'name'
  },
  {
    title: '姓名假名',
    align: "center",
    dataIndex: 'nameKana'
  },
  {
    title: '性别（M:男, F:女）',
    align: "center",
    dataIndex: 'gender'
  },
  {
    title: '出生日期',
    align: "center",
    dataIndex: 'birthDate',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
  },
  {
    title: '死亡日期',
    align: "center",
    dataIndex: 'deathDate',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
  },
  {
    title: '年龄（冗余字段）',
    align: "center",
    dataIndex: 'age'
  },
  {
    title: '联系电话',
    align: "center",
    dataIndex: 'phoneNumber'
  },
  {
    title: '居住地址',
    align: "center",
    dataIndex: 'address'
  },
  {
    title: '头像照片URL',
    align: "center",
    dataIndex: 'photoUrl'
  },
  {
    title: '监护人姓名',
    align: "center",
    dataIndex: 'guardianName'
  },
  {
    title: '与被照护者关系',
    align: "center",
    dataIndex: 'guardianRelationship'
  },
  {
    title: '监护人联系电话',
    align: "center",
    dataIndex: 'guardianPhone'
  },
  {
    title: '要介护等级',
    align: "center",
    dataIndex: 'careLevel'
  },
  {
    title: '介护认证编号',
    align: "center",
    dataIndex: 'careCertNumber'
  },
  {
    title: '开始照护日期',
    align: "center",
    dataIndex: 'careStartDate',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
  },
  {
    title: '居住类型（独居/与家人同住/机构等）',
    align: "center",
    dataIndex: 'residenceType'
  },
  {
    title: '是否有认知症',
    align: "center",
    dataIndex: 'isDementia'
  },
  {
    title: '疾病备注',
    align: "center",
    dataIndex: 'diseaseNotes'
  },
  {
    title: '过敏信息',
    align: "center",
    dataIndex: 'allergyNotes'
  },
  {
    title: '状态（active/disabled/deceased）',
    align: "center",
    dataIndex: 'status'
  },
  {
    title: '逻辑删除标识',
    align: "center",
    dataIndex: 'deleteFlag'
  },
];

// 高级查询数据
export const superQuerySchema = {
  residentCode: {title: '编号',order: 0,view: 'text', type: 'string',},
  name: {title: '姓名',order: 1,view: 'text', type: 'string',},
  nameKana: {title: '姓名假名',order: 2,view: 'text', type: 'string',},
  gender: {title: '性别（M:男, F:女）',order: 3,view: 'text', type: 'string',},
  birthDate: {title: '出生日期',order: 4,view: 'date', type: 'string',},
  deathDate: {title: '死亡日期',order: 5,view: 'date', type: 'string',},
  age: {title: '年龄（冗余字段）',order: 6,view: 'number', type: 'number',},
  phoneNumber: {title: '联系电话',order: 7,view: 'text', type: 'string',},
  address: {title: '居住地址',order: 8,view: 'textarea', type: 'string',},
  photoUrl: {title: '头像照片URL',order: 9,view: 'textarea', type: 'string',},
  guardianName: {title: '监护人姓名',order: 10,view: 'text', type: 'string',},
  guardianRelationship: {title: '与被照护者关系',order: 11,view: 'text', type: 'string',},
  guardianPhone: {title: '监护人联系电话',order: 12,view: 'text', type: 'string',},
  careLevel: {title: '要介护等级',order: 13,view: 'text', type: 'string',},
  careCertNumber: {title: '介护认证编号',order: 14,view: 'text', type: 'string',},
  careStartDate: {title: '开始照护日期',order: 15,view: 'date', type: 'string',},
  residenceType: {title: '居住类型（独居/与家人同住/机构等）',order: 16,view: 'text', type: 'string',},
  isDementia: {title: '是否有认知症',order: 17,view: 'number', type: 'number',},
  diseaseNotes: {title: '疾病备注',order: 18,view: 'textarea', type: 'string',},
  allergyNotes: {title: '过敏信息',order: 19,view: 'textarea', type: 'string',},
  status: {title: '状态（active/disabled/deceased）',order: 20,view: 'text', type: 'string',},
  deleteFlag: {title: '逻辑删除标识',order: 21,view: 'number', type: 'number',},
};
