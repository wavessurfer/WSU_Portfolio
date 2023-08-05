CREATE DATABASE IF NOT EXISTS `lab1`;
USE `lab1`;

DROP TABLE IF EXISTS `timeslot`;
CREATE TABLE `timeslot` (
	`time_slot_id` varchar(4) NOT NULL,
	`day` varchar(1) NOT NULL,
	`start_time` time NOT NULL,
	`end_time` time DEFAULT NULL,
	PRIMARY KEY (`time_slot_id`,`day`,`start_time`)
);

DROP TABLE IF EXISTS `section`;
CREATE TABLE `section` (
	`course_id` varchar(8) NOT NULL,
    `sec_id` varchar(8) NOT NULL,
	`semester` varchar(6) NOT NULL,
	`year` numeric(4,0) NOT NULL,
	`building` varchar(15) DEFAULT NULL,
    `room_number` varchar(7) DEFAULT NULL,
    `time_slot_id` varchar(4) DEFAULT NULL,
    PRIMARY KEY(`course_id`,`sec_id`,`semester`,`year`),
    foreign key (`time_slot_id`) references timeslot(time_slot_id)
);


LOCK TABLES `timeslot` WRITE;

INSERT INTO `timeslot` VALUES ('A','F','08:00:00','08:50:00'), ('A','M','08:00:00','08:50:00');

UNLOCK TABLES;