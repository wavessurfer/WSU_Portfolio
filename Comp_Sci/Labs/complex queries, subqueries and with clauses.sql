use university;

select dept_name, avg_salary
from
	(select dept_name, avg(salary) as avg_salary
	from instructor
    group by dept_name) as temp
where avg_salary > 42000;

select dept_name, avg(salary) as avg_salary
from instructor
group by dept_name
having avg_salary > 42000;

with max_budget(value) as
	(select max(budget)
    from department)
select budget, dept_name
from department, max_budget
where department.budget = max_budget.value;

select budget, dept_name
from department, (select max(budget) from department) as max_budget(value)
where department.budget = max_budget.value;

with dept_total (dept_name, value) as
	(select dept_name, sum(salary)
    from instructor
    group by dept_name),
    dept_total_avg(value) as
		(select avg(value)
        from dept_total)
select dept_name
from dept_total, dept_total_avg
where dept_total.value >= dept_total_avg.value;

create table instructor_A
	select * from instructor;
    
delete from instructor_A
where dept_name = 'Finance';

update instructor_A
set salary = case
				when salary <= 10000 then salary * 1.05
                else salary * 1.03
			end;

select course.course_id, prereq_id
from course natural join prereq;

select course.course_id, prereq_id
from course natural left outer join prereq; -- right / left