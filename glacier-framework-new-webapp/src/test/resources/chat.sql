/*
Navicat MySQL Data Transfer

Source Server         : 本地MySql
Source Server Version : 50067
Source Host           : localhost:3306
Source Database       : chat

Target Server Type    : MYSQL
Target Server Version : 50067
File Encoding         : 65001

Date: 2013-12-05 14:06:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_action`
-- ----------------------------
DROP TABLE IF EXISTS `t_action`;
CREATE TABLE `t_action` (
  `action_id` varchar(32) NOT NULL COMMENT '操作主键Id',
  `menu_id` varchar(32) default NULL COMMENT '操作所在菜单外键',
  `action_cn_name` varchar(30) NOT NULL COMMENT '操作中文名称',
  `action_en_name` varchar(30) NOT NULL COMMENT '操作英文名称',
  `contain_id` varchar(50) default NULL COMMENT '操作所在容器ID',
  `icon_cls` varchar(30) default NULL COMMENT '操作样式',
  `type` enum('link','button') default 'button' COMMENT '操作类型：按钮/超链接',
  `disabled` enum('enabled','disabled') default NULL COMMENT '默认打开是否禁用',
  `method` varchar(100) default NULL COMMENT '操作调用前台JS方法',
  `order_num` int(10) unsigned default NULL COMMENT '排序',
  `remark` varchar(50) default NULL COMMENT '备注',
  PRIMARY KEY  (`action_id`),
  KEY `FK_t_action_t_menu_id` USING BTREE (`menu_id`),
  CONSTRAINT `FK_t_action_t_menu_id` FOREIGN KEY (`menu_id`) REFERENCES `t_menu` (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限_动作';

-- ----------------------------
-- Records of t_action
-- ----------------------------
INSERT INTO `t_action` VALUES ('18060139f0e736a796d5ac4bdd78eadc', 'e550884c5e6c1e94ee70cc833aa1c2b9', '修改', 'edit', 'RolePanel', 'icon-standard-pencil-go', 'button', 'enabled', '', '2', '');
INSERT INTO `t_action` VALUES ('435435kkk', 'a324wkljsknfs', '删除', 'del', 'MenuPanel', 'icon-standard-pencil-delete', 'button', 'disabled', 'glacier.permissions_mgr.res_mgr.res.delMenu();', '3', '');
INSERT INTO `t_action` VALUES ('5db796929f23e991708fd0af99b3b4bc', 'e550884c5e6c1e94ee70cc833aa1c2b9', '增加', 'add', 'RolePanel', 'icon-standard-pencil-add', 'button', 'enabled', '', '1', '');
INSERT INTO `t_action` VALUES ('8eb3b50d119f05c30127c3359e4a5d2a', 'e550884c5e6c1e94ee70cc833aa1c2b9', '删除', 'del', 'RolePanel', 'icon-standard-pencil-delete', 'button', 'disabled', '', '3', '');
INSERT INTO `t_action` VALUES ('9320f5b0199abd8d53990eef7cdcd745', 'a324wkljsknfs', '编辑', 'edit', 'ActionPanel', 'icon-standard-pencil-go', 'button', 'disabled', 'glacier.permissions_mgr.res_mgr.res.editAction();', '2', '');
INSERT INTO `t_action` VALUES ('acdiisdf', 'a324wkljsknfs', '增加', 'add', 'MenuPanel', 'icon-standard-pencil-add', 'button', 'enabled', 'glacier.permissions_mgr.res_mgr.res.addMenu();', '1', '');
INSERT INTO `t_action` VALUES ('b34352268cb171aee1f8e2110657beab', 'e550884c5e6c1e94ee70cc833aa1c2b9', '操作授权', 'actionAuth', 'RolePanel', 'icon-standard-key-go', 'button', 'enabled', 'glacier.permissions_mgr.role_mgr.role.actionAuth();', '5', '');
INSERT INTO `t_action` VALUES ('e550884c5e6c1e94a970cc833aa1c2b9', 'a324wkljsknfs', '增加', 'add', 'ActionPanel', 'icon-standard-pencil-add', 'button', 'enabled', 'glacier.permissions_mgr.res_mgr.res.addAction();', '1', '');
INSERT INTO `t_action` VALUES ('eb07f8ec549c0beb66e4e8a1a0f21604', 'e550884c5e6c1e94ee70cc833aa1c2b9', '授权', 'auth', 'RolePanel', 'icon-standard-shield-go', 'button', 'disabled', 'glacier.permissions_mgr.role_mgr.role.showMenuAndActionWin();', '4', '');
INSERT INTO `t_action` VALUES ('f4b5eca05e616d411f1aeef044346664', 'a324wkljsknfs', '删除', 'del', 'ActionPanel', 'icon-standard-pencil-delete', 'button', 'disabled', 'glacier.permissions_mgr.res_mgr.res.delAction();', '3', '');
INSERT INTO `t_action` VALUES ('werdb546456', 'a324wkljsknfs', '修改', 'edit', 'MenuPanel', 'icon-standard-pencil-go', 'button', 'disabled', 'glacier.permissions_mgr.res_mgr.res.editMenu();', '2', '');

-- ----------------------------
-- Table structure for `t_add`
-- ----------------------------
DROP TABLE IF EXISTS `t_add`;
CREATE TABLE `t_add` (
  `add_id` varchar(32) NOT NULL,
  `add_cn_name` varchar(255) default NULL,
  `user_id` varchar(32) NOT NULL,
  PRIMARY KEY  (`add_id`),
  KEY `Fkwer` (`user_id`),
  CONSTRAINT `Fkwer` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_add
-- ----------------------------
INSERT INTO `t_add` VALUES ('wersdfsdf', '草泥马', '07f211657c8c6b31ee4360c88917e5d2');
INSERT INTO `t_add` VALUES ('zxczxasd', '问哦如', '07f211657c8c6b31ee4360c88917e5qw');

-- ----------------------------
-- Table structure for `t_authority`
-- ----------------------------
DROP TABLE IF EXISTS `t_authority`;
CREATE TABLE `t_authority` (
  `role_id` varchar(32) NOT NULL COMMENT '主键、唯一',
  `menu_id` varchar(32) NOT NULL COMMENT '菜单主键Id',
  `actions` varchar(255) default NULL COMMENT '动作组合',
  PRIMARY KEY  (`role_id`,`menu_id`),
  KEY `FK_t_authority2` (`menu_id`),
  CONSTRAINT `FK_t_authority1` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`role_id`),
  CONSTRAINT `FK_t_authority2` FOREIGN KEY (`menu_id`) REFERENCES `t_menu` (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限_菜单角色中间表';

-- ----------------------------
-- Records of t_authority
-- ----------------------------
INSERT INTO `t_authority` VALUES ('sadasdasd', '234234werwer', 'add,edit,auth');
INSERT INTO `t_authority` VALUES ('sadasdasd', 'a324wkljsknfs', 'MenuPanel_add,MenuPanel_edit,MenuPanel_del,ActionPanel_add,ActionPanel_edit,ActionPanel_del');
INSERT INTO `t_authority` VALUES ('sadasdasd', 'e550884c5e6c1e94ee70cc833aa1c2b9', 'RolePanel_add,RolePanel_edit,RolePanel_del,RolePanel_auth,RolePanel_actionAuth');
INSERT INTO `t_authority` VALUES ('sadasdasd', 'sdfsdf', 'add,edit,auth');

-- ----------------------------
-- Table structure for `t_dep`
-- ----------------------------
DROP TABLE IF EXISTS `t_dep`;
CREATE TABLE `t_dep` (
  `dep_id` varchar(32) NOT NULL,
  `dep_name` varchar(255) default NULL,
  `pid` varchar(255) default NULL,
  PRIMARY KEY  (`dep_id`),
  KEY `FK_dep_pid` (`pid`),
  CONSTRAINT `FK_dep_pid` FOREIGN KEY (`pid`) REFERENCES `t_dep` (`dep_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_dep
-- ----------------------------
INSERT INTO `t_dep` VALUES ('bingchuangruanjian', '冰川软件', null);
INSERT INTO `t_dep` VALUES ('caiwubu', '财务部', 'bingchuangruanjian');
INSERT INTO `t_dep` VALUES ('kaifabu', '开发部', 'bingchuangruanjian');

-- ----------------------------
-- Table structure for `t_field`
-- ----------------------------
DROP TABLE IF EXISTS `t_field`;
CREATE TABLE `t_field` (
  `field_id` varchar(32) NOT NULL COMMENT '主键、唯一',
  `field` varchar(64) default NULL COMMENT '字段(英文)',
  `field_name` varchar(128) default NULL COMMENT '字段名(中文)',
  `value_field` varchar(128) default NULL COMMENT '字段值',
  `display_field` varchar(128) default NULL COMMENT '显示值',
  `enabled` tinyint(4) default NULL COMMENT '是否可用',
  `sort` int(11) default NULL COMMENT '排序字段',
  `remark` varchar(255) default NULL,
  PRIMARY KEY  (`field_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统_字段';

-- ----------------------------
-- Records of t_field
-- ----------------------------

-- ----------------------------
-- Table structure for `t_group`
-- ----------------------------
DROP TABLE IF EXISTS `t_group`;
CREATE TABLE `t_group` (
  `group_id` varchar(32) NOT NULL COMMENT '用户组主键',
  `group_cn_name` varchar(25) default NULL COMMENT '用户组中文名',
  `group_en_name` varchar(25) default NULL COMMENT '用户组英文名',
  `group_type` varchar(20) default NULL COMMENT '用户组类别',
  `status` varchar(30) default NULL COMMENT '状态',
  `order_num` int(10) unsigned default NULL COMMENT '排序',
  `remark` varchar(50) default NULL COMMENT '备注',
  PRIMARY KEY  (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限_用户组';

-- ----------------------------
-- Records of t_group
-- ----------------------------
INSERT INTO `t_group` VALUES ('2234oolsdf', '管理员组', 'admin_gr', null, null, null, null);

-- ----------------------------
-- Table structure for `t_group_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_group_role`;
CREATE TABLE `t_group_role` (
  `role_id` varchar(32) NOT NULL COMMENT '主键、唯一',
  `group_id` varchar(32) NOT NULL COMMENT '用户组主键',
  PRIMARY KEY  (`role_id`,`group_id`),
  KEY `FK_t_group_role2` (`group_id`),
  CONSTRAINT `FK_t_group_role1` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`role_id`),
  CONSTRAINT `FK_t_group_role2` FOREIGN KEY (`group_id`) REFERENCES `t_group` (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限_组角色中间表';

-- ----------------------------
-- Records of t_group_role
-- ----------------------------
INSERT INTO `t_group_role` VALUES ('sadasdasd', '2234oolsdf');
INSERT INTO `t_group_role` VALUES ('sdferwwerewr', '2234oolsdf');

-- ----------------------------
-- Table structure for `t_group_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_group_user`;
CREATE TABLE `t_group_user` (
  `user_id` varchar(32) NOT NULL COMMENT '主键、唯一ID',
  `group_id` varchar(32) NOT NULL COMMENT '用户组主键',
  PRIMARY KEY  (`user_id`,`group_id`),
  KEY `FK_t_group_user2` (`group_id`),
  CONSTRAINT `FK_t_group_user1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`),
  CONSTRAINT `FK_t_group_user2` FOREIGN KEY (`group_id`) REFERENCES `t_group` (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限_组用户中间表';

-- ----------------------------
-- Records of t_group_user
-- ----------------------------
INSERT INTO `t_group_user` VALUES ('07f211657c8c6b31ee4360c88917e5d2', '2234oolsdf');
INSERT INTO `t_group_user` VALUES ('07f211657c8c6b31ee4360c88917e5qw', '2234oolsdf');

-- ----------------------------
-- Table structure for `t_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `menu_id` varchar(32) NOT NULL COMMENT '菜单主键Id',
  `pid` varchar(32) default NULL COMMENT '父级菜单Id',
  `menu_en_name` varchar(30) default NULL COMMENT '菜单英文名称',
  `menu_cn_name` varchar(30) default NULL COMMENT '英文中文名称',
  `icon_cls` varchar(50) default NULL COMMENT '菜单图标样式',
  `url` varchar(100) default NULL COMMENT '菜单请求URL',
  `order_num` int(10) unsigned default NULL COMMENT '排序',
  `remark` varchar(255) default NULL COMMENT '备注',
  PRIMARY KEY  (`menu_id`),
  KEY `FK_menu2parent1N` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限_菜单';

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('234234werwer', null, 'system', '系统设置', 'icon-standard-computer', '', '1', '');
INSERT INTO `t_menu` VALUES ('41244b1c1ff9d4eb8f363c2f20bf8028', '234234werwer', 'log', '系统日志', 'icon-standard-script', '/do/log/index.htm', '10', '系统日志包括操作日志和登录日志两种类型');
INSERT INTO `t_menu` VALUES ('a324wkljsknfs', '234234werwer', 'res', '资源管理', 'icon-cologne-featured', '/do/res/index.htm', '2', '');
INSERT INTO `t_menu` VALUES ('e550884c5e6c1e94ee70cc833aa1c2b9', '234234werwer', 'role', '角色管理', 'icon-standard-status-online', '/do/role/index.htm', '8', '');
INSERT INTO `t_menu` VALUES ('sdfsdf', '234234werwer', 'user', '用户管理', 'icon-standard-cd', '/do/menu/index.htm', '3', '');

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `role_id` varchar(32) NOT NULL COMMENT '主键、唯一',
  `role_en_name` varchar(25) NOT NULL COMMENT '角色英文名(大写)',
  `role_cn_name` varchar(25) default NULL COMMENT '角色中文名',
  `builtin` varchar(10) default NULL COMMENT '枚举：内置(BUILTIN)，非内置(NONINTRINSIC)',
  `inherit` varchar(10) default NULL COMMENT '是否继承角色组权限',
  `remark` varchar(255) default NULL COMMENT '备注',
  PRIMARY KEY  (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限_角色';

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('dklfjg345', 'werwss', '测试管理员', null, null, null);
INSERT INTO `t_role` VALUES ('sadasdasd', 'asdf', '管理员', null, null, null);
INSERT INTO `t_role` VALUES ('sdferwwerewr', 'sdferw', '公告管理员', null, null, null);
INSERT INTO `t_role` VALUES ('xcvxvsdf', 'werwer', '系统管理员', null, null, null);

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` varchar(32) NOT NULL COMMENT '主键、唯一ID',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(64) NOT NULL COMMENT '密码，MD5加密',
  `salt` varchar(50) default NULL COMMENT '安全密码，作为用户的盐值，解密用',
  `status` varchar(20) NOT NULL COMMENT '用户状态，包括启用，隐藏，冻结，弃用',
  `builtin` varchar(10) NOT NULL COMMENT '枚举：内置(BUILTIN)，非内置(NONINTRINSIC)',
  `email` varchar(50) default NULL COMMENT '电子邮件',
  `user_image` varchar(50) default NULL COMMENT '用户头像所在磁盘路径',
  `remark` varchar(255) default NULL COMMENT '备注',
  `last_login_time` datetime default NULL COMMENT '最后登录时间',
  `last_login_ip_address` varchar(15) default NULL COMMENT '最后登录IP地址',
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限_用户';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('07f211657c8c6b31ee4360c88917e5d2', 'admin', '5dc10e7826e648ec6f136974c38f81d0e5e1d0ae', 'e03b1b95ceff4db6', 'enable', 'builtin', null, null, null, null, null);
INSERT INTO `t_user` VALUES ('07f211657c8c6b31ee4360c88917e5qw', 'user', 'user', null, 'enable', 'builtin', null, null, null, null, null);

-- ----------------------------
-- Table structure for `t_user_exp`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_exp`;
CREATE TABLE `t_user_exp` (
  `user_id` varchar(32) NOT NULL COMMENT '主键、唯一ID',
  `user_en_name` varchar(30) default NULL COMMENT '英文名',
  `user_cn_name` varchar(25) default NULL COMMENT '真实名字',
  PRIMARY KEY  (`user_id`),
  CONSTRAINT `FK_user2userExp11` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限_用户扩展';

-- ----------------------------
-- Records of t_user_exp
-- ----------------------------
INSERT INTO `t_user_exp` VALUES ('07f211657c8c6b31ee4360c88917e5d2', 'zhangzhenfei', '张振飞');
INSERT INTO `t_user_exp` VALUES ('07f211657c8c6b31ee4360c88917e5qw', 'user', '卡卡');

-- ----------------------------
-- Table structure for `t_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `user_id` varchar(32) NOT NULL COMMENT '主键、唯一ID',
  `role_id` varchar(32) NOT NULL COMMENT '主键、唯一',
  PRIMARY KEY  (`user_id`,`role_id`),
  KEY `FK_t_user_role2` (`role_id`),
  CONSTRAINT `FK_t_user_role1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`),
  CONSTRAINT `FK_t_user_role2` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限_用户角色中间表';

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('07f211657c8c6b31ee4360c88917e5qw', 'sadasdasd');
INSERT INTO `t_user_role` VALUES ('07f211657c8c6b31ee4360c88917e5d2', 'sdferwwerewr');
INSERT INTO `t_user_role` VALUES ('07f211657c8c6b31ee4360c88917e5d2', 'xcvxvsdf');
