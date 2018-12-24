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
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

/*Data for the table `choicequestionanswertb` */

insert  into `choicequestionanswertb`(`choicequestionanswer_id`,`choicequestionanswer_answer`,`choicequestionanswer_create_date_time`,`choicequestionanswer_ext1`,`choicequestionanswer_ext2`,`choicequestionanswer_last_update_time`,`choicequestionanswer_choicequestion_id`) values (1,'C:谷歌','2018-12-06 16:09:56',NULL,NULL,'2018-12-13 18:25:09',1),(2,'C：互联网','2018-12-06 16:12:28',NULL,NULL,'2018-12-13 18:25:17',2),(3,'C：研究科学家','2018-12-06 16:14:49',NULL,NULL,'2018-12-13 18:25:25',3),(4,'D：颗粒度','2018-12-06 16:16:55',NULL,NULL,'2018-12-13 18:25:57',4),(5,'D：重复数据记录处理','2018-12-06 16:19:52',NULL,NULL,'2018-12-13 18:26:06',5),(6,'A：深度优先遍历策略','2018-12-06 16:21:58',NULL,NULL,'2018-12-13 18:26:18',6),(7,'B：广度优先遍历策略 ','2018-12-06 16:21:58',NULL,NULL,'2018-12-13 18:26:26',6),(8,'A：数据从产生到被删除销毁的过程中，具有','2018-12-06 16:24:14',NULL,NULL,'2018-12-13 18:26:37',7),(9,'B：在不同的数据存在阶段，数据的价值是不','2018-12-06 16:24:14',NULL,NULL,'2018-12-13 18:26:45',7),(10,'C：根据数据价值的不同应该对数据采取不同','2018-12-06 16:24:14',NULL,NULL,'2018-12-13 18:26:54',7),(11,'A：挖掘数据的潜在价值','2018-12-06 16:26:39',NULL,NULL,'2018-12-13 18:27:06',8),(12,'B：实现数据重组的创新价值','2018-12-06 16:26:39',NULL,NULL,'2018-12-13 18:27:12',8),(13,'C：利用数据可扩展性拓宽业务领域','2018-12-06 16:26:39',NULL,NULL,'2018-12-13 18:27:21',8),(14,'D：无线上网卡和无线网卡连接都是一样的','2018-12-06 16:30:24',NULL,NULL,'2018-12-13 18:27:34',9),(15,'A：202.194.28.0 ','2018-12-06 16:32:17',NULL,NULL,'2018-12-13 18:27:49',10),(16,'A、月出','2018-12-22 20:03:50',NULL,NULL,'2018-12-22 20:03:50',13),(17,'A、月出','2018-12-22 20:04:24',NULL,NULL,'2018-12-22 20:04:24',14),(18,'B、日出','2018-12-22 20:04:24',NULL,NULL,'2018-12-22 20:04:24',14),(19,'A、123','2018-12-22 20:07:24',NULL,NULL,'2018-12-22 20:07:24',15),(20,'D、asdasd','2018-12-22 20:07:46',NULL,NULL,'2018-12-22 20:07:46',16),(21,'C、哦','2018-12-22 20:16:56',NULL,NULL,'2018-12-22 20:16:56',17),(22,'C、哦','2018-12-22 20:17:12',NULL,NULL,'2018-12-22 20:17:12',18),(23,'B、哈','2018-12-22 20:19:28',NULL,NULL,'2018-12-22 20:19:28',19),(24,'C、哦','2018-12-22 20:19:28',NULL,NULL,'2018-12-22 20:19:28',19),(25,'A、123','2018-12-23 20:12:43',NULL,NULL,'2018-12-23 20:12:43',20),(26,'B、123','2018-12-23 20:12:43',NULL,NULL,'2018-12-23 20:12:43',20),(27,'D、123','2018-12-23 20:12:43',NULL,NULL,'2018-12-23 20:12:43',20),(28,'C、asd','2018-12-23 20:41:46',NULL,NULL,'2018-12-23 20:41:46',21);

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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `choicequestiontb` */

