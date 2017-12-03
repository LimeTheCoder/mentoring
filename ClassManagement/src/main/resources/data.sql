DELETE FROM `course_session`;
DELETE FROM `student_profile`;
DELETE FROM `school_class`;
DELETE FROM `teacher_profile`;
DELETE FROM `user_profile_info`;
DELETE FROM `school`;
DELETE FROM `address`;

ALTER TABLE `address` AUTO_INCREMENT = 1;
ALTER TABLE `course_session` AUTO_INCREMENT = 1;
ALTER TABLE `school` AUTO_INCREMENT = 1;
ALTER TABLE `school_class` AUTO_INCREMENT = 1;
ALTER TABLE `student_profile` AUTO_INCREMENT = 1;
ALTER TABLE `teacher_profile` AUTO_INCREMENT = 1;
ALTER TABLE `user_profile_info` AUTO_INCREMENT = 1;

INSERT INTO `address` (`id`, `postal_code`,`country`,`city`,`street`,`building`) VALUES (1, 'AAA97','England','London','Flowers','5A');
INSERT INTO `address` (`id`, `postal_code`,`country`,`city`,`street`,`building`) VALUES (2, 'BBB41','Germany','Berlin','Graiham','67');
INSERT INTO `address` (`id`, `postal_code`,`country`,`city`,`street`,`building`) VALUES (3, 'SSS99','Canada','Ottava','Lumpen str.','18');

INSERT INTO `school` (`id`,`name`,`address_id`,`type`) VALUES (1,'Central High School',2,'HIGH');

INSERT INTO `user_profile_info` (`user_identificator`,`name`,`surname`,`second_name`,`age`,`phone`,`address_id`) VALUES ('jessy','Jessy','James',NULL,15,'+380972185561',1);
INSERT INTO `user_profile_info` (`user_identificator`,`name`,`surname`,`second_name`,`age`,`phone`,`address_id`) VALUES ('student','Jeremy','Williams',NULL,13,'+380972185561',2);
INSERT INTO `user_profile_info` (`user_identificator`,`name`,`surname`,`second_name`,`age`,`phone`,`address_id`) VALUES ('teacher','Sara','White',NULL,38,'+785642314',1);

INSERT INTO `teacher_profile` (`user_identificator`,`position`,`experience`,`subject`) VALUES ('teacher','Senior Teacher',10,'MATH');

INSERT INTO `school_class` (`id`,`name`,`manager_id`,`school_id`) VALUES (1,'Languages class','teacher',1);

INSERT INTO `student_profile` (`user_identificator`,`enrollment_year`,`class_id`) VALUES ('jessy',2009,1);
INSERT INTO `student_profile` (`user_identificator`,`enrollment_year`,`class_id`) VALUES ('student',2009,1);

INSERT INTO `course_session` (`id`,`course_key`,`class_id`,`opening_date`,`closing_date`) VALUES (1,'ml-218',1,'2017-12-03 22:45:00','2018-01-18 18:00:00');
INSERT INTO `course_session` (`id`,`course_key`,`class_id`,`opening_date`,`closing_date`) VALUES (2,'ml-219',1,'2017-12-03 22:45:00','2018-01-18 18:00:00');