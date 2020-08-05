import java.lang.String;
import java.util.Scanner;
import java.util.*;


public class DualBall {
    public static void main(String[] args) {
        // 创建一个集合 -- HashSet(元素不重复)
        HashSet <Integer> set = new HashSet<>();

        // 红色6个号码 .
        // 创建一个Random随机数 .
        Random r = new Random();

        // 因为是HashSet集合,不能存重复元素,
        // 所以当集合长度 = 5 && 元素不重复 的时候 , 就可以了.
        while (set.size() < 6){
            int redBall = r.nextInt(33) + 1;
            set.add(redBall);
        }

        System.out.println("双色球中奖号码为:");
        System.out.print("红球是:");
        // 使用增强for循环遍历输出.
        for (Integer i : set) {
            System.out.print(i+" ");
        }
        // 蓝色球
        int blueBall = r.nextInt(16) + 1;
        System.out.println();
        System.out.println("蓝球是:"+blueBall);
    }
}