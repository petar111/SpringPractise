

DROP TABLE IF EXISTS `creature`;

CREATE TABLE `creature` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `locked` tinyint(4) NOT NULL,
  `premium` tinyint(4) NOT NULL,
  `price` double NOT NULL,
  `date_pushed_in_realm` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
);
