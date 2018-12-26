/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.19 : Database - filemanagement
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`filemanagement` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `filemanagement`;

/*Table structure for table `tb_files` */

DROP TABLE IF EXISTS `tb_files`;

CREATE TABLE `tb_files` (
  `files_id` varchar(100) NOT NULL COMMENT '备注:自动生成',
  `create_time` datetime DEFAULT NULL COMMENT '备注:file上传时间',
  `files_name` varchar(1000) DEFAULT NULL COMMENT '备注:文件名称',
  `files_uploadUrl` varchar(1000) DEFAULT NULL COMMENT '备注:文件本地路径',
  `files_url` varchar(1000) DEFAULT NULL COMMENT '备注:文件访问路径',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '备注:文件修改时间',
  `video_size` varchar(30) DEFAULT NULL COMMENT '备注:视频文件大小',
  `video_time` int(11) DEFAULT NULL COMMENT '备注:视频文件时长/s',
  `video_format` varchar(30) DEFAULT NULL COMMENT '备注:视频格式',
  `video_cover` varchar(200) DEFAULT NULL COMMENT '备注:视频封面图片',
  PRIMARY KEY (`files_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_files` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
