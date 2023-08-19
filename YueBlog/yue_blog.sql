/*
 Navicat Premium Data Transfer

 Source Server         : yueqiao
 Source Server Type    : MySQL
 Source Server Version : 80034
 Source Host           : 43.138.86.8:3306
 Source Schema         : yue_blog

 Target Server Type    : MySQL
 Target Server Version : 80034
 File Encoding         : 65001

 Date: 20/08/2023 01:57:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for about
-- ----------------------------
DROP TABLE IF EXISTS `about`;
CREATE TABLE `about`  (
  `about_id` int NOT NULL AUTO_INCREMENT COMMENT '关于主键id',
  `about_title` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '关于标题',
  `music_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '音乐id',
  `about_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '关于正文',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`about_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '关于表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of about
-- ----------------------------
INSERT INTO `about` VALUES (1, 'Yueqiao', '1856722728', '<p>社畜一枚，暂无更多信息</p>\n', NULL, NULL, 'admin', '2023-08-19 01:43:35');

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog`  (
  `blog_id` bigint NOT NULL AUTO_INCREMENT COMMENT '博客id',
  `blog_title` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '博客标题',
  `blog_introduction` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '博客简介',
  `blog_cover` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '博客封面',
  `blog_content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '博客正文',
  `recommend_index` bigint NOT NULL DEFAULT 0 COMMENT '推荐指数',
  `blog_words` bigint NOT NULL COMMENT '博客字数',
  `read_time` bigint NOT NULL COMMENT '阅读时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`blog_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '博客表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of blog
-- ----------------------------

-- ----------------------------
-- Table structure for blog_category
-- ----------------------------
DROP TABLE IF EXISTS `blog_category`;
CREATE TABLE `blog_category`  (
  `blog_category_id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `blog_id` bigint NOT NULL COMMENT '博客id',
  `category_id` bigint NOT NULL COMMENT '分类id',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`blog_category_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '博客分类表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of blog_category
-- ----------------------------

-- ----------------------------
-- Table structure for blog_collection
-- ----------------------------
DROP TABLE IF EXISTS `blog_collection`;
CREATE TABLE `blog_collection`  (
  `blog_collection_id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `blog_id` bigint NOT NULL COMMENT '博客id',
  `collection_id` bigint NOT NULL COMMENT '合集id',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`blog_collection_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '博客合集表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of blog_collection
-- ----------------------------

-- ----------------------------
-- Table structure for blog_tag
-- ----------------------------
DROP TABLE IF EXISTS `blog_tag`;
CREATE TABLE `blog_tag`  (
  `blog_tag_id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `blog_id` bigint NOT NULL COMMENT '博客id',
  `tag_id` bigint NOT NULL COMMENT '标签id',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`blog_tag_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '博客标签表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of blog_tag
-- ----------------------------

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `category_id` int NOT NULL AUTO_INCREMENT COMMENT '分类id',
  `category_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '分类名称',
  `category_introduction` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '分类简介',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '分类表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of category
-- ----------------------------

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection`  (
  `collection_id` int NOT NULL AUTO_INCREMENT COMMENT '合集id',
  `collection_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '合集名称',
  `collection_introduction` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '合集简介',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`collection_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '合集表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of collection
-- ----------------------------

-- ----------------------------
-- Table structure for site_setting
-- ----------------------------
DROP TABLE IF EXISTS `site_setting`;
CREATE TABLE `site_setting`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `setting_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '配置key',
  `setting_introduction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '配置介绍',
  `value` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '配置value',
  `type` int NULL DEFAULT NULL COMMENT '1基础设置，2页脚徽标，3资料卡，4友链信息',
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '网站配置表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of site_setting
-- ----------------------------
INSERT INTO `site_setting` VALUES (1, 'blogName', '博客名称', 'Yue\'s Blog', 1, NULL, NULL, 'admin', '2023-08-19 02:14:08');
INSERT INTO `site_setting` VALUES (2, 'webTitleSuffix', '网页标题后缀', ' - Yue\'s Blog', 1, NULL, NULL, 'admin', '2023-08-19 02:14:08');
INSERT INTO `site_setting` VALUES (3, 'footerImgTitle', '页脚图片标题', '', 1, NULL, NULL, 'admin', '2023-08-19 02:14:08');
INSERT INTO `site_setting` VALUES (4, 'footerImgUrl', '页脚图片路径', '', 1, NULL, NULL, 'admin', '2023-08-19 02:14:08');
INSERT INTO `site_setting` VALUES (5, 'copyright', 'Copyright', '{\"title\":\"Copyright © 2019 - 2022\",\"siteName\":\"YUE\'S BLOG\"}', 1, NULL, NULL, 'admin', '2023-08-19 02:14:08');
INSERT INTO `site_setting` VALUES (6, 'beian', 'ICP备案号', '', 1, NULL, NULL, 'admin', '2023-08-19 02:14:08');
INSERT INTO `site_setting` VALUES (9, 'playlistServer', '播放器平台', 'netease', 1, NULL, NULL, 'admin', '2023-08-19 02:14:08');
INSERT INTO `site_setting` VALUES (10, 'playlistId', '播放器歌单', '3071528549', 1, NULL, NULL, 'admin', '2023-08-19 02:14:08');
INSERT INTO `site_setting` VALUES (11, 'avatar', '头像', '/img/avatar.jpg', 2, NULL, NULL, 'admin', '2023-08-19 02:14:08');
INSERT INTO `site_setting` VALUES (12, 'name', '昵称', 'YueQiao', 2, NULL, NULL, 'admin', '2023-08-19 02:14:08');
INSERT INTO `site_setting` VALUES (13, 'rollText', '滚动个签', '\"无论前路艰险如何\",\"我都会陪在你身边\"', 2, NULL, NULL, 'admin', '2023-08-19 02:14:08');
INSERT INTO `site_setting` VALUES (14, 'github', 'GitHub', 'https://github.com/yueqiaozgb', 2, NULL, NULL, 'admin', '2023-08-19 02:14:08');
INSERT INTO `site_setting` VALUES (16, 'qq', 'QQ', '', 2, NULL, NULL, 'admin', '2023-08-19 02:14:08');
INSERT INTO `site_setting` VALUES (17, 'bilibili', 'bilibili', '', 2, NULL, NULL, 'admin', '2023-08-19 02:14:08');
INSERT INTO `site_setting` VALUES (18, 'netease', '网易云音乐', '', 2, NULL, NULL, 'admin', '2023-08-19 02:14:08');
INSERT INTO `site_setting` VALUES (19, 'email', 'email', 'mailto:yueqiaozgb@163.com', 2, NULL, NULL, 'admin', '2023-08-19 02:14:08');
INSERT INTO `site_setting` VALUES (20, 'favorite', '自定义', '{\"title\":\"最喜欢的动漫 \",\"content\":\"魔女之旅\"}', 2, NULL, NULL, 'admin', '2023-08-19 02:14:08');
INSERT INTO `site_setting` VALUES (21, 'favorite', '自定义', '{\"title\":\"最喜欢的角色\",\"content\":\"イレイナ：伊蕾娜，观星\"}', 2, NULL, NULL, 'admin', '2023-08-19 02:14:08');
INSERT INTO `site_setting` VALUES (22, 'favorite', '自定义', '{\"title\":\"最喜欢玩的游戏 \",\"content\":\"明日方舟，崩坏三，原神，碧蓝航线，碧蓝档案，musedash\"}', 2, NULL, NULL, 'admin', '2023-08-19 02:14:08');
INSERT INTO `site_setting` VALUES (24, 'badge', '徽标', '{\"title\":\"由 Spring Boot 强力驱动\",\"url\":\"https://spring.io/projects/spring-boot/\",\"subject\":\"Powered\",\"value\":\"Spring Boot\",\"color\":\"blue\"}', 3, NULL, NULL, 'admin', '2023-08-19 02:14:08');
INSERT INTO `site_setting` VALUES (25, 'badge', '徽标', '{\"title\":\"Vue.js 客户端渲染\",\"url\":\"https://cn.vuejs.org/\",\"subject\":\"SPA\",\"value\":\"Vue.js\",\"color\":\"brightgreen\"}', 3, NULL, NULL, 'admin', '2023-08-19 02:14:08');
INSERT INTO `site_setting` VALUES (26, 'badge', '徽标', '{\"title\":\"UI 框架 Semantic-UI\",\"url\":\"https://semantic-ui.com/\",\"subject\":\"UI\",\"value\":\"Semantic-UI\",\"color\":\"semantic-ui\"}', 3, NULL, NULL, 'admin', '2023-08-19 02:14:08');
INSERT INTO `site_setting` VALUES (28, 'badge', '徽标', '{\"title\":\"静态资源托管于 GitHub\",\"url\":\"https://github.com/\",\"subject\":\"OSS\",\"value\":\"GitHub\",\"color\":\"github\"}', 3, NULL, NULL, 'admin', '2023-08-19 02:14:08');

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `tag_id` int NOT NULL AUTO_INCREMENT COMMENT '标签id',
  `tag_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '标签名称',
  `tag_introduction` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标签简介',
  `tag_color` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '标签颜色',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`tag_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '标签表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tag
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `role_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色访问权限',
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '昵称',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '头像地址',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '邮箱',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'Admin', 'e10adc3949ba59abbe56e057f20f883e', 'admin', 'Admin', '/img/avatar.jpg', 'yueqiaozgb@163.com', '2020-09-21 16:47:18', '2020-09-21 16:47:22', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