insert  into `choicequestiontb`(`choicequestion_id`,`choicequestion_chapter_id`,`choicequestion_course_id`,`choicequestion_create_date_time`,`choicequestion_ext1`,`choicequestion_ext2`,`choicequestion_imgurl`,`choicequestion_last_update_time`,`choicequestion_question`,`choicequestion_score`,`choicequestiontb_issingleselection`) values (1,1,1,'2018-12-06 16:06:01',NULL,NULL,NULL,'2018-12-19 18:10:01','当前大数据技术的基础是由（ ）首先提出的',2,1),(2,1,1,'2018-12-06 16:11:05',NULL,NULL,NULL,'2018-12-20 17:27:02','大数据的起源是（ ）',2,1),(3,1,1,'2018-12-06 16:13:10',NULL,NULL,NULL,'2018-12-14 16:49:21','根据不同的业务需求来建立数据模型，抽取最有意义的向量，决定选取哪种方法的数据分析 角色人员是（ ）',2,0),(4,1,1,'2018-12-06 16:15:31',NULL,NULL,NULL,'2018-12-14 16:49:22','（ ）反映数据的精细化程度，越细化的数据，价值越高',2,0),(5,1,1,'2018-12-06 16:17:38',NULL,NULL,NULL,'2018-12-19 18:06:45','数据清洗的方法不包括（ ）',2,0),(6,2,1,'2018-12-06 16:20:22',NULL,NULL,NULL,'2018-12-14 16:49:24','在网络爬虫的爬行策略中，应用最为基础的是（ ）',3,1),(7,2,1,'2018-12-06 16:22:46',NULL,NULL,NULL,'2018-12-14 16:49:24','下列关于数据生命周期管理的核心认识中，正确的是（）',3,1),(8,2,1,'2018-12-06 16:24:59',NULL,NULL,NULL,'2018-12-14 16:49:26','数据再利用的意义在于（ ）',3,1),(9,2,1,'2018-12-06 16:28:00',NULL,NULL,NULL,'2018-12-14 16:49:26','将计算机连接到互联网，下列说法错误的是（ ）',2,0),(10,2,1,'2018-12-06 16:30:36',NULL,NULL,NULL,'2018-12-14 16:49:27','以下IP地址中为C类网络地址的是（ ）',2,0),(11,1,2,'2018-12-22 19:58:43',NULL,NULL,NULL,'2018-12-22 19:58:43','题目',2,0),(12,1,2,'2018-12-22 20:00:08',NULL,NULL,NULL,'2018-12-22 20:00:08','123123',1,1),(13,1,2,'2018-12-22 20:03:50',NULL,NULL,NULL,'2018-12-22 20:03:50','转身回望谁在吟唱,这首歌曲出自？',5,0),(14,1,2,'2018-12-22 20:04:24',NULL,NULL,NULL,'2018-12-22 20:04:24','转身回望谁在吟唱,这首歌曲出自？',5,1),(15,1,2,'2018-12-22 20:07:24',NULL,NULL,NULL,'2018-12-22 20:07:24','123123123',2,0),(16,1,2,'2018-12-22 20:07:46',NULL,NULL,NULL,'2018-12-22 20:07:46','asdasd',1,0),(17,1,2,'2018-12-22 20:16:56',NULL,NULL,NULL,'2018-12-22 20:16:56','啊啊啊啊啊啊啊',2,0),(18,1,2,'2018-12-22 20:17:12',NULL,NULL,NULL,'2018-12-22 20:17:12','啊啊啊啊啊啊啊',2,0),(19,1,2,'2018-12-22 20:19:28',NULL,NULL,NULL,'2018-12-22 20:19:28','啊啊啊啊啊啊啊',2,1),(20,1,2,'2018-12-23 20:12:43',NULL,NULL,NULL,'2018-12-23 20:12:43','123',2,1),(21,5,6,'2018-12-23 20:41:46',NULL,NULL,NULL,'2018-12-23 20:41:46','asd',1,0);

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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `gapfillinganswertb` */

