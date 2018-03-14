-- MySQL dump 10.14  Distrib 5.5.52-MariaDB, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: kjkj
-- ------------------------------------------------------
-- Server version	5.5.52-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tbl_data1024`
--

DROP TABLE IF EXISTS `tbl_data1024`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_data1024` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `chanel` bigint(20) NOT NULL,
  `dataType` int(11) NOT NULL,
  `errorRow` bigint(20) NOT NULL,
  `errorType` int(11) NOT NULL,
  `currentCount` bigint(20) NOT NULL,
  `nextCount` bigint(20) NOT NULL,
  `inputTime` bigint(20) NOT NULL,
  `produceTime` bigint(20) NOT NULL,
  `reporter` bigint(20) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_data1024`
--

LOCK TABLES `tbl_data1024` WRITE;
/*!40000 ALTER TABLE `tbl_data1024` DISABLE KEYS */;
INSERT INTO `tbl_data1024` VALUES (1,8,100,46874,200,53910,53912,1515296318719,1515296318719,1),(2,9,100,46875,200,53911,53913,1515296318719,1515296318719,1),(3,10,100,46876,200,53912,53914,1515296318719,1515296318719,1),(4,11,100,46877,200,53913,53915,1515296318719,1515296318719,1),(5,12,100,46878,200,53914,53916,1515296318719,1515296318719,1),(6,13,100,46879,200,53915,53917,1515296318719,1515296318719,1),(7,14,100,46873,200,53916,53918,1515296318719,1515296318719,1);
/*!40000 ALTER TABLE `tbl_data1024` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_data848`
--

DROP TABLE IF EXISTS `tbl_data848`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_data848` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `errorFrame` varchar(20) NOT NULL,
  `correctCode` varchar(20) NOT NULL,
  `actualCode` varchar(20) NOT NULL,
  `inputTime` bigint(20) NOT NULL,
  `produceTime` bigint(20) NOT NULL,
  `reporter` bigint(20) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_data848`
--

