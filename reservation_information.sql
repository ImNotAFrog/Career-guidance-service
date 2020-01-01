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

 Date: 01/01/2020 21:59:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for reservation_information
-- ----------------------------
DROP TABLE IF EXISTS `reservation_information`;
CREATE TABLE `reservation_information`  (
  `r_id` bigint(50) NOT NULL,
  `u_id` bigint(50) NULL DEFAULT NULL,
  `tName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `uName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `time` datetime(0) NOT NULL,
  `project` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`r_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reservation_information
-- ----------------------------
INSERT INTO `reservation_information` VALUES (4122613962801152, NULL, 'heting', 'heq', '2019-12-11 12:30:00', 'xiangnm');
INSERT INTO `reservation_information` VALUES (4122621940367360, NULL, '11', 'bab', '2019-11-11 12:10:00', 'aaa');
INSERT INTO `reservation_information` VALUES (4122637488652288, NULL, 'heting', 'heqddd', '2019-12-11 12:30:00', 'xiangnm');
INSERT INTO `reservation_information` VALUES (4847803487326208, NULL, 'heting', 'heqddd', '2019-12-11 12:30:00', 'xiangnm');
INSERT INTO `reservation_information` VALUES (4850465846956032, NULL, 'heting', 'heqddd', '2019-12-01 12:30:00', 'xiangnm');

SET FOREIGN_KEY_CHECKS = 1;
