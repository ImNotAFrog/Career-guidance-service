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

 Date: 01/01/2020 21:59:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for personal_center
-- ----------------------------
DROP TABLE IF EXISTS `personal_center`;
CREATE TABLE `personal_center`  (
  `p_id` bigint(50) NOT NULL,
  `uName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `uSex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `uPhone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `uWeixin` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `uEmail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `uMajor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`p_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of personal_center
-- ----------------------------
INSERT INTO `personal_center` VALUES (4083087852732416, 'a', 'a', NULL, NULL, NULL, NULL);
INSERT INTO `personal_center` VALUES (4083112280358912, '1a', 'a', NULL, NULL, NULL, NULL);
INSERT INTO `personal_center` VALUES (4083122355077120, '11a', 'a', NULL, NULL, NULL, NULL);
INSERT INTO `personal_center` VALUES (4083135340642304, '11a', 'af ', NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
