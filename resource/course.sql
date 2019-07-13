/*
 Navicat Premium Data Transfer

 Source Server         : local-MySQL-01
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : keba

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 06/07/2019 09:56:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程ID',
  `teacher_id` int(11) DEFAULT NULL COMMENT '授课教师ID',
  `college_id` int(11) DEFAULT NULL COMMENT '院校ID',
  `teacher_name` varchar(360) DEFAULT NULL COMMENT '授课教师名称',
  `course_name` varchar(360) NOT NULL COMMENT '课程名称',
  `course_introduce` varchar(360) DEFAULT NULL COMMENT '课程介绍',
  `course_time` varchar(360) DEFAULT NULL COMMENT '课程时间',
  `course_rate` decimal(11,1) DEFAULT NULL COMMENT '课程评分',
  `course_count` int(11) DEFAULT NULL COMMENT '课程点击',
  `recommend` int(11) NOT NULL DEFAULT '0' COMMENT '是否推荐',
  `course_img` varchar(255) DEFAULT NULL COMMENT '课程图片地址',
  PRIMARY KEY (`course_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
