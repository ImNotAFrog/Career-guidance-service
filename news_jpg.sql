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

 Date: 01/01/2020 13:36:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for news_jpg
-- ----------------------------
DROP TABLE IF EXISTS `news_jpg`;
CREATE TABLE `news_jpg`  (
  `j_id` bigint(50) NOT NULL AUTO_INCREMENT,
  `j_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `poster` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`j_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5257740074090497 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of news_jpg
-- ----------------------------
INSERT INTO `news_jpg` VALUES (1, 'asas', '/posters/15776225035821.png');
INSERT INTO `news_jpg` VALUES (5251227171422208, 'asas', '/posters/15776225954291.png');
INSERT INTO `news_jpg` VALUES (5257421780942848, 'asas', '/posters/15776240724551.png');
INSERT INTO `news_jpg` VALUES (5257740074090496, 'asas', '/posters/15776241482601.png');

SET FOREIGN_KEY_CHECKS = 1;
