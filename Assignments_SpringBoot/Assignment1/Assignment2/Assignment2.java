/*
*
*
*

postgres=# \c muskan
You are now connected to database "muskan" as user "postgres".
muskan=# create table employees(id serial primary key , name varchar(100), department varchar(50),salary numeric(10,2), hire_date Date);

CREATE TABLE
muskan=# insert into employees(1, 'Alice' , 'IT' , 60000.00 , 2020-03-15);
ERROR:  syntax error at or near "1"
LINE 1: insert into employees(1, 'Alice' , 'IT' , 60000.00 , 2020-03...
                              ^

muskan=# insert into employees(name , department , salary , hire_date) values('Alice' , 'IT' , 60000.00 , '2020-03-15');
INSERT 0 1
muskan=# describe employees;
ERROR:  syntax error at or near "describe"
LINE 1: describe employees;
        ^
muskan=# describe\d employees
                                      Table "public.employees"
   Column   |          Type          | Collation | Nullable |                Default
------------+------------------------+-----------+----------+---------------------------------------
 id         | integer                |           | not null | nextval('employees_id_seq'::regclass)
 name       | character varying(100) |           |          |
 department | character varying(50)  |           |          |
 salary     | numeric(10,2)          |           |          |
 hire_date  | date                   |           |          |
Indexes:
    "employees_pkey" PRIMARY KEY, btree (id)


muskan-# insert into employees(name , department , salary , hire_date) values('Bob', 'HR', 45000.00 , '2019-07-10');
ERROR:  syntax error at or near "describe"
LINE 1: describe
        ^
muskan=# insert into employees(name , department , salary , hire_date) values('Bob', 'HR', 45000.00 , '2019-07-10');
INSERT 0 1
muskan=# insert into employees(name , department , salary , hire_date) values('Charlie', 'Finance', 50000.00 , '2021-01-05');
INSERT 0 1
muskan=# insert into employees(name , department , salary , hire_date) values('Diana', 'IT', 62000.00 , '2018-12-01');
INSERT 0 1
muskan=# insert into employees(name , department , salary , hire_date) values('Eve', 'Finance', 52000.00 , '2018-12-01');
INSERT 0 1
muskan=# update employees set hire_date = '2022-04-22' where name = 'Eve';
UPDATE 1
muskan=# insert into employees(name , department , salary , hire_date) values('Frank', 'HR', 47000.00 , '2020-09-30');
INSERT 0 1
muskan=# insert into employees(name , department , salary , hire_date) values('Grace', 'IT', 65000.00 , '2023-06-10');
INSERT 0 1
muskan=# insert into employees(name , department , salary , hire_date) values('Heidi', 'Finance', 48000.00 , '2023-01-20');
INSERT 0 1
muskan=# insert into employees(name , department , salary , hire_date) values('Ivan', 'Admin', 53000.00 , '2021-11-11');
INSERT 0 1
muskan=# insert into employees(name , department , salary , hire_date) values('Judy', 'IT', 61000.00 , '2022-08-08');
INSERT 0 1
muskan=# commit;
WARNING:  there is no transaction in progress
COMMIT
muskan=# describe employees
muskan-# ;
ERROR:  syntax error at or near "describe"
LINE 1: describe employees
        ^
muskan=# select * from employees;
 id |  name   | department |  salary  | hire_date
----+---------+------------+----------+------------
  1 | Alice   | IT         | 60000.00 | 2020-03-15
  2 | Bob     | HR         | 45000.00 | 2019-07-10
  3 | Charlie | Finance    | 50000.00 | 2021-01-05
  4 | Diana   | IT         | 62000.00 | 2018-12-01
  5 | Eve     | Finance    | 52000.00 | 2022-04-22
  6 | Frank   | HR         | 47000.00 | 2020-09-30
  7 | Grace   | IT         | 65000.00 | 2023-06-10
  8 | Heidi   | Finance    | 48000.00 | 2023-01-20
  9 | Ivan    | Admin      | 53000.00 | 2021-11-11
 10 | Judy    | IT         | 61000.00 | 2022-08-08
(10 rows)


muskan=# \d employees;
                                      Table "public.employees"
   Column   |          Type          | Collation | Nullable |                Default
------------+------------------------+-----------+----------+---------------------------------------
 id         | integer                |           | not null | nextval('employees_id_seq'::regclass)
 name       | character varying(100) |           |          |
 department | character varying(50)  |           |          |
 salary     | numeric(10,2)          |           |          |
 hire_date  | date                   |           |          |
Indexes:
    "employees_pkey" PRIMARY KEY, btree (id)


muskan=# select * from employees;
 id |  name   | department |  salary  | hire_date
----+---------+------------+----------+------------
  1 | Alice   | IT         | 60000.00 | 2020-03-15
  2 | Bob     | HR         | 45000.00 | 2019-07-10
  3 | Charlie | Finance    | 50000.00 | 2021-01-05
  4 | Diana   | IT         | 62000.00 | 2018-12-01
  5 | Eve     | Finance    | 52000.00 | 2022-04-22
  6 | Frank   | HR         | 47000.00 | 2020-09-30
  7 | Grace   | IT         | 65000.00 | 2023-06-10
  8 | Heidi   | Finance    | 48000.00 | 2023-01-20
  9 | Ivan    | Admin      | 53000.00 | 2021-11-11
 10 | Judy    | IT         | 61000.00 | 2022-08-08
(10 rows)


muskan=# select name , salary from employees;
  name   |  salary
---------+----------
 Alice   | 60000.00
 Bob     | 45000.00
 Charlie | 50000.00
 Diana   | 62000.00
 Eve     | 52000.00
 Frank   | 47000.00
 Grace   | 65000.00
 Heidi   | 48000.00
 Ivan    | 53000.00
 Judy    | 61000.00
(10 rows)


muskan=# select name from emlployees where department = 'Finance';
ERROR:  relation "emlployees" does not exist
LINE 1: select name from emlployees where department = 'Finance';
                         ^
muskan=# select name from employees where department = 'Finance';
  name
---------
 Charlie
 Eve
 Heidi
(3 rows)


muskan=# select name  from employees order by salary;
  name
---------
 Bob
 Frank
 Heidi
 Charlie
 Eve
 Ivan
 Alice
 Judy
 Diana
 Grace
(10 rows)


muskan=# select name ,salary from employees order by salary;
  name   |  salary
---------+----------
 Bob     | 45000.00
 Frank   | 47000.00
 Heidi   | 48000.00
 Charlie | 50000.00
 Eve     | 52000.00
 Ivan    | 53000.00
 Alice   | 60000.00
 Judy    | 61000.00
 Diana   | 62000.00
 Grace   | 65000.00
(10 rows)


muskan=# select name , date from employees order by hire_date;
ERROR:  column "date" does not exist
LINE 1: select name , date from employees order by hire_date;
                      ^
HINT:  Perhaps you meant to reference the column "employees.name".
muskan=# select name , hire_date from employees order by hire_date;
  name   | hire_date
---------+------------
 Diana   | 2018-12-01
 Bob     | 2019-07-10
 Alice   | 2020-03-15
 Frank   | 2020-09-30
 Charlie | 2021-01-05
 Ivan    | 2021-11-11
 Eve     | 2022-04-22
 Judy    | 2022-08-08
 Heidi   | 2023-01-20
 Grace   | 2023-06-10
(10 rows)


muskan=# select name , hire_date from employees order by hire_date desc;
  name   | hire_date
---------+------------
 Grace   | 2023-06-10
 Heidi   | 2023-01-20
 Judy    | 2022-08-08
 Eve     | 2022-04-22
 Ivan    | 2021-11-11
 Charlie | 2021-01-05
 Frank   | 2020-09-30
 Alice   | 2020-03-15
 Bob     | 2019-07-10
 Diana   | 2018-12-01
(10 rows)


muskan=# select name  , salary , department from employees order by department ,  salary desc;
  name   |  salary  | department
---------+----------+------------
 Ivan    | 53000.00 | Admin
 Eve     | 52000.00 | Finance
 Charlie | 50000.00 | Finance
 Heidi   | 48000.00 | Finance
 Frank   | 47000.00 | HR
 Bob     | 45000.00 | HR
 Grace   | 65000.00 | IT
 Diana   | 62000.00 | IT
 Judy    | 61000.00 | IT
 Alice   | 60000.00 | IT
(10 rows)


muskan=# update employees set salary = salary+salary*0.1;
UPDATE 10
muskan=# select * from employees;
 id |  name   | department |  salary  | hire_date
----+---------+------------+----------+------------
  1 | Alice   | IT         | 66000.00 | 2020-03-15
  2 | Bob     | HR         | 49500.00 | 2019-07-10
  3 | Charlie | Finance    | 55000.00 | 2021-01-05
  4 | Diana   | IT         | 68200.00 | 2018-12-01
  5 | Eve     | Finance    | 57200.00 | 2022-04-22
  6 | Frank   | HR         | 51700.00 | 2020-09-30
  7 | Grace   | IT         | 71500.00 | 2023-06-10
  8 | Heidi   | Finance    | 52800.00 | 2023-01-20
  9 | Ivan    | Admin      | 58300.00 | 2021-11-11
 10 | Judy    | IT         | 67100.00 | 2022-08-08
(10 rows)


muskan=# update employees set department = 'Admin' where name = 'Bob';
UPDATE 1
muskan=# select * from employees;
 id |  name   | department |  salary  | hire_date
----+---------+------------+----------+------------
  1 | Alice   | IT         | 66000.00 | 2020-03-15
  3 | Charlie | Finance    | 55000.00 | 2021-01-05
  4 | Diana   | IT         | 68200.00 | 2018-12-01
  5 | Eve     | Finance    | 57200.00 | 2022-04-22
  6 | Frank   | HR         | 51700.00 | 2020-09-30
  7 | Grace   | IT         | 71500.00 | 2023-06-10
  8 | Heidi   | Finance    | 52800.00 | 2023-01-20
  9 | Ivan    | Admin      | 58300.00 | 2021-11-11
 10 | Judy    | IT         | 67100.00 | 2022-08-08
  2 | Bob     | Admin      | 49500.00 | 2019-07-10
(10 rows)


muskan=# update employees set salary = 55000.00 where hire_date>2020;
ERROR:  operator does not exist: date > integer
LINE 1: update employees set salary = 55000.00 where hire_date>2020;
                                                              ^
HINT:  No operator matches the given name and argument types. You might need to add explicit type casts.
muskan=# update employees set salary = 55000.00 where hire_date>'2020';
ERROR:  invalid input syntax for type date: "2020"
LINE 1: ...date employees set salary = 55000.00 where hire_date>'2020';
                                                                ^
muskan=# update employees set salary = 55000.00 where hire_date>'2020-01-01';
UPDATE 8
muskan=# select * from employees;
 id |  name   | department |  salary  | hire_date
----+---------+------------+----------+------------
  4 | Diana   | IT         | 68200.00 | 2018-12-01
  2 | Bob     | Admin      | 49500.00 | 2019-07-10
  1 | Alice   | IT         | 55000.00 | 2020-03-15
  3 | Charlie | Finance    | 55000.00 | 2021-01-05
  5 | Eve     | Finance    | 55000.00 | 2022-04-22
  6 | Frank   | HR         | 55000.00 | 2020-09-30
  7 | Grace   | IT         | 55000.00 | 2023-06-10
  8 | Heidi   | Finance    | 55000.00 | 2023-01-20
  9 | Ivan    | Admin      | 55000.00 | 2021-11-11
 10 | Judy    | IT         | 55000.00 | 2022-08-08
(10 rows)


muskan=# delete from employees where department = 'HR';
DELETE 1
muskan=# select * from employees;
 id |  name   | department |  salary  | hire_date
----+---------+------------+----------+------------
  4 | Diana   | IT         | 68200.00 | 2018-12-01
  2 | Bob     | Admin      | 49500.00 | 2019-07-10
  1 | Alice   | IT         | 55000.00 | 2020-03-15
  3 | Charlie | Finance    | 55000.00 | 2021-01-05
  5 | Eve     | Finance    | 55000.00 | 2022-04-22
  7 | Grace   | IT         | 55000.00 | 2023-06-10
  8 | Heidi   | Finance    | 55000.00 | 2023-01-20
  9 | Ivan    | Admin      | 55000.00 | 2021-11-11
 10 | Judy    | IT         | 55000.00 | 2022-08-08
(9 rows)


muskan=# select * from employees order by id;
 id |  name   | department |  salary  | hire_date
----+---------+------------+----------+------------
  1 | Alice   | IT         | 55000.00 | 2020-03-15
  2 | Bob     | Admin      | 49500.00 | 2019-07-10
  3 | Charlie | Finance    | 55000.00 | 2021-01-05
  4 | Diana   | IT         | 68200.00 | 2018-12-01
  5 | Eve     | Finance    | 55000.00 | 2022-04-22
  7 | Grace   | IT         | 55000.00 | 2023-06-10
  8 | Heidi   | Finance    | 55000.00 | 2023-01-20
  9 | Ivan    | Admin      | 55000.00 | 2021-11-11
 10 | Judy    | IT         | 55000.00 | 2022-08-08
(9 rows)


muskan=# delete from employees where hire_date > '2020-01-01';
DELETE 7
muskan=# delete from employees where salary< 40000;
DELETE 0
muskan=# delete from employees where salary< 48000;
DELETE 0
muskan=# select * from employees order by id;
 id | name  | department |  salary  | hire_date
----+-------+------------+----------+------------
  2 | Bob   | Admin      | 49500.00 | 2019-07-10
  4 | Diana | IT         | 68200.00 | 2018-12-01
(2 rows)



=============================================================================================================

 *
 *
 *
 *
 *
muskan=# rollback;
WARNING:  there is no transaction in progress
ROLLBACK
muskan=#
muskan=# select count(*) from employees where department = 'IT';
 count
-------
     1
(1 row)


muskan=# select count(*) from employees where department = 'HR';
 count
-------
     0
(1 row)


muskan=# select count(*) from employees where department = 'Finance';
 count
-------
     0
(1 row)


muskan=# select count(*) from employees where department = 'Admin';
 count
-------
     1
(1 row)


muskan=# SELECT department, COUNT(*) AS employee_count
muskan-# FROM employees
muskan-# GROUP BY department;
 department | employee_count
------------+----------------
 Admin      |              1
 IT         |              1
(2 rows)


muskan=# select department , count(*) as employee_count
muskan-# from employee
muskan-# group by department;
ERROR:  relation "employee" does not exist
LINE 2: from employee
             ^
muskan=# select department , count(*) as employee_ct from employees group by department;
 department | employee_ct
------------+-------------
 Admin      |           1
 IT         |           1
(2 rows)


muskan=# select avg(salary) as avgsalary from employees;
     avgsalary
--------------------
 58850.000000000000
(1 row)


muskan=# select avg(salary) as avgsalary from employees where department = 'Finance';
 avgsalary
-----------

(1 row)


muskan=# select avg(salary) as avgsalary from employees where department = 'IT';
     avgsalary
--------------------
 68200.000000000000
(1 row)


muskan=# select avg(salary) as avgsalary from employees;
     avgsalary
--------------------
 58850.000000000000
(1 row)


muskan=# select max(salary) from employees;
   max
----------
 68200.00
(1 row)


muskan=# select min(salary) from employees;
   min
----------
 49500.00
(1 row)


muskan=# select max(salary) as high , min(salary) as low from employees;
   high   |   low
----------+----------
 68200.00 | 49500.00
(1 row)


muskan=# select max(salary) , min(salary) from employees;
   max    |   min
----------+----------
 68200.00 | 49500.00
(1 row)


muskan=# select department  sum(salary) from employees;
ERROR:  syntax error at or near "("
LINE 1: select department  sum(salary) from employees;
                              ^
muskan=# select  sum(salary) from employees;
    sum
-----------
 117700.00
(1 row)


muskan=#


* */
















//Rollback info

/*
If you just run regular SQL commands like UPDATE, DELETE, or INSERT without starting a transaction explicitly, PostgreSQL auto-commits them right away.

So by the time you type ROLLBACK, it's already too late — the changes are saved.
* */
