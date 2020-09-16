CREATE DATABASE IF NOT EXISTS lianxi04 DEFAULT CHARACTER SET utf8mb4 DEFAULT COLLATE utf8mb4_unicode_ci;
USE lianxi04;
CREATE TABLE lagou_teacher
(
    id           INT PRIMARY KEY, -- 讲师ID 主键 int类型
    name         VARCHAR(20),     -- 讲师姓名 VARCHAR类型
    introduction VARCHAR(100),    -- 讲师简介 VARCHAR类型
    level        CHAR(4),         -- 讲师级别 char类型 高级讲师&首席讲师
    INDEX index_name (name)       -- 为讲师姓名添加索引

);
CREATE TABLE lagou_subject
(
    id           INT PRIMARY KEY, -- 课程分类ID 主键 int类型
    name         VARCHAR(20),     -- 课程分类名称 VARCHAR类型 比如前端开发 后端开发 数据库DBA......
    introduction VARCHAR(100),    -- 课程分类描述 VARCHAR类型
    creat_time   DATETIME,        -- 创建时间 datetime类型
    update_time  DATETIME         -- 更新时间 datetime类型
);

CREATE TABLE lagou_course
(
    id               INT PRIMARY KEY,                                                           -- 课程ID 主键 int类型
    lagou_teacher_id INT,                                                                       -- 课程讲师ID 外键 用于描述课程的授课老师
    lagou_subject_id INT,                                                                       -- 课程分类ID 外键 用于描述课程所属的分类 比如 Java课程就属于后端分类
    title            VARCHAR(20),                                                               -- 课程标题 VARCHAR类型 比如Java VUE PHP ......
    courses          INT,                                                                       -- 总课时 int类型
    visits           INT,                                                                       -- 浏览数量 bigint类型
    state            CHAR(1) DEFAULT 0,                                                         -- 课程状态 char 类型,  0 未发布(默认)  1 已发布
    INDEX index_title (title),                                                                  -- 为课程标题字段添加索引
    CONSTRAINT lagou_teacher_id_fk FOREIGN KEY (lagou_teacher_id) REFERENCES lagou_teacher (id),
    CONSTRAINT lagou_subject_id_fk FOREIGN KEY (lagou_subject_id) REFERENCES lagou_subject (id) -- 为teacher_id & subject_id,添加外键约束

);
-- 向讲师表插入两条数据
INSERT INTO lagou_teacher
VALUES (1, '刘德华', '毕业于清华大学，主攻前端技术,授课风格生动活泼,深受学员喜爱',
        '高级讲师');
INSERT INTO lagou_teacher
VALUES (2, '郭富城', '毕业于北京大学，多年的IT经验，研发多项Java课题,授课经验丰富',
        '首席讲师');
-- 向课程分类表中插入两条数据
INSERT INTO lagou_subject
VALUES (1, '后端开发', '后端课程包括 Java PHP Python', '2020-03-27 00:44:04', '2020-03-27 00:44:04');
INSERT INTO lagou_subject
VALUES (2, '前端开发', '前端课程包括 JQuery VUE angularJS', '2020-02-27 10:00:04', '2020-02-27 18:44:04');
-- 向课程表中插入两条数据
-- 插入Java课程
INSERT INTO lagou_course
VALUES (1, 1, 1, 'Java', 300, 250000, '1');
-- 插入VUE课程
INSERT INTO lagou_course
VALUES (2, 2, 2, 'VUE', 400, 200000, '1');

# 查询刘德华老师所教的课程属于哪个课程分类
SELECT t.name,ls.name
FROM lianxi04.lagou_teacher t
         JOIN lagou_course lc ON t.id = lc.lagou_teacher_id
join lagou_subject ls ON lc.lagou_subject_id = ls.id
where t.name='刘德华';

DROP DATABASE IF EXISTS lianxi04;