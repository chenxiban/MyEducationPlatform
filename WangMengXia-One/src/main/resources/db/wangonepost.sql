/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.19 : Database - wangonepost
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`wangonepost` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `wangonepost`;

/*Table structure for table `tb_disbar` */

DROP TABLE IF EXISTS `tb_disbar`;

CREATE TABLE `tb_disbar` (
  `disbar_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '课程主键',
  `disbar_category` varchar(30) NOT NULL COMMENT '课程讨论分类名字',
  `disbar_createtime` datetime DEFAULT NULL COMMENT '评论时间',
  `disbar_describe` varchar(30) NOT NULL COMMENT '课程讨论分类描述',
  `disbar_updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次修改时间',
  PRIMARY KEY (`disbar_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `tb_disbar` */

insert  into `tb_disbar`(`disbar_id`,`disbar_category`,`disbar_createtime`,`disbar_describe`,`disbar_updatetime`) values (1,'模块1','2018-12-14 13:54:25','描述','2018-12-14 13:54:38'),(2,'模块2','2018-12-14 16:04:17','描述2','2018-12-14 16:04:24');

/*Table structure for table `tb_disclazzlike` */

DROP TABLE IF EXISTS `tb_disclazzlike`;

CREATE TABLE `tb_disclazzlike` (
  `disclazzlike_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '课程点赞主键',
  `disclazzlike_createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `disclazzlike_stuts` tinyint(3) unsigned DEFAULT '0' COMMENT '状态',
  `disclazzlike_updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次修改时间',
  `user_id` int(11) NOT NULL COMMENT '点/反的用户的id',
  `discommit_id` int(10) unsigned NOT NULL COMMENT '帖子评论id',
  PRIMARY KEY (`disclazzlike_id`),
  KEY `FKhuf8kysgojwfkmhpoemnsdbdc` (`discommit_id`),
  CONSTRAINT `FKhuf8kysgojwfkmhpoemnsdbdc` FOREIGN KEY (`discommit_id`) REFERENCES `tb_discommit` (`discommit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `tb_disclazzlike` */

insert  into `tb_disclazzlike`(`disclazzlike_id`,`disclazzlike_createtime`,`disclazzlike_stuts`,`disclazzlike_updatetime`,`user_id`,`discommit_id`) values (2,'2018-12-16 10:56:26',0,'2018-12-16 10:56:45',1,1);

/*Table structure for table `tb_discommit` */

DROP TABLE IF EXISTS `tb_discommit`;

CREATE TABLE `tb_discommit` (
  `discommit_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '帖子评论id',
  `discommit_count` varchar(500) NOT NULL COMMENT '评论内容',
  `discommit_createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `discommit_name` varchar(50) NOT NULL COMMENT '评论人昵称',
  `discommit_report` tinyint(3) unsigned DEFAULT '0' COMMENT '是否举报成功',
  `discommit_updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次修改时间',
  `user_id` int(11) NOT NULL COMMENT '评论人id',
  `dispost_id` int(10) unsigned NOT NULL COMMENT '课程帖子主键',
  PRIMARY KEY (`discommit_id`),
  KEY `FK6flj9kg35ydof2ov282hkcgc4` (`dispost_id`),
  CONSTRAINT `FK6flj9kg35ydof2ov282hkcgc4` FOREIGN KEY (`dispost_id`) REFERENCES `tb_dispost` (`dispost_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `tb_discommit` */

insert  into `tb_discommit`(`discommit_id`,`discommit_count`,`discommit_createtime`,`discommit_name`,`discommit_report`,`discommit_updatetime`,`user_id`,`dispost_id`) values (1,'修改','2018-12-16 10:55:07','用户1',0,'2018-12-16 19:36:56',1,1),(2,'评论','2018-12-19 15:01:28','wanghah',0,'2018-12-19 17:03:10',1,2),(4,'discomm','2018-12-16 18:33:23','用户1',0,'2018-12-23 23:50:49',1,3),(5,'\"评论2\"','2018-12-16 18:52:58','\"用户1\"',0,'2018-12-23 23:51:07',1,5),(6,'评论2','2018-12-16 18:53:28','用户1',0,'2018-12-23 23:51:13',1,6),(7,'555','2018-12-16 18:53:28','555',0,'2018-12-23 23:52:30',2,7),(8,'666','2018-12-16 18:53:28','6666',0,'2018-12-23 23:52:31',3,8),(9,'777','2018-12-16 18:53:28','777',0,'2018-12-23 23:52:31',4,9);

/*Table structure for table `tb_discomreport` */

DROP TABLE IF EXISTS `tb_discomreport`;

CREATE TABLE `tb_discomreport` (
  `discomreport_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '评论举报主键',
  `discomreport_content` varchar(200) NOT NULL COMMENT '举报内容',
  `discomreport_createtime` datetime DEFAULT NULL COMMENT '发表时间',
  `discomreport_stuts` tinyint(3) unsigned DEFAULT '0' COMMENT '举报信息审核状态',
  `discomreport_updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次修改时间',
  `user_id` int(11) NOT NULL COMMENT '举报的用户id',
  `discommit_id` int(10) unsigned NOT NULL COMMENT '帖子评论id',
  PRIMARY KEY (`discomreport_id`),
  KEY `FKcmaqfs4x7r58126pk5kdrfsy` (`discommit_id`),
  CONSTRAINT `FKcmaqfs4x7r58126pk5kdrfsy` FOREIGN KEY (`discommit_id`) REFERENCES `tb_discommit` (`discommit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_discomreport` */

/*Table structure for table `tb_dislike` */

DROP TABLE IF EXISTS `tb_dislike`;

CREATE TABLE `tb_dislike` (
  `dislike_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '课程点赞主键',
  `dislike_createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `dislike_stuts` tinyint(3) unsigned DEFAULT '0' COMMENT '状态',
  `dislike_updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次修改时间',
  `user_id` int(11) NOT NULL COMMENT '点/反的用户的id',
  `dispost_id` int(10) unsigned NOT NULL COMMENT '课程帖子主键',
  PRIMARY KEY (`dislike_id`),
  KEY `FKl0xl4o5qiudiwug9s75gvyd39` (`dispost_id`),
  CONSTRAINT `FKl0xl4o5qiudiwug9s75gvyd39` FOREIGN KEY (`dispost_id`) REFERENCES `tb_dispost` (`dispost_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `tb_dislike` */

insert  into `tb_dislike`(`dislike_id`,`dislike_createtime`,`dislike_stuts`,`dislike_updatetime`,`user_id`,`dispost_id`) values (3,'2018-12-16 15:46:51',1,'2018-12-21 15:36:10',1,1),(9,'2018-12-21 15:36:25',2,'2018-12-21 15:36:32',2,2);

/*Table structure for table `tb_dispost` */

DROP TABLE IF EXISTS `tb_dispost`;

CREATE TABLE `tb_dispost` (
  `dispost_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '课程帖子主键',
  `dispost_count` varchar(2000) NOT NULL COMMENT '课程帖子内容',
  `dispost_createtime` datetime DEFAULT NULL COMMENT '评论时间',
  `dispost_fightouts` int(11) NOT NULL COMMENT '投票数',
  `dispost_name` varchar(30) NOT NULL COMMENT '发帖人姓名',
  `dispost_report` tinyint(3) unsigned DEFAULT '0' COMMENT '是否举报成功',
  `dispost_title` varchar(100) NOT NULL COMMENT '课程帖子标题',
  `dispost_updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次修改时间',
  `dispostcha_id` int(11) NOT NULL COMMENT '章节id需老师和学生提供数据',
  `user_id` int(11) NOT NULL COMMENT '发帖人id需要个人中心提供数据',
  `disbar_id` int(10) unsigned NOT NULL COMMENT '课程主键',
  PRIMARY KEY (`dispost_id`),
  KEY `FK4q1nx1i91xvde0lc2cfvehf3p` (`disbar_id`),
  CONSTRAINT `FK4q1nx1i91xvde0lc2cfvehf3p` FOREIGN KEY (`disbar_id`) REFERENCES `tb_disbar` (`disbar_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Data for the table `tb_dispost` */

insert  into `tb_dispost`(`dispost_id`,`dispost_count`,`dispost_createtime`,`dispost_fightouts`,`dispost_name`,`dispost_report`,`dispost_title`,`dispost_updatetime`,`dispostcha_id`,`user_id`,`disbar_id`) values (1,'修改','2018-12-19 14:40:03',12,'用户1',0,'修改标题','2018-12-21 15:57:06',1,1,1),(2,'主题','2018-12-19 14:40:03',1,'用户2',0,'主题标题','2018-12-21 15:57:12',1,1,1),(3,'帖子2','2018-12-19 14:40:43',3,'用户',0,'帖子标题','2018-12-21 15:57:16',1,1,1),(5,'aaaaa','2018-12-19 14:40:43',12,'asas',0,'dispost_title','2018-12-21 15:57:18',1,1,1),(6,'aaaaa','2018-12-19 14:40:43',12,'asas',0,'dispost_title','2018-12-21 15:57:19',1,1,1),(7,'aaaaa','2018-12-19 14:40:43',12,'asas',0,'dispost_title','2018-12-21 15:57:21',1,1,1),(8,'aaaaa','2018-12-19 14:40:43',12,'asas',0,'dispost_title','2018-12-21 15:57:23',1,1,1),(9,'aaaaa','2018-12-19 14:40:43',12,'asas',0,'dispost_title','2018-12-21 15:57:25',1,1,1),(10,'aaaaa','2018-12-19 14:40:43',12,'asas',0,'dispost_title','2018-12-21 15:57:26',1,1,1),(11,'aaaaa','2018-12-19 14:40:43',12,'asas',0,'dispost_title','2018-12-21 15:57:29',1,1,1),(12,'aaaaa','2018-12-19 14:40:43',12,'asas',0,'dispost_title','2018-12-21 15:57:31',1,1,1),(13,'aaaaa','2018-12-19 14:40:43',12,'asas',0,'dispost_title','2018-12-21 15:57:32',1,1,1),(14,'aaaaa','2018-12-19 14:40:43',12,'asas',0,'dispost_title','2018-12-21 15:57:35',1,1,1),(15,'aaaaa','2018-12-19 14:40:43',12,'asas',0,'dispost_title','2018-12-21 15:57:37',1,1,1),(16,'aaaaa','2018-12-19 14:40:43',12,'asas',0,'dispost_title','2018-12-21 15:57:38',1,1,1),(17,'aaaaa','2018-12-19 14:40:43',12,'asas',0,'dispost_title','2018-12-21 15:57:40',1,1,1),(18,'aaaaa','2018-12-19 14:40:43',12,'asas',0,'dispost_title','2018-12-21 15:57:41',1,1,1),(19,'aaaaa','2018-12-19 14:40:43',12,'asas',0,'dispost_title','2018-12-21 15:57:45',1,1,1),(20,'aaaaa','2018-12-19 14:40:43',12,'asas',0,'dispost_title','2018-12-21 15:57:51',1,1,1),(21,'aaaaa','2018-12-19 14:40:43',12,'asas',0,'dispost_title','2018-12-21 15:58:04',1,1,1),(22,'aaaaa','2018-12-19 14:40:43',12,'asas',0,'dispost_title','2018-12-21 15:58:07',1,1,1);

/*Table structure for table `tb_dispostreply` */

DROP TABLE IF EXISTS `tb_dispostreply`;

CREATE TABLE `tb_dispostreply` (
  `dispostreply_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '课程回复主键',
  `dispostreply_createtime` datetime DEFAULT NULL COMMENT '评论时间',
  `dispostreply_name` varchar(2000) NOT NULL COMMENT '回复内容',
  `dispostreply_report` tinyint(3) unsigned DEFAULT '0' COMMENT '是否举报成功',
  `dispostreply_updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次修改时间',
  `user_id` int(11) NOT NULL COMMENT '回复人id需个人中心提供数据',
  `discommit_id` int(10) unsigned NOT NULL COMMENT '帖子评论id',
  PRIMARY KEY (`dispostreply_id`),
  KEY `FKidobuucx532rj4a0vsdwdj14t` (`discommit_id`),
  CONSTRAINT `FKidobuucx532rj4a0vsdwdj14t` FOREIGN KEY (`discommit_id`) REFERENCES `tb_discommit` (`discommit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `tb_dispostreply` */

insert  into `tb_dispostreply`(`dispostreply_id`,`dispostreply_createtime`,`dispostreply_name`,`dispostreply_report`,`dispostreply_updatetime`,`user_id`,`discommit_id`) values (1,NULL,'修改回复',0,'2018-12-16 19:44:45',1,1),(2,NULL,'回复2',NULL,'2018-12-16 19:14:31',1,1),(3,NULL,'回复3',0,'2018-12-18 13:39:06',1,1),(4,NULL,'回复4',0,'2018-12-18 13:39:13',1,1),(5,NULL,'回复2',NULL,'2018-12-18 14:06:39',1,1);

/*Table structure for table `tb_disrepcount` */

DROP TABLE IF EXISTS `tb_disrepcount`;

CREATE TABLE `tb_disrepcount` (
  `disrepcount_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '帖子举报主键',
  `disrepcount_content` varchar(200) NOT NULL COMMENT '返还的举报内容',
  `disrepcount_createtime` datetime DEFAULT NULL COMMENT '发表时间',
  `disreport_updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次修改时间',
  `dispost_id` int(10) unsigned NOT NULL COMMENT '课程帖子主键',
  PRIMARY KEY (`disrepcount_id`),
  KEY `FKgpe9dg50bulm317xgsp4yik8l` (`dispost_id`),
  CONSTRAINT `FKgpe9dg50bulm317xgsp4yik8l` FOREIGN KEY (`dispost_id`) REFERENCES `tb_dispost` (`dispost_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_disrepcount` */

/*Table structure for table `tb_disreply` */

DROP TABLE IF EXISTS `tb_disreply`;

CREATE TABLE `tb_disreply` (
  `disreply_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '课程回复举报主键',
  `disreply_content` varchar(200) NOT NULL COMMENT '举报内容',
  `disreply_createtime` datetime DEFAULT NULL COMMENT '发表时间',
  `disreply_stuts` tinyint(3) unsigned DEFAULT '0' COMMENT '举报信息审核状态',
  `disreply_updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次修改时间',
  `user_id` int(11) NOT NULL COMMENT '举报的用户id',
  `dispostreply_id` int(10) unsigned NOT NULL COMMENT '课程回复主键',
  PRIMARY KEY (`disreply_id`),
  KEY `FK3otembtwelmtn2wrg9jqjt04i` (`dispostreply_id`),
  CONSTRAINT `FK3otembtwelmtn2wrg9jqjt04i` FOREIGN KEY (`dispostreply_id`) REFERENCES `tb_dispostreply` (`dispostreply_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_disreply` */

/*Table structure for table `tb_disreplylike` */

DROP TABLE IF EXISTS `tb_disreplylike`;

CREATE TABLE `tb_disreplylike` (
  `disreplylike_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '课程点赞主键',
  `disreplylike_createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `disreplylike_stuts` tinyint(3) unsigned DEFAULT '0' COMMENT '状态',
  `disreplylike_updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次修改时间',
  `user_id` int(11) NOT NULL COMMENT '点/反的用户的id',
  `dispostreply_id` int(10) unsigned NOT NULL COMMENT '课程回复主键',
  PRIMARY KEY (`disreplylike_id`),
  KEY `FK7ooi4gc6henvpkudwr25ha7v3` (`dispostreply_id`),
  CONSTRAINT `FK7ooi4gc6henvpkudwr25ha7v3` FOREIGN KEY (`dispostreply_id`) REFERENCES `tb_dispostreply` (`dispostreply_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `tb_disreplylike` */

insert  into `tb_disreplylike`(`disreplylike_id`,`disreplylike_createtime`,`disreplylike_stuts`,`disreplylike_updatetime`,`user_id`,`dispostreply_id`) values (1,NULL,1,'2018-12-16 15:25:01',1,1);

/*Table structure for table `tb_disreport` */

DROP TABLE IF EXISTS `tb_disreport`;

CREATE TABLE `tb_disreport` (
  `disreport_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '评论举报主键',
  `disreport_content` varchar(200) NOT NULL COMMENT '举报内容',
  `disreport_createtime` datetime DEFAULT NULL COMMENT '发表时间',
  `disreport_stuts` tinyint(3) unsigned DEFAULT '0' COMMENT '举报信息审核状态',
  `disreport_updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次修改时间',
  `user_id` int(11) NOT NULL COMMENT '举报的用户id',
  `dispost_id` int(10) unsigned NOT NULL COMMENT '课程帖子主键',
  PRIMARY KEY (`disreport_id`),
  KEY `FKdxk2gdcgm70hra92emt8gbwyx` (`dispost_id`),
  CONSTRAINT `FKdxk2gdcgm70hra92emt8gbwyx` FOREIGN KEY (`dispost_id`) REFERENCES `tb_dispost` (`dispost_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_disreport` */

/*Table structure for table `tb_users` */

DROP TABLE IF EXISTS `tb_users`;

CREATE TABLE `tb_users` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `user_name` varchar(50) NOT NULL COMMENT '用户昵称',
  `user_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次修改时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `tb_users` */

insert  into `tb_users`(`user_id`,`user_createtime`,`user_name`,`user_update_time`) values (1,'2018-12-15 16:38:05','用户1','2018-12-15 16:38:05');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
