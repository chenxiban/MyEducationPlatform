/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.19 : Database - wangpost
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`wangpost` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `wangpost`;

/*Table structure for table `tb_bar` */

DROP TABLE IF EXISTS `tb_bar`;

CREATE TABLE `tb_bar` (
  `bar_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '贴吧分类id',
  `bar_category` varchar(50) NOT NULL COMMENT '贴吧分类名',
  `bar_createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `bar_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次修改时间',
  PRIMARY KEY (`bar_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `tb_bar` */

insert  into `tb_bar`(`bar_id`,`bar_category`,`bar_createtime`,`bar_update_time`) values (1,'招人啦','2018-12-09 14:47:02','2018-12-11 20:04:24'),(2,'新手帮忙','2017-11-09 14:47:30','2018-12-09 14:51:01'),(3,'2017奖学金','2017-04-09 14:47:30','2018-12-09 14:51:09'),(4,'学识体系','2016-12-09 14:47:30','2018-12-09 14:51:15'),(5,'问题库','2018-12-09 14:47:30','2018-12-09 14:50:38'),(6,'优质回答','2018-12-09 14:47:30','2018-12-09 14:50:38'),(7,'课程推荐','2018-12-09 14:47:30','2018-12-09 14:50:39'),(8,'学习分享','2018-12-09 14:47:30','2018-12-09 14:50:40'),(9,'站内活动','2018-12-09 14:47:30','2018-12-09 14:50:41'),(10,'精选','2018-12-09 14:47:30','2018-12-09 14:50:44'),(12,'王哈','2018-12-09 14:47:30','2018-12-11 13:01:30'),(13,'新春晚会','2018-12-11 13:22:49','2018-12-11 13:22:49');

/*Table structure for table `tb_commitlike` */

DROP TABLE IF EXISTS `tb_commitlike`;

CREATE TABLE `tb_commitlike` (
  `commitlike_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '帖子评论点赞id',
  `commitlike_createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `commitlike_stuts` tinyint(3) unsigned DEFAULT '0' COMMENT '帖子评论点赞状态',
  `commitlike_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次修改时间',
  `user_id` int(11) NOT NULL COMMENT '帖子评论点赞id',
  `postcommit_id` int(10) unsigned NOT NULL COMMENT '帖子评论id',
  PRIMARY KEY (`commitlike_id`),
  KEY `FK16uytgjibjn1fx1kn8i33cmrj` (`postcommit_id`),
  CONSTRAINT `FK16uytgjibjn1fx1kn8i33cmrj` FOREIGN KEY (`postcommit_id`) REFERENCES `tb_postcommit` (`postcommit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

/*Data for the table `tb_commitlike` */

insert  into `tb_commitlike`(`commitlike_id`,`commitlike_createtime`,`commitlike_stuts`,`commitlike_update_time`,`user_id`,`postcommit_id`) values (1,'2018-12-09 15:13:29',1,'2018-12-09 15:13:39',1,1),(2,'2018-12-09 15:13:29',1,'2018-12-09 15:13:40',3,1),(3,'2018-12-09 15:13:29',2,'2018-12-09 15:13:43',4,1),(4,'2018-12-15 23:15:22',1,'2018-12-15 23:15:42',5,1),(5,'2018-12-15 23:15:22',1,'2018-12-15 23:15:42',6,1),(6,'2018-12-15 23:15:22',1,'2018-12-15 23:15:43',7,1),(7,'2018-12-15 23:15:22',1,'2018-12-15 23:15:43',8,1),(8,'2018-12-15 23:15:22',1,'2018-12-15 23:15:44',9,1),(9,'2018-12-15 23:15:22',1,'2018-12-15 23:15:44',10,1),(10,'2018-12-15 23:15:22',1,'2018-12-15 23:15:45',11,1),(11,'2018-12-15 23:15:22',2,'2018-12-15 23:15:46',12,1),(12,'2018-12-15 23:15:22',2,'2018-12-15 23:15:48',13,1),(13,'2018-12-15 23:15:22',1,'2018-12-15 23:15:46',14,1),(14,'2018-12-15 23:15:22',1,'2018-12-15 23:15:49',15,1),(15,'2018-12-15 23:15:22',1,'2018-12-15 23:15:49',17,1),(16,'2018-12-15 23:15:22',1,'2018-12-15 23:15:50',19,1),(17,'2018-12-15 23:15:22',1,'2018-12-15 23:15:51',20,1),(18,'2018-12-15 23:15:22',1,'2018-12-15 23:15:52',21,1),(19,'2018-12-15 23:15:22',1,'2018-12-15 23:15:53',22,1),(20,'2018-12-15 23:15:22',1,'2018-12-15 23:15:53',1,2),(21,'2018-12-15 23:15:22',1,'2018-12-15 23:15:56',2,2),(22,'2018-12-15 23:15:22',1,'2018-12-15 23:15:56',3,2),(23,'2018-12-15 23:15:22',1,'2018-12-15 23:15:57',4,2),(24,'2018-12-15 23:15:22',1,'2018-12-15 23:15:58',5,2),(25,'2018-12-15 23:15:22',1,'2018-12-15 23:15:59',6,2),(26,'2018-12-15 23:15:22',1,'2018-12-15 23:15:59',7,2),(27,'2018-12-15 23:15:22',1,'2018-12-15 23:16:00',8,2),(28,'2018-12-15 23:15:22',1,'2018-12-15 23:16:02',9,2),(29,'2018-12-15 23:15:22',1,'2018-12-15 23:16:03',10,2),(30,'2018-12-15 23:15:22',2,'2018-12-15 23:16:03',1,3),(31,'2018-12-15 23:15:22',2,'2018-12-15 23:16:06',1,4),(32,'2018-12-15 23:15:22',1,'2018-12-15 23:16:04',1,5),(33,'2018-12-15 23:15:22',1,'2018-12-15 23:16:07',1,6),(34,'2018-12-15 23:15:22',1,'2018-12-15 23:16:07',1,7),(35,'2018-12-15 23:15:22',1,'2018-12-15 23:16:12',1,8),(36,'2018-12-15 23:15:22',1,'2018-12-15 23:16:13',1,9),(37,'2018-12-15 23:15:22',1,'2018-12-15 23:16:13',1,10),(38,'2018-12-15 23:15:22',1,'2018-12-15 23:16:14',1,11),(39,'2018-12-15 23:15:22',1,'2018-12-15 23:16:15',1,12),(40,'2018-12-15 23:15:22',1,'2018-12-15 23:16:17',1,13),(41,'2018-12-15 23:15:22',1,'2018-12-15 23:16:15',1,14),(42,'2018-12-15 23:15:22',1,'2018-12-15 23:16:19',1,15),(43,'2018-12-15 23:15:22',1,'2018-12-15 23:16:20',1,16),(44,'2018-12-15 23:15:22',1,'2018-12-15 23:16:21',1,17),(45,'2018-12-15 23:15:22',1,'2018-12-15 23:16:21',1,18),(46,'2018-12-15 23:15:22',1,'2018-12-15 23:16:24',1,19);

/*Table structure for table `tb_commitreport` */

DROP TABLE IF EXISTS `tb_commitreport`;

CREATE TABLE `tb_commitreport` (
  `commitreport_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '评论举报id',
  `commitreport_content` varchar(100) NOT NULL COMMENT '评论举报内容',
  `commitreport_createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `commitreport_stuts` tinyint(3) unsigned DEFAULT '0' COMMENT '举报信息审核状态',
  `commitreport_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次修改时间',
  `user_id` int(11) NOT NULL COMMENT '评论举报人id',
  `postcommit_id` int(10) unsigned NOT NULL COMMENT '帖子评论id',
  PRIMARY KEY (`commitreport_id`),
  KEY `FKemu1woav724v7cghwcre6rtsp` (`postcommit_id`),
  CONSTRAINT `FKemu1woav724v7cghwcre6rtsp` FOREIGN KEY (`postcommit_id`) REFERENCES `tb_postcommit` (`postcommit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `tb_commitreport` */

insert  into `tb_commitreport`(`commitreport_id`,`commitreport_content`,`commitreport_createtime`,`commitreport_stuts`,`commitreport_update_time`,`user_id`,`postcommit_id`) values (1,'第一轮落选 不开心','2018-12-09 15:12:28',0,'2018-12-09 15:12:47',1,1),(2,'第一轮落选 不开心','2018-12-09 15:12:28',0,'2018-12-09 15:12:50',3,1),(3,'举报成功','2018-12-15 23:11:21',0,'2018-12-15 23:12:03',4,2),(4,'举报成功','2018-12-15 23:11:21',0,'2018-12-15 23:12:02',5,3),(5,'举报成功','2018-12-15 23:11:21',1,'2018-12-15 23:12:07',6,11);

/*Table structure for table `tb_post` */

DROP TABLE IF EXISTS `tb_post`;

CREATE TABLE `tb_post` (
  `post_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '帖子id',
  `post_content` varchar(2000) NOT NULL COMMENT '帖子内容',
  `post_createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `post_name` varchar(50) NOT NULL COMMENT '发帖人昵称',
  `post_report` tinyint(3) unsigned DEFAULT '0' COMMENT '是否举报成功',
  `post_title` varchar(100) NOT NULL COMMENT '帖子标题',
  `post_top` tinyint(3) unsigned DEFAULT '0' COMMENT '是否置顶',
  `post_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次修改时间',
  `user_id` int(11) NOT NULL COMMENT '发帖人id',
  `user_touurl` varchar(200) DEFAULT NULL COMMENT '用户头像路经',
  `bar_id` int(10) unsigned NOT NULL COMMENT '贴吧分类id',
  PRIMARY KEY (`post_id`),
  KEY `FK66gk9urqgn1sae6fedgb123n0` (`bar_id`),
  CONSTRAINT `FK66gk9urqgn1sae6fedgb123n0` FOREIGN KEY (`bar_id`) REFERENCES `tb_bar` (`bar_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

/*Data for the table `tb_post` */

insert  into `tb_post`(`post_id`,`post_content`,`post_createtime`,`post_name`,`post_report`,`post_title`,`post_top`,`post_update_time`,`user_id`,`user_touurl`,`bar_id`) values (1,'请问有谁知道题库什么的吗？ 看视频学习感觉有点慌，记不住，好多东西，总觉得不如纸质资料来的舒坦，求资源','2018-12-09 14:53:14','雨中画',0,'问题',1,'2018-12-12 15:02:30',1,NULL,2),(2,'在网络中通常把提供服务的计算机称为服务器，把请求服务的计算机称为？','2018-12-09 14:53:14','王哈哈',0,'精选',0,'2018-12-12 15:03:24',3,NULL,5),(3,'如何比马云有钱','2018-12-15 21:54:29','王哈哈',0,'马云',0,'2018-12-15 22:01:11',3,NULL,1),(4,'慕课这玩意真好,什么都能看','2018-12-15 21:54:29','画中画',0,'慕课',0,'2018-12-15 22:01:12',1,NULL,3),(5,'有人问我“你理想的工作是什么？”','2018-12-15 21:54:29','我蜗',0,'你坚持的意义是什么？',0,'2018-12-15 22:02:07',5,NULL,4),(6,'现在已经进入十月份了，对于一些学校的某些专业的学生来说，他们已经开始面临着离开校园，进入社会。但是对于初入职场的人来说，是应该先就业，找一份稳定的工作，积蓄一些资金再择业呢？还是应该先择业，根据自己的喜好去选择自己所喜爱的工作，甚至于选择与自己所学专业完全没有关系的职业再就业呢？','2018-12-15 22:03:27','这是我昵称',0,'先就业还是先择业',0,'2018-12-15 22:04:39',6,NULL,6),(7,' 大家是喜欢读电子书还是纸质书啊？为什么呢？','2018-12-15 22:03:27','今天你看慕课了吗',0,'你喜欢电子书还是纸质书？',0,'2018-12-15 22:04:42',7,NULL,7),(8,'我现在还是一名大学在校生，我所在的学校是一个二本的普通院校。在来大学之前我是非常憧憬大学的生活的，来了一段时间之后这种感觉真是一点都不剩呀！根本感受不到学习的氛围，感觉同学们除了上课就是睡觉，我不喜欢睡懒觉，虽然有些吃力，但是我时时刻刻提醒自己一定要反抗这种氛围，不要变得和他们一样。大家也来谈谈自己大学时期遇到的问题吧。','2018-12-15 22:05:30','箱子v1',0,'大学里应该怎么合理的利用自己的时间 ',0,'2018-12-15 22:05:38',8,NULL,8),(9,'慕课君友情提醒，你的假期余额已不足~','2018-12-15 22:05:38','箱子v1',0,'讨论向：你都如何向亲戚介绍你的专业？ ',0,'2018-12-15 22:23:53',1,NULL,1),(10,'  鄙人才疏学浅，说的不对的地方还请批评指正。先说说我认为的一些上班族和学生党参加线上学习的动机，并阐述线上与线下教育相比存在的缺点：','2018-12-15 22:05:38','雨中画',0,'论线上与线下教育学习的优缺点',0,'2018-12-15 22:23:55',1,NULL,1),(11,'  这几天在讨论区转悠的时候，发现有不少同学都发了和雾霾有关的帖子。遂想起最近不少大学同学跟我打电话说帝都的环境污染太恶劣，待不下去了。而我作为一个天天跟着经济、金融数据屁股后面跑的人，知不知道国内哪有空气好、经济水平发展不错、教育资源发达、医疗娱乐设施比较健全的地方，给他们推荐一下。我也知道，不仅是环境污染所造成的生活不适让他们宁愿放弃帝都那些部级单位或500强中国区总部之类的高薪和福利，转而去二三线城市发展，食品安全问题、高房价、交通拥堵、看病难、教育资源分配不均、就业难等等这些部分地方zf对城镇化的盲目推进所造成的城市病其实也是推手。就着我最近写毕设的时候谈到了这一点，我也谈谈我对城市病的一些认知。','2018-12-15 22:05:38','王哈哈',0,'聊一聊身边的城市病 ',0,'2018-12-15 22:24:00',3,NULL,1),(12,'没有拿到优秀，略微有些伤心。','2018-12-15 22:05:38','我爱学习',0,'《中国饮食文化》笔记 ',0,'2018-12-15 22:24:02',4,NULL,1),(13,'   一、晒证书','2018-12-15 22:05:38','我蜗',0,'【晒证书】慕课阴晴圆缺（附心得与建议）',0,'2018-12-15 22:24:04',5,NULL,1),(14,'曾有两个同事A和B，来自同一所大学，同届同系。在一个单位，这算挺近的关系了，按说该结为死党才是，然而他们并没有。因为A骨子里有点瞧不上B。','2018-12-15 22:05:38','这是我昵称',0,'决定你前途的，不是你的起点…… ',0,'2018-12-15 22:24:06',6,NULL,1),(15,'“教师教学能力提升MOOC慕课项目“始于2015年四年来，已陆续建设并推出“翻转课堂教学法”（北京大学）等30门课程，累计学习者超过108万人次，覆盖全国。为让广大教师更有效学习此次教师教学能力系列慕课，基于前期的实践经验，经全国顶尖教育教学专家规划特推出三大教师教学能力系列，力求列既有“骨架”，也有“血肉”。','2018-12-15 22:05:38','今天你看慕课了吗',0,'学习交流区—教师教学能力系列慕课  ',0,'2018-12-15 22:24:07',7,NULL,1),(16,'公民基本权利的现实性是指什么，应该怎么写','2018-12-15 22:05:38','箱子v1 ',0,'宪法论文',0,'2018-12-15 22:24:09',8,NULL,1),(17,'现在的微商可以理解为电子商务的应用吗？','2018-12-15 22:05:38','雨中画',0,'现在的微商可以理解为电子商务的应用吗？',0,'2018-12-15 22:24:12',1,NULL,1),(18,'为什么我的视频看完了，进度不是100%','2018-12-15 22:05:38','王哈哈',0,'我的疑惑之处 ',0,'2018-12-15 22:24:15',3,NULL,1),(19,'请问英语听力怎么样练习才最有效果？','2018-12-15 22:05:38','我爱学习',0,'英语听力的问题',0,'2018-12-15 22:24:17',4,NULL,1),(20,'我想知道在哪里看成绩','2018-12-15 22:05:38','我蜗',0,'成绩 ',0,'2018-12-15 22:24:18',5,NULL,2),(21,'唾液属于体液吗？ ','2018-12-15 22:05:38','这是我昵称',0,'唾液属于体液吗？ ',0,'2018-12-15 22:24:20',6,NULL,2),(22,'期末考试成绩在哪公布，，，有网址吗？？？？','2018-12-15 22:05:38','今天你看慕课了吗',0,'期末考试 ',0,'2018-12-15 22:24:24',7,NULL,2),(23,'中国大学MOOC平台外语学习者学习原因和策略调查','2018-12-15 22:05:38','箱子v1',0,'中国大学MOOC平台外语学习者学习原因和策略调查',0,'2018-12-15 22:24:26',8,NULL,3),(24,'我已经把14课时都听完了，为何还显示只学了7课时？','2018-12-15 22:05:38','雨中画',0,'我已经把14课时都听完了，为何还显示只学了7课时？',0,'2018-12-15 22:24:28',1,NULL,4),(25,'1.练习口语   ','2018-12-15 22:05:38','这是我昵称',0,'五个值得推荐的英语学习网站，不可错过哦！ ',0,'2018-12-15 22:24:29',6,NULL,6),(27,'胸式呼吸～参与肌肉：以膈肌、胸大肌、胸小肌、前锯肌、肋间外肌、肋间内肌、肋间最内肌、胸横肌等为主，同时，构成胸腔的其它肌肉（包括背部肌肉等），协同参与。它是以肋骨和胸骨活动为主的呼吸运动。 二、腹式呼吸～参与肌肉：主要是腹肌和膈肌，其它构成腹腔的肌肉协同参与。它是以膈肌运动为主的呼吸运动。)','2018-12-15 22:05:38','今天你看慕课了吗',0,'苟富贵',0,'2018-12-15 22:24:31',7,NULL,10),(28,'十二指肠液引流术是用十二指肠引流管经口插入将十二指肠液及胆汁引流出体外的检查方法，可协助诊断胆囊、胆管的某些疾病，还能测定十二指肠液的胰酶，以了解胰腺功能。十二指肠引流本身对胆道系统感染也有治疗作用。请问：从解剖学角度来看，插入十二指肠引流管时需要注意哪些事项？譬如路径、插入深度和位置等。','2018-12-15 22:05:38','我蜗',0,'12 ',0,'2018-12-15 22:24:37',5,NULL,9);

/*Table structure for table `tb_postcommit` */

DROP TABLE IF EXISTS `tb_postcommit`;

CREATE TABLE `tb_postcommit` (
  `postcommit_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '帖子评论id',
  `postcommit_count` varchar(2000) NOT NULL COMMENT '评论内容',
  `postcommit_createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `postcommit_name` varchar(50) NOT NULL COMMENT '评论人昵称',
  `postcommit_report` tinyint(3) unsigned DEFAULT '0' COMMENT '是否举报成功',
  `postcommit_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次修改时间',
  `user_id` int(11) NOT NULL COMMENT '评论人id',
  `user_touurl` varchar(200) DEFAULT NULL COMMENT '用户头像路经',
  `post_id` int(10) unsigned NOT NULL COMMENT '帖子id',
  PRIMARY KEY (`postcommit_id`),
  KEY `FKcou380tc9rcu7tdx6b33lj86s` (`post_id`),
  CONSTRAINT `FKcou380tc9rcu7tdx6b33lj86s` FOREIGN KEY (`post_id`) REFERENCES `tb_post` (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `tb_postcommit` */

insert  into `tb_postcommit`(`postcommit_id`,`postcommit_count`,`postcommit_createtime`,`postcommit_name`,`postcommit_report`,`postcommit_update_time`,`user_id`,`user_touurl`,`post_id`) values (1,'手机App点击签到没反应怎么办！！！','2018-12-09 15:11:30','王哈哈',0,'2018-12-15 23:09:35',1,'txiang.png',1),(2,'qqqq','2018-12-15 23:01:05','雨中画',0,'2018-12-15 23:09:37',1,'txiang.png',2),(3,'线下教育虽然比较传统，但是更加有可靠性，但是线下教育种类较少，容易受到局限','2018-12-15 23:01:05','我爱学习',0,'2018-12-15 23:09:37',4,'txiang.png',1),(4,'线下教育虽然比较传统，但是更加有可靠性，但是线下教育种类较少，容易受到局限','2018-12-15 23:09:48','我蜗',0,'2018-12-15 23:10:13',5,'txiang.png',1),(5,'你知道吗？今年6月份6级考的就是这个作文题。','2018-12-15 23:09:48','这是我昵称',0,'2018-12-15 23:10:13',6,'txiang.png',1),(6,'我觉得线上的话只要有网各个阶层都能看。','2018-12-15 23:09:48','今天你看慕课了吗',0,'2018-12-15 23:10:15',7,'txiang.png',1),(7,'线下教育会给老师和学生提供一个面对面的机会交流，但随着现在中国式教育的普及，我觉得线上教育以后很有可能是种趋势。','2018-12-15 23:09:48','箱子v1',0,'2018-12-15 23:10:14',8,'txiang.png',1),(8,'雾霾那么大，我想对于中国的教育应该在不久的将来变成全民网上教育吧。 ','2018-12-15 23:09:48','今天你看慕课了吗',0,'2018-12-15 23:10:15',1,'txiang.png',1),(9,'不过线上教育长期如此的话对眼睛不好。','2018-12-15 23:09:48','这是我昵称',0,'2018-12-15 23:10:16',6,'txiang.png',1),(10,'赞同你说的。我之前说的那个，也是这个意思。我说的不够具体。如果平台愿意做，你说的这些弊端，大多数都可以完善。比如，抄袭严重，平台设置举报通道不难，甚至可以把多次抄袭的晒出来。比如代上课，也可以制止很多。如果作业抄袭制止了，代上课的也一定减少很多，因为代的难度加大了。','2018-12-15 23:09:48','我蜗',0,'2018-12-15 23:10:10',5,'txiang.png',1),(11,'有思想有内涵的楼主，把问题摆的清清楚楚。慕课是近几年才发展起来的在线学习平台，不足之处需要广大慕友在学习中不断提出，平台跟进改变，线上学习终会成为广大非在校生的主流学习方式。','2018-12-15 23:09:48','我爱学习',0,'2018-12-15 23:10:10',4,'txiang.png',1),(12,'我充分体验到了线下教育的弊端，通过实践和线上教育补充自己 ','2018-12-15 23:09:48','王哈哈',0,'2018-12-15 23:10:09',3,'txiang.png',1),(13,'我认为，线上新颖些，让学生第一感觉，唉？这样就可以学习了？但是，报名了课程，能不能坚持又是一问题。线下，拿大学来说，多少学生旷课。说教授就低着头讲，有问题问不到。自我感觉，都有利有弊，不能说是有一个能完全进行最优质的教育','2018-12-15 23:09:48','雨中画',0,'2018-12-15 23:10:08',1,'txiang.png',1),(14,'线上学习，线下考核。','2018-12-15 23:09:48','王哈哈',0,'2018-12-15 23:10:07',3,'txiang.png',3),(15,'线上有很多bug比如一楼说的，但我还是很喜欢线上！','2018-12-15 23:09:48','我爱学习',0,'2018-12-15 23:10:07',4,'txiang.png',4),(16,'复制二三贴：抄袭怎么能这样！','2018-12-15 23:09:48','我蜗',0,'2018-12-15 23:10:05',5,'txiang.png',5),(17,'在寻求进步的过程中，难免会泥沙俱下。','2018-12-15 23:09:48','这是我昵称',0,'2018-12-15 23:10:03',6,'txiang.png',6),(18,'线上线下本就各有利弊 我一直觉得二者该结合 线上线下内容相互存在逻辑关系 利用翻转课堂的理念 有效结合。线上主打知识传授 线下主打解疑答惑 ','2018-12-15 23:09:48','今天你看慕课了吗',0,'2018-12-15 23:10:06',7,'txiang.png',7),(19,'各有优劣所在','2018-12-15 23:09:48','箱子v1',0,'2018-12-15 23:10:03',8,'txiang.png',8);

/*Table structure for table `tb_postlike` */

DROP TABLE IF EXISTS `tb_postlike`;

CREATE TABLE `tb_postlike` (
  `postlike_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '帖子点赞id',
  `postlike_createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `postlike_stuts` tinyint(3) unsigned DEFAULT '0' COMMENT '点赞,反对,状态',
  `postlike_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次修改时间',
  `user_id` int(11) NOT NULL COMMENT '点/反的用户的id',
  `post_id` int(10) unsigned NOT NULL COMMENT '帖子id',
  PRIMARY KEY (`postlike_id`),
  KEY `FKi7lsk1cmw0qaw7wse92ngavdj` (`post_id`),
  CONSTRAINT `FKi7lsk1cmw0qaw7wse92ngavdj` FOREIGN KEY (`post_id`) REFERENCES `tb_post` (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8;

/*Data for the table `tb_postlike` */

insert  into `tb_postlike`(`postlike_id`,`postlike_createtime`,`postlike_stuts`,`postlike_update_time`,`user_id`,`post_id`) values (1,'2018-12-09 15:09:19',1,'2018-12-09 15:09:59',1,1),(2,'2018-12-09 15:09:19',1,'2018-12-09 15:09:59',1,2),(3,'2018-12-09 15:09:19',2,'2018-12-09 15:10:00',3,1),(4,'2018-12-09 15:09:19',2,'2018-12-09 15:10:04',4,2),(5,'2018-12-09 15:09:59',1,'2018-12-15 22:56:31',2,1),(6,'2018-12-09 15:09:59',1,'2018-12-15 22:56:31',3,1),(7,'2018-12-09 15:09:59',1,'2018-12-15 22:56:32',4,1),(8,'2018-12-09 15:09:59',1,'2018-12-15 22:56:33',5,1),(9,'2018-12-09 15:09:59',1,'2018-12-15 22:56:33',6,1),(10,'2018-12-09 15:09:59',1,'2018-12-15 22:56:34',7,1),(11,'2018-12-09 15:09:59',1,'2018-12-15 22:56:35',81,1),(12,'2018-12-09 15:09:59',1,'2018-12-15 22:56:37',12,1),(13,'2018-12-09 15:09:59',1,'2018-12-15 22:56:36',11,1),(14,'2018-12-09 15:09:59',1,'2018-12-15 22:56:38',13,1),(15,'2018-12-09 15:09:59',1,'2018-12-15 22:56:39',14,1),(16,'2018-12-09 15:09:59',1,'2018-12-15 22:56:41',15,1),(17,'2018-12-09 15:09:59',1,'2018-12-15 22:56:40',16,1),(18,'2018-12-09 15:09:59',1,'2018-12-15 22:56:43',17,1),(19,'2018-12-09 15:09:59',1,'2018-12-15 22:56:44',18,1),(20,'2018-12-09 15:09:59',1,'2018-12-15 22:56:44',19,1),(21,'2018-12-09 15:09:59',1,'2018-12-15 22:56:45',20,1),(22,'2018-12-09 15:09:59',1,'2018-12-15 22:56:46',21,1),(23,'2018-12-09 15:09:59',1,'2018-12-15 22:56:48',22,1),(24,'2018-12-09 15:09:59',1,'2018-12-15 22:56:47',23,1),(25,'2018-12-09 15:09:59',1,'2018-12-15 22:56:49',24,1),(26,'2018-12-09 15:09:59',1,'2018-12-15 22:56:49',25,1),(27,'2018-12-09 15:09:59',1,'2018-12-15 22:56:50',26,2),(28,'2018-12-09 15:09:59',1,'2018-12-15 22:56:51',27,1),(29,'2018-12-09 15:09:59',1,'2018-12-15 22:56:53',28,1),(30,'2018-12-09 15:09:59',2,'2018-12-15 22:56:52',29,1),(31,'2018-12-09 15:09:59',1,'2018-12-15 22:56:55',30,1),(32,'2018-12-09 15:09:59',1,'2018-12-15 22:56:57',1,2),(33,'2018-12-09 15:09:59',1,'2018-12-15 22:56:58',2,3),(34,'2018-12-09 15:09:59',2,'2018-12-15 22:56:59',3,4),(35,'2018-12-09 15:09:59',1,'2018-12-15 22:57:01',4,2),(36,'2018-12-09 15:09:59',1,'2018-12-15 22:57:00',5,1),(37,'2018-12-09 15:09:59',1,'2018-12-15 22:57:03',6,2),(38,'2018-12-09 15:09:59',1,'2018-12-15 22:57:04',7,2),(39,'2018-12-09 15:09:59',2,'2018-12-15 22:57:05',8,2),(40,'2018-12-09 15:09:59',2,'2018-12-15 22:57:05',9,2),(41,'2018-12-09 15:09:59',1,'2018-12-15 22:57:06',10,2),(42,'2018-12-09 15:09:59',1,'2018-12-15 22:57:07',11,2),(43,'2018-12-09 15:09:59',1,'2018-12-15 22:57:07',1,3),(44,'2018-12-09 15:09:59',1,'2018-12-15 22:57:08',2,3),(45,'2018-12-09 15:09:59',2,'2018-12-15 22:57:09',3,4),(46,'2018-12-09 15:09:59',2,'2018-12-15 22:57:10',1,5),(47,'2018-12-09 15:09:59',2,'2018-12-15 22:57:12',1,6),(48,'2018-12-09 15:09:59',1,'2018-12-15 22:57:11',1,7),(49,'2018-12-09 15:09:59',1,'2018-12-15 22:57:14',1,8),(50,'2018-12-09 15:09:59',1,'2018-12-15 22:57:18',1,9),(51,NULL,0,'2018-12-15 22:54:34',1,10),(52,NULL,0,'2018-12-15 22:54:37',1,11),(53,NULL,0,'2018-12-15 22:54:40',1,12),(54,NULL,0,'2018-12-15 22:54:43',1,13),(55,NULL,0,'2018-12-15 22:54:46',1,14),(56,NULL,0,'2018-12-15 22:54:48',1,15),(57,NULL,0,'2018-12-15 22:54:50',1,16),(58,NULL,0,'2018-12-15 22:54:54',1,17),(59,NULL,0,'2018-12-15 22:54:56',1,18),(60,NULL,0,'2018-12-15 22:54:59',1,19),(61,NULL,0,'2018-12-15 22:55:03',1,20),(62,NULL,0,'2018-12-15 22:55:06',1,21),(63,NULL,0,'2018-12-15 22:55:08',1,22),(64,NULL,0,'2018-12-15 22:55:11',1,23),(65,NULL,0,'2018-12-15 22:55:13',1,24),(66,NULL,0,'2018-12-15 22:55:16',1,25),(68,NULL,0,'2018-12-15 22:55:31',8,22),(69,NULL,1,'2018-12-15 22:56:22',4,9);

/*Table structure for table `tb_postreply` */

DROP TABLE IF EXISTS `tb_postreply`;

CREATE TABLE `tb_postreply` (
  `postreply_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '帖子回复id',
  `postreply_count` varchar(500) NOT NULL COMMENT '回复内容',
  `postreply_createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `postreply_report` tinyint(3) unsigned DEFAULT '0' COMMENT '是否举报成功',
  `postreply_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次修改时间',
  `user_id` int(11) NOT NULL COMMENT '回复人id',
  `postcommit_id` int(10) unsigned NOT NULL COMMENT '帖子评论id',
  `user_name` varchar(20) NOT NULL COMMENT '回复人昵称',
  PRIMARY KEY (`postreply_id`),
  KEY `FKhuqwunxs6h10ave9y1vp96f3e` (`postcommit_id`),
  CONSTRAINT `FKhuqwunxs6h10ave9y1vp96f3e` FOREIGN KEY (`postcommit_id`) REFERENCES `tb_postcommit` (`postcommit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `tb_postreply` */

insert  into `tb_postreply`(`postreply_id`,`postreply_count`,`postreply_createtime`,`postreply_report`,`postreply_update_time`,`user_id`,`postcommit_id`,`user_name`) values (1,'666','2018-12-09 15:14:14',0,'2018-12-11 19:11:27',1,1,'雨中画'),(2,'不开心','2018-12-09 15:14:14',0,'2018-12-11 16:57:09',3,1,'王哈哈'),(3,'学习页面签到就可以了吧，不需要在这里跟帖评论。','2018-12-15 23:26:42',0,'2018-12-15 23:32:16',4,1,'我爱学习'),(4,'乖乖地天天签到。。。','2018-12-15 23:26:42',0,'2018-12-15 23:32:17',5,1,'我蜗'),(5,'日常签到emmm','2018-12-15 23:26:42',0,'2018-12-15 23:32:24',6,1,'这是我昵称'),(6,'签到签到。希望会被幸运的抽中','2018-12-15 23:26:42',0,'2018-12-15 23:32:25',7,1,'今天你看慕课了吗'),(7,'签到了哦哈','2018-12-15 23:26:42',0,'2018-12-15 23:32:26',8,1,'箱子v1'),(8,'学习和中奖使我快乐','2018-12-15 23:26:42',0,'2018-12-15 23:32:28',1,1,'今天你看慕课了吗'),(9,'(日常签到啊','2018-12-15 23:26:42',0,'2018-12-15 23:32:29',3,1,'王哈哈'),(10,'坚持每天签到，不管有没有活动。','2018-12-15 23:26:42',0,'2018-12-15 23:32:30',4,1,'我爱学习'),(11,'坚持签到，坚持打卡','2018-12-15 23:26:42',0,'2018-12-15 23:32:37',5,1,'我蜗'),(12,'签签签到…啦','2018-12-15 23:26:42',0,'2018-12-15 23:32:31',6,1,'这是我昵称'),(13,'我来啦！小鱼儿','2018-12-15 23:26:42',0,'2018-12-15 23:32:33',7,2,'今天你看慕课了吗'),(14,'期待小幸运','2018-12-15 23:26:42',0,'2018-12-15 23:32:34',8,3,'箱子v1 '),(15,'小锦鲤来了','2018-12-15 23:26:42',0,'2018-12-15 23:32:38',7,4,'今天你看慕课了吗'),(16,'期待期待，希望能有好运哦','2018-12-15 23:26:42',0,'2018-12-15 23:32:36',6,5,'这是我昵称'),(17,'好好学习才能有惊喜','2018-12-15 23:26:42',0,'2018-12-15 23:32:43',5,6,'我蜗');

/*Table structure for table `tb_postreplylike` */

DROP TABLE IF EXISTS `tb_postreplylike`;

CREATE TABLE `tb_postreplylike` (
  `postreplylike_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '点赞回复id',
  `postreplylike_createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `postreplylike_stuts` tinyint(3) unsigned DEFAULT '0' COMMENT '点赞状态',
  `postreplylike_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次修改时间',
  `user_id` int(11) NOT NULL COMMENT '点赞人id',
  `postreply_id` int(10) unsigned NOT NULL COMMENT '帖子回复id',
  PRIMARY KEY (`postreplylike_id`),
  KEY `FKifprsfugbvbejrif0gj45qpjk` (`postreply_id`),
  CONSTRAINT `FKifprsfugbvbejrif0gj45qpjk` FOREIGN KEY (`postreply_id`) REFERENCES `tb_postreply` (`postreply_id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

/*Data for the table `tb_postreplylike` */

insert  into `tb_postreplylike`(`postreplylike_id`,`postreplylike_createtime`,`postreplylike_stuts`,`postreplylike_update_time`,`user_id`,`postreply_id`) values (1,'2018-12-09 15:17:22',1,'2018-12-09 15:17:54',1,1),(2,'2018-12-09 15:17:22',2,'2018-12-09 15:17:55',6,1),(3,'2018-12-09 15:17:22',1,'2018-12-09 15:17:55',3,1),(4,'2018-12-09 15:17:22',1,'2018-12-09 15:17:56',4,2),(5,'2018-12-09 15:17:22',2,'2018-12-09 15:17:59',5,2),(6,'2018-12-15 23:36:58',1,'2018-12-15 23:38:49',6,1),(7,'2018-12-15 23:36:58',1,'2018-12-15 23:38:50',7,1),(8,'2018-12-15 23:36:58',1,'2018-12-15 23:38:52',8,1),(9,'2018-12-15 23:36:58',1,'2018-12-15 23:38:52',9,1),(10,'2018-12-15 23:36:58',1,'2018-12-15 23:38:57',10,1),(11,'2018-12-15 23:36:58',1,'2018-12-15 23:38:43',11,1),(12,'2018-12-15 23:36:58',1,'2018-12-15 23:38:45',13,1),(13,'2018-12-15 23:36:58',1,'2018-12-15 23:38:44',12,1),(14,'2018-12-15 23:36:58',2,'2018-12-15 23:38:46',14,1),(15,'2018-12-15 23:36:58',2,'2018-12-15 23:38:46',15,1),(16,'2018-12-15 23:36:58',2,'2018-12-15 23:38:47',16,1),(17,'2018-12-15 23:36:58',2,'2018-12-15 23:38:32',1,2),(18,'2018-12-15 23:36:58',1,'2018-12-15 23:38:32',2,2),(19,'2018-12-15 23:36:58',1,'2018-12-15 23:38:35',3,2),(21,'2018-12-15 23:36:58',1,'2018-12-15 23:38:36',4,3),(22,'2018-12-15 23:36:58',1,'2018-12-15 23:38:37',1,4),(23,'2018-12-15 23:36:58',1,'2018-12-15 23:38:37',1,5),(24,'2018-12-15 23:36:58',1,'2018-12-15 23:38:40',1,6),(25,'2018-12-15 23:36:58',1,'2018-12-15 23:38:39',1,7),(26,'2018-12-15 23:36:58',1,'2018-12-15 23:38:40',1,8),(27,'2018-12-15 23:36:58',1,'2018-12-15 23:38:27',1,9),(28,'2018-12-15 23:36:58',1,'2018-12-15 23:38:28',1,10),(29,'2018-12-15 23:36:58',1,'2018-12-15 23:38:28',1,11),(30,'2018-12-15 23:36:58',1,'2018-12-15 23:38:29',1,12),(31,'2018-12-15 23:36:58',1,'2018-12-15 23:38:25',1,13),(32,'2018-12-15 23:36:58',1,'2018-12-15 23:38:26',1,14),(33,'2018-12-15 23:36:58',1,'2018-12-15 23:38:23',1,15),(34,'2018-12-15 23:36:58',1,'2018-12-15 23:38:19',1,16),(35,'0000-00-00 00:00:00',1,'2018-12-15 23:38:20',1,17),(37,'2018-12-15 23:36:58',1,'2018-12-15 23:38:18',7,7);

/*Table structure for table `tb_postreplyreport` */

DROP TABLE IF EXISTS `tb_postreplyreport`;

CREATE TABLE `tb_postreplyreport` (
  `postreplyreport_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '回复举报id',
  `postreplyreport_content` varchar(100) NOT NULL COMMENT '举报内容',
  `postreplyreport_createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `postreplyreport_stuts` tinyint(3) unsigned DEFAULT '0' COMMENT '举报信息审核状态',
  `postreplyreport_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次修改时间',
  `user_id` int(11) NOT NULL COMMENT '举报人id',
  `postreply_id` int(10) unsigned NOT NULL COMMENT '帖子回复id',
  PRIMARY KEY (`postreplyreport_id`),
  KEY `FKn401h5by1x01lj5n66ubspjxi` (`postreply_id`),
  CONSTRAINT `FKn401h5by1x01lj5n66ubspjxi` FOREIGN KEY (`postreply_id`) REFERENCES `tb_postreply` (`postreply_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `tb_postreplyreport` */

insert  into `tb_postreplyreport`(`postreplyreport_id`,`postreplyreport_content`,`postreplyreport_createtime`,`postreplyreport_stuts`,`postreplyreport_update_time`,`user_id`,`postreply_id`) values (1,'内容不好','2018-12-09 15:16:14',0,'2018-12-09 15:16:30',1,1),(2,'举报','2018-12-09 15:16:14',0,'2018-12-09 15:16:33',3,1),(3,'举报','2018-12-15 23:33:39',1,'2018-12-15 23:34:17',4,2),(4,'举报','2018-12-15 23:33:39',0,'2018-12-15 23:34:21',5,3);

/*Table structure for table `tb_postreport` */

DROP TABLE IF EXISTS `tb_postreport`;

CREATE TABLE `tb_postreport` (
  `postreport_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '帖子举报主键',
  `postreport_content` varchar(200) NOT NULL COMMENT '举报内容',
  `postreport_createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `postreport_stuts` tinyint(3) unsigned DEFAULT '0' COMMENT '举报信息审核状态',
  `postreport_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次修改时间',
  `user_id` int(11) NOT NULL COMMENT '举报的用户',
  `post_id` int(10) unsigned NOT NULL COMMENT '帖子id',
  PRIMARY KEY (`postreport_id`),
  KEY `FKgqwjn0hkptj1g98lr48thc03p` (`post_id`),
  CONSTRAINT `FKgqwjn0hkptj1g98lr48thc03p` FOREIGN KEY (`post_id`) REFERENCES `tb_post` (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `tb_postreport` */

insert  into `tb_postreport`(`postreport_id`,`postreport_content`,`postreport_createtime`,`postreport_stuts`,`postreport_update_time`,`user_id`,`post_id`) values (1,'内容不好','2018-12-09 15:06:53',0,'2018-12-09 15:07:01',1,1),(2,'内容不好','2018-12-15 22:44:40',1,'2018-12-15 22:46:47',3,1),(3,'内容不好','2018-12-15 22:44:40',0,'2018-12-15 22:46:48',4,2),(4,'内容不好','2018-12-15 22:44:40',0,'2018-12-15 22:46:49',5,3),(5,'内容不好','2018-12-15 22:44:40',0,'2018-12-15 22:46:50',6,4),(6,'内容不好','2018-12-15 22:44:40',1,'2018-12-15 22:46:51',7,5),(7,'内容不好','2018-12-15 22:44:40',0,'2018-12-15 22:46:52',8,6),(8,'内容不好','2018-12-15 22:44:40',0,'2018-12-15 22:46:53',1,7),(9,'就是想举报','2018-12-15 22:44:40',0,'2018-12-15 22:46:54',3,21),(10,'就是想举报','2018-12-15 22:44:40',1,'2018-12-15 22:46:56',5,13),(11,'就是想举报','2018-12-15 22:44:40',0,'2018-12-15 22:46:57',6,15),(12,'就是想举报','2018-12-15 22:44:40',0,'2018-12-15 22:46:58',7,18),(13,'就是想举报','2018-12-15 22:44:40',0,'2018-12-15 22:47:01',8,11);

/*Table structure for table `tb_reportcount` */

DROP TABLE IF EXISTS `tb_reportcount`;

CREATE TABLE `tb_reportcount` (
  `reportcount_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '帖子举报内容主键',
  `reportcount_content` varchar(200) NOT NULL COMMENT '管理员返还的举报内容',
  `reportcount_createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `reportcount_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次修改时间',
  `post_id` int(10) unsigned NOT NULL COMMENT '帖子id',
  PRIMARY KEY (`reportcount_id`),
  KEY `FKp54wgo0tn2sxf5bp4qb0mjg8n` (`post_id`),
  CONSTRAINT `FKp54wgo0tn2sxf5bp4qb0mjg8n` FOREIGN KEY (`post_id`) REFERENCES `tb_post` (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `tb_reportcount` */

insert  into `tb_reportcount`(`reportcount_id`,`reportcount_content`,`reportcount_createtime`,`reportcount_update_time`,`post_id`) values (1,'经过管理员的审核,您的举报成功','2018-12-15 22:49:49','2018-12-15 22:49:56',1),(2,'经过管理员的审核,您的举报成功','2018-12-15 22:49:49','2018-12-15 22:49:57',5),(3,'经过管理员的审核,您的举报未成功,我们会加大监管力度','2018-12-15 22:49:49','2018-12-15 22:50:00',13);

/*Table structure for table `tb_users` */

DROP TABLE IF EXISTS `tb_users`;

CREATE TABLE `tb_users` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `user_name` varchar(50) NOT NULL COMMENT '用户姓名',
  `user_touurl` varchar(200) DEFAULT NULL COMMENT '用户头像路经',
  `user_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次修改时间',
  `user_pwd` varchar(50) DEFAULT NULL COMMENT '用户密码',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `tb_users` */

insert  into `tb_users`(`user_id`,`user_createtime`,`user_name`,`user_touurl`,`user_update_time`,`user_pwd`) values (1,'2016-06-24 00:00:00','雨中画','txiang.png','2018-12-09 14:43:26',''),(2,'2017-01-23 00:00:00','贴吧管理员','txiang.png','2018-12-09 15:27:27','123456'),(3,'2016-03-15 00:00:00','王哈哈','txiang.png','2018-12-09 14:46:13',''),(4,'2018-12-09 00:00:00','我爱学习','txiang.png','2018-12-09 14:46:13',''),(5,'2016-11-26 00:00:00','我蜗','txiang.png','2018-12-09 14:46:14',''),(6,'2018-11-11 00:00:00','这是我昵称','txiang.png','2018-12-09 14:46:22',''),(7,'2018-12-15 21:57:02',' 今天你看慕课了吗','txiang.png','2018-12-15 21:57:11',NULL),(8,'2018-12-15 21:57:39','箱子v1 ','txiang.png','2018-12-15 21:57:49',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
