import java.lang.String;
import java.util.Scanner;

public class OrderOfDay {
    //输入年月日输出这一年的第几天，输入格式为****/**/**
    public static void main(String[] args) {
        int allday = 0;
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        Scanner read = new Scanner(System.in);
        System.out.print("请输入年月日，格式如：1997/01/01:");
        String dateStr =  read.next();
        String[] dateInt = dateStr.split("/");
        int year =  Integer.parseInt(dateInt[0]);
        int month = Integer.parseInt(dateInt[1]);
        int day = Integer.parseInt(dateInt[2]);
        for(int i = 0;i < month-1;i++){
            allday += days[i];
        }
        allday += day;
        if(((year % 4==0 && year % 100 == 0)|| year % 400 == 0)&&month > 2){
            allday++;
        }
        System.out.println(month+"月"+day+"是"+year+"年的第"+allday+"天");
    }
}