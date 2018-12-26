/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.19 : Database - testandexam
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`testandexam` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `testandexam`;

/*Table structure for table `choicequestionanswertb` */

DROP TABLE IF EXISTS `choicequestionanswertb`;

CREATE TABLE `choicequestionanswertb` (
  `choicequestionanswer_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注：选择题正确答案主键',
  `choicequestionanswer_answer` varchar(225) NOT NULL COMMENT '备注：选择题正确答案',
  `choicequestionanswer_create_date_time` datetime DEFAULT NULL COMMENT '备注：选择题答案构成时间',
  `choicequestionanswer_ext1` int(11) DEFAULT NULL,
  `choicequestionanswer_ext2` varchar(225) DEFAULT NULL,
  `choicequestionanswer_last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '备注：选择题答案修改时间',
  `choicequestionanswer_choicequestion_id` int(10) unsigned NOT NULL COMMENT '备注：选择题主键',
  PRIMARY KEY (`choicequestionanswer_id`),
  KEY `FKsmigqiv5r670udu6fa0nsybsw` (`choicequestionanswer_choicequestion_id`),
  CONSTRAINT `FKsmigqiv5r670udu6fa0nsybsw` FOREIGN KEY (`choicequestionanswer_choicequestion_id`) REFERENCES `choicequestiontb` (`choicequestion_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `choicequestionanswertb` */

insert  into `choicequestionanswertb`(`choicequestionanswer_id`,`choicequestionanswer_answer`,`choicequestionanswer_create_date_time`,`choicequestionanswer_ext1`,`choicequestionanswer_ext2`,`choicequestionanswer_last_update_time`,`choicequestionanswer_choicequestion_id`) values (10,'A','2018-12-28 15:24:47',NULL,NULL,'2018-12-28 15:24:47',4),(11,'B','2018-12-28 15:24:47',NULL,NULL,'2018-12-28 15:24:47',4),(12,'C','2018-12-28 15:24:47',NULL,NULL,'2018-12-28 15:24:47',4),(13,'D','2018-12-28 15:24:47',NULL,NULL,'2018-12-28 15:24:47',4),(14,'A','2018-12-28 15:25:14',NULL,NULL,'2018-12-28 15:25:14',5),(15,'B','2018-12-28 15:25:14',NULL,NULL,'2018-12-28 15:25:14',5),(16,'C','2018-12-28 15:25:14',NULL,NULL,'2018-12-28 15:25:14',5),(17,'A','2018-12-28 16:19:08',NULL,NULL,'2018-12-28 16:19:08',6),(18,'B','2018-12-28 16:19:08',NULL,NULL,'2018-12-28 16:19:08',6);

/*Table structure for table `choicequestiontb` */

DROP TABLE IF EXISTS `choicequestiontb`;

CREATE TABLE `choicequestiontb` (
  `choicequestion_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注：选择题主键',
  `choicequestion_chapter_id` int(10) unsigned DEFAULT NULL COMMENT '备注：章节外键',
  `choicequestion_course_id` int(10) unsigned DEFAULT NULL COMMENT '备注：课程外键',
  `choicequestion_create_date_time` datetime DEFAULT NULL COMMENT '备注：选择题构成时间',
  `choicequestion_ext1` int(11) DEFAULT NULL,
  `choicequestion_ext2` varchar(225) DEFAULT NULL,
  `choicequestion_imgurl` varchar(225) DEFAULT NULL COMMENT '备注：选择题图片',
  `choicequestion_last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '备注：选择题修改时间',
  `choicequestion_question` varchar(225) NOT NULL COMMENT '备注：选择题问题',
  `choicequestion_score` int(10) unsigned NOT NULL COMMENT '备注：每道选择题分数',
  `choicequestiontb_issingleselection` tinyint(4) NOT NULL DEFAULT '0' COMMENT '备注：选择题类型',
  PRIMARY KEY (`choicequestion_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `choicequestiontb` */

insert  into `choicequestiontb`(`choicequestion_id`,`choicequestion_chapter_id`,`choicequestion_course_id`,`choicequestion_create_date_time`,`choicequestion_ext1`,`choicequestion_ext2`,`choicequestion_imgurl`,`choicequestion_last_update_time`,`choicequestion_question`,`choicequestion_score`,`choicequestiontb_issingleselection`) values (4,1,1,'2018-12-28 15:24:47',NULL,NULL,NULL,'2018-12-28 15:24:47','asdasdasasd',2,1),(5,1,1,'2018-12-28 15:25:14',NULL,NULL,NULL,'2018-12-28 15:25:14','asdasd',4,1),(6,14,46,'2018-12-28 16:19:08',NULL,NULL,NULL,'2018-12-28 16:19:08','timuxuanze',1,1);

/*Table structure for table `gapfillinganswertb` */

DROP TABLE IF EXISTS `gapfillinganswertb`;

CREATE TABLE `gapfillinganswertb` (
  `gapfillinganswer_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注：填空题正确答案主键',
  `gapfillinganswer_answer` varchar(225) NOT NULL COMMENT '备注：填空题正确答案',
  `gapfillinganswer_create_date_time` datetime DEFAULT NULL COMMENT '备注：填空题正确答案构成时间',
  `gapfillinganswer_ext1` int(11) DEFAULT NULL,
  `gapfillinganswer_ext2` varchar(225) DEFAULT NULL,
  `gapfillinganswer_last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '备注：填空题正确答案修改时间',
  `gapfillinganswer_gapfilling_id` int(10) unsigned NOT NULL COMMENT '备注：填空题主键',
  PRIMARY KEY (`gapfillinganswer_id`),
  KEY `FKo7lfiyogkhg34rs6wlgjott24` (`gapfillinganswer_gapfilling_id`),
  CONSTRAINT `FKo7lfiyogkhg34rs6wlgjott24` FOREIGN KEY (`gapfillinganswer_gapfilling_id`) REFERENCES `gapfillingtb` (`gapfilling_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `gapfillinganswertb` */

insert  into `gapfillinganswertb`(`gapfillinganswer_id`,`gapfillinganswer_answer`,`gapfillinganswer_create_date_time`,`gapfillinganswer_ext1`,`gapfillinganswer_ext2`,`gapfillinganswer_last_update_time`,`gapfillinganswer_gapfilling_id`) values (2,'tiankong','2018-12-27 20:33:41',NULL,NULL,'2018-12-27 20:33:41',2),(3,'1','2018-12-28 15:26:20',NULL,NULL,'2018-12-28 15:26:20',3),(4,'2','2018-12-28 15:26:34',NULL,NULL,'2018-12-28 15:26:35',4),(5,'3','2018-12-28 15:26:38',NULL,NULL,'2018-12-28 15:26:38',5);

/*Table structure for table `gapfillingtb` */

DROP TABLE IF EXISTS `gapfillingtb`;

CREATE TABLE `gapfillingtb` (
  `gapfilling_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注：填空题主键',
  `gapfilling_chapter_id` int(10) unsigned DEFAULT NULL COMMENT '备注：章节外键',
  `gapfilling_course_id` int(10) unsigned DEFAULT NULL COMMENT '备注：课程外键',
  `gapfilling_create_date_time` datetime DEFAULT NULL COMMENT '备注：填空题构成时间',
  `gapfilling_ext1` int(11) DEFAULT NULL,
  `gapfilling_ext2` varchar(225) DEFAULT NULL,
  `gapfilling_imgurl` varchar(225) DEFAULT NULL COMMENT '备注：填空题图片',
  `gapfilling_last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '备注：填空题修改时间',
  `gapfilling_question` varchar(225) NOT NULL COMMENT '备注：填空题问题',
  `gapfilling_score` int(10) unsigned NOT NULL COMMENT '备注：每道填空题分数',
  PRIMARY KEY (`gapfilling_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `gapfillingtb` */

insert  into `gapfillingtb`(`gapfilling_id`,`gapfilling_chapter_id`,`gapfilling_course_id`,`gapfilling_create_date_time`,`gapfilling_ext1`,`gapfilling_ext2`,`gapfilling_imgurl`,`gapfilling_last_update_time`,`gapfilling_question`,`gapfilling_score`) values (2,1,1,'2018-12-27 20:33:41',NULL,NULL,NULL,'2018-12-28 15:48:26','tiankongti',4),(3,1,1,'2018-12-28 15:26:20',NULL,NULL,NULL,'2018-12-28 15:48:27','填空题问题',1),(4,1,1,'2018-12-28 15:26:34',NULL,NULL,NULL,'2018-12-28 15:48:28','填空题问题2',1),(5,1,1,'2018-12-28 15:26:38',NULL,NULL,NULL,'2018-12-28 15:48:31','填空题问题3',1);

/*Table structure for table `optiontb` */

DROP TABLE IF EXISTS `optiontb`;

CREATE TABLE `optiontb` (
  `option_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注：选项主键',
  `optiona` varchar(50) NOT NULL COMMENT '备注：选项',
  `optionb` varchar(50) NOT NULL COMMENT '备注：选项',
  `optionc` varchar(50) NOT NULL COMMENT '备注：选项',
  `option_create_date_time` datetime DEFAULT NULL COMMENT '备注：选项构成时间',
  `optiond` varchar(50) NOT NULL COMMENT '备注：选项',
  `option_ext1` int(11) DEFAULT NULL,
  `option_ext2` varchar(225) DEFAULT NULL,
  `option_last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '备注：选项修改时间',
  `option_choicequestion_id` int(10) unsigned NOT NULL COMMENT '备注：选择题主键',
  PRIMARY KEY (`option_id`),
  KEY `FKebl1a2esea0aurrwhb22qofqs` (`option_choicequestion_id`),
  CONSTRAINT `FKebl1a2esea0aurrwhb22qofqs` FOREIGN KEY (`option_choicequestion_id`) REFERENCES `choicequestiontb` (`choicequestion_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `optiontb` */

insert  into `optiontb`(`option_id`,`optiona`,`optionb`,`optionc`,`option_create_date_time`,`optiond`,`option_ext1`,`option_ext2`,`option_last_update_time`,`option_choicequestion_id`) values (4,'A、asd','B、asdasd','C、asd','2018-12-28 15:24:47','D、asdasd',NULL,NULL,'2018-12-28 15:24:47',4),(5,'A、asdasd','B、asdasd','C、asdasd','2018-12-28 15:25:14','D、asdasdasd',NULL,NULL,'2018-12-28 15:25:14',5),(6,'A、a','B、b','C、c','2018-12-28 16:19:08','D、d',NULL,NULL,'2018-12-28 16:19:08',6);

/*Table structure for table `studentexamsrecordtb` */

DROP TABLE IF EXISTS `studentexamsrecordtb`;

CREATE TABLE `studentexamsrecordtb` (
  `studentexamsrecord_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注：学生考试记录主键',
  `studentexamsrecord_answer` varchar(225) DEFAULT NULL COMMENT '备注：记录学生考试针对问题选择的答案',
  `studentexamsrecord_course_id` int(10) unsigned DEFAULT NULL COMMENT '备注：课程外键',
  `studentexamsrecord_create_date_time` datetime DEFAULT NULL COMMENT '备注：学生考试记录创建时间',
  `studentexamsrecord_ext1` int(11) DEFAULT NULL,
  `studentexamsrecord_ext2` varchar(225) DEFAULT NULL,
  `studentexamsrecord_last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '备注：学生考试记录修改时间',
  `studentexamsrecord_question` varchar(225) NOT NULL COMMENT '备注：记录学生考试问题',
  `studentexamsrecord_student_id` int(10) unsigned DEFAULT NULL COMMENT '备注：学生外键',
  `studentexamsrecord_studentexams_id` int(10) unsigned NOT NULL COMMENT '备注：学生考试主键',
  PRIMARY KEY (`studentexamsrecord_id`),
  KEY `FKjc0r52ukj87rs1wtylfl67b98` (`studentexamsrecord_studentexams_id`),
  CONSTRAINT `FKjc0r52ukj87rs1wtylfl67b98` FOREIGN KEY (`studentexamsrecord_studentexams_id`) REFERENCES `studentexamstb` (`studentexams_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `studentexamsrecordtb` */

/*Table structure for table `studentexamstb` */

DROP TABLE IF EXISTS `studentexamstb`;

CREATE TABLE `studentexamstb` (
  `studentexams_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注：学生考试主键',
  `studentexams_create_date_time` datetime NOT NULL COMMENT '备注：学生考试开始时间',
  `studentexams_deadline_time` datetime NOT NULL COMMENT '备注：学生考试截止时间',
  `studentexams_last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '备注：修改时间',
  `studentexams_score` int(10) unsigned NOT NULL COMMENT '备注：学生考试分数',
  `studenttest_course_id` int(10) unsigned DEFAULT NULL COMMENT '备注：课程外键',
  `studenttest_ext1` int(11) DEFAULT NULL,
  `studenttest_ext2` varchar(225) DEFAULT NULL,
  `studenttest_student_id` int(10) unsigned DEFAULT NULL COMMENT '备注：学生外键',
  PRIMARY KEY (`studentexams_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `studentexamstb` */

/*Table structure for table `studenttestrecordtb` */

DROP TABLE IF EXISTS `studenttestrecordtb`;

CREATE TABLE `studenttestrecordtb` (
  `studenttestrecord_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注：学生测试记录主键',
  `studenttestrecord_answers` varchar(225) DEFAULT NULL COMMENT '备注：学生填写测试的答案',
  `studenttestrecord_chapter_id` int(10) unsigned DEFAULT NULL COMMENT '备注：章节外键',
  `studenttestrecord_course_id` int(10) unsigned DEFAULT NULL COMMENT '备注：课程外键',
  `studenttestrecord_create_date_time` datetime DEFAULT NULL COMMENT '备注：创建学生测试记录表的时间',
  `studenttestrecord_ext1` int(11) DEFAULT NULL,
  `studenttestrecord_ext2` varchar(225) DEFAULT NULL,
  `studenttestrecord_last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '备注：最后一次修改学生测试记录表的时间',
  `studenttestrecord_questions` varchar(225) NOT NULL COMMENT '备注：学生测试的问题',
  `studenttestrecord_student_id` int(10) unsigned DEFAULT NULL COMMENT '备注：学生外键',
  `studenttestrecord_studenttest_id` int(10) unsigned DEFAULT NULL COMMENT '备注：学生测试外键',
  PRIMARY KEY (`studenttestrecord_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `studenttestrecordtb` */

insert  into `studenttestrecordtb`(`studenttestrecord_id`,`studenttestrecord_answers`,`studenttestrecord_chapter_id`,`studenttestrecord_course_id`,`studenttestrecord_create_date_time`,`studenttestrecord_ext1`,`studenttestrecord_ext2`,`studenttestrecord_last_update_time`,`studenttestrecord_questions`,`studenttestrecord_student_id`,`studenttestrecord_studenttest_id`) values (1,'C',1,1,'2018-12-28 15:47:42',NULL,NULL,'2018-12-28 15:47:42','asdasdasasd',1,1),(2,'B',1,1,'2018-12-28 15:47:42',NULL,NULL,'2018-12-28 15:47:42','asdasd',1,1),(3,'asdasd',1,1,'2018-12-28 15:48:51',NULL,NULL,'2018-12-28 15:48:51','填空题问题',1,1);

/*Table structure for table `studenttesttb` */

DROP TABLE IF EXISTS `studenttesttb`;

CREATE TABLE `studenttesttb` (
  `studenttest_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注：学生测试主键',
  `studenttest_chapter_id` int(10) unsigned DEFAULT NULL COMMENT '备注：章节外键',
  `studenttest_create_date_time` datetime NOT NULL COMMENT '备注：创建该表测试时间',
  `studenttest_deadline_time` datetime DEFAULT NULL,
  `studenttest_ext1` int(11) DEFAULT NULL,
  `studenttest_ext2` varchar(225) DEFAULT NULL,
  `studenttest_last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '备注：修改该表测试时间',
  `studenttest_number` int(10) unsigned DEFAULT '0' COMMENT '备注：学生已经测试的次数',
  `studenttest_score` int(10) unsigned NOT NULL COMMENT '备注：学生测试分数',
  `studenttest_student_id` int(10) unsigned DEFAULT NULL COMMENT '备注：学生外键',
  PRIMARY KEY (`studenttest_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `studenttesttb` */

/*Table structure for table `teachercreateexamstb` */

DROP TABLE IF EXISTS `teachercreateexamstb`;

CREATE TABLE `teachercreateexamstb` (
  `teachercreateexams_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注：教师发起考试主键',
  `teachercreateexams_choicenum` int(10) unsigned DEFAULT NULL COMMENT '备注：选择题数量',
  `teachercreateexams_course_id` int(10) unsigned DEFAULT NULL COMMENT '备注：课程外键',
  `teachercreateexams_endtime` datetime NOT NULL COMMENT '备注：教师发起考试截止提交时间',
  `teachercreateexams_examsname` varchar(50) DEFAULT NULL COMMENT '备注：教师发起考试名称',
  `teachercreateexams_examstime` varchar(225) DEFAULT NULL COMMENT '备注：教师发起考试时间',
  `teachercreateexams_explain` varchar(225) NOT NULL COMMENT '备注：教师发起考试说明',
  `teachercreateexams_ext1` int(11) DEFAULT NULL,
  `teachercreateexams_ext2` varchar(225) DEFAULT NULL,
  `teachercreateexams_gapfillingnum` int(10) unsigned DEFAULT NULL COMMENT '备注：填空题数量',
  `teachercreateexams_random` varchar(10) NOT NULL COMMENT '备注：考试题目是否随机出现',
  `teachercreateexams_score` int(10) unsigned DEFAULT NULL COMMENT '备注：教师发起考试的分数',
  `teachercreateexams_state` tinyint(4) DEFAULT '1' COMMENT '备注：教师发起考试的状态',
  `teachercreateexams_teacher_id` int(10) unsigned DEFAULT NULL COMMENT '备注：教师外键',
  `teachercreateexams_tfngnum` int(10) unsigned DEFAULT NULL COMMENT '备注：判断题数量',
  PRIMARY KEY (`teachercreateexams_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `teachercreateexamstb` */

/*Table structure for table `teachercreatetesttb` */

DROP TABLE IF EXISTS `teachercreatetesttb`;

CREATE TABLE `teachercreatetesttb` (
  `teachercreatetest_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注：教师发起测试主键',
  `teachercratetest_choicenum` int(10) unsigned DEFAULT NULL COMMENT '备注：选择题数量',
  `teachercratetest_gapfillingnum` int(10) unsigned DEFAULT NULL COMMENT '备注：填空题数量',
  `teachercratetest_random` varchar(10) NOT NULL COMMENT '备注：测试题目是否随机出现',
  `teachercratetest_state` tinyint(4) NOT NULL DEFAULT '0' COMMENT '备注：测试状态(0:未发布；1:发布)',
  `teachercratetest_testname` varchar(120) NOT NULL COMMENT '备注：测试名称',
  `teachercratetest_tfngnum` int(10) unsigned DEFAULT NULL COMMENT '备注：判断题数量',
  `teachercreatetest_chapter_id` int(10) unsigned DEFAULT NULL COMMENT '备注：章节外键',
  `teachercreatetest_endtime` datetime NOT NULL COMMENT '备注：测试截止时间',
  `teachercreatetest_explain` varchar(225) NOT NULL COMMENT '备注：测试说明',
  `teachercreatetest_ext1` int(11) DEFAULT NULL,
  `teachercreatetest_ext2` varchar(225) DEFAULT NULL,
  `teachercreatetest_number` int(10) unsigned NOT NULL COMMENT '备注：允许测试的次数',
  `teachercreatetest_teacher_id` int(10) unsigned DEFAULT NULL COMMENT '备注：教师外键',
  `teachercreatetest_testtime` varchar(225) DEFAULT NULL COMMENT '备注：测试时间',
  PRIMARY KEY (`teachercreatetest_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `teachercreatetesttb` */

insert  into `teachercreatetesttb`(`teachercreatetest_id`,`teachercratetest_choicenum`,`teachercratetest_gapfillingnum`,`teachercratetest_random`,`teachercratetest_state`,`teachercratetest_testname`,`teachercratetest_tfngnum`,`teachercreatetest_chapter_id`,`teachercreatetest_endtime`,`teachercreatetest_explain`,`teachercreatetest_ext1`,`teachercreatetest_ext2`,`teachercreatetest_number`,`teachercreatetest_teacher_id`,`teachercreatetest_testtime`) values (7,0,0,'是',0,'aaaaaaaaaaaaaa',0,9,'2018-12-29 00:00:00','aaaaaaaaaaa',NULL,NULL,1,1,'0'),(8,1,1,'是',0,'uiouio',1,14,'2018-12-29 00:00:00','uiouio',NULL,NULL,1,1,'0'),(9,0,0,'是',0,'dasdas',0,13,'2018-12-29 00:00:00','asdas',NULL,NULL,1,1,'0'),(10,0,0,'是',0,'uewilbafkjds',0,12,'2018-12-29 00:00:00','sdfsdhjkdffg',NULL,NULL,1,1,'0');

/*Table structure for table `tfnganswertb` */

DROP TABLE IF EXISTS `tfnganswertb`;

CREATE TABLE `tfnganswertb` (
  `tfnganswer_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注：判断题正确答案主键',
  `tfnganswer_answer` tinyint(4) DEFAULT NULL COMMENT '备注：判断题正确答案(0:错误 1：正确)',
  `tfnganswer_create_date_time` datetime DEFAULT NULL COMMENT '备注：创建判断题正确答案时间',
  `tfnganswer_ext1` int(11) DEFAULT NULL,
  `tfnganswer_ext2` varchar(225) DEFAULT NULL,
  `tfnganswer_last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '备注：修改判断题正确答案时间',
  `tfnganswer_tfng_id` int(10) unsigned NOT NULL COMMENT '备注：判断题主键',
  PRIMARY KEY (`tfnganswer_id`),
  KEY `FKho3xom344ukw7h5n8h9iom87y` (`tfnganswer_tfng_id`),
  CONSTRAINT `FKho3xom344ukw7h5n8h9iom87y` FOREIGN KEY (`tfnganswer_tfng_id`) REFERENCES `tfngtb` (`tfng_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `tfnganswertb` */

insert  into `tfnganswertb`(`tfnganswer_id`,`tfnganswer_answer`,`tfnganswer_create_date_time`,`tfnganswer_ext1`,`tfnganswer_ext2`,`tfnganswer_last_update_time`,`tfnganswer_tfng_id`) values (1,0,'2018-12-27 20:33:27',NULL,NULL,'2018-12-27 20:33:27',1),(2,0,'2018-12-28 15:27:13',NULL,NULL,'2018-12-28 15:27:13',2),(3,0,'2018-12-28 15:27:30',NULL,NULL,'2018-12-28 15:27:30',3),(4,0,'2018-12-28 15:27:38',NULL,NULL,'2018-12-28 15:27:38',4),(5,1,'2018-12-28 15:27:42',NULL,NULL,'2018-12-28 15:27:42',5),(6,0,'2018-12-28 15:28:18',NULL,NULL,'2018-12-28 15:28:18',6),(7,1,'2018-12-28 15:28:24',NULL,NULL,'2018-12-28 15:28:24',7);

/*Table structure for table `tfngtb` */

DROP TABLE IF EXISTS `tfngtb`;

CREATE TABLE `tfngtb` (
  `tfng_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注：判断题主键',
  `tfng_chapter_id` int(10) unsigned DEFAULT NULL COMMENT '备注：章节章节',
  `tfng_course_id` int(10) unsigned DEFAULT NULL COMMENT '备注：课程外键',
  `tfng_create_date_time` datetime DEFAULT NULL COMMENT '备注：判断题构成时间',
  `tfng_ext1` int(11) DEFAULT NULL,
  `tfng_ext2` varchar(225) DEFAULT NULL,
  `tfng_imgurl` varchar(225) DEFAULT NULL COMMENT '备注：判断题图片',
  `tfng_last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '备注：判断题修改时间',
  `tfng_question` varchar(225) NOT NULL COMMENT '备注：判断题问题',
  `tfng_score` int(10) unsigned NOT NULL COMMENT '备注：每道判断题分数',
  PRIMARY KEY (`tfng_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `tfngtb` */

insert  into `tfngtb`(`tfng_id`,`tfng_chapter_id`,`tfng_course_id`,`tfng_create_date_time`,`tfng_ext1`,`tfng_ext2`,`tfng_imgurl`,`tfng_last_update_time`,`tfng_question`,`tfng_score`) values (1,1,1,'2018-12-27 20:33:27',NULL,NULL,NULL,'2018-12-28 15:49:37','panduanti',2),(2,1,1,'2018-12-28 15:27:13',NULL,NULL,NULL,'2018-12-28 15:49:34','asdasd',3),(3,1,1,'2018-12-28 15:27:30',NULL,NULL,NULL,'2018-12-28 15:49:33','uiytuert',3),(4,1,1,'2018-12-28 15:27:38',NULL,NULL,NULL,'2018-12-28 15:49:32','zhengque',3),(5,1,1,'2018-12-28 15:27:42',NULL,NULL,NULL,'2018-12-28 15:49:30','cuowu',3),(6,1,1,'2018-12-28 15:28:18',NULL,NULL,NULL,'2018-12-28 15:28:18','zhengque',1),(7,1,1,'2018-12-28 15:28:24',NULL,NULL,NULL,'2018-12-28 15:28:24','cuowu',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
