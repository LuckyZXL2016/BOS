/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50629
Source Host           : 127.0.0.1:3306
Source Database       : bos_crm

Target Server Type    : MYSQL
Target Server Version : 50629
File Encoding         : 65001

Date: 2018-04-13 19:37:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_customer`
-- ----------------------------
DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `station` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `decidedzone_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_customer
-- ----------------------------
INSERT INTO `t_customer` VALUES ('1', '张三', '百度', '13811111111', '北京市西城区长安街100号', '123');
INSERT INTO `t_customer` VALUES ('2', '李四', '哇哈哈', '13822222222', '上海市虹桥区南京路250号', '123');
INSERT INTO `t_customer` VALUES ('3', '王五', '搜狗', '13533333333', '天津市河北区中山路30号', '123');
INSERT INTO `t_customer` VALUES ('4', '赵六', '联想', '18633333333', '石家庄市桥西区和平路10号', '123');
INSERT INTO `t_customer` VALUES ('5', '小白', '测试空间', '18511111111', '内蒙古自治区呼和浩特市和平路100号', '123');
INSERT INTO `t_customer` VALUES ('6', '小黑', '联想', '13722222222', '天津市南开区红旗路20号', '123');
INSERT INTO `t_customer` VALUES ('7', '小花', '百度', '13733333333', '北京市东城区王府井大街20号', '123');
INSERT INTO `t_customer` VALUES ('8', '小李', '长城', '13788888888', '北京市昌平区建材城西路100号', '123');
INSERT INTO `t_customer` VALUES ('9', '小张', '腾讯', '15705102215', 'jsnt', '123');
