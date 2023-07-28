-- 关闭外键约束
SET FOREIGN_KEY_CHECKS = 0;

-- 系统用户表
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `username` varchar(64) NOT NULL COMMENT '用户名',
    `nickname` varchar(64) DEFAULT NULL COMMENT '昵称',
    `phone` varchar(64) DEFAULT NULL COMMENT '电话',
    `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
    `sex` char(1) DEFAULT NULL COMMENT '性别',
    `password` varchar(255) NOT NULL COMMENT '密码',
    `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态',
    `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标志',
    `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `remark` varchar(64) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统用户表';

-- 系统角色表
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `role_name` varchar(64) NOT NULL COMMENT '角色名称',
    `role_key` varchar(64) NOT NULL COMMENT '角色权限',
    `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态',
    `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标志',
    `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `remark` varchar(64) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统角色表';

-- 系统用户角色表
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `user_id` bigint NOT NULL COMMENT '用户id',
    `role_id` bigint NOT NULL COMMENT '角色id',
    `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态',
    `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统角色用户表';

-- 系统菜单表
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `parent_id` bigint NOT NULL COMMENT '父菜单id',
    `menu_name` varchar(64) NOT NULL COMMENT '菜单名称',
    `menu_icon` varchar(64) NOT NULL COMMENT '菜单图标',
    `menu_category` char(1) NOT NULL COMMENT '菜单类型',
    `menu_perms` varchar(64) NOT NULL COMMENT '菜单权限',
    `order_num` int NOT NULL COMMENT '显示顺序',
    `path` varchar(64) DEFAULT NULL COMMENT '路由',
    `component` varchar(64) DEFAULT NULL COMMENT '组件路径',
    `is_frame` char(1) NOT NULL DEFAULT '0' COMMENT '是否外链',
    `is_cache` char(1) NOT NULL DEFAULT '1' COMMENT '是否缓存',
    `is_visible` char(1) NOT NULL DEFAULT '1' COMMENT '是否可见',
    `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态',
    `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标志',
    `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `remark` varchar(64) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统菜单表';

-- 系统角色菜单表
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `role_id` bigint NOT NULL COMMENT '角色id',
    `menu_id` bigint NOT NULL COMMENT '菜单id',
    `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态',
    `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `remark` varchar(64) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统角色菜单表';

-- 开启外键约束
SET FOREIGN_KEY_CHECKS = 1;