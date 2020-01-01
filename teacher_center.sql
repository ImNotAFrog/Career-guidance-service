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

 Date: 01/01/2020 22:00:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for teacher_center
-- ----------------------------
DROP TABLE IF EXISTS `teacher_center`;
CREATE TABLE `teacher_center`  (
  `t_center_id` bigint(50) NOT NULL,
  `tName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `tSex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `tMajor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `tSynopsis` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `tPhone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`t_center_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher_center
-- ----------------------------
INSERT INTO `teacher_center` VALUES (4843915791142912, 'laoshi', 'nv', 'jisuanji', 'jhddhskndksjd', NULL);
INSERT INTO `teacher_center` VALUES (4852042360000512, 'laoshi', 'yuqinmeiv', 'jisuanji', 'jhddhskndksjd', '234');

SET FOREIGN_KEY_CHECKS = 1;
