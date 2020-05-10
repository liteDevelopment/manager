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

# 账号表
CREATE TABLE `account`
(
    `id`      int(20)     NOT NULL,
    `account` varchar(32) NOT NULL,
    `type`    int(11)     NOT NULL COMMENT '1-手机号',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

# 用户账号关联表
CREATE TABLE `user_account`
(
    `id`         int(20) NOT NULL,
    `user_id`    int(20) NOT NULL,
    `account_id` int(20) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY (`user_id`, `account_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;