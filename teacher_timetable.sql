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

 Date: 01/01/2020 13:36:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for teacher_timetable
-- ----------------------------
DROP TABLE IF EXISTS `teacher_timetable`;
CREATE TABLE `teacher_timetable`  (
  `t_id` bigint(50) NOT NULL AUTO_INCREMENT,
  `u_id` bigint(50) NOT NULL,
  `s_id` bigint(50) NOT NULL,
  `free_top` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `free_down` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `time_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`t_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5233504022429697 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher_timetable
-- ----------------------------
INSERT INTO `teacher_timetable` VALUES (4849000271314944, 4141, 1414, NULL, NULL, '啊撒撒');
INSERT INTO `teacher_timetable` VALUES (4852564272087040, 4141, 1414, '2019-12-11 12:13:59', '2019-12-01 16:50:21', NULL);
INSERT INTO `teacher_timetable` VALUES (4853068347736064, 4141, 1414, '2019-12-11 12:13:59', '2019-12-01 16:50:21', NULL);
INSERT INTO `teacher_timetable` VALUES (5232458134978560, 4846787557851136, 4846787557851136, '2609-11-01 21:45:21', '2609-11-01 18:59:25', NULL);
INSERT INTO `teacher_timetable` VALUES (5233504022429696, 4846787557851136, 4846787557851136, '2019-12-11 08:00:00', '2019-12-01 08:00:00', NULL);

SET FOREIGN_KEY_CHECKS = 1;
