import java.lang.String;
import java.util.Scanner;

public class OrderOfDay {
    //���������������һ��ĵڼ��죬�����ʽΪ****/**/**
    public static void main(String[] args) {
        int allday = 0;
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        Scanner read = new Scanner(System.in);
        System.out.print("�����������գ���ʽ�磺1997/01/01:");
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
        System.out.println(month+"��"+day+"��"+year+"��ĵ�"+allday+"��");
    }
}