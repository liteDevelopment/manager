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

CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL,
  `name` varchar(32) NOT NULL COMMENT '学生姓名',
  `contact` varchar(24) DEFAULT NULL COMMENT '联系方式',
  `status` bit(1) DEFAULT NULL COMMENT '是否在校 0 不在 1 在',
  `product_id` bigint(20) DEFAULT NULL COMMENT '所选课程id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '客户表';

CREATE TABLE `product` (
  `id` bigint(20) NOT NULL,
  `name` varchar(64) NOT NULL COMMENT '课程名称',
  `price` decimal(10,2) DEFAULT NULL COMMENT '产品价格',
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '产品表';

CREATE TABLE `sales_slip` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL COMMENT '销售id',
  `customer_id` bigint(20) NOT NULL COMMENT '客户id',
  `status` bit(1) DEFAULT NULL COMMENT '有效性',
  PRIMARY KEY (`id`),
  KEY `idx_salesslip_userid` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '销售单表';

CREATE TABLE `sales_slip_detail` (
  `id` bigint(20) NOT NULL,
  `sales_slip_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL COMMENT '产品id',
  `num` decimal(5,0) DEFAULT NULL COMMENT '产品数量',
  `price` decimal(10,2) DEFAULT NULL COMMENT '单价',
  `percentage` decimal(5,2) DEFAULT NULL COMMENT '提成比例',
  `commission` decimal(5,2) DEFAULT NULL COMMENT '佣金',
  PRIMARY KEY (`id`),
  KEY `idx_salesslipdetail_salesslipid` (`sales_slip_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '销售明细单表';
