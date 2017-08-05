-- MySQL dump 10.13  Distrib 5.7.19, for Linux (x86_64)
--
-- Host: localhost    Database: upaj
-- ------------------------------------------------------
-- Server version	5.7.19-0ubuntu0.16.04.1

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_id` varchar(45) NOT NULL,
  `password` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'admin1@gmail.com','98a6bc2187754ce85ce0a99a7570b190'),(2,'admin2@gmail.com','98a6bc2187754ce85ce0a99a7570b190'),(3,'admin3@gmail.com','98a6bc2187754ce85ce0a99a7570b190'),(4,'admin4@gmail.com','98a6bc2187754ce85ce0a99a7570b190'),(5,'admin5@gmail.com','98a6bc2187754ce85ce0a99a7570b190');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `experts`
--

DROP TABLE IF EXISTS `experts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `experts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_id` varchar(45) NOT NULL,
  `password` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `experts`
--

LOCK TABLES `experts` WRITE;
/*!40000 ALTER TABLE `experts` DISABLE KEYS */;
INSERT INTO `experts` VALUES (1,'exp1@gmail.com','98a6bc2187754ce85ce0a99a7570b190'),(2,'exp2@gmail.com','98a6bc2187754ce85ce0a99a7570b190'),(3,'exp3@gmail.com','98a6bc2187754ce85ce0a99a7570b190'),(4,'exp4@gmail.com','98a6bc2187754ce85ce0a99a7570b190'),(5,'exp5@gmail.com','98a6bc2187754ce85ce0a99a7570b190');
/*!40000 ALTER TABLE `experts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requests`
--

DROP TABLE IF EXISTS `requests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `requests` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `expert_id` int(11) DEFAULT NULL,
  `notes` mediumtext,
  `is_spam` int(11) DEFAULT '0',
  `is_done` int(11) DEFAULT '0',
  `solution` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requests`
--

LOCK TABLES `requests` WRITE;
/*!40000 ALTER TABLE `requests` DISABLE KEYS */;
INSERT INTO `requests` VALUES (1,1,1,'kindly suggest',0,1,'jdjkjafdkjkjdnj\npradeep'),(2,1,1,'kindly suggest',0,1,'Check it guys, its awesome\npradeep'),(3,2,2,'kindly suggest',0,0,'will reach to you soon'),(4,3,2,'kindly suggest',0,0,'will reach to you soon'),(5,1,1,'kindly suggest',0,0,'kjdsfkvjdsnkjvnjskdhnvjn'),(6,3,2,'kindly suggest',0,0,'will reach to you soon'),(7,2,1,'kindly suggest',0,0,'will reach to you soon'),(8,1,2,'kindly suggest',0,0,'will reach to you soon'),(9,2,1,'kindly suggest',0,0,'will reach to you soon'),(10,3,2,'kindly suggest',0,0,'will reach to you soon'),(11,4,5,'ddkdb',0,0,NULL),(12,5,3,'dbdjdj',0,0,NULL),(13,6,3,'hi k',0,0,NULL),(14,7,1,'demo problem',0,0,NULL),(15,8,3,'demo problem',0,0,NULL),(16,9,4,'Hu my phone color is fading... What should I do',0,0,NULL),(17,10,3,'gghuhhyu',0,0,NULL),(18,11,2,'the guys are a little quite',0,0,'87984792');
/*!40000 ALTER TABLE `requests` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mobile` varchar(10) NOT NULL,
  `aadhar` varchar(45) DEFAULT NULL,
  `spam_count` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'9023936885','123456789012',0),(2,'9999388424','123456789012',0),(3,'7814226606','123456789012',0),(4,'',NULL,NULL),(5,'',NULL,0),(6,'1234567890',NULL,0),(7,'9999388424',NULL,0),(8,'9999388424',NULL,0),(9,'1234567890',NULL,0),(10,'1234567891',NULL,0),(11,'1234567890',NULL,0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-05 16:57:02
