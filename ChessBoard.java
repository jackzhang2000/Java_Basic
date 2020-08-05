/*
	作业五
	程序功能：
		使用二维数组和循环实现五子棋游戏棋盘的绘制
*/

import java.util.Arrays;

public class ChessBoard {
	
	public static void main(String[] args) {
		
		// 1.声明一个二维数组（17行17列，char类型）
		char[][] chessBoard = new char[17][17];
		
		// 2.往数组里添加字符char
		//(1)添加符号“+”
		for(int i=1; i<chessBoard.length; i++) {  //行
			for(int j=1; j<chessBoard[i].length; j++) {	 //列
				chessBoard[i][j] = '+';
			}
		}
		//(2)在首行添加0~9，a~f     
		for(int j=1; j<=10; j++) {
			chessBoard[0][j] = (char)(48+j-1);
		}
		for(int j=11; j<chessBoard[0].length; j++) {
			chessBoard[0][j] = (char)(86+j);
		}
		//(3)在列首添加0~9，a~f 
		for(int i=1; i<=10; i++) {
			chessBoard[i][0] = (char)(48+i-1);
		}
		for(int i=11; i<chessBoard[0].length; i++) {
			chessBoard[i][0] = (char)(86+i);
		}
		
		// 3.打印结果
		for(int i=0; i<chessBoard.length; i++) {  //行
			for(int j=0; j<chessBoard[i].length; j++) {	 //列
				System.out.print(chessBoard[i][j] + "   ");
			}
			System.out.println();
		}
		
	}
}