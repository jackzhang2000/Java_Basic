/*
	��ҵ��
	�����ܣ�
		�Զ����������ݣ����Դ洢Ԫ�������ﵽ��������80%ʱ������1.5��
		���磬�������� 10��������� 8 ��Ԫ��ʱ������������ݣ������� 10 �� 15��
*/

import java.util.Scanner;
import java.util.Arrays;

public class ArrayAdjust {
	
	public static void main(String[] args) {
		
		// 1.����һ�����飬���糤��Ϊ�û������capacity������Ϊint��һά����
		Scanner sc = new Scanner(System.in);
		
		System.out.println("������һά�����������");
		int capacity = sc.nextInt();	
		int[] arr = new int[capacity];
		System.out.println("���������Ϊ��" + arr.length);
		
		// 2.��ʾ�û��������д洢Ԫ�أ���ͬʱ�����������
		System.out.println("�����������������ݣ�");
		System.out.println("------------------------------------------");
		boolean stop = false;
		int stock = 1; //�����Ѵ洢��
		String instruct; //�����Ƿ���������ָ��
		
		while(!stop) {
			
			System.out.println("�������" + stock + "��Ԫ��:");
			arr[stock-1] = sc.nextInt();
			System.out.println();
			System.out.println(Arrays.toString(arr));
			
			//����
			if(stock>=arr.length*4/5) {
				System.out.println("------------------------------------------");
				System.out.println("�Ѵ洢���ﵽ������������80%, ��������1.5��");
				// 3.������������Ϊԭ����1.5��
				int[] arr2 = new int[arr.length*3/2];
				//��ԭ�������Ԫ�ظ��Ƶ����ݺ��������
				for(int i=0; i<arr.length; i++) {
					arr2[i] = arr[i];
				}
				arr = arr2; //��arrָ�����ݺ������
				System.out.println("����������" + arr.length + " (�Ѵ洢��" + stock + ")");
				System.out.println("------------------------------------------");
			}
			
			System.out.println("------------------------------------------");
			System.out.println("�Ƿ�������룿(y/n)");
			instruct = sc.next();
			stop = (instruct.equals("n")) ? true : false;
			
			if(stop){
				System.out.println("���������" );
				System.out.println("�����ڵõ��������ǣ�");
				System.out.println("------------------------------------------");
				System.out.println(Arrays.toString(arr));
				System.out.println("------------------------------------------");
				System.out.println("���������Ϊ��" + arr.length + "(�Ѵ洢��" + stock + ")");
			}
			
			stock++;
		}
		
	}
}