
CREATE TABLE `access` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `access_name` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='权限表';



CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(255) NOT NULL COMMENT '书籍名称',
  `book_describe` varchar(1024) DEFAULT NULL COMMENT '书籍描述',
  `creat_username` varchar(10) NOT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8 COMMENT='图书信息';



CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(32) NOT NULL COMMENT '角色名称',
  `role_describe` varchar(128) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='角色表';



CREATE TABLE `role_access` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `access_id` int(11) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='角色权限表';



CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(32) NOT NULL COMMENT '用户名称',
  `username` varchar(32) NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户表';



CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户角色表';

INSERT INTO `user`
(id, nickname, username, password)
VALUES(1, '系统管理员', 'root', 'f6ca2148e71470662b19bad4e30955c4');
INSERT INTO `user`
(id, nickname, username, password)
VALUES(2, '图书管理员', 'bookManager', 'c48663c2fc43f00b256767d8bd763dcc');
INSERT INTO `user`
(id, nickname, username, password)
VALUES(3, '普通用户', 'test1', '97a6a2c27640d844b6d0870e0ac72de1');
INSERT INTO `role`
(id, role_name, role_describe)
VALUES(1, '系统管理员', '超级管理员，我最大');
INSERT INTO `role`
(id, role_name, role_describe)
VALUES(2, '图书管理员', '图书管理员，能对图书做增删改查');
INSERT INTO `role`
(id, role_name, role_describe)
VALUES(3, '普通用户', '只能浏览');
INSERT INTO access
(id, access_name)
VALUES(1, 'book.get');
INSERT INTO access
(id, access_name)
VALUES(2, 'book.update');
INSERT INTO access
(id, access_name)
VALUES(3, 'book.add');
INSERT INTO access
(id, access_name)
VALUES(4, 'book.del');
INSERT INTO role_access
(id, role_id, access_id)
VALUES(1, 1, 1);
INSERT INTO role_access
(id, role_id, access_id)
VALUES(2, 1, 2);
INSERT INTO role_access
(id, role_id, access_id)
VALUES(3, 1, 3);
INSERT INTO role_access
(id, role_id, access_id)
VALUES(4, 1, 4);
INSERT INTO role_access
(id, role_id, access_id)
VALUES(5, 2, 1);
INSERT INTO role_access
(id, role_id, access_id)
VALUES(6, 2, 2);
INSERT INTO role_access
(id, role_id, access_id)
VALUES(7, 2, 3);
INSERT INTO role_access
(id, role_id, access_id)
VALUES(8, 2, 4);
INSERT INTO role_access
(id, role_id, access_id)
VALUES(9, 3, 1);
INSERT INTO user_role
(id, user_id, role_id)
VALUES(1, 1, 1);
INSERT INTO user_role
(id, user_id, role_id)
VALUES(2, 2, 2);
INSERT INTO user_role
(id, user_id, role_id)
VALUES(3, 3, 3);
