/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : car_db

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2018-06-22 17:18:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `brand`
-- ----------------------------
DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `country` varchar(55) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of brand
-- ----------------------------

-- ----------------------------
-- Table structure for `brand_model`
-- ----------------------------
DROP TABLE IF EXISTS `brand_model`;
CREATE TABLE `brand_model` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brand_id` int(11) NOT NULL COMMENT '品牌id',
  `name` varchar(25) NOT NULL COMMENT '型号名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='品牌-型号表';

-- ----------------------------
-- Records of brand_model
-- ----------------------------

-- ----------------------------
-- Table structure for `item`
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(55) NOT NULL,
  `status` int(1) NOT NULL COMMENT '状态：1启用，2禁用',
  `brand_modle_id` int(11) NOT NULL COMMENT '品牌-型号id',
  `labels` varchar(55) DEFAULT NULL COMMENT '标签id',
  `property_type` int(2) NOT NULL COMMENT '类别，例如：SUV，跑车等等',
  `price_high` decimal(12,2) DEFAULT NULL COMMENT '所有规格中最高价',
  `price_low` decimal(12,2) DEFAULT NULL COMMENT '所有规格中最低价',
  `is_auto` tinyint(1) DEFAULT NULL COMMENT '是否自动挡',
  `is_chinese` tinyint(1) DEFAULT NULL COMMENT '是否国产',
  `speed_box` int(1) DEFAULT NULL COMMENT '变速箱：手动，自动',
  `img_str` text COMMENT '默认图片地址集合',
  `priority` int(1) DEFAULT NULL COMMENT '排序优先级',
  `create_time` datetime DEFAULT NULL,
  `stock` int(11) DEFAULT NULL COMMENT '默认库存',
  `country` varchar(55) DEFAULT NULL COMMENT '生产国',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item
-- ----------------------------

-- ----------------------------
-- Table structure for `item_brand_model`
-- ----------------------------
DROP TABLE IF EXISTS `item_brand_model`;
CREATE TABLE `item_brand_model` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '类目ID',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父类目ID=0时，代表的是一级的类目',
  `name` varchar(50) DEFAULT NULL COMMENT '类目名称',
  `status` int(1) DEFAULT '1' COMMENT '状态。可选值:1(正常),2(删除)',
  `sort_order` int(4) DEFAULT NULL COMMENT '排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数',
  `is_parent` tinyint(1) DEFAULT '1' COMMENT '该类目是否为父类目，1为true，0为false',
  `created` datetime DEFAULT NULL COMMENT '创建时间',
  `updated` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`,`status`) USING BTREE,
  KEY `sort_order` (`sort_order`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='商品类目';

-- ----------------------------
-- Records of item_brand_model
-- ----------------------------
INSERT INTO `item_brand_model` VALUES ('1', '0', '奥迪', '1', '1', '1', '2018-06-22 13:00:00', '2018-06-22 13:00:04');
INSERT INTO `item_brand_model` VALUES ('2', '0', '宝马', '1', '2', '1', '2018-06-22 13:00:41', '2018-06-22 13:00:43');
INSERT INTO `item_brand_model` VALUES ('3', '1', 'A4', '1', null, '0', '2018-06-22 13:01:11', '2018-06-22 13:01:13');

-- ----------------------------
-- Table structure for `item_desc`
-- ----------------------------
DROP TABLE IF EXISTS `item_desc`;
CREATE TABLE `item_desc` (
  `item_id` int(11) NOT NULL,
  `item_description` mediumtext COMMENT '商品详情',
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品详情表';

-- ----------------------------
-- Records of item_desc
-- ----------------------------

-- ----------------------------
-- Table structure for `item_specification`
-- ----------------------------
DROP TABLE IF EXISTS `item_specification`;
CREATE TABLE `item_specification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) NOT NULL,
  `configuration_name` varchar(55) NOT NULL,
  `color` varchar(30) DEFAULT NULL,
  `fix_price` decimal(12,2) DEFAULT NULL COMMENT '定价',
  `now_price` decimal(12,2) DEFAULT NULL COMMENT '现价',
  `img_str` text COMMENT '图片地址json串',
  `oil_wear` varchar(35) DEFAULT NULL COMMENT '油耗',
  `displacement` double(5,1) DEFAULT NULL COMMENT '排量',
  `energy` int(1) DEFAULT NULL COMMENT '能源：汽油，柴油，油电混合，天然气',
  `seat_number` int(2) DEFAULT NULL COMMENT '座位数',
  `stock` int(11) DEFAULT NULL COMMENT '库存',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item_specification
-- ----------------------------

-- ----------------------------
-- Table structure for `label`
-- ----------------------------
DROP TABLE IF EXISTS `label`;
CREATE TABLE `label` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(55) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of label
-- ----------------------------
INSERT INTO `label` VALUES ('1', 'test标签1');
INSERT INTO `label` VALUES ('2', 'test标签2');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(55) NOT NULL COMMENT '用户名',
  `pwd` varchar(55) NOT NULL,
  `mobile` int(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', null, null);

-- ----------------------------
-- Table structure for `wx_user`
-- ----------------------------
DROP TABLE IF EXISTS `wx_user`;
CREATE TABLE `wx_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `openid` varchar(55) DEFAULT '' COMMENT '用户的标识，对当前公众号唯一',
  `nickname` varchar(55) DEFAULT NULL COMMENT '用户的昵称',
  `sex` int(1) DEFAULT NULL COMMENT '用户的性别，值为1时是男性，值为2时是女性，值为0时是未知',
  `city` varchar(55) DEFAULT NULL COMMENT '用户所在城市',
  `province` varchar(55) DEFAULT NULL COMMENT '用户所在省份',
  `country` varchar(55) DEFAULT NULL COMMENT '用户所在国家',
  `headimgurl` varchar(255) DEFAULT NULL COMMENT '用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。',
  `subscribe_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注',
  `groupid` varchar(55) DEFAULT NULL COMMENT '用户所在的分组ID（兼容旧的用户分组接口）',
  `tagid_list` varchar(255) DEFAULT NULL COMMENT '用户被打上的标签ID列表',
  `subscribe_scene` varchar(55) DEFAULT NULL COMMENT '返回用户关注的渠道来源，ADD_SCENE_SEARCH 公众号搜索，ADD_SCENE_ACCOUNT_MIGRATION 公众号迁移，ADD_SCENE_PROFILE_CARD 名片分享，ADD_SCENE_QR_CODE 扫描二维码，ADD_SCENEPROFILE LINK 图文页内名称点击，ADD_SCENE_PROFILE_ITEM 图文页右上角菜单，ADD_SCENE_PAID 支付后关注，ADD_SCENE_OTHERS 其他',
  `qr_scene` varchar(55) DEFAULT NULL COMMENT '二维码扫码场景（开发者自定义）',
  `qr_scene_str` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wx_user
-- ----------------------------
