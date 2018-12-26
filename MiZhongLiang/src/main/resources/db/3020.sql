/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.19 : Database - mizhongliang
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mizhongliang` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `mizhongliang`;

/*Table structure for table `fanstb` */

DROP TABLE IF EXISTS `fanstb`;

CREATE TABLE `fanstb` (
  `fans_id` int(10) unsigned NOT NULL COMMENT '备注:粉丝自动增长主键',
  `fans_users_id` int(10) unsigned NOT NULL,
  `fans_users_ids` int(10) unsigned NOT NULL,
  PRIMARY KEY (`fans_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `fanstb` */

/*Table structure for table `followtb` */

DROP TABLE IF EXISTS `followtb`;

CREATE TABLE `followtb` (
  `follow_id` int(10) unsigned NOT NULL COMMENT '备注:关注自动增长主键',
  `follow_users_id` int(10) unsigned NOT NULL,
  `follow_users_ids` int(10) unsigned NOT NULL,
  PRIMARY KEY (`follow_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `followtb` */

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values (1),(1);

/*Table structure for table `usersdetailstb` */

DROP TABLE IF EXISTS `usersdetailstb`;

CREATE TABLE `usersdetailstb` (
  `users_id` int(10) unsigned NOT NULL COMMENT '用户id',
  `users_birthday` varchar(20) DEFAULT NULL COMMENT '生日',
  `users_departmentsmajor` varchar(20) NOT NULL COMMENT '院系',
  `users_diploma` varchar(20) DEFAULT NULL COMMENT '最高学历',
  `users_email` varchar(50) NOT NULL COMMENT '邮箱',
  `users_ext1` varchar(20) DEFAULT NULL COMMENT '预留字段1',
  `users_ext2` int(10) unsigned DEFAULT NULL COMMENT '预留字段2',
  `users_idcard` varchar(18) DEFAULT NULL COMMENT '身份证',
  `users_identitytype` varchar(4) NOT NULL COMMENT '身份类型:1为学生；0为老师',
  `users_name` varchar(8) DEFAULT NULL COMMENT '用户真实姓名',
  `users_nickname` varchar(20) NOT NULL COMMENT '用户昵称',
  `users_profile` varchar(200) DEFAULT NULL COMMENT '个人简介',
  `users_sex` char(1) NOT NULL COMMENT '备注:用户性别',
  `users_telephone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `users_url` varchar(50) NOT NULL COMMENT '头像路径',
  PRIMARY KEY (`users_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `usersdetailstb` */

insert  into `usersdetailstb`(`users_id`,`users_birthday`,`users_departmentsmajor`,`users_diploma`,`users_email`,`users_ext1`,`users_ext2`,`users_idcard`,`users_identitytype`,`users_name`,`users_nickname`,`users_profile`,`users_sex`,`users_telephone`,`users_url`) values (1,'2018-1-1','计算机','本科','123@qq.com',NULL,NULL,'411403199711305118','1','小佳','丑逼李海潮','李海潮是丑逼','男','13245631234','img/lhc.jpg'),(2,'2018-1-1','计算机','本科','123@qq.com',NULL,NULL,'411403199711305118','0','郭士才','丑逼李海潮','李海潮是丑逼','男','13245631234','img/lhc.jpg');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
