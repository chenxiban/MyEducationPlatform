/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.19 : Database - rightsmanagement
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`rightsmanagement` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `rightsmanagement`;

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values (62);

/*Table structure for table `tb_clazz` */

DROP TABLE IF EXISTS `tb_clazz`;

CREATE TABLE `tb_clazz` (
  `class_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '班级ID',
  `class_creat_time` datetime DEFAULT NULL COMMENT '备注:创建时间',
  `class_name` varchar(20) DEFAULT NULL COMMENT '备注:班级名称',
  `class_number` int(10) unsigned DEFAULT NULL COMMENT '班级编号',
  `class_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '备注:最后一次修改时间',
  `clazz_college_id` int(10) unsigned DEFAULT NULL COMMENT '学院/院系/专业ID',
  `page` int(11) NOT NULL,
  `rows` int(11) NOT NULL,
  PRIMARY KEY (`class_id`),
  UNIQUE KEY `UK_h16o080wn9u1b3iiq66oy9qse` (`class_name`),
  KEY `FKt19s64s96vxydrdqh24xs3rqu` (`clazz_college_id`),
  CONSTRAINT `FKt19s64s96vxydrdqh24xs3rqu` FOREIGN KEY (`clazz_college_id`) REFERENCES `tb_college` (`college_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `tb_clazz` */

insert  into `tb_clazz`(`class_id`,`class_creat_time`,`class_name`,`class_number`,`class_update_time`,`clazz_college_id`,`page`,`rows`) values (1,'2018-12-23 15:48:11','哈哈班',1801,'2018-12-23 16:43:47',12,0,0),(2,'2018-12-23 15:48:51','呵呵班',1802,'2018-12-23 16:43:49',12,0,0),(3,'2018-12-23 15:48:51','学霸班',1803,'2018-12-23 16:43:50',12,0,0),(4,'2018-12-23 15:49:38','嘎嘎班',1804,'2018-12-23 16:43:53',13,0,0),(5,'2018-12-23 15:49:47','顺溜班',1805,'2018-12-23 16:43:56',13,0,0),(6,'2018-12-23 15:49:56','智障班',1806,'2018-12-23 16:44:02',13,0,0),(7,'2018-12-23 15:50:06','脑残班',1807,'2018-12-23 16:44:18',13,0,0),(8,'2018-12-23 15:50:19','低能班',1808,'2018-12-23 16:44:20',13,0,0),(9,'2018-12-23 15:50:28','模特班',1809,'2018-12-23 16:44:15',14,0,0),(10,'2018-12-23 15:50:39','哼哈班',1810,'2018-12-23 16:44:22',14,0,0),(11,'2018-12-23 15:50:59','六六班',1811,'2018-12-23 16:44:25',14,0,0);

/*Table structure for table `tb_college` */

DROP TABLE IF EXISTS `tb_college`;

CREATE TABLE `tb_college` (
  `college_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '学院/院系/专业ID',
  `college_creat_time` datetime DEFAULT NULL COMMENT '备注:创建时间',
  `college_founder` varchar(50) DEFAULT NULL COMMENT '备注:创建人',
  `college_name` varchar(60) DEFAULT NULL COMMENT '备注:学院/院系/专业名称',
  `college_parent_id` int(10) unsigned NOT NULL COMMENT '备注:父模块编号',
  `college_path` varchar(120) DEFAULT NULL COMMENT '备注:路径',
  `college_rmark` int(10) unsigned NOT NULL COMMENT '备注:标注是 学院/系别/专业分别用0，1，2代表',
  `college_update_man` varchar(50) DEFAULT NULL COMMENT '备注:修改人',
  `college_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '备注:最后一次修改时间',
  `college_weight` int(10) unsigned DEFAULT NULL COMMENT '备注:权重',
  `college_organization_id` int(10) unsigned DEFAULT '1' COMMENT '机构ID',
  PRIMARY KEY (`college_id`),
  UNIQUE KEY `UK_5068ec34jjh3i8xlmoot2hild` (`college_name`),
  KEY `FKc3themep2er21ojwj0c0odx6s` (`college_organization_id`),
  CONSTRAINT `FKc3themep2er21ojwj0c0odx6s` FOREIGN KEY (`college_organization_id`) REFERENCES `tb_organization` (`organization_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `tb_college` */

insert  into `tb_college`(`college_id`,`college_creat_time`,`college_founder`,`college_name`,`college_parent_id`,`college_path`,`college_rmark`,`college_update_man`,`college_update_time`,`college_weight`,`college_organization_id`) values (1,'2018-12-13 18:03:02','小佳','河南工业大学计算机与应用技术学院',0,NULL,0,'小佳','2018-12-13 18:12:39',1000,1),(2,'2018-12-13 18:03:02','小佳','河南工业大学中英国际学院',0,NULL,0,'小佳','2018-12-13 18:12:40',990,1),(3,'2018-12-13 18:03:02','小佳','河南工业大学磨料磨具学院',0,NULL,0,'小佳','2018-12-13 18:12:41',980,1),(4,'2018-12-13 18:03:02','小佳','河南工业大学粮食教育学院',0,NULL,0,'小佳','2018-12-13 18:12:42',970,1),(5,'2018-12-13 18:03:02','小佳','河南工业大学经济教育学院',0,NULL,0,'小佳','2018-12-13 18:12:43',960,1),(6,'2018-12-13 18:03:02','小佳','河南工业大学心理与精神教育学院',0,NULL,0,'小佳','2018-12-13 18:12:44',950,1),(7,'2018-12-13 18:03:02','小佳','河南工业大学园林建筑土木学院',0,NULL,0,'小佳','2018-12-13 18:12:45',940,1),(8,'2018-12-13 18:03:02','小佳','河南工业大学理工学院',0,NULL,0,'小佳','2018-12-13 18:12:48',930,1),(9,'2018-12-13 18:03:02','小佳','河南工业大学艺术设计学院',0,NULL,0,'小佳','2018-12-13 18:12:49',920,1),(10,'2018-12-13 18:03:02','小佳','河南工业大学政治与哲学学院',0,NULL,0,'小佳','2018-12-13 18:12:50',910,1),(11,'2018-12-13 18:03:02','小佳','计算机专业院系',1,NULL,1,'小佳','2018-12-13 18:13:57',850,1),(12,'2018-12-13 18:03:02','小佳','安卓开发',11,NULL,2,'小佳','2018-12-13 18:15:09',800,1),(13,'2018-12-13 18:03:02','小佳','JAVA开发',11,NULL,2,'小佳','2018-12-13 18:15:13',799,1),(14,'2018-12-13 18:03:02','小佳','IOS开发',11,NULL,2,'小佳','2018-12-13 18:15:05',798,1),(15,'2018-12-13 18:03:02','小佳','前端开发与美工设计',11,NULL,2,'小佳','2018-12-13 18:15:48',797,1),(16,'2018-12-13 18:03:02','小佳','运维与实施',11,NULL,2,'小佳','2018-12-13 18:16:18',796,1),(17,'2018-12-13 18:03:02','小佳','外语专业院系',2,NULL,1,'小佳','2018-12-13 18:20:31',750,1),(18,'2018-12-13 18:03:02','小佳','出国留学',17,NULL,2,'小佳','2018-12-13 18:20:16',749,1),(19,'2018-12-13 18:03:02','小佳','政治外交',17,NULL,2,'小佳','2018-12-13 18:20:28',748,1),(20,'2018-12-13 18:03:02','小佳','外语',17,NULL,2,'小佳','2018-12-13 18:20:51',747,1),(21,'2018-12-13 18:03:02','小佳','无用的',99999,NULL,0,NULL,'2018-12-26 22:20:49',666666,1);

/*Table structure for table `tb_coursetui` */

DROP TABLE IF EXISTS `tb_coursetui`;

CREATE TABLE `tb_coursetui` (
  `tui_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '推荐课程主键',
  `course_id` int(10) unsigned DEFAULT NULL COMMENT '推荐课程id',
  PRIMARY KEY (`tui_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_coursetui` */

/*Table structure for table `tb_modules` */

DROP TABLE IF EXISTS `tb_modules`;

CREATE TABLE `tb_modules` (
  `modules_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注:模块自动增长主键',
  `modules_create_time` datetime DEFAULT NULL COMMENT '备注:模块创建时间',
  `modules_founder` varchar(50) DEFAULT NULL COMMENT '备注:创建人',
  `modules_last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '备注:模块最后一次修改时间',
  `modules_name` varchar(50) DEFAULT NULL COMMENT '备注:模块名称',
  `modules_parent_id` int(10) unsigned NOT NULL COMMENT '备注:父模块编号',
  `modules_path` varchar(120) DEFAULT NULL COMMENT '备注:模块路径',
  `modules_update_man` varchar(50) DEFAULT NULL COMMENT '备注:修改人',
  `modules_weight` int(10) unsigned DEFAULT NULL COMMENT '备注:权重',
  PRIMARY KEY (`modules_id`),
  UNIQUE KEY `UK_39829fb4tg2fk4sfd8owip3eo` (`modules_name`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `tb_modules` */

insert  into `tb_modules`(`modules_id`,`modules_create_time`,`modules_founder`,`modules_last_update_time`,`modules_name`,`modules_parent_id`,`modules_path`,`modules_update_man`,`modules_weight`) values (1,'2018-12-13 17:48:39','小佳','2018-12-13 17:49:35','后台管理',0,NULL,NULL,200),(2,'2018-12-13 17:48:39','小佳','2018-12-13 17:52:14','机构查看',1,'organization.html','陈小佳',190),(3,'2018-12-13 17:48:39','小佳','2018-12-13 17:50:48','用户管理',1,'yh.html',NULL,180),(4,'2018-12-13 17:48:39','小佳','2018-12-13 17:51:17','角色管理',1,'jdgl.html',NULL,170),(5,'2018-12-13 17:48:39','小佳','2018-12-13 17:51:35','模块管理',1,'modules.html',NULL,160),(6,'2018-12-13 17:48:39','小佳','2018-12-13 17:51:55','权限查看',1,'permission.html',NULL,150),(7,'2018-12-13 17:48:39','小佳','2018-12-13 17:53:31','班级管理',1,'clazz.html',NULL,140),(8,'2018-12-13 17:48:39','小佳','2018-12-19 15:18:45','推荐管理',0,NULL,NULL,400),(9,'2018-12-13 17:48:39','小佳','2018-12-19 15:20:17','贴吧推荐',8,'post.html',NULL,390),(10,'2018-12-13 17:48:39','小佳','2018-12-19 15:21:01','课程推荐',8,'course.html',NULL,380),(13,'2018-12-23 16:50:42','小佳','2018-12-23 16:50:42','课程讨论区管理',8,'postcourse.html',NULL,666),(17,'2018-12-25 22:04:31','陈小佳','2018-12-25 22:04:31','机构管理',1,'college.html',NULL,6666);

/*Table structure for table `tb_organization` */

DROP TABLE IF EXISTS `tb_organization`;

CREATE TABLE `tb_organization` (
  `organization_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '机构ID',
  `organization_abstract` varchar(1000) DEFAULT NULL COMMENT '备注:机构简介',
  `organization_address` varchar(140) DEFAULT NULL COMMENT '备注:机构地址',
  `organization_creat_time` datetime DEFAULT NULL COMMENT '备注:机构创建时间',
  `organization_head` varchar(10) DEFAULT NULL COMMENT '备注:机构负责人',
  `organization_mtel` varchar(11) DEFAULT NULL COMMENT '备注:机构联系方式',
  `organization_school` varchar(60) DEFAULT NULL COMMENT '备注:机构名称',
  `organization_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '备注:最后一次操作时间',
  PRIMARY KEY (`organization_id`),
  UNIQUE KEY `UK_i9ikv0gjkb2gff2oiifnnip1f` (`organization_school`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `tb_organization` */

insert  into `tb_organization`(`organization_id`,`organization_abstract`,`organization_address`,`organization_creat_time`,`organization_head`,`organization_mtel`,`organization_school`,`organization_update_time`) values (1,'由马帅帅担任项目主管所领头开发的一款智慧教育平台,名下拥有150人的开发团队,彪悍狂野的民风,幽默风趣的作风,迅雷不及掩耳盗铃之势的编程速度,始于二零一八年十二月初结束于二零一九年元旦过后,时光珍奇,虽不能至,仍向往之!!!马哥,小马哥,马哥,帅帅,马帅帅,万分感谢您的教导,有空一起耍呀哈哈哈哈哈哈!!!','河南省郑州市中原区嵩山南路140号','2018-12-13 17:57:51','马帅帅','15638589820','河南工业大学','2018-12-19 20:07:19'),(2,'由陈小佳担任项目技术经理所领头开发的一款智慧教育平台,名下拥有20-30人的开发团队,彪悍狂野的民风,幽默风趣的作风,迅雷不及掩耳盗铃之势的编程速度,始于二零一八年十二月初结束于二零一九年元旦过后,时光珍奇,虽不能至,仍向往之!!!万分感谢您的教导,有空一起耍呀哈哈哈哈哈哈!!!','河南省郑州市中原区嵩山南路140号','2018-12-13 17:57:51','陈永佳','15638589820','河南工业大学嵩山路小区','2018-12-19 20:08:11');

/*Table structure for table `tb_permission` */

DROP TABLE IF EXISTS `tb_permission`;

CREATE TABLE `tb_permission` (
  `permission_id` int(10) unsigned NOT NULL COMMENT '权限ID',
  `permission_last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '权限最近一次修改时间',
  `permission_module` varchar(50) NOT NULL COMMENT '权限所属模块',
  `permission_name` varchar(50) NOT NULL COMMENT '权限名称',
  `permission_value` varchar(50) DEFAULT NULL COMMENT '权限资源对象',
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_permission` */

insert  into `tb_permission`(`permission_id`,`permission_last_update_time`,`permission_module`,`permission_name`,`permission_value`) values (1,'2018-12-09 19:39:38','拥有所有权限','超级管理员','all'),(2,'2018-12-09 19:39:40','权限模块','更新系统权限','permission:updatePermission'),(3,'2018-12-09 19:39:42','用户模块','测试控制器方法','user:getFuture'),(7,'2018-12-09 22:23:45','权限模块','批量插入权限数据','permission:batchInsert'),(8,'2018-12-09 22:23:45','权限模块','查询系统权限','permission:queryAll'),(9,'2018-12-09 22:23:45','用户模块','查询用户','user:getAllPageUsers'),(11,'2018-12-10 14:07:22','文件管理模块','下载文件','file:downloadFile'),(12,'2018-12-19 13:35:44','班级模块','查询班级','clazz:getAllPageClazz'),(13,'2018-12-23 16:16:08','班级模块','修改班级','clazz:updClazz'),(14,'2018-12-19 13:35:44','班级模块','删除班级','clazz:delClazz'),(15,'2018-12-19 13:35:44','机构设置管理','查询机构','college:getCollege'),(16,'2018-12-19 13:35:45','机构设置管理','添加机构','college:addCollege'),(17,'2018-12-19 13:35:45','机构设置管理','修改机构','college:updateCollege'),(18,'2018-12-19 13:35:45','菜单模块','查询左侧菜单树','modules:queryMenuTree'),(19,'2018-12-19 13:35:45','菜单模块','查询模块','modules:getModules'),(20,'2018-12-19 13:35:45','菜单模块','修改模块','modules:updModules'),(21,'2018-12-19 13:35:45','菜单模块','添加模块','modules:addModules'),(22,'2018-12-19 13:35:45','菜单模块','删除模块','modules:delModules'),(23,'2018-12-19 13:35:45','菜单模块','查询角色设置模块','modules:queryRoleSetModuleTree'),(24,'2018-12-19 13:35:45','Token模块','添加token的存储信息','tokens:saveMyToken'),(25,'2018-12-19 13:35:45','机构管理','查询机构','organization:queryAllOrganization'),(26,'2018-12-19 13:35:45','权限模块','查看系统权限','permission:queryNode'),(27,'2018-12-19 13:35:45','角色模块','获取角色权限','roles:getRolesPermissionByRoleId'),(28,'2018-12-19 13:35:45','角色模块','获取用户角色','roles:getUserRolesByUserId'),(29,'2018-12-19 13:35:45','角色模块','角色设置菜单模块','roles:setRoleModule'),(30,'2018-12-19 13:35:46','角色模块','增加角色','roles:addByRole'),(31,'2018-12-19 13:35:46','角色模块','移除角色','roles:delRolesId'),(32,'2018-12-19 13:35:46','角色模块','查询角色','roles:getAllPageRoles'),(33,'2018-12-19 13:35:46','角色模块','删除角色','roles:delRoles'),(34,'2018-12-19 13:35:46','角色模块','添加角色','roles:addRoles'),(35,'2018-12-19 13:35:46','角色模块','修改角色','roles:updRoles'),(36,'2018-12-19 13:35:46','用户模块','修改用户','user:updUsers'),(37,'2018-12-19 13:35:46','用户模块','通过token换取用户信息','user:getUserIdByToken'),(38,'2018-12-19 13:35:46','用户模块','不分页查询角色','user:getRolesList'),(39,'2018-12-19 13:35:46','用户模块','删除用户','user:delUsers'),(40,'2018-12-19 13:35:46','用户模块','重置密码','user:clearUsers'),(41,'2018-12-19 13:35:46','用户模块','锁定用户','user:lockUsers'),(42,'2019-01-01 22:20:57','文件管理','上传支持分片断点传输','file:beforeUpload'),(43,'2019-01-01 20:54:26','班级模块','添加班级','clazz:addClazzs'),(44,'2019-01-01 20:54:26','机构设置管理','删除机构','college:delCollege'),(45,'2019-01-01 20:54:26','课程推荐管理','添加课程推荐信息','course:saveCourseTui'),(46,'2019-01-01 20:54:26','课程推荐管理','删除课程推荐信息','course:delCourseTui'),(47,'2019-01-01 20:54:27','课程推荐管理','查询课程推荐id','course:getCourseId'),(48,'2019-01-01 20:54:27','课程推荐管理','查询课程前二十信息','course:getCurrIdBySubscriptionNum'),(49,'2019-01-01 20:54:27','机构管理','添加机构信息','organization:saveOrganization'),(50,'2019-01-01 20:54:27','机构管理','修改机构信息','organization:updOrganization'),(51,'2019-01-01 20:54:27','机构管理','删除机构','organization:delOrganization'),(52,'2019-01-01 20:54:27','机构管理','查询所有机构','organization:getAllOrganization'),(53,'2019-01-01 20:54:27','贴吧推荐管理','查询贴吧推荐信息','post:queryAllPage'),(54,'2019-01-01 20:54:27','贴吧推荐管理','删除贴吧推荐信息','post:delPsotTui'),(55,'2019-01-01 20:54:27','贴吧推荐管理','添加贴吧推荐信息','post:savePostTui'),(56,'2019-01-01 20:54:27','贴吧推荐管理','查询推荐id','post:getPostId'),(57,'2019-01-01 20:54:27','用户模块','提供芈忠良获取所有用户信息','user:getUserInfo'),(58,'2019-01-01 20:54:27','用户模块','修改老师专业绑定','user:updateUser'),(59,'2019-01-01 20:54:27','用户模块','添加用户信息','user:addUsers'),(60,'2019-01-01 20:54:27','用户模块','为班级设置学生','user:addUserClazz'),(61,'2019-01-01 20:54:28','用户模块','查询老师','user:getByTeacher');

/*Table structure for table `tb_posttui` */

DROP TABLE IF EXISTS `tb_posttui`;

CREATE TABLE `tb_posttui` (
  `tui_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '推荐帖子主键',
  `post_id` int(10) unsigned DEFAULT NULL COMMENT '推荐帖子id',
  PRIMARY KEY (`tui_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_posttui` */

/*Table structure for table `tb_rolemodules` */

DROP TABLE IF EXISTS `tb_rolemodules`;

CREATE TABLE `tb_rolemodules` (
  `role_id` int(10) unsigned NOT NULL COMMENT '角色id',
  `modules_id` int(10) unsigned NOT NULL COMMENT '备注:模块自动增长主键',
  PRIMARY KEY (`modules_id`,`role_id`),
  KEY `FKhb29mdbx6e0icqxaut4l25fcx` (`role_id`),
  CONSTRAINT `FKev7wlpd3ew18vq5i5garxieal` FOREIGN KEY (`modules_id`) REFERENCES `tb_modules` (`modules_id`),
  CONSTRAINT `FKhb29mdbx6e0icqxaut4l25fcx` FOREIGN KEY (`role_id`) REFERENCES `tb_roles` (`roles_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_rolemodules` */

insert  into `tb_rolemodules`(`role_id`,`modules_id`) values (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,13),(1,17);

/*Table structure for table `tb_rolepermission` */

DROP TABLE IF EXISTS `tb_rolepermission`;

CREATE TABLE `tb_rolepermission` (
  `permission_id` int(10) unsigned NOT NULL COMMENT '权限ID',
  `role_id` int(10) unsigned NOT NULL COMMENT '角色id',
  PRIMARY KEY (`role_id`,`permission_id`),
  KEY `FK30lcsmod8av77oje9180e8h3j` (`permission_id`),
  CONSTRAINT `FK30lcsmod8av77oje9180e8h3j` FOREIGN KEY (`permission_id`) REFERENCES `tb_permission` (`permission_id`),
  CONSTRAINT `FKctrkpw96n1lfjf6nmpmxxjkjr` FOREIGN KEY (`role_id`) REFERENCES `tb_roles` (`roles_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_rolepermission` */

insert  into `tb_rolepermission`(`permission_id`,`role_id`) values (1,1),(2,1),(3,1),(7,1),(8,1),(9,1),(12,1),(13,1),(14,1),(15,1),(16,1),(17,1),(18,1),(19,1),(20,1),(21,1),(22,1),(23,1),(24,1),(25,1),(26,1),(27,1),(28,1),(29,1),(30,1),(31,1),(32,1),(33,1),(34,1),(35,1),(36,1),(37,1),(38,1),(39,1),(40,1),(41,1),(42,1),(43,1),(44,1),(45,1),(46,1),(47,1),(48,1),(49,1),(50,1),(51,1),(52,1),(53,1),(54,1),(55,1),(56,1),(57,1),(58,1),(59,1),(60,1),(61,1);

/*Table structure for table `tb_roles` */

DROP TABLE IF EXISTS `tb_roles`;

CREATE TABLE `tb_roles` (
  `roles_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `roles_creat_time` datetime NOT NULL COMMENT '创建时间',
  `roles_explain` varchar(1000) DEFAULT NULL COMMENT '角色功能',
  `roles_name` varchar(50) NOT NULL COMMENT '角色姓名',
  `roles_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次修改时间',
  `roles_ename` varchar(50) DEFAULT NULL COMMENT '角色英文体现,如:ROLE_xxx',
  PRIMARY KEY (`roles_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `tb_roles` */

insert  into `tb_roles`(`roles_id`,`roles_creat_time`,`roles_explain`,`roles_name`,`roles_update_time`,`roles_ename`) values (1,'2018-12-04 12:28:10','拥有所有权限','超级管理员','2018-12-09 19:38:01','ROLE_ALL'),(2,'2018-12-04 12:28:10','拥有权限管理系统的所有权限','权限管理员','2018-12-09 19:39:05','ROLE_Permission'),(3,'2018-12-04 12:28:10','拥有老师所拥有的角色','老师','2018-12-09 19:38:51','ROLE_Teacher'),(4,'2018-12-04 12:28:10','拥有学生所拥有的权限','学生','2018-12-09 19:38:44','ROLE_Student'),(5,'2018-12-04 12:28:10','拥有管理贴吧讨论区的权限','贴吧管理员','2018-12-09 19:38:40','ROLE_TieBa');

/*Table structure for table `tb_token` */

DROP TABLE IF EXISTS `tb_token`;

CREATE TABLE `tb_token` (
  `token_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'token存储表id',
  `user_id` int(10) unsigned DEFAULT NULL COMMENT '用户id',
  `token_acc` varchar(120) DEFAULT NULL COMMENT 'token存储',
  `token_creat_time` datetime DEFAULT NULL COMMENT 'token存储创建时间',
  `token_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'token存储最后一次修改时间',
  PRIMARY KEY (`token_id`),
  UNIQUE KEY `UK_3tlgt45se8pfspcbl9wad9wp5` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `tb_token` */

insert  into `tb_token`(`token_id`,`user_id`,`token_acc`,`token_creat_time`,`token_update_time`) values (16,1,'ff9c9926-352a-4a44-8163-3047f299bf14','2019-01-01 21:57:51','2019-01-01 21:57:51');

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_creat_time` datetime DEFAULT NULL COMMENT '创建时间',
  `user_is_lookout` char(1) DEFAULT '否' COMMENT '是否锁定',
  `user_last_login_time` datetime DEFAULT NULL COMMENT '用户最后一次登录时间',
  `user_lock_time` datetime DEFAULT NULL COMMENT '用户锁定时间',
  `user_name` varchar(20) NOT NULL COMMENT '用户名称',
  `user_password` varchar(120) DEFAULT NULL COMMENT '用户登陆密码',
  `user_protectemail` varchar(50) DEFAULT NULL COMMENT '密保邮箱',
  `user_protectmtel` varchar(11) DEFAULT NULL COMMENT '密保手机号',
  `user_psd_wrong_time` tinyint(3) unsigned DEFAULT '0' COMMENT '密码错误次数',
  `user_stu_no` int(11) unsigned NOT NULL COMMENT '由 Java 代码生成的用户流水号',
  `user_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次修改时间',
  `user_college_id` int(10) unsigned DEFAULT NULL COMMENT '学院/院系/专业ID',
  PRIMARY KEY (`user_id`),
  KEY `FKro7hc3xbbmhr7hl70k0gi7dw2` (`user_college_id`),
  CONSTRAINT `FKro7hc3xbbmhr7hl70k0gi7dw2` FOREIGN KEY (`user_college_id`) REFERENCES `tb_college` (`college_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `tb_user` */

insert  into `tb_user`(`user_id`,`user_creat_time`,`user_is_lookout`,`user_last_login_time`,`user_lock_time`,`user_name`,`user_password`,`user_protectemail`,`user_protectmtel`,`user_psd_wrong_time`,`user_stu_no`,`user_update_time`,`user_college_id`) values (1,'2018-12-09 14:51:54','否','2019-01-01 21:57:50',NULL,'小佳','$2a$10$WsK12hTCxpsyIF./P84vm.xfOjekIw83O1bzpKZNNWCo7B4Ga//5q','867647213@qq.com','15638589820',0,201800001,'2019-01-01 21:57:50',NULL),(2,'2018-12-14 14:03:40','否','2018-12-18 20:15:28',NULL,'郭士才','$2a$10$04MtmHWU4gYQCUSeiXBe..Usg921WYxFk7Sv5tK/B9T96VOiBlKkW','1111114455@qq.com','15896556656',0,201800001,'2018-12-18 20:15:28',NULL),(3,'2018-12-23 21:30:25','否',NULL,NULL,'模块管理员','$2a$10$u8j9Ulwbc.reJEbIBwKWMOikN6jtQNY2vP22Hwm4JfBHOD6.UiaCm','111111111@qq.com','15635547821',0,201800001,'2018-12-23 21:48:31',NULL),(4,'2018-12-23 21:40:09','否',NULL,NULL,'杨毅晨','$2a$10$YfmfMi.pXC7VABPiUd7wReb2w/FFfibP2DvNgEw.sun8Y2E/q3pGi','666666@qq.com','15666666666',0,201800001,'2018-12-26 22:28:32',11),(5,'2018-12-23 21:40:19','否',NULL,NULL,'郭双利','$2a$10$8c2GxAuTiOdU8/vPKPQuDOImlFI7XWG6LvXr/uLJEy77lPDyxoJPO','666666@qq.com','15666666666',0,201800001,'2018-12-23 21:48:32',NULL),(6,'2018-12-23 21:40:24','否',NULL,NULL,'李志伟','$2a$10$Wl3eOgq0s63pP4gqeNpOweP7j3ZwiO8hpLxqe25oqodbev7tZnvwS','666666@qq.com','15666666666',0,201800001,'2018-12-23 21:48:33',NULL),(7,'2018-12-23 21:40:38','否',NULL,NULL,'张俊奇','$2a$10$RSE16eHCjYSEC3guJvs.d.BoxwAKQEwTfdwjbYMd.tCDy905lq4Sy','666666@qq.com','15666666666',0,201800001,'2018-12-23 21:48:33',NULL),(8,'2018-12-23 21:40:44','否',NULL,NULL,'李海潮','$2a$10$WwUZBiz9QlZyS9y5bjQ1nusj8o1hER5IUiUxzPjEDXzsA.4WgXuHm','666666@qq.com','15666666666',0,201800001,'2018-12-26 22:29:08',21),(9,'2018-12-23 21:40:55','否',NULL,NULL,'刘莉莉','$2a$10$aKNCbMOhWa8Atw0a27VVyOJxVb27ysMQU0YPcoOU6bbx37Deml.5W','666666@qq.com','15666666666',0,201800001,'2018-12-23 21:48:34',NULL),(10,'2018-12-23 21:41:10','否',NULL,NULL,'通航','$2a$10$4kJ9d1k0cY1IPbtry/rr7O5DFzo1Kp/LvZagTCOctuZVseWwXbQDu','666666@qq.com','15666666666',0,201800001,'2018-12-23 21:48:35',NULL),(11,'2018-12-23 21:41:22','否',NULL,NULL,'李怡雯','$2a$10$PmrWOgSfGcvThv2u1xQQEemlZ45J4CJ64LHQ1HxAk3RVYpkNaGIPK','666666@qq.com','15666666666',0,201800001,'2018-12-23 21:48:35',NULL),(12,'2018-12-23 21:41:29','否',NULL,NULL,'张冰倩','$2a$10$u1ZIoALaqwm45CwfTFoNtews52b/TPigTgU7rMr9gGya8eEb3W3Gq','666666@qq.com','15666666666',0,201800001,'2018-12-26 22:29:39',11),(13,'2018-12-23 21:41:36','否',NULL,NULL,'刘宇超','$2a$10$MYvx4USCkbs4Y7FCc00zHez3PWHZwMNf0s4XSLv9MXHc5S01yMHpm','666666@qq.com','15666666666',0,201800001,'2018-12-23 21:48:37',NULL),(14,'2018-12-23 21:41:42','否',NULL,NULL,'宋志斌','$2a$10$nAp.BVFPRRa1ORo8P4VhceqnlFpPMS5.9EPHZkDfh1pO1nM1Sx3ie','666666@qq.com','15666666666',0,201800001,'2018-12-26 22:30:03',21),(15,'2018-12-23 21:41:51','否',NULL,NULL,'宋庆双','$2a$10$JgLJDRJNEFMRE/CM.hMTJu.DJR2xusUK6ebkNdfUJ7hIq8eGZJjpq','666666@qq.com','15666666666',0,201800001,'2018-12-23 21:48:38',NULL),(16,'2018-12-23 21:42:08','否',NULL,NULL,'王梦霞','$2a$10$I67pfnyYM.dSiWof7qOTd.D2iYBncQXGSc/qOHBb7HXZQAA8YKkyu','2934128615@qq.com','15736709693',0,201800001,'2018-12-23 21:48:39',NULL),(17,'2018-12-23 21:42:17','否',NULL,NULL,'刘森川','$2a$10$Rcq9u/GCTCijLaT.LrfrTuTDQys9AoXgplwXM.xl5UFkz4ImyEi6i','2934128615@qq.com','15736709693',0,201800001,'2018-12-23 21:48:40',NULL),(18,'2018-12-23 21:42:24','否',NULL,NULL,'孙可欣','$2a$10$FQTW0iFysrEEE2/WnWbtiOdwKSPl3iBvXLUjDwHfJ6UZbMXTdf8H2','2934128615@qq.com','15736709693',0,201800001,'2018-12-26 22:29:11',21),(19,'2018-12-23 21:42:30','否',NULL,NULL,'杜新爱','$2a$10$drB/rr/83ug9M6CqWAcNpOnwpnSPJNqXaQAXr4yQjzaS3jw38pppS','2934128615@qq.com','15736709693',0,201800001,'2018-12-23 21:48:41',NULL),(20,'2018-12-23 21:42:40','否',NULL,NULL,'王安岭','$2a$10$D5WAKrpF949qxBybX522xewr4twOCokUS7fs1k2rgw1syNU1oxdMK','2934128615@qq.com','15736709693',0,201800001,'2018-12-23 21:48:42',NULL),(21,'2018-12-23 21:42:57','否',NULL,NULL,'王传威','$2a$10$Cnun1atwgXkN07iVpzDs3ep.5EUXXvAZm.2ysOXdLGSIcl6m/6RGi','2934128615@qq.com','15736709693',0,201800001,'2018-12-23 21:48:42',NULL),(22,'2018-12-23 21:43:03','否',NULL,NULL,'芈忠良','$2a$10$ldnrlOx3RrpVbhe0LHTyiuT1zIUfGlutOf4bZyYQM6wZ4A5Y2kJjS','2934128615@qq.com','15736709693',0,201800001,'2018-12-23 21:48:43',NULL),(23,'2018-12-23 21:43:11','否',NULL,NULL,'谢立博','$2a$10$pKS6seHYBSuWOtPb.Y56u.IGHLEnlR97We1e8BiJ/6a1zYj8bT7zG','2934128615@qq.com','15736709693',0,201800001,'2018-12-23 21:48:44',NULL),(24,'2018-12-23 21:43:30','否',NULL,NULL,'白亚铂','$2a$10$vwqkJeXaQxtGX0Q27v6GqeUeEFJhn/uThs.wqxys8Ns2CTlnhC/OS','2934128615@qq.com','15736709693',0,201800001,'2018-12-23 21:48:44',NULL),(25,'2018-12-23 21:43:36','否',NULL,NULL,'黄绪文','$2a$10$hb7Vo2Zk6C8Mrc7pqDnEEuKuqWSC1GFEvdbx/pVuuu23RDwIKGeCe','2934128615@qq.com','15736709693',0,201800001,'2018-12-23 21:48:46',NULL),(26,'2019-01-01 22:18:47','否',NULL,NULL,'无敌的我','$2a$10$l91Muy9WKxmgoV6SjRGpfu7VKwf7EDi.Q8d9zdZ5bXxGp1E9pdkMm','867647213@qq.com','15638589820',0,201800001,'2019-01-01 22:18:47',NULL);

/*Table structure for table `tb_userclazz` */

DROP TABLE IF EXISTS `tb_userclazz`;

CREATE TABLE `tb_userclazz` (
  `users_id` int(10) unsigned NOT NULL COMMENT '用户id',
  `clazz_id` int(10) unsigned NOT NULL COMMENT '班级ID',
  PRIMARY KEY (`clazz_id`,`users_id`),
  KEY `FKquy4gxc5x012wrqwnv1xt9e0` (`users_id`),
  CONSTRAINT `FKquy4gxc5x012wrqwnv1xt9e0` FOREIGN KEY (`users_id`) REFERENCES `tb_user` (`user_id`),
  CONSTRAINT `FKik3h4nxou2m6xn7gllmd8bhj` FOREIGN KEY (`clazz_id`) REFERENCES `tb_clazz` (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_userclazz` */

insert  into `tb_userclazz`(`users_id`,`clazz_id`) values (5,4);

/*Table structure for table `tb_userroles` */

DROP TABLE IF EXISTS `tb_userroles`;

CREATE TABLE `tb_userroles` (
  `users_id` int(10) unsigned NOT NULL COMMENT '用户id',
  `roles_id` int(10) unsigned NOT NULL COMMENT '角色id',
  PRIMARY KEY (`roles_id`,`users_id`),
  KEY `FK8qmvialltjuf4wtbumnlqy8w4` (`users_id`),
  CONSTRAINT `FK8qmvialltjuf4wtbumnlqy8w4` FOREIGN KEY (`users_id`) REFERENCES `tb_user` (`user_id`),
  CONSTRAINT `FKe2kirkkjeqjmf4r79j8rn9csq` FOREIGN KEY (`roles_id`) REFERENCES `tb_roles` (`roles_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_userroles` */

insert  into `tb_userroles`(`users_id`,`roles_id`) values (1,1),(4,1),(4,3),(5,4),(6,4),(7,4),(8,3),(9,4),(10,4),(11,4),(12,1),(12,3),(13,4),(14,3),(15,3),(16,1),(16,3),(17,3),(18,3),(19,3),(20,1),(20,3),(21,1),(21,3),(22,3),(23,3),(24,3),(25,4);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
