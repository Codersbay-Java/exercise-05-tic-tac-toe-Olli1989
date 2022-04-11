package application;

import java.util.Scanner;

public class Main {
	public static final int BOARD_SIZE = 3;

	public static void main(String[] args) {
		int[][] board = new int[BOARD_SIZE][BOARD_SIZE];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = -10;
			}
		}
		Scanner scanner = new Scanner(System.in);

		int i = 0;
		boolean won= false;
		boolean player1 = true;

		int row,column = 0;
		System.out.println("TIK TAK TOE");
		System.out.println("Player one to start: ");
		printLayer(board);

		while (i <= 8 && !won){
			if(player1){
				System.out.println("Player one please choose your field: ");
			} else {
				System.out.println("Player two please choose your field");
			}
			do {
				System.out.print("Please choose the row: ");
				row = scanner.nextInt()-1;
				System.out.print("Please choose the column: ");
				column = scanner.nextInt()-1;
			} while((row < 0) || (row > 2) || (column < 0) || (column > 2) || checkIfChoosen(board, row, column) );


			if(player1) {
				board[row][column]=1;
			} else {
				board[row][column]=2;
			}

			player1 = !player1;

			won=checkIfWinner(board);
			printLayer(board);


			if(i == 8 && !won){
				System.out.println("Nobody won");
				won = true;
			}


			i++;
		}

		System.out.println("Congratulation");
	}

	static int checkDiagonal1(int[][] arr){
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i][i];
		}
		return sum;
	}
	static int checkDiagonal2(int[][] arr){
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum+= arr[i][arr.length-i-1];
		}
		return sum;
	}
	static int sumRow(int[][] arr, int row) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[row][i];
		}
		return sum;
	}
	static int sumCol(int[][] arr, int col) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i][col];
		}
		return sum;
	}

	static boolean checkIfWinner (int[][] arr) {
		int sum1 = checkDiagonal1(arr);
		int sum2 = checkDiagonal2(arr);
		int sum3 = sumRow(arr, 0);
		int sum4 = sumRow(arr, 1);
		int sum5 = sumRow(arr, 2);
		int sum6 = sumCol(arr, 0);
		int sum7 = sumCol(arr, 1);
		int sum8 = sumCol(arr, 2);

		if(sum1==6 || sum2==6 || sum3==6 || sum4==6 || sum5==6 || sum6==6 || sum7==6 || sum8==6){
			System.out.println();
			System.out.println("Player two has won");
			return true;
		} else if(sum1== 3|| sum2==3 || sum3==3 || sum4==3 || sum5==3 || sum6==3 || sum7==3 || sum8==3){
			System.out.println();
			System.out.println("Player one has won");
			return true;
		}

		return false;
	}

	static void printLayer (int[][] arr){
		for(int[] myArr : arr){
			for(int ele : myArr){
				if(ele == 1){
					System.out.print('O' + "\t");
				} else if (ele == 2) {
					System.out.print('X' + "\t");
				} else {
					System.out.print("+" + "\t");
				}
			}
			System.out.println();
		}
	}

	static boolean checkIfChoosen(int[][] arr, int row, int col){
		if(arr[row][col] != -10 ){
			return true;
		}

		return false;
	}
}
