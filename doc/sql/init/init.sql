# 用户表
CREATE TABLE `user`
(
    `id`       int(20)      NOT NULL,
    `name`     varchar(255) NOT NULL,
    `password` varchar(255) NOT NULL,
    `phone`    varchar(20)  NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

# 账号表
CREATE TABLE `account`
(
    `id`      int(20)     NOT NULL,
    `account` varchar(32) NOT NULL,
    `type`    tinyint(3)  NOT NULL COMMENT '1-手机号',
    `user_id` int(20)     NOT NULL DEFAULT 0,
    PRIMARY KEY (`id`),
    UNIQUE KEY uk_account (`account`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

# 角色表
CREATE TABLE `role`
(
    `id`   int(20)      NOT NULL,
    `name` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

# 用户角色绑定关系表
CREATE TABLE `user_role`
(
    `id`      int(20) NOT NULL,
    `user_id` int(20) NOT NULL,
    `role_id` int(20) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY (`user_id`, `role_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

## 新增用户/账号
INSERT INTO noah.user (id, name, password, phone) VALUES (1, 'admin', '$2a$10$PlfalHVD2vSeVTn9ou5QsOKyXGKJJTvNIIwuBuxN6CZKPcwedh5ly', '13010001000');
INSERT INTO noah.account (id, account, type, user_id) VALUES (1, '13010001000', 1, 1);