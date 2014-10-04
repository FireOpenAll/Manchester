/*
Navicat MySQL Data Transfer

Source Server         : Galaxy
Source Server Version : 50615
Source Host           : 192.168.1.103:3306
Source Database       : galaxy

Target Server Type    : MYSQL
Target Server Version : 50615
File Encoding         : 65001

Date: 2014-10-01 23:09:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ac_activity
-- ----------------------------
DROP TABLE IF EXISTS ac_activity;
CREATE TABLE ac_activity (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  created_time timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  updated_time timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  type varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  title varchar(300) CHARACTER SET utf8 DEFAULT NULL,
  start_time timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  end_time timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  province_id smallint(6) DEFAULT NULL,
  city_id smallint(6) DEFAULT NULL,
  district_id smallint(6) DEFAULT NULL,
  address varchar(255)   NULL,
  ref_url varchar(255)  NULL,
  price decimal(10,0 DEFAULT NULL,
  user_id bigint(20) DEFAULT NULL,
  operator_id bigint(20) DEFAULT NULL,
  joined_num int(11) DEFAULT NULL,
  tickets_num int(11) DEFAULT NULL,
  status tinyint(4) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ac_activity_detail
-- ----------------------------
DROP TABLE IF EXISTS ac_activity_detail;
CREATE TABLE ac_activity_detail (
  id bigint(20) NOT NULL,
  created_time timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  updated_time timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  content varchar(5000) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for u_group
-- ----------------------------
DROP TABLE IF EXISTS u_group;
CREATE TABLE u_group (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  created_time timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  updated_time timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  create_user_id bigint(20) DEFAULT NULL,
  group_avatar varchar(50) DEFAULT NULL,
  name varchar(30) DEFAULT NULL,
  domain varchar(50) DEFAULT NULL,
  group_type varchar(20) DEFAULT NULL,
  display_type tinyint(4) DEFAULT NULL,
  description varchar(500) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for u_group_apply
-- ----------------------------
DROP TABLE IF EXISTS u_group_apply;
CREATE TABLE u_group_apply (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  created_time timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  group_id bigint(20) NOT NULL,
  user_id bigint(20) DEFAULT NULL,
  audit_user_id bigint(20) DEFAULT NULL,
  status varchar(255) DEFAULT NULL,
  message varchar(255) DEFAULT NULL,
  reason varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for u_group_member
-- ----------------------------
DROP TABLE IF EXISTS u_group_member;
CREATE TABLE u_group_member (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  created_time timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  user_id bigint(20) DEFAULT NULL,
  group_id bigint(20) DEFAULT NULL,
  member_name varchar(50) DEFAULT NULL,
  role varchar(30) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for u_user
-- ----------------------------
DROP TABLE IF EXISTS u_user;
CREATE TABLE u_user (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  created_time timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  updated_time timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  login_name varchar(255) NOT NULL,
  password varchar(255) DEFAULT NULL,
  sex varchar(255) DEFAULT NULL,
  birthday timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  type varchar(255) DEFAULT NULL,
  nick varchar(255) DEFAULT NULL,
  followers int(11) DEFAULT NULL,
  fans int(11) DEFAULT NULL,
  real_name varchar(255) DEFAULT NULL,
  email varchar(255) DEFAULT NULL,
  mobile varchar(255) DEFAULT NULL,
  real_name_auth tinyint(4) DEFAULT NULL,
  email_auth tinyint(4) DEFAULT NULL,
  mobile_auth tinyint(4) DEFAULT NULL,
  haspic tinyint(4) DEFAULT NULL,
  avatar varchar(100) DEFAULT NULL,
  weibo_openid varchar(30) DEFAULT NULL,
  webchat_openid varchar(30) DEFAULT NULL,
  qq_openid varchar(30) DEFAULT NULL,
  last_visit_time timestamp NOT NULL DEFAULT 0000-00-00 00:00:00 ON UPDATE CURRENT_TIMESTAMP,
  status varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for u_user_profiles
-- ----------------------------
DROP TABLE IF EXISTS u_user_profiles;
CREATE TABLE u_user_profiles (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  created_time timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  updated_time timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  user_id bigint(20) DEFAULT NULL,
  name varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  value varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
