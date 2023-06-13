-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: mazequizu
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (2);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jugador`
--

DROP TABLE IF EXISTS `jugador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jugador` (
  `jugID` int NOT NULL AUTO_INCREMENT,
  `jug_nombre` varchar(45) NOT NULL,
  `jug_apellido_pat` varchar(45) NOT NULL,
  `jug_apellido_mat` varchar(45) NOT NULL,
  `jug_carrera` varchar(45) NOT NULL,
  `jug_puntaje` int NOT NULL,
  `jug_password` varchar(45) NOT NULL,
  PRIMARY KEY (`jugID`),
  UNIQUE KEY `jug_id_UNIQUE` (`jugID`)
) ENGINE=InnoDB AUTO_INCREMENT=42353452 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jugador`
--

LOCK TABLES `jugador` WRITE;
/*!40000 ALTER TABLE `jugador` DISABLE KEYS */;
INSERT INTO `jugador` VALUES (1321313,'Guadalupe','Ruelas','Sandoval','IEI',0,'2347'),(2313133,'Jose','Yañes','Lopez','IEI',0,'3588953'),(13241412,'Aldo','Navarro','Medina','IEI',0,'232323'),(20202225,'David','Vallejo','Ortiz','ITC',0,'123'),(20202226,'Zayra','Avelar','Jaime','ITC',7,'123123'),(20202227,'Dago','Salamanca','Puentes','IEI',7,'33231'),(20202228,'Diego','Salamanca ','Puentes','ITC',0,'13213'),(20202244,'Katy','Romo','Lopez','ITC',2,'23131'),(20202245,'Cesar','Murillo','Figueroa','IER',2,'1233223'),(23131313,'Claudia','Rivera','Romero','MTC',0,'4434434'),(42353445,'Ulises','Lopez','Orozco','MTC',0,'324242');
/*!40000 ALTER TABLE `jugador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pregunta`
--

DROP TABLE IF EXISTS `pregunta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pregunta` (
  `pregID` int NOT NULL AUTO_INCREMENT,
  `preg_decrip` varchar(45) NOT NULL,
  `preg_valor` int NOT NULL,
  PRIMARY KEY (`pregID`),
  UNIQUE KEY `PRE_ID_UNIQUE` (`pregID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pregunta`
--

LOCK TABLES `pregunta` WRITE;
/*!40000 ALTER TABLE `pregunta` DISABLE KEYS */;
INSERT INTO `pregunta` VALUES (1,'Lenguaje de consulta mas común',5),(2,'Son estándares de cable UTP:',5),(3,'Se puede describir como puente multipuerto.',5),(4,'Es una capa del modelo TCP/IP.',5),(5,'¿Lenguaje de progrmación orientado a objetos?',10),(6,'Está compuesta de 4 octetos.',5),(8,'¿Cuál de los siguientes es un DBMS?',4),(9,'Compuesto de unos y ceros:',5),(10,'Dispositivo que almacena información/energía.',5),(11,'¿Cuál es una compuerta logica?',5),(12,'¿Cuáles son los tipos de cables UTP?',5),(13,'Fue el primer compilador:',5),(14,'¿Como se implementan los lenguajes?',5),(15,'Es el simbolo que representa la resistencia:',5),(17,'Unidad de la medida de la resistencia.',5);
/*!40000 ALTER TABLE `pregunta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quiz`
--

DROP TABLE IF EXISTS `quiz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quiz` (
  `id_quiz` int NOT NULL AUTO_INCREMENT,
  `pregid` int NOT NULL,
  `resid` int NOT NULL,
  `quiz_value` int NOT NULL,
  PRIMARY KEY (`id_quiz`),
  UNIQUE KEY `id_quiz_UNIQUE` (`id_quiz`),
  KEY `pregid` (`pregid`),
  KEY `res_idx` (`resid`),
  CONSTRAINT `preg` FOREIGN KEY (`pregid`) REFERENCES `pregunta` (`pregID`),
  CONSTRAINT `res` FOREIGN KEY (`resid`) REFERENCES `respuesta` (`resID`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quiz`
--

LOCK TABLES `quiz` WRITE;
/*!40000 ALTER TABLE `quiz` DISABLE KEYS */;
INSERT INTO `quiz` VALUES (10,1,1,1),(12,1,3,0),(13,1,6,0),(14,1,7,0),(15,2,1,0),(16,2,2,0),(17,2,3,0),(18,2,4,1),(19,3,5,1),(20,3,6,0),(21,3,7,0),(22,3,1,0),(23,4,2,0),(24,4,3,0),(25,4,7,1),(26,4,5,0),(27,5,7,0),(28,5,2,1),(29,5,1,0),(30,5,9,0),(31,6,3,0),(32,6,5,0),(33,6,7,1),(34,6,6,0),(35,8,6,1),(36,8,5,0),(37,8,8,0),(38,8,1,0),(39,9,2,0),(40,9,9,1),(41,9,1,0),(42,9,6,0),(43,10,8,0),(44,10,4,0),(45,10,5,0),(46,10,10,1),(47,11,10,0),(48,11,9,0),(49,11,11,1),(50,11,4,0),(51,12,12,1),(52,12,4,0),(53,12,5,0),(54,12,7,0),(55,13,11,0),(56,13,13,1),(57,13,8,0),(58,13,1,0),(59,14,3,0),(60,14,12,0),(61,14,4,0),(62,14,14,1),(63,15,10,0),(64,15,7,0),(65,15,15,1),(70,15,11,0),(71,17,1,0),(72,17,7,0),(73,17,15,0),(74,17,16,1);
/*!40000 ALTER TABLE `quiz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `respuesta`
--

DROP TABLE IF EXISTS `respuesta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `respuesta` (
  `resID` int NOT NULL AUTO_INCREMENT,
  `res_descript` varchar(45) NOT NULL,
  PRIMARY KEY (`resID`),
  UNIQUE KEY `pregunta_UNIQUE` (`resID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `respuesta`
--

LOCK TABLES `respuesta` WRITE;
/*!40000 ALTER TABLE `respuesta` DISABLE KEYS */;
INSERT INTO `respuesta` VALUES (1,'SQL'),(2,'Java'),(3,'Internet'),(4,'T568A y T568B'),(5,'Switch'),(6,'MYSQL'),(7,'IP'),(8,'BDMS'),(9,'Codigo Binario'),(10,'Flip Flop'),(11,'NAND'),(12,'Directo y cruzado'),(13,'FORT RAN I'),(14,'Interpretes y compiladores'),(15,'Omega'),(16,'Ohms');
/*!40000 ALTER TABLE `respuesta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-10 21:30:31
