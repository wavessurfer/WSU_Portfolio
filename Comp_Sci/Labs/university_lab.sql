use university;

select title
from course
where dept_name = "Comp Sci.";

select dept_name
from course;

select distinct dept_name
from course;

select title, dept_name
from course
order by dept_name;

select name, round(salary/12,2) as monthly_salary
from instructor
order by salary;

select name, dept_name, salary
from instructor
order by dept_name;

-- Operators of ρ, σ, ∏, ∪, ∩, X, –, ◊ (natural join)
    
-- List all instructors in Biology with Salary > 8K
	-- ∏name (σ dept_name='Biology' ^ salary>80000 (instructor) )
select name, dept_name, salary
from instructor
where dept_name = 'Biology' and salary > 80000;


-- List the names of instructors and the courses ID they are teaching
	-- ∏ name,course_id (σ instructor.id = teaches.id (instructor x teaches))
select name, course_id
from instructor, teaches
where instructor.ID=teaches.ID;

	-- ∏ name,course_id (instructor ◊ teaches))
select name, course_id
from instructor natural join teaches;


-- List the names of instructors and the title of the courses they are teaching
	-- ∏ name, title, course_id
	-- (σ teaches.course_id = course.course_id and instructor.id = teaches.id 
		-- (instructor x teaches x course))
select name, title
from instructor, teaches, course
where instructor.ID=teaches.ID and teaches.course_ID = course.course_ID;

	-- ∏ name, title, course_id (σ instructor.id = teaches.id 
		-- ((course ◊ teaches) x instructor))
select name, title
from course natural join teaches, instructor
where instructor.ID=teaches.ID;

-- Find the names of instructors who have higher salary than some instructors in 'Comp Sci.'
	-- 	∏ instructor.name ( σ instructor.salary > i2.salary
		-- ( instructor x P i2 ( σ instructor.dept_name = 'Comp. Sci.' (instructor)))

select distinct instructor.name, instructor.salary, instructor.dept_name
from instructor, instructor as T
where T.dept_name="Comp. Sci." AND instructor.salary>T.salary
order by instructor.salary desc;

-- Find courses that ran in F2009 or in S2010
select distinct course_id, semester, year
from section
where (semester = 'Fall' and year = 2009) or ( semester = 'Spring' and year = 2010)
order by year asc;

select course_id, semester, year
from section
where semester = 'Fall' and year = 2009
union
select course_id, semester, year
from section
where semester = 'Spring' and year = 2010;

-- Find courses that ran in F2009 and in S2010
	-- ∏ course_id ( σ section.course_id=section2.course_id,
					-- (section.semester = 'Spring' and section.year = 2010)
					-- ( section x P section2 (σ section.semester = 'Fall' and section.year = 2009 (section))))
select section.course_id
from section, section as s2
where (section.semester='Spring' and section.year=2010)
	and (s2.semester='Fall' and s2.year=2009)
    and section.course_id=s2.course_id;                

select course_id
from section
where semester = 'Fall' and year = 2009
intersect
select course_id
from section
where semester = 'Spring' and year = 2010;

-- Find courses that ran in F2009 but not in S2010
select course_id
from section
where semester = 'Fall' and year = 2009
except
select course_id
from section
where semester = 'Spring' and year = 2010;

select section.course_id
from section, section as s2
where !(section.semester='Spring' and section.year=2010)
	and (s2.semester='Fall' and s2.year=2009)
    and section.course_id=s2.course_id;

