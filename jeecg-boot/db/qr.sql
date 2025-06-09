-- 注意：该页面对应的前台目录为views/qr文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external)
VALUES ('2025060608578510110', NULL, '设备二维码管理', '/qr/bizDeviceList', 'qr/BizDeviceList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-06-06 08:57:11', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025060608578510111', '2025060608578510110', '添加设备二维码管理', NULL, NULL, 0, NULL, NULL, 2, 'qr:biz_device:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-06 08:57:11', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025060608578510112', '2025060608578510110', '编辑设备二维码管理', NULL, NULL, 0, NULL, NULL, 2, 'qr:biz_device:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-06 08:57:11', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025060608578510113', '2025060608578510110', '删除设备二维码管理', NULL, NULL, 0, NULL, NULL, 2, 'qr:biz_device:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-06 08:57:11', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025060608578510114', '2025060608578510110', '批量删除设备二维码管理', NULL, NULL, 0, NULL, NULL, 2, 'qr:biz_device:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-06 08:57:11', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025060608578510115', '2025060608578510110', '导出excel_设备二维码管理', NULL, NULL, 0, NULL, NULL, 2, 'qr:biz_device:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-06 08:57:11', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025060608578510116', '2025060608578510110', '导入excel_设备二维码管理', NULL, NULL, 0, NULL, NULL, 2, 'qr:biz_device:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-06-06 08:57:11', NULL, NULL, 0, 0, '1', 0);

CREATE TABLE `biz_device` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `device_no` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '设备编号（唯一）',
  `production_batch` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '生产批次',
  `production_date` datetime DEFAULT NULL COMMENT '生产日期',
  `production_person` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '生产人员姓名',
  `maintenance_tel` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '维保联系电话',
  `drawing_pdf_url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '生产图纸 PDF 存储路径',
  `status` varchar(3) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '出货状态',
  `shipped_date` datetime DEFAULT NULL COMMENT '出货日期',
  `shipped_to` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '出货去向',
  PRIMARY KEY (`id`),
  KEY `device_no_idx` (`device_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci