/*
Navicat MySQL Data Transfer

Source Server         : 本地MySql
Source Server Version : 50067
Source Host           : localhost:3306
Source Database       : chat

Target Server Type    : MYSQL
Target Server Version : 50067
File Encoding         : 65001

Date: 2013-12-28 16:27:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tmpdep`
-- ----------------------------
DROP TABLE IF EXISTS `tmpdep`;
CREATE TABLE `tmpdep` (
  `id` varchar(32) default NULL,
  `nLevel` int(11) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tmpdep
-- ----------------------------
INSERT INTO `tmpdep` VALUES ('kaifabu', '0');
INSERT INTO `tmpdep` VALUES ('yanfabu', '1');
INSERT INTO `tmpdep` VALUES ('yanfayibu', '2');

-- ----------------------------
-- Table structure for `treenodes`
-- ----------------------------
DROP TABLE IF EXISTS `treenodes`;
CREATE TABLE `treenodes` (
  `id` int(11) NOT NULL,
  `nodename` varchar(20) default NULL,
  `pid` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of treenodes
-- ----------------------------
INSERT INTO `treenodes` VALUES ('1', 'A', '0');
INSERT INTO `treenodes` VALUES ('2', 'B', '1');
INSERT INTO `treenodes` VALUES ('3', 'C', '1');
INSERT INTO `treenodes` VALUES ('4', 'D', '2');
INSERT INTO `treenodes` VALUES ('5', 'E', '2');
INSERT INTO `treenodes` VALUES ('6', 'F', '3');
INSERT INTO `treenodes` VALUES ('7', 'G', '6');

-- ----------------------------
-- Table structure for `t_action`
-- ----------------------------
DROP TABLE IF EXISTS `t_action`;
CREATE TABLE `t_action` (
  `action_id` varchar(32) NOT NULL COMMENT '操作主键Id',
  `menu_id` varchar(32) default NULL COMMENT '操作所在菜单外键',
  `panel_id` varchar(32) default NULL,
  `auth_range` enum('Close','Open') default NULL COMMENT ' 是否需要权限范围控制',
  `default_action` enum('NonDefault','Default') default NULL COMMENT '是否默认操作',
  `action_cn_name` varchar(30) NOT NULL COMMENT '操作中文名称',
  `action_en_name` varchar(30) NOT NULL COMMENT '操作英文名称',
  `icon_cls` varchar(30) default NULL COMMENT '操作样式',
  `type` enum('Link','Button') default 'Button' COMMENT '操作类型：按钮/超链接',
  `disabled` enum('Enabled','Disabled') default NULL COMMENT '默认打开是否禁用',
  `method` varchar(100) default NULL COMMENT '操作调用前台JS方法',
  `order_num` int(10) unsigned default NULL COMMENT '排序',
  `remark` varchar(50) default NULL COMMENT '备注',
  `creater` varchar(32) default NULL,
  `create_time` date default NULL,
  PRIMARY KEY  (`action_id`),
  KEY `FK_t_action_t_menu_id` USING BTREE (`menu_id`),
  CONSTRAINT `FK_t_action_t_menu_id` FOREIGN KEY (`menu_id`) REFERENCES `t_menu` (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_action
-- ----------------------------
INSERT INTO `t_action` VALUES ('18060139f0e736a796d5ac4bdd78eadc', 'e550884c5e6c1e94ee70cc833aa1c2b9', '83bbeed02a85549ae84cde8d98bcd8c1', 'Open', 'NonDefault', '修改', 'edit', 'icon-standard-pencil-go', 'Button', 'Disabled', 'glacier.permissions_mgr.role_mgr.role.editRole();', '2', '', '07f211657c8c6b31ee4360c88917e5d2', '2013-12-18');
INSERT INTO `t_action` VALUES ('1c03e9c9af10b312c625ef94a6eedd83', 'e550884c5e6c1e94ee70cc833aa1c2b9', '83bbeed02a85549ae84cde8d98bcd8c1', 'Open', 'Default', '列表', 'list', '', 'Button', 'Enabled', '', '1', '', null, null);
INSERT INTO `t_action` VALUES ('374ec973386e4070b4fa0e4903c226c9', 'a324wkljsknfs', 'a8cd691ee27a9251cd5815a27ba77346', 'Open', 'Default', '列表', 'list', '', 'Button', 'Enabled', '', '1', '', null, null);
INSERT INTO `t_action` VALUES ('429f54b614db46af58598c8d9a47a36f', 'a324wkljsknfs', 'f70cea540b93849f63396becde171532', 'Open', 'NonDefault', '删除', 'del', 'icon-standard-pencil-delete', 'Button', 'Disabled', 'glacier.permissions_mgr.res_mgr.res.delPanel();', '4', '', '07f211657c8c6b31ee4360c88917e5d2', '2013-12-18');
INSERT INTO `t_action` VALUES ('4de1a37c75530995939ee56418060f56', 'a324wkljsknfs', 'f70cea540b93849f63396becde171532', 'Open', 'Default', '列表', 'list', '', 'Button', 'Enabled', '', '1', '', null, null);
INSERT INTO `t_action` VALUES ('5db796929f23e991708fd0af99b3b4bc', 'e550884c5e6c1e94ee70cc833aa1c2b9', '83bbeed02a85549ae84cde8d98bcd8c1', 'Close', 'NonDefault', '增加', 'add', 'icon-standard-pencil-add', 'Button', 'Enabled', 'glacier.permissions_mgr.role_mgr.role.addRole();', '1', '', '07f211657c8c6b31ee4360c88917e5d2', '2013-12-18');
INSERT INTO `t_action` VALUES ('6838d18fa1e582d4dc28404a80445c88', 'a324wkljsknfs', 'eb07f8ec54989seb66e4e8a1a0f21604', 'Close', 'NonDefault', '增加', 'add', 'icon-standard-pencil-add', 'Button', 'Enabled', 'glacier.permissions_mgr.res_mgr.res.addMenu();', '2', '', '07f211657c8c6b31ee4360c88917e5d2', '2013-12-18');
INSERT INTO `t_action` VALUES ('6c0bc1e009b3742af24d7bdc94adec3c', 'a324wkljsknfs', 'f70cea540b93849f63396becde171532', 'Close', 'NonDefault', '增加', 'add', 'icon-standard-pencil-add', 'Button', 'Enabled', 'glacier.permissions_mgr.res_mgr.res.addPanel();', '2', '', '07f211657c8c6b31ee4360c88917e5d2', '2013-12-18');
INSERT INTO `t_action` VALUES ('6e1027dd7e57195d06dd2fac811f8ebf', 'a324wkljsknfs', 'eb07f8ec54989seb66e4e8a1a0f21604', 'Open', 'NonDefault', '修改', 'edit', 'icon-standard-pencil-go', 'Button', 'Disabled', 'glacier.permissions_mgr.res_mgr.res.editMenu();', '3', '', '07f211657c8c6b31ee4360c88917e5d2', '2013-12-18');
INSERT INTO `t_action` VALUES ('8eb3b50d119f05c30127c3359e4a5d2a', 'e550884c5e6c1e94ee70cc833aa1c2b9', '83bbeed02a85549ae84cde8d98bcd8c1', 'Open', 'NonDefault', '删除', 'del', 'icon-standard-pencil-delete', 'Button', 'Disabled', 'glacier.permissions_mgr.role_mgr.role.delRole();', '3', '', '07f211657c8c6b31ee4360c88917e5qw', '2013-12-18');
INSERT INTO `t_action` VALUES ('9320f5b0199abd8d53990eef7cdcd745', 'a324wkljsknfs', 'a8cd691ee27a9251cd5815a27ba77346', 'Open', 'NonDefault', '编辑', 'edit', 'icon-standard-pencil-go', 'Button', 'Disabled', 'glacier.permissions_mgr.res_mgr.res.editAction();', '3', '', '07f211657c8c6b31ee4360c88917e5qw', '2013-12-18');
INSERT INTO `t_action` VALUES ('b0f605139653554aa66cf38a78fe42ba', 'a324wkljsknfs', 'eb07f8ec54989seb66e4e8a1a0f21604', 'Open', 'Default', '列表', 'list', '', 'Button', 'Disabled', '', '1', '', null, null);
INSERT INTO `t_action` VALUES ('b34352268cb171aee1f8e2110657beab', 'e550884c5e6c1e94ee70cc833aa1c2b9', '83bbeed02a85549ae84cde8d98bcd8c1', 'Open', 'NonDefault', '权限维护', 'actionAuth', 'icon-standard-key-go', 'Button', 'Enabled', 'glacier.permissions_mgr.role_mgr.role.actionAuth();', '5', '', '07f211657c8c6b31ee4360c88917e5d2', '2013-12-18');
INSERT INTO `t_action` VALUES ('b5852fac0798a25a13b87e8532c60440', 'a324wkljsknfs', 'eb07f8ec54989seb66e4e8a1a0f21604', 'Open', 'NonDefault', '删除', 'del', 'icon-standard-pencil-delete', 'Button', 'Disabled', 'glacier.permissions_mgr.res_mgr.res.delMenu();', '4', '', '07f211657c8c6b31ee4360c88917e5qw', '2013-12-18');
INSERT INTO `t_action` VALUES ('dad8f671986722837f7eecb2b77c284b', 'a324wkljsknfs', 'f70cea540b93849f63396becde171532', 'Open', 'NonDefault', '修改', 'edit', 'icon-standard-pencil-go', 'Button', 'Disabled', 'glacier.permissions_mgr.res_mgr.res.editPanel();', '3', '', '07f211657c8c6b31ee4360c88917e5d2', '2013-12-18');
INSERT INTO `t_action` VALUES ('e550884c5e6c1e94a970cc833aa1c2b9', 'a324wkljsknfs', 'a8cd691ee27a9251cd5815a27ba77346', 'Close', 'NonDefault', '增加', 'add', 'icon-standard-pencil-add', 'Button', 'Enabled', 'glacier.permissions_mgr.res_mgr.res.addAction();', '2', '', '07f211657c8c6b31ee4360c88917e5d2', '2013-12-18');
INSERT INTO `t_action` VALUES ('f4b5eca05e616d411f1aeef044346664', 'a324wkljsknfs', 'a8cd691ee27a9251cd5815a27ba77346', 'Open', 'NonDefault', '删除', 'del', 'icon-standard-pencil-delete', 'Button', 'Disabled', 'glacier.permissions_mgr.res_mgr.res.delAction();', '4', '', '07f211657c8c6b31ee4360c88917e5qw', '2013-12-18');

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
  `actions` varchar(21779) default NULL COMMENT '动作组合',
  PRIMARY KEY  (`role_id`,`menu_id`),
  KEY `FK_t_authority2` (`menu_id`),
  CONSTRAINT `FK_t_authority1` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`role_id`),
  CONSTRAINT `FK_t_authority2` FOREIGN KEY (`menu_id`) REFERENCES `t_menu` (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限_菜单角色中间表';

-- ----------------------------
-- Records of t_authority
-- ----------------------------
INSERT INTO `t_authority` VALUES ('ddde8880768be2c4178c5388108df64b', '234234werwer', null);
INSERT INTO `t_authority` VALUES ('ddde8880768be2c4178c5388108df64b', 'a324wkljsknfs', 'ActionPanel_list:ALL,ActionPanel_add:ALL,ActionPanel_edit:ALL,ActionPanel_del:DEP,MenuPanel_list:ALL,MenuPanel_add:ALL,MenuPanel_edit:ALL,MenuPanel_del:ALL,Panel_list:ALL,Panel_add:ALL,Panel_edit:ALL,Panel_del:ALL');
INSERT INTO `t_authority` VALUES ('ddde8880768be2c4178c5388108df64b', 'e550884c5e6c1e94ee70cc833aa1c2b9', 'RolePanel_list:DEP,RolePanel_add:ALL,RolePanel_edit:ALL,RolePanel_del:SELF,RolePanel_actionAuth:DEP');
INSERT INTO `t_authority` VALUES ('ddde8880768be2c4178c5388108df64b', 'sdfsdf', null);
INSERT INTO `t_authority` VALUES ('dklfjg345', '234234werwer', null);
INSERT INTO `t_authority` VALUES ('dklfjg345', 'a324wkljsknfs', 'ActionPanel_list:ALL,ActionPanel_add:ALL,ActionPanel_edit:DEPC,ActionPanel_del:DEP,MenuPanel_list:SELF,MenuPanel_add:ALL,MenuPanel_del:DEP');
INSERT INTO `t_authority` VALUES ('dklfjg345', 'e550884c5e6c1e94ee70cc833aa1c2b9', 'RolePanel_list:DEP,RolePanel_edit:DEP,RolePanel_del:DEPC');
INSERT INTO `t_authority` VALUES ('dklfjg345', 'sdfsdf', null);
INSERT INTO `t_authority` VALUES ('sadasdasd', '234234werwer', 'add:ALL,edit:ALL,auth:ALL');
INSERT INTO `t_authority` VALUES ('sadasdasd', '29f319e4af6c62091e23eaa8d9bb7c6b', null);
INSERT INTO `t_authority` VALUES ('sadasdasd', '41244b1c1ff9d4eb8f363c2f20bf8028', null);
INSERT INTO `t_authority` VALUES ('sadasdasd', 'a324wkljsknfs', 'ActionPanel_list:ALL,ActionPanel_add:ALL,ActionPanel_edit:DEP,ActionPanel_del:DEPC,MenuPanel_list:ALL,MenuPanel_add:ALL,MenuPanel_edit:ALL,MenuPanel_del:SELF,Panel_list:ALL,Panel_add:ALL,Panel_edit:ALL,Panel_del:ALL');
INSERT INTO `t_authority` VALUES ('sadasdasd', 'e550884c5e6c1e94ee70cc833aa1c2b9', 'RolePanel_list:SELF,RolePanel_add:ALL,RolePanel_edit:ALL,RolePanel_del:ALL,RolePanel_actionAuth:DEP');
INSERT INTO `t_authority` VALUES ('sadasdasd', 'sdfsdf', 'add:ALL,edit:ALL,auth:ALL');
INSERT INTO `t_authority` VALUES ('sdferwwerewr', '234234werwer', null);
INSERT INTO `t_authority` VALUES ('sdferwwerewr', 'a324wkljsknfs', 'ActionPanel_list,MenuPanel_list,Panel_list');
INSERT INTO `t_authority` VALUES ('sdferwwerewr', 'e550884c5e6c1e94ee70cc833aa1c2b9', null);

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
INSERT INTO `t_dep` VALUES ('atest', '测试部', 'caiwubu');
INSERT INTO `t_dep` VALUES ('bingchuangruanjian', '冰川软件', null);
INSERT INTO `t_dep` VALUES ('caiwubu', '财务部', 'bingchuangruanjian');
INSERT INTO `t_dep` VALUES ('kaifabu', '开发部', 'bingchuangruanjian');
INSERT INTO `t_dep` VALUES ('yanfabu', '研发部', 'kaifabu');
INSERT INTO `t_dep` VALUES ('yanfayibu', '研发一部', 'yanfabu');

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
INSERT INTO `t_menu` VALUES ('29f319e4af6c62091e23eaa8d9bb7c6b', '234234werwer', 'preferences', '首选参数', 'icon-standard-disconnect', '/do/preferences/index.htm', '1', '用于配置系统业务功能');
INSERT INTO `t_menu` VALUES ('41244b1c1ff9d4eb8f363c2f20bf8028', '234234werwer', 'log', '系统日志', 'icon-standard-script', '/do/log/index.htm', '10', '系统日志包括操作日志和登录日志两种类型');
INSERT INTO `t_menu` VALUES ('a324wkljsknfs', '234234werwer', 'res', '资源管理', 'icon-cologne-featured', '/do/res/index.htm', '2', '');
INSERT INTO `t_menu` VALUES ('e550884c5e6c1e94ee70cc833aa1c2b9', '234234werwer', 'role', '角色管理', 'icon-standard-status-online', '/do/role/index.htm', '3', '');
INSERT INTO `t_menu` VALUES ('sdfsdf', '234234werwer', 'user', '用户管理', 'icon-standard-user', '/do/menu/index.htm', '4', '');

-- ----------------------------
-- Table structure for `t_panel`
-- ----------------------------
DROP TABLE IF EXISTS `t_panel`;
CREATE TABLE `t_panel` (
  `panel_id` varchar(32) NOT NULL,
  `menu_id` varchar(32) default NULL,
  `panel_cn_name` varchar(50) default NULL,
  `panel_en_name` varchar(50) default NULL,
  `order_num` int(11) default NULL,
  PRIMARY KEY  (`panel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_panel
-- ----------------------------
INSERT INTO `t_panel` VALUES ('83bbeed02a85549ae84cde8d98bcd8c1', 'e550884c5e6c1e94ee70cc833aa1c2b9', '角色', 'RolePanel', '1');
INSERT INTO `t_panel` VALUES ('a8cd691ee27a9251cd5815a27ba77346', 'a324wkljsknfs', '操作管理', 'ActionPanel', '3');
INSERT INTO `t_panel` VALUES ('eb07f8ec54989seb66e4e8a1a0f21604', 'a324wkljsknfs', '菜单管理', 'MenuPanel', '1');
INSERT INTO `t_panel` VALUES ('f70cea540b93849f63396becde171532', 'a324wkljsknfs', '面板管理', 'Panel', '2');

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
  `creater` varchar(32) default NULL,
  `create_time` date default NULL,
  PRIMARY KEY  (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限_角色';

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('ddde8880768be2c4178c5388108df64b', 'Test', '测试', null, null, '', '07f211657c8c6b31ee4360c88917e5d2', '2013-12-18');
INSERT INTO `t_role` VALUES ('dklfjg345', 'werwss', '测试管理员', null, null, null, '07f211657c8c6b31ee4360c88917e5d2', '2013-12-18');
INSERT INTO `t_role` VALUES ('ecbd91701e8363c24504ddfa50411e64', 'tsss4445', '测试3345', null, null, '', '07f211657c8c6b31ee4360c88917e5qw', '2013-12-18');
INSERT INTO `t_role` VALUES ('sadasdasd', 'asdf', '管理员', null, null, null, '07f211657c8c6b31ee4360c88917e5d2', '2013-12-18');
INSERT INTO `t_role` VALUES ('sdferwwerewr', 'sdferw', '公告管理员', null, null, null, '07f211657c8c6b31ee4360c88917e5d2', '2013-12-18');
INSERT INTO `t_role` VALUES ('xcvxvsdf', 'werwer', '系统管理员', null, null, null, '07f211657c8c6b31ee4360c88917e5qw', '2013-12-18');

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
  `creater` varchar(32) default NULL,
  `create_time` date default NULL,
  `dep_id` varchar(32) default NULL,
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限_用户';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('07f211657c8c6b31ee4360c88917e5d2', 'admin', '5dc10e7826e648ec6f136974c38f81d0e5e1d0ae', 'e03b1b95ceff4db6', 'enable', 'builtin', null, null, null, null, null, '07f211657c8c6b31ee4360c88917e5d2', '2013-12-25', 'bingchuangruanjian');
INSERT INTO `t_user` VALUES ('07f211657c8c6b31ee4360c88917e5qw', 'user', '5dc10e7826e648ec6f136974c38f81d0e5e1d0ae', 'e03b1b95ceff4db6', 'enable', 'builtin', null, null, null, null, null, '07f211657c8c6b31ee4360c88917e5d2', '2013-12-25', 'kaifabu');
INSERT INTO `t_user` VALUES ('60409abd739a12ae676992c92a1bfbbf', 'test', 'test', null, 'enable', 'builtin', null, null, null, null, null, '07f211657c8c6b31ee4360c88917e5d2', '2013-12-25', 'caiwubu');

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
INSERT INTO `t_user_role` VALUES ('07f211657c8c6b31ee4360c88917e5qw', 'dklfjg345');
INSERT INTO `t_user_role` VALUES ('07f211657c8c6b31ee4360c88917e5d2', 'sadasdasd');
INSERT INTO `t_user_role` VALUES ('07f211657c8c6b31ee4360c88917e5d2', 'xcvxvsdf');

-- ----------------------------
-- Procedure structure for `createChildLst`
-- ----------------------------
DROP PROCEDURE IF EXISTS `createChildLst`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `createChildLst`(IN rootId INT,IN nDepth INT)
BEGIN  
      DECLARE done INT DEFAULT 0;  
      DECLARE b INT;  
      DECLARE cur1 CURSOR FOR SELECT id FROM treeNodes where pid=rootId;  
      DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;  
      
      insert into tmpLst values (null,rootId,nDepth);  
  
      
      OPEN cur1;  
      
      FETCH cur1 INTO b;  
      WHILE done=0 DO  
              CALL createChildLst(b,nDepth+1);  
              FETCH cur1 INTO b;  
      END WHILE;  
      
      CLOSE cur1;
			
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `showTreeNodes`
-- ----------------------------
DROP PROCEDURE IF EXISTS `showTreeNodes`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `showTreeNodes`(IN rootId VARCHAR(32))
BEGIN

 DECLARE Level int;#定义变量Level int 类型
 Set Level= 0;

 CREATE TABLE IF NOT EXISTS tmpDep (#如果中间表不存在创建中间表
  id varchar(32),
  nLevel int
 );
 DELETE FROM tmpdep;#清空表数据
 
 INSERT INTO tmpDep VALUES (rootId,Level);

 WHILE ROW_COUNT()>0 DO #如果插入数据成功，Level自动加1，获取该成功行，自动插入子部门
		SET Level=Level+1 ;
		INSERT into tmpDep 
			SELECT A.dep_id,Level FROM t_dep A,tmpDep B 
    WHERE  A.pid=B.id AND B.nLevel=Level-1  ;
 END WHILE;

 SELECT temp_del.dep_id FROM t_dep temp_del,tmpDep B WHERE temp_del.dep_id=B.id ORDER BY B.nLevel;

END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `showTreeNodes_yongyupost2000`
-- ----------------------------
DROP PROCEDURE IF EXISTS `showTreeNodes_yongyupost2000`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `showTreeNodes_yongyupost2000`(IN rootid INT)
BEGIN
 DECLARE Level int ;#定义变量Level int 类型
 drop TABLE IF EXISTS tmpDep; #定义中间表，后面会进行遍历
 CREATE TABLE tmpDep (#创建中间表
  id varchar(32),
  nLevel int,
  sCort varchar(8000)
 );
 Set Level= 0;
INSERT INTO tmpDep VALUES (rootId,Level,rootId);
INSERT INTO tmpDep SELECT id,Level+1,ID FROM t_dep WHERE pid = rootId;
 WHILE ROW_COUNT()>0 DO
		SET Level=Level+1 ;
		INSERT into tmpDep 
		SELECT A.dep_id,Level,concat(B.sCort,A.dep_id) FROM t_dep A,tmpDep B 
    WHERE  A.pid=B.id AND B.nLevel=Level-1  ;
 END WHILE;
  
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for `getChildLst`
-- ----------------------------
DROP FUNCTION IF EXISTS `getChildLst`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `getChildLst`(rootId INT) RETURNS varchar(1000) CHARSET utf8
BEGIN
DECLARE sTemp VARCHAR(1000);
DECLARE sTempChd VARCHAR(1000);
SET sTemp = '$';
SET sTempChd =cast(rootId as CHAR);
WHILE sTempChd is not null DO
SET sTemp = concat(sTemp,',',sTempChd);
SELECT group_concat(id) INTO sTempChd FROM treeNodes where FIND_IN_SET(pid,sTempChd)>0;
END WHILE;

RETURN sTemp;
END
;;
DELIMITER ;
