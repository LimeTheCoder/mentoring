CREATE TABLE IF NOT EXISTS `user` (
  `username` varchar(255) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `user_roles` (
  `user_username` varchar(255) NOT NULL,
  `authority` varchar(255) DEFAULT NULL,
  KEY `FK1misndtpfm9hx3ttvixdus8d1` (`user_username`),
  CONSTRAINT `FK1misndtpfm9hx3ttvixdus8d1` FOREIGN KEY (`user_username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
