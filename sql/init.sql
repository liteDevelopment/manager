CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  `code` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;