insert  into `gapfillinganswertb`(`gapfillinganswer_id`,`gapfillinganswer_answer`,`gapfillinganswer_create_date_time`,`gapfillinganswer_ext1`,`gapfillinganswer_ext2`,`gapfillinganswer_last_update_time`,`gapfillinganswer_gapfilling_id`) values (1,'掌故','2018-12-06 16:47:42',NULL,NULL,'2018-12-13 09:29:33',1),(2,'日本','2018-12-06 16:48:38',NULL,NULL,'2018-12-13 09:29:26',2),(3,'周恩来','2018-12-06 16:49:31',NULL,NULL,'2018-12-13 09:29:25',3),(4,'孙中山','2018-12-06 16:50:25',NULL,NULL,'2018-12-13 09:29:16',4),(5,'托克维尔','2018-12-06 16:51:28',NULL,NULL,'2018-12-13 09:29:15',5),(6,'北岛','2018-12-06 16:52:43',NULL,NULL,'2018-12-13 09:29:11',6),(7,'瞿秋白','2018-12-06 16:53:31',NULL,NULL,'2018-12-13 09:29:04',7),(8,'《冬》','2018-12-06 16:54:10',NULL,NULL,'2018-12-13 09:29:00',8),(9,'梁漱溟','2018-12-06 16:55:05',NULL,NULL,'2018-12-13 09:28:56',9),(10,'独立与自由','2018-12-06 16:55:52',NULL,NULL,'2018-12-13 09:28:52',10),(11,'I am fine!','2018-12-14 09:35:46',NULL,NULL,'2018-12-14 10:29:39',11),(12,'很好,谢谢关心http://localhost:3060/YangYiChen//choiceQuestion/updateChoiceQuestion?optionId=11','2018-12-14 17:54:53',NULL,NULL,'2018-12-14 17:54:53',12),(13,'asd','2018-12-22 18:45:30',NULL,NULL,'2018-12-22 18:45:31',14),(14,'asd','2018-12-22 18:45:59',NULL,NULL,'2018-12-22 18:45:59',15),(15,'君','2018-12-22 18:47:00',NULL,NULL,'2018-12-22 18:47:00',16),(16,'丹青留下明日的黄花','2018-12-22 18:57:28',NULL,NULL,'2018-12-22 18:57:28',17),(17,'世代传承的表达','2018-12-22 18:57:58',NULL,NULL,'2018-12-22 18:57:58',18);

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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `gapfillingtb` */

