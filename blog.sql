-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: blog
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_blog`
--

DROP TABLE IF EXISTS `t_blog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_blog` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `appreciation` bit(1) NOT NULL,
  `commentabled` bit(1) NOT NULL,
  `content` longtext,
  `create_time` datetime(6) DEFAULT NULL,
  `first_picture` varchar(255) DEFAULT NULL,
  `flag` varchar(255) DEFAULT NULL,
  `published` bit(1) NOT NULL,
  `recommend` bit(1) NOT NULL,
  `share_statement` bit(1) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `update_time` datetime(6) DEFAULT NULL,
  `views` int DEFAULT NULL,
  `type_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `description` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_blog`
--

LOCK TABLES `t_blog` WRITE;
/*!40000 ALTER TABLE `t_blog` DISABLE KEYS */;
INSERT INTO `t_blog` VALUES (1055,_binary '',_binary '','> 安装Mysql前：\r\n>\r\n> ​	1、如果：你（曾经安装过)，需要（先卸载干净）， 否则是（装不上）的。所以先谈（卸载）\r\n>\r\n> ​    2、如果：你没有（安装过），这是（第一次安装）， 请直接看（第2部分）Mysql安装教程。\r\n\r\n\r\n\r\n# 1、Mysql彻底卸载\r\n\r\n~~~\r\n分为三个步骤：\r\n	1、卸载Mysql(软件)\r\n	2、删除Mysql(残留文件)\r\n	3、删除mysql(注册表)\r\n	4、重启电脑\r\n~~~\r\n\r\n## 1.1、 卸载Mysql(软件)\r\n\r\n<img src=\"https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture8/image-20210225100139275.png\" alt=\"image-20210225100139275\" style=\"zoom: 33%;\" />\r\n\r\n---\r\n\r\n<img src=\"https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture8/image-20210225100652279.png\" alt=\"image-20210225100652279\" style=\"zoom:50%;\" />\r\n\r\n\r\n\r\n## 1.2、删除Mysql(残留文件)\r\n\r\n> `把3个目录下的`：Mysql目录（删除掉）\r\n\r\n<img src=\"https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture8/image-20210225101506730.png\" alt=\"image-20210225101506730\"  />\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n## 1.3、 删除mysql(注册表)\r\n\r\n- `第一步:打开注册表`\r\n\r\n> window + R中输入：regedit\r\n\r\n---\r\n\r\n<img src=\"https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture8/image-20210225102143059.png\" alt=\"image-20210225102143059\" style=\"zoom:33%;\" />\r\n\r\n---\r\n\r\n<img src=\"https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture8/image-20210225101930080.png\" alt=\"image-20210225101930080\" style=\"zoom:33%;\" />\r\n\r\n---\r\n\r\n- `第二步：删除mysql注册表`\r\n\r\n~~~\r\n找到这6个路径：（分别删除Mysql）\r\n\r\nHKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControl001\\Services\\MYSQL\r\nHKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControl002\\Services\\MYSQL\r\nHKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\Services\\MYSQL\r\n\r\nHKEY_LOCAL_MACHINE\\SYSTEM\\ControlSet001\\Services\\Eventlog\\Application\\MySQL\r\nHKEY_LOCAL_MACHINE\\SYSTEM\\ControlSet002\\Services\\Eventlog\\Application\\MySQL\r\nHKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\Services\\Eventlog\\Application\\MySQL\r\n~~~\r\n\r\n<img src=\"https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture8/image-20210225103504095.png\" alt=\"image-20210225103504095\" style=\"zoom:50%;\" />\r\n\r\n---\r\n\r\n## 1.4、重启电脑\r\n\r\n> 不重启：可能装不上。\r\n\r\n\r\n\r\n\r\n\r\n# 2、安装Mysql\r\n\r\n~~~\r\n1、官网安装\r\n2、选版本（看个人需求）\r\n3、正式安装（MSI版本）是microsoft installer的简写，是微软格式的安装包。\r\n~~~\r\n\r\n## 2.1、官网安装\r\n\r\n> 安装网址：https://dev.mysql.com/downloads/installer/\r\n\r\n<img src=\"https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture8/image-20210225105441638.png\" alt=\"image-20210225105441638\" style=\"zoom: 33%;\" />\r\n\r\n---\r\n\r\n## 2.2、选择版本\r\n\r\n<img src=\"https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture8/image-20210225105551371.png\" alt=\"image-20210225105551371\" style=\"zoom: 33%;\" />\r\n\r\n---\r\n\r\n\r\n\r\n## 2.3、正式安装\r\n\r\n- `第一步: Download安装`\r\n\r\n> 此处我选择：Mysql 8.0.23 最新版本   （其余版本：操作也是一致的）\r\n\r\n![image-20210225110504945](https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture8/image-20210225110504945.png)\r\n\r\n---\r\n\r\n\r\n\r\n- `第二步：打开Mysql安装包，安装`\r\n\r\n<img src=\"https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture8/image-20210225111135015.png\" alt=\"image-20210225111135015\" style=\"zoom: 50%;\" />\r\n\r\n---\r\n\r\n<img src=\"https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture8/image-20210225113322331.png\" alt=\"image-20210225113322331\" style=\"zoom: 33%;\" />\r\n\r\n---\r\n\r\n<img src=\"https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture8/image-20210225113736364.png\" alt=\"image-20210225113736364\"  />\r\n\r\n----\r\n\r\n> 如果：出现了这个，点击安装。 \r\n>\r\n> 如果：没有出现，说明你（安装其他）软件时，`已经装过`, 不必慌张。\r\n\r\n<img src=\"https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture8/image-20210225114129657.png\" alt=\"image-20210225114129657\" style=\"zoom: 50%;\" />\r\n\r\n---\r\n\r\n<img src=\"https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture8/image-20210225113855222.png\" alt=\"image-20210225113855222\" style=\"zoom: 50%;\" />\r\n\r\n---\r\n\r\n<img src=\"https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture8/image-20210225114831129.png\" alt=\"image-20210225114831129\" style=\"zoom:50%;\" />\r\n\r\n---\r\n\r\n<img src=\"https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture8/image-20210225114927546.png\" alt=\"image-20210225114927546\" style=\"zoom: 50%;\" />\r\n\r\n---\r\n\r\n<img src=\"https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture8/image-20210225115502984.png\" alt=\"image-20210225115502984\" style=\"zoom:50%;\" />\r\n\r\n---\r\n\r\n<img src=\"https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture8/image-20210225115605516.png\" alt=\"image-20210225115605516\" style=\"zoom:50%;\" />\r\n\r\n---\r\n\r\n<img src=\"https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture8/image-20210225115729705.png\" alt=\"image-20210225115729705\" style=\"zoom:50%;\" />\r\n\r\n---\r\n\r\n<img src=\"https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture8/image-20210225115819999.png\" alt=\"image-20210225115819999\" style=\"zoom:50%;\" />\r\n\r\n---\r\n\r\n![image-20210225120526443](https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture8/image-20210225120526443.png)\r\n\r\n---\r\n\r\n<img src=\"https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture8/image-20210225120617593.png\" alt=\"image-20210225120617593\" style=\"zoom: 33%;\" />\r\n\r\n---\r\n\r\n<img src=\"https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture8/image-20210225120644968.png\" alt=\"image-20210225120644968\" style=\"zoom:33%;\" />\r\n\r\n----\r\n\r\n## 2.4、配置环境变量\r\n\r\n<img src=\"https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture8/image-20210225121009744.png\" alt=\"image-20210225121009744\" style=\"zoom:33%;\" />\r\n\r\n---\r\n\r\n<img src=\"https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture8/image-20210225121045426.png\" alt=\"image-20210225121045426\" style=\"zoom:50%;\" />\r\n\r\n---\r\n\r\n<img src=\"https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture8/image-20210225121126061.png\" alt=\"image-20210225121126061\" style=\"zoom:50%;\" />\r\n\r\n---\r\n\r\n![image-20210225121531322](https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture8/image-20210225121531322.png)\r\n\r\n---\r\n\r\n## 2.5、测试：是否安装成功\r\n\r\n> cmd中输入：mysql -u root -p\r\n\r\n<img src=\"https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture8/image-20210225122009120.png\" alt=\"image-20210225122009120\" style=\"zoom:50%;\" />\r\n\r\n---\r\n\r\n\r\n\r\n# 3、Navicat连接Mysql\r\n\r\n> Navicat连接Mysql 是建立在：Mysql已（成功安装了）的（前提下）\r\n\r\n## 3.1、下载Navicat\r\n\r\n> 官网安装：https://navicat.com.cn/download/navicat-premium\r\n\r\n![image-20210225122953526](https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture8/image-20210225122953526.png)\r\n\r\n---\r\n\r\n## 3.2、安装：\r\n\r\n> 安装方法：一路下一步就好，注意（选择下：安装路径），以后（删除方便）\r\n\r\n<img src=\"https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture8/image-20210225123601921.png\" alt=\"image-20210225123601921\" style=\"zoom:50%;\" />\r\n\r\n\r\n\r\n\r\n\r\n## 3.3、连接Mysql测试\r\n\r\n---\r\n\r\n<img src=\"https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture8/image-20210225124646562.png\" alt=\"image-20210225124646562\" style=\"zoom: 67%;\" />\r\n\r\n---\r\n\r\n<img src=\"https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture8/image-20210225125322459.png\" alt=\"image-20210225125322459\" style=\"zoom:50%;\" />\r\n\r\n`sql代码：`\r\n\r\n~~~mysql\r\ncreate table student(\r\n	stuId int primary key,\r\n	sname varchar(20)\r\n)charset=utf8;\r\n\r\ninsert into student values(1, \'张三\');\r\ninsert into student values(2, \'王五\');\r\n\r\nselect * from student;\r\n~~~\r\n\r\n\r\n\r\n# 4、操作过程中==可能遇到的问题==\r\n\r\n> 会一直更新\r\n\r\n','2021-07-16 17:46:26.095000','https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture9/142-400x250.jpg','原创',_binary '',_binary '',_binary '','Windows下Mysql安装','2021-07-16 17:46:26.095000',7,72,1,'这篇博客是基于：Windows下安装 Mysql 8.0.23 的教程， 由本人亲自测试安装成功！！！'),(1099,_binary '\0',_binary '\0','# 1、Nginx概念\r\n\r\n\r\n\r\n## 1.1、什么是Nginx\r\n\r\n\r\n\r\n## 1.2、Nginx的作用\r\n\r\n~~~nginx\r\n作用：\r\n	1、反向代理\r\n	2、负载均衡\r\n	3、动静分离\r\n~~~\r\n\r\n\r\n\r\n\r\n\r\n# 2、Nginx的安装\r\n\r\n## 2.1、windows下安装\r\n\r\n~~~nginx\r\nNginx下载页面下载后（无中文目录）解压,  用cmd执行 nginx.exe 访问80端口即可\r\n~~~\r\n\r\n<img src=\"https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture9/image-20210712184741023.png\" alt=\"image-20210712184741023\" style=\"zoom:50%;\" />\r\n\r\n---\r\n\r\n\r\n\r\n## 2.2、Linux下安装\r\n\r\n~~~shell\r\n# 1、下载页面：下载 (nginx-1.20.1.tar.gz) 后传输到linux服务器上\r\n\r\n\r\n# 2、确认nginx没有安装过\r\n	whereis nginx      # 寻找：nginx的位置\r\n	nginx			   # nginx命令，再次测试： nginx: command not found\r\n\r\n# 3、解压\r\n	tar -zxvf 安装包.tar.gz\r\n	\r\n# 4、进入：nginx目录， 自动配置config\r\n	./configure\r\n\r\n# 5、编译\r\n	make\r\n	\r\n# 6、安装\r\n	make install\r\n\r\n# 7、寻找nginx的位置\r\n	whereis nginx\r\n\r\n# 8、进入sbin执行nginx\r\n	./nginx\r\n~~~\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n# 3、Nginx命令\r\n\r\n~~~shell\r\n#1、寻找：nginx目录\r\n	whereis nginx   #进行查找\r\n\r\n#2、启动nginx（前提：进入nginx的sbin目录）\r\n	./nginx\r\n	\r\n#3、停止\r\n	./nginx -s stop     #注意：停止是强制性的\r\n		\r\n#4、安全退出\r\n	./nginx -s quit     #注意：安全退出，会保证安全的情况下去（结束nginx的进程）\r\n	\r\n#5、重新加载配置文件\r\n	./nginx -s reload\r\n\r\n#6、查看nginx的进程\r\n	ps aux|grep nginx\r\n~~~\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n# 4、Nginx快速入门：实战\r\n\r\n> 实现：windows下启动（两个服务），也就两个jar不同端口， 使用（反向代理、负载均衡）特性','2021-07-18 15:58:08.895000','https://gitee.com/sheep-are-flying-in-the-sky/my-picture/raw/master/picture9/173-400x250.jpg','原创',_binary '',_binary '',_binary '\0','Nginx笔记','2021-07-18 15:58:08.895000',1,71,1,'这是学习Nginx笔记');
/*!40000 ALTER TABLE `t_blog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_blog_tags`
--

DROP TABLE IF EXISTS `t_blog_tags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_blog_tags` (
  `blogs_id` bigint NOT NULL,
  `tags_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_blog_tags`
--

LOCK TABLES `t_blog_tags` WRITE;
/*!40000 ALTER TABLE `t_blog_tags` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_blog_tags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_comment`
--

