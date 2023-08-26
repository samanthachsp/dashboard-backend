CREATE TABLE `requisition` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Description` varchar(350) DEFAULT NULL,
  `DateCreated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `SkNo` varchar(25) DEFAULT NULL,
  `Amount` decimal(10,2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`),
  UNIQUE KEY `UK_UNIQUE_REQUISITION` (`id`)
) ; 


CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;

CREATE TABLE `production` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Description` varchar(350) DEFAULT NULL,
  `DateCreated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `Item` varchar(25) DEFAULT NULL,
  `Amount` decimal(10,2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`),
  UNIQUE KEY `UK_UNIQUE_REQUISITION` (`id`)
) ; 


CREATE TABLE `groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ; 