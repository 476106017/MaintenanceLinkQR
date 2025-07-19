-- 注意：该页面对应的前台目录为views/caresys文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值

INSERT INTO sys_permission(id, parent_id, name, url, component, component_name,redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external)
VALUES ('2025071309321000000', NULL, 'cs_service_calendar', '/caresys/csServiceCalendar', 'caresys/CsServiceCalendar', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-07-13 21:32:10', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025071309321000001', '2025071309321000000', '添加cs_service_calendar', NULL, NULL, 0, NULL, NULL, 2, 'caresys:cs_service_calendar:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-07-13 21:32:10', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025071309321000002', '2025071309321000000', '编辑cs_service_calendar', NULL, NULL, 0, NULL, NULL, 2, 'caresys:cs_service_calendar:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-07-13 21:32:10', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025071309321000003', '2025071309321000000', '删除cs_service_calendar', NULL, NULL, 0, NULL, NULL, 2, 'caresys:cs_service_calendar:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-07-13 21:32:10', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025071309321000004', '2025071309321000000', '批量删除cs_service_calendar', NULL, NULL, 0, NULL, NULL, 2, 'caresys:cs_service_calendar:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-07-13 21:32:10', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025071309321000005', '2025071309321000000', '导出excel_cs_service_calendar', NULL, NULL, 0, NULL, NULL, 2, 'caresys:cs_service_calendar:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-07-13 21:32:10', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025071309321000006', '2025071309321000000', '导入excel_cs_service_calendar', NULL, NULL, 0, NULL, NULL, 2, 'caresys:cs_service_calendar:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-07-13 21:32:10', NULL, NULL, 0, 0, '1', 0);