DROP TABLE IF EXISTS `t_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_comment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `create_time` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `blog_id` bigint DEFAULT NULL,
  `parent_comment_id` bigint DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `admin_comment` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=137 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_comment`
--

LOCK TABLES `t_comment` WRITE;
/*!40000 ALTER TABLE `t_comment` DISABLE KEYS */;
INSERT INTO `t_comment` VALUES (136,'白丁浪迹江湖路， 莫怕生死谈笑间。','2021-07-18 09:23:52.225000','DD25600552987@qq.com','泯恩仇',1055,-1,'/images/comment.jpg',_binary '\0');
/*!40000 ALTER TABLE `t_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_tag`
--

DROP TABLE IF EXISTS `t_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_tag` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=136 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_tag`
--

LOCK TABLES `t_tag` WRITE;
/*!40000 ALTER TABLE `t_tag` DISABLE KEYS */;
INSERT INTO `t_tag` VALUES (115,'测试标签1'),(120,'测试标签2');
/*!40000 ALTER TABLE `t_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_type`
--

DROP TABLE IF EXISTS `t_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_type` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_type`
--

LOCK TABLES `t_type` WRITE;
/*!40000 ALTER TABLE `t_type` DISABLE KEYS */;
INSERT INTO `t_type` VALUES (71,'剑指Offer'),(72,'SqlServer');
/*!40000 ALTER TABLE `t_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `avatar` varchar(255) DEFAULT NULL,
  `create_time` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `update_time` datetime(6) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'/images/avatar.jpg','2021-06-05 18:22:34.000000','2560055298@qq.com','老洋','e10adc3949ba59abbe56e057f20f883eTZaFQ8muE2LtSMsC8/rPNA==','管理员','2021-08-05 18:23:09.000000','root');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-20 20:08:35
