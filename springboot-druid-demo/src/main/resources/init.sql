-- boss用户表
CREATE TABLE `boss_user` (
	`id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
	`login_name` varchar(32) NOT NULL DEFAULT '' COMMENT '登录用户名',
	`real_name` varchar(256) NOT NULL DEFAULT '' COMMENT '用户直实姓名',
	`sex` int(11) NOT NULL DEFAULT 0 COMMENT '用户的性别，值为1时是男性，值为2时是女性，值为0时是未知',
	`password` varchar(32) NOT NULL DEFAULT '' COMMENT '密码',
	`salt` varchar(32) NOT NULL DEFAULT '' COMMENT '加密密码的盐',
	`status` int(11) NOT NULL DEFAULT 1 COMMENT '状态：0-不可用，1-可用',
	`last_login_time` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '最后次的登录时间',
	`department_id` int(11) NOT NULL DEFAULT 0 COMMENT '所属部门id',
	`create_time` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` timestamp DEFAULT CURRENT_TIMESTAMP on update current_timestamp COMMENT '最后更新时间',
	CONSTRAINT uq_login_name UNIQUE(login_name),
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='boss用户表';
-- 初始化数据:密码为888888
insert into boss_user (id, login_name, real_name, sex,password) VALUES (1, 'admin','管理员',1, '111111');
