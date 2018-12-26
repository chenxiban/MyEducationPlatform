/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.19 : Database - llltzhihuistudent
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`llltzhihuistudent` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `llltzhihuistudent`;

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values (1),(1),(1);

/*Table structure for table `stucoursecomment` */

DROP TABLE IF EXISTS `stucoursecomment`;

CREATE TABLE `stucoursecomment` (
  `comment_id` int(10) unsigned NOT NULL COMMENT '备注:学生评价表自增ID',
  `comment_context` varchar(255) NOT NULL COMMENT '备注:评价内容',
  `comment_start` int(10) unsigned NOT NULL COMMENT '备注:评价星级',
  `comment_time` date NOT NULL COMMENT '备注:评价时间',
  `comment_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '备注:评价修改时间',
  `course_count` varchar(255) NOT NULL COMMENT '备注:第几次开课',
  `course_id` int(10) unsigned NOT NULL COMMENT '备注:课程ID',
  `student_id` int(10) unsigned NOT NULL COMMENT '备注:学生ID',
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `stucoursecomment` */

insert  into `stucoursecomment`(`comment_id`,`comment_context`,`comment_start`,`comment_time`,`comment_update_time`,`course_count`,`course_id`,`student_id`) values (0,'莹莹',5,'2018-12-11','2018-12-15 17:07:05','第一次开课',1,1);

/*Table structure for table `studentrecord` */

DROP TABLE IF EXISTS `studentrecord`;

CREATE TABLE `studentrecord` (
  `schole_studenting_id` int(10) unsigned NOT NULL COMMENT '备注:学生学习表自增ID',
  `student_id` int(10) unsigned NOT NULL COMMENT '备注:学生ID',
  `student_state` int(11) NOT NULL DEFAULT '0' COMMENT '备注:视频学习状态',
  `unit_course_id` int(10) unsigned NOT NULL COMMENT '备注:章节课时ID',
  `video_exit_time` double DEFAULT '0' COMMENT '备注:视频退出时间',
  `video_studenting_time` int(11) DEFAULT NULL COMMENT '备注:视频学习时长',
  PRIMARY KEY (`schole_studenting_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `studentrecord` */

/*Table structure for table `stugivepraise` */

DROP TABLE IF EXISTS `stugivepraise`;

CREATE TABLE `stugivepraise` (
  `give_praise_id` int(10) unsigned NOT NULL COMMENT '备注:学生点赞表自增ID',
  `comment_id` int(10) unsigned NOT NULL COMMENT '备注:评价ID',
  `give_praise_state` tinyint(4) NOT NULL COMMENT '备注:对评价的点赞状态',
  `not_praise_state` tinyint(4) NOT NULL COMMENT '备注:对评价踩赞个状态',
  `student_id` int(10) unsigned NOT NULL COMMENT '备注:学生ID',
  `stucoursecomment_stugivepraise_id` int(10) unsigned DEFAULT NULL COMMENT '备注:学生评价表自增ID',
  PRIMARY KEY (`give_praise_id`),
  KEY `FKw9hrax49c1dpmn8eojs63rh` (`stucoursecomment_stugivepraise_id`),
  KEY `FKrc2hjwvv9i7d3fflorl1cwuia` (`comment_id`),
  CONSTRAINT `FKrc2hjwvv9i7d3fflorl1cwuia` FOREIGN KEY (`comment_id`) REFERENCES `stucoursecomment` (`comment_id`),
  CONSTRAINT `FKw9hrax49c1dpmn8eojs63rh` FOREIGN KEY (`stucoursecomment_stugivepraise_id`) REFERENCES `stucoursecomment` (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `stugivepraise` */

/*Table structure for table `stuselectioncourse` */

DROP TABLE IF EXISTS `stuselectioncourse`;

CREATE TABLE `stuselectioncourse` (
  `stu_selection_course_id` int(10) unsigned NOT NULL COMMENT '备注:学生选课表自增ID',
  `course_id` int(10) unsigned NOT NULL COMMENT '备注:课程ID',
  `selection_course_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '备注:选课时间',
  `student_id` int(10) unsigned NOT NULL COMMENT '备注:学生ID',
  PRIMARY KEY (`stu_selection_course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `stuselectioncourse` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
