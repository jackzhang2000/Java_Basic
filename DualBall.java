import java.lang.String;
import java.util.Scanner;
import java.util.*;


public class DualBall {
    public static void main(String[] args) {
        // ����һ������ -- HashSet(Ԫ�ز��ظ�)
        HashSet <Integer> set = new HashSet<>();

        // ��ɫ6������ .
        // ����һ��Random����� .
        Random r = new Random();

        // ��Ϊ��HashSet����,���ܴ��ظ�Ԫ��,
        // ���Ե����ϳ��� = 5 && Ԫ�ز��ظ� ��ʱ�� , �Ϳ�����.
        while (set.size() < 6){
            int redBall = r.nextInt(33) + 1;
            set.add(redBall);
        }

        System.out.println("˫ɫ���н�����Ϊ:");
        System.out.print("������:");
        // ʹ����ǿforѭ���������.
        for (Integer i : set) {
            System.out.print(i+" ");
        }
        // ��ɫ��
        int blueBall = r.nextInt(16) + 1;
        System.out.println();
        System.out.println("������:"+blueBall);
    }
}