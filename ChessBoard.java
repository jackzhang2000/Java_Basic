/*
	��ҵ��
	�����ܣ�
		ʹ�ö�ά�����ѭ��ʵ����������Ϸ���̵Ļ���
*/

import java.util.Arrays;

public class ChessBoard {
	
	public static void main(String[] args) {
		
		// 1.����һ����ά���飨17��17�У�char���ͣ�
		char[][] chessBoard = new char[17][17];
		
		// 2.������������ַ�char
		//(1)��ӷ��š�+��
		for(int i=1; i<chessBoard.length; i++) {  //��
			for(int j=1; j<chessBoard[i].length; j++) {	 //��
				chessBoard[i][j] = '+';
			}
		}
		//(2)���������0~9��a~f     
		for(int j=1; j<=10; j++) {
			chessBoard[0][j] = (char)(48+j-1);
		}
		for(int j=11; j<chessBoard[0].length; j++) {
			chessBoard[0][j] = (char)(86+j);
		}
		//(3)���������0~9��a~f 
		for(int i=1; i<=10; i++) {
			chessBoard[i][0] = (char)(48+i-1);
		}
		for(int i=11; i<chessBoard[0].length; i++) {
			chessBoard[i][0] = (char)(86+i);
		}
		
		// 3.��ӡ���
		for(int i=0; i<chessBoard.length; i++) {  //��
			for(int j=0; j<chessBoard[i].length; j++) {	 //��
				System.out.print(chessBoard[i][j] + "   ");
			}
			System.out.println();
		}
		
	}
}