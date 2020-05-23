# 角色表
drop table `role`;
CREATE TABLE `role`
(
    `id`   int(20)      NOT NULL,
    `name` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

# 用户表
drop table `user`;
CREATE TABLE `user`
(
    `id`       int(20)      NOT NULL,
    `role_id`  int(20)      NOT NULL,
    `name`     varchar(255) NOT NULL,
    `password` varchar(255) NOT NULL,
    `phone`    varchar(20)  NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

# 账号表
drop table `account`;
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

# 客户表
drop table `customer`;
CREATE TABLE `customer`
(
    `id`      bigint(20)  NOT NULL,
    `name`    varchar(32) NOT NULL COMMENT '学生姓名',
    `contact` varchar(24) DEFAULT NULL COMMENT '联系方式',
    `status`  bit(1)      DEFAULT b'1' COMMENT '是否在校 0 不在 1 在',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT '客户表';

# 商品表
drop table `product`;
CREATE TABLE `product`
(
    `id`     bigint(20)  NOT NULL,
    `name`   varchar(64) NOT NULL COMMENT '课程名称',
    `price`  decimal(10, 2) DEFAULT NULL COMMENT '产品价格',
    `status` bit(1)         DEFAULT b'1' COMMENT '状态',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT '产品表';

# 销售单表
drop table `sales_slip`;
CREATE TABLE `sales_slip`
(
    `id`          bigint(20) NOT NULL,
    `code`        varchar(32) DEFAULT NULL COMMENT '单号',
    `user_id`     bigint(20) NOT NULL COMMENT '销售id',
    `customer_id` bigint(20) NOT NULL COMMENT '客户id',
    `create_time` datetime    DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
    `status`      bit(1)      DEFAULT b'1' COMMENT '有效性',
    PRIMARY KEY (`id`),
    KEY `idx_salesslip_userid` (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT '销售单表';

# 销售明细表
drop table `sales_slip_detail`;
CREATE TABLE `sales_slip_detail` (
  `id` bigint(20) NOT NULL,
  `sales_slip_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL COMMENT '产品id',
  `num` decimal(5,0) DEFAULT NULL COMMENT '产品数量',
  `price` decimal(10,2) DEFAULT NULL COMMENT '单价',
  `percentage` decimal(5,2) DEFAULT NULL COMMENT '提成比例',
  `commission` decimal(5,2) DEFAULT NULL COMMENT '佣金',
  `cutoff_time` date DEFAULT NULL COMMENT '结算时间',
  PRIMARY KEY (`id`),
  KEY `idx_salesslipdetail_salesslipid` (`sales_slip_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '销售明细单表';

CREATE TABLE `sys_config` (
  `id` bigint(20) NOT NULL,
  `code` varchar(32) DEFAULT NULL COMMENT '编码',
  `name` varchar(32) DEFAULT NULL COMMENT '名称',
  `value` varchar(32) DEFAULT NULL COMMENT '值',
  `desc` varchar(255) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

