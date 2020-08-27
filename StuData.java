/*4. 编程题

        使用 List 集合实现简易的学生信息管理系统，要求打印字符界面提示用户选择相应的功 能，根据用户输入的选择去实现增加、删除、修改、查找以及遍历所有学生信息的功能。

        其中学生的信息有：学号、姓名、年龄。 要求： 尽量将功能拆分为多个.java 文件。

        Class StuData 类：存放学生信息的操作方法：增删改查
*/
package com.lagou.mod3.homework;

import java.util.ArrayList;
import java.util.Scanner;

public class StuData {

    private ArrayList<Student> stus = new ArrayList();

    //static int index = 0;

    Scanner scanner = new Scanner(System.in);

    /**
     * 增加学生信息
     * @param stu
     */
    public void addStu(Student stu){
        stus.add(stu);
    }

    //输入学生信息
    public void append(){

        Student stu = new Student();

        /**
         * 通过封装方法，将学生信息赋给stus
         */
        stu.setStuName(name());

        stu.setStuNo(stuNum());

        stu.setAge(age());

        //将stu中的信息增添到stus中
        addStu(stu);

        System.out.println("学生信息已添加！");
        System.out.println();
    }


    //得到学生姓名
    public String name(){

        String name;

        System.out.println("请输入学生的姓名:");
        name = scanner.next();

        return name;
    }


    //得到学生学号
    public String stuNum(){

        String stuNum;

        System.out.println("请输入学生的学号:");
        stuNum = scanner.next();


        //如果学号不为11位，则重新输入，直到学号正确
        if(stuNum.length() != 11){
            System.out.println("您输入的学号有误！请重新输入！");
            stuNum();
        }

        //如果学号已存在，则重新输入，直到不存在
        for(int i = 0; i < stus.size(); i++){
            if(stuNum.equals(stus.get(i).getStuNo())){
                System.out.println("该学号已存在！请重新输入！");
                stuNum();
                break;
            }
        }

        return stuNum;
    }

    //得到学生的年龄
    public int age(){

        int stuAge;

        System.out.println("请输入学生的年龄：");
        stuAge = scanner.nextInt();

        if(stuAge < 0 || stuAge >=  80){
            System.out.println("您输入的年龄有误！请重新输入！");
            age();
        }

        return stuAge;
    }

    /**
     *
     * 删除学生信息
     *
     * @param stuNo
     */
    public void delStu(){

        System.out.println("请输入您想删除的学号：");
        String stuNo = scanner.next();

        boolean isDel = false;

        for(int i = 0; i < stus.size(); i++){
            if(stuNo.equals(stus.get(i).getStuNo())){
                isDel = true;
                stus.remove(i);
                break;
            }
        }

        if(isDel){
            System.out.println("删除操作已完成！");
        }else{
            System.out.println("无此学生信息！");
        }
    }


    /**
     * 修改学生信息:
     * 1.姓名
     * 2.学号
     * 3.年龄
     * @param stu
     */
    public void updateStu(String stuNo){

        boolean flag = false;

        for(int i = 0; i < stus.size(); i ++){
            if(stuNo.equals(stus.get(i).getStuNo())){

                flag = true;

                information();

                switch(scanner.nextInt()){
                    case 1:
                        String name = name();
                        stus.get(i).setStuName(name);;
                        break;
                    case 2:
                        String stuNum = stuNum();
                        stus.get(i).setStuNo(stuNum);
                        break;
                    case 3:
                        int age = age();
                        stus.get(i).setAge(age);
                        break;
                    case 0:
                        System.exit(0);
                }

                break;
            }

            if(!flag)
                System.out.println("您输入的学号不存在！");
        }
    }

    public void information(){
        System.out.println("请选择您要修改的信息：");
        System.out.println("1.姓名");
        System.out.println("2.学号");
        System.out.println("3.年龄");
        System.out.println("0.退出");
        System.out.println("请输入序号：");
    }
    /**
     * 根据学号查询学生信息
     * 如果存在，输出学生信息
     * @param stuNo
     */
    public void queryStuByStuNo(String stuNo){

        boolean flag = false;

        for(int i = 0; i < stus.size(); i ++){
            if(stuNo.equals(stus.get(i).getStuNo())){
                System.out.println("姓名：" + stus.get(i).getStuName());
                System.out.println("学号：" + stus.get(i).getStuNo());
                System.out.println("年龄：" + stus.get(i).getAge());

                System.out.println("+---------------+-------------------------------+---------------+---------------+---------------+");
                System.out.println("|\t姓名\t|\t\t学号\t\t|\t年龄\t|");
                System.out.println("+---------------+-------------------------------+---------------+---------------+---------------+");
                System.out.println("|\t" + stus.get(i).getStuName() + "\t|\t    " + stus.get(i).getStuNo() + "     \t|\t"  +
                        "\t|\t"  + stus.get(i).getAge() + "\t|\t"  + "\t|");
                System.out.println("+---------------+-------------------------------+---------------+---------------+---------------+");

                flag = true;
            }
        }

        if(!flag)
            System.out.println("该学号不存在！");
    }
}