# Host: localhost  (Version: 5.5.27)
# Date: 2014-10-17 23:02:43
# Generator: MySQL-Front 5.3  (Build 2.42)

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;

#
# Source for table "u_card"
#

DROP TABLE IF EXISTS u_card;
CREATE TABLE u_card (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  created_time timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  updated_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  user_id bigint(20) NOT NULL DEFAULT '0',
  name varchar(255) DEFAULT NULL,
  company varchar(255) DEFAULT NULL,
  title varchar(255) DEFAULT NULL,
  phone varchar(20) DEFAULT NULL,
  email varchar(50) DEFAULT NULL,
  address varchar(255) DEFAULT NULL,
  website varchar(255) DEFAULT NULL,
  qq varchar(20) DEFAULT NULL,
  weixin varchar(50) DEFAULT NULL,
  photo varchar(255) DEFAULT NULL,
  qrcode varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

#
# Data for table "u_card"
#

#INSERT INTO u_card VALUES (8,'2014-10-17 00:33:20','2014-10-17 00:33:20',1,'name1','北京邮电大学1','工程师','13121986603','email@gmail.com','北京市海淀区西土城路10号','www.baidu.com','9494944','weixin165','http://t12.baidu.com/it/u=280433981,3906892836&fm=58','www.baidu.com'),(9,'2014-10-17 00:33:31','2014-10-17 00:33:31',2,'name2','北京邮电大学1','工程师','13121986603','email@gmail.com','北京市海淀区西土城路10号','www.baidu.com','9494944','weixin165','http://t12.baidu.com/it/u=280433981,3906892836&fm=58','www.baidu.com'),(10,'2014-10-17 00:33:37','2014-10-17 00:33:37',3,'name3','北京邮电大学1','工程师','13121986603','email@gmail.com','北京市海淀区西土城路10号','www.baidu.com','9494944','weixin165','http://t12.baidu.com/it/u=280433981,3906892836&fm=58','www.baidu.com'),(11,'2014-10-17 00:33:42','2014-10-17 00:33:42',4,'name4','北京邮电大学1','工程师','13121986603','email@gmail.com','北京市海淀区西土城路10号','www.baidu.com','9494944','weixin165','http://t12.baidu.com/it/u=280433981,3906892836&fm=58','www.baidu.com'),(12,'2014-10-17 00:33:46','2014-10-17 00:33:46',5,'name5','北京邮电大学1','工程师','13121986603','email@gmail.com','北京市海淀区西土城路10号','www.baidu.com','9494944','weixin165','http://t12.baidu.com/it/u=280433981,3906892836&fm=58','www.baidu.com'),(13,'2014-10-17 00:33:51','2014-10-17 00:33:51',6,'name6','北京邮电大学1','工程师','13121986603','email@gmail.com','北京市海淀区西土城路10号','www.baidu.com','9494944','weixin165','http://t12.baidu.com/it/u=280433981,3906892836&fm=58','www.baidu.com'),(14,'2014-10-17 00:33:56','2014-10-17 00:34:46',7,'name7','北京邮电大学7','工程师','13121986603','email@gmail.com','北京市海淀区西土城路10号','www.baidu.com','9494944','weixin165','http://t12.baidu.com/it/u=280433981,3906892836&fm=58','www.baidu.com');

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
