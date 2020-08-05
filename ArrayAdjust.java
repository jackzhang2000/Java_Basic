/*
	作业四
	程序功能：
		自定义数组扩容，当以存储元素数量达到总容量的80%时，扩容1.5倍
		例如，总容量是 10，当输入第 8 个元素时，数组进行扩容，容量从 10 变 15。
*/

import java.util.Scanner;
import java.util.Arrays;

public class ArrayAdjust {
	
	public static void main(String[] args) {
		
		// 1.声明一个数组，比如长度为用户输入的capacity，类型为int的一维数组
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入一维数组的容量：");
		int capacity = sc.nextInt();	
		int[] arr = new int[capacity];
		System.out.println("数组的容量为：" + arr.length);
		
		// 2.提示用户在数组中存储元素，并同时检测数组容量
		System.out.println("请在数组里输入内容：");
		System.out.println("------------------------------------------");
		boolean stop = false;
		int stock = 1; //定义已存储量
		String instruct; //保存是否继续输入的指令
		
		while(!stop) {
			
			System.out.println("请输入第" + stock + "个元素:");
			arr[stock-1] = sc.nextInt();
			System.out.println();
			System.out.println(Arrays.toString(arr));
			
			//扩容
			if(stock>=arr.length*4/5) {
				System.out.println("------------------------------------------");
				System.out.println("已存储量达到了数组容量的80%, 已扩容至1.5倍");
				// 3.增加数组容量为原来的1.5倍
				int[] arr2 = new int[arr.length*3/2];
				//将原来数组的元素复制到扩容后的数组中
				for(int i=0; i<arr.length; i++) {
					arr2[i] = arr[i];
				}
				arr = arr2; //将arr指向扩容后的数组
				System.out.println("数组容量：" + arr.length + " (已存储：" + stock + ")");
				System.out.println("------------------------------------------");
			}
			
			System.out.println("------------------------------------------");
			System.out.println("是否继续输入？(y/n)");
			instruct = sc.next();
			stop = (instruct.equals("n")) ? true : false;
			
			if(stop){
				System.out.println("输入结束！" );
				System.out.println("您现在得到的数组是：");
				System.out.println("------------------------------------------");
				System.out.println(Arrays.toString(arr));
				System.out.println("------------------------------------------");
				System.out.println("数组的容量为：" + arr.length + "(已存储：" + stock + ")");
			}
			
			stock++;
		}
		
	}
}