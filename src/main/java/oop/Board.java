package oop;

public class Board {
    int[][] board;

    public Board (){
        board = getStartBoard();
    }

    public int[][] getStartBoard(){
        int[][] newBoard = new int[3][3];
        for (int i = 0; i < newBoard.length; i++) {
            for (int j = 0; j < newBoard[i].length; j++) {
                newBoard[i][j] = 0;
            }

        }
        return newBoard;
    }

    public void printLayer (){
        for(int[] myArr : board){
            for(int ele : myArr){
                if(ele == 3){
                    System.out.print('O' + "\t");
                } else if (ele == 5) {
                    System.out.print('X' + "\t");
                } else {
                    System.out.print("+" + "\t");
                }
            }
            System.out.println();
        }
    }


}