LOCK TABLES `tbl_data848` WRITE;
/*!40000 ALTER TABLE `tbl_data848` DISABLE KEYS */;
INSERT INTO `tbl_data848` VALUES (1,'0','1f 15','88 82',1515296318719,1515296318719,1),(2,'1','2f 15','88 83',1515296318719,1515296318719,1),(3,'2','3f 15','88 84',1515296318719,1515296318719,1);
/*!40000 ALTER TABLE `tbl_data848` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_dep`
--

DROP TABLE IF EXISTS `tbl_dep`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_dep` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(28) DEFAULT NULL,
  `tele` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_dep`
--

LOCK TABLES `tbl_dep` WRITE;
/*!40000 ALTER TABLE `tbl_dep` DISABLE KEYS */;
INSERT INTO `tbl_dep` VALUES (1,'信息中心','15809294537'),(2,'服务中心','137'),(3,'AA','1');
/*!40000 ALTER TABLE `tbl_dep` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_emp`
--

DROP TABLE IF EXISTS `tbl_emp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_emp` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `userName` varchar(15) DEFAULT NULL,
  `pwd` varchar(32) DEFAULT NULL,
  `name` varchar(28) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `tele` varchar(30) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `gender` int(1) DEFAULT NULL,
  `birthday` bigint(20) DEFAULT NULL,
  `depUuid` bigint(20) NOT NULL,
  `lastLoginTime` bigint(20) NOT NULL,
  `lastLoginIp` varchar(30) NOT NULL,
  `loginTimes` int(11) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_emp`
--

LOCK TABLES `tbl_emp` WRITE;
/*!40000 ALTER TABLE `tbl_emp` DISABLE KEYS */;
INSERT INTO `tbl_emp` VALUES (1,'admin','21232f297a57a5a743894a0e4a801fc3','白新平','15809294537','西安','1',1647469340,NULL,1,1515344778908,'0:0:0:0:0:0:0:1',146),(2,'fuwu','a0134b5d74668d25f24c3c06065eef7c','fuwu','','','',0,NULL,2,1508160926096,'-',0),(3,'dsds','0544ed93c22d5e1c869010c4515a7401','sdfas','','','',0,1506873600000,1,1508391911573,'-',0),(4,'rsdfsd','343d9040a671c45832ee5381860e2996','fsdfs','','','',0,NULL,1,1508392024923,'-',0);
/*!40000 ALTER TABLE `tbl_emp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_emp_role`
--

DROP TABLE IF EXISTS `tbl_emp_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_emp_role` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `empUuid` bigint(20) DEFAULT NULL,
  `roleUuid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_emp_role`
--

LOCK TABLES `tbl_emp_role` WRITE;
/*!40000 ALTER TABLE `tbl_emp_role` DISABLE KEYS */;
INSERT INTO `tbl_emp_role` VALUES (1,1,1),(2,2,2),(3,3,1),(4,4,1);
/*!40000 ALTER TABLE `tbl_emp_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_menu`
--

DROP TABLE IF EXISTS `tbl_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_menu` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `url` varchar(255) NOT NULL,
  `puuid` bigint(20) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_menu`
--

LOCK TABLES `tbl_menu` WRITE;
/*!40000 ALTER TABLE `tbl_menu` DISABLE KEYS */;
INSERT INTO `tbl_menu` VALUES (1,'系统菜单','-',0),(2,'基础维护','-',1),(3,'员工维护','emp_list',2),(4,'部门维护','dep_list',2),(5,'角色维护','role_list',2),(6,'资源维护','res_list',2),(7,'菜单维护','menu_list',2),(8,'数据维护','-',1),(9,'数据上传','upload_page',8),(10,'848数据','data848_list',8),(11,'1024数据','data1024_list',8);
/*!40000 ALTER TABLE `tbl_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_res`
--

DROP TABLE IF EXISTS `tbl_res`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_res` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `url` varchar(255) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_res`
--

LOCK TABLES `tbl_res` WRITE;
/*!40000 ALTER TABLE `tbl_res` DISABLE KEYS */;
INSERT INTO `tbl_res` VALUES (1,'员工添加','com.bxp.kjkj.auth.emp.web.EmpAction.input');
/*!40000 ALTER TABLE `tbl_res` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_role`
--

DROP TABLE IF EXISTS `tbl_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_role` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `code` varchar(30) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_role`
--

LOCK TABLES `tbl_role` WRITE;
/*!40000 ALTER TABLE `tbl_role` DISABLE KEYS */;
INSERT INTO `tbl_role` VALUES (1,'系统管理员','admin'),(2,'服务人员','fuwu');
/*!40000 ALTER TABLE `tbl_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_role_menu`
--

DROP TABLE IF EXISTS `tbl_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_role_menu` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleUuid` bigint(20) NOT NULL,
  `menuUuid` bigint(20) NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_role_menu`
--

LOCK TABLES `tbl_role_menu` WRITE;
/*!40000 ALTER TABLE `tbl_role_menu` DISABLE KEYS */;
INSERT INTO `tbl_role_menu` VALUES (8,2,4),(9,2,3),(10,2,2),(24,2,8),(97,2,9),(105,1,7),(106,1,4),(107,1,5),(108,1,2),(109,1,3),(110,1,8),(112,1,9),(113,1,6),(116,1,10),(117,1,11);
/*!40000 ALTER TABLE `tbl_role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_role_res`
--

DROP TABLE IF EXISTS `tbl_role_res`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_role_res` (
  `uuid` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleUuid` bigint(20) DEFAULT NULL,
  `resUuid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_role_res`
--

LOCK TABLES `tbl_role_res` WRITE;
/*!40000 ALTER TABLE `tbl_role_res` DISABLE KEYS */;
INSERT INTO `tbl_role_res` VALUES (8,1,1);
/*!40000 ALTER TABLE `tbl_role_res` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-08  1:08:42
