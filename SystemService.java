
/**
 *
 * 4. 编程题
 *
 *         使用 List 集合实现简易的学生信息管理系统，要求打印字符界面提示用户选择相应的功 能，根据用户输入的选择去实现增加、删除、修改、查找以及遍历所有学生信息的功能。
 *
 *         其中学生的信息有：学号、姓名、年龄。 要求： 尽量将功能拆分为多个.java 文件。
 *
 *         Class SystemService：系统入口和功能菜单类
 * Author: Jack Zhang 15021131346
 *
 */
package com.lagou.mod3.homework;

import java.util.Scanner;
public class SystemService {

    Scanner scanner = new Scanner(System.in);

    public void bulletin(){
        System.out.println("1.添加学生信息");
        System.out.println("2.删除学生信息");
        System.out.println("3.修改学生信息");
        System.out.println("4.查询学生信息");
        System.out.println("0.退出系统");

        System.out.println("请输入序号：");
    }

    public void serviceChoose(){

        StuData sd = new StuData();
        System.out.println("-----欢迎使用学生信息管理系统-----");
        while(true){

            bulletin();

            switch(scanner.nextInt()){
                case 1:
                    sd.append();
                    System.out.println();
                    break;
                case 2:
                    sd.delStu();
                    System.out.println();
                    break;
                case 3:
                    System.out.println("请输入要修改的学生的学号：");
                    sd.updateStu(scanner.next());
                    System.out.println();
                    break;
                case 4:
                    System.out.println("请输入要查询的学生的学号：");
                    sd.queryStuByStuNo(scanner.next());
                    System.out.println();
                    break;
                case 0:
                    System.exit(0);//退出系统
            }
        }
    }

    public static void main(String[] args) {
        SystemService ss = new SystemService();
        ss.serviceChoose();
    }
}
