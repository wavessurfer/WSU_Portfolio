use university;

-- a. Create a new course “CS-001”, titled “Weekly Seminar”, with 0 credits.
insert into course
values ('CS-001', 'Weekly Seminar', 'Comp. Sci.', '0');

-- b. Create a section of this course in Autumn 2009, with sec id of 1.
insert into section ( course_id, sec_id, semester, year)
values ('CS-001',1,'Autumn',2009);

-- c. Enroll every student in the Comp. Sci. department in the above section.
insert into takes 
select distinct ID, section.course_id, section.sec_id, section.semester, section.year, null
from (student natural join section)
where section.course_id = 'CS-001' AND dept_name = 'Comp. Sci.';

-- d. Delete enrollments in the above section where the student’s name is Chavez
delete from takes
where (ID) in (select ID from student where name = 'Chavez');

-- e. Delete the course CS-001. What will happen if you run this delete
   -- statement without first deleting offerings (sections) of this course.
delete from course
where course_id = 'CS-001';
#Since takes.course_id is foreign key for section.course_id, it will delete it from both tables,
#section and takes.

-- f. Delete all takestuples corresponding to any section of any course with
-- the word “database” as a part of the title; ignore case when matching
-- the word with the title.
delete from takes
where (course_id) in (select course_id from course
    where title like '%database%');