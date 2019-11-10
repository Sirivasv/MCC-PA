-- MySQL dump 10.13  Distrib 5.7.27, for Linux (x86_64)
--
-- Host: localhost    Database: biblioteca
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
-- Table structure for table `autor`
--

DROP TABLE IF EXISTS `autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `autor` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autor`
--

LOCK TABLES `autor` WRITE;
/*!40000 ALTER TABLE `autor` DISABLE KEYS */;
INSERT INTO `autor` VALUES (1,'Howard Phillip ','Lovecraft '),(2,'Edgar Alan     ','Poe       '),(3,'Sthephen       ','King      '),(4,'Ray            ','Bradbury  '),(5,'Phillip K.     ','Dick      ');
/*!40000 ALTER TABLE `autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genero`
--

DROP TABLE IF EXISTS `genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genero` (
  `id_generos` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id_generos`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genero`
--

LOCK TABLES `genero` WRITE;
/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
INSERT INTO `genero` VALUES (1,'Terror'),(2,'SCI-FI'),(3,'Historia'),(4,'Literatura Universal');
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libro`
--

DROP TABLE IF EXISTS `libro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `libro` (
  `isbn` varchar(14) NOT NULL,
  `titulo` varchar(255) NOT NULL,
  `generos_id_generos` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY (`isbn`),
  KEY `fk_libros_generos_idx` (`generos_id_generos`),
  CONSTRAINT `fk_libros_generos` FOREIGN KEY (`generos_id_generos`) REFERENCES `genero` (`id_generos`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libro`
--

LOCK TABLES `libro` WRITE;
/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
INSERT INTO `libro` VALUES ('142437956','Los sueños en la casa de la bruja',1),('1451678193','Crónicas Marcianas',2),('1495227553','En las montañas de la locura',1),('1501142976','Eso',1),('1536919241','La llamada de Cthulhu',1),('307743667','Carrie',1),('345404475','¿Sueñan los androides con ovejas eléctricas?',2),('8471665018','Narraciones extraordinarias',1);
/*!40000 ALTER TABLE `libro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `privilegio`
--

DROP TABLE IF EXISTS `privilegio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `privilegio` (
  `priv_id` tinyint(3) unsigned NOT NULL,
  `priv_nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`priv_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `privilegio`
--

LOCK TABLES `privilegio` WRITE;
/*!40000 ALTER TABLE `privilegio` DISABLE KEYS */;
INSERT INTO `privilegio` VALUES (1,'registrar_publicacion'),(2,'registrar_libro'),(3,'registrar_autor'),(4,'buscar_libro'),(5,'buscar_autor'),(6,'buscar_publicacion');
/*!40000 ALTER TABLE `privilegio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publicacion`
--

DROP TABLE IF EXISTS `publicacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `publicacion` (
  `autor_id` tinyint(3) unsigned NOT NULL,
  `libro_isbn` varchar(14) NOT NULL,
  `anio_publicacion` date NOT NULL,
  PRIMARY KEY (`autor_id`,`libro_isbn`),
  KEY `fk_publicaciones_autores1_idx` (`autor_id`),
  KEY `fk_publicaciones_libros1_idx` (`libro_isbn`),
  KEY `autor_libro_idx` (`autor_id`,`libro_isbn`),
  CONSTRAINT `fk_publicaciones_autores1` FOREIGN KEY (`autor_id`) REFERENCES `autor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_publicaciones_libros1` FOREIGN KEY (`libro_isbn`) REFERENCES `libro` (`isbn`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publicacion`
--

LOCK TABLES `publicacion` WRITE;
/*!40000 ALTER TABLE `publicacion` DISABLE KEYS */;
INSERT INTO `publicacion` VALUES (1,'142437956','1933-07-01'),(1,'1495227553','1936-01-01'),(1,'1536919241','1928-02-01'),(2,'8471665018','1834-01-01'),(3,'1501142976','1986-09-15'),(3,'307743667','1974-04-05'),(4,'1451678193','1950-01-01'),(5,'345404475','1986-01-01');
/*!40000 ALTER TABLE `publicacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rol` (
  `rol_id` tinyint(3) unsigned NOT NULL,
  `rol_nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`rol_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'admin'),(2,'usuario');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol_has_privilegio`
--

DROP TABLE IF EXISTS `rol_has_privilegio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rol_has_privilegio` (
  `rol_rol_id` tinyint(3) unsigned NOT NULL,
  `privilegio_priv_id` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY (`rol_rol_id`,`privilegio_priv_id`),
  KEY `fk_rol_has_privilegio_privilegio1_idx` (`privilegio_priv_id`),
  KEY `fk_rol_has_privilegio_rol1_idx` (`rol_rol_id`),
  CONSTRAINT `fk_rol_has_privilegio_privilegio1` FOREIGN KEY (`privilegio_priv_id`) REFERENCES `privilegio` (`priv_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_rol_has_privilegio_rol1` FOREIGN KEY (`rol_rol_id`) REFERENCES `rol` (`rol_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol_has_privilegio`
--

LOCK TABLES `rol_has_privilegio` WRITE;
/*!40000 ALTER TABLE `rol_has_privilegio` DISABLE KEYS */;
INSERT INTO `rol_has_privilegio` VALUES (1,1),(1,2),(1,3),(1,4),(2,4),(1,5),(2,5),(1,6),(2,6);
/*!40000 ALTER TABLE `rol_has_privilegio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `mail` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido_paterno` varchar(45) NOT NULL,
  `apellido_materno` varchar(45) DEFAULT NULL,
  `telefono` varchar(12) NOT NULL,
  `admin` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`mail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('admin@libreria.com','password123','Administrador','Sistema','NULL','55555555',1),('grimheart@gmail.com','patito123','Gabriel','González','G','123456',0);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `vista_publicacion`
--

DROP TABLE IF EXISTS `vista_publicacion`;
/*!50001 DROP VIEW IF EXISTS `vista_publicacion`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `vista_publicacion` AS SELECT 
 1 AS `ISBN`,
 1 AS `Titulo`,
 1 AS `Autor`,
 1 AS `Genero`,
 1 AS `Fecha de publicacion`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `vista_publicacion`
--

/*!50001 DROP VIEW IF EXISTS `vista_publicacion`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vista_publicacion` AS select `l`.`isbn` AS `ISBN`,`l`.`titulo` AS `Titulo`,concat(`a`.`nombre`,' ',`a`.`apellido`) AS `Autor`,`g`.`nombre` AS `Genero`,`p`.`anio_publicacion` AS `Fecha de publicacion` from (((`publicacion` `p` join `autor` `a` on((`p`.`autor_id` = `a`.`id`))) join `libro` `l` on((`p`.`libro_isbn` = `l`.`isbn`))) join `genero` `g` on((`l`.`generos_id_generos` = `g`.`id_generos`))) order by `l`.`titulo` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-17 12:11:57