insert  into `gapfillingtb`(`gapfilling_id`,`gapfilling_chapter_id`,`gapfilling_course_id`,`gapfilling_create_date_time`,`gapfilling_ext1`,`gapfilling_ext2`,`gapfilling_imgurl`,`gapfilling_last_update_time`,`gapfilling_question`,`gapfilling_score`) values (1,1,1,'2018-12-06 16:47:11',NULL,NULL,NULL,'2018-12-14 16:50:05','王元化《李鸿章办外交》一文的体裁是（）?',2),(2,1,1,'2018-12-06 16:48:18',NULL,NULL,NULL,'2018-12-14 16:50:06','晚清时期德国宰相俾斯麦曾作出论断，将来会在亚洲崛起的国家是（）?',2),(3,1,1,'2018-12-06 16:49:10',NULL,NULL,NULL,'2018-12-14 16:50:07','1954年，（）率领中国代表团出席日内瓦会议?',2),(4,1,1,'2018-12-06 16:50:02',NULL,NULL,NULL,'2018-12-14 16:50:08','《民报发刊词》的作者是（）?',2),(5,1,1,'2018-12-06 16:51:07',NULL,NULL,NULL,'2018-12-14 16:50:08','《美国的民主》一书的作者是（）?',3),(6,1,1,'2018-12-06 16:52:03',NULL,NULL,NULL,'2018-12-14 16:50:09','《回答》一诗被认为是“喊出了80年代人的心声”，其作者是（）?',3),(7,2,1,'2018-12-06 16:53:10',NULL,NULL,NULL,'2018-12-14 16:50:10','《多余的话》是（）的遗书?',2),(8,2,1,'2018-12-06 16:53:54',NULL,NULL,NULL,'2018-12-14 16:50:11','著名诗人穆旦的代表诗作是（）?',2),(9,2,1,'2018-12-06 16:54:46',NULL,NULL,NULL,'2018-12-14 16:50:12','知识分子自杀是一种独特的文化现象，（）不具备这一文化意义?',2),(10,2,1,'2018-12-06 16:55:33',NULL,NULL,NULL,'2018-12-14 16:50:13','陈寅恪认为王国维最伟大的精神是（），这种精神具有永恒的意义?',2),(11,2,1,'2018-12-14 09:35:46',NULL,NULL,'1.pfg','2018-12-14 16:50:14','How are you?',5),(12,3,2,'2018-12-14 17:54:53',NULL,NULL,NULL,'2018-12-14 18:23:23','你好吗?',5),(14,3,4,'2018-12-22 18:45:30',NULL,NULL,NULL,'2018-12-22 18:45:30','asdasd',2),(15,1,2,'2018-12-22 18:45:59',NULL,NULL,NULL,'2018-12-22 18:45:59','asdasdasd',2),(16,1,2,'2018-12-22 18:47:00',NULL,NULL,NULL,'2018-12-22 18:47:00','醉卧沙场（）莫笑',2),(17,1,2,'2018-12-22 18:57:28',NULL,NULL,NULL,'2018-12-22 18:57:28','风雨打尽红墙和绿瓦',1),(18,1,2,'2018-12-22 18:57:58',NULL,NULL,NULL,'2018-12-22 18:57:58','汉字里墨香温存的一笔一划',2);

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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `optiontb` */

