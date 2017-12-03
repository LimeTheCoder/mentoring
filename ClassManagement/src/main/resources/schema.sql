CREATE TABLE IF NOT EXISTS `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `postal_code` varchar(25) NOT NULL,
  `country` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `street` varchar(45) DEFAULT NULL,
  `building` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Contains info about some location';

CREATE TABLE IF NOT EXISTS `school` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `address_id` int(11) DEFAULT NULL,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_school_address_idx` (`address_id`),
  CONSTRAINT `fk_school_address` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `user_profile_info` (
  `user_identificator` varchar(60) NOT NULL,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `second_name` varchar(45) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_identificator`),
  UNIQUE KEY `email_UNIQUE` (`user_identificator`),
  KEY `fk_profile_address_idx` (`address_id`),
  CONSTRAINT `fk_profile_address` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `teacher_profile` (
  `user_identificator` varchar(60) NOT NULL,
  `position` varchar(45) DEFAULT NULL,
  `experience` int(11) DEFAULT NULL,
  `subject` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`user_identificator`),
  CONSTRAINT `fk_teacher_prfl_id` FOREIGN KEY (`user_identificator`) REFERENCES `user_profile_info` (`user_identificator`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `school_class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `manager_id` varchar(60) DEFAULT NULL,
  `school_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_class_manager_id_idx` (`manager_id`),
  KEY `fk_class_school_id_idx` (`school_id`),
  CONSTRAINT `fk_class_manager_id` FOREIGN KEY (`manager_id`) REFERENCES `teacher_profile` (`user_identificator`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_class_school_id` FOREIGN KEY (`school_id`) REFERENCES `school` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `student_profile` (
  `user_identificator` varchar(60) NOT NULL,
  `enrollment_year` int(11) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_identificator`),
  KEY `fk_student_class_id_idx` (`class_id`),
  CONSTRAINT `fk_student_class_id` FOREIGN KEY (`class_id`) REFERENCES `school_class` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `fk_student_prfl_id` FOREIGN KEY (`user_identificator`) REFERENCES `user_profile_info` (`user_identificator`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `course_session` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_key` varchar(100) NOT NULL,
  `class_id` int(11) NOT NULL,
  `opening_date` datetime NOT NULL,
  `closing_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `course_class_idx` (`course_key`,`class_id`),
  KEY `fk_session_class_idx` (`class_id`),
  CONSTRAINT `fk_session_class` FOREIGN KEY (`class_id`) REFERENCES `school_class` (`id`) ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
