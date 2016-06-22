-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: restaurantadvisor
-- ------------------------------------------------------
-- Server version	5.6.24

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
-- Table structure for table `addressdetails`
--

DROP TABLE IF EXISTS `addressdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `addressdetails` (
  `UserID` bigint(20) NOT NULL,
  `BlockNumber` varchar(255) DEFAULT NULL,
  `City` varchar(255) DEFAULT NULL,
  `Country` varchar(255) DEFAULT NULL,
  `State` varchar(255) DEFAULT NULL,
  `Street` varchar(255) DEFAULT NULL,
  `ZipCode` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addressdetails`
--

LOCK TABLES `addressdetails` WRITE;
/*!40000 ALTER TABLE `addressdetails` DISABLE KEYS */;
INSERT INTO `addressdetails` VALUES (2,'75','Boston','USA','Massachussetts','Saint Alphonsus Street','02120'),(3,'51','asasdasd asd','USA','MA','asa asd','02120'),(4,'75','Boston','USA','MA','Saint Alphonsus Street','02120'),(5,'200','Boston','USA','MA','Boylston Street','02116'),(6,'75','Boston','USA','MA','Saint ','02120'),(7,'606','Boston','USA','MA','Congress Street','02210'),(8,'75','Boston','USA','MA','Saint ','02120'),(9,'75','Boston','USA','MA','75 Saint Alphonsus Street','02120'),(11,'75','Boston','USA','MA','Saint','02120'),(12,'75','asdasd','USA','ma','dasd ','02120'),(13,'78','asdasd','USA','MA','asdsd asd','23154'),(14,'75','asdas','USA','MA','asd ','02120'),(15,'7','asd ','USA','MA','asd ','02012'),(16,'360','Boston','USA','MA','Huntington Avenue','02120');
/*!40000 ALTER TABLE `addressdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoteldetails`
--

DROP TABLE IF EXISTS `hoteldetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hoteldetails` (
  `UserID` bigint(20) NOT NULL,
  `AverageRating` double DEFAULT NULL,
  `CostFor2` int(11) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `HotelEmailContact` varchar(255) DEFAULT NULL,
  `HotelMobileContact` varchar(255) DEFAULT NULL,
  `HotelName` varchar(255) DEFAULT NULL,
  `HotelType` varchar(255) DEFAULT NULL,
  `TagLine` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoteldetails`
--

LOCK TABLES `hoteldetails` WRITE;
/*!40000 ALTER TABLE `hoteldetails` DISABLE KEYS */;
INSERT INTO `hoteldetails` VALUES (4,4.5,15,'amazing at its best','shahsmit14@gmail.com','8527419630','Boston Harbour','MULTI-CUISINE','harbour'),(5,0,85,'Family hotel','shahsmit14@gmail.com','7418529630','Four Season Hotel','MULTI-CUISINE','Enjoy to the core'),(7,0,852,'best in boston','shahsmit14@gmail.com','4561237980','Renaissance Boston','MULTI-CUISINE','Waterfront'),(16,0,15,'samundar asasd asd','shahsmit14@gmail.com','7894561328','Samudra','MULTI-CUISINE','samundar');
/*!40000 ALTER TABLE `hoteldetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logindetails`
--

DROP TABLE IF EXISTS `logindetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `logindetails` (
  `UserID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Password` varchar(255) DEFAULT NULL,
  `Status` varchar(255) DEFAULT NULL,
  `UserName` varchar(255) DEFAULT NULL,
  `RoleID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`UserID`),
  KEY `FK_69ye34urvhqiwr41d0j3ettk7` (`RoleID`),
  CONSTRAINT `FK_69ye34urvhqiwr41d0j3ettk7` FOREIGN KEY (`RoleID`) REFERENCES `userrole` (`RoleID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logindetails`
--

LOCK TABLES `logindetails` WRITE;
/*!40000 ALTER TABLE `logindetails` DISABLE KEYS */;
INSERT INTO `logindetails` VALUES (2,'kdXucAD5vW6yqA8ok8wU5w==','ACTIVE','User1234',2),(3,'C3H2QKPD5CT6UdMplBpJ1Q==','ACTIVE','User1235',2),(4,'5jcq+s6GAdAs9iPxsKGBJQ==','ACTIVE','Hotel123',3),(5,'yhoWtZKIBhXazLxnZWqBeQ==','ACTIVE','Hotel456',3),(6,'WgOQwyBojaa/UXq8RAGjdg==','DE-ACTIVE','User7890',2),(7,'vrPtiaKkES5mB5Kb69DAhA==','ACTIVE','Hotel147',3),(8,'Sr2jbNqFu0QNpVFP9myZTQ==','ACTIVE','KevinShah123',2),(9,'xNqP+83rIglwDk6yhdHGCw==','ACTIVE','KevinShah14',2),(11,'6v24Z/xZcgMZ2bpf+NV8Og==','ACTIVE','Vijay123',2),(12,'1NJli/aTRhIIjnD6C0dALA==','ACTIVE','KevinShah24',2),(13,'FloHTQSG/zCqdC3kCtGTMg==','ACTIVE','VijayShah09',2),(14,'h93b+c8x2Dr+ZLpPSkQHaw==','ACTIVE','Test1234',2),(15,'qRrJzV7M9+309A2Rff7l5Q==','ACTIVE','Test4567',2),(16,'dmYTcL6OOd9DqOxcmiveWQ==','ACTIVE','Hotel159',3),(17,'l/xBEEbLy6V8Zn+IHkNjRA==','ACTIVE','Admin123',1);
/*!40000 ALTER TABLE `logindetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menudetails`
--

DROP TABLE IF EXISTS `menudetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menudetails` (
  `MenuDetailsId` bigint(20) NOT NULL AUTO_INCREMENT,
  `Description` varchar(255) DEFAULT NULL,
  `Item` varchar(255) DEFAULT NULL,
  `Price` float DEFAULT NULL,
  `Status` varchar(255) DEFAULT NULL,
  `TimeStamp` datetime DEFAULT NULL,
  `UserID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`MenuDetailsId`),
  KEY `FK_t2s6hkyp2b5b4q12yokc6xlti` (`UserID`),
  CONSTRAINT `FK_t2s6hkyp2b5b4q12yokc6xlti` FOREIGN KEY (`UserID`) REFERENCES `logindetails` (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menudetails`
--

LOCK TABLES `menudetails` WRITE;
/*!40000 ALTER TABLE `menudetails` DISABLE KEYS */;
INSERT INTO `menudetails` VALUES (1,'Delicious potatotes','Pav Bhaji',35,'AVAILABLE',NULL,4),(2,'Delicious water ','Pani Puri',50,'AVAILABLE',NULL,4),(3,'bread latin style','Pizza',42,'AVAILABLE',NULL,4);
/*!40000 ALTER TABLE `menudetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderdetails`
--

DROP TABLE IF EXISTS `orderdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderdetails` (
  `OrderDetailsId` bigint(20) NOT NULL AUTO_INCREMENT,
  `Quantity` int(11) DEFAULT NULL,
  `MenuDetailsId` bigint(20) DEFAULT NULL,
  `OrderId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`OrderDetailsId`),
  KEY `FK_ek7536k6bsxwu602vxhxm1s0p` (`MenuDetailsId`),
  KEY `FK_7l7ektj83qf2sg6duhm97icsq` (`OrderId`),
  CONSTRAINT `FK_7l7ektj83qf2sg6duhm97icsq` FOREIGN KEY (`OrderId`) REFERENCES `ordertransaction` (`OrderId`),
  CONSTRAINT `FK_ek7536k6bsxwu602vxhxm1s0p` FOREIGN KEY (`MenuDetailsId`) REFERENCES `menudetails` (`MenuDetailsId`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderdetails`
--

LOCK TABLES `orderdetails` WRITE;
/*!40000 ALTER TABLE `orderdetails` DISABLE KEYS */;
INSERT INTO `orderdetails` VALUES (1,2,1,1),(2,2,2,1),(3,5,3,1),(4,1,1,1),(5,1,2,1),(6,1,3,1),(7,2,1,2),(8,2,2,4),(9,6,1,5),(10,6,2,5),(11,6,3,5),(12,1,1,6),(13,10,1,7),(14,10,2,7),(15,10,3,7);
/*!40000 ALTER TABLE `orderdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordertransaction`
--

DROP TABLE IF EXISTS `ordertransaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ordertransaction` (
  `OrderId` bigint(20) NOT NULL AUTO_INCREMENT,
  `OrderStatus` varchar(255) DEFAULT NULL,
  `OrderTimeStamp` datetime DEFAULT NULL,
  `TotalCost` float DEFAULT NULL,
  `CustomerUserID` bigint(20) DEFAULT NULL,
  `HotelUserID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`OrderId`),
  KEY `FK_sld9m642bemp39aotxwstl6tq` (`CustomerUserID`),
  KEY `FK_3u0x1kyd6norv2b8lau9citqo` (`HotelUserID`),
  CONSTRAINT `FK_3u0x1kyd6norv2b8lau9citqo` FOREIGN KEY (`HotelUserID`) REFERENCES `logindetails` (`UserID`),
  CONSTRAINT `FK_sld9m642bemp39aotxwstl6tq` FOREIGN KEY (`CustomerUserID`) REFERENCES `logindetails` (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordertransaction`
--

LOCK TABLES `ordertransaction` WRITE;
/*!40000 ALTER TABLE `ordertransaction` DISABLE KEYS */;
INSERT INTO `ordertransaction` VALUES (1,'ORDERED','2015-04-24 00:47:29',127,2,4),(2,'ORDERED','2015-04-24 00:52:37',70,2,4),(4,'ORDERED','2015-04-24 00:55:03',100,2,4),(5,'ORDERED','2015-04-24 01:20:02',762,2,4),(6,'ORDERED','2015-04-24 01:21:02',35,2,4),(7,'ORDERED','2015-04-24 01:44:50',1270,2,4);
/*!40000 ALTER TABLE `ordertransaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paymentdetails`
--

DROP TABLE IF EXISTS `paymentdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paymentdetails` (
  `UserID` bigint(20) NOT NULL,
  `CardName` varchar(255) DEFAULT NULL,
  `CardNumber` bigint(20) DEFAULT NULL,
  `CardType` varchar(255) DEFAULT NULL,
  `CCVNumber` int(11) DEFAULT NULL,
  `ExpiryDate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paymentdetails`
--

LOCK TABLES `paymentdetails` WRITE;
/*!40000 ALTER TABLE `paymentdetails` DISABLE KEYS */;
INSERT INTO `paymentdetails` VALUES (2,'Kevin Shah',1234567891012131,'CREDIT',475,'14/14/1456'),(3,'ad asd asd ',7418529630741852,'DEBIT',123,'12/12/1234'),(4,'harbour',7894561237894560,'CREDIT',456,'48/48/4852'),(5,'hotel four',7984561327894561,'DEBIT',123,'14/14/1444'),(6,'sonal shah',7894561237894560,'DEBIT',123,'14/14/1589'),(7,'Renaissance',1234567891234560,'DEBIT',123,'14/14/1458'),(8,'kevin shah',8527419637418520,'DEBIT',123,'14/14/1445'),(9,'kevin shah',8527419637418520,'DEBIT',123,'14/14/1445'),(10,'kevin shah',8527419637418520,'DEBIT',123,'14/14/1445'),(11,'Vijay Shah',7418529630741852,'DEBIT',741,'14/14/1485'),(12,'ad asd asd',7418529631789456,'DEBIT',123,'14/14/1485'),(13,'sdas asd ',7894561230789456,'DEBIT',123,'15/15/1598'),(14,'asd asd',7894561237894561,'DEBIT',123,'15/15/1596'),(15,'ada ad',7894561237894561,'DEBIT',789,'15/15/1596'),(16,'samudra ',7894561237894560,'DEBIT',456,'15/15/1596');
/*!40000 ALTER TABLE `paymentdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userdetails`
--

DROP TABLE IF EXISTS `userdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userdetails` (
  `UserID` bigint(20) NOT NULL,
  `contactNumber` varchar(255) DEFAULT NULL,
  `DateOfBirth` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `FirstName` varchar(255) DEFAULT NULL,
  `Gender` varchar(255) DEFAULT NULL,
  `LastName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userdetails`
--

LOCK TABLES `userdetails` WRITE;
/*!40000 ALTER TABLE `userdetails` DISABLE KEYS */;
INSERT INTO `userdetails` VALUES (1,'15975320','14-06-1990','smitshah14@gmail.com','Smit','Male','Shah'),(2,'7418529630','07/24/1987','shahsmit14@gmail.com','Kevin','MALE','Shah'),(3,'1234512345','14/14/1556','shahsmit14@gmail.com','12345','MALE','12345'),(6,'7899456123','89/78/7894','shahsmit14@gmail.com','Sonal','FEMALE','Shah'),(8,'7894561231','14/14/1478','shahsmit14@gmail.com','Kevin ','MALE','Shah'),(9,'8527419630','14/14/1478','shahsmit14@gmail.com','Kevin','MALE','Shah'),(11,'8527419630','14/14/1489','shahsmit14@gmail.com','Vijay','MALE','Shah'),(12,'8527419630','14/14/1489','shahsmit14@gmail.com','Kevin','MALE','Shah'),(13,'5154875326','15/15/1596','shahsmit14@gmail.com','Vijay','MALE','Shah'),(14,'1234567890','15/15/1598','shahsmit14@gmail.com','Test','MALE','Test'),(15,'7894651230','15/15/1598','shahsmit14@gmail.com','Test','MALE','Test'),(17,'15975320','14-06-1990','smitshah14@gmail.com','Smit','Male','Shah');
/*!40000 ALTER TABLE `userdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userreviews`
--

DROP TABLE IF EXISTS `userreviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userreviews` (
  `UserReviewId` bigint(20) NOT NULL AUTO_INCREMENT,
  `Rating` float DEFAULT NULL,
  `RatingTimeStamp` datetime DEFAULT NULL,
  `ReviewDescription` varchar(255) DEFAULT NULL,
  `ReviewHeadline` varchar(255) DEFAULT NULL,
  `ReviewedUserID` bigint(20) DEFAULT NULL,
  `ReviewerUserID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`UserReviewId`),
  KEY `FK_oy2dwoape9u1siwnva72lguj4` (`ReviewedUserID`),
  KEY `FK_23pnd03wkostbw6sgreavkqrj` (`ReviewerUserID`),
  CONSTRAINT `FK_23pnd03wkostbw6sgreavkqrj` FOREIGN KEY (`ReviewerUserID`) REFERENCES `logindetails` (`UserID`),
  CONSTRAINT `FK_oy2dwoape9u1siwnva72lguj4` FOREIGN KEY (`ReviewedUserID`) REFERENCES `logindetails` (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userreviews`
--

LOCK TABLES `userreviews` WRITE;
/*!40000 ALTER TABLE `userreviews` DISABLE KEYS */;
INSERT INTO `userreviews` VALUES (1,5,'2015-04-24 16:27:33','Excellent service','Excellent',4,2),(2,4,'2015-04-24 16:28:34','Amazing food items','Amazing food',4,2);
/*!40000 ALTER TABLE `userreviews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userrole`
--

DROP TABLE IF EXISTS `userrole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userrole` (
  `RoleID` bigint(20) NOT NULL AUTO_INCREMENT,
  `RoleType` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`RoleID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userrole`
--

LOCK TABLES `userrole` WRITE;
/*!40000 ALTER TABLE `userrole` DISABLE KEYS */;
INSERT INTO `userrole` VALUES (1,'ADMIN'),(2,'CUSTOMER'),(3,'HOTEL');
/*!40000 ALTER TABLE `userrole` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-04-24 16:31:49
