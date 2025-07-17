-- 注意：该页面对应的前台目录为views/caresys文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2025071309303540560', NULL, 'cs_feedback', '/caresys/csFeedbackList', 'caresys/CsFeedbackList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2025-07-13 21:30:56', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025071309303540561', '2025071309303540560', '添加cs_feedback', NULL, NULL, 0, NULL, NULL, 2, 'caresys:cs_feedback:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-07-13 21:30:56', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025071309303540562', '2025071309303540560', '编辑cs_feedback', NULL, NULL, 0, NULL, NULL, 2, 'caresys:cs_feedback:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-07-13 21:30:56', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025071309303540563', '2025071309303540560', '删除cs_feedback', NULL, NULL, 0, NULL, NULL, 2, 'caresys:cs_feedback:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-07-13 21:30:56', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025071309303540564', '2025071309303540560', '批量删除cs_feedback', NULL, NULL, 0, NULL, NULL, 2, 'caresys:cs_feedback:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-07-13 21:30:56', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025071309303540565', '2025071309303540560', '导出excel_cs_feedback', NULL, NULL, 0, NULL, NULL, 2, 'caresys:cs_feedback:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-07-13 21:30:56', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2025071309303540566', '2025071309303540560', '导入excel_cs_feedback', NULL, NULL, 0, NULL, NULL, 2, 'caresys:cs_feedback:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2025-07-13 21:30:56', NULL, NULL, 0, 0, '1', 0);