insert  into `optiontb`(`option_id`,`optiona`,`optionb`,`optionc`,`option_create_date_time`,`optiond`,`option_ext1`,`option_ext2`,`option_last_update_time`,`option_choicequestion_id`) values (1,'A：微软','B：百度','C:谷歌','2018-12-06 16:08:21','D:阿里巴巴',NULL,NULL,'2018-12-06 16:08:39',1),(2,'A：金融','B：电信','C：互联网','2018-12-06 16:12:05','D:公共管理',NULL,NULL,'2018-12-06 16:12:13',2),(3,'A：数据管理人员','B：数据分析员','C：研究科学家','2018-12-06 16:14:23','D：软件开发工程师',NULL,NULL,'2018-12-06 16:14:31',3),(4,'A：规模','B：活性','C：关联度','2018-12-06 16:16:31','D：颗粒度',NULL,NULL,'2018-12-06 16:16:39',4),(5,'A：缺失值处理','B：噪声数据清除','C：一致性检查 ','2018-12-06 16:18:29','D：重复数据记录处理',NULL,NULL,'2018-12-06 16:18:50',5),(6,'A：深度优先遍历策略','B：广度优先遍历策略 ','C：高度优先遍历策略','2018-12-06 16:21:14','D：反向链接策略',NULL,NULL,'2018-12-06 16:21:26',6),(7,'A：数据从产生到被删除销毁的过程中，具有','B：在不同的数据存在阶段，数据的价值是不','C：根据数据价值的不同应该对数据采取不同','2018-12-06 16:23:47','D：数据生命周期管理旨在产生效益的同时，',NULL,NULL,'2018-12-06 16:24:00',7),(8,'A：挖掘数据的潜在价值','B：实现数据重组的创新价值','C：利用数据可扩展性拓宽业务领域','2018-12-06 16:26:12','D：优化存储设备，降低设备成本',NULL,NULL,'2018-12-06 16:26:20',8),(9,'A：可分为局域网连接和广域网连接两大类','B：网卡和无线网卡都属于局域网连接，只是','C：Modem属于广域网连接','2018-12-06 16:29:41','D：无线上网卡和无线网卡连接都是一样的',NULL,NULL,'2018-12-06 16:29:48',9),(10,'A：202.194.28.0 ','B：136.252.177.28','C：231.250.1.27 ','2018-12-06 16:31:50','D：108.29.255.255',NULL,NULL,'2018-12-06 16:32:00',10),(11,'A、xuanxianga','B、xuanxiangb','C、xuangxiangc','2018-12-22 19:58:43','D、xuangxuangd',NULL,NULL,'2018-12-22 19:58:43',11),(12,'A、123123','B、123','C、123','2018-12-22 20:00:08','D、123',NULL,NULL,'2018-12-22 20:00:08',12),(13,'A、月出','B、日出','C、东出','2018-12-22 20:03:50','D、北出',NULL,NULL,'2018-12-22 20:03:50',13),(14,'A、月出','B、日出','C、东出','2018-12-22 20:04:24','D、北出',NULL,NULL,'2018-12-22 20:04:24',14),(15,'A、123','B、123','C、123123','2018-12-22 20:07:24','D、123',NULL,NULL,'2018-12-22 20:07:24',15),(16,'A、asd','B、asd','C、asdasdasd','2018-12-22 20:07:46','D、asdasd',NULL,NULL,'2018-12-22 20:07:46',16),(17,'A、啊','B、哈','C、哦','2018-12-22 20:16:56','D、饿',NULL,NULL,'2018-12-22 20:16:56',17),(18,'A、啊','B、哈','C、哦','2018-12-22 20:17:12','D、饿',NULL,NULL,'2018-12-22 20:17:12',18),(19,'A、啊','B、哈','C、哦','2018-12-22 20:19:28','D、饿',NULL,NULL,'2018-12-22 20:19:28',19),(20,'A、123','B、123','C、123123','2018-12-23 20:12:43','D、123',NULL,NULL,'2018-12-23 20:12:43',20),(21,'A、asd','B、asd','C、asd','2018-12-23 20:41:46','D、asd',NULL,NULL,'2018-12-23 20:41:46',21);

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `studenttestrecordtb` */

insert  into `studenttestrecordtb`(`studenttestrecord_id`,`studenttestrecord_answers`,`studenttestrecord_chapter_id`,`studenttestrecord_course_id`,`studenttestrecord_create_date_time`,`studenttestrecord_ext1`,`studenttestrecord_ext2`,`studenttestrecord_last_update_time`,`studenttestrecord_questions`,`studenttestrecord_student_id`,`studenttestrecord_studenttest_id`) values (1,'C:谷歌',1,1,'2018-12-16 13:29:21',NULL,NULL,'2018-12-16 13:29:21','大数据的起源是()?',1,1);

/*Table structure for table `studenttesttb` */

DROP TABLE IF EXISTS `studenttesttb`;

