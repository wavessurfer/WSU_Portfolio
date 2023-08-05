use university;

create view faculty as
select ID, name, dept_name
from instructor;

select *
from course right outer join prereq on (course.course_id=prereq.prereq_id);

create view faculty as
	select ID, name;
    
create view depts_total_salary(dept_name, total_salary) as
	select dept_name, sum(salary)
    from instructor
    group by dept_name;

select round(avg(total_salary),2) as avg_salary
from depts_total_salary;

create view physics_fall_2009 as
	select course.course_id, sec_id, building, room_number
    from course, section
    where course.course_id = section.course_id
		and course.dept_name = 'Physics'
        and section.semester = 'Fall'
        and section.year = 2009;

create view physics_fall_2009_watson as 
	select course_id, room_number
    from physics_fall_2009
    where building = 'Watson';
    
create index studID_index on student(ID);