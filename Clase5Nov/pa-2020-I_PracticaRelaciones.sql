-- MySQL dump 10.13  Distrib 5.7.27, for Linux (x86_64)
--
-- Host: localhost    Database: practica_relaciones
-- ------------------------------------------------------
-- Server version	5.7.27-0ubuntu0.19.04.1

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
-- Table structure for table `marca_auto`
--

DROP TABLE IF EXISTS `marca_auto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marca_auto` (
  `marca_auto_id` int(10) unsigned NOT NULL,
  `marca_auto_nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`marca_auto_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marca_auto`
--

LOCK TABLES `marca_auto` WRITE;
/*!40000 ALTER TABLE `marca_auto` DISABLE KEYS */;
INSERT INTO `marca_auto` VALUES (1,'Ford'),(2,'Audi'),(3,'Volkswagen'),(4,'Nissan');
/*!40000 ALTER TABLE `marca_auto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sub_marca`
--

DROP TABLE IF EXISTS `sub_marca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sub_marca` (
  `sub_marca_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `sub_marca_nombre` varchar(45) NOT NULL,
  `marca_auto_marca_auto_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`sub_marca_id`),
  KEY `fk_sub_marca_marca_auto_idx` (`marca_auto_marca_auto_id`),
  CONSTRAINT `fk_sub_marca_marca_auto` FOREIGN KEY (`marca_auto_marca_auto_id`) REFERENCES `marca_auto` (`marca_auto_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sub_marca`
--

LOCK TABLES `sub_marca` WRITE;
/*!40000 ALTER TABLE `sub_marca` DISABLE KEYS */;
INSERT INTO `sub_marca` VALUES (1,'Fiesta',1),(2,'Fusion',1),(3,'Mustang',1),(4,'A1',2),(5,'A3',2),(6,'A4',2),(7,'TT',2),(8,'Polo',3),(9,'Gol',3),(10,'Vento',3),(11,'Jetta',3),(12,'Tsuru',4),(13,'Altima',4),(14,'Kicks',4),(15,'Sentra',4),(16,'Versa',4);
/*!40000 ALTER TABLE `sub_marca` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-28 10:52:00