CREATE TABLE `studenttesttb` (
  `studenttest_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '备注：学生测试主键',
  `studenttest_chapter_id` int(10) unsigned DEFAULT NULL COMMENT '备注：章节外键',
  `studenttest_create_date_time` datetime NOT NULL COMMENT '备注：创建该表测试时间',
  `studenttest_deadline_time` datetime NOT NULL COMMENT '备注：学生测试截止时间',
  `studenttest_ext1` int(11) DEFAULT NULL,
  `studenttest_ext2` varchar(225) DEFAULT NULL,
  `studenttest_last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '备注：修改该表测试时间',
  `studenttest_number` int(10) unsigned DEFAULT '0' COMMENT '备注：学生已经测试的次数',
  `studenttest_score` int(10) unsigned NOT NULL COMMENT '备注：学生测试分数',
  `studenttest_student_id` int(10) unsigned DEFAULT NULL COMMENT '备注：学生外键',
  PRIMARY KEY (`studenttest_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `studenttesttb` */

insert  into `studenttesttb`(`studenttest_id`,`studenttest_chapter_id`,`studenttest_create_date_time`,`studenttest_deadline_time`,`studenttest_ext1`,`studenttest_ext2`,`studenttest_last_update_time`,`studenttest_number`,`studenttest_score`,`studenttest_student_id`) values (1,1,'2018-12-16 10:24:48','2018-12-31 12:12:12',NULL,NULL,'2018-12-16 10:24:48',1,80,1);

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
  PRIMARY KEY (`teachercreatetest_id`),
  KEY `FK_teachercreatetesttb` (`teachercreatetest_chapter_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `teachercreatetesttb` */

insert  into `teachercreatetesttb`(`teachercreatetest_id`,`teachercratetest_choicenum`,`teachercratetest_gapfillingnum`,`teachercratetest_random`,`teachercratetest_state`,`teachercratetest_testname`,`teachercratetest_tfngnum`,`teachercreatetest_chapter_id`,`teachercreatetest_endtime`,`teachercreatetest_explain`,`teachercreatetest_ext1`,`teachercreatetest_ext2`,`teachercreatetest_number`,`teachercreatetest_teacher_id`,`teachercreatetest_testtime`) values (6,15,14,'是',0,'vue测试',14,2,'2018-12-23 20:12:06','测试说明',NULL,NULL,2,1,'0'),(7,0,0,'是',0,'asdasda',0,3,'2018-12-23 20:32:52','dasdas',NULL,NULL,1,4,'0'),(8,0,0,'是',0,'asdasd',0,1,'2018-12-23 20:33:33','asd',NULL,NULL,1,1,'0'),(10,1,0,'是',0,'a',0,5,'2018-12-01 00:00:00','a',NULL,NULL,1,1,'0'),(11,0,0,'是',0,'啊实打实多',0,1,'2018-12-29 00:00:00','啊实打实',NULL,NULL,1,1,'0');

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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `tfnganswertb` */

insert  into `tfnganswertb`(`tfnganswer_id`,`tfnganswer_answer`,`tfnganswer_create_date_time`,`tfnganswer_ext1`,`tfnganswer_ext2`,`tfnganswer_last_update_time`,`tfnganswer_tfng_id`) values (1,1,'2018-12-06 16:35:48',NULL,NULL,'2018-12-13 09:34:27',1),(2,0,'2018-12-06 16:36:53',NULL,NULL,'2018-12-13 09:34:25',2),(3,0,'2018-12-06 16:37:50',NULL,NULL,'2018-12-13 09:34:18',3),(4,0,'2018-12-06 16:38:36',NULL,NULL,'2018-12-13 09:34:16',4),(5,1,'2018-12-06 16:39:18',NULL,NULL,'2018-12-13 09:34:12',5),(6,1,'2018-12-06 16:40:13',NULL,NULL,'2018-12-13 09:34:09',6),(7,1,'2018-12-06 16:41:05',NULL,NULL,'2018-12-13 09:34:05',7),(8,0,'2018-12-06 16:41:42',NULL,NULL,'2018-12-13 09:34:00',8),(9,1,'2018-12-06 16:42:27',NULL,NULL,'2018-12-13 09:33:56',9),(10,0,'2018-12-06 16:43:06',NULL,NULL,'2018-12-13 09:33:52',10),(11,0,'2018-12-14 10:57:22',NULL,NULL,'2018-12-14 11:28:04',11),(12,1,'2018-12-21 17:46:08',NULL,NULL,'2018-12-21 17:46:08',12),(13,0,'2018-12-22 17:44:38',NULL,NULL,'2018-12-22 17:44:38',14),(14,1,'2018-12-22 17:46:11',NULL,NULL,'2018-12-22 17:46:11',15),(15,0,'2018-12-22 17:48:56',NULL,NULL,'2018-12-22 17:48:56',16),(16,0,'2018-12-22 17:51:33',NULL,NULL,'2018-12-22 17:51:33',17),(17,0,'2018-12-22 17:55:00',NULL,NULL,'2018-12-22 17:55:00',18),(18,0,'2018-12-22 18:21:24',NULL,NULL,'2018-12-22 18:21:24',19),(19,0,'2018-12-22 18:21:48',NULL,NULL,'2018-12-22 18:21:48',20);

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
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `tfngtb` */

insert  into `tfngtb`(`tfng_id`,`tfng_chapter_id`,`tfng_course_id`,`tfng_create_date_time`,`tfng_ext1`,`tfng_ext2`,`tfng_imgurl`,`tfng_last_update_time`,`tfng_question`,`tfng_score`) values (1,1,1,'2018-12-06 16:35:22',NULL,NULL,NULL,'2018-12-14 16:50:42','虚假提问能够增强说话的气势?',2),(2,1,1,'2018-12-06 16:36:35',NULL,NULL,NULL,'2018-12-14 16:50:43','演讲中主体置换的目的是改变听众的利益需求?',2),(3,1,1,'2018-12-06 16:37:34',NULL,NULL,NULL,'2018-12-14 16:50:44','在《水浒传》中，武松是一个被文学语言神化了的英雄形象?',2),(4,1,1,'2018-12-06 16:38:20',NULL,NULL,NULL,'2018-12-14 16:50:44','王小波故事里所讲述的内容是“现实主义”的，讲述故事的姿态却是“荒诞主义”的?',2),(5,1,1,'2018-12-06 16:39:00',NULL,NULL,NULL,'2018-12-14 16:50:45','一只特立独行的猪，就其语法意义而言，这是一句假话。就其修辞意义而言，这是一句真话?',2),(6,2,1,'2018-12-06 16:39:49',NULL,NULL,NULL,'2018-12-14 16:50:46','《一只特立独行的猪》，这部作品以“猪”作为主人公，既是自嘲，同时又是反讽?',2),(7,2,1,'2018-12-06 16:40:52',NULL,NULL,NULL,'2018-12-14 16:50:47','中国当代著名作家汪曾祺亦精于戏剧，是京派作家的代表人物?',2),(8,2,1,'2018-12-06 16:41:28',NULL,NULL,NULL,'2018-12-14 16:50:48','汪曾祺组织的演出的第一部戏剧是《沙家浜》，这也是他在戏剧界的成名作?',2),(9,2,1,'2018-12-06 16:42:13',NULL,NULL,NULL,'2018-12-14 16:50:49','“扪虱而谈”在古代属于一件比较雅致的事情?',2),(10,2,1,'2018-12-06 16:42:50',NULL,NULL,NULL,'2018-12-14 16:50:49','金岳霖对林徽因的爱是光明磊落的，林徽因曾数次深受感动?',2),(11,2,1,'2018-12-14 10:57:22',NULL,NULL,NULL,'2018-12-14 16:50:51','天气晴朗',2),(12,3,2,'2018-12-21 17:46:08',NULL,NULL,NULL,'2018-12-21 17:46:08','天气晴朗',2),(13,3,4,'2018-12-22 17:33:31',NULL,NULL,NULL,'2018-12-22 17:33:31','asd',2),(14,1,2,'2018-12-22 17:44:38',NULL,NULL,NULL,'2018-12-22 17:44:38','aaaaaaaaaaa',1),(15,7,8,'2018-12-22 17:46:11',NULL,NULL,NULL,'2018-12-22 17:46:11','我想测试一下',6),(16,1,2,'2018-12-22 17:48:56',NULL,NULL,NULL,'2018-12-22 17:48:56','asdasd',1),(17,3,4,'2018-12-22 17:51:33',NULL,NULL,NULL,'2018-12-22 17:51:33','asdasd',2),(18,1,2,'2018-12-22 17:55:00',NULL,NULL,NULL,'2018-12-22 17:55:00','asd',2),(19,1,2,'2018-12-22 18:21:24',NULL,NULL,NULL,'2018-12-22 18:21:24','asdsadasd',3),(20,1,2,'2018-12-22 18:21:48',NULL,NULL,NULL,'2018-12-22 18:21:48','345345',2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
