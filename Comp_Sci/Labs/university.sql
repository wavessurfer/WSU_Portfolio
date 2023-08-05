CREATE DATABASE IF NOT EXISTS `university`;
USE `university`;

DROP TABLE IF EXISTS `classroom`;
create table `classroom` (
	`building` varchar (15),
	`room_number` varchar (7),
	`capacity` numeric (4,0),
	primary key (`building`,`room_number`)
);

DROP TABLE IF EXISTS `department`;
create table `department` (
	`dept_name` varchar (20),
	`building` varchar (15),
	`budget` numeric (12,2) check (budget > 0),
	primary key (`dept_name`)
);

DROP TABLE IF EXISTS `course`;
create table `course` (
	`course_id` varchar (8),
	`title` varchar (50),
	`dept_name` varchar (20),
	`credits` numeric (2,0) check (credits > 0),
	primary key (`course_id`),
	foreign key (`dept_name`) references department(dept_name)
    on delete set null
);

DROP TABLE IF EXISTS `section`;
create table `section`(
	`course_id` varchar (8),
	`sec_id` varchar (8),
	`semester` varchar (6) check (semester in
		('Fall', 'Winter', 'Spring', 'Summer')),
	`year` numeric (4,0) check (year > 1701 and year < 2100),
	`building` varchar (15),
    `room_number` varchar (7),
	`time_slot_id` varchar (4),
	primary key (`course_id`, `sec_id`, `semester`, `year`),
	foreign key (`course_id`) references course(course_id)
		on delete cascade,
	foreign key (`building`, `room_number`) references classroom(`building`, `room_number`)
		on delete set null
);

DROP TABLE IF EXISTS `instructor`;
create table `instructor` (
	`ID` varchar (5),
	`name` varchar (20) not null,
	`dept_name` varchar (20),
	`salary` numeric (8,2) check (salary > 29000),
	primary key (`ID`),
	foreign key (`dept_name`) references department(dept_name)
    on delete set null
);

INSERT INTO `classroom`
VALUES 	('Packard','101','500'),
		('Painter','514','10'),
        ('Taylor','3128','70'),
		('Watson','100','30'),
        ('Watson','120','50');

INSERT INTO `department`
VALUES 	('Biology','Watson','90000'),
		('Comp. Sci.','Taylor','100000'),
        ('Elec. Eng.','Taylot','85000'),
		('Finance','Painter','120000'),
        ('History','Painter','50000'),
        ('Music','Packard','80000'),
        ('Physics','Watson','70000');
		
INSERT INTO `course`
VALUES 	('BIO101','Intro. to Bio','Biology','4'),
		('BIO301','Genetics','Biology','4'),
        ('BIO399','Computational Bio','Biology','3'),
        ('CS101','Intro. to Comp. Sci.','Comp. Sci.','4'),
        ('CS190','Game Design','Comp. Sci.','4'),
        ('CS315','Robotics','Comp. Sci.','3'),
        ('CS319','Image Processing','Comp. Sci.','3'),
        ('CS347','Database System Concepts','Comp. Sci.','3'),
        ('EE181','Intro. to Digital Systems','Elec. Eng.','3'),
        ('FIN201','Investment Banking','Finance','4'),
        ('HIS351','World History','History','3'),
        ('MUS199','Music Video Production','Music','3'),
        ('PHY101','Physical Principles','Physics','4');

INSERT INTO `section`
VALUES 	('BIO101','1','Summer','2009','Painter','514','B'),
		('BIO301','1','Summer','2010','Painter','514','A'),
        ('CS101','1','Fall','2009','Packard','101','H'),
		('CS101','1','Spring','2010','Packard','101','F'),
        ('CS190','1','Spring','2009','Taylor','3128','E'),
		('CS190','2','Spring','2009','Taylot','3128','A'),
        ('CS315','1','Spring','2010','Watson','120','D'),
		('CS319','1','Spring','2010','Watson','100','B'),
        ('CS319','2','Spring','2010','Taylor','3128','C'),
		('CS347','1','Fall','2009','Taylor','3128','A'),
        ('EE181','1','Spring','2009','Taylor','3128','C'),
		('FIN201','1','Spring','2010','Packard','101','B'),
        ('HIS351','1','Spring','2010','Painter','514','C'),
		('MUS199','1','Spring','2010','Packard','101','D'),
        ('PHY101','1','Fall','2009','Watson','100','A');
        
INSERT INTO `instructor`
VALUES 	('10101','Srinivasan','Comp. Sci.','65000'),
		('12121','Wu','Finance','90000'),
        ('15151','Mozart','Music','40000'),
        ('22222','Einstein','Physics','95000'),
        ('32343','El Said','Physics','60000'),
        ('33456','Gold','Physics','87000'),
        ('45565','Katz','Comp. Sci.','75000'),
        ('58583','Califieri','History','62000'),
        ('76543','Singh','Finance','80000'),
        ('76766','Crick','Biology','72000'),
        ('83821','Brandt','Comp. Sci.','92000'),
        ('98345','Kim','Elec. Eng.','80000');