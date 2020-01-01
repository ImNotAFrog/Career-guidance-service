/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : career_guidance

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 01/01/2020 13:36:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `a_id` bigint(50) NOT NULL AUTO_INCREMENT,
  `u_id` bigint(20) NOT NULL,
  `a_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `a_article` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `a_uploader` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `a_publishDate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`a_id`, `u_id`) USING BTREE,
  INDEX `u_id`(`u_id`) USING BTREE,
  CONSTRAINT `u_id` FOREIGN KEY (`u_id`) REFERENCES `sys_user` (`u_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7965905983176705 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
