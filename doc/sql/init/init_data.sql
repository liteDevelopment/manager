-- 初始化角色
INSERT INTO role (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO role (id, name) VALUES (2, 'ROLE_SALES');


-- 新增用户/账号
INSERT INTO user (id, role_id, name, password, phone)
VALUES (1, 1, 'admin', '$2a$10$PlfalHVD2vSeVTn9ou5QsOKyXGKJJTvNIIwuBuxN6CZKPcwedh5ly', '13010001000');
INSERT INTO account (id, account, type, user_id)
VALUES (1, '13010001000', 1, 1);

INSERT INTO user (id, role_id, name, password, phone)
VALUES (2, 2, 'sales_test', '$2a$10$PlfalHVD2vSeVTn9ou5QsOKyXGKJJTvNIIwuBuxN6CZKPcwedh5ly', '13020002000');
INSERT INTO account (id, account, type, user_id)
VALUES (2, '13020002000', 1, 2);

INSERT INTO sys_config (`id`, `code`, `name`, `value`, `desc`)
VALUES (1, 'percentage', '提成比例', '0.17', '公共销售提成比例');