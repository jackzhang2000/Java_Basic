CREATE DATABASE IF NOT EXISTS lianxi02 DEFAULT CHARACTER SET utf8mb4 DEFAULT COLLATE utf8mb4_unicode_ci;
USE lianxi02;

# 创建部门表
CREATE TABLE dept
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20)
);

INSERT INTO dept (name)
VALUES ('开发部'),
       ('市场部'),
       ('财务部');
# 创建员工表
CREATE TABLE employee
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    name      VARCHAR(10),
    gender    CHAR(1),                         -- 性别
    salary    DOUBLE,                          -- 工资
    join_date DATE,                            -- 入职日期
    dept_id   INT,
    FOREIGN KEY (dept_id) REFERENCES dept (id) -- 外键，关联部门表(部门表的主键)
);

INSERT INTO employee(name, gender, salary, join_date, dept_id)
VALUES ('孙悟空', '男', 7200, '2013-02-24', 1);
INSERT INTO employee(name, gender, salary, join_date, dept_id)
VALUES ('猪八戒', '男', 3600, '2010-12-02', 2);
INSERT INTO employee(name, gender, salary, join_date, dept_id)
VALUES ('唐僧', '男', 9000, '2008-08-08', 2);
INSERT INTO employee(name, gender, salary, join_date, dept_id)
VALUES ('白骨精', '女', 5000, '2015-10-07', 3);
INSERT INTO employee(name, gender, salary, join_date, dept_id)
VALUES ('蜘蛛精', '女', 4500, '2011-03-14', 1);

# 1) 查询工资最高的员工是谁？
SELECT *
FROM lianxi02.employee
WHERE salary = (SELECT max(salary) FROM lianxi02.employee);

# 2) 查询工资小于平均工资的员工有哪些？
SELECT *
FROM lianxi02.employee
WHERE salary < (SELECT avg(salary) FROM lianxi02.employee);
# 3) 查询大于5000的员工，来至于哪些部门，输出部门的名字
SELECT *
FROM lianxi02.dept
WHERE id IN (SELECT dept_id FROM employee WHERE salary > 5000);
# 4) 查询开发部与财务部所有的员工信息，分别使用子查询和表连接实现
SELECT *
FROM lianxi02.employee
WHERE dept_id IN (SELECT id FROM lianxi02.dept WHERE dept.name IN ('开发部', '财务部'));

SELECT *
FROM lianxi02.employee e
         JOIN lianxi02.dept d ON d.id = e.dept_id
WHERE d.name IN ('开发部', '财务部');
# 5) 查询2011年以后入职的员工信息和部门信息，分别使用子查询和表连接实现
SELECT id, name, gender, salary, join_date, dept_id, (SELECT dept.name FROM lianxi02.dept WHERE dept.id = dept_id)
FROM lianxi02.employee
WHERE year(join_date) > 2011;

SELECT e.id, e.name, e.gender, e.salary, e.join_date, e.dept_id, d.id, d.name
FROM lianxi02.employee e
         JOIN lianxi02.dept d ON d.id = e.dept_id
WHERE  year(e.join_date) > 2011;

DROP DATABASE IF EXISTS lianxi02;