-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: database_1
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `admindata`
--

DROP TABLE IF EXISTS `admindata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admindata` (
  `username` varchar(10) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admindata`
--

LOCK TABLES `admindata` WRITE;
/*!40000 ALTER TABLE `admindata` DISABLE KEYS */;
INSERT INTO `admindata` VALUES ('admin','12345678');
/*!40000 ALTER TABLE `admindata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking_data`
--

DROP TABLE IF EXISTS `booking_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking_data` (
  `booking_id` int NOT NULL,
  `username` varchar(45) NOT NULL,
  `uid` varchar(45) NOT NULL,
  `fid` varchar(45) NOT NULL,
  `number_of_passengers` double NOT NULL,
  `total_cost` varchar(45) NOT NULL,
  `booking_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`booking_id`),
  UNIQUE KEY `_id_UNIQUE` (`booking_id`),
  KEY `user_key1` (`uid`),
  KEY `flight_foreign_key` (`fid`),
  CONSTRAINT `flight_foreign_key` FOREIGN KEY (`fid`) REFERENCES `flightdata` (`id`),
  CONSTRAINT `user_key1` FOREIGN KEY (`uid`) REFERENCES `userdao` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking_data`
--

LOCK TABLES `booking_data` WRITE;
/*!40000 ALTER TABLE `booking_data` DISABLE KEYS */;
INSERT INTO `booking_data` VALUES (71836043,'Adhhu','A19','J9 KT64',1,'5000.0','2023-08-07 14:13:33'),(82175536,'Pratham','27','J9 KT64',1,'5000.0','2023-08-05 20:14:57');
/*!40000 ALTER TABLE `booking_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flightdata`
--

DROP TABLE IF EXISTS `flightdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flightdata` (
  `id` varchar(10) NOT NULL,
  `flightname` varchar(45) NOT NULL,
  `fromd` varchar(45) NOT NULL,
  `tod` varchar(45) NOT NULL,
  `departuredate` date NOT NULL,
  `departuretime` varchar(45) NOT NULL,
  `arrivaldate` date NOT NULL,
  `arrivaltime` varchar(45) NOT NULL,
  `duration` varchar(45) NOT NULL,
  `no_of_seat` int NOT NULL,
  `cost_per_seat` double NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flightdata`
--

LOCK TABLES `flightdata` WRITE;
/*!40000 ALTER TABLE `flightdata` DISABLE KEYS */;
INSERT INTO `flightdata` VALUES ('J9 KT64','Indigo','hyderabad','bhopal','2023-08-09','19:13','2023-08-10','00:10','4 hours',117,5000),('O8 ET31','Indigo','indore','hyderabad','2023-08-03','19:12','2023-08-04','19:12','24 hours',188,2000);
/*!40000 ALTER TABLE `flightdata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_data`
--

DROP TABLE IF EXISTS `payment_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment_data` (
  `transaction_id` varchar(19) NOT NULL,
  `user_id` varchar(45) NOT NULL,
  `flight_id` varchar(45) NOT NULL,
  `book_id` int NOT NULL,
  `fullname` varchar(45) NOT NULL,
  `card_number` varchar(45) NOT NULL,
  `cvv` int NOT NULL,
  `expiry_date` varchar(45) NOT NULL,
  `Date_of_payment` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `amount_paid` double NOT NULL,
  PRIMARY KEY (`transaction_id`,`book_id`),
  UNIQUE KEY `transaction_id_UNIQUE` (`transaction_id`),
  KEY `adding_foreing_key` (`flight_id`),
  KEY `user_key` (`user_id`),
  CONSTRAINT `adding_foreing_key` FOREIGN KEY (`flight_id`) REFERENCES `flightdata` (`id`),
  CONSTRAINT `user_key` FOREIGN KEY (`user_id`) REFERENCES `userdao` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_data`
--

LOCK TABLES `payment_data` WRITE;
/*!40000 ALTER TABLE `payment_data` DISABLE KEYS */;
INSERT INTO `payment_data` VALUES ('1OwT1A5VFkMQVB69jv','27','J9 KT64',82175536,'Pratham','123456789',123,'03/26','2023-08-05 00:00:00',5000),('ImzGtqbIpPiFjKjhtR','A19','J9 KT64',71836043,'Adhyan','1231123213123',123,'06/28','2023-08-07 00:00:00',5000),('Olht822buCRszlF24T','A21','J9 KT64',1745110,'Jeevika','1234 45645',123,'01/27','2023-08-03 00:00:00',5000);
/*!40000 ALTER TABLE `payment_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userdao`
--

DROP TABLE IF EXISTS `userdao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userdao` (
  `user_id` varchar(10) NOT NULL,
  `username` varchar(45) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `date_of_birth` date NOT NULL,
  `gender` varchar(45) NOT NULL,
  `phone_no` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `registered_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`,`username`,`email`,`phone_no`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userdao`
--

LOCK TABLES `userdao` WRITE;
/*!40000 ALTER TABLE `userdao` DISABLE KEYS */;
INSERT INTO `userdao` VALUES ('27','Pratham','Prathmesh','Vairale','2002-08-27','male','1234567890','prathmesh@gmail.com','123456','2023-07-02 12:53:04'),('52761','Rohit','Sfa','Mehra','2023-08-03','female','1234567890','rohit@gmail.com','12345678','2023-08-07 18:10:58'),('58735','Saniya','Saniya','Mehra','2023-08-18','female','1234567890','saniya@gmail.com','12345678','2023-08-07 18:06:30'),('A19','Adhhu','Adhyan','Talwad','2004-01-19','male','1234567890','adhyan@gmail.com','123456','2023-07-02 12:53:04'),('A21','Jivi','Jeevika','Patanker','2003-08-21','female','1234567890','jeevika@gmail.com','123456','2023-07-02 12:53:04');
/*!40000 ALTER TABLE `userdao` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-22 19:15:25
