DELETE FROM `user_roles`;
DELETE FROM `user`;

ALTER TABLE `user_roles` AUTO_INCREMENT = 1;
ALTER TABLE `user` AUTO_INCREMENT = 1;

INSERT INTO `user` (`username`,`enabled`,`password`) VALUES ('admin',1,'$2a$10$frm2RydarZomGlSAaH6ySeM1FDgscNapPDE8wM.0CtqFOW5bJVRPu');
INSERT INTO `user` (`username`,`enabled`,`password`) VALUES ('user',1,'$2a$10$QVyaHEcCx7SldRnTwTa0T.Kd4fUMMgD/pNHQshrWv6YJaDgVaXHqu');
INSERT INTO `user` (`username`,`enabled`,`password`) VALUES ('teacher',1,'$2a$10$QVyaHEcCx7SldRnTwTa0T.Kd4fUMMgD/pNHQshrWv6YJaDgVaXHqu');
INSERT INTO `user` (`username`,`enabled`,`password`) VALUES ('student',1,'$2a$10$QVyaHEcCx7SldRnTwTa0T.Kd4fUMMgD/pNHQshrWv6YJaDgVaXHqu');

INSERT INTO `user_roles` (`user_username`,`authority`) VALUES ('admin','ROLE_USER');
INSERT INTO `user_roles` (`user_username`,`authority`) VALUES ('admin','ROLE_ADMIN');
INSERT INTO `user_roles` (`user_username`,`authority`) VALUES ('user','ROLE_USER');
INSERT INTO `user_roles` (`user_username`,`authority`) VALUES ('teacher','ROLE_USER');
INSERT INTO `user_roles` (`user_username`,`authority`) VALUES ('teacher','ROLE_TEACHER');
INSERT INTO `user_roles` (`user_username`,`authority`) VALUES ('student','ROLE_USER');
INSERT INTO `user_roles` (`user_username`,`authority`) VALUES ('student','ROLE_STUDENT');
