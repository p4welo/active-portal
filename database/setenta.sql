-- MySQL dump 10.13  Distrib 5.5.35, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: setenta
-- ------------------------------------------------------
-- Server version	5.5.35-0+wheezy1

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` varchar(32) NOT NULL,
  `name` varchar(128) NOT NULL,
  `code` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sid` (`sid`),
  UNIQUE KEY `code` (`code`),
  KEY `category_sid_idx` (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (6,'43632299f3434e0889c96b50c1168103','Zajęcia solo','solo'),(7,'53632299f3434e0889c96b50c1168103','Dzieci','dzieci'),(8,'5vm32299f3434e0889c96b50c1168103','Seniorzy','seniorzy'),(9,'5vm32299f3434e0889c96b50c1168nnn','Zajęcia w parach','pary'),(10,'5vm32299f3434e0889c96b50c1mcnnnn','Treningi formacji','formacje');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dance_class`
--

DROP TABLE IF EXISTS `dance_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dance_class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` varchar(32) NOT NULL,
  `style_id` int(11) NOT NULL,
  `instructor_id` int(11) DEFAULT NULL,
  `day` int(11) NOT NULL,
  `start_time` varchar(5) NOT NULL,
  `end_time` varchar(5) NOT NULL,
  `can_join` tinyint(1) NOT NULL DEFAULT '0',
  `can_register` tinyint(1) NOT NULL DEFAULT '1',
  `in_progress` tinyint(1) NOT NULL DEFAULT '0',
  `level` varchar(16) NOT NULL DEFAULT 'BEGINNER',
  `room_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sid` (`sid`),
  KEY `style_id` (`style_id`),
  KEY `instructor_id` (`instructor_id`),
  KEY `room_id` (`room_id`),
  KEY `dance_class_sid_idx` (`sid`),
  KEY `dance_class_day_idx` (`day`),
  CONSTRAINT `dance_class_ibfk_1` FOREIGN KEY (`style_id`) REFERENCES `style` (`id`) ON DELETE CASCADE,
  CONSTRAINT `dance_class_ibfk_2` FOREIGN KEY (`instructor_id`) REFERENCES `instructor` (`id`) ON DELETE CASCADE,
  CONSTRAINT `dance_class_ibfk_3` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dance_class`
--

LOCK TABLES `dance_class` WRITE;
/*!40000 ALTER TABLE `dance_class` DISABLE KEYS */;
INSERT INTO `dance_class` VALUES (61,'536789cnv34344vb89vjgh05hjvclakk',1,1,0,'11:00','12:00',0,0,1,'BEGINNER',4),(62,'736dd9cnv34344vb89vjgh05hjvclakk',1,1,0,'12:00','13:00',0,1,0,'BEGINNER',4),(63,'936789cnv34344vb89vjgh05hjvclakk',2,4,0,'17:00','17:45',0,0,1,'BEGINNER',4),(64,'5367czcnv34344vb89vjgh05hjvclakk',3,7,0,'18:30','19:30',1,0,1,'ADVANCED',4),(65,'736789hnv34344vb89vjgh05hjvclakk',4,1,0,'19:30','20:30',1,0,1,'INTERMEDIATE',4),(66,'336789hnv34344v1166jgh0jkjvclakk',4,1,0,'20:30','21:30',0,1,0,'BEGINNER',4),(67,'436789hnv3434jj1166jgh05hjvclakk',4,1,0,'21:30','22:30',1,0,1,'BEGINNER',4),(68,'536789hnv3434jj1214jgh05hjvnbvkk',5,1,1,'17:30','18:30',1,0,1,'INTERMEDIATE',4),(69,'ghj789hnv3434jj1166jgh043jvnbvkk',6,3,1,'18:30','19:30',1,0,1,'BEGINNER',4),(70,'aaj789hnv3434jj1166jt55hjtvnbvkk',4,1,1,'18:45','19:45',0,0,1,'ADVANCED',3),(71,'aaj789hnv3434jj1166jgvbnxzvnbvkk',4,4,1,'20:00','21:00',1,0,1,'INTERMEDIATE',4),(72,'fgtr89hnv3434jj1166jgvbngzvnbvkk',7,5,1,'21:00','22:00',0,1,0,'BEGINNER',4),(73,'abcd89hnv3434jj1166jgvbnxzvnbvkk',8,1,1,'21:30','24:00',0,0,1,'ADVANCED',4),(74,'bvgh89hnv3434jj1166jgvbnxzvczvkk',9,NULL,2,'17:00','18:00',0,1,0,'BEGINNER',4),(75,'kvlb89hnv3434jj1166jgvbnxzwqbvkk',10,5,2,'17:00','18:00',0,1,0,'BEGINNER',3),(76,'kvlbsdfgv3434jj1166jgvbrezvnbvkk',11,1,2,'19:30','20:30',1,0,1,'BEGINNER',4),(77,'hxlbsdfgv3434jj1166jgvbnxzvnbvkk',4,4,2,'19:30','20:30',1,0,1,'BEGINNER',3),(78,'qwebsdfgv3434jj1166jgvbnxnnvbvkk',12,1,2,'19:30','20:30',1,0,1,'ADVANCED',4),(79,'452fsdfgv3434jj1166jgvbnxzdfbvkk',4,NULL,2,'20:30','21:30',0,1,0,'BEGINNER',4),(80,'qwebsdfgv34vbhyt166jgvbnxzvnnkkk',4,1,2,'21:30','22:30',1,0,1,'ADVANCED',4),(81,'qwebsdfgv34vbh64756jgvbnxzvnnkkk',10,1,3,'16:30','17:15',1,0,1,'BEGINNER',4),(82,'qwebsdfgv34vbh64756j0plmxzvnnkkk',5,1,3,'17:30','18:30',1,0,1,'INTERMEDIATE',4),(83,'1468sdfgv34vbh64756j0plmxzvnnkkk',13,9,3,'19:30','20:30',1,0,1,'INTERMEDIATE',4),(84,'2466sdfgv34vbh64756j0plmxzvnnkkk',13,9,3,'20:30','21:30',1,0,1,'ADVANCED',4),(85,'3464sdfgv34vbh64756j0plmxzvnnkkk',4,4,3,'20:30','21:30',0,1,0,'BEGINNER',NULL),(86,'4466sdfgv34vbh64756j0plmxzvnnkkk',3,1,3,'21:30','22:30',0,0,1,'INTERMEDIATE',4),(87,'5466sd44v34vbh64756j0plmxzvnnkkk',14,1,4,'17:00','17:45',1,0,1,'BEGINNER',3),(88,'5466sd44v34v73jd756j0plmxzvnnkkk',15,9,4,'19:15','20:15',1,0,1,'BEGINNER',4),(89,'54839d44v34v73jd756j0plmxzvnnkkk',15,9,4,'20:15','21:15',1,0,1,'INTERMEDIATE',4),(90,'54839d44kclv73jd756j0plmxzvnnkkk',16,4,4,'21:15','22:15',0,0,1,'BEGINNER',4),(91,'73839d44kclv73jd756j0plmxzvnnkkk',5,1,5,'10:00','11:00',1,0,1,'INTERMEDIATE',4),(92,'73hdjd44kclv73jd756j0plmxzvnnkkk',2,NULL,5,'11:00','11:45',0,1,0,'BEGINNER',4),(93,'03999d44kclv73jd756j0plmxzvnnkkk',4,1,5,'16:00','17:00',0,1,0,'INTERMEDIATE',4);
/*!40000 ALTER TABLE `dance_class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `email`
--

DROP TABLE IF EXISTS `email`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `email` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` varchar(32) NOT NULL,
  `sender` varchar(64) NOT NULL,
  `subject` varchar(256) NOT NULL,
  `content` text NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sid` (`sid`),
  KEY `email_sid_idx` (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `email`
--

LOCK TABLES `email` WRITE;
/*!40000 ALTER TABLE `email` DISABLE KEYS */;
/*!40000 ALTER TABLE `email` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instructor`
--

DROP TABLE IF EXISTS `instructor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instructor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` varchar(32) NOT NULL,
  `first_name` varchar(64) NOT NULL,
  `last_name` varchar(64) DEFAULT NULL,
  `nick` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sid` (`sid`),
  KEY `instructor_sid_idx` (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructor`
--

LOCK TABLES `instructor` WRITE;
/*!40000 ALTER TABLE `instructor` DISABLE KEYS */;
INSERT INTO `instructor` VALUES (1,'536789cnv34344vb89vjgh05hjvc1233','Barbara','Karpińska',NULL),(2,'536789cnv34389vb89vjgh05hjvc1233','Paweł','Radomski',NULL),(3,'536789cnv11389vb89vjgh05hjvc1233','Marta','Mościcka','Mostek'),(4,'536789cnv11389vb89vjgh05hjvc8763','Magda','Mróz',NULL),(5,'536789cnv11389vb110jgh05hjvc8763','Julia','Utig',NULL),(6,'536789cnv65488vb110jgh05hjvc8763','Marta','Brendel',NULL),(7,'536789cnv65488vb110jgh05hjvcvv63','Anna','Faściszewska',NULL),(8,'536789cn111088vb110jgh05hjvcvv63','Joanna','Sipowicz',NULL),(9,'116789cnv65488vb110jgh05hjvcvv63','Barbara Karpińska,','Paweł Radomski',NULL);
/*!40000 ALTER TABLE `instructor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instructor_description`
--

DROP TABLE IF EXISTS `instructor_description`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instructor_description` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` varchar(32) NOT NULL,
  `instructor_id` int(11) NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sid` (`sid`),
  KEY `instructor_description_sid_idx` (`sid`),
  KEY `instructor_description_instructor_idx` (`instructor_id`),
  CONSTRAINT `instructor_description_ibfk_1` FOREIGN KEY (`instructor_id`) REFERENCES `instructor` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructor_description`
--

LOCK TABLES `instructor_description` WRITE;
/*!40000 ALTER TABLE `instructor_description` DISABLE KEYS */;
/*!40000 ALTER TABLE `instructor_description` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` varchar(32) NOT NULL,
  `title` varchar(128) NOT NULL,
  `created_at` varchar(16) NOT NULL,
  `content` text NOT NULL,
  `image_src` varchar(1024) DEFAULT NULL,
  `image_alt` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sid` (`sid`),
  KEY `news_sid_idx` (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES (1,'73hdjd44kclv73jd756j0plmxzvycuxk','Ooga Booga!','2013-06-24 00:21','Instruktorka z naszej szkoły - Barbara Karpińska podczas wczorajszego wrocławskiego turnieju tańca nowoczesnego dla dzieci i młodzieży \"Ooga Booga\" pełniła funkcję przewodniczącego jury :)<br/><br/>W szkole funkcjonuje formacja dziecięca, prowadzona przez Barbarę - od września ruszamy z kolejnym naborem dla nowych członków, w związku z czym zapraszamy dzieci w wieku 5-11 lat. Formacja bierze udział w licznych konkursach w kategorii Show dance oraz wielu pokazach. W najbliższym czasie nasze dzieciaki będziemy mogli podziwiać 14 lipca w Lwówku Śląskim podczas Lwóweckiego Lata Agatowego :)<br/><br/>Zapraszamy do oglądania galerii z wczorajszego turnieju.','img/photos/oogabooga.jpg','konkurs tańca wrocław'),(2,'73hdjd44kclv73jd756j0plmxzvycjck','Lwóweckie lato agatowe','2013-07-23 14:05','14 lipca małe Setenty wystąpiły podczas tegorocznych obchodów Lwóweckiego Lata Agatowego.<br/><br/>Zaprezentowały swój najnowszy układ w rytmach country - kapelusze kowbojskie, energetyczna muzyka... Publiczność dosłownie oszalała z zachwytu :)<br/><br/>Gratulujemy, było super!','img/photos/lwowek.jpg','pokazy tańca dolnośląskie'),(3,'73hdjd44kclv73jd756j0plmxzvyycns','Ruszają zajęcia z zouka!','2013-08-29 15:03','Już w najbliższą środę o 20:30 ruszamy z długo oczekiwanymi zajęciami z zouka dla średniozaawansowanych! Zajęcia poprowadzi Julia Utig.<br/><br/>ZOSTAŁY JESZCZE WOLNE MIEJSCA!<br/>Nie trzeba się zapisywać w parach, można przyjść samemu :)<br/><br/>Ważna informacja dla początkujących! Formujemy już grupę od podstaw :)<br/><br/>Zapisy pod numerem telefonu: 695 081 437','img/photos/zouk.jpg','zouk wrocław'),(4,'73hdjd44kclv73jd7ueiiplmxzvyycns','Nowa szata graficzna!','2013-09-13 09:25','W końcu ruszyła nasza strona internetowa po generalnej przebudowie graficznej!<br/><br/>Zachęcamy do częstych odwiedzin - już niebawem zupełnie nowe, REWOLUCYJNE funkcjonalności!','img/photos/nowastrona.png','szkoła tańca wrocław'),(5,'73hdjd44kcuejdmd7ueiiplmxzvyycns','Uwaga! Zmieniamy lokalizację!','2013-11-01 08:47','Przenosimy zajęcia na Sienkiewicza 6a - wejście od strony pl. Bema!<br /><br />Dwie przestronne sale będą do Waszej dyspozycji już od poniedziałku!','https://scontent-b-ams.xx.fbcdn.net/hphotos-prn2/1425738_533370393413415_1125803338_n.png','taniec wrocław'),(6,'bcnmxd44kclv73jd756j0plmxzvycjck','Zajęcia z zumby','2013-11-02 18:20','Niesamowita, żywiołowa i energetyczna Angela to <strong>KOLEJNY NOWY INSTRUKTOR</strong> w naszej kadrze! Zabierz znajome i wpadnij do nas na zumbę! Zumba Angela ma już swoją renomę we Wrocławiu, przekonaj się i Ty! :)<br/><br/>Zajęcia ruszają już w czwartek, 14 listopada - dołączyć można w każdej chwili!<br/><br/>TERMIN:<br/>czwartek 18:30 - 19:30<br/><br/>ZAPISY:<br/>Telefon: 695 081 437<br/>E-mail: kontakt@setenta.wroclaw.pl','http://igglamour.files.wordpress.com/2012/01/zumba-fitness.jpg','zumba wrocław'),(7,'bcnmxd44k567ujjd756j0plmxzvycjck','Hip-hop z Mostkiem!','2013-11-02 21:31','Zapraszamy serdecznie na zajęcia hip-hop z <strong>NOWYM INSTRUKTOREM</strong>! Zajęcia poprowadzi znana i ceniona w środowisku Marta Mościcka - Mostek, <strong>wielokrotna finalistka mistrzostw Polski w hip-hopie</strong>.<br/><br/>TERMIN: wtorek 18:30 - 19:30<br/><br/>RUSZAJĄ ZAPISY - GRUPA RUSZY PO ZEBRANIU WYMAGANEJ LICZBY UCZESTNIKÓW<br/><br/>Telefon: 695 081 437<br/>E-mail: kontakt@setenta.wroclaw.pl','img/photos/mostek.jpg','hip hop wrocław'),(8,'22wexd44k567ujjd756j0plmxzvycjck','Przedsylwestrowe warsztaty taneczne','2013-12-15 22:14','Masz dość podpierania ścian w sylwestra? Zapraszamy Cię na <strong>przedsylwestrowe warsztaty tańca użytkowego</strong> - discofox, blues, rock\'n\'roll, walc oraz salsa. Przełam się i zostań królem parkietu!<br /><br />1,5 h zajęć przez trzy dni - 27, 28, 29 grudnia, godz. 19:00. Koszt trzydniowych warsztatów to <strong>JEDYNE 35 zł od osoby</strong>!<br /><br />Zapisy telefoniczne: 695 081 437 bądź z poziomu naszej strony internetowej (szybka wiadomość)','https://scontent-b-vie.xx.fbcdn.net/hphotos-prn2/t1/1469900_553053174778470_122507627_n.jpg','taniec na sylwestra'),(9,'bcnmxd44k5llskamnn6j0plmxzvycjck','Bal przebierańców dla dzieci!','2014-02-05 12:53','Są jeszcze miejsca na niedzielny (<em>10 lutego</em>) <strong>BAL PRZEBIERAŃCÓW DLA DZIECI</strong>! Zwariowana zabawa pod okiem wykwalifikowanej kadry instruktorów.<br /><br />W programie:<ul><li>Zabawy taneczne</li><li>Zabawy plastyczne</li><li>Konkursy</li><li>Nauka tańca</li></ul>Zapewniamy napoje i słodycze.<br/><br/>Czas: 15:00 - 18:00<br/>Koszt: 15 zł','https://scontent-a-ams.xx.fbcdn.net/hphotos-frc1/t1/1897992_576863989064055_839558548_n.png','balik przebierańców'),(10,'b5557844k5llskamnn6j0plmxzvycjck','Walentynkowy wieczorek taneczny','2014-02-06 19:06','Brak pomysłów na walentynkowy weekend?<br/>W sobotę (<em>15 lutego</em>) zapraszamy na <strong>WALENTYNKOWY WIECZOREK TANECZNY</strong>!<br/><br/>W programie:<ul><li>lekcje tańca</li><li>animacje</li><li>pokazy tańca</li></ul>Oferujemy:<ul><li>lampkę szampana</li><li>przekąski</li></ul>Startujemy o godz. 18:00<br/>Koszt: 15 zł','https://fbcdn-sphotos-c-a.akamaihd.net/hphotos-ak-ash3/t1/1000956_577420719008382_815465883_n.jpg','walentynkowy wieczorek taneczny'),(11,'g5557844k5llskamnn6j0plmxzvycjck','Walentynkowa promocja dla narzeczonych','2014-02-12 15:03','<p>Każda para, kt&oacute;ra w dzień WALENTYNEK zgłosi się do nas telefonicznie (<em>695 081 437</em>) bądź mailowo (<em>kontakt@setenta.wroclaw.pl</em>) otrzyma możliwość zakupu karnetu na pierwszy taniec!<br />\n<br />\n<strong>4 lekcje INDYWIDUALNE w cenie 110 zł zamiast 220 zł!</strong><br />\n<br />\nInstruktor ułoży Wam choreografię pod wybraną muzykę i wymagania :)<br />\n<br />\nZapraszamy!</p>','img/photos/dirty-dancing.jpg','walentynkowy wieczorek taneczny');
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `room` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` varchar(32) NOT NULL,
  `name` varchar(128) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sid` (`sid`),
  KEY `room_sid_idx` (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (3,'zxcvblkjhgzxcvblkjhgzxcvblkjhgdf','m'),(4,'zxcvblkjhgzxcvblkjhgzxcvblkjhglv','d');
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `style`
--

DROP TABLE IF EXISTS `style`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `style` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` varchar(32) NOT NULL,
  `name` varchar(128) NOT NULL,
  `category_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sid` (`sid`),
  KEY `style_sid_idx` (`sid`),
  KEY `style_category_idx` (`category_id`),
  CONSTRAINT `style_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `style`
--

LOCK TABLES `style` WRITE;
/*!40000 ALTER TABLE `style` DISABLE KEYS */;
INSERT INTO `style` VALUES (1,'43632299f3434e0889vjkb50c1168103','Aktywne 50+',8),(2,'43632299f343445289vjkb50c1168103','Balet z elementami gimnastyki artystycznej',7),(3,'43223299f343445289vjkb50c1168103','Taniec towarzyski',9),(4,'43223299f343445289vjkb0011168103','Taniec użytkowy',9),(5,'43223369f343445289vjkb0011168103','Dziecięca formacja taneczna',10),(6,'43223mcnv343445289vjkb0011168103','Hip hop',6),(7,'43223mcnv343445289vjkb0585168103','Reggaeton',6),(8,'43223mcnv343445289vjkb05851yyv03','Trening El-Fuego',10),(9,'43223mcnv343445289vjkb05vvvcxv03','Hip hop dla dzieci 5-7 lat',7),(10,'43223mcnv343445289vjkb05ggvcxv03','Mix dance 4-7 lat',7),(11,'53223mcnv343445289vjkb05ggvcxv03','Ladies latino',6),(12,'53223mcnv34344vb89vjkb05ggvcxv03','Salsa solo',6),(13,'53223mcnv34344vb89vjgh05ggvcxv03','Bachata',9),(14,'53223mcnv34344vb89vjgh05hjvcxv03','Balet 3 latki',7),(15,'5322tycnv34344vb89vjgh05hjvcxv03','Salsa kubańska',9),(16,'5322tycnv34344vb89vjgh05hjvc1233','Zouk',9);
/*!40000 ALTER TABLE `style` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` varchar(32) NOT NULL,
  `first_name` varchar(25) NOT NULL,
  `last_name` varchar(35) NOT NULL,
  `login` varchar(15) NOT NULL,
  `password` varchar(65) NOT NULL,
  `email` varchar(30) NOT NULL,
  `type` int(4) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sid` (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'098765432562738271gshducjxksleej','Użytkownik','Testowy','test','test','test@mail.com',0);
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

-- Dump completed on 2014-04-23  9:41:54
