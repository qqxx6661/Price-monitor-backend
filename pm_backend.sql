/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : pm_backend

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2019-01-21 15:06:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for pm_auth
-- ----------------------------
DROP TABLE IF EXISTS `pm_auth`;
CREATE TABLE `pm_auth` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(255) NOT NULL,
  `app_type` varchar(10) DEFAULT NULL,
  `app_user_id` varchar(255) DEFAULT NULL,
  `access_token` varchar(255) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for pm_class
-- ----------------------------
DROP TABLE IF EXISTS `pm_class`;
CREATE TABLE `pm_class` (
  `class_id` int(11) NOT NULL,
  `class_name` varchar(255) NOT NULL,
  `class_category` varchar(255) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for pm_class_top
-- ----------------------------
DROP TABLE IF EXISTS `pm_class_top`;
CREATE TABLE `pm_class_top` (
  `class_top_id` int(11) NOT NULL,
  `class_top_name` varchar(255) NOT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for pm_constant
-- ----------------------------
DROP TABLE IF EXISTS `pm_constant`;
CREATE TABLE `pm_constant` (
  `type` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for pm_jd_item
-- ----------------------------
DROP TABLE IF EXISTS `pm_jd_item`;
CREATE TABLE `pm_jd_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` bigint(20) NOT NULL,
  `category_id` bigint(20) NOT NULL,
  `name` varchar(256) DEFAULT NULL,
  `subtitle` varchar(512) DEFAULT NULL,
  `price` varchar(32) DEFAULT NULL,
  `plus_price` varchar(32) DEFAULT NULL,
  `max_price` varchar(32) DEFAULT NULL,
  `min_price` varchar(32) DEFAULT NULL,
  `discount` varchar(32) DEFAULT NULL,
  `last_price` varchar(32) DEFAULT NULL,
  `note` varchar(128) DEFAULT NULL COMMENT '????????????????????????',
  `sale` varchar(128) DEFAULT NULL,
  `label` varchar(128) DEFAULT NULL,
  `store_name` varchar(128) DEFAULT NULL,
  `is_ziying` tinyint(1) NOT NULL COMMENT '????????????',
  `is_alert` tinyint(1) NOT NULL COMMENT '??????????????????',
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_item_id` (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for pm_jd_item_history
-- ----------------------------
DROP TABLE IF EXISTS `pm_jd_item_history`;
CREATE TABLE `pm_jd_item_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` bigint(20) NOT NULL,
  `price` varchar(32) DEFAULT NULL,
  `last_price` varchar(32) DEFAULT NULL,
  `note` varchar(128) DEFAULT NULL COMMENT '????????????????????????',
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for pm_monitor_class
-- ----------------------------
DROP TABLE IF EXISTS `pm_monitor_class`;
CREATE TABLE `pm_monitor_class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL,
  `expected_discount` varchar(20) NOT NULL DEFAULT '0.7',
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for pm_monitor_item
-- ----------------------------
DROP TABLE IF EXISTS `pm_monitor_item`;
CREATE TABLE `pm_monitor_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `user_price` varchar(10) NOT NULL,
  `item_id` bigint(20) NOT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  `name` varchar(256) DEFAULT NULL,
  `subtitle` varchar(512) DEFAULT NULL,
  `price` varchar(32) DEFAULT NULL,
  `plus_price` varchar(32) DEFAULT NULL,
  `max_price` varchar(32) DEFAULT NULL,
  `min_price` varchar(32) DEFAULT NULL,
  `discount` varchar(32) DEFAULT NULL,
  `last_price` varchar(32) DEFAULT NULL,
  `note` varchar(128) DEFAULT NULL COMMENT '????????????????????????',
  `sale` varchar(128) DEFAULT NULL,
  `label` varchar(128) DEFAULT NULL,
  `store_name` varchar(128) DEFAULT NULL,
  `is_ziying` tinyint(1) DEFAULT NULL COMMENT '????????????',
  `is_alert` tinyint(1) NOT NULL COMMENT '??????????????????',
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for pm_user
-- ----------------------------
DROP TABLE IF EXISTS `pm_user`;
CREATE TABLE `pm_user` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `name` varchar(40) DEFAULT NULL,
   `email` varchar(40) NOT NULL,
   `phone` varchar(20) DEFAULT NULL,
   `password` varchar(255) NOT NULL,
   `is_active` tinyint(1) NOT NULL COMMENT '??????????????????',
   `is_superuser` tinyint(1) NOT NULL COMMENT '???????????????',
   `is_olduser` tinyint(1) DEFAULT '0',
   `gmt_create` datetime DEFAULT NULL,
   `gmt_modified` datetime DEFAULT NULL,
   `serverjiang_key` varchar(255) NOT NULL DEFAULT '' COMMENT 'server???Key',
   PRIMARY KEY (`id`),
   UNIQUE KEY `uk_email` (`email`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for pm_validate
-- ----------------------------
DROP TABLE IF EXISTS `pm_validate`;
CREATE TABLE `pm_validate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `email` varchar(40) NOT NULL,
  `reset_token` varchar(40) NOT NULL,
  `type` varchar(20) NOT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for pm_user_membership
-- ----------------------------

DROP TABLE IF EXISTS `pm_user_membership`;
CREATE TABLE `pm_user_membership` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '??????id',
  `user_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '??????id',
  `member_name` varchar(20) NOT NULL COMMENT '????????????',
  `monitor_coin` int(20) unsigned NOT NULL DEFAULT '0' COMMENT '?????????????????????',
  `is_valid` tinyint(3) NOT NULL COMMENT '1-??????, 0-?????????????????????',
  `note` varchar(20) NOT NULL COMMENT '??????',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '????????????',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '????????????',
  PRIMARY KEY (`id`),
  KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='????????????';

-- ----------------------------
-- Table structure for pm_pay_record
-- ----------------------------

DROP TABLE IF EXISTS `pm_pay_record`;
CREATE TABLE `pm_pay_record` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '??????id',
  `user_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '??????id',
  `price` int(11) unsigned NOT NULL COMMENT '?????????????????????10???=1000???',
  `monitor_coin` int(20) unsigned NOT NULL DEFAULT '0' COMMENT '?????????????????????',
  `is_valid` tinyint(3) NOT NULL COMMENT '1-??????, 0-??????',
  `pay_source` varchar(20) NOT NULL COMMENT '????????????',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '????????????',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '????????????',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='????????????';

-- ----------------------------
-- Table structure for pm_mail_record
-- ----------------------------

DROP TABLE IF EXISTS `pm_mail_record`;
CREATE TABLE `pm_mail_record` (
 `id` int(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '??????id',
 `address` varchar(64) NOT NULL COMMENT '????????????',
 `from` varchar(64) NOT NULL COMMENT '???????????????',
 `to` varchar(64) NOT NULL COMMENT '???????????????',
 `subject` varchar(64) NOT NULL COMMENT '??????',
 `content` varchar(16384) NOT NULL COMMENT '??????',
 `is_sent` tinyint(3) NOT NULL COMMENT '1-????????????, 0-????????????',
 `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '????????????',
 `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '????????????',
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='??????????????????';

-- ----------------------------
-- Table structure for pm_monitor_jd_item_vip
-- ----------------------------
DROP TABLE IF EXISTS `pm_monitor_jd_item_vip`;
CREATE TABLE `pm_monitor_jd_item_vip` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) unsigned NOT NULL COMMENT '??????id',
  `user_price` varchar(10) NOT NULL COMMENT '??????????????????',
  `item_id` bigint(20) NOT NULL COMMENT '??????Id',
  `category_id` bigint(20) DEFAULT NULL COMMENT '??????Id',
  `name` varchar(256) NOT NULL DEFAULT '' COMMENT '????????????',
  `subtitle` varchar(512) NOT NULL DEFAULT '' COMMENT 'subtitle',
  `price` varchar(32) NOT NULL DEFAULT '' COMMENT 'price',
  `plus_price` varchar(32) NOT NULL DEFAULT '' COMMENT 'plus_price',
  `max_price` varchar(32) NOT NULL DEFAULT '' COMMENT 'max_price',
  `min_price` varchar(32) NOT NULL DEFAULT '' COMMENT 'min_price',
  `discount` varchar(32) NOT NULL DEFAULT '' COMMENT 'discount',
  `last_price` varchar(32) NOT NULL DEFAULT '' COMMENT 'last_price',
  `note` varchar(128) NOT NULL DEFAULT '' COMMENT 'note',
  `sale` varchar(128) NOT NULL DEFAULT '' COMMENT 'sale',
  `label` varchar(128) NOT NULL DEFAULT '' COMMENT 'label',
  `store_name` varchar(128) NOT NULL DEFAULT '' COMMENT 'store_name',
  `is_ziying` tinyint(1) NOT NULL DEFAULT 0 COMMENT '????????????',
  `is_alert` tinyint(1) NOT NULL DEFAULT 0 COMMENT '??????????????????',
  `monitor_coin_count` int(11) unsigned NOT NULL COMMENT '????????????????????????',
  `monitor_type` tinyint(3) NOT NULL COMMENT '1-5????????????, 2-15????????????, 3-30????????????, 4-1???????????????5-3????????????',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '????????????',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '????????????',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;