/*
Navicat MySQL Data Transfer

Source Server         : rds
Source Server Version : 50715
Source Host           : rm-2zexc221rpq83tolxo.mysql.rds.aliyuncs.com:3306
Source Database       : invoicing

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2018-06-13 15:14:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `accounting_subject`
-- ----------------------------
DROP TABLE IF EXISTS `accounting_subject`;
CREATE TABLE `accounting_subject` (
  `id` varchar(36) NOT NULL,
  `client_id` varchar(128) DEFAULT NULL,
  `create_user_id` varchar(36) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `logically_deleted` bit(1) DEFAULT NULL,
  `sort_number` int(11) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `ending_balance` double DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `opening_balance` double DEFAULT NULL,
  `pinyin` varchar(20) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `shortname` varchar(20) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of accounting_subject
-- ----------------------------
INSERT INTO `accounting_subject` VALUES ('40288383623303a601623309a7ab0000', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-03-17 16:18:14', '', '0', '2018-03-17 17:09:54', '101', '-200', '现金', '0', 'xj', null, '现金', 'CASH_BANK');
INSERT INTO `accounting_subject` VALUES ('4028838362333dc6016233422ab10000', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-03-17 17:19:57', '', '0', '2018-03-17 17:19:57', '0150', '0', '财付通账户', '0', 'cftzh', null, '财付通账户', 'CASH_BANK');
INSERT INTO `accounting_subject` VALUES ('4028838362333dc60162334609ad0001', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-03-17 17:24:11', '', '0', '2018-03-17 17:24:11', '001', '0', '积分消费', '0', 'jfxf', null, '积分消费', 'EXPENDITURE');
INSERT INTO `accounting_subject` VALUES ('4028838362333dc6016233463ce10002', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-03-17 17:24:24', '', '0', '2018-03-17 17:24:31', '002', '0', '其他费用', '0', 'qtfy', null, '其他费用', 'EXPENDITURE');
INSERT INTO `accounting_subject` VALUES ('4028838362333dc601623346ed5e0003', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-03-17 17:25:09', '', '0', '2018-03-17 17:25:17', '003', '0', '积分换商品', '0', 'jfhsp', null, '积分换商品', 'EXPENDITURE');
INSERT INTO `accounting_subject` VALUES ('40288383623368d30162336a57690000', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-03-17 18:03:50', '', '0', '2018-03-17 18:03:50', '004', '0', '调账亏损', '0', 'tzks', null, '调账亏损', 'EXPENDITURE');
INSERT INTO `accounting_subject` VALUES ('40288383623368d30162336ad3b60001', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-03-17 18:04:22', '', '0', '2018-03-17 18:04:22', '005', '0', '固定资产折旧', '0', 'gdzczj', null, '固定资产折旧', 'EXPENDITURE');
INSERT INTO `accounting_subject` VALUES ('40288383623368d30162336b050e0002', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-03-17 18:04:34', '', '0', '2018-03-17 18:04:34', '006', '0', '优惠', '0', 'yh', null, '优惠', 'EXPENDITURE');
INSERT INTO `accounting_subject` VALUES ('40288383623368d30162336b28400003', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-03-17 18:04:43', '', '0', '2018-03-17 18:04:43', '007', '0', '运费', '0', 'yf', null, '运费', 'EXPENDITURE');
INSERT INTO `accounting_subject` VALUES ('40288383623368d30162336b4bb70004', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-03-17 18:04:53', '', '0', '2018-03-17 18:04:53', '008', '0', '网店商城扣费', '0', 'wdsckf', null, '网店商城扣费', 'EXPENDITURE');
INSERT INTO `accounting_subject` VALUES ('40288383623368d30162336b6b530005', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-03-17 18:05:01', '', '0', '2018-03-17 18:05:01', '009', '0', '积分转储值', '0', 'jfzcz', null, '积分转储值', 'EXPENDITURE');
INSERT INTO `accounting_subject` VALUES ('40288383623368d30162336b92c00006', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-03-17 18:05:11', '', '0', '2018-03-17 18:05:11', '010', '0', '赔付', '0', 'pf', null, '赔付', 'EXPENDITURE');
INSERT INTO `accounting_subject` VALUES ('40288383623368d30162336bc7fc0007', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-03-17 18:05:24', '', '0', '2018-03-17 18:05:24', '011', '0', '部门管理费用', '0', 'bmglfy', null, '部门管理费用', 'EXPENDITURE');

-- ----------------------------
-- Table structure for `address`
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` varchar(36) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `logically_deleted` bit(1) DEFAULT NULL,
  `sort_number` int(11) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `level` varchar(50) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `parent_id` varchar(36) DEFAULT NULL,
  `client_id` varchar(128) DEFAULT NULL,
  `create_user_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtms9onytw1xuqqukihkuqkhk5` (`parent_id`),
  CONSTRAINT `FKtms9onytw1xuqqukihkuqkhk5` FOREIGN KEY (`parent_id`) REFERENCES `address` (`id`),
  CONSTRAINT `address_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `address` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('402881d15f6b15f0015f6b174bec0000', '0000-00-00 00:00:00', '', '0', '0000-00-00 00:00:00', null, '辽宁省', null, 'tonr', null);
INSERT INTO `address` VALUES ('402881d15f6b15f0015f6b17cf650001', '0000-00-00 00:00:00', '', '0', '0000-00-00 00:00:00', null, '营口市', '402881d15f6b15f0015f6b174bec0000', 'tonr', null);
INSERT INTO `address` VALUES ('402881d15f6b15f0015f6b17f4ec0002', '0000-00-00 00:00:00', '', '0', '0000-00-00 00:00:00', null, '鲅鱼圈区', '402881d15f6b15f0015f6b17cf650001', 'tonr', null);
INSERT INTO `address` VALUES ('402881d15f6b15f0015f6b18d5440003', '0000-00-00 00:00:00', '', '0', '0000-00-00 00:00:00', null, '丹东市', '402881d15f6b15f0015f6b174bec0000', 'tonr', null);
INSERT INTO `address` VALUES ('402881d15f6b15f0015f6b18ec230004', '0000-00-00 00:00:00', '', '0', '0000-00-00 00:00:00', null, '元宝区', '402881d15f6b15f0015f6b18d5440003', 'tonr', null);

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` varchar(36) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `logically_deleted` bit(1) DEFAULT NULL,
  `sort_number` int(11) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `login_name` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_type` varchar(255) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `client_id` varchar(128) DEFAULT NULL,
  `create_user_id` varchar(36) DEFAULT NULL,
  `avatar` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('402881bf628440b60162845478a40003', '2018-04-02 11:09:11', '', '0', '2018-04-02 11:09:11', 'test', null, '$2a$10$S/5D8HNDm1e4EweHFpptSeRnjLrbS4RSRpFC2UiEINVEaXp/V.yT6', 'ADMIN', '测试', 'tonr', '402881c45eff19a4015eff80ec080002', '/logo.svg');
INSERT INTO `admin` VALUES ('402881bf628440b6016284564f230004', '2018-04-02 11:11:12', '', '0', '2018-04-02 11:11:12', '11', null, '$2a$10$LdnTOtR8/2FfaAa1j41GJe7KApb.muEqSUCFDZAfeZBIrXAos5hGS', 'ADMIN', '1', 'tonr', '402881c45eff19a4015eff80ec080002', '/logo.svg');
INSERT INTO `admin` VALUES ('402881c45eff19a4015eff80ec080002', null, '', '0', null, 'admin', null, '$2a$10$iVCowG5hxgiIIsVDDGXaDOCs9n0WIwQy6Os1to2BJh1zObvEDIyMS', 'ADMIN', '超级管理员', 'tonr', null, '/logo.svg');

-- ----------------------------
-- Table structure for `admin_roles`
-- ----------------------------
DROP TABLE IF EXISTS `admin_roles`;
CREATE TABLE `admin_roles` (
  `admin_id` varchar(36) NOT NULL,
  `role_id` varchar(36) NOT NULL,
  KEY `FKcjlqrvoka3pq87dm3nhyx6h5c` (`role_id`),
  KEY `FK1bcjwl07gm1kcu8h3dhiyd3ol` (`admin_id`),
  CONSTRAINT `FK1bcjwl07gm1kcu8h3dhiyd3ol` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`id`),
  CONSTRAINT `FKcjlqrvoka3pq87dm3nhyx6h5c` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `admin_roles_ibfk_1` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`id`),
  CONSTRAINT `admin_roles_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of admin_roles
-- ----------------------------
INSERT INTO `admin_roles` VALUES ('402881c45eff19a4015eff80ec080002', '402881c45effd975015effdcc87d0000');
INSERT INTO `admin_roles` VALUES ('402881bf628440b60162845478a40003', '402881c45effd975015effdcc87d0000');
INSERT INTO `admin_roles` VALUES ('402881bf628440b6016284564f230004', '402881c45effd975015effdcc87d0000');

-- ----------------------------
-- Table structure for `attachment`
-- ----------------------------
DROP TABLE IF EXISTS `attachment`;
CREATE TABLE `attachment` (
  `id` varchar(36) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `logically_deleted` bit(1) DEFAULT NULL,
  `sort_number` int(11) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `format` varchar(50) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `path` varchar(500) DEFAULT NULL,
  `size` bigint(20) DEFAULT NULL,
  `client_id` varchar(128) DEFAULT NULL,
  `create_user_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of attachment
-- ----------------------------
INSERT INTO `attachment` VALUES ('402881b56371f870016371fd9f810000', '2018-05-18 14:43:57', '', '0', '2018-05-18 14:43:57', 'jpg', 'xiaohou.jpg', '/nfs-client//framework/admin/2018-05-18/1526625836905.jpg', '311611', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `attachment` VALUES ('402881b56371f870016371ffbc020001', '2018-05-18 14:46:15', '', '0', '2018-05-18 14:46:15', 'jpg', 'xiaohou.jpg', '/nfs-client//framework/admin/2018-05-18/1526625975294.jpg', '311611', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `attachment` VALUES ('402881b5637216a801637219f6e00000', '2018-05-18 15:14:54', '', '0', '2018-05-18 15:14:54', 'jpg', '1522044544412.jpg', '/nfs-client//framework/admin/2018-05-18/1526627694282.jpg', '42419', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `attachment` VALUES ('402881b5637216a80163721c98d80001', '2018-05-18 15:17:47', '', '0', '2018-05-18 15:17:47', 'jpg', '1522044813540.jpg', '/nfs-client//framework/admin/2018-05-18/1526627866834.jpg', '50404', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `attachment` VALUES ('402881b5637216a801637221b0b80002', '2018-05-18 15:23:21', '', '0', '2018-05-18 15:23:21', 'png', '1522032087881.png', '/nfs-client//framework/admin/2018-05-18/1526628200629.png', '25670', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `attachment` VALUES ('402881b5637216a80163722577c90003', '2018-05-18 15:27:28', '', '0', '2018-05-18 15:27:28', 'png', '1522032087881.png', '/nfs-client//framework/admin/2018-05-18/1526628448198.png', '25670', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `attachment` VALUES ('402881bf6260271e0162602e935a000d', '2018-03-26 10:41:28', '', '0', '2018-03-26 10:41:28', 'png', '15506891419230378_pic1.png', '/nfs-client//framework/anonymous/2018-03-26/1522032087881.png', '25670', null, null);
INSERT INTO `attachment` VALUES ('402881bf6260cad5016260e8e8e10000', '2018-03-26 14:04:59', '', '0', '2018-03-26 14:04:59', 'png', '不一样.png', '/nfs-client//framework/anonymous/2018-03-26/1522044299478.png', '482314', null, null);
INSERT INTO `attachment` VALUES ('402881bf6260cad5016260eca5a10001', '2018-03-26 14:09:04', '', '0', '2018-03-26 14:09:04', 'jpg', 'TB2GIGRXo_FK1Jjy0FnXXbXfXXa_!!1862446581.jpg_430x430q90.jpg', '/nfs-client//framework/anonymous/2018-03-26/1522044544412.jpg', '42419', null, null);
INSERT INTO `attachment` VALUES ('402881bf6260cad5016260ed488d0002', '2018-03-26 14:09:46', '', '0', '2018-03-26 14:09:46', 'jpg', 'TB2dLePXf_HK1JjSszgXXazDFXa_!!1862446581.jpg_430x430q90.jpg', '/nfs-client//framework/anonymous/2018-03-26/1522044586121.jpg', '50404', null, null);
INSERT INTO `attachment` VALUES ('402881bf6260cad5016260ed730e0003', '2018-03-26 14:09:57', '', '0', '2018-03-26 14:09:57', 'jpg', 'TB2p7KQXgvGK1Jjy0FfXXbykpXa_!!1862446581.jpg_430x430q90.jpg', '/nfs-client//framework/anonymous/2018-03-26/1522044597003.jpg', '27635', null, null);
INSERT INTO `attachment` VALUES ('402881bf6260cad5016260ed78590004', '2018-03-26 14:09:58', '', '0', '2018-03-26 14:09:58', 'jpg', 'TB23YWQXnzGK1JjSsppXXc31VXa_!!1862446581.jpg_430x430q90.jpg', '/nfs-client//framework/anonymous/2018-03-26/1522044598357.jpg', '42838', null, null);
INSERT INTO `attachment` VALUES ('402881bf6260cad5016260f0c0e80005', '2018-03-26 14:13:34', '', '0', '2018-03-26 14:13:34', 'jpg', 'TB2dLePXf_HK1JjSszgXXazDFXa_!!1862446581.jpg_430x430q90.jpg', '/nfs-client//framework/anonymous/2018-03-26/1522044813540.jpg', '50404', null, null);
INSERT INTO `attachment` VALUES ('402881bf6260cad5016260f19fef0006', '2018-03-26 14:14:31', '', '0', '2018-03-26 14:14:31', 'jpg', 'TB2dLePXf_HK1JjSszgXXazDFXa_!!1862446581.jpg_430x430q90.jpg', '/nfs-client//framework/anonymous/2018-03-26/1522044870635.jpg', '50404', null, null);
INSERT INTO `attachment` VALUES ('402881bf6260f7f3016260fb95790000', '2018-03-26 14:25:23', '', '0', '2018-03-26 14:25:23', 'jpg', 'TB2dLePXf_HK1JjSszgXXazDFXa_!!1862446581.jpg_430x430q90.jpg', '/nfs-client//framework/anonymous/2018-03-26/1522045523308.jpg', '50404', null, null);
INSERT INTO `attachment` VALUES ('402881bf6260f7f3016260fbbc5f0001', '2018-03-26 14:25:33', '', '0', '2018-03-26 14:25:33', 'jpg', 'TB2GIGRXo_FK1Jjy0FnXXbXfXXa_!!1862446581.jpg_430x430q90.jpg', '/nfs-client//framework/anonymous/2018-03-26/1522045533274.jpg', '42419', null, null);
INSERT INTO `attachment` VALUES ('402881bf6260f7f3016260fbc41f0002', '2018-03-26 14:25:35', '', '0', '2018-03-26 14:25:35', 'jpg', 'TB2p7KQXgvGK1Jjy0FfXXbykpXa_!!1862446581.jpg_430x430q90.jpg', '/nfs-client//framework/anonymous/2018-03-26/1522045535260.jpg', '27635', null, null);
INSERT INTO `attachment` VALUES ('402881bf6260f7f3016260fbd25c0003', '2018-03-26 14:25:39', '', '0', '2018-03-26 14:25:39', 'jpg', 'TB23YWQXnzGK1JjSsppXXc31VXa_!!1862446581.jpg_430x430q90.jpg', '/nfs-client//framework/anonymous/2018-03-26/1522045538904.jpg', '42838', null, null);
INSERT INTO `attachment` VALUES ('402881bf6260f7f30162610216550008', '2018-03-26 14:32:30', '', '0', '2018-03-26 14:32:30', 'jpg', 'TB2dLePXf_HK1JjSszgXXazDFXa_!!1862446581.jpg_430x430q90.jpg', '/nfs-client//framework/anonymous/2018-03-26/1522045949520.jpg', '50404', null, null);
INSERT INTO `attachment` VALUES ('402881bf626106d401626107a1a40000', '2018-03-26 14:38:33', '', '0', '2018-03-26 14:38:33', 'jpg', 'TB2dLePXf_HK1JjSszgXXazDFXa_!!1862446581.jpg_430x430q90.jpg', '/nfs-client//framework/anonymous/2018-03-26/1522046312856.jpg', '50404', null, null);
INSERT INTO `attachment` VALUES ('402881bf626106d401626107a9790001', '2018-03-26 14:38:35', '', '0', '2018-03-26 14:38:35', 'jpg', 'TB2GIGRXo_FK1Jjy0FnXXbXfXXa_!!1862446581.jpg_430x430q90.jpg', '/nfs-client//framework/anonymous/2018-03-26/1522046314867.jpg', '42419', null, null);
INSERT INTO `attachment` VALUES ('402881bf626106d401626107b04f0002', '2018-03-26 14:38:37', '', '0', '2018-03-26 14:38:37', 'jpg', 'TB2p7KQXgvGK1Jjy0FfXXbykpXa_!!1862446581.jpg_430x430q90.jpg', '/nfs-client//framework/anonymous/2018-03-26/1522046316617.jpg', '27635', null, null);
INSERT INTO `attachment` VALUES ('402881bf626106d401626107b8000003', '2018-03-26 14:38:39', '', '0', '2018-03-26 14:38:39', 'jpg', 'TB23YWQXnzGK1JjSsppXXc31VXa_!!1862446581.jpg_430x430q90.jpg', '/nfs-client//framework/anonymous/2018-03-26/1522046318587.jpg', '42838', null, null);
INSERT INTO `attachment` VALUES ('402881bf626106d401626109b1c10008', '2018-03-26 14:40:48', '', '0', '2018-03-26 14:40:48', 'jpg', 'TB23YWQXnzGK1JjSsppXXc31VXa_!!1862446581.jpg_430x430q90.jpg', '/nfs-client//framework/anonymous/2018-03-26/1522046448058.jpg', '42838', null, null);
INSERT INTO `attachment` VALUES ('402881bf626106d401626109e72e0009', '2018-03-26 14:41:02', '', '0', '2018-03-26 14:41:02', 'jpg', 'TB2dLePXf_HK1JjSszgXXazDFXa_!!1862446581.jpg_430x430q90.jpg', '/nfs-client//framework/anonymous/2018-03-26/1522046461738.jpg', '50404', null, null);
INSERT INTO `attachment` VALUES ('40288383625cbade01625cbff5a60000', '2018-03-25 18:41:47', '', '0', '2018-03-25 18:41:47', 'jpg', 'ad.jpg', '/nfs-client//framework/anonymous/2018-03-25/1521974506893.jpg', '39944', null, null);
INSERT INTO `attachment` VALUES ('40288383625cbade01625cc06e530001', '2018-03-25 18:42:18', '', '0', '2018-03-25 18:42:18', 'jpg', 'art-list-auther.jpg', '/nfs-client//framework/anonymous/2018-03-25/1521974537807.jpg', '1630', null, null);
INSERT INTO `attachment` VALUES ('40288383625cbade01625cc78c8c0002', '2018-03-25 18:50:04', '', '0', '2018-03-25 18:50:04', 'jpg', 'art-hot-img.jpg', '/nfs-client//framework/anonymous/2018-03-25/1521975004294.jpg', '3627', null, null);
INSERT INTO `attachment` VALUES ('none-cover', null, '', '0', null, 'jpg', 'none-img.jpg', '/nfs-client/none-img.jpg', null, null, null);

-- ----------------------------
-- Table structure for `business_related_unit`
-- ----------------------------
DROP TABLE IF EXISTS `business_related_unit`;
CREATE TABLE `business_related_unit` (
  `id` varchar(36) NOT NULL,
  `client_id` varchar(128) DEFAULT NULL,
  `create_user_id` varchar(36) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `logically_deleted` bit(1) DEFAULT NULL,
  `sort_number` int(11) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `code` varchar(20) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `bank_account` varchar(50) DEFAULT NULL,
  `credit_line` double DEFAULT NULL,
  `credit_line_enable` bit(1) DEFAULT NULL,
  `deposit_bank` varchar(200) DEFAULT NULL,
  `detail_address` varchar(500) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `linkman` varchar(20) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `now_payable_amount` double DEFAULT NULL,
  `now_receivable_amount` double DEFAULT NULL,
  `opening_payable_amount` double DEFAULT NULL,
  `opening_receivable_amount` double DEFAULT NULL,
  `pinyin` varchar(50) DEFAULT NULL,
  `price_level` varchar(20) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `shortname` varchar(20) DEFAULT NULL,
  `tax_number` varchar(50) DEFAULT NULL,
  `tax_rate` int(11) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of business_related_unit
-- ----------------------------
INSERT INTO `business_related_unit` VALUES ('402881c5623bcb3501623bcd525d0000', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-03-19 09:08:54', '', '0', '2018-04-08 22:33:15', '001', '零售客户', null, '500', '', null, null, null, null, null, '200', '100', '200', '100', 'lskh', '预设售价1', null, '零售客户', null, '0', null, 'CUSTOMER');
INSERT INTO `business_related_unit` VALUES ('402881c5623befdf01623c0df2990000', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-03-19 10:19:30', '', '0', '2018-05-30 15:05:35', '002', '网店客户', '6222022222222', '1', '', '工商银行', null, 'huaqian@hq.com', '蔡干强(楊千棟)', '14812444577', '1', '2', '1', '2', 'wdkh', null, '第一条记录/中国深圳', '网店客户', 'g324323232', '0', '07758214544', 'VENDOR');
INSERT INTO `business_related_unit` VALUES ('40288383629e85eb01629f4aa30b0000', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-04-07 16:48:12', '', '0', '2018-04-08 21:23:26', '003', '成都商贸有限公司', null, null, '', null, null, null, '王永文', null, '0', '0', '0', '0', 'cdsmyxgs', null, null, '成都商贸有限公司', null, '0', null, 'VENDOR');

-- ----------------------------
-- Table structure for `code_number`
-- ----------------------------
DROP TABLE IF EXISTS `code_number`;
CREATE TABLE `code_number` (
  `id` varchar(36) NOT NULL,
  `client_id` varchar(128) DEFAULT NULL,
  `create_user_id` varchar(36) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `logically_deleted` bit(1) DEFAULT NULL,
  `sort_number` int(11) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `business_type` varchar(20) DEFAULT NULL,
  `next_code` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of code_number
-- ----------------------------
INSERT INTO `code_number` VALUES ('4028838362c755120162c755eeef0000', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-04-15 11:25:20', '', '0', '2018-04-16 11:28:42', 'JHD', '001');

-- ----------------------------
-- Table structure for `counter`
-- ----------------------------
DROP TABLE IF EXISTS `counter`;
CREATE TABLE `counter` (
  `id` varchar(36) NOT NULL,
  `client_id` varchar(128) DEFAULT NULL,
  `create_user_id` varchar(36) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `logically_deleted` bit(1) DEFAULT NULL,
  `sort_number` int(11) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `store_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of counter
-- ----------------------------
INSERT INTO `counter` VALUES ('402881c5622d815401622d8694e50000', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-03-16 14:36:57', '', '0', '2018-03-16 14:36:57', '01', '柜台01', '402881c5622d572401622d5ba7830003');

-- ----------------------------
-- Table structure for `dictionary`
-- ----------------------------
DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE `dictionary` (
  `id` varchar(36) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `logically_deleted` bit(1) DEFAULT NULL,
  `sort_number` int(11) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `code` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `dictionary_category_id` varchar(36) DEFAULT NULL,
  `client_id` varchar(128) DEFAULT NULL,
  `create_user_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5karylm6jn6jkkvfifx4l9h30` (`dictionary_category_id`),
  CONSTRAINT `FK5karylm6jn6jkkvfifx4l9h30` FOREIGN KEY (`dictionary_category_id`) REFERENCES `dictionary_category` (`id`),
  CONSTRAINT `dictionary_ibfk_1` FOREIGN KEY (`dictionary_category_id`) REFERENCES `dictionary_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of dictionary
-- ----------------------------
INSERT INTO `dictionary` VALUES ('402881bc613110e701613142f3a60001', '0000-00-00 00:00:00', '', '0', '0000-00-00 00:00:00', 'g', '克', '402881bc613110e70161314135990000', 'tonr', null);
INSERT INTO `dictionary` VALUES ('402881bc613110e7016131430af10002', '0000-00-00 00:00:00', '', '0', '0000-00-00 00:00:00', 'kg', '千克', '402881bc613110e70161314135990000', 'tonr', null);
INSERT INTO `dictionary` VALUES ('402881bc613110e701613182c9940005', '0000-00-00 00:00:00', '', '0', '0000-00-00 00:00:00', '1', '1', '402881bc613110e70161314450460003', 'tonr', null);
INSERT INTO `dictionary` VALUES ('402881bc613110e701613182eb4e0006', '0000-00-00 00:00:00', '', '0', '0000-00-00 00:00:00', '2', '2', '402881bc613110e70161314450460003', 'tonr', null);
INSERT INTO `dictionary` VALUES ('402881bc6144c31d016144c38ef90000', '0000-00-00 00:00:00', '', '0', '0000-00-00 00:00:00', null, 'c', '402881bc614494c40161449913eb0000', 'tonr', null);
INSERT INTO `dictionary` VALUES ('402881bc6145ad51016145d3b1cd0001', '0000-00-00 00:00:00', '', '0', '0000-00-00 00:00:00', null, '机电', '402881bc6145ad51016145d37dab0000', 'tonr', null);
INSERT INTO `dictionary` VALUES ('402881bc61464dfe01614651f7030003', '0000-00-00 00:00:00', '', '0', '0000-00-00 00:00:00', null, '个', '402881bc613110e70161314135990000', 'tonr', null);
INSERT INTO `dictionary` VALUES ('402881bd61650a450161653bff9f0002', '0000-00-00 00:00:00', '', '0', '0000-00-00 00:00:00', null, '海尔', '402881bc614494c40161449913eb0000', 'tonr', null);
INSERT INTO `dictionary` VALUES ('402881bd61650a450161653c18bf0003', '0000-00-00 00:00:00', '', '0', '0000-00-00 00:00:00', null, '太平洋保险', '402881bc613f59be01613f67fe180000', 'tonr', null);

-- ----------------------------
-- Table structure for `dictionary_category`
-- ----------------------------
DROP TABLE IF EXISTS `dictionary_category`;
CREATE TABLE `dictionary_category` (
  `id` varchar(36) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `logically_deleted` bit(1) DEFAULT NULL,
  `sort_number` int(11) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `code` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `parent_id` varchar(36) DEFAULT NULL,
  `client_id` varchar(128) DEFAULT NULL,
  `create_user_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdgpx4q8hdcqgg16pwnrjmuqu3` (`parent_id`),
  CONSTRAINT `FKdgpx4q8hdcqgg16pwnrjmuqu3` FOREIGN KEY (`parent_id`) REFERENCES `dictionary_category` (`id`),
  CONSTRAINT `dictionary_category_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `dictionary_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of dictionary_category
-- ----------------------------
INSERT INTO `dictionary_category` VALUES ('402881bc613110e70161314135990000', '0000-00-00 00:00:00', '', '0', '0000-00-00 00:00:00', 'unit', '单位', null, 'tonr', null);
INSERT INTO `dictionary_category` VALUES ('402881bc613110e70161314450460003', '0000-00-00 00:00:00', '', '0', '0000-00-00 00:00:00', 'standard', '规格', null, 'tonr', null);
INSERT INTO `dictionary_category` VALUES ('402881bc613110e70161314675800004', '0000-00-00 00:00:00', '', '0', '0000-00-00 00:00:00', null, '1', '402881bc613110e70161314135990000', 'tonr', null);
INSERT INTO `dictionary_category` VALUES ('402881bc613f59be01613f67fe180000', '0000-00-00 00:00:00', '', '0', '0000-00-00 00:00:00', 'insurance_company', '保险公司', null, 'tonr', null);
INSERT INTO `dictionary_category` VALUES ('402881bc614494c40161449913eb0000', '0000-00-00 00:00:00', '', '0', '0000-00-00 00:00:00', 'vendor', '供应商', null, 'tonr', null);
INSERT INTO `dictionary_category` VALUES ('402881bc6145ad51016145d37dab0000', '0000-00-00 00:00:00', '', '0', '0000-00-00 00:00:00', 'work_type', '工种', null, 'tonr', null);

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` varchar(36) NOT NULL,
  `client_id` varchar(128) DEFAULT NULL,
  `create_user_id` varchar(36) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `logically_deleted` bit(1) DEFAULT NULL,
  `sort_number` int(11) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `brand_id` varchar(36) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `cost_price` double DEFAULT NULL,
  `height` double DEFAULT NULL,
  `length` double DEFAULT NULL,
  `made_address` varchar(50) DEFAULT NULL,
  `model` varchar(100) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `pinyin` varchar(50) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `shortname` varchar(50) DEFAULT NULL,
  `standard` varchar(100) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `width` double DEFAULT NULL,
  `goods_category_id` varchar(36) DEFAULT NULL,
  `barcode` varchar(200) DEFAULT NULL,
  `goods_type_id` varchar(36) DEFAULT NULL,
  `stock_number` double DEFAULT NULL,
  `stock_warn_number` double DEFAULT NULL,
  `retail_price` double DEFAULT NULL,
  `cover_image_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('402881bf62602fa301626032b82f0009', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-03-26 10:45:59', '', '0', '2018-05-30 15:38:19', null, 'W100914', '51', '0', '0', null, null, '修身气质休闲小西装', 'xsqzxxxxz', '修身', '小西装', null, '1.25', '0', '402881bf62706e6a016270d10a84000d', '0110010023', '402883836326143e0163262a541a0000', '0', '0', '289', '402881b5637216a801637219f6e00000');
INSERT INTO `goods` VALUES ('402881bf626106d40162610f3615000a', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-03-26 14:46:50', '', '0', '2018-05-21 16:29:29', null, 'W100917', '0', '0', '0', null, null, 'zara烟灰色微弹力水洗牛仔铅笔裤', 'zarayhswdlsxnzqbk3', null, 'zara烟灰色微弹力水洗牛仔铅笔裤', null, '1.26', '0', '402881bf62706e6a016270b42bbc0005', null, null, '0', '1', '0', '402881b5637216a80163721c98d80001');
INSERT INTO `goods` VALUES ('40288383629aa9e801629aaac5870000', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-04-06 19:15:06', '', '0', '2018-05-18 15:27:33', null, 'a', '0', '0', '0', null, null, 'a', 'a', null, 'a', null, '0', '0', '402881bf62706e6a016270887fdd0000', null, null, '0', '1', '0', '402881b5637216a80163722577c90003');

-- ----------------------------
-- Table structure for `goods_attribute`
-- ----------------------------
DROP TABLE IF EXISTS `goods_attribute`;
CREATE TABLE `goods_attribute` (
  `id` varchar(36) NOT NULL,
  `client_id` varchar(128) DEFAULT NULL,
  `create_user_id` varchar(36) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `logically_deleted` bit(1) DEFAULT NULL,
  `sort_number` int(11) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `goods_id` varchar(255) DEFAULT NULL,
  `goods_type_attribute_id` varchar(255) DEFAULT NULL,
  `goods_type_attribute_value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of goods_attribute
-- ----------------------------
INSERT INTO `goods_attribute` VALUES ('402881b56386a0bc016386a1dcd30000', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-05-22 14:55:45', '', '0', '2018-05-22 14:55:45', '402881bf62602fa301626032b82f0009', '402881b56328e2690163291605490003', '白色');
INSERT INTO `goods_attribute` VALUES ('402881b56386a0bc016386a1dcd90001', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-05-22 14:55:45', '', '0', '2018-05-22 14:55:45', '402881bf62602fa301626032b82f0009', '402881b5634e27ce01634e582d490000', 'S');
INSERT INTO `goods_attribute` VALUES ('402881b56386a0bc016386a1dcda0002', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-05-22 14:55:45', '', '0', '2018-05-22 14:55:45', '402881bf62602fa301626032b82f0009', '402881b5634e27ce01634e582d490000', 'M');

-- ----------------------------
-- Table structure for `goods_category`
-- ----------------------------
DROP TABLE IF EXISTS `goods_category`;
CREATE TABLE `goods_category` (
  `id` varchar(36) NOT NULL,
  `client_id` varchar(128) DEFAULT NULL,
  `create_user_id` varchar(36) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `logically_deleted` bit(1) DEFAULT NULL,
  `sort_number` int(11) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `parent_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of goods_category
-- ----------------------------
INSERT INTO `goods_category` VALUES ('402881b56338183f01633826f07e0001', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-05-07 09:11:06', '', '0', '2018-05-07 11:06:59', '条纹', '402881bf62706e6a0162709c2c3a0001');
INSERT INTO `goods_category` VALUES ('402881bf62706e6a016270887fdd0000', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-03-29 14:53:37', '', '0', '2018-03-29 14:53:37', 'ZARA女装', null);
INSERT INTO `goods_category` VALUES ('402881bf62706e6a0162709c2c3a0001', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-03-29 15:15:06', '', '0', '2018-05-06 19:53:08', '衬衫', '402881bf62706e6a016270887fdd0000');
INSERT INTO `goods_category` VALUES ('402881bf62706e6a016270b235ae0003', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-03-29 15:39:10', '', '0', '2018-03-29 15:39:10', '裤子', '402881bf62706e6a016270887fdd0000');
INSERT INTO `goods_category` VALUES ('402881bf62706e6a016270b42bbc0005', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-03-29 15:41:19', '', '0', '2018-05-07 09:00:01', '铅笔裤', '402881bf62706e6a016270b235ae0003');
INSERT INTO `goods_category` VALUES ('402881bf62706e6a016270bf4c540008', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-03-29 15:53:28', '', '0', '2018-03-29 15:53:28', '哈伦裤', '402881bf62706e6a016270b235ae0003');
INSERT INTO `goods_category` VALUES ('402881bf62706e6a016270d08658000c', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-03-29 16:12:17', '', '0', '2018-03-29 16:12:17', '长袖', '402881bf62706e6a0162709c2c3a0001');
INSERT INTO `goods_category` VALUES ('402881bf62706e6a016270d10a84000d', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-03-29 16:12:51', '', '0', '2018-05-07 14:41:14', '西装', '402881bf62706e6a016270887fdd0000');

-- ----------------------------
-- Table structure for `goods_sku`
-- ----------------------------
DROP TABLE IF EXISTS `goods_sku`;
CREATE TABLE `goods_sku` (
  `id` varchar(36) NOT NULL,
  `client_id` varchar(128) DEFAULT NULL,
  `create_user_id` varchar(36) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `logically_deleted` bit(1) DEFAULT NULL,
  `sort_number` int(11) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `barcode` varchar(200) DEFAULT NULL,
  `code` varchar(200) DEFAULT NULL,
  `goods_id` varchar(36) DEFAULT NULL,
  `goods_property_value_ids` varchar(2000) DEFAULT NULL,
  `last_purchase_price` double DEFAULT NULL,
  `goods_attribute_ids` varchar(2000) DEFAULT NULL,
  `stock_number` double DEFAULT NULL,
  `stock_warn_number` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of goods_sku
-- ----------------------------
INSERT INTO `goods_sku` VALUES ('402881b56386a0bc016386a1dd160003', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-05-22 14:55:45', '', '0', '2018-05-30 15:38:19', null, null, '402881bf62602fa301626032b82f0009', null, '0', '402881b56386a0bc016386a1dcd30000,402881b56386a0bc016386a1dcd90001', '5', null);
INSERT INTO `goods_sku` VALUES ('402881b56386a0bc016386a1dd160004', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-05-22 14:55:45', '', '0', '2018-05-30 15:38:19', null, null, '402881bf62602fa301626032b82f0009', null, '0', '402881b56386a0bc016386a1dcd30000,402881b56386a0bc016386a1dcda0002', '1', null);

-- ----------------------------
-- Table structure for `goods_supplier`
-- ----------------------------
DROP TABLE IF EXISTS `goods_supplier`;
CREATE TABLE `goods_supplier` (
  `id` varchar(36) NOT NULL,
  `client_id` varchar(128) DEFAULT NULL,
  `create_user_id` varchar(36) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `logically_deleted` bit(1) DEFAULT NULL,
  `sort_number` int(11) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `business_related_unit_id` varchar(36) DEFAULT NULL,
  `goods_id` varchar(255) DEFAULT NULL,
  `minimum_count` double DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of goods_supplier
-- ----------------------------
INSERT INTO `goods_supplier` VALUES ('402881be63afd80f0163afdd03bd0002', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-05-30 15:04:47', '', '0', '2018-05-30 15:04:47', '402881c5623befdf01623c0df2990000', '402881bf62602fa301626032b82f0009', '0', '0');
INSERT INTO `goods_supplier` VALUES ('402881be63afd80f0163afdd2e650003', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-05-30 15:04:58', '', '0', '2018-05-30 15:04:58', '40288383629e85eb01629f4aa30b0000', '402881bf62602fa301626032b82f0009', '0', '0');

-- ----------------------------
-- Table structure for `goods_type`
-- ----------------------------
DROP TABLE IF EXISTS `goods_type`;
CREATE TABLE `goods_type` (
  `id` varchar(36) NOT NULL,
  `client_id` varchar(128) DEFAULT NULL,
  `create_user_id` varchar(36) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `logically_deleted` bit(1) DEFAULT NULL,
  `sort_number` int(11) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of goods_type
-- ----------------------------
INSERT INTO `goods_type` VALUES ('402881b56348e1e101634943d88c0000', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-05-10 16:56:13', '', '0', '2018-05-15 15:15:36', '鞋');
INSERT INTO `goods_type` VALUES ('402883836326143e0163262a541a0000', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-05-03 21:21:38', '', '0', '2018-05-11 13:26:34', '衣服');
INSERT INTO `goods_type` VALUES ('402883836326367c0163264512b60000', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-05-03 21:50:51', '', '0', '2018-05-03 21:50:51', '裤子');

-- ----------------------------
-- Table structure for `goods_type_attribute`
-- ----------------------------
DROP TABLE IF EXISTS `goods_type_attribute`;
CREATE TABLE `goods_type_attribute` (
  `id` varchar(36) NOT NULL,
  `client_id` varchar(128) DEFAULT NULL,
  `create_user_id` varchar(36) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `logically_deleted` bit(1) DEFAULT NULL,
  `sort_number` int(11) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `attr_values` varchar(500) DEFAULT NULL,
  `goods_type_id` varchar(36) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of goods_type_attribute
-- ----------------------------
INSERT INTO `goods_type_attribute` VALUES ('402881b56328e2690163291605490003', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-05-04 10:58:19', '', '0', '2018-05-04 11:04:17', '白色,红色,蓝色', '402883836326143e0163262a541a0000', '颜色');
INSERT INTO `goods_type_attribute` VALUES ('402881b5634e27ce01634e582d490000', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-05-11 16:36:32', '', '0', '2018-05-11 16:36:32', 'S,M,L,XL', '402883836326143e0163262a541a0000', '尺码');

-- ----------------------------
-- Table structure for `member`
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` varchar(36) NOT NULL,
  `client_id` varchar(128) DEFAULT NULL,
  `create_user_id` varchar(36) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `logically_deleted` bit(1) DEFAULT NULL,
  `sort_number` int(11) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `code` varchar(20) DEFAULT NULL,
  `input_manner` varchar(20) DEFAULT NULL,
  `license_number` varchar(50) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `login_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('402881ca6218c5b4016218c9c7c00000', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-03-12 13:58:20', '', '0', '2018-03-14 22:42:11', '03121358191131', 'ARTIFICIAL', null, '18640068590', '王羽菲', '321', null, null, null);
INSERT INTO `member` VALUES ('402881ca6218c5b4016218ca16270001', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-03-12 13:58:40', '', '0', '2018-03-12 16:38:45', '03121358397666', 'ARTIFICIAL', 'xxxxxxx', '13000000000', '朱德范', null, null, null, null);

-- ----------------------------
-- Table structure for `member_card`
-- ----------------------------
DROP TABLE IF EXISTS `member_card`;
CREATE TABLE `member_card` (
  `id` varchar(36) NOT NULL,
  `client_id` varchar(128) DEFAULT NULL,
  `create_user_id` varchar(36) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `logically_deleted` bit(1) DEFAULT NULL,
  `sort_number` int(11) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `member_card_type_id` varchar(36) DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `card_number` varchar(20) DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `expire_date` datetime DEFAULT NULL,
  `member_id` varchar(36) DEFAULT NULL,
  `points` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of member_card
-- ----------------------------
INSERT INTO `member_card` VALUES ('402881c562237ec2016223a0baf00000', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-03-14 16:29:19', '', '0', '2018-03-14 17:09:34', '402881c0621d9efb01621de76bb80000', '0', 'VIP-003', '0.8', '2019-03-07 00:00:00', '402881ca6218c5b4016218ca16270001', '0', null);
INSERT INTO `member_card` VALUES ('402881c562237ec2016223c5d6a10001', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-03-14 17:09:51', '', '0', '2018-03-15 15:56:43', '402881c0621d9efb01621df0d34b0001', '16', 'VIP-001', '0.9', '2019-03-08 00:00:00', '402881ca6218c5b4016218c9c7c00000', '2', null);
INSERT INTO `member_card` VALUES ('4028838362241de80162243985940000', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-03-14 19:16:12', '', '0', '2018-03-15 15:58:02', '402881c0621d9efb01621df0d34b0001', '20', 'VIP-002', '0.9', '2019-03-08 00:00:00', '402881ca6218c5b4016218c9c7c00000', '0', null);

-- ----------------------------
-- Table structure for `member_card_type`
-- ----------------------------
DROP TABLE IF EXISTS `member_card_type`;
CREATE TABLE `member_card_type` (
  `id` varchar(36) NOT NULL,
  `client_id` varchar(128) DEFAULT NULL,
  `create_user_id` varchar(36) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `logically_deleted` bit(1) DEFAULT NULL,
  `sort_number` int(11) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of member_card_type
-- ----------------------------
INSERT INTO `member_card_type` VALUES ('402881c0621d9efb01621de76bb80000', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-03-13 13:48:48', '', '0', '2018-03-13 13:58:19', '0.8', '金卡', null);
INSERT INTO `member_card_type` VALUES ('402881c0621d9efb01621df0d34b0001', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-03-13 13:59:05', '', '0', '2018-03-13 13:59:05', '0.9', '银卡', null);

-- ----------------------------
-- Table structure for `module`
-- ----------------------------
DROP TABLE IF EXISTS `module`;
CREATE TABLE `module` (
  `id` varchar(36) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `logically_deleted` bit(1) DEFAULT NULL,
  `sort_number` int(11) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `code` varchar(100) DEFAULT NULL,
  `icon` varchar(100) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `navi_id_path` varchar(500) DEFAULT NULL,
  `navi_name_path` varchar(500) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `url` varchar(500) DEFAULT NULL,
  `parent_id` varchar(36) DEFAULT NULL,
  `client_id` varchar(128) DEFAULT NULL,
  `create_user_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKovripa3rfs5f9qu2pvyhgo6xi` (`parent_id`),
  CONSTRAINT `FKovripa3rfs5f9qu2pvyhgo6xi` FOREIGN KEY (`parent_id`) REFERENCES `module` (`id`),
  CONSTRAINT `module_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `module` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of module
-- ----------------------------
INSERT INTO `module` VALUES ('', null, null, null, null, null, null, null, null, null, null, '1', null, null, null);
INSERT INTO `module` VALUES ('24746c09-2960-11e7-b497-21af0a259a98', null, '', '2', null, null, '', '管理员管理', 'b8c06782-2a58-11e7-b497-21af0a259a98/24746c09-2960-11e7-b497-21af0a259a98', '系统管理 /管理员管理', 'MENU', '/admin/admin/list', '98b33553-827e-11e7-9f6e-708bcdac0848', 'tonr', null);
INSERT INTO `module` VALUES ('3ffd622d-2a1f-11e7-b497-21af0a259a98', null, '', '1', null, null, '', '角色管理', '98b33553-827e-11e7-9f6e-708bcdac0848/3ffd622d-2a1f-11e7-b497-21af0a259a98', '权限管理 /角色管理', 'MENU', '/admin/role/list', '98b33553-827e-11e7-9f6e-708bcdac0848', 'tonr', null);
INSERT INTO `module` VALUES ('402881bf6274b40e016274b68f300000', '2018-03-30 10:22:24', '', '0', '2018-03-30 10:22:24', null, null, '员工管理', null, null, 'MENU', '/basic-data/employee/employee', '402881ca62099787016209dd99c00032', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881c55f38c257015f38c2e4d00000', null, '', '0', null, null, null, '附件管理', '', '', 'MENU', '/admin/attachment/list', 'b8c06782-2a58-11e7-b497-21af0a259a98', 'tonr', null);
INSERT INTO `module` VALUES ('402881ca62099787016209c7fe260000', null, '', '0', null, null, null, '常用', null, null, 'MENU', null, null, 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209c82b680001', null, '', '0', '2018-03-22 10:18:10', null, null, '单据草稿', null, null, 'MENU', '/common/draft/draft', '402881ca62099787016209c7fe260000', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209c83d110002', null, '', '0', '2018-03-22 10:26:02', null, null, '单据中心', null, null, 'MENU', '/common/bill/bill', '402881ca62099787016209c7fe260000', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209c85e650003', null, '', '0', '2018-03-22 10:28:27', null, null, '库存状况', null, null, 'MENU', '/common/store/store', '402881ca62099787016209c7fe260000', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209ca617a0004', null, '', '0', null, null, null, '商品', null, null, 'MENU', null, null, 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209ca85990005', null, '', '0', '2018-03-22 10:28:45', null, null, '商品信息', null, null, 'MENU', '/goods/goods/goods', '402881ca62099787016209ca617a0004', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209caa3cc0006', null, '', '0', '2018-04-04 16:13:28', null, null, 'sku管理', null, null, 'MENU', '/goods/goods/goods-sku', '402881ca62099787016209ca617a0004', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209cae6510007', null, '', '0', '2018-03-22 10:30:00', null, null, '商品套餐管理', null, null, 'MENU', '/goods/package/package', '402881ca62099787016209ca617a0004', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209cb0e880008', null, '', '0', '2018-03-20 09:56:04', null, null, '商品属性值设置', null, null, 'MENU', '/goods/property-value/property-value', '402881ca62099787016209ca617a0004', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209cb4fad0009', null, '', '0', '2018-03-21 19:57:49', null, null, '商品属性组管理', null, null, 'MENU', '/goods/property-group/property-group', '402881ca62099787016209ca617a0004', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209cbd790000a', null, '', '0', null, null, null, '进货', null, null, 'MENU', null, null, 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209cbfdb8000b', null, '', '0', '2018-03-22 10:23:00', null, null, '新增进货订单', null, null, 'MENU', '/purchase/new-order/new-order', '402881ca62099787016209cbd790000a', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209cc28ab000c', null, '', '0', '2018-04-15 12:01:29', null, null, '进货订单管理', null, null, 'MENU', '/purchase/order-list/order-list', '402881ca62099787016209cbd790000a', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209cc5e30000d', null, '', '0', '2018-03-22 10:30:23', null, null, '进货入库单', null, null, 'MENU', '1', '402881ca62099787016209cbd790000a', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209cc80f0000e', null, '', '0', '2018-03-22 10:30:26', null, null, '进货退货单', null, null, 'MENU', '1', '402881ca62099787016209cbd790000a', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209cca39f000f', null, '', '0', '2018-03-22 10:30:30', null, null, '进货换货单', null, null, 'MENU', '1', '402881ca62099787016209cbd790000a', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209cccaa60010', null, '', '0', '2018-03-22 10:30:35', null, null, '付款单', null, null, 'MENU', '1', '402881ca62099787016209cbd790000a', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209ce43390011', null, '', '0', null, null, null, '批零', null, null, 'MENU', null, null, 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209d01df60012', null, '', '0', '2018-03-22 10:30:46', null, null, '新增销售订单', null, null, 'MENU', '1', '402881ca62099787016209ce43390011', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209d21bef0013', null, '', '0', null, null, null, '销售订单管理', null, null, 'MENU', '1', '402881ca62099787016209ce43390011', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209d23ba30014', null, '', '0', null, null, null, '销售出库单', null, null, 'MENU', '1', '402881ca62099787016209ce43390011', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209d25d3a0015', null, '', '0', null, null, null, '销售退货单', null, null, 'MENU', '1', '402881ca62099787016209ce43390011', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209d27fef0016', null, '', '0', null, null, null, '销售换货单', null, null, 'MENU', '1', '402881ca62099787016209ce43390011', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209d2a6aa0017', null, '', '0', null, null, null, '收款单', null, null, 'MENU', '1', '402881ca62099787016209ce43390011', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209d2c9da0018', null, '', '0', '2018-03-22 10:23:33', null, null, '零售开单', null, null, 'MENU', '/retail/retail/retail', '402881ca62099787016209ce43390011', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209d2ee6f0019', null, '', '0', null, null, null, '零售退货', null, null, 'MENU', '1', '402881ca62099787016209ce43390011', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209d30f43001a', null, '', '0', null, null, null, '促销管理', null, null, 'MENU', '1', '402881ca62099787016209ce43390011', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209d32d7a001b', null, '', '0', null, null, null, '物价管理', null, null, 'MENU', '1', '402881ca62099787016209ce43390011', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209d35280001c', null, '', '0', null, null, null, '价格折扣跟踪', null, null, 'MENU', '1', '402881ca62099787016209ce43390011', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209d3e4e1001e', null, '', '0', null, null, null, '库存', null, null, 'MENU', null, null, 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209d40ebb001f', null, '', '0', null, null, null, '库存状况表', null, null, 'MENU', '1', '402881ca62099787016209d3e4e1001e', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209d42b190020', null, '', '0', null, null, null, '库存分布表', null, null, 'MENU', '1', '402881ca62099787016209d3e4e1001e', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209d4486c0021', null, '', '0', null, null, null, '汇总备货', null, null, 'MENU', '1', '402881ca62099787016209d3e4e1001e', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209d466c40022', null, '', '0', null, null, null, '报损单', null, null, 'MENU', '1', '402881ca62099787016209d3e4e1001e', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209d47de00023', null, '', '0', null, null, null, '报溢单', null, null, 'MENU', '1', '402881ca62099787016209d3e4e1001e', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209d4e8d00024', null, '', '0', null, null, null, '调拨单', null, null, 'MENU', '1', '402881ca62099787016209d3e4e1001e', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209d4f86f0025', null, '', '0', null, null, null, '调价单', null, null, 'MENU', '1', '402881ca62099787016209d3e4e1001e', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209d530090026', null, '', '0', null, null, null, '其他入库单', null, null, 'MENU', '1', '402881ca62099787016209d3e4e1001e', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209d5412e0027', null, '', '0', null, null, null, '其他出库单', null, null, 'MENU', '1', '402881ca62099787016209d3e4e1001e', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209d56f300028', null, '', '0', '2018-03-22 10:24:31', null, null, '库存盘点', null, null, 'MENU', '/store/inventory/inventory', '402881ca62099787016209d3e4e1001e', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209d654940029', null, '', '0', null, null, null, '商品上下限报警设置', null, null, 'MENU', '1', '402881ca62099787016209d3e4e1001e', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209d6c945002a', null, '', '0', null, null, null, '库存报警查询', null, null, 'MENU', '1', '402881ca62099787016209d3e4e1001e', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209d7e06e002b', null, '', '0', null, null, null, '财务', null, null, 'MENU', null, null, 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209d8058a002c', null, '', '0', null, null, null, '往来单位应收应付', null, null, 'MENU', '1', '402881ca62099787016209d7e06e002b', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209d83227002d', null, '', '0', '2018-03-22 10:25:20', null, null, '收款单', null, null, 'MENU', '/finance/receivables/receivables', '402881ca62099787016209d7e06e002b', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209d840f6002e', null, '', '0', null, null, null, '付款单', null, null, 'MENU', '1', '402881ca62099787016209d7e06e002b', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209dd99c00032', null, '', '0', null, null, null, '资料', null, null, 'MENU', null, null, 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209ddb8170033', null, '', '0', '2018-03-18 18:47:51', null, null, '往来单位', null, null, 'MENU', '/basic-data/business-related-unit/business-related-unit', '402881ca62099787016209dd99c00032', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209ddd4c90034', null, '', '0', '2018-03-15 20:27:23', null, null, '存货仓库', null, null, 'MENU', '/basic-data/warehouse/warehouse', '402881ca62099787016209dd99c00032', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209ddfc4b0035', null, '', '0', null, null, null, '仓库货位', null, null, 'MENU', '1', '402881ca62099787016209dd99c00032', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209de43f00036', null, '', '0', '2018-03-17 15:33:48', null, null, '现金银行', null, null, 'MENU', '/basic-data/cashbank/cashbank', '402881ca62099787016209dd99c00032', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209de7d820037', null, '', '0', '2018-03-17 17:23:18', null, null, '费用支出', null, null, 'MENU', '/basic-data/expenditure/expenditure', '402881ca62099787016209dd99c00032', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209deda4f0038', null, '', '0', '2018-03-15 17:18:45', null, null, '门店管理', null, null, 'MENU', '/basic-data/store/store', '402881ca62099787016209dd99c00032', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402881ca62099787016209df23bb003a', null, '', '0', null, null, null, '会员管理', null, null, 'MENU', '/basic-data/member/member', '402881ca62099787016209dd99c00032', 'tonr', '402881c45eff19a4015eff80ec080002');
INSERT INTO `module` VALUES ('402883835f2fa17a015f2fa27de00000', null, '', '0', null, null, null, '字典维护', '', '', 'MENU', '/admin/dictionary/list', 'b8c06782-2a58-11e7-b497-21af0a259a98', 'tonr', null);
INSERT INTO `module` VALUES ('402883835f2fa17a015f2fa2a5df0001', null, '', '0', null, null, null, '字典类别管理', '', '', 'MENU', '/admin/dictionary/categoryList', 'b8c06782-2a58-11e7-b497-21af0a259a98', 'tonr', null);
INSERT INTO `module` VALUES ('402883835f2fa17a015f2fa2cea90002', null, '', '0', null, null, null, '地址管理', '', '', 'MENU', '/admin/address/list', 'b8c06782-2a58-11e7-b497-21af0a259a98', 'tonr', null);
INSERT INTO `module` VALUES ('8fe09b87-296d-11e7-b497-21af0a259a98', null, '', '0', null, null, '', '模块管理', '98b33553-827e-11e7-9f6e-708bcdac0848/8fe09b87-296d-11e7-b497-21af0a259a98', '权限管理/模块管理', 'MENU', '/admin/module/list', '98b33553-827e-11e7-9f6e-708bcdac0848', 'tonr', null);
INSERT INTO `module` VALUES ('98b33553-827e-11e7-9f6e-708bcdac0848', null, '', '5', null, null, 'glyphicon glyphicon-lock', '权限管理', '98b33553-827e-11e7-9f6e-708bcdac0848', '权限管理', 'MENU', '', null, 'tonr', null);
INSERT INTO `module` VALUES ('b8c06782-2a58-11e7-b497-21af0a259a98', null, '', '6', null, null, 'fa fa-fw fa-wrench', '系统管理', 'b8c06782-2a58-11e7-b497-21af0a259a98', '系统管理', 'MENU', '', null, 'tonr', null);

-- ----------------------------
-- Table structure for `oauth_access_token`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_access_token`;
CREATE TABLE `oauth_access_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication_id` varchar(128) NOT NULL,
  `user_name` varchar(256) DEFAULT NULL,
  `client_id` varchar(256) DEFAULT NULL,
  `authentication` blob,
  `refresh_token` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`authentication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of oauth_access_token
-- ----------------------------
INSERT INTO `oauth_access_token` VALUES ('79b50fdd84d1e5dd40318dd98d1ba563', 0xACED0005737200436F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744F4175746832416363657373546F6B656E0CB29E361B24FACE0200064C00156164646974696F6E616C496E666F726D6174696F6E74000F4C6A6176612F7574696C2F4D61703B4C000A65787069726174696F6E7400104C6A6176612F7574696C2F446174653B4C000C72656672657368546F6B656E74003F4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F636F6D6D6F6E2F4F417574683252656672657368546F6B656E3B4C000573636F706574000F4C6A6176612F7574696C2F5365743B4C0009746F6B656E547970657400124C6A6176612F6C616E672F537472696E673B4C000576616C756571007E000578707372001E6A6176612E7574696C2E436F6C6C656374696F6E7324456D7074794D6170593614855ADCE7D002000078707372000E6A6176612E7574696C2E44617465686A81014B59741903000078707708000001618BAD63F1787372004C6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744578706972696E674F417574683252656672657368546F6B656E2FDF47639DD0C9B70200014C000A65787069726174696F6E71007E0002787200446F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744F417574683252656672657368546F6B656E73E10E0A6354D45E0200014C000576616C756571007E0005787074002439366561616433632D303034372D343337662D393937362D3263626663363963636663627371007E0009770800000161C13E12C878737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65536574801D92D18F9B80550200007872002C6A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65436F6C6C656374696F6E19420080CB5EF71E0200014C0001637400164C6A6176612F7574696C2F436F6C6C656374696F6E3B7870737200176A6176612E7574696C2E4C696E6B656448617368536574D86CD75A95DD2A1E020000787200116A6176612E7574696C2E48617368536574BA44859596B8B7340300007870770C000000103F4000000000000374000472656164740005777269746574000574727573747874000662656172657274002461306566623166642D643937662D343530342D616536362D393961633734356436643061, '0ade7d7970c764fb26bb21888ffa467f', 'jichu', 'tonr', 0xACED0005737200416F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F417574683241757468656E7469636174696F6EBD400B02166252130200024C000D73746F7265645265717565737474003C4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F4F4175746832526571756573743B4C00127573657241757468656E7469636174696F6E7400324C6F72672F737072696E676672616D65776F726B2F73656375726974792F636F72652F41757468656E7469636174696F6E3B787200476F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E416273747261637441757468656E7469636174696F6E546F6B656ED3AA287E6E47640E0200035A000D61757468656E746963617465644C000B617574686F7269746965737400164C6A6176612F7574696C2F436F6C6C656374696F6E3B4C000764657461696C737400124C6A6176612F6C616E672F4F626A6563743B787000737200266A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654C697374FC0F2531B5EC8E100200014C00046C6973747400104C6A6176612F7574696C2F4C6973743B7872002C6A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65436F6C6C656374696F6E19420080CB5EF71E0200014C00016371007E00047870737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A65787000000001770400000001737200426F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E617574686F726974792E53696D706C654772616E746564417574686F7269747900000000000001A40200014C0004726F6C657400124C6A6176612F6C616E672F537472696E673B787074000541444D494E7871007E000C707372003A6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F41757468325265717565737400000000000000010200075A0008617070726F7665644C000B617574686F72697469657371007E00044C000A657874656E73696F6E7374000F4C6A6176612F7574696C2F4D61703B4C000B726564697265637455726971007E000E4C00077265667265736874003B4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F546F6B656E526571756573743B4C000B7265736F7572636549647374000F4C6A6176612F7574696C2F5365743B4C000D726573706F6E7365547970657371007E0014787200386F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E426173655265717565737436287A3EA37169BD0200034C0008636C69656E74496471007E000E4C001172657175657374506172616D657465727371007E00124C000573636F706571007E00147870740004746F6E72737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654D6170F1A5A8FE74F507420200014C00016D71007E00127870737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F400000000000067708000000080000000374000A6772616E745F7479706574000870617373776F7264740009636C69656E745F6964740004746F6E72740008757365726E616D657400056A6963687578737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65536574801D92D18F9B80550200007871007E0009737200176A6176612E7574696C2E4C696E6B656448617368536574D86CD75A95DD2A1E020000787200116A6176612E7574696C2E48617368536574BA44859596B8B7340300007870770C000000103F40000000000003740004726561647400057772697465740005747275737478017371007E0025770C000000103F40000000000000787371007E001A3F40000000000000770800000010000000007870707371007E0025770C000000103F400000000000017400096672616D65776F726B787371007E0025770C000000103F40000000000000787372004F6F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E557365726E616D6550617373776F726441757468656E7469636174696F6E546F6B656E00000000000001A40200024C000B63726564656E7469616C7371007E00054C00097072696E636970616C71007E00057871007E0003017371007E00077371007E000B0000000177040000000171007E000F7871007E0032737200176A6176612E7574696C2E4C696E6B6564486173684D617034C04E5C106CC0FB0200015A000B6163636573734F726465727871007E001A3F400000000000067708000000080000000474000D636C69656E745F73656372657474000673656372657471007E001C71007E001D71007E001E71007E001F71007E002071007E0021780070737200326F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E7573657264657461696C732E5573657200000000000001A40200075A00116163636F756E744E6F6E457870697265645A00106163636F756E744E6F6E4C6F636B65645A001563726564656E7469616C734E6F6E457870697265645A0007656E61626C65644C000B617574686F72697469657371007E00144C000870617373776F726471007E000E4C0008757365726E616D6571007E000E7870010101017371007E0022737200116A6176612E7574696C2E54726565536574DD98509395ED875B0300007870737200466F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E7573657264657461696C732E5573657224417574686F72697479436F6D70617261746F7200000000000001A4020000787077040000000171007E000F787071007E0021, 'c41dcc3ee980eeee35b5b7f51651bdbe');
INSERT INTO `oauth_access_token` VALUES ('f2f49bb9bbe4a8a65a86f491f1a899e7', 0xACED0005737200436F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744F4175746832416363657373546F6B656E0CB29E361B24FACE0200064C00156164646974696F6E616C496E666F726D6174696F6E74000F4C6A6176612F7574696C2F4D61703B4C000A65787069726174696F6E7400104C6A6176612F7574696C2F446174653B4C000C72656672657368546F6B656E74003F4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F636F6D6D6F6E2F4F417574683252656672657368546F6B656E3B4C000573636F706574000F4C6A6176612F7574696C2F5365743B4C0009746F6B656E547970657400124C6A6176612F6C616E672F537472696E673B4C000576616C756571007E000578707372001E6A6176612E7574696C2E436F6C6C656374696F6E7324456D7074794D6170593614855ADCE7D002000078707372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000161C9A3166C787372004C6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744578706972696E674F417574683252656672657368546F6B656E2FDF47639DD0C9B70200014C000A65787069726174696F6E71007E0002787200446F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744F417574683252656672657368546F6B656E73E10E0A6354D45E0200014C000576616C756571007E0005787074002433316430393762322D366566332D343335382D613532382D6363643135393338663361667371007E000977080000016213E5C21178737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65536574801D92D18F9B80550200007872002C6A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65436F6C6C656374696F6E19420080CB5EF71E0200014C0001637400164C6A6176612F7574696C2F436F6C6C656374696F6E3B7870737200176A6176612E7574696C2E4C696E6B656448617368536574D86CD75A95DD2A1E020000787200116A6176612E7574696C2E48617368536574BA44859596B8B7340300007870770C000000103F4000000000000374000472656164740005777269746574000574727573747874000662656172657274002466656333616130392D396136612D346664332D393763622D653761626435656263376162, '0b883991f151094545aaab3614951d08', 'gongzhang', 'tonr', 0xACED0005737200416F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F417574683241757468656E7469636174696F6EBD400B02166252130200024C000D73746F7265645265717565737474003C4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F4F4175746832526571756573743B4C00127573657241757468656E7469636174696F6E7400324C6F72672F737072696E676672616D65776F726B2F73656375726974792F636F72652F41757468656E7469636174696F6E3B787200476F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E416273747261637441757468656E7469636174696F6E546F6B656ED3AA287E6E47640E0200035A000D61757468656E746963617465644C000B617574686F7269746965737400164C6A6176612F7574696C2F436F6C6C656374696F6E3B4C000764657461696C737400124C6A6176612F6C616E672F4F626A6563743B787000737200266A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654C697374FC0F2531B5EC8E100200014C00046C6973747400104C6A6176612F7574696C2F4C6973743B7872002C6A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65436F6C6C656374696F6E19420080CB5EF71E0200014C00016371007E00047870737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A65787000000001770400000001737200426F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E617574686F726974792E53696D706C654772616E746564417574686F7269747900000000000001A40200014C0004726F6C657400124C6A6176612F6C616E672F537472696E673B787074000541444D494E7871007E000C707372003A6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F41757468325265717565737400000000000000010200075A0008617070726F7665644C000B617574686F72697469657371007E00044C000A657874656E73696F6E7374000F4C6A6176612F7574696C2F4D61703B4C000B726564697265637455726971007E000E4C00077265667265736874003B4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F546F6B656E526571756573743B4C000B7265736F7572636549647374000F4C6A6176612F7574696C2F5365743B4C000D726573706F6E7365547970657371007E0014787200386F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E426173655265717565737436287A3EA37169BD0200034C0008636C69656E74496471007E000E4C001172657175657374506172616D657465727371007E00124C000573636F706571007E00147870740004746F6E72737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654D6170F1A5A8FE74F507420200014C00016D71007E00127870737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F400000000000067708000000080000000374000A6772616E745F7479706574000870617373776F7264740009636C69656E745F6964740004746F6E72740008757365726E616D65740009676F6E677A68616E6778737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65536574801D92D18F9B80550200007871007E0009737200176A6176612E7574696C2E4C696E6B656448617368536574D86CD75A95DD2A1E020000787200116A6176612E7574696C2E48617368536574BA44859596B8B7340300007870770C000000103F40000000000003740004726561647400057772697465740005747275737478017371007E0025770C000000103F40000000000000787371007E001A3F40000000000000770800000010000000007870707371007E0025770C000000103F400000000000017400096672616D65776F726B787371007E0025770C000000103F40000000000000787372004F6F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E557365726E616D6550617373776F726441757468656E7469636174696F6E546F6B656E00000000000001A40200024C000B63726564656E7469616C7371007E00054C00097072696E636970616C71007E00057871007E0003017371007E00077371007E000B0000000177040000000171007E000F7871007E0032737200176A6176612E7574696C2E4C696E6B6564486173684D617034C04E5C106CC0FB0200015A000B6163636573734F726465727871007E001A3F400000000000067708000000080000000474000D636C69656E745F73656372657474000673656372657471007E001C71007E001D71007E001E71007E001F71007E002071007E0021780070737200326F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E7573657264657461696C732E5573657200000000000001A40200075A00116163636F756E744E6F6E457870697265645A00106163636F756E744E6F6E4C6F636B65645A001563726564656E7469616C734E6F6E457870697265645A0007656E61626C65644C000B617574686F72697469657371007E00144C000870617373776F726471007E000E4C0008757365726E616D6571007E000E7870010101017371007E0022737200116A6176612E7574696C2E54726565536574DD98509395ED875B0300007870737200466F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E7573657264657461696C732E5573657224417574686F72697479436F6D70617261746F7200000000000001A4020000787077040000000171007E000F787071007E0021, '916c8862eb6d987cfd27afea4dc6ba69');
INSERT INTO `oauth_access_token` VALUES ('22a5dd27512bd8b1e9fcd7160f4bc1dd', 0xACED0005737200436F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744F4175746832416363657373546F6B656E0CB29E361B24FACE0200064C00156164646974696F6E616C496E666F726D6174696F6E74000F4C6A6176612F7574696C2F4D61703B4C000A65787069726174696F6E7400104C6A6176612F7574696C2F446174653B4C000C72656672657368546F6B656E74003F4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F636F6D6D6F6E2F4F417574683252656672657368546F6B656E3B4C000573636F706574000F4C6A6176612F7574696C2F5365743B4C0009746F6B656E547970657400124C6A6176612F6C616E672F537472696E673B4C000576616C756571007E000578707372001E6A6176612E7574696C2E436F6C6C656374696F6E7324456D7074794D6170593614855ADCE7D002000078707372000E6A6176612E7574696C2E44617465686A81014B597419030000787077080000016147593F1E787372004C6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744578706972696E674F417574683252656672657368546F6B656E2FDF47639DD0C9B70200014C000A65787069726174696F6E71007E0002787200446F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744F417574683252656672657368546F6B656E73E10E0A6354D45E0200014C000576616C756571007E0005787074002439383735376131662D316131372D343533662D613630382D3337343064303564643138617371007E0009770800000161DF44D91D78737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65536574801D92D18F9B80550200007872002C6A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65436F6C6C656374696F6E19420080CB5EF71E0200014C0001637400164C6A6176612F7574696C2F436F6C6C656374696F6E3B7870737200176A6176612E7574696C2E4C696E6B656448617368536574D86CD75A95DD2A1E020000787200116A6176612E7574696C2E48617368536574BA44859596B8B7340300007870770C000000043F4000000000000374000472656164740005777269746574000574727573747874000662656172657274002465356362663730302D653864642D346466632D383639352D383934613263313730626639, '2239da922a27a5086d14241d9018f14d', null, 'syhgjd', 0xACED0005737200416F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F417574683241757468656E7469636174696F6EBD400B02166252130200024C000D73746F7265645265717565737474003C4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F4F4175746832526571756573743B4C00127573657241757468656E7469636174696F6E7400324C6F72672F737072696E676672616D65776F726B2F73656375726974792F636F72652F41757468656E7469636174696F6E3B787200476F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E416273747261637441757468656E7469636174696F6E546F6B656ED3AA287E6E47640E0200035A000D61757468656E746963617465644C000B617574686F7269746965737400164C6A6176612F7574696C2F436F6C6C656374696F6E3B4C000764657461696C737400124C6A6176612F6C616E672F4F626A6563743B787000737200266A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654C697374FC0F2531B5EC8E100200014C00046C6973747400104C6A6176612F7574696C2F4C6973743B7872002C6A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65436F6C6C656374696F6E19420080CB5EF71E0200014C00016371007E00047870737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A657870000000007704000000007871007E000C707372003A6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F41757468325265717565737400000000000000010200075A0008617070726F7665644C000B617574686F72697469657371007E00044C000A657874656E73696F6E7374000F4C6A6176612F7574696C2F4D61703B4C000B72656469726563745572697400124C6A6176612F6C616E672F537472696E673B4C00077265667265736874003B4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F546F6B656E526571756573743B4C000B7265736F7572636549647374000F4C6A6176612F7574696C2F5365743B4C000D726573706F6E7365547970657371007E0011787200386F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E426173655265717565737436287A3EA37169BD0200034C0008636C69656E74496471007E000F4C001172657175657374506172616D657465727371007E000E4C000573636F706571007E00117870740006737968676A64737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654D6170F1A5A8FE74F507420200014C00016D71007E000E7870737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F400000000000037708000000040000000274000A6772616E745F74797065740012636C69656E745F63726564656E7469616C73740009636C69656E745F6964740006737968676A6478737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65536574801D92D18F9B80550200007871007E0009737200176A6176612E7574696C2E4C696E6B656448617368536574D86CD75A95DD2A1E020000787200116A6176612E7574696C2E48617368536574BA44859596B8B7340300007870770C000000103F40000000000003740004726561647400057772697465740005747275737478017371007E0020770C000000103F40000000000000787371007E00173F40000000000000770800000010000000007870707371007E0020770C000000103F400000000000017400096672616D65776F726B787371007E0020770C000000103F400000000000007870, 'ed3043df4cf641f3943a046d3bea3870');
INSERT INTO `oauth_access_token` VALUES ('07c9a691b2bee46e79fab27719cd6f18', 0xACED0005737200436F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744F4175746832416363657373546F6B656E0CB29E361B24FACE0200064C00156164646974696F6E616C496E666F726D6174696F6E74000F4C6A6176612F7574696C2F4D61703B4C000A65787069726174696F6E7400104C6A6176612F7574696C2F446174653B4C000C72656672657368546F6B656E74003F4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F636F6D6D6F6E2F4F417574683252656672657368546F6B656E3B4C000573636F706574000F4C6A6176612F7574696C2F5365743B4C0009746F6B656E547970657400124C6A6176612F6C616E672F537472696E673B4C000576616C756571007E000578707372001E6A6176612E7574696C2E436F6C6C656374696F6E7324456D7074794D6170593614855ADCE7D002000078707372000E6A6176612E7574696C2E44617465686A81014B59741903000078707708000001618535EFC3787372004C6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744578706972696E674F417574683252656672657368546F6B656E2FDF47639DD0C9B70200014C000A65787069726174696F6E71007E0002787200446F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744F417574683252656672657368546F6B656E73E10E0A6354D45E0200014C000576616C756571007E0005787074002433666566303935352D643230322D343861392D396637382D3636323733616362376338347371007E0009770800000161C0E4E6CE78737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65536574801D92D18F9B80550200007872002C6A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65436F6C6C656374696F6E19420080CB5EF71E0200014C0001637400164C6A6176612F7574696C2F436F6C6C656374696F6E3B7870737200176A6176612E7574696C2E4C696E6B656448617368536574D86CD75A95DD2A1E020000787200116A6176612E7574696C2E48617368536574BA44859596B8B7340300007870770C000000103F4000000000000374000472656164740005777269746574000574727573747874000662656172657274002430643130336539642D313239362D343134652D386439652D343937386136383631353566, '23538ec77cf6086a0d84c897603904e1', 'jiedai', 'tonr', 0xACED0005737200416F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F417574683241757468656E7469636174696F6EBD400B02166252130200024C000D73746F7265645265717565737474003C4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F4F4175746832526571756573743B4C00127573657241757468656E7469636174696F6E7400324C6F72672F737072696E676672616D65776F726B2F73656375726974792F636F72652F41757468656E7469636174696F6E3B787200476F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E416273747261637441757468656E7469636174696F6E546F6B656ED3AA287E6E47640E0200035A000D61757468656E746963617465644C000B617574686F7269746965737400164C6A6176612F7574696C2F436F6C6C656374696F6E3B4C000764657461696C737400124C6A6176612F6C616E672F4F626A6563743B787000737200266A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654C697374FC0F2531B5EC8E100200014C00046C6973747400104C6A6176612F7574696C2F4C6973743B7872002C6A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65436F6C6C656374696F6E19420080CB5EF71E0200014C00016371007E00047870737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A65787000000001770400000001737200426F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E617574686F726974792E53696D706C654772616E746564417574686F7269747900000000000001A40200014C0004726F6C657400124C6A6176612F6C616E672F537472696E673B787074000541444D494E7871007E000C707372003A6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F41757468325265717565737400000000000000010200075A0008617070726F7665644C000B617574686F72697469657371007E00044C000A657874656E73696F6E7374000F4C6A6176612F7574696C2F4D61703B4C000B726564697265637455726971007E000E4C00077265667265736874003B4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F546F6B656E526571756573743B4C000B7265736F7572636549647374000F4C6A6176612F7574696C2F5365743B4C000D726573706F6E7365547970657371007E0014787200386F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E426173655265717565737436287A3EA37169BD0200034C0008636C69656E74496471007E000E4C001172657175657374506172616D657465727371007E00124C000573636F706571007E00147870740004746F6E72737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654D6170F1A5A8FE74F507420200014C00016D71007E00127870737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F400000000000067708000000080000000374000A6772616E745F7479706574000870617373776F7264740009636C69656E745F6964740004746F6E72740008757365726E616D657400066A696564616978737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65536574801D92D18F9B80550200007871007E0009737200176A6176612E7574696C2E4C696E6B656448617368536574D86CD75A95DD2A1E020000787200116A6176612E7574696C2E48617368536574BA44859596B8B7340300007870770C000000103F40000000000003740004726561647400057772697465740005747275737478017371007E0025770C000000103F40000000000000787371007E001A3F40000000000000770800000010000000007870707371007E0025770C000000103F400000000000017400096672616D65776F726B787371007E0025770C000000103F40000000000000787372004F6F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E557365726E616D6550617373776F726441757468656E7469636174696F6E546F6B656E00000000000001A40200024C000B63726564656E7469616C7371007E00054C00097072696E636970616C71007E00057871007E0003017371007E00077371007E000B0000000177040000000171007E000F7871007E0032737200176A6176612E7574696C2E4C696E6B6564486173684D617034C04E5C106CC0FB0200015A000B6163636573734F726465727871007E001A3F400000000000067708000000080000000474000D636C69656E745F73656372657474000673656372657471007E001C71007E001D71007E001E71007E001F71007E002071007E0021780070737200326F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E7573657264657461696C732E5573657200000000000001A40200075A00116163636F756E744E6F6E457870697265645A00106163636F756E744E6F6E4C6F636B65645A001563726564656E7469616C734E6F6E457870697265645A0007656E61626C65644C000B617574686F72697469657371007E00144C000870617373776F726471007E000E4C0008757365726E616D6571007E000E7870010101017371007E0022737200116A6176612E7574696C2E54726565536574DD98509395ED875B0300007870737200466F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E7573657264657461696C732E5573657224417574686F72697479436F6D70617261746F7200000000000001A4020000787077040000000171007E000F787071007E0021, '2d736f9b35afa4f36bcf9ff6f064c1b0');
INSERT INTO `oauth_access_token` VALUES ('e5de2432315eac2883cd3b8aa774b0e5', 0xACED0005737200436F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744F4175746832416363657373546F6B656E0CB29E361B24FACE0200064C00156164646974696F6E616C496E666F726D6174696F6E74000F4C6A6176612F7574696C2F4D61703B4C000A65787069726174696F6E7400104C6A6176612F7574696C2F446174653B4C000C72656672657368546F6B656E74003F4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F636F6D6D6F6E2F4F417574683252656672657368546F6B656E3B4C000573636F706574000F4C6A6176612F7574696C2F5365743B4C0009746F6B656E547970657400124C6A6176612F6C616E672F537472696E673B4C000576616C756571007E000578707372001E6A6176612E7574696C2E436F6C6C656374696F6E7324456D7074794D6170593614855ADCE7D002000078707372000E6A6176612E7574696C2E44617465686A81014B597419030000787077080000015ED4048D1F7870737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65536574801D92D18F9B80550200007872002C6A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65436F6C6C656374696F6E19420080CB5EF71E0200014C0001637400164C6A6176612F7574696C2F436F6C6C656374696F6E3B7870737200176A6176612E7574696C2E4C696E6B656448617368536574D86CD75A95DD2A1E020000787200116A6176612E7574696C2E48617368536574BA44859596B8B7340300007870770C000000043F400000000000027400047265616474000577726974657874000662656172657274002463323538393233392D313635662D343130342D613534392D356635326133353238313339, '2ca14d222efe51873ce379f5f5b68670', null, 'tonr', 0xACED0005737200416F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F417574683241757468656E7469636174696F6EBD400B02166252130200024C000D73746F7265645265717565737474003C4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F4F4175746832526571756573743B4C00127573657241757468656E7469636174696F6E7400324C6F72672F737072696E676672616D65776F726B2F73656375726974792F636F72652F41757468656E7469636174696F6E3B787200476F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E416273747261637441757468656E7469636174696F6E546F6B656ED3AA287E6E47640E0200035A000D61757468656E746963617465644C000B617574686F7269746965737400164C6A6176612F7574696C2F436F6C6C656374696F6E3B4C000764657461696C737400124C6A6176612F6C616E672F4F626A6563743B787000737200266A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654C697374FC0F2531B5EC8E100200014C00046C6973747400104C6A6176612F7574696C2F4C6973743B7872002C6A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65436F6C6C656374696F6E19420080CB5EF71E0200014C00016371007E00047870737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A657870000000007704000000007871007E000C707372003A6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F41757468325265717565737400000000000000010200075A0008617070726F7665644C000B617574686F72697469657371007E00044C000A657874656E73696F6E7374000F4C6A6176612F7574696C2F4D61703B4C000B72656469726563745572697400124C6A6176612F6C616E672F537472696E673B4C00077265667265736874003B4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F546F6B656E526571756573743B4C000B7265736F7572636549647374000F4C6A6176612F7574696C2F5365743B4C000D726573706F6E7365547970657371007E0011787200386F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E426173655265717565737436287A3EA37169BD0200034C0008636C69656E74496471007E000F4C001172657175657374506172616D657465727371007E000E4C000573636F706571007E00117870740004746F6E72737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654D6170F1A5A8FE74F507420200014C00016D71007E000E7870737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F400000000000037708000000040000000274000A6772616E745F74797065740012636C69656E745F63726564656E7469616C7374000573636F706574000A7265616420777269746578737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65536574801D92D18F9B80550200007871007E0009737200176A6176612E7574696C2E4C696E6B656448617368536574D86CD75A95DD2A1E020000787200116A6176612E7574696C2E48617368536574BA44859596B8B7340300007870770C000000103F4000000000000274000472656164740005777269746578017371007E0020770C000000103F40000000000000787371007E00173F40000000000000770800000010000000007870707371007E0020770C000000103F400000000000017400096672616D65776F726B787371007E0020770C000000103F400000000000007870, null);
INSERT INTO `oauth_access_token` VALUES ('896340ba51f3c71522fbac0b37299246', 0xACED0005737200436F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744F4175746832416363657373546F6B656E0CB29E361B24FACE0200064C00156164646974696F6E616C496E666F726D6174696F6E74000F4C6A6176612F7574696C2F4D61703B4C000A65787069726174696F6E7400104C6A6176612F7574696C2F446174653B4C000C72656672657368546F6B656E74003F4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F636F6D6D6F6E2F4F417574683252656672657368546F6B656E3B4C000573636F706574000F4C6A6176612F7574696C2F5365743B4C0009746F6B656E547970657400124C6A6176612F6C616E672F537472696E673B4C000576616C756571007E000578707372001E6A6176612E7574696C2E436F6C6C656374696F6E7324456D7074794D6170593614855ADCE7D002000078707372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000163CAD81073787372004C6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744578706972696E674F417574683252656672657368546F6B656E2FDF47639DD0C9B70200014C000A65787069726174696F6E71007E0002787200446F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744F417574683252656672657368546F6B656E73E10E0A6354D45E0200014C000576616C756571007E0005787074002433363239633134612D383465302D343664652D626338312D3835333439336235643138617371007E000977080000016441479D8778737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65536574801D92D18F9B80550200007872002C6A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65436F6C6C656374696F6E19420080CB5EF71E0200014C0001637400164C6A6176612F7574696C2F436F6C6C656374696F6E3B7870737200176A6176612E7574696C2E4C696E6B656448617368536574D86CD75A95DD2A1E020000787200116A6176612E7574696C2E48617368536574BA44859596B8B7340300007870770C000000043F4000000000000374000472656164740005777269746574000574727573747874000662656172657274002462626465376438302D343838632D343236612D613439612D633139333431343831346637, '3b81d145452f5592e6af39f632f56690', 'admin', 'tonr', 0xACED0005737200416F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F417574683241757468656E7469636174696F6EBD400B02166252130200024C000D73746F7265645265717565737474003C4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F4F4175746832526571756573743B4C00127573657241757468656E7469636174696F6E7400324C6F72672F737072696E676672616D65776F726B2F73656375726974792F636F72652F41757468656E7469636174696F6E3B787200476F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E416273747261637441757468656E7469636174696F6E546F6B656ED3AA287E6E47640E0200035A000D61757468656E746963617465644C000B617574686F7269746965737400164C6A6176612F7574696C2F436F6C6C656374696F6E3B4C000764657461696C737400124C6A6176612F6C616E672F4F626A6563743B787000737200266A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654C697374FC0F2531B5EC8E100200014C00046C6973747400104C6A6176612F7574696C2F4C6973743B7872002C6A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65436F6C6C656374696F6E19420080CB5EF71E0200014C00016371007E00047870737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A65787000000001770400000001737200426F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E617574686F726974792E53696D706C654772616E746564417574686F7269747900000000000001A40200014C0004726F6C657400124C6A6176612F6C616E672F537472696E673B787074000541444D494E7871007E000C707372003A6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F41757468325265717565737400000000000000010200075A0008617070726F7665644C000B617574686F72697469657371007E00044C000A657874656E73696F6E7374000F4C6A6176612F7574696C2F4D61703B4C000B726564697265637455726971007E000E4C00077265667265736874003B4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F546F6B656E526571756573743B4C000B7265736F7572636549647374000F4C6A6176612F7574696C2F5365743B4C000D726573706F6E7365547970657371007E0014787200386F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E426173655265717565737436287A3EA37169BD0200034C0008636C69656E74496471007E000E4C001172657175657374506172616D657465727371007E00124C000573636F706571007E00147870740004746F6E72737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654D6170F1A5A8FE74F507420200014C00016D71007E00127870737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F400000000000067708000000080000000374000A6772616E745F7479706574000870617373776F7264740009636C69656E745F6964740004746F6E72740008757365726E616D6574000561646D696E78737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65536574801D92D18F9B80550200007871007E0009737200176A6176612E7574696C2E4C696E6B656448617368536574D86CD75A95DD2A1E020000787200116A6176612E7574696C2E48617368536574BA44859596B8B7340300007870770C000000103F40000000000003740004726561647400057772697465740005747275737478017371007E0025770C000000103F40000000000000787371007E001A3F40000000000000770800000010000000007870707371007E0025770C000000103F400000000000017400096672616D65776F726B787371007E0025770C000000103F40000000000000787372004F6F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E557365726E616D6550617373776F726441757468656E7469636174696F6E546F6B656E00000000000001A40200024C000B63726564656E7469616C7371007E00054C00097072696E636970616C71007E00057871007E0003017371007E00077371007E000B0000000177040000000171007E000F7871007E0032737200176A6176612E7574696C2E4C696E6B6564486173684D617034C04E5C106CC0FB0200015A000B6163636573734F726465727871007E001A3F400000000000067708000000080000000474000D636C69656E745F73656372657474000673656372657471007E001C71007E001D71007E001E71007E001F71007E002071007E0021780070737200326F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E7573657264657461696C732E5573657200000000000001A40200075A00116163636F756E744E6F6E457870697265645A00106163636F756E744E6F6E4C6F636B65645A001563726564656E7469616C734E6F6E457870697265645A0007656E61626C65644C000B617574686F72697469657371007E00144C000870617373776F726471007E000E4C0008757365726E616D6571007E000E7870010101017371007E0022737200116A6176612E7574696C2E54726565536574DD98509395ED875B0300007870737200466F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E7573657264657461696C732E5573657224417574686F72697479436F6D70617261746F7200000000000001A4020000787077040000000171007E000F787071007E0021, 'ccccfe5219daa41c9afb3f68a8062eb1');
INSERT INTO `oauth_access_token` VALUES ('f6220d36e03e80a58616761afc918bed', 0xACED0005737200436F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744F4175746832416363657373546F6B656E0CB29E361B24FACE0200064C00156164646974696F6E616C496E666F726D6174696F6E74000F4C6A6176612F7574696C2F4D61703B4C000A65787069726174696F6E7400104C6A6176612F7574696C2F446174653B4C000C72656672657368546F6B656E74003F4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F636F6D6D6F6E2F4F417574683252656672657368546F6B656E3B4C000573636F706574000F4C6A6176612F7574696C2F5365743B4C0009746F6B656E547970657400124C6A6176612F6C616E672F537472696E673B4C000576616C756571007E000578707372001E6A6176612E7574696C2E436F6C6C656374696F6E7324456D7074794D6170593614855ADCE7D002000078707372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000161C2F87531787372004C6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744578706972696E674F417574683252656672657368546F6B656E2FDF47639DD0C9B70200014C000A65787069726174696F6E71007E0002787200446F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744F417574683252656672657368546F6B656E73E10E0A6354D45E0200014C000576616C756571007E0005787074002466363638383831382D633930332D343565612D616234642D6233326130336435316565307371007E000977080000016223B7037E78737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65536574801D92D18F9B80550200007872002C6A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65436F6C6C656374696F6E19420080CB5EF71E0200014C0001637400164C6A6176612F7574696C2F436F6C6C656374696F6E3B7870737200176A6176612E7574696C2E4C696E6B656448617368536574D86CD75A95DD2A1E020000787200116A6176612E7574696C2E48617368536574BA44859596B8B7340300007870770C000000043F4000000000000374000472656164740005777269746574000574727573747874000662656172657274002464663063643762312D373564302D343661352D383533372D643038636631646664316365, '937d17c81cdfe31546ff986c1770f0cd', 'kuguan', 'tonr', 0xACED0005737200416F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F417574683241757468656E7469636174696F6EBD400B02166252130200024C000D73746F7265645265717565737474003C4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F4F4175746832526571756573743B4C00127573657241757468656E7469636174696F6E7400324C6F72672F737072696E676672616D65776F726B2F73656375726974792F636F72652F41757468656E7469636174696F6E3B787200476F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E416273747261637441757468656E7469636174696F6E546F6B656ED3AA287E6E47640E0200035A000D61757468656E746963617465644C000B617574686F7269746965737400164C6A6176612F7574696C2F436F6C6C656374696F6E3B4C000764657461696C737400124C6A6176612F6C616E672F4F626A6563743B787000737200266A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654C697374FC0F2531B5EC8E100200014C00046C6973747400104C6A6176612F7574696C2F4C6973743B7872002C6A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65436F6C6C656374696F6E19420080CB5EF71E0200014C00016371007E00047870737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A65787000000001770400000001737200426F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E617574686F726974792E53696D706C654772616E746564417574686F7269747900000000000001A40200014C0004726F6C657400124C6A6176612F6C616E672F537472696E673B787074000541444D494E7871007E000C707372003A6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F41757468325265717565737400000000000000010200075A0008617070726F7665644C000B617574686F72697469657371007E00044C000A657874656E73696F6E7374000F4C6A6176612F7574696C2F4D61703B4C000B726564697265637455726971007E000E4C00077265667265736874003B4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F546F6B656E526571756573743B4C000B7265736F7572636549647374000F4C6A6176612F7574696C2F5365743B4C000D726573706F6E7365547970657371007E0014787200386F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E426173655265717565737436287A3EA37169BD0200034C0008636C69656E74496471007E000E4C001172657175657374506172616D657465727371007E00124C000573636F706571007E00147870740004746F6E72737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654D6170F1A5A8FE74F507420200014C00016D71007E00127870737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F400000000000067708000000080000000374000A6772616E745F7479706574000870617373776F7264740009636C69656E745F6964740004746F6E72740008757365726E616D657400066B756775616E78737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65536574801D92D18F9B80550200007871007E0009737200176A6176612E7574696C2E4C696E6B656448617368536574D86CD75A95DD2A1E020000787200116A6176612E7574696C2E48617368536574BA44859596B8B7340300007870770C000000103F40000000000003740004726561647400057772697465740005747275737478017371007E0025770C000000103F40000000000000787371007E001A3F40000000000000770800000010000000007870707371007E0025770C000000103F400000000000017400096672616D65776F726B787371007E0025770C000000103F40000000000000787372004F6F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E557365726E616D6550617373776F726441757468656E7469636174696F6E546F6B656E00000000000001A40200024C000B63726564656E7469616C7371007E00054C00097072696E636970616C71007E00057871007E0003017371007E00077371007E000B0000000177040000000171007E000F7871007E0032737200176A6176612E7574696C2E4C696E6B6564486173684D617034C04E5C106CC0FB0200015A000B6163636573734F726465727871007E001A3F400000000000067708000000080000000474000D636C69656E745F73656372657474000673656372657471007E001C71007E001D71007E001E71007E001F71007E002071007E0021780070737200326F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E7573657264657461696C732E5573657200000000000001A40200075A00116163636F756E744E6F6E457870697265645A00106163636F756E744E6F6E4C6F636B65645A001563726564656E7469616C734E6F6E457870697265645A0007656E61626C65644C000B617574686F72697469657371007E00144C000870617373776F726471007E000E4C0008757365726E616D6571007E000E7870010101017371007E0022737200116A6176612E7574696C2E54726565536574DD98509395ED875B0300007870737200466F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E7573657264657461696C732E5573657224417574686F72697479436F6D70617261746F7200000000000001A4020000787077040000000171007E000F787071007E0021, '20fa7bd0da504c59d34678debf9a8f06');
INSERT INTO `oauth_access_token` VALUES ('5524d240d3369e59b792f53c33e642c4', 0xACED0005737200436F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744F4175746832416363657373546F6B656E0CB29E361B24FACE0200064C00156164646974696F6E616C496E666F726D6174696F6E74000F4C6A6176612F7574696C2F4D61703B4C000A65787069726174696F6E7400104C6A6176612F7574696C2F446174653B4C000C72656672657368546F6B656E74003F4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F636F6D6D6F6E2F4F417574683252656672657368546F6B656E3B4C000573636F706574000F4C6A6176612F7574696C2F5365743B4C0009746F6B656E547970657400124C6A6176612F6C616E672F537472696E673B4C000576616C756571007E000578707372001E6A6176612E7574696C2E436F6C6C656374696F6E7324456D7074794D6170593614855ADCE7D002000078707372000E6A6176612E7574696C2E44617465686A81014B59741903000078707708000001616719F926787372004C6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744578706972696E674F417574683252656672657368546F6B656E2FDF47639DD0C9B70200014C000A65787069726174696F6E71007E0002787200446F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744F417574683252656672657368546F6B656E73E10E0A6354D45E0200014C000576616C756571007E0005787074002465653830623137332D373032622D343534392D383166642D3065653837633137616438637371007E0009770800000161FF05932678737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65536574801D92D18F9B80550200007872002C6A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65436F6C6C656374696F6E19420080CB5EF71E0200014C0001637400164C6A6176612F7574696C2F436F6C6C656374696F6E3B7870737200176A6176612E7574696C2E4C696E6B656448617368536574D86CD75A95DD2A1E020000787200116A6176612E7574696C2E48617368536574BA44859596B8B7340300007870770C000000103F4000000000000374000472656164740005777269746574000574727573747874000662656172657274002433663233353264612D333533372D343963642D613233652D313138373835353465353865, 'a332ec7ccd1dd8819161d91c60aea61f', null, 'tonr', 0xACED0005737200416F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F417574683241757468656E7469636174696F6EBD400B02166252130200024C000D73746F7265645265717565737474003C4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F4F4175746832526571756573743B4C00127573657241757468656E7469636174696F6E7400324C6F72672F737072696E676672616D65776F726B2F73656375726974792F636F72652F41757468656E7469636174696F6E3B787200476F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E416273747261637441757468656E7469636174696F6E546F6B656ED3AA287E6E47640E0200035A000D61757468656E746963617465644C000B617574686F7269746965737400164C6A6176612F7574696C2F436F6C6C656374696F6E3B4C000764657461696C737400124C6A6176612F6C616E672F4F626A6563743B787000737200266A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654C697374FC0F2531B5EC8E100200014C00046C6973747400104C6A6176612F7574696C2F4C6973743B7872002C6A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65436F6C6C656374696F6E19420080CB5EF71E0200014C00016371007E00047870737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A657870000000007704000000007871007E000C707372003A6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F41757468325265717565737400000000000000010200075A0008617070726F7665644C000B617574686F72697469657371007E00044C000A657874656E73696F6E7374000F4C6A6176612F7574696C2F4D61703B4C000B72656469726563745572697400124C6A6176612F6C616E672F537472696E673B4C00077265667265736874003B4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F546F6B656E526571756573743B4C000B7265736F7572636549647374000F4C6A6176612F7574696C2F5365743B4C000D726573706F6E7365547970657371007E0011787200386F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E426173655265717565737436287A3EA37169BD0200034C0008636C69656E74496471007E000F4C001172657175657374506172616D657465727371007E000E4C000573636F706571007E00117870740004746F6E72737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654D6170F1A5A8FE74F507420200014C00016D71007E000E7870737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F400000000000037708000000040000000274000A6772616E745F74797065740012636C69656E745F63726564656E7469616C73740009636C69656E745F6964740004746F6E7278737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65536574801D92D18F9B80550200007871007E0009737200176A6176612E7574696C2E4C696E6B656448617368536574D86CD75A95DD2A1E020000787200116A6176612E7574696C2E48617368536574BA44859596B8B7340300007870770C000000103F40000000000003740004726561647400057772697465740005747275737478017371007E0020770C000000103F40000000000000787371007E00173F40000000000000770800000010000000007870707371007E0020770C000000103F400000000000017400096672616D65776F726B787371007E0020770C000000103F400000000000007870, 'e97c61db9616907014d08b3fad27297a');
INSERT INTO `oauth_access_token` VALUES ('13bd237aa936ab477f4697d86196ce1d', 0xACED0005737200436F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744F4175746832416363657373546F6B656E0CB29E361B24FACE0200064C00156164646974696F6E616C496E666F726D6174696F6E74000F4C6A6176612F7574696C2F4D61703B4C000A65787069726174696F6E7400104C6A6176612F7574696C2F446174653B4C000C72656672657368546F6B656E74003F4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F636F6D6D6F6E2F4F417574683252656672657368546F6B656E3B4C000573636F706574000F4C6A6176612F7574696C2F5365743B4C0009746F6B656E547970657400124C6A6176612F6C616E672F537472696E673B4C000576616C756571007E000578707372001E6A6176612E7574696C2E436F6C6C656374696F6E7324456D7074794D6170593614855ADCE7D002000078707372000E6A6176612E7574696C2E44617465686A81014B59741903000078707708000001616BB2457E787372004C6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744578706972696E674F417574683252656672657368546F6B656E2FDF47639DD0C9B70200014C000A65787069726174696F6E71007E0002787200446F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744F417574683252656672657368546F6B656E73E10E0A6354D45E0200014C000576616C756571007E0005787074002430633566636262302D393465392D343936322D623539612D3066343733616339636134357371007E0009770800000162039DDF7E78737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65536574801D92D18F9B80550200007872002C6A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65436F6C6C656374696F6E19420080CB5EF71E0200014C0001637400164C6A6176612F7574696C2F436F6C6C656374696F6E3B7870737200176A6176612E7574696C2E4C696E6B656448617368536574D86CD75A95DD2A1E020000787200116A6176612E7574696C2E48617368536574BA44859596B8B7340300007870770C000000043F4000000000000374000472656164740005777269746574000574727573747874000662656172657274002439616463653933322D313162312D343331392D386663392D373834383066626639626533, 'd6bd452a82f834f5164243cd3fea6d8a', '18640019220', 'tonr', 0xACED0005737200416F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F417574683241757468656E7469636174696F6EBD400B02166252130200024C000D73746F7265645265717565737474003C4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F4F4175746832526571756573743B4C00127573657241757468656E7469636174696F6E7400324C6F72672F737072696E676672616D65776F726B2F73656375726974792F636F72652F41757468656E7469636174696F6E3B787200476F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E416273747261637441757468656E7469636174696F6E546F6B656ED3AA287E6E47640E0200035A000D61757468656E746963617465644C000B617574686F7269746965737400164C6A6176612F7574696C2F436F6C6C656374696F6E3B4C000764657461696C737400124C6A6176612F6C616E672F4F626A6563743B787000737200266A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654C697374FC0F2531B5EC8E100200014C00046C6973747400104C6A6176612F7574696C2F4C6973743B7872002C6A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65436F6C6C656374696F6E19420080CB5EF71E0200014C00016371007E00047870737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A65787000000001770400000001737200426F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E617574686F726974792E53696D706C654772616E746564417574686F7269747900000000000001A40200014C0004726F6C657400124C6A6176612F6C616E672F537472696E673B78707400064D454D4245527871007E000C707372003A6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F41757468325265717565737400000000000000010200075A0008617070726F7665644C000B617574686F72697469657371007E00044C000A657874656E73696F6E7374000F4C6A6176612F7574696C2F4D61703B4C000B726564697265637455726971007E000E4C00077265667265736874003B4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F546F6B656E526571756573743B4C000B7265736F7572636549647374000F4C6A6176612F7574696C2F5365743B4C000D726573706F6E7365547970657371007E0014787200386F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E426173655265717565737436287A3EA37169BD0200034C0008636C69656E74496471007E000E4C001172657175657374506172616D657465727371007E00124C000573636F706571007E00147870740004746F6E72737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654D6170F1A5A8FE74F507420200014C00016D71007E00127870737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F400000000000067708000000080000000374000A6772616E745F7479706574000870617373776F7264740009636C69656E745F6964740004746F6E72740008757365726E616D6574000B313836343030313932323078737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65536574801D92D18F9B80550200007871007E0009737200176A6176612E7574696C2E4C696E6B656448617368536574D86CD75A95DD2A1E020000787200116A6176612E7574696C2E48617368536574BA44859596B8B7340300007870770C000000103F40000000000003740004726561647400057772697465740005747275737478017371007E0025770C000000103F40000000000000787371007E001A3F40000000000000770800000010000000007870707371007E0025770C000000103F400000000000017400096672616D65776F726B787371007E0025770C000000103F40000000000000787372004F6F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E557365726E616D6550617373776F726441757468656E7469636174696F6E546F6B656E00000000000001A40200024C000B63726564656E7469616C7371007E00054C00097072696E636970616C71007E00057871007E0003017371007E00077371007E000B0000000177040000000171007E000F7871007E0032737200176A6176612E7574696C2E4C696E6B6564486173684D617034C04E5C106CC0FB0200015A000B6163636573734F726465727871007E001A3F400000000000067708000000080000000474000D636C69656E745F73656372657474000673656372657471007E001C71007E001D71007E001E71007E001F71007E002071007E0021780070737200326F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E7573657264657461696C732E5573657200000000000001A40200075A00116163636F756E744E6F6E457870697265645A00106163636F756E744E6F6E4C6F636B65645A001563726564656E7469616C734E6F6E457870697265645A0007656E61626C65644C000B617574686F72697469657371007E00144C000870617373776F726471007E000E4C0008757365726E616D6571007E000E7870010101017371007E0022737200116A6176612E7574696C2E54726565536574DD98509395ED875B0300007870737200466F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E7573657264657461696C732E5573657224417574686F72697479436F6D70617261746F7200000000000001A4020000787077040000000171007E000F787071007E0021, '3826380741175bad0fd00f1db3d8feee');
INSERT INTO `oauth_access_token` VALUES ('81452911be5949cb92856426569d13e6', 0xACED0005737200436F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744F4175746832416363657373546F6B656E0CB29E361B24FACE0200064C00156164646974696F6E616C496E666F726D6174696F6E74000F4C6A6176612F7574696C2F4D61703B4C000A65787069726174696F6E7400104C6A6176612F7574696C2F446174653B4C000C72656672657368546F6B656E74003F4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F636F6D6D6F6E2F4F417574683252656672657368546F6B656E3B4C000573636F706574000F4C6A6176612F7574696C2F5365743B4C0009746F6B656E547970657400124C6A6176612F6C616E672F537472696E673B4C000576616C756571007E000578707372001E6A6176612E7574696C2E436F6C6C656374696F6E7324456D7074794D6170593614855ADCE7D002000078707372000E6A6176612E7574696C2E44617465686A81014B597419030000787077080000016156A5C2CC787372004C6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744578706972696E674F417574683252656672657368546F6B656E2FDF47639DD0C9B70200014C000A65787069726174696F6E71007E0002787200446F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744F417574683252656672657368546F6B656E73E10E0A6354D45E0200014C000576616C756571007E0005787074002433393662663061662D383532652D346661362D623164642D3065373038323030346530357371007E0009770800000161EE915CCC78737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65536574801D92D18F9B80550200007872002C6A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65436F6C6C656374696F6E19420080CB5EF71E0200014C0001637400164C6A6176612F7574696C2F436F6C6C656374696F6E3B7870737200176A6176612E7574696C2E4C696E6B656448617368536574D86CD75A95DD2A1E020000787200116A6176612E7574696C2E48617368536574BA44859596B8B7340300007870770C000000103F4000000000000374000472656164740005777269746574000574727573747874000662656172657274002464313365666364632D316463622D346664392D386463372D663962643735363763333365, 'db1b4be2361605d385939dd1c302ad25', '18519537641', 'tonr', 0xACED0005737200416F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F417574683241757468656E7469636174696F6EBD400B02166252130200024C000D73746F7265645265717565737474003C4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F4F4175746832526571756573743B4C00127573657241757468656E7469636174696F6E7400324C6F72672F737072696E676672616D65776F726B2F73656375726974792F636F72652F41757468656E7469636174696F6E3B787200476F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E416273747261637441757468656E7469636174696F6E546F6B656ED3AA287E6E47640E0200035A000D61757468656E746963617465644C000B617574686F7269746965737400164C6A6176612F7574696C2F436F6C6C656374696F6E3B4C000764657461696C737400124C6A6176612F6C616E672F4F626A6563743B787000737200266A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654C697374FC0F2531B5EC8E100200014C00046C6973747400104C6A6176612F7574696C2F4C6973743B7872002C6A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65436F6C6C656374696F6E19420080CB5EF71E0200014C00016371007E00047870737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A65787000000001770400000001737200426F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E617574686F726974792E53696D706C654772616E746564417574686F7269747900000000000001A40200014C0004726F6C657400124C6A6176612F6C616E672F537472696E673B78707400064D454D4245527871007E000C707372003A6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F41757468325265717565737400000000000000010200075A0008617070726F7665644C000B617574686F72697469657371007E00044C000A657874656E73696F6E7374000F4C6A6176612F7574696C2F4D61703B4C000B726564697265637455726971007E000E4C00077265667265736874003B4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F546F6B656E526571756573743B4C000B7265736F7572636549647374000F4C6A6176612F7574696C2F5365743B4C000D726573706F6E7365547970657371007E0014787200386F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E426173655265717565737436287A3EA37169BD0200034C0008636C69656E74496471007E000E4C001172657175657374506172616D657465727371007E00124C000573636F706571007E00147870740004746F6E72737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654D6170F1A5A8FE74F507420200014C00016D71007E00127870737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F400000000000067708000000080000000374000A6772616E745F7479706574000870617373776F7264740009636C69656E745F6964740004746F6E72740008757365726E616D6574000B313835313935333736343178737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65536574801D92D18F9B80550200007871007E0009737200176A6176612E7574696C2E4C696E6B656448617368536574D86CD75A95DD2A1E020000787200116A6176612E7574696C2E48617368536574BA44859596B8B7340300007870770C000000103F40000000000003740004726561647400057772697465740005747275737478017371007E0025770C000000103F40000000000000787371007E001A3F40000000000000770800000010000000007870707371007E0025770C000000103F400000000000017400096672616D65776F726B787371007E0025770C000000103F40000000000000787372004F6F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E557365726E616D6550617373776F726441757468656E7469636174696F6E546F6B656E00000000000001A40200024C000B63726564656E7469616C7371007E00054C00097072696E636970616C71007E00057871007E0003017371007E00077371007E000B0000000177040000000171007E000F7871007E0032737200176A6176612E7574696C2E4C696E6B6564486173684D617034C04E5C106CC0FB0200015A000B6163636573734F726465727871007E001A3F400000000000067708000000080000000474000D636C69656E745F73656372657474000673656372657471007E001C71007E001D71007E001E71007E001F71007E002071007E0021780070737200326F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E7573657264657461696C732E5573657200000000000001A40200075A00116163636F756E744E6F6E457870697265645A00106163636F756E744E6F6E4C6F636B65645A001563726564656E7469616C734E6F6E457870697265645A0007656E61626C65644C000B617574686F72697469657371007E00144C000870617373776F726471007E000E4C0008757365726E616D6571007E000E7870010101017371007E0022737200116A6176612E7574696C2E54726565536574DD98509395ED875B0300007870737200466F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E7573657264657461696C732E5573657224417574686F72697479436F6D70617261746F7200000000000001A4020000787077040000000171007E000F787071007E0021, '769dc1832a39419410e20cf9b72b662c');
INSERT INTO `oauth_access_token` VALUES ('146a7432634dadca97d21747b18d9be4', 0xACED0005737200436F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744F4175746832416363657373546F6B656E0CB29E361B24FACE0200064C00156164646974696F6E616C496E666F726D6174696F6E74000F4C6A6176612F7574696C2F4D61703B4C000A65787069726174696F6E7400104C6A6176612F7574696C2F446174653B4C000C72656672657368546F6B656E74003F4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F636F6D6D6F6E2F4F417574683252656672657368546F6B656E3B4C000573636F706574000F4C6A6176612F7574696C2F5365743B4C0009746F6B656E547970657400124C6A6176612F6C616E672F537472696E673B4C000576616C756571007E000578707372001E6A6176612E7574696C2E436F6C6C656374696F6E7324456D7074794D6170593614855ADCE7D002000078707372000E6A6176612E7574696C2E44617465686A81014B59741903000078707708000001604728A23F787372004C6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744578706972696E674F417574683252656672657368546F6B656E2FDF47639DD0C9B70200014C000A65787069726174696F6E71007E0002787200446F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744F417574683252656672657368546F6B656E73E10E0A6354D45E0200014C000576616C756571007E0005787074002431626137633061382D303834332D346262352D383331632D6464616235346332343164317371007E0009770800000160DF143C3F78737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65536574801D92D18F9B80550200007872002C6A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65436F6C6C656374696F6E19420080CB5EF71E0200014C0001637400164C6A6176612F7574696C2F436F6C6C656374696F6E3B7870737200176A6176612E7574696C2E4C696E6B656448617368536574D86CD75A95DD2A1E020000787200116A6176612E7574696C2E48617368536574BA44859596B8B7340300007870770C000000103F4000000000000374000472656164740005777269746574000574727573747874000662656172657274002438353935646630332D653235342D343566362D623936352D313336643933326266356266, 'e1c5a9b1fce23179c383dc020a2153ec', '18640019221', 'tonr', 0xACED0005737200416F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F417574683241757468656E7469636174696F6EBD400B02166252130200024C000D73746F7265645265717565737474003C4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F4F4175746832526571756573743B4C00127573657241757468656E7469636174696F6E7400324C6F72672F737072696E676672616D65776F726B2F73656375726974792F636F72652F41757468656E7469636174696F6E3B787200476F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E416273747261637441757468656E7469636174696F6E546F6B656ED3AA287E6E47640E0200035A000D61757468656E746963617465644C000B617574686F7269746965737400164C6A6176612F7574696C2F436F6C6C656374696F6E3B4C000764657461696C737400124C6A6176612F6C616E672F4F626A6563743B787000737200266A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654C697374FC0F2531B5EC8E100200014C00046C6973747400104C6A6176612F7574696C2F4C6973743B7872002C6A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65436F6C6C656374696F6E19420080CB5EF71E0200014C00016371007E00047870737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A65787000000001770400000001737200426F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E617574686F726974792E53696D706C654772616E746564417574686F7269747900000000000001A40200014C0004726F6C657400124C6A6176612F6C616E672F537472696E673B78707400064D454D4245527871007E000C707372003A6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F41757468325265717565737400000000000000010200075A0008617070726F7665644C000B617574686F72697469657371007E00044C000A657874656E73696F6E7374000F4C6A6176612F7574696C2F4D61703B4C000B726564697265637455726971007E000E4C00077265667265736874003B4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F546F6B656E526571756573743B4C000B7265736F7572636549647374000F4C6A6176612F7574696C2F5365743B4C000D726573706F6E7365547970657371007E0014787200386F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E426173655265717565737436287A3EA37169BD0200034C0008636C69656E74496471007E000E4C001172657175657374506172616D657465727371007E00124C000573636F706571007E00147870740004746F6E72737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654D6170F1A5A8FE74F507420200014C00016D71007E00127870737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F400000000000067708000000080000000374000A6772616E745F7479706574000870617373776F7264740009636C69656E745F6964740004746F6E72740008757365726E616D6574000B313836343030313932323178737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65536574801D92D18F9B80550200007871007E0009737200176A6176612E7574696C2E4C696E6B656448617368536574D86CD75A95DD2A1E020000787200116A6176612E7574696C2E48617368536574BA44859596B8B7340300007870770C000000103F40000000000003740004726561647400057772697465740005747275737478017371007E0025770C000000103F40000000000000787371007E001A3F40000000000000770800000010000000007870707371007E0025770C000000103F400000000000017400096672616D65776F726B787371007E0025770C000000103F40000000000000787372004F6F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E557365726E616D6550617373776F726441757468656E7469636174696F6E546F6B656E00000000000001A40200024C000B63726564656E7469616C7371007E00054C00097072696E636970616C71007E00057871007E0003017371007E00077371007E000B0000000177040000000171007E000F7871007E0032737200176A6176612E7574696C2E4C696E6B6564486173684D617034C04E5C106CC0FB0200015A000B6163636573734F726465727871007E001A3F400000000000067708000000080000000474000D636C69656E745F73656372657474000673656372657471007E001C71007E001D71007E001E71007E001F71007E002071007E0021780070737200326F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E7573657264657461696C732E5573657200000000000001A40200075A00116163636F756E744E6F6E457870697265645A00106163636F756E744E6F6E4C6F636B65645A001563726564656E7469616C734E6F6E457870697265645A0007656E61626C65644C000B617574686F72697469657371007E00144C000870617373776F726471007E000E4C0008757365726E616D6571007E000E7870010101017371007E0022737200116A6176612E7574696C2E54726565536574DD98509395ED875B0300007870737200466F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E7573657264657461696C732E5573657224417574686F72697479436F6D70617261746F7200000000000001A4020000787077040000000171007E000F787071007E0021, 'f610b6223995fca565a14f64a8f24798');
INSERT INTO `oauth_access_token` VALUES ('8be38e72b8cd88059d0f243f439d24dc', 0xACED0005737200436F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744F4175746832416363657373546F6B656E0CB29E361B24FACE0200064C00156164646974696F6E616C496E666F726D6174696F6E74000F4C6A6176612F7574696C2F4D61703B4C000A65787069726174696F6E7400104C6A6176612F7574696C2F446174653B4C000C72656672657368546F6B656E74003F4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F636F6D6D6F6E2F4F417574683252656672657368546F6B656E3B4C000573636F706574000F4C6A6176612F7574696C2F5365743B4C0009746F6B656E547970657400124C6A6176612F6C616E672F537472696E673B4C000576616C756571007E000578707372001E6A6176612E7574696C2E436F6C6C656374696F6E7324456D7074794D6170593614855ADCE7D002000078707372000E6A6176612E7574696C2E44617465686A81014B597419030000787077080000015F72D95668787372004C6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744578706972696E674F417574683252656672657368546F6B656E2FDF47639DD0C9B70200014C000A65787069726174696F6E71007E0002787200446F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744F417574683252656672657368546F6B656E73E10E0A6354D45E0200014C000576616C756571007E0005787074002436303362303763662D633735662D346335312D396131612D3366656437643039616434627371007E00097708000001600AC4F06878737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65536574801D92D18F9B80550200007872002C6A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65436F6C6C656374696F6E19420080CB5EF71E0200014C0001637400164C6A6176612F7574696C2F436F6C6C656374696F6E3B7870737200176A6176612E7574696C2E4C696E6B656448617368536574D86CD75A95DD2A1E020000787200116A6176612E7574696C2E48617368536574BA44859596B8B7340300007870770C000000103F4000000000000374000472656164740005777269746574000574727573747874000662656172657274002463336664633138352D323763342D343333352D623161362D306663303336396534303230, 'e45b204730007e2d0b6d4ed06e37406e', '18802482337', 'tonr', 0xACED0005737200416F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F417574683241757468656E7469636174696F6EBD400B02166252130200024C000D73746F7265645265717565737474003C4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F4F4175746832526571756573743B4C00127573657241757468656E7469636174696F6E7400324C6F72672F737072696E676672616D65776F726B2F73656375726974792F636F72652F41757468656E7469636174696F6E3B787200476F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E416273747261637441757468656E7469636174696F6E546F6B656ED3AA287E6E47640E0200035A000D61757468656E746963617465644C000B617574686F7269746965737400164C6A6176612F7574696C2F436F6C6C656374696F6E3B4C000764657461696C737400124C6A6176612F6C616E672F4F626A6563743B787000737200266A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654C697374FC0F2531B5EC8E100200014C00046C6973747400104C6A6176612F7574696C2F4C6973743B7872002C6A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65436F6C6C656374696F6E19420080CB5EF71E0200014C00016371007E00047870737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A65787000000001770400000001737200426F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E617574686F726974792E53696D706C654772616E746564417574686F7269747900000000000001A40200014C0004726F6C657400124C6A6176612F6C616E672F537472696E673B78707400064D454D4245527871007E000C707372003A6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F41757468325265717565737400000000000000010200075A0008617070726F7665644C000B617574686F72697469657371007E00044C000A657874656E73696F6E7374000F4C6A6176612F7574696C2F4D61703B4C000B726564697265637455726971007E000E4C00077265667265736874003B4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F546F6B656E526571756573743B4C000B7265736F7572636549647374000F4C6A6176612F7574696C2F5365743B4C000D726573706F6E7365547970657371007E0014787200386F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E426173655265717565737436287A3EA37169BD0200034C0008636C69656E74496471007E000E4C001172657175657374506172616D657465727371007E00124C000573636F706571007E00147870740004746F6E72737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654D6170F1A5A8FE74F507420200014C00016D71007E00127870737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F400000000000067708000000080000000374000A6772616E745F7479706574000870617373776F7264740009636C69656E745F6964740004746F6E72740008757365726E616D6574000B313838303234383233333778737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65536574801D92D18F9B80550200007871007E0009737200176A6176612E7574696C2E4C696E6B656448617368536574D86CD75A95DD2A1E020000787200116A6176612E7574696C2E48617368536574BA44859596B8B7340300007870770C000000103F40000000000003740004726561647400057772697465740005747275737478017371007E0025770C000000103F40000000000000787371007E001A3F40000000000000770800000010000000007870707371007E0025770C000000103F400000000000017400096672616D65776F726B787371007E0025770C000000103F40000000000000787372004F6F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E557365726E616D6550617373776F726441757468656E7469636174696F6E546F6B656E00000000000001A40200024C000B63726564656E7469616C7371007E00054C00097072696E636970616C71007E00057871007E0003017371007E00077371007E000B0000000177040000000171007E000F7871007E0032737200176A6176612E7574696C2E4C696E6B6564486173684D617034C04E5C106CC0FB0200015A000B6163636573734F726465727871007E001A3F400000000000067708000000080000000474000D636C69656E745F73656372657474000673656372657471007E001C71007E001D71007E001E71007E001F71007E002071007E0021780070737200326F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E7573657264657461696C732E5573657200000000000001A40200075A00116163636F756E744E6F6E457870697265645A00106163636F756E744E6F6E4C6F636B65645A001563726564656E7469616C734E6F6E457870697265645A0007656E61626C65644C000B617574686F72697469657371007E00144C000870617373776F726471007E000E4C0008757365726E616D6571007E000E7870010101017371007E0022737200116A6176612E7574696C2E54726565536574DD98509395ED875B0300007870737200466F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E7573657264657461696C732E5573657224417574686F72697479436F6D70617261746F7200000000000001A4020000787077040000000171007E000F787071007E0021, 'b235589a66d953d730a32ff8526a066b');

-- ----------------------------
-- Table structure for `oauth_approvals`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_approvals`;
CREATE TABLE `oauth_approvals` (
  `userId` varchar(256) DEFAULT NULL,
  `clientId` varchar(256) DEFAULT NULL,
  `scope` varchar(256) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `expiresAt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `lastModifiedAt` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of oauth_approvals
-- ----------------------------

-- ----------------------------
-- Table structure for `oauth_client_details`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
  `client_id` varchar(128) NOT NULL,
  `resource_ids` varchar(256) DEFAULT NULL,
  `client_secret` varchar(256) DEFAULT NULL,
  `scope` varchar(256) DEFAULT NULL,
  `authorized_grant_types` varchar(256) DEFAULT NULL,
  `web_server_redirect_uri` varchar(256) DEFAULT NULL,
  `authorities` varchar(256) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(4096) DEFAULT NULL,
  `autoapprove` varchar(256) DEFAULT NULL,
  `id` varchar(36) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `logically_deleted` bit(1) DEFAULT NULL,
  `sort_number` int(11) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `create_user_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`client_id`),
  UNIQUE KEY `UK_3my6lp6ttga6hhwtsutscqset` (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
INSERT INTO `oauth_client_details` VALUES ('syhgjd', 'framework', 'P@ssWord!$', 'read,write,trust', 'password,refresh_token,client_credentials', null, null, null, null, null, null, '402881d16052ab4e016052b7e2de0000', null, '', '0', null, '沈阳惠工街店', null);
INSERT INTO `oauth_client_details` VALUES ('syshjd', 'framework', 'P@ssWord@#', 'read,write,trust', 'password,refresh_token,client_credentials', null, null, null, null, null, null, '402881d1608b32fd01608b838e330003', null, '', '0', null, '沈阳沈河街店', null);
INSERT INTO `oauth_client_details` VALUES ('tonr', 'framework', 'secret', 'read,write,trust', 'password,refresh_token,client_credentials', '', '', null, null, null, '', '1', null, '', '0', null, '会员管理系统', null);

-- ----------------------------
-- Table structure for `oauth_client_token`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_token`;
CREATE TABLE `oauth_client_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication_id` varchar(128) NOT NULL,
  `user_name` varchar(256) DEFAULT NULL,
  `client_id` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`authentication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of oauth_client_token
-- ----------------------------

-- ----------------------------
-- Table structure for `oauth_code`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_code`;
CREATE TABLE `oauth_code` (
  `code` varchar(256) DEFAULT NULL,
  `authentication` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of oauth_code
-- ----------------------------

-- ----------------------------
-- Table structure for `oauth_refresh_token`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_refresh_token`;
CREATE TABLE `oauth_refresh_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of oauth_refresh_token
-- ----------------------------
INSERT INTO `oauth_refresh_token` VALUES ('533a6b4dedf107ca1079fb67999fad29', 0xACED00057372004C6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744578706972696E674F417574683252656672657368546F6B656E2FDF47639DD0C9B70200014C000A65787069726174696F6E7400104C6A6176612F7574696C2F446174653B787200446F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744F417574683252656672657368546F6B656E73E10E0A6354D45E0200014C000576616C75657400124C6A6176612F6C616E672F537472696E673B787074002461636438623030612D623431632D343361312D393334392D6531623262633434653232347372000E6A6176612E7574696C2E44617465686A81014B597419030000787077080000015F9BB2B65C78, 0xACED0005737200416F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F417574683241757468656E7469636174696F6EBD400B02166252130200024C000D73746F7265645265717565737474003C4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F4F4175746832526571756573743B4C00127573657241757468656E7469636174696F6E7400324C6F72672F737072696E676672616D65776F726B2F73656375726974792F636F72652F41757468656E7469636174696F6E3B787200476F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E416273747261637441757468656E7469636174696F6E546F6B656ED3AA287E6E47640E0200035A000D61757468656E746963617465644C000B617574686F7269746965737400164C6A6176612F7574696C2F436F6C6C656374696F6E3B4C000764657461696C737400124C6A6176612F6C616E672F4F626A6563743B787000737200266A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654C697374FC0F2531B5EC8E100200014C00046C6973747400104C6A6176612F7574696C2F4C6973743B7872002C6A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65436F6C6C656374696F6E19420080CB5EF71E0200014C00016371007E00047870737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A65787000000001770400000001737200426F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E617574686F726974792E53696D706C654772616E746564417574686F7269747900000000000001A40200014C0004726F6C657400124C6A6176612F6C616E672F537472696E673B787074000541444D494E7871007E000C707372003A6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F41757468325265717565737400000000000000010200075A0008617070726F7665644C000B617574686F72697469657371007E00044C000A657874656E73696F6E7374000F4C6A6176612F7574696C2F4D61703B4C000B726564697265637455726971007E000E4C00077265667265736874003B4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F546F6B656E526571756573743B4C000B7265736F7572636549647374000F4C6A6176612F7574696C2F5365743B4C000D726573706F6E7365547970657371007E0014787200386F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E426173655265717565737436287A3EA37169BD0200034C0008636C69656E74496471007E000E4C001172657175657374506172616D657465727371007E00124C000573636F706571007E00147870740004746F6E72737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654D6170F1A5A8FE74F507420200014C00016D71007E00127870737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F400000000000067708000000080000000374000A6772616E745F7479706574000870617373776F7264740009636C69656E745F6964740004746F6E72740008757365726E616D6574000561646D696E78737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65536574801D92D18F9B80550200007871007E0009737200176A6176612E7574696C2E4C696E6B656448617368536574D86CD75A95DD2A1E020000787200116A6176612E7574696C2E48617368536574BA44859596B8B7340300007870770C000000103F40000000000003740004726561647400057772697465740005747275737478017371007E0025770C000000103F40000000000000787371007E001A3F40000000000000770800000010000000007870707371007E0025770C000000103F400000000000017400096672616D65776F726B787371007E0025770C000000103F40000000000000787372004F6F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E557365726E616D6550617373776F726441757468656E7469636174696F6E546F6B656E00000000000001A40200024C000B63726564656E7469616C7371007E00054C00097072696E636970616C71007E00057871007E0003017371007E00077371007E000B0000000177040000000171007E000F7871007E0032737200176A6176612E7574696C2E4C696E6B6564486173684D617034C04E5C106CC0FB0200015A000B6163636573734F726465727871007E001A3F400000000000067708000000080000000474000D636C69656E745F73656372657474000673656372657471007E001C71007E001D71007E001E71007E001F71007E002071007E0021780070737200326F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E7573657264657461696C732E5573657200000000000001A40200075A00116163636F756E744E6F6E457870697265645A00106163636F756E744E6F6E4C6F636B65645A001563726564656E7469616C734E6F6E457870697265645A0007656E61626C65644C000B617574686F72697469657371007E00144C000870617373776F726471007E000E4C0008757365726E616D6571007E000E7870010101017371007E0022737200116A6176612E7574696C2E54726565536574DD98509395ED875B0300007870737200466F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E7573657264657461696C732E5573657224417574686F72697479436F6D70617261746F7200000000000001A4020000787077040000000171007E000F787071007E0021);
INSERT INTO `oauth_refresh_token` VALUES ('b235589a66d953d730a32ff8526a066b', 0xACED00057372004C6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744578706972696E674F417574683252656672657368546F6B656E2FDF47639DD0C9B70200014C000A65787069726174696F6E7400104C6A6176612F7574696C2F446174653B787200446F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744F417574683252656672657368546F6B656E73E10E0A6354D45E0200014C000576616C75657400124C6A6176612F6C616E672F537472696E673B787074002436303362303763662D633735662D346335312D396131612D3366656437643039616434627372000E6A6176612E7574696C2E44617465686A81014B59741903000078707708000001600AC4F06878, 0xACED0005737200416F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F417574683241757468656E7469636174696F6EBD400B02166252130200024C000D73746F7265645265717565737474003C4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F4F4175746832526571756573743B4C00127573657241757468656E7469636174696F6E7400324C6F72672F737072696E676672616D65776F726B2F73656375726974792F636F72652F41757468656E7469636174696F6E3B787200476F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E416273747261637441757468656E7469636174696F6E546F6B656ED3AA287E6E47640E0200035A000D61757468656E746963617465644C000B617574686F7269746965737400164C6A6176612F7574696C2F436F6C6C656374696F6E3B4C000764657461696C737400124C6A6176612F6C616E672F4F626A6563743B787000737200266A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654C697374FC0F2531B5EC8E100200014C00046C6973747400104C6A6176612F7574696C2F4C6973743B7872002C6A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65436F6C6C656374696F6E19420080CB5EF71E0200014C00016371007E00047870737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A65787000000001770400000001737200426F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E617574686F726974792E53696D706C654772616E746564417574686F7269747900000000000001A40200014C0004726F6C657400124C6A6176612F6C616E672F537472696E673B78707400064D454D4245527871007E000C707372003A6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F41757468325265717565737400000000000000010200075A0008617070726F7665644C000B617574686F72697469657371007E00044C000A657874656E73696F6E7374000F4C6A6176612F7574696C2F4D61703B4C000B726564697265637455726971007E000E4C00077265667265736874003B4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F546F6B656E526571756573743B4C000B7265736F7572636549647374000F4C6A6176612F7574696C2F5365743B4C000D726573706F6E7365547970657371007E0014787200386F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E426173655265717565737436287A3EA37169BD0200034C0008636C69656E74496471007E000E4C001172657175657374506172616D657465727371007E00124C000573636F706571007E00147870740004746F6E72737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654D6170F1A5A8FE74F507420200014C00016D71007E00127870737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F400000000000067708000000080000000374000A6772616E745F7479706574000870617373776F7264740009636C69656E745F6964740004746F6E72740008757365726E616D6574000B313838303234383233333778737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65536574801D92D18F9B80550200007871007E0009737200176A6176612E7574696C2E4C696E6B656448617368536574D86CD75A95DD2A1E020000787200116A6176612E7574696C2E48617368536574BA44859596B8B7340300007870770C000000103F40000000000003740004726561647400057772697465740005747275737478017371007E0025770C000000103F40000000000000787371007E001A3F40000000000000770800000010000000007870707371007E0025770C000000103F400000000000017400096672616D65776F726B787371007E0025770C000000103F40000000000000787372004F6F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E557365726E616D6550617373776F726441757468656E7469636174696F6E546F6B656E00000000000001A40200024C000B63726564656E7469616C7371007E00054C00097072696E636970616C71007E00057871007E0003017371007E00077371007E000B0000000177040000000171007E000F7871007E0032737200176A6176612E7574696C2E4C696E6B6564486173684D617034C04E5C106CC0FB0200015A000B6163636573734F726465727871007E001A3F400000000000067708000000080000000474000D636C69656E745F73656372657474000673656372657471007E001C71007E001D71007E001E71007E001F71007E002071007E0021780070737200326F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E7573657264657461696C732E5573657200000000000001A40200075A00116163636F756E744E6F6E457870697265645A00106163636F756E744E6F6E4C6F636B65645A001563726564656E7469616C734E6F6E457870697265645A0007656E61626C65644C000B617574686F72697469657371007E00144C000870617373776F726471007E000E4C0008757365726E616D6571007E000E7870010101017371007E0022737200116A6176612E7574696C2E54726565536574DD98509395ED875B0300007870737200466F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E7573657264657461696C732E5573657224417574686F72697479436F6D70617261746F7200000000000001A4020000787077040000000171007E000F787071007E0021);
INSERT INTO `oauth_refresh_token` VALUES ('f610b6223995fca565a14f64a8f24798', 0xACED00057372004C6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744578706972696E674F417574683252656672657368546F6B656E2FDF47639DD0C9B70200014C000A65787069726174696F6E7400104C6A6176612F7574696C2F446174653B787200446F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744F417574683252656672657368546F6B656E73E10E0A6354D45E0200014C000576616C75657400124C6A6176612F6C616E672F537472696E673B787074002431626137633061382D303834332D346262352D383331632D6464616235346332343164317372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000160DF143C3F78, 0xACED0005737200416F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F417574683241757468656E7469636174696F6EBD400B02166252130200024C000D73746F7265645265717565737474003C4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F4F4175746832526571756573743B4C00127573657241757468656E7469636174696F6E7400324C6F72672F737072696E676672616D65776F726B2F73656375726974792F636F72652F41757468656E7469636174696F6E3B787200476F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E416273747261637441757468656E7469636174696F6E546F6B656ED3AA287E6E47640E0200035A000D61757468656E746963617465644C000B617574686F7269746965737400164C6A6176612F7574696C2F436F6C6C656374696F6E3B4C000764657461696C737400124C6A6176612F6C616E672F4F626A6563743B787000737200266A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654C697374FC0F2531B5EC8E100200014C00046C6973747400104C6A6176612F7574696C2F4C6973743B7872002C6A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65436F6C6C656374696F6E19420080CB5EF71E0200014C00016371007E00047870737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A65787000000001770400000001737200426F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E617574686F726974792E53696D706C654772616E746564417574686F7269747900000000000001A40200014C0004726F6C657400124C6A6176612F6C616E672F537472696E673B78707400064D454D4245527871007E000C707372003A6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F41757468325265717565737400000000000000010200075A0008617070726F7665644C000B617574686F72697469657371007E00044C000A657874656E73696F6E7374000F4C6A6176612F7574696C2F4D61703B4C000B726564697265637455726971007E000E4C00077265667265736874003B4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F546F6B656E526571756573743B4C000B7265736F7572636549647374000F4C6A6176612F7574696C2F5365743B4C000D726573706F6E7365547970657371007E0014787200386F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E426173655265717565737436287A3EA37169BD0200034C0008636C69656E74496471007E000E4C001172657175657374506172616D657465727371007E00124C000573636F706571007E00147870740004746F6E72737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654D6170F1A5A8FE74F507420200014C00016D71007E00127870737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F400000000000067708000000080000000374000A6772616E745F7479706574000870617373776F7264740009636C69656E745F6964740004746F6E72740008757365726E616D6574000B313836343030313932323178737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65536574801D92D18F9B80550200007871007E0009737200176A6176612E7574696C2E4C696E6B656448617368536574D86CD75A95DD2A1E020000787200116A6176612E7574696C2E48617368536574BA44859596B8B7340300007870770C000000103F40000000000003740004726561647400057772697465740005747275737478017371007E0025770C000000103F40000000000000787371007E001A3F40000000000000770800000010000000007870707371007E0025770C000000103F400000000000017400096672616D65776F726B787371007E0025770C000000103F40000000000000787372004F6F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E557365726E616D6550617373776F726441757468656E7469636174696F6E546F6B656E00000000000001A40200024C000B63726564656E7469616C7371007E00054C00097072696E636970616C71007E00057871007E0003017371007E00077371007E000B0000000177040000000171007E000F7871007E0032737200176A6176612E7574696C2E4C696E6B6564486173684D617034C04E5C106CC0FB0200015A000B6163636573734F726465727871007E001A3F400000000000067708000000080000000474000D636C69656E745F73656372657474000673656372657471007E001C71007E001D71007E001E71007E001F71007E002071007E0021780070737200326F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E7573657264657461696C732E5573657200000000000001A40200075A00116163636F756E744E6F6E457870697265645A00106163636F756E744E6F6E4C6F636B65645A001563726564656E7469616C734E6F6E457870697265645A0007656E61626C65644C000B617574686F72697469657371007E00144C000870617373776F726471007E000E4C0008757365726E616D6571007E000E7870010101017371007E0022737200116A6176612E7574696C2E54726565536574DD98509395ED875B0300007870737200466F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E7573657264657461696C732E5573657224417574686F72697479436F6D70617261746F7200000000000001A4020000787077040000000171007E000F787071007E0021);
INSERT INTO `oauth_refresh_token` VALUES ('ed3043df4cf641f3943a046d3bea3870', 0xACED00057372004C6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744578706972696E674F417574683252656672657368546F6B656E2FDF47639DD0C9B70200014C000A65787069726174696F6E7400104C6A6176612F7574696C2F446174653B787200446F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744F417574683252656672657368546F6B656E73E10E0A6354D45E0200014C000576616C75657400124C6A6176612F6C616E672F537472696E673B787074002439383735376131662D316131372D343533662D613630382D3337343064303564643138617372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000161DF44D91D78, 0xACED0005737200416F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F417574683241757468656E7469636174696F6EBD400B02166252130200024C000D73746F7265645265717565737474003C4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F4F4175746832526571756573743B4C00127573657241757468656E7469636174696F6E7400324C6F72672F737072696E676672616D65776F726B2F73656375726974792F636F72652F41757468656E7469636174696F6E3B787200476F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E416273747261637441757468656E7469636174696F6E546F6B656ED3AA287E6E47640E0200035A000D61757468656E746963617465644C000B617574686F7269746965737400164C6A6176612F7574696C2F436F6C6C656374696F6E3B4C000764657461696C737400124C6A6176612F6C616E672F4F626A6563743B787000737200266A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654C697374FC0F2531B5EC8E100200014C00046C6973747400104C6A6176612F7574696C2F4C6973743B7872002C6A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65436F6C6C656374696F6E19420080CB5EF71E0200014C00016371007E00047870737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A657870000000007704000000007871007E000C707372003A6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F41757468325265717565737400000000000000010200075A0008617070726F7665644C000B617574686F72697469657371007E00044C000A657874656E73696F6E7374000F4C6A6176612F7574696C2F4D61703B4C000B72656469726563745572697400124C6A6176612F6C616E672F537472696E673B4C00077265667265736874003B4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F546F6B656E526571756573743B4C000B7265736F7572636549647374000F4C6A6176612F7574696C2F5365743B4C000D726573706F6E7365547970657371007E0011787200386F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E426173655265717565737436287A3EA37169BD0200034C0008636C69656E74496471007E000F4C001172657175657374506172616D657465727371007E000E4C000573636F706571007E00117870740006737968676A64737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654D6170F1A5A8FE74F507420200014C00016D71007E000E7870737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F400000000000037708000000040000000274000A6772616E745F74797065740012636C69656E745F63726564656E7469616C73740009636C69656E745F6964740006737968676A6478737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65536574801D92D18F9B80550200007871007E0009737200176A6176612E7574696C2E4C696E6B656448617368536574D86CD75A95DD2A1E020000787200116A6176612E7574696C2E48617368536574BA44859596B8B7340300007870770C000000103F40000000000003740004726561647400057772697465740005747275737478017371007E0020770C000000103F40000000000000787371007E00173F40000000000000770800000010000000007870707371007E0020770C000000103F400000000000017400096672616D65776F726B787371007E0020770C000000103F400000000000007870);
INSERT INTO `oauth_refresh_token` VALUES ('769dc1832a39419410e20cf9b72b662c', 0xACED00057372004C6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744578706972696E674F417574683252656672657368546F6B656E2FDF47639DD0C9B70200014C000A65787069726174696F6E7400104C6A6176612F7574696C2F446174653B787200446F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744F417574683252656672657368546F6B656E73E10E0A6354D45E0200014C000576616C75657400124C6A6176612F6C616E672F537472696E673B787074002433393662663061662D383532652D346661362D623164642D3065373038323030346530357372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000161EE915CCC78, 0xACED0005737200416F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F417574683241757468656E7469636174696F6EBD400B02166252130200024C000D73746F7265645265717565737474003C4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F4F4175746832526571756573743B4C00127573657241757468656E7469636174696F6E7400324C6F72672F737072696E676672616D65776F726B2F73656375726974792F636F72652F41757468656E7469636174696F6E3B787200476F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E416273747261637441757468656E7469636174696F6E546F6B656ED3AA287E6E47640E0200035A000D61757468656E746963617465644C000B617574686F7269746965737400164C6A6176612F7574696C2F436F6C6C656374696F6E3B4C000764657461696C737400124C6A6176612F6C616E672F4F626A6563743B787000737200266A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654C697374FC0F2531B5EC8E100200014C00046C6973747400104C6A6176612F7574696C2F4C6973743B7872002C6A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65436F6C6C656374696F6E19420080CB5EF71E0200014C00016371007E00047870737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A65787000000001770400000001737200426F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E617574686F726974792E53696D706C654772616E746564417574686F7269747900000000000001A40200014C0004726F6C657400124C6A6176612F6C616E672F537472696E673B78707400064D454D4245527871007E000C707372003A6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F41757468325265717565737400000000000000010200075A0008617070726F7665644C000B617574686F72697469657371007E00044C000A657874656E73696F6E7374000F4C6A6176612F7574696C2F4D61703B4C000B726564697265637455726971007E000E4C00077265667265736874003B4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F546F6B656E526571756573743B4C000B7265736F7572636549647374000F4C6A6176612F7574696C2F5365743B4C000D726573706F6E7365547970657371007E0014787200386F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E426173655265717565737436287A3EA37169BD0200034C0008636C69656E74496471007E000E4C001172657175657374506172616D657465727371007E00124C000573636F706571007E00147870740004746F6E72737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654D6170F1A5A8FE74F507420200014C00016D71007E00127870737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F400000000000067708000000080000000374000A6772616E745F7479706574000870617373776F7264740009636C69656E745F6964740004746F6E72740008757365726E616D6574000B313835313935333736343178737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65536574801D92D18F9B80550200007871007E0009737200176A6176612E7574696C2E4C696E6B656448617368536574D86CD75A95DD2A1E020000787200116A6176612E7574696C2E48617368536574BA44859596B8B7340300007870770C000000103F40000000000003740004726561647400057772697465740005747275737478017371007E0025770C000000103F40000000000000787371007E001A3F40000000000000770800000010000000007870707371007E0025770C000000103F400000000000017400096672616D65776F726B787371007E0025770C000000103F40000000000000787372004F6F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E557365726E616D6550617373776F726441757468656E7469636174696F6E546F6B656E00000000000001A40200024C000B63726564656E7469616C7371007E00054C00097072696E636970616C71007E00057871007E0003017371007E00077371007E000B0000000177040000000171007E000F7871007E0032737200176A6176612E7574696C2E4C696E6B6564486173684D617034C04E5C106CC0FB0200015A000B6163636573734F726465727871007E001A3F400000000000067708000000080000000474000D636C69656E745F73656372657474000673656372657471007E001C71007E001D71007E001E71007E001F71007E002071007E0021780070737200326F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E7573657264657461696C732E5573657200000000000001A40200075A00116163636F756E744E6F6E457870697265645A00106163636F756E744E6F6E4C6F636B65645A001563726564656E7469616C734E6F6E457870697265645A0007656E61626C65644C000B617574686F72697469657371007E00144C000870617373776F726471007E000E4C0008757365726E616D6571007E000E7870010101017371007E0022737200116A6176612E7574696C2E54726565536574DD98509395ED875B0300007870737200466F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E7573657264657461696C732E5573657224417574686F72697479436F6D70617261746F7200000000000001A4020000787077040000000171007E000F787071007E0021);
INSERT INTO `oauth_refresh_token` VALUES ('e97c61db9616907014d08b3fad27297a', 0xACED00057372004C6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744578706972696E674F417574683252656672657368546F6B656E2FDF47639DD0C9B70200014C000A65787069726174696F6E7400104C6A6176612F7574696C2F446174653B787200446F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744F417574683252656672657368546F6B656E73E10E0A6354D45E0200014C000576616C75657400124C6A6176612F6C616E672F537472696E673B787074002465653830623137332D373032622D343534392D383166642D3065653837633137616438637372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000161FF05932678, 0xACED0005737200416F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F417574683241757468656E7469636174696F6EBD400B02166252130200024C000D73746F7265645265717565737474003C4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F4F4175746832526571756573743B4C00127573657241757468656E7469636174696F6E7400324C6F72672F737072696E676672616D65776F726B2F73656375726974792F636F72652F41757468656E7469636174696F6E3B787200476F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E416273747261637441757468656E7469636174696F6E546F6B656ED3AA287E6E47640E0200035A000D61757468656E746963617465644C000B617574686F7269746965737400164C6A6176612F7574696C2F436F6C6C656374696F6E3B4C000764657461696C737400124C6A6176612F6C616E672F4F626A6563743B787000737200266A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654C697374FC0F2531B5EC8E100200014C00046C6973747400104C6A6176612F7574696C2F4C6973743B7872002C6A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65436F6C6C656374696F6E19420080CB5EF71E0200014C00016371007E00047870737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A657870000000007704000000007871007E000C707372003A6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F41757468325265717565737400000000000000010200075A0008617070726F7665644C000B617574686F72697469657371007E00044C000A657874656E73696F6E7374000F4C6A6176612F7574696C2F4D61703B4C000B72656469726563745572697400124C6A6176612F6C616E672F537472696E673B4C00077265667265736874003B4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F546F6B656E526571756573743B4C000B7265736F7572636549647374000F4C6A6176612F7574696C2F5365743B4C000D726573706F6E7365547970657371007E0011787200386F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E426173655265717565737436287A3EA37169BD0200034C0008636C69656E74496471007E000F4C001172657175657374506172616D657465727371007E000E4C000573636F706571007E00117870740004746F6E72737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654D6170F1A5A8FE74F507420200014C00016D71007E000E7870737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F400000000000037708000000040000000274000A6772616E745F74797065740012636C69656E745F63726564656E7469616C73740009636C69656E745F6964740004746F6E7278737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65536574801D92D18F9B80550200007871007E0009737200176A6176612E7574696C2E4C696E6B656448617368536574D86CD75A95DD2A1E020000787200116A6176612E7574696C2E48617368536574BA44859596B8B7340300007870770C000000103F40000000000003740004726561647400057772697465740005747275737478017371007E0020770C000000103F40000000000000787371007E00173F40000000000000770800000010000000007870707371007E0020770C000000103F400000000000017400096672616D65776F726B787371007E0020770C000000103F400000000000007870);
INSERT INTO `oauth_refresh_token` VALUES ('3826380741175bad0fd00f1db3d8feee', 0xACED00057372004C6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744578706972696E674F417574683252656672657368546F6B656E2FDF47639DD0C9B70200014C000A65787069726174696F6E7400104C6A6176612F7574696C2F446174653B787200446F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744F417574683252656672657368546F6B656E73E10E0A6354D45E0200014C000576616C75657400124C6A6176612F6C616E672F537472696E673B787074002430633566636262302D393465392D343936322D623539612D3066343733616339636134357372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000162039DDF7E78, 0xACED0005737200416F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F417574683241757468656E7469636174696F6EBD400B02166252130200024C000D73746F7265645265717565737474003C4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F4F4175746832526571756573743B4C00127573657241757468656E7469636174696F6E7400324C6F72672F737072696E676672616D65776F726B2F73656375726974792F636F72652F41757468656E7469636174696F6E3B787200476F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E416273747261637441757468656E7469636174696F6E546F6B656ED3AA287E6E47640E0200035A000D61757468656E746963617465644C000B617574686F7269746965737400164C6A6176612F7574696C2F436F6C6C656374696F6E3B4C000764657461696C737400124C6A6176612F6C616E672F4F626A6563743B787000737200266A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654C697374FC0F2531B5EC8E100200014C00046C6973747400104C6A6176612F7574696C2F4C6973743B7872002C6A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65436F6C6C656374696F6E19420080CB5EF71E0200014C00016371007E00047870737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A65787000000001770400000001737200426F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E617574686F726974792E53696D706C654772616E746564417574686F7269747900000000000001A40200014C0004726F6C657400124C6A6176612F6C616E672F537472696E673B78707400064D454D4245527871007E000C707372003A6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F41757468325265717565737400000000000000010200075A0008617070726F7665644C000B617574686F72697469657371007E00044C000A657874656E73696F6E7374000F4C6A6176612F7574696C2F4D61703B4C000B726564697265637455726971007E000E4C00077265667265736874003B4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F546F6B656E526571756573743B4C000B7265736F7572636549647374000F4C6A6176612F7574696C2F5365743B4C000D726573706F6E7365547970657371007E0014787200386F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E426173655265717565737436287A3EA37169BD0200034C0008636C69656E74496471007E000E4C001172657175657374506172616D657465727371007E00124C000573636F706571007E00147870740004746F6E72737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654D6170F1A5A8FE74F507420200014C00016D71007E00127870737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F400000000000067708000000080000000374000A6772616E745F7479706574000870617373776F7264740009636C69656E745F6964740004746F6E72740008757365726E616D6574000B313836343030313932323078737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65536574801D92D18F9B80550200007871007E0009737200176A6176612E7574696C2E4C696E6B656448617368536574D86CD75A95DD2A1E020000787200116A6176612E7574696C2E48617368536574BA44859596B8B7340300007870770C000000103F40000000000003740004726561647400057772697465740005747275737478017371007E0025770C000000103F40000000000000787371007E001A3F40000000000000770800000010000000007870707371007E0025770C000000103F400000000000017400096672616D65776F726B787371007E0025770C000000103F40000000000000787372004F6F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E557365726E616D6550617373776F726441757468656E7469636174696F6E546F6B656E00000000000001A40200024C000B63726564656E7469616C7371007E00054C00097072696E636970616C71007E00057871007E0003017371007E00077371007E000B0000000177040000000171007E000F7871007E0032737200176A6176612E7574696C2E4C696E6B6564486173684D617034C04E5C106CC0FB0200015A000B6163636573734F726465727871007E001A3F400000000000067708000000080000000474000D636C69656E745F73656372657474000673656372657471007E001C71007E001D71007E001E71007E001F71007E002071007E0021780070737200326F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E7573657264657461696C732E5573657200000000000001A40200075A00116163636F756E744E6F6E457870697265645A00106163636F756E744E6F6E4C6F636B65645A001563726564656E7469616C734E6F6E457870697265645A0007656E61626C65644C000B617574686F72697469657371007E00144C000870617373776F726471007E000E4C0008757365726E616D6571007E000E7870010101017371007E0022737200116A6176612E7574696C2E54726565536574DD98509395ED875B0300007870737200466F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E7573657264657461696C732E5573657224417574686F72697479436F6D70617261746F7200000000000001A4020000787077040000000171007E000F787071007E0021);
INSERT INTO `oauth_refresh_token` VALUES ('2d736f9b35afa4f36bcf9ff6f064c1b0', 0xACED00057372004C6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744578706972696E674F417574683252656672657368546F6B656E2FDF47639DD0C9B70200014C000A65787069726174696F6E7400104C6A6176612F7574696C2F446174653B787200446F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744F417574683252656672657368546F6B656E73E10E0A6354D45E0200014C000576616C75657400124C6A6176612F6C616E672F537472696E673B787074002433666566303935352D643230322D343861392D396637382D3636323733616362376338347372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000161C0E4E6CE78, 0xACED0005737200416F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F417574683241757468656E7469636174696F6EBD400B02166252130200024C000D73746F7265645265717565737474003C4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F4F4175746832526571756573743B4C00127573657241757468656E7469636174696F6E7400324C6F72672F737072696E676672616D65776F726B2F73656375726974792F636F72652F41757468656E7469636174696F6E3B787200476F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E416273747261637441757468656E7469636174696F6E546F6B656ED3AA287E6E47640E0200035A000D61757468656E746963617465644C000B617574686F7269746965737400164C6A6176612F7574696C2F436F6C6C656374696F6E3B4C000764657461696C737400124C6A6176612F6C616E672F4F626A6563743B787000737200266A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654C697374FC0F2531B5EC8E100200014C00046C6973747400104C6A6176612F7574696C2F4C6973743B7872002C6A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65436F6C6C656374696F6E19420080CB5EF71E0200014C00016371007E00047870737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A65787000000001770400000001737200426F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E617574686F726974792E53696D706C654772616E746564417574686F7269747900000000000001A40200014C0004726F6C657400124C6A6176612F6C616E672F537472696E673B787074000541444D494E7871007E000C707372003A6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F41757468325265717565737400000000000000010200075A0008617070726F7665644C000B617574686F72697469657371007E00044C000A657874656E73696F6E7374000F4C6A6176612F7574696C2F4D61703B4C000B726564697265637455726971007E000E4C00077265667265736874003B4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F546F6B656E526571756573743B4C000B7265736F7572636549647374000F4C6A6176612F7574696C2F5365743B4C000D726573706F6E7365547970657371007E0014787200386F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E426173655265717565737436287A3EA37169BD0200034C0008636C69656E74496471007E000E4C001172657175657374506172616D657465727371007E00124C000573636F706571007E00147870740004746F6E72737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654D6170F1A5A8FE74F507420200014C00016D71007E00127870737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F400000000000067708000000080000000374000A6772616E745F7479706574000870617373776F7264740009636C69656E745F6964740004746F6E72740008757365726E616D657400066A696564616978737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65536574801D92D18F9B80550200007871007E0009737200176A6176612E7574696C2E4C696E6B656448617368536574D86CD75A95DD2A1E020000787200116A6176612E7574696C2E48617368536574BA44859596B8B7340300007870770C000000103F40000000000003740004726561647400057772697465740005747275737478017371007E0025770C000000103F40000000000000787371007E001A3F40000000000000770800000010000000007870707371007E0025770C000000103F400000000000017400096672616D65776F726B787371007E0025770C000000103F40000000000000787372004F6F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E557365726E616D6550617373776F726441757468656E7469636174696F6E546F6B656E00000000000001A40200024C000B63726564656E7469616C7371007E00054C00097072696E636970616C71007E00057871007E0003017371007E00077371007E000B0000000177040000000171007E000F7871007E0032737200176A6176612E7574696C2E4C696E6B6564486173684D617034C04E5C106CC0FB0200015A000B6163636573734F726465727871007E001A3F400000000000067708000000080000000474000D636C69656E745F73656372657474000673656372657471007E001C71007E001D71007E001E71007E001F71007E002071007E0021780070737200326F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E7573657264657461696C732E5573657200000000000001A40200075A00116163636F756E744E6F6E457870697265645A00106163636F756E744E6F6E4C6F636B65645A001563726564656E7469616C734E6F6E457870697265645A0007656E61626C65644C000B617574686F72697469657371007E00144C000870617373776F726471007E000E4C0008757365726E616D6571007E000E7870010101017371007E0022737200116A6176612E7574696C2E54726565536574DD98509395ED875B0300007870737200466F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E7573657264657461696C732E5573657224417574686F72697479436F6D70617261746F7200000000000001A4020000787077040000000171007E000F787071007E0021);
INSERT INTO `oauth_refresh_token` VALUES ('c41dcc3ee980eeee35b5b7f51651bdbe', 0xACED00057372004C6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744578706972696E674F417574683252656672657368546F6B656E2FDF47639DD0C9B70200014C000A65787069726174696F6E7400104C6A6176612F7574696C2F446174653B787200446F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744F417574683252656672657368546F6B656E73E10E0A6354D45E0200014C000576616C75657400124C6A6176612F6C616E672F537472696E673B787074002439366561616433632D303034372D343337662D393937362D3263626663363963636663627372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000161C13E12C878, 0xACED0005737200416F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F417574683241757468656E7469636174696F6EBD400B02166252130200024C000D73746F7265645265717565737474003C4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F4F4175746832526571756573743B4C00127573657241757468656E7469636174696F6E7400324C6F72672F737072696E676672616D65776F726B2F73656375726974792F636F72652F41757468656E7469636174696F6E3B787200476F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E416273747261637441757468656E7469636174696F6E546F6B656ED3AA287E6E47640E0200035A000D61757468656E746963617465644C000B617574686F7269746965737400164C6A6176612F7574696C2F436F6C6C656374696F6E3B4C000764657461696C737400124C6A6176612F6C616E672F4F626A6563743B787000737200266A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654C697374FC0F2531B5EC8E100200014C00046C6973747400104C6A6176612F7574696C2F4C6973743B7872002C6A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65436F6C6C656374696F6E19420080CB5EF71E0200014C00016371007E00047870737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A65787000000001770400000001737200426F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E617574686F726974792E53696D706C654772616E746564417574686F7269747900000000000001A40200014C0004726F6C657400124C6A6176612F6C616E672F537472696E673B787074000541444D494E7871007E000C707372003A6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F41757468325265717565737400000000000000010200075A0008617070726F7665644C000B617574686F72697469657371007E00044C000A657874656E73696F6E7374000F4C6A6176612F7574696C2F4D61703B4C000B726564697265637455726971007E000E4C00077265667265736874003B4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F546F6B656E526571756573743B4C000B7265736F7572636549647374000F4C6A6176612F7574696C2F5365743B4C000D726573706F6E7365547970657371007E0014787200386F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E426173655265717565737436287A3EA37169BD0200034C0008636C69656E74496471007E000E4C001172657175657374506172616D657465727371007E00124C000573636F706571007E00147870740004746F6E72737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654D6170F1A5A8FE74F507420200014C00016D71007E00127870737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F400000000000067708000000080000000374000A6772616E745F7479706574000870617373776F7264740009636C69656E745F6964740004746F6E72740008757365726E616D657400056A6963687578737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65536574801D92D18F9B80550200007871007E0009737200176A6176612E7574696C2E4C696E6B656448617368536574D86CD75A95DD2A1E020000787200116A6176612E7574696C2E48617368536574BA44859596B8B7340300007870770C000000103F40000000000003740004726561647400057772697465740005747275737478017371007E0025770C000000103F40000000000000787371007E001A3F40000000000000770800000010000000007870707371007E0025770C000000103F400000000000017400096672616D65776F726B787371007E0025770C000000103F40000000000000787372004F6F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E557365726E616D6550617373776F726441757468656E7469636174696F6E546F6B656E00000000000001A40200024C000B63726564656E7469616C7371007E00054C00097072696E636970616C71007E00057871007E0003017371007E00077371007E000B0000000177040000000171007E000F7871007E0032737200176A6176612E7574696C2E4C696E6B6564486173684D617034C04E5C106CC0FB0200015A000B6163636573734F726465727871007E001A3F400000000000067708000000080000000474000D636C69656E745F73656372657474000673656372657471007E001C71007E001D71007E001E71007E001F71007E002071007E0021780070737200326F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E7573657264657461696C732E5573657200000000000001A40200075A00116163636F756E744E6F6E457870697265645A00106163636F756E744E6F6E4C6F636B65645A001563726564656E7469616C734E6F6E457870697265645A0007656E61626C65644C000B617574686F72697469657371007E00144C000870617373776F726471007E000E4C0008757365726E616D6571007E000E7870010101017371007E0022737200116A6176612E7574696C2E54726565536574DD98509395ED875B0300007870737200466F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E7573657264657461696C732E5573657224417574686F72697479436F6D70617261746F7200000000000001A4020000787077040000000171007E000F787071007E0021);
INSERT INTO `oauth_refresh_token` VALUES ('20fa7bd0da504c59d34678debf9a8f06', 0xACED00057372004C6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744578706972696E674F417574683252656672657368546F6B656E2FDF47639DD0C9B70200014C000A65787069726174696F6E7400104C6A6176612F7574696C2F446174653B787200446F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744F417574683252656672657368546F6B656E73E10E0A6354D45E0200014C000576616C75657400124C6A6176612F6C616E672F537472696E673B787074002466363638383831382D633930332D343565612D616234642D6233326130336435316565307372000E6A6176612E7574696C2E44617465686A81014B597419030000787077080000016223B7037E78, 0xACED0005737200416F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F417574683241757468656E7469636174696F6EBD400B02166252130200024C000D73746F7265645265717565737474003C4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F4F4175746832526571756573743B4C00127573657241757468656E7469636174696F6E7400324C6F72672F737072696E676672616D65776F726B2F73656375726974792F636F72652F41757468656E7469636174696F6E3B787200476F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E416273747261637441757468656E7469636174696F6E546F6B656ED3AA287E6E47640E0200035A000D61757468656E746963617465644C000B617574686F7269746965737400164C6A6176612F7574696C2F436F6C6C656374696F6E3B4C000764657461696C737400124C6A6176612F6C616E672F4F626A6563743B787000737200266A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654C697374FC0F2531B5EC8E100200014C00046C6973747400104C6A6176612F7574696C2F4C6973743B7872002C6A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65436F6C6C656374696F6E19420080CB5EF71E0200014C00016371007E00047870737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A65787000000001770400000001737200426F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E617574686F726974792E53696D706C654772616E746564417574686F7269747900000000000001A40200014C0004726F6C657400124C6A6176612F6C616E672F537472696E673B787074000541444D494E7871007E000C707372003A6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F41757468325265717565737400000000000000010200075A0008617070726F7665644C000B617574686F72697469657371007E00044C000A657874656E73696F6E7374000F4C6A6176612F7574696C2F4D61703B4C000B726564697265637455726971007E000E4C00077265667265736874003B4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F546F6B656E526571756573743B4C000B7265736F7572636549647374000F4C6A6176612F7574696C2F5365743B4C000D726573706F6E7365547970657371007E0014787200386F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E426173655265717565737436287A3EA37169BD0200034C0008636C69656E74496471007E000E4C001172657175657374506172616D657465727371007E00124C000573636F706571007E00147870740004746F6E72737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654D6170F1A5A8FE74F507420200014C00016D71007E00127870737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F400000000000067708000000080000000374000A6772616E745F7479706574000870617373776F7264740009636C69656E745F6964740004746F6E72740008757365726E616D657400066B756775616E78737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65536574801D92D18F9B80550200007871007E0009737200176A6176612E7574696C2E4C696E6B656448617368536574D86CD75A95DD2A1E020000787200116A6176612E7574696C2E48617368536574BA44859596B8B7340300007870770C000000103F40000000000003740004726561647400057772697465740005747275737478017371007E0025770C000000103F40000000000000787371007E001A3F40000000000000770800000010000000007870707371007E0025770C000000103F400000000000017400096672616D65776F726B787371007E0025770C000000103F40000000000000787372004F6F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E557365726E616D6550617373776F726441757468656E7469636174696F6E546F6B656E00000000000001A40200024C000B63726564656E7469616C7371007E00054C00097072696E636970616C71007E00057871007E0003017371007E00077371007E000B0000000177040000000171007E000F7871007E0032737200176A6176612E7574696C2E4C696E6B6564486173684D617034C04E5C106CC0FB0200015A000B6163636573734F726465727871007E001A3F400000000000067708000000080000000474000D636C69656E745F73656372657474000673656372657471007E001C71007E001D71007E001E71007E001F71007E002071007E0021780070737200326F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E7573657264657461696C732E5573657200000000000001A40200075A00116163636F756E744E6F6E457870697265645A00106163636F756E744E6F6E4C6F636B65645A001563726564656E7469616C734E6F6E457870697265645A0007656E61626C65644C000B617574686F72697469657371007E00144C000870617373776F726471007E000E4C0008757365726E616D6571007E000E7870010101017371007E0022737200116A6176612E7574696C2E54726565536574DD98509395ED875B0300007870737200466F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E7573657264657461696C732E5573657224417574686F72697479436F6D70617261746F7200000000000001A4020000787077040000000171007E000F787071007E0021);
INSERT INTO `oauth_refresh_token` VALUES ('916c8862eb6d987cfd27afea4dc6ba69', 0xACED00057372004C6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744578706972696E674F417574683252656672657368546F6B656E2FDF47639DD0C9B70200014C000A65787069726174696F6E7400104C6A6176612F7574696C2F446174653B787200446F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744F417574683252656672657368546F6B656E73E10E0A6354D45E0200014C000576616C75657400124C6A6176612F6C616E672F537472696E673B787074002433316430393762322D366566332D343335382D613532382D6363643135393338663361667372000E6A6176612E7574696C2E44617465686A81014B597419030000787077080000016213E5C21178, 0xACED0005737200416F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F417574683241757468656E7469636174696F6EBD400B02166252130200024C000D73746F7265645265717565737474003C4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F4F4175746832526571756573743B4C00127573657241757468656E7469636174696F6E7400324C6F72672F737072696E676672616D65776F726B2F73656375726974792F636F72652F41757468656E7469636174696F6E3B787200476F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E416273747261637441757468656E7469636174696F6E546F6B656ED3AA287E6E47640E0200035A000D61757468656E746963617465644C000B617574686F7269746965737400164C6A6176612F7574696C2F436F6C6C656374696F6E3B4C000764657461696C737400124C6A6176612F6C616E672F4F626A6563743B787000737200266A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654C697374FC0F2531B5EC8E100200014C00046C6973747400104C6A6176612F7574696C2F4C6973743B7872002C6A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65436F6C6C656374696F6E19420080CB5EF71E0200014C00016371007E00047870737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A65787000000001770400000001737200426F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E617574686F726974792E53696D706C654772616E746564417574686F7269747900000000000001A40200014C0004726F6C657400124C6A6176612F6C616E672F537472696E673B787074000541444D494E7871007E000C707372003A6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F41757468325265717565737400000000000000010200075A0008617070726F7665644C000B617574686F72697469657371007E00044C000A657874656E73696F6E7374000F4C6A6176612F7574696C2F4D61703B4C000B726564697265637455726971007E000E4C00077265667265736874003B4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F546F6B656E526571756573743B4C000B7265736F7572636549647374000F4C6A6176612F7574696C2F5365743B4C000D726573706F6E7365547970657371007E0014787200386F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E426173655265717565737436287A3EA37169BD0200034C0008636C69656E74496471007E000E4C001172657175657374506172616D657465727371007E00124C000573636F706571007E00147870740004746F6E72737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654D6170F1A5A8FE74F507420200014C00016D71007E00127870737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F400000000000067708000000080000000374000A6772616E745F7479706574000870617373776F7264740009636C69656E745F6964740004746F6E72740008757365726E616D65740009676F6E677A68616E6778737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65536574801D92D18F9B80550200007871007E0009737200176A6176612E7574696C2E4C696E6B656448617368536574D86CD75A95DD2A1E020000787200116A6176612E7574696C2E48617368536574BA44859596B8B7340300007870770C000000103F40000000000003740004726561647400057772697465740005747275737478017371007E0025770C000000103F40000000000000787371007E001A3F40000000000000770800000010000000007870707371007E0025770C000000103F400000000000017400096672616D65776F726B787371007E0025770C000000103F40000000000000787372004F6F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E557365726E616D6550617373776F726441757468656E7469636174696F6E546F6B656E00000000000001A40200024C000B63726564656E7469616C7371007E00054C00097072696E636970616C71007E00057871007E0003017371007E00077371007E000B0000000177040000000171007E000F7871007E0032737200176A6176612E7574696C2E4C696E6B6564486173684D617034C04E5C106CC0FB0200015A000B6163636573734F726465727871007E001A3F400000000000067708000000080000000474000D636C69656E745F73656372657474000673656372657471007E001C71007E001D71007E001E71007E001F71007E002071007E0021780070737200326F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E7573657264657461696C732E5573657200000000000001A40200075A00116163636F756E744E6F6E457870697265645A00106163636F756E744E6F6E4C6F636B65645A001563726564656E7469616C734E6F6E457870697265645A0007656E61626C65644C000B617574686F72697469657371007E00144C000870617373776F726471007E000E4C0008757365726E616D6571007E000E7870010101017371007E0022737200116A6176612E7574696C2E54726565536574DD98509395ED875B0300007870737200466F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E7573657264657461696C732E5573657224417574686F72697479436F6D70617261746F7200000000000001A4020000787077040000000171007E000F787071007E0021);
INSERT INTO `oauth_refresh_token` VALUES ('ccccfe5219daa41c9afb3f68a8062eb1', 0xACED00057372004C6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744578706972696E674F417574683252656672657368546F6B656E2FDF47639DD0C9B70200014C000A65787069726174696F6E7400104C6A6176612F7574696C2F446174653B787200446F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744F417574683252656672657368546F6B656E73E10E0A6354D45E0200014C000576616C75657400124C6A6176612F6C616E672F537472696E673B787074002433363239633134612D383465302D343664652D626338312D3835333439336235643138617372000E6A6176612E7574696C2E44617465686A81014B597419030000787077080000016441479D8778, 0xACED0005737200416F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F417574683241757468656E7469636174696F6EBD400B02166252130200024C000D73746F7265645265717565737474003C4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F4F4175746832526571756573743B4C00127573657241757468656E7469636174696F6E7400324C6F72672F737072696E676672616D65776F726B2F73656375726974792F636F72652F41757468656E7469636174696F6E3B787200476F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E416273747261637441757468656E7469636174696F6E546F6B656ED3AA287E6E47640E0200035A000D61757468656E746963617465644C000B617574686F7269746965737400164C6A6176612F7574696C2F436F6C6C656374696F6E3B4C000764657461696C737400124C6A6176612F6C616E672F4F626A6563743B787000737200266A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654C697374FC0F2531B5EC8E100200014C00046C6973747400104C6A6176612F7574696C2F4C6973743B7872002C6A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65436F6C6C656374696F6E19420080CB5EF71E0200014C00016371007E00047870737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A65787000000001770400000001737200426F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E617574686F726974792E53696D706C654772616E746564417574686F7269747900000000000001A40200014C0004726F6C657400124C6A6176612F6C616E672F537472696E673B787074000541444D494E7871007E000C707372003A6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F41757468325265717565737400000000000000010200075A0008617070726F7665644C000B617574686F72697469657371007E00044C000A657874656E73696F6E7374000F4C6A6176612F7574696C2F4D61703B4C000B726564697265637455726971007E000E4C00077265667265736874003B4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F546F6B656E526571756573743B4C000B7265736F7572636549647374000F4C6A6176612F7574696C2F5365743B4C000D726573706F6E7365547970657371007E0014787200386F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E426173655265717565737436287A3EA37169BD0200034C0008636C69656E74496471007E000E4C001172657175657374506172616D657465727371007E00124C000573636F706571007E00147870740004746F6E72737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654D6170F1A5A8FE74F507420200014C00016D71007E00127870737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F400000000000067708000000080000000374000A6772616E745F7479706574000870617373776F7264740009636C69656E745F6964740004746F6E72740008757365726E616D6574000561646D696E78737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65536574801D92D18F9B80550200007871007E0009737200176A6176612E7574696C2E4C696E6B656448617368536574D86CD75A95DD2A1E020000787200116A6176612E7574696C2E48617368536574BA44859596B8B7340300007870770C000000103F40000000000003740004726561647400057772697465740005747275737478017371007E0025770C000000103F40000000000000787371007E001A3F40000000000000770800000010000000007870707371007E0025770C000000103F400000000000017400096672616D65776F726B787371007E0025770C000000103F40000000000000787372004F6F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E557365726E616D6550617373776F726441757468656E7469636174696F6E546F6B656E00000000000001A40200024C000B63726564656E7469616C7371007E00054C00097072696E636970616C71007E00057871007E0003017371007E00077371007E000B0000000177040000000171007E000F7871007E0032737200176A6176612E7574696C2E4C696E6B6564486173684D617034C04E5C106CC0FB0200015A000B6163636573734F726465727871007E001A3F400000000000067708000000080000000474000D636C69656E745F73656372657474000673656372657471007E001C71007E001D71007E001E71007E001F71007E002071007E0021780070737200326F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E7573657264657461696C732E5573657200000000000001A40200075A00116163636F756E744E6F6E457870697265645A00106163636F756E744E6F6E4C6F636B65645A001563726564656E7469616C734E6F6E457870697265645A0007656E61626C65644C000B617574686F72697469657371007E00144C000870617373776F726471007E000E4C0008757365726E616D6571007E000E7870010101017371007E0022737200116A6176612E7574696C2E54726565536574DD98509395ED875B0300007870737200466F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E7573657264657461696C732E5573657224417574686F72697479436F6D70617261746F7200000000000001A4020000787077040000000171007E000F787071007E0021);

-- ----------------------------
-- Table structure for `purchase_order`
-- ----------------------------
DROP TABLE IF EXISTS `purchase_order`;
CREATE TABLE `purchase_order` (
  `id` varchar(36) NOT NULL,
  `client_id` varchar(128) DEFAULT NULL,
  `create_user_id` varchar(36) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `logically_deleted` bit(1) DEFAULT NULL,
  `sort_number` int(11) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `business_related_unit_id` varchar(36) DEFAULT NULL,
  `delivery_date` datetime DEFAULT NULL,
  `operator` varchar(36) DEFAULT NULL,
  `order_number` varchar(36) DEFAULT NULL,
  `remark` varchar(500) DEFAULT NULL,
  `summary` varchar(500) DEFAULT NULL,
  `warehouse_id` varchar(36) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of purchase_order
-- ----------------------------

-- ----------------------------
-- Table structure for `purchase_order_sku`
-- ----------------------------
DROP TABLE IF EXISTS `purchase_order_sku`;
CREATE TABLE `purchase_order_sku` (
  `id` varchar(36) NOT NULL,
  `client_id` varchar(128) DEFAULT NULL,
  `create_user_id` varchar(36) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `logically_deleted` bit(1) DEFAULT NULL,
  `sort_number` int(11) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `count` double DEFAULT NULL,
  `price` double DEFAULT NULL,
  `remark` double DEFAULT NULL,
  `sku_id` varchar(36) DEFAULT NULL,
  `sum_price` double DEFAULT NULL,
  `purchase_order_id` varchar(36) DEFAULT NULL,
  `goods_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of purchase_order_sku
-- ----------------------------

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` varchar(36) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `logically_deleted` bit(1) DEFAULT NULL,
  `sort_number` int(11) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `client_id` varchar(128) DEFAULT NULL,
  `create_user_id` varchar(36) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `icon` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('402881bf628440b6016284592d7d0005', '2018-04-02 11:14:20', '', '0', '2018-04-02 11:14:20', '店长', 'tonr', '402881c45eff19a4015eff80ec080002', null, 'person');
INSERT INTO `role` VALUES ('402881bf628440b601628459468a0006', '2018-04-02 11:14:26', '', '0', '2018-04-02 11:14:26', '收银', 'tonr', '402881c45eff19a4015eff80ec080002', null, 'person');
INSERT INTO `role` VALUES ('402881c45effd975015effdcc87d0000', null, '', '-9', '2018-04-15 12:01:43', '管理员', 'tonr', null, '管理员具有平台全部功能使用权限。请谨慎配置。', 'locked');

-- ----------------------------
-- Table structure for `role_modules`
-- ----------------------------
DROP TABLE IF EXISTS `role_modules`;
CREATE TABLE `role_modules` (
  `role_id` varchar(36) NOT NULL,
  `module_id` varchar(36) NOT NULL,
  KEY `FKnxc3e53nguousgf65ti2ayxx3` (`module_id`),
  KEY `FKikj9g5f57f4fixgqbp3j9ddae` (`role_id`),
  CONSTRAINT `FKikj9g5f57f4fixgqbp3j9ddae` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FKnxc3e53nguousgf65ti2ayxx3` FOREIGN KEY (`module_id`) REFERENCES `module` (`id`),
  CONSTRAINT `role_modules_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `role_modules_ibfk_2` FOREIGN KEY (`module_id`) REFERENCES `module` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of role_modules
-- ----------------------------
INSERT INTO `role_modules` VALUES ('402881c45effd975015effdcc87d0000', '402881ca62099787016209caa3cc0006');
INSERT INTO `role_modules` VALUES ('402881c45effd975015effdcc87d0000', '402881ca62099787016209ca85990005');
INSERT INTO `role_modules` VALUES ('402881c45effd975015effdcc87d0000', '402881ca62099787016209cb4fad0009');
INSERT INTO `role_modules` VALUES ('402881c45effd975015effdcc87d0000', '402881ca62099787016209cb0e880008');
INSERT INTO `role_modules` VALUES ('402881c45effd975015effdcc87d0000', '402881ca62099787016209cc28ab000c');
INSERT INTO `role_modules` VALUES ('402881c45effd975015effdcc87d0000', '402881ca62099787016209cbfdb8000b');
INSERT INTO `role_modules` VALUES ('402881c45effd975015effdcc87d0000', '402881bf6274b40e016274b68f300000');
INSERT INTO `role_modules` VALUES ('402881c45effd975015effdcc87d0000', '402881ca62099787016209ddb8170033');
INSERT INTO `role_modules` VALUES ('402881c45effd975015effdcc87d0000', '402881ca62099787016209de7d820037');
INSERT INTO `role_modules` VALUES ('402881c45effd975015effdcc87d0000', '402881ca62099787016209de43f00036');
INSERT INTO `role_modules` VALUES ('402881c45effd975015effdcc87d0000', '402881ca62099787016209ddd4c90034');
INSERT INTO `role_modules` VALUES ('402881c45effd975015effdcc87d0000', '402881ca62099787016209deda4f0038');
INSERT INTO `role_modules` VALUES ('402881c45effd975015effdcc87d0000', '402881ca62099787016209df23bb003a');
INSERT INTO `role_modules` VALUES ('402881c45effd975015effdcc87d0000', '8fe09b87-296d-11e7-b497-21af0a259a98');
INSERT INTO `role_modules` VALUES ('402881c45effd975015effdcc87d0000', '402881ca62099787016209ca617a0004');
INSERT INTO `role_modules` VALUES ('402881c45effd975015effdcc87d0000', '402881ca62099787016209cbd790000a');
INSERT INTO `role_modules` VALUES ('402881c45effd975015effdcc87d0000', '402881ca62099787016209dd99c00032');
INSERT INTO `role_modules` VALUES ('402881c45effd975015effdcc87d0000', '98b33553-827e-11e7-9f6e-708bcdac0848');

-- ----------------------------
-- Table structure for `store`
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store` (
  `id` varchar(36) NOT NULL,
  `client_id` varchar(128) DEFAULT NULL,
  `create_user_id` varchar(36) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `logically_deleted` bit(1) DEFAULT NULL,
  `sort_number` int(11) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `address_id` varchar(36) DEFAULT NULL,
  `close_business_time` varchar(8) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `detail_address` varchar(400) DEFAULT NULL,
  `fax` varchar(20) DEFAULT NULL,
  `linkman` varchar(20) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `start_business_time` varchar(8) DEFAULT NULL,
  `store_manager_id` varchar(36) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `warehouse_id` varchar(36) DEFAULT NULL,
  `zip_code` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of store
-- ----------------------------
INSERT INTO `store` VALUES ('402881c5622d572401622d5ba7830003', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-03-16 13:50:04', '', '0', '2018-03-16 14:08:13', '123', '23:00:00', '001', null, '啊', null, null, null, '总店', null, '09:00:00', '402881c45eff19a4015eff80ec080002', null, '402883836229a062016229b698880000', null);

-- ----------------------------
-- Table structure for `warehouse`
-- ----------------------------
DROP TABLE IF EXISTS `warehouse`;
CREATE TABLE `warehouse` (
  `id` varchar(36) NOT NULL,
  `client_id` varchar(128) DEFAULT NULL,
  `create_user_id` varchar(36) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `logically_deleted` bit(1) DEFAULT NULL,
  `sort_number` int(11) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `address_id` varchar(36) DEFAULT NULL,
  `code` varchar(20) DEFAULT NULL,
  `linkman` varchar(20) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `pinyin` varchar(20) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  `shipping_address` varchar(500) DEFAULT NULL,
  `shortname` varchar(20) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `zip_code` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of warehouse
-- ----------------------------
INSERT INTO `warehouse` VALUES ('402883836229a062016229b698880000', 'tonr', '402881c45eff19a4015eff80ec080002', '2018-03-15 20:50:55', '', '0', '2018-06-03 12:28:36', null, '001', '王女生', '主仓库', 'zck', null, '荣盛·爱家郦都 智慧二街荣盛·爱家郦都二期附近', '主仓库', '18640068590', null);
