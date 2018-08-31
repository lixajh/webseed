/*
 Navicat MySQL Data Transfer

 Source Server         : 118.24.155.154
 Source Server Type    : MySQL
 Source Server Version : 50626
 Source Host           : 118.24.155.154:3306
 Source Schema         : webseed

 Target Server Type    : MySQL
 Target Server Version : 50626
 File Encoding         : 65001

 Date: 31/08/2018 14:56:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_admin
-- ----------------------------
DROP TABLE IF EXISTS `tbl_admin`;
CREATE TABLE `tbl_admin`  (
  `pk_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `salt` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `data_status` int(11) NULL DEFAULT NULL COMMENT '-1：删除，0：正常，1冻结',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nick_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `last_login_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`pk_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_admin
-- ----------------------------
INSERT INTO `tbl_admin` VALUES (5, '123', '8cf7951b3ad5dd41b635eb8172446d71', 'a57760386ad9cd0ab8b627c7e042d44a', 0, NULL, NULL, '2018-08-30 07:09:48', '2018-08-30 07:09:48', '2018-08-28 04:15:47');
INSERT INTO `tbl_admin` VALUES (8, '13', 'd94da04e5edfbafc1578cbfda466c52d', 'cd4eed40d4aa1acff9c59c1de4b378d5', 0, NULL, NULL, NULL, NULL, '2018-08-28 23:00:48');
INSERT INTO `tbl_admin` VALUES (9, '132', '29633edecfdb065705dee3faa8e0f439', '30401ae3d1fd58812b9206d0c1d837cb', 0, NULL, NULL, NULL, NULL, '2018-08-29 02:04:03');
INSERT INTO `tbl_admin` VALUES (10, '1322', '399692a59eb93cf3025864ee12f5b2a5', '57689460f8cdb70845c206fa6e088b3f', -1, NULL, NULL, NULL, NULL, '2018-08-29 02:04:31');
INSERT INTO `tbl_admin` VALUES (15, '1321', 'b7220c4e98ac07458dae778c2e4efe7f', 'a32d19a010321dba628f5cfcd7a12ab8', -1, NULL, NULL, NULL, NULL, '2018-08-29 02:57:03');
INSERT INTO `tbl_admin` VALUES (16, '1323', 'dc1db68407897cfea5dd0f3aecad740f', '95191b75a10d43d30cccecf3e56fadc4', 0, NULL, NULL, NULL, NULL, '2018-08-29 02:57:07');
INSERT INTO `tbl_admin` VALUES (17, '1324', '57c24758ca688b5fd7d6a337e3d4d9c9', 'a891ac04e1bf31512570a6a8c0de6afd', 0, NULL, NULL, NULL, NULL, '2018-08-29 02:57:09');
INSERT INTO `tbl_admin` VALUES (18, '1325', '4a0ff2c4d3ef4130e848374dae975201', '320cd335ac5c9ff17c0e2f2a4ecbcafc', 0, NULL, NULL, NULL, NULL, '2018-08-29 02:57:11');
INSERT INTO `tbl_admin` VALUES (19, '1326', 'e462b4bf25b9808ef99d5a303d901d5f', 'd1f93b69409aa1502435454eb0849d7a', 0, NULL, NULL, NULL, NULL, '2018-08-29 02:57:14');
INSERT INTO `tbl_admin` VALUES (20, '1327', 'b97b20a4924df193adfa05530ac9f5d2', '27ec80a52193be3726a709f2a71b7247', 0, NULL, NULL, NULL, NULL, '2018-08-29 02:57:15');
INSERT INTO `tbl_admin` VALUES (21, '1328', 'f056afdee00988fadd4a34ee155e376e', 'fe9e8e0c74105ab1cf25f42d2e829824', 0, NULL, NULL, NULL, NULL, '2018-08-29 02:57:18');
INSERT INTO `tbl_admin` VALUES (22, '1329', '0d78464a993ad405b2a456f1ebedbfd0', '9fa8fcc8b18a612218ca4b9efeb0a08d', 0, NULL, NULL, NULL, NULL, '2018-08-29 02:57:20');
INSERT INTO `tbl_admin` VALUES (23, '1320', '63d221689d05c58ab8122f742e1dfdf1', '328c47435a12a56afc08c1084897927a', 0, NULL, NULL, NULL, NULL, '2018-08-29 02:57:22');
INSERT INTO `tbl_admin` VALUES (24, '1331', '980b875f9d5b796e5f31283bd29a545a', '10ca1f8e879f0eb8da7d87c87a9d8b25', 0, NULL, NULL, NULL, NULL, '2018-08-29 02:57:27');
INSERT INTO `tbl_admin` VALUES (25, '1332', '18e2a1d0fccc1aa8dd0048f768fca866', 'f989fb1f14848d23edace567333a8c34', 0, NULL, NULL, NULL, NULL, '2018-08-29 02:57:29');
INSERT INTO `tbl_admin` VALUES (26, '1333', '64adb6f34f60e9ee5b6eea17c9b342d5', '140f123cd8d15f0d847cedb25ff3da27', 0, NULL, NULL, NULL, NULL, '2018-08-29 02:57:31');
INSERT INTO `tbl_admin` VALUES (27, '1334', '2865a46e8faa9410be7374d15d2006aa', '17fc876ee3ba431b6e071beab514ede9', 0, NULL, NULL, NULL, NULL, '2018-08-29 02:57:33');

-- ----------------------------
-- Table structure for tbl_member
-- ----------------------------
DROP TABLE IF EXISTS `tbl_member`;
CREATE TABLE `tbl_member`  (
  `pk_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `salt` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `data_status` int(11) NULL DEFAULT NULL COMMENT '-1：删除，0：正常，1冻结',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `open_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '微信用户的唯一标识',
  `nickname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `last_login_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `head_img_url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `union_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。',
  PRIMARY KEY (`pk_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_member
-- ----------------------------
INSERT INTO `tbl_member` VALUES (5, NULL, NULL, NULL, NULL, NULL, 'ozqVc0VzImLHzu_NGlk_siyBH83U', '李晓', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for tbl_member_plus
-- ----------------------------
DROP TABLE IF EXISTS `tbl_member_plus`;
CREATE TABLE `tbl_member_plus`  (
  `pk_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fk_member_id` bigint(20) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `language` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `city` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '微信普通用户个人资料填写的城市',
  `sex` int(11) NULL DEFAULT NULL COMMENT '用户的性别，值为1时是男性，值为2时是女性，值为0时是未知',
  `province` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '微信用户个人资料填写的省份',
  `country` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '微信国家，如中国为CN',
  `privilege` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '微信用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）',
  PRIMARY KEY (`pk_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
