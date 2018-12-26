/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.19 : Database - zhangbingqian
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`zhangbingqian` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `zhangbingqian`;

/*Table structure for table `chapter_tb` */

DROP TABLE IF EXISTS `chapter_tb`;

CREATE TABLE `chapter_tb` (
  `chapter_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '章节id',
  `chapter_description` varchar(1000) DEFAULT NULL COMMENT '详细描述',
  `chapter_name` varchar(255) DEFAULT NULL COMMENT '章节/课时名称',
  `curriculum_id` int(11) DEFAULT NULL COMMENT '课程id',
  `last_updte_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次修改时间',
  `parent_id` int(10) unsigned DEFAULT '0' COMMENT '父id,默认为0',
  `creation_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`chapter_id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

/*Data for the table `chapter_tb` */

insert  into `chapter_tb`(`chapter_id`,`chapter_description`,`chapter_name`,`curriculum_id`,`last_updte_time`,`parent_id`,`creation_time`) values (3,NULL,'第1讲：导言：数学建模是开启数学大门的金钥匙',9,'2018-12-21 15:17:05',0,'2018-12-21 15:17:05'),(4,NULL,'1.1 什么是数学建模',9,'2018-12-21 15:18:21',3,'2018-12-21 15:17:05'),(5,NULL,'1.2 数学建模对发展数学学科和推动数学应用的重要性',9,'2018-12-21 15:19:53',3,'2018-12-21 15:17:05'),(6,NULL,'1.3 数学建模对人才培养的重要性',9,'2018-12-21 15:21:09',3,'2018-12-21 15:17:05'),(7,NULL,'1.4 对数学建模学习的建议',9,'2018-12-21 15:21:31',3,'2018-12-21 15:17:05'),(8,NULL,'第2讲：马尔萨斯人口论与数学建模有关',9,'2018-12-21 15:22:12',0,'2018-12-21 15:17:05'),(9,NULL,'2.1 马尔萨斯人口论',9,'2018-12-21 15:22:47',8,'2018-12-21 15:17:05'),(10,NULL,'2.2 马尔萨斯人口模型',9,'2018-12-21 15:22:54',8,'2018-12-21 15:17:05'),(11,NULL,'2.3 Logistic模型',9,'2018-12-21 15:22:55',8,'2018-12-21 15:17:05'),(12,NULL,'2.4 Leslie模型',9,'2018-12-21 15:23:02',8,'2018-12-21 15:17:05'),(13,NULL,'2.5 更复杂的模型',9,'2018-12-21 15:23:08',8,'2018-12-21 15:17:05'),(14,NULL,'第1章 College Life 校园生活',10,'2018-12-21 15:29:02',0,'2018-12-21 15:17:05'),(15,NULL,'1.1 词汇的具体化表达',10,'2018-12-21 15:29:09',14,'2018-12-21 15:17:05'),(16,NULL,'1.2 句子的具体化表达',10,'2018-12-21 15:29:12',14,'2018-12-21 15:17:05'),(17,NULL,'1.3 篇章段落的具体化表达',10,'2018-12-21 15:29:14',14,'2018-12-21 15:17:05'),(18,NULL,'1.4 什么是大学-莫忘少年凌云志',10,'2018-12-21 15:29:17',14,'2018-12-21 15:17:05'),(19,NULL,'第2章 A World of Fast Food 快餐世界',10,'2018-12-21 15:29:48',0,'2018-12-21 15:17:05'),(20,NULL,'2.1 怎样表达“吃”？',10,'2018-12-21 15:29:56',19,'2018-12-21 15:17:05'),(21,NULL,'2.2 句子的“一二三原则”',10,'2018-12-21 15:29:58',19,'2018-12-21 15:17:05'),(22,NULL,'2.3 句子的数字格原则练习',10,'2018-12-21 15:30:03',19,'2018-12-21 15:17:05'),(23,NULL,'2.4 中西饮食文化对比',10,'2018-12-21 15:30:07',19,'2018-12-21 15:17:05'),(24,NULL,'专题一：绪论',11,'2018-12-21 15:30:26',0,'2018-12-21 15:17:05'),(25,NULL,'第一讲 思想政治学科教学论学科性质及学习方法',11,'2018-12-21 15:38:02',24,'2018-12-21 15:17:05'),(26,NULL,'专题二：思想政治课的性质和功能',11,'2018-12-21 15:39:02',0,'2018-12-21 15:17:05'),(27,NULL,'第二讲 思想政治课的性质',11,'2018-12-21 15:39:22',27,'2018-12-21 15:17:05'),(28,NULL,'第三讲 思想政治课的功能',11,'2018-12-21 15:39:41',27,'2018-12-21 15:17:05'),(29,NULL,'专题三：思想政治课的课程设置',11,'2018-12-21 15:39:52',0,'2018-12-21 15:17:05'),(30,NULL,'第四讲 思想政治课程改革',11,'2018-12-21 15:40:43',29,'2018-12-21 15:17:05'),(31,NULL,'第五讲 思想政治课程目标',11,'2018-12-21 15:40:56',29,'2018-12-21 15:17:05'),(32,NULL,'第一周',12,'2018-12-21 15:42:18',0,'2018-12-21 15:17:05'),(33,NULL,'1.1 太极宗师的传奇故事',12,'2018-12-21 15:42:31',32,'2018-12-21 15:17:05'),(34,NULL,'1.2 太极拳的神奇与平凡',12,'2018-12-21 15:43:25',32,'2018-12-21 15:17:05'),(35,NULL,'1.3 为什么要练太极拳',12,'2018-12-21 15:44:27',32,'2018-12-21 15:17:05'),(36,NULL,'第二周',12,'2018-12-21 15:44:29',0,'2018-12-21 15:17:05'),(37,NULL,'2.1 太极拳传承脉络',12,'2018-12-21 15:45:48',36,'2018-12-21 15:17:05'),(38,NULL,'2.2 太极拳流派与风格',12,'2018-12-21 15:45:58',36,'2018-12-21 15:17:05'),(39,NULL,'2.3 太极拳欣赏',12,'2018-12-21 15:46:08',36,'2018-12-21 15:17:05'),(40,NULL,'第一周',13,'2018-12-21 15:49:04',0,'2018-12-21 15:17:05'),(41,NULL,'1.1 了解园丁艺术',13,'2018-12-21 15:49:18',40,'2018-12-21 15:17:05'),(42,NULL,'1.2 准备工具',13,'2018-12-21 15:49:30',40,'2018-12-21 15:17:05'),(43,NULL,'第二周',13,'2018-12-21 15:49:34',0,'2018-12-21 15:17:05'),(44,NULL,'2.1 怎样站立',13,'2018-12-21 15:50:01',43,'2018-12-21 15:17:05'),(45,NULL,'2.2 怎样拿剪子',13,'2018-12-21 15:50:10',43,'2018-12-21 15:17:05'),(46,NULL,'第一章 外国电影史',14,'2018-12-21 15:51:35',0,'2018-12-21 15:17:05'),(47,NULL,'第一节 电影的诞生',14,'2018-12-21 15:51:58',46,'2018-12-21 15:17:05'),(48,NULL,'第二节 电影叙事',14,'2018-12-21 15:52:14',46,'2018-12-21 15:17:05'),(49,NULL,'第三节 苏联蒙太奇学派',14,'2018-12-21 15:52:24',46,'2018-12-21 15:17:05'),(50,NULL,'第四节 欧洲第二次现代主义思潮',14,'2018-12-21 15:52:55',46,'2018-12-21 15:17:05'),(51,NULL,'第五节 法国新浪潮',14,'2018-12-21 15:53:04',46,'2018-12-21 15:17:05'),(52,NULL,'第六节 新好莱坞',14,'2018-12-21 15:53:17',46,'2018-12-21 15:17:05'),(53,NULL,'第二章 中国电影史',14,'2018-12-21 15:53:55',0,NULL),(54,NULL,'第一节 中国电影第一步',14,'2018-12-21 15:54:31',53,NULL),(55,NULL,'第二章 中国电影史',14,'2018-12-21 16:02:07',0,'2018-12-21 15:17:05'),(56,NULL,'第一节 从强大走向更强大',14,'2018-12-21 16:02:31',0,'2018-12-21 15:17:05'),(57,NULL,'第二章 中国电影史',14,'2018-12-21 16:03:49',0,NULL);

/*Table structure for table `course_ware_tb` */

DROP TABLE IF EXISTS `course_ware_tb`;

CREATE TABLE `course_ware_tb` (
  `course_ware_id` varchar(255) NOT NULL COMMENT '课件编号',
  `class_hour_id` int(11) DEFAULT NULL COMMENT '课时id',
  `courseware_creation_time` datetime DEFAULT NULL COMMENT '创建时间',
  `courseware_description` varchar(1000) DEFAULT NULL COMMENT '课件描述',
  `courseware_duration` int(10) unsigned DEFAULT '0' COMMENT '课件时长（秒）',
  `courseware_path` varchar(255) DEFAULT NULL COMMENT '课件路径',
  `courseware_size` varchar(255) DEFAULT NULL COMMENT '课件大小',
  `courseware_type` varchar(255) DEFAULT NULL COMMENT '课件类型',
  `last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次修改时间',
  PRIMARY KEY (`course_ware_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `course_ware_tb` */

insert  into `course_ware_tb`(`course_ware_id`,`class_hour_id`,`courseware_creation_time`,`courseware_description`,`courseware_duration`,`courseware_path`,`courseware_size`,`courseware_type`,`last_update_time`) values ('测试数据',47,NULL,'测试数据',0,'测试数据',NULL,NULL,'2018-12-23 14:16:48');

/*Table structure for table `covermap_tb` */

DROP TABLE IF EXISTS `covermap_tb`;

CREATE TABLE `covermap_tb` (
  `covermap_id` varchar(255) NOT NULL COMMENT '封面图id',
  `covermap_url` varchar(255) NOT NULL COMMENT '封面图路径',
  `curriculum_id` int(11) NOT NULL COMMENT '课程id',
  `last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次修改时间',
  PRIMARY KEY (`covermap_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `covermap_tb` */

/*Table structure for table `curriculum_tb` */

DROP TABLE IF EXISTS `curriculum_tb`;

CREATE TABLE `curriculum_tb` (
  `curriculum_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '课程编号',
  `course_introduction` varchar(1000) DEFAULT NULL COMMENT '课程介绍',
  `creation_time` datetime DEFAULT NULL COMMENT '创建时间',
  `curriculum_category_id` int(11) DEFAULT NULL COMMENT '课程类别id',
  `curriculum_name` varchar(255) DEFAULT NULL COMMENT '课程名称',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后一次修改时间',
  `start_time` datetime DEFAULT NULL COMMENT '开课时间',
  `subscription_num` int(10) unsigned DEFAULT '0' COMMENT '订阅人数',
  `teacher_id` int(11) NOT NULL COMMENT '老师id',
  `whether_to_issue` int(10) unsigned DEFAULT '0' COMMENT '是否发布（0：否，1：是）',
  PRIMARY KEY (`curriculum_id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;

/*Data for the table `curriculum_tb` */

insert  into `curriculum_tb`(`curriculum_id`,`course_introduction`,`creation_time`,`curriculum_category_id`,`curriculum_name`,`end_time`,`last_update_time`,`start_time`,`subscription_num`,`teacher_id`,`whether_to_issue`) values (9,'fjfghfhfg',NULL,1,'asasa',NULL,'2018-12-21 15:08:33',NULL,6,1,0),(10,'热门文科必修课',NULL,2,'大学英语',NULL,'2018-12-21 15:09:14',NULL,4,2,0),(11,'热门文科必修课',NULL,2,'大学政治',NULL,'2018-12-21 15:09:41',NULL,7,3,0),(12,'热门选修课',NULL,1,'太极拳',NULL,'2018-12-21 15:10:07',NULL,6,4,0),(13,'热门选修课',NULL,1,'园丁教学',NULL,'2018-12-21 15:10:33',NULL,0,4,0),(14,'热门选修课',NULL,1,'电影观赏',NULL,'2018-12-21 15:10:48',NULL,9,4,0),(62,'qqqqqq','2018-12-26 17:24:08',1,'qqq',NULL,'2018-12-26 17:24:08',NULL,2,1,NULL);

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values (66),(66),(66),(66),(66),(66);

/*Table structure for table `notice_tb` */

DROP TABLE IF EXISTS `notice_tb`;

CREATE TABLE `notice_tb` (
  `notice_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '公告表id',
  `announcement_content` varchar(1000) DEFAULT NULL COMMENT '公告内容',
  `creation_time` datetime DEFAULT NULL COMMENT '创建时间',
  `curriculum_id` int(11) DEFAULT NULL COMMENT '课程id',
  `teacher_id` int(11) DEFAULT NULL COMMENT '老师id',
  `last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `notice_title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;

/*Data for the table `notice_tb` */

insert  into `notice_tb`(`notice_id`,`announcement_content`,`creation_time`,`curriculum_id`,`teacher_id`,`last_update_time`,`notice_title`) values (1,'mmm',NULL,9,1,'2018-12-26 17:19:17','sdsdss'),(61,'ooo','2018-12-26 17:17:06',9,1,'2018-12-26 17:18:16','lll');

/*Table structure for table `scoring_standard_tb` */

DROP TABLE IF EXISTS `scoring_standard_tb`;

CREATE TABLE `scoring_standard_tb` (
  `scoring_standard_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注:评分表id',
  `curriculum_id` int(11) DEFAULT NULL COMMENT '备注:课程id',
  `proportion` int(11) DEFAULT '50' COMMENT '备注:章节测试所占比重(一门课程比重总和必须为100)',
  `update_count` int(11) DEFAULT '0' COMMENT '修改次数,默认为0',
  `path_identity` int(11) DEFAULT NULL,
  PRIMARY KEY (`scoring_standard_id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

/*Data for the table `scoring_standard_tb` */

insert  into `scoring_standard_tb`(`scoring_standard_id`,`curriculum_id`,`proportion`,`update_count`,`path_identity`) values (3,1,50,1,NULL),(63,12,25,1,NULL),(64,12,36,1,NULL),(65,13,56,0,NULL);

/*Table structure for table `student_credit_tb` */

DROP TABLE IF EXISTS `student_credit_tb`;

CREATE TABLE `student_credit_tb` (
  `student_credit_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注:学分表id',
  `credit` double unsigned NOT NULL COMMENT '备注:学分',
  `curriculum_id` int(11) DEFAULT NULL COMMENT '备注:课程id',
  `last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '备注:最后一次修改时间',
  `student_id` int(11) DEFAULT NULL COMMENT '备注:学生id',
  PRIMARY KEY (`student_credit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `student_credit_tb` */

insert  into `student_credit_tb`(`student_credit_id`,`credit`,`curriculum_id`,`last_update_time`,`student_id`) values (2,50.5,2,'2018-12-16 11:13:22',1),(8,90,1,'2018-12-20 16:05:42',3),(11,85,1,'2018-12-20 21:58:48',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
