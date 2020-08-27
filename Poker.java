/*5. 编程题

        使用集合实现斗地主游戏的部分功能，要求如下：

        （1）首先准备 54 张扑克牌并打乱顺序。

        （2）由三个玩家交替摸牌，每人 17 张扑克牌，最后三张留作底牌。

        （3）查看三个玩家手中的扑克牌和底牌。

        （4）其中玩家手中的扑克牌需要按照大小顺序打印，规则如下：

        手中扑克牌从大到小的摆放顺序：大王,小王,2,A,K,Q,J,10,9,8,7,6,5,4,3
        */
package com.lagou.mod3.homework;
import java.util.ArrayList;
import java.util.Collections;

public class Poker {

    public static void main(String[] args) {
        //1.准备牌
        ArrayList<String> puker=new ArrayList<>();
        puker.add("大王");
        puker.add("小王");
        String colors []={"♥","♦","♠","♣"};
        String nums []={"2","A","K","Q","J","10","9","8","7","6","5","4","3"};
        for (String color : colors) {
            for (String num : nums) {
                puker.add(num+color);
            }
        }
        //2.洗牌
        Collections.shuffle(puker);
        //3.发牌
        ArrayList<String> player01=new ArrayList<>();
        ArrayList<String> player02=new ArrayList<>();
        ArrayList<String> player03=new ArrayList<>();
        ArrayList<String> dipai=new ArrayList<>();
        for (int i = 0; i < puker.size(); i++) {
            if (i>=51){
                dipai.add(puker.get(i));
            }else if (i%3==0){
                player01.add(puker.get(i));
            }else if (i%3==1){
                player02.add(puker.get(i));
            }else if (i%3==2){
                player03.add(puker.get(i));
            }
        }
        //4.看牌
        System.out.println("刘德华"+player01);
        System.out.println("周润发"+player02);
        System.out.println("周星驰"+player03);
        System.out.println("底牌"+dipai);
    }
}


