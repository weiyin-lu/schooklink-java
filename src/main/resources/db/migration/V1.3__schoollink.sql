-- MySQL dump 10.13  Distrib 5.7.36, for Win64 (x86_64)
--
-- Host: localhost    Database: schoollink
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `dictionary`
--

DROP TABLE IF EXISTS `dictionary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dictionary` (
  `dic_id` int NOT NULL AUTO_INCREMENT COMMENT '数据角度唯一性ID',
  `dic_type` varchar(50) NOT NULL COMMENT '字典类型编码',
  `dic_key` varchar(50) NOT NULL COMMENT '字典编码',
  `dic_value` varchar(100) NOT NULL COMMENT '字典编码值',
  PRIMARY KEY (`dic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dictionary`
--

LOCK TABLES `dictionary` WRITE;
/*!40000 ALTER TABLE `dictionary` DISABLE KEYS */;
INSERT INTO `dictionary` VALUES (1,'gender','1','男'),(2,'gender','2','女'),(3,'user_type','1','老师'),(4,'user_type','2','家长'),(5,'user_type','3','学生'),(6,'grade','202301','23-1班'),(7,'grade','202302','23-2班'),(8,'grade','202303','23-3班'),(9,'grade','202304','23-4班'),(10,'grade','202305','强化班'),(11,'gender','3','保密'),(12,'grade','000000','未分配'),(13,'grade','202001','20-1班');
/*!40000 ALTER TABLE `dictionary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flyway_schema_history`
--

DROP TABLE IF EXISTS `flyway_schema_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flyway_schema_history` (
  `installed_rank` int NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flyway_schema_history`
--

LOCK TABLES `flyway_schema_history` WRITE;
/*!40000 ALTER TABLE `flyway_schema_history` DISABLE KEYS */;
INSERT INTO `flyway_schema_history` VALUES (1,'1.0','schoollink','SQL','V1_0__schoollink.sql',845334615,'root','2023-10-15 04:44:46',2539,1),(2,'1.1','schoollink','SQL','V1.1__schoollink.sql',1059819363,'root','2023-10-15 05:35:19',1887,1),(3,'1.2','schoollink','SQL','V1.2__schoollink.sql',1460170174,'root','2023-10-15 08:30:16',2732,1);
/*!40000 ALTER TABLE `flyway_schema_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parents`
--

DROP TABLE IF EXISTS `parents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parents` (
  `parents_id` int NOT NULL AUTO_INCREMENT COMMENT '数据角度唯一性ID',
  `parent_unique_id` varchar(32) NOT NULL COMMENT '家长编号，业务角度唯一性ID',
  `parent_name` varchar(100) NOT NULL COMMENT '家长姓名',
  `gender` varchar(10) NOT NULL COMMENT '家长性别',
  `contact_email` varchar(100) DEFAULT NULL COMMENT '家长联系邮箱',
  `contact_phone` varchar(15) NOT NULL COMMENT '家长联系电话',
  `is_delete` int NOT NULL DEFAULT '0' COMMENT '逻辑删除标识',
  PRIMARY KEY (`parents_id`),
  UNIQUE KEY `parents_un` (`parent_unique_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parents`
--

LOCK TABLES `parents` WRITE;
/*!40000 ALTER TABLE `parents` DISABLE KEYS */;
INSERT INTO `parents` VALUES (1,'JZ010101','江离','1','JZ010101@school.com','13841877783',0),(2,'JZ010102','秦乱','1','JZ010102@school.com','13841877784',0),(3,'JZ010103','白恒图','1','JZ010103@school.com','13841877785',0),(4,'JZ010104','李二','1','JZ010104@school.com','13841877786',0),(5,'JZ010105','袁五行','1','JZ010151@school.com','13841877787',0);
/*!40000 ALTER TABLE `parents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `students` (
  `student_id` int NOT NULL AUTO_INCREMENT COMMENT '数据角度唯一性ID',
  `student_unique_id` varchar(32) NOT NULL COMMENT '学号，业务角度唯一性ID',
  `student_name` varchar(100) NOT NULL COMMENT '学生姓名',
  `birthdate` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '学生生日',
  `contact_email` varchar(100) DEFAULT NULL COMMENT '学生邮箱',
  `contact_phone` varchar(15) DEFAULT NULL COMMENT '学生手机号',
  `gender` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学生性别编码',
  `parents` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '负责家长业务唯一性ID',
  `grade` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '所在班级编码',
  `is_delete` int NOT NULL DEFAULT '0' COMMENT '逻辑删除标识',
  PRIMARY KEY (`student_id`),
  UNIQUE KEY `students_un` (`student_unique_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1,'XS000001','张大虎','20170401',NULL,NULL,'1','JZ010101','202301',0),(2,'XS000002','张小虎','20170106',NULL,NULL,'1','JZ010101','202301',0),(3,'XS000003','王花花','20180307',NULL,NULL,'2','JZ010102','202302',0),(4,'XS000004','李四','20170806',NULL,NULL,'1','JZ010103','202303',0),(5,'XS000005','方正','20170904',NULL,NULL,'2','JZ010105','202304',0),(6,'XS000006','福华','20170515',NULL,NULL,'1','JZ010104','202305',0),(7,'XS000007','公孙刘洪','20160703',NULL,NULL,'1',NULL,'202302',0),(8,'XS000008','测试用户1',NULL,NULL,NULL,'3',NULL,'000000',0);
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teachers`
--

DROP TABLE IF EXISTS `teachers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teachers` (
  `teacher_id` int NOT NULL AUTO_INCREMENT COMMENT '数据角度唯一性ID',
  `teacher_unique_id` varchar(100) NOT NULL COMMENT '工号，业务角度唯一性ID',
  `teacher_name` varchar(100) NOT NULL COMMENT '教师姓名',
  `gender` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '教师性别编码',
  `contact_email` varchar(100) DEFAULT NULL COMMENT '教师联系邮箱',
  `grade` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '所在班级编码',
  `contact_phone` varchar(100) NOT NULL COMMENT '教师联系电话',
  `is_delete` int NOT NULL DEFAULT '0' COMMENT '逻辑删除标识',
  PRIMARY KEY (`teacher_id`),
  UNIQUE KEY `teachers_un` (`teacher_unique_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachers`
--

LOCK TABLES `teachers` WRITE;
/*!40000 ALTER TABLE `teachers` DISABLE KEYS */;
INSERT INTO `teachers` VALUES (1,'JS010102','张老师','1','JS01@school.com','202301','17151141151',0),(2,'JS010103','王老师','2','JS02@school.com','202302','17151141152',0),(3,'JS010104','李主任','1','JS03@school.com','202303','17151141153',0),(4,'JS010105','阎教授','2','JS04@school.com','202304','17151141154',0),(5,'JS010106','刘老师','1','JS05@school.com','202305','17151141155',0),(6,'JS010107','宫老师','string','string','string','string',0);
/*!40000 ALTER TABLE `teachers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '数据角度唯一性ID',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(128) NOT NULL COMMENT '密码',
  `user_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户角色编码',
  `is_delete` int NOT NULL DEFAULT '0' COMMENT '逻辑删除标识',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `users_un` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'XS000001','123456','3',0),(2,'XS000002','123456','3',0),(3,'XS000003','123456','3',0),(4,'XS000004','123456','3',0),(5,'XS000005','123456','3',0),(6,'XS000006','123456','3',0),(7,'XS000007','123456','3',0),(8,'JS010102','123456','1',0),(9,'JS010103','123456','1',0),(10,'JS010104','123456','1',0),(11,'JS010105','123456','1',0),(12,'JS010106','123456','1',0),(13,'JS010107','123456','1',0),(14,'JZ010101','123456','2',0),(15,'JZ010102','123456','2',0),(16,'JZ010103','123456','2',0),(17,'JZ010104','123456','2',0),(18,'JZ010105','123456','2',0),(19,'XS000008','123456','3',0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'schoollink'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-22 20:04:33
