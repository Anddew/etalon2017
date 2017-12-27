CREATE DATABASE  IF NOT EXISTS `netcrackerappdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `netcrackerappdb`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: netcrackerappdb
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `admins`
--

DROP TABLE IF EXISTS `admins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admins` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL,
  `email` varchar(25) NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `admins_id_uindex` (`userId`),
  UNIQUE KEY `admins_user_name_uindex` (`user_name`),
  UNIQUE KEY `admins_email_uindex` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admins`
--

LOCK TABLES `admins` WRITE;
/*!40000 ALTER TABLE `admins` DISABLE KEYS */;
/*!40000 ALTER TABLE `admins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `companies`
--

DROP TABLE IF EXISTS company;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `companies` (
  `userId` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `companies`
--

LOCK TABLES company WRITE;
/*!40000 ALTER TABLE company DISABLE KEYS */;
INSERT INTO company VALUES (1,'NetCracker'),(2,'EPAM'),(3,'SkyWind'),(4,'Интеграл'),(5,'БелТелеКом');
/*!40000 ALTER TABLE company ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculties`
--

DROP TABLE IF EXISTS faculty;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `faculties` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `university_id` int(11) NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `fk_university_idx` (`university_id`),
  CONSTRAINT `fk_university` FOREIGN KEY (`university_id`) REFERENCES university (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculties`
--

LOCK TABLES faculty WRITE;
/*!40000 ALTER TABLE faculty DISABLE KEYS */;
INSERT INTO faculty VALUES (1,'ФПМ',1),(2,'ФизФак',1),(3,'ФРКТ',1),(4,'МехМатФак',1),(5,'ФКП',2),(6,'ФКСиС',2),(7,'ФИТУ',2),(8,'КТ',2),(9,'МТФ',3),(10,'ФИТР',3),(11,'ПСФ',3);
/*!40000 ALTER TABLE faculty ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `headsfromcompany`
--

DROP TABLE IF EXISTS `headsfromcompany`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `headsfromcompany` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(16) NOT NULL,
  `password` varchar(32) NOT NULL,
  `email` varchar(255) NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `company_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `company_idx` (`company_id`),
  CONSTRAINT `fk_companies` FOREIGN KEY (`company_id`) REFERENCES company (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `headsfromcompany`
--

LOCK TABLES `headsfromcompany` WRITE;
/*!40000 ALTER TABLE `headsfromcompany` DISABLE KEYS */;
/*!40000 ALTER TABLE `headsfromcompany` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `headsfromuniversity`
--

DROP TABLE IF EXISTS `headsfromuniversity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `headsfromuniversity` (
  `userId` int(11) NOT NULL,
  `user_name` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL,
  `email` varchar(25) NOT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `first_name` varchar(15) DEFAULT NULL,
  `last_name` varchar(15) DEFAULT NULL,
  `faculty_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `headfromuniversity_user_name_uindex` (`user_name`),
  UNIQUE KEY `headfromuniversity_email_uindex` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `headsfromuniversity`
--

LOCK TABLES `headsfromuniversity` WRITE;
/*!40000 ALTER TABLE `headsfromuniversity` DISABLE KEYS */;
/*!40000 ALTER TABLE `headsfromuniversity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requests`
--

DROP TABLE IF EXISTS practice;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `requests` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `check_status` tinyint(1) NOT NULL,
  `student_required_count` int(11) NOT NULL,
  `faculty_id` int(11) NOT NULL,
  `min_avg_score` double DEFAULT NULL,
  `required_no_allocation` tinyint(1) DEFAULT NULL,
  `date_start` date NOT NULL,
  `date_end` date NOT NULL,
  `education_form` enum('FULL_TIME','PART_TIME','DISTANCE') DEFAULT NULL,
  PRIMARY KEY (`userId`),
  KEY `faculty_id_idx` (`faculty_id`),
  CONSTRAINT `faculty_id` FOREIGN KEY (`faculty_id`) REFERENCES faculty (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requests`
--

LOCK TABLES practice WRITE;
/*!40000 ALTER TABLE practice DISABLE KEYS */;
INSERT INTO practice VALUES (1,0,2,6,NULL,NULL,'0000-00-00','0000-00-00',NULL),(3,0,1,7,NULL,NULL,'0000-00-00','0000-00-00',NULL);
/*!40000 ALTER TABLE practice ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requestsstudents`
--

DROP TABLE IF EXISTS practice_student;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `requestsstudents` (
  `student_id` int(11) NOT NULL,
  `request_id` int(11) NOT NULL,
  PRIMARY KEY (`student_id`,`request_id`),
  KEY `fk_request_idx` (`request_id`),
  CONSTRAINT `fk_request` FOREIGN KEY (`request_id`) REFERENCES practice (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_student` FOREIGN KEY (`student_id`) REFERENCES user (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requestsstudents`
--

LOCK TABLES practice_student WRITE;
/*!40000 ALTER TABLE practice_student DISABLE KEYS */;
/*!40000 ALTER TABLE practice_student ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `specialities`
--

DROP TABLE IF EXISTS speciality;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `specialities` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `faculty_id` int(11) NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `fk_faculty_idx` (`faculty_id`),
  CONSTRAINT `fk_faculty` FOREIGN KEY (`faculty_id`) REFERENCES faculty (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `specialities`
--

LOCK TABLES speciality WRITE;
/*!40000 ALTER TABLE speciality DISABLE KEYS */;
INSERT INTO speciality VALUES (1,'Прикладная математика',1),(2,'Информатика',1),(3,'Компьютерная безопасность',1),(4,'Физика',2),(5,'Компьютерная физика',2),(6,'Ядерная физика',2),(7,'Прикладная информатика',3),(8,'Радиофизика',3),(9,'Электроника',3),(10,'Математика',4),(11,'Компьютерная математика',4),(12,'Математическое моделирование',4),(13,'Математика и информатика',4),(14,'Электронные системы безопасности',5),(15,'Программируемые мобильные системы',5),(16,'Информационные системы и технологии',5),(17,'Программное обеспечение',6),(18,'Вычислительные машины,системы и сети',6),(19,'Электронные вычислительные средства',6),(20,'Промышленная электроника',7),(21,'Информационные технологии и управление',7),(22,'Искусственный интеллект',7),(23,'Программное обеспечение ИТ систем',8),(24,'Компьютерная графика',8),(25,'Электроника автомобиля',8),(26,'Машины и технология обработки материалов',9),(27,'Машины и технология литейного производства',9),(28,'Промышленные роботы и комплексы',10),(29,'Автоматизация технологических процессов',10),(30,'Программное обеспечение систем',10),(31,'Информационно-измерительная техника',11),(32,'Техническое обеспечение безопасности',11),(33,'Микро- и наносистемная техника',11);
/*!40000 ALTER TABLE speciality ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS user;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `students` (
  `userId` int(11) NOT NULL,
  `user_name` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL,
  `email` varchar(25) NOT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `first_name` varchar(15) DEFAULT NULL,
  `last_name` varchar(15) DEFAULT NULL,
  `education_form` enum('Full-Time','Part-Time','Evening','Distance') NOT NULL,
  `speciality_id` int(11) NOT NULL,
  `group_number` int(11) NOT NULL,
  `avg_score` double NOT NULL,
  `required_job` tinyint(1) NOT NULL,
  `practice_status` enum('Available','Waiting','On practice') NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `students_user_name_uindex` (`user_name`),
  UNIQUE KEY `students_password_uindex` (`password`),
  UNIQUE KEY `students_email_uindex` (`email`),
  KEY `speciality_id_idx` (`speciality_id`),
  CONSTRAINT `speciality_id` FOREIGN KEY (`speciality_id`) REFERENCES speciality (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

--
-- Table structure for table `universities`
--

DROP TABLE IF EXISTS university;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `universities` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `universities`
--

LOCK TABLES university WRITE;
/*!40000 ALTER TABLE university DISABLE KEYS */;
INSERT INTO university VALUES (1,'БГУ'),(2,'БГУИР'),(3,'БНТУ');
/*!40000 ALTER TABLE university ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-27 21:47:02
