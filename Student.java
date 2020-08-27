package com.lagou.mod3.homework;

/**
 *
 * 4. 编程题
 *
 *         使用 List 集合实现简易的学生信息管理系统，要求打印字符界面提示用户选择相应的功 能，根据用户输入的选择去实现增加、删除、修改、查找以及遍历所有学生信息的功能。
 *
 *         其中学生的信息有：学号、姓名、年龄。 要求： 尽量将功能拆分为多个.java 文件。
 *
 *         Class Student类：学生信息类，存放学生对象的信息
 * Author: Jack Zhang 15021131346
 *
 */

public class Student {

    private String stuName;
    private String stuNo;
    private int age;
    public Student() {
    }

    public Student(String stuName, String stuNo, int age) {
        this.stuName = stuName;
        this.stuNo = stuNo;
        this.age = age;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
