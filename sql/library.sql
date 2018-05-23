# Host: localhost  (Version 6.0.11-alpha-community)
# Date: 2018-05-22 20:31:40
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "book"
#

DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(255) NOT NULL,
  `book_writer` varchar(255) NOT NULL,
  `book_publisher` varchar(255) NOT NULL,
  `book_isrent` bigint(20) NOT NULL,
  `book_person` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Data for table "book"
#

INSERT INTO `book` VALUES (1,'机器学习','周志华','清华大学出版社',1,'linyue'),(2,'实战机器学习','Peter','人民邮电出版社',1,'linyue'),(4,'算法导论','Thomas','机械工业出版社',0,' ');

#
# Structure for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(40) NOT NULL,
  `user_email` varchar(50) NOT NULL,
  `user_pwd` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

#
# Data for table "user"
#

INSERT INTO `user` VALUES (1,'linyue','123123@qq.com','123'),(3,'rain','222222@gmail.com','222'),(4,'ray','333333@qq.com','333'),(5,'test','123123@qq.com','123');
