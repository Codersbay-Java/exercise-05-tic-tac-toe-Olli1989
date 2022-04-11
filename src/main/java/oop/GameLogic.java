package oop;

import java.util.Random;
import java.util.Scanner;

public class GameLogic {
    private Scanner scanner = new Scanner(System.in);
    private Random rand = new Random();

    public GameLogic(){}

    public int getNumber(){
        return scanner.nextInt();
    }

    public int getRandomNumber(){
        return rand.nextInt(3);
    }

    public int getNumberBetweenOneAndTwo(){
        System.out.println("Choose number between 1 and 2:");
        int number = getNumber();
        while(number < 1 || number > 2){
            System.out.println("Please insert the correct Number");
            number = getNumber();
        }
        return number;
    }

    public int getNumberBetweenOneAndThree(){
        System.out.println("Choose number between 1 and 3:");
        int number = getNumber();
        while(number < 1 || number > 3){
            System.out.println("Please insert the correct Number");
            number = getNumber();
        }
        return number-1;
    }

    public boolean checkIfChoosen(int[][] board, int row, int col){
        if(board[row][col] != 0 ){
            return true;
        }
        return false;
    }

    public boolean checkIfWinner (int[][] arr) {
        int sum1 = checkDiagonal1(arr);
        int sum2 = checkDiagonal2(arr);
        int sum3 = sumRow(arr, 0);
        int sum4 = sumRow(arr, 1);
        int sum5 = sumRow(arr, 2);
        int sum6 = sumCol(arr, 0);
        int sum7 = sumCol(arr, 1);
        int sum8 = sumCol(arr, 2);

        if(sum1==9 || sum2==9 || sum3==9 || sum4==9 || sum5==9 || sum6==9 || sum7==9 || sum8==9 || sum1== 15|| sum2==15 || sum3==15 || sum4==15 || sum5==15 || sum6==15 || sum7==15 || sum8==15){
            return true;
        }

        return false;
    }

    public int checkDiagonal1(int[][] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][i];
        }
        return sum;
    }
    public int checkDiagonal2(int[][] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum+= arr[i][arr.length-i-1];
        }
        return sum;
    }
    public int sumRow(int[][] arr, int row) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[row][i];
        }
        return sum;
    }
    public int sumCol(int[][] arr, int col) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i][col];
        }
        return sum;
    }
}
