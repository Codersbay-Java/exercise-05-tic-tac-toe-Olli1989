package oop;

public class Main {
    public static void main(String[] args) {
        GameLogic gameLogic = new GameLogic();
        Board board = new Board();
        Player player1 = new Player("Player 1", 1 , true);
        Player player2 = new Player("Player 2", 1 , false);
        int chooseOpponent = 0;
        int rounds = 1;
        int row = 0, col = 0;

        System.out.println("Do you wanna play against a computer(1) or a second Player(2):");
        chooseOpponent = gameLogic.getNumberBetweenOneAndTwo();

        board.printLayer();

        switch (chooseOpponent) {
            case 1:
                player1 = new Player("Player 1", 1 , true);
                player2 = new Player("Player 2", 1 , false);
                break;
            case 2:
                player1 = new Player("Player 1", 1 , true);
                player2 = new Player("Player 2", 2 , false);
                break;
            default:
                break;
        }

        while(rounds <= 9){
            if(player1.isHisTurn){
                System.out.println("It's your turn " + player1.name);
            } else if(player2.isHisTurn){
                System.out.println("It's your turn " + player2.name);
            }

            if (player1.isHisTurn || (player2.isHisTurn && player2.type == 1)){
                row = gameLogic.getNumberBetweenOneAndThree();
                col = gameLogic.getNumberBetweenOneAndThree();
                while(gameLogic.checkIfChoosen(board.board, row, col)){
                    System.out.println("Field is already taken please choose a other one!");
                    row = gameLogic.getNumberBetweenOneAndThree();
                    col = gameLogic.getNumberBetweenOneAndThree();
                }
            } else if(player2.isHisTurn && player2.type == 2) {
                if(gameLogic.sumRow(board.board, 0) == 10){
                    row = 0;
                    for (int i = 0; i <board.board[row].length; i++) {
                        if(board.board[row][i]==0){
                            col = i;
                        }
                    }
                } else if(gameLogic.sumRow(board.board, 1) == 10){
                    row = 1;
                    for (int i = 0; i <board.board[row].length; i++) {
                        if(board.board[row][i]==0){
                            col = i;
                        }
                    }
                } else if(gameLogic.sumRow(board.board, 2) == 10){
                    row = 2;
                    for (int i = 0; i <board.board[row].length; i++) {
                        if(board.board[row][i]==0){
                            col = i;
                        }
                    }
                } else if(gameLogic.sumCol(board.board, 0) == 10){
                    col = 0;
                    for (int i = 0; i <board.board.length; i++) {
                        if(board.board[i][col]==0){
                            row = i;
                        }
                    }
                } else if(gameLogic.sumCol(board.board, 1) == 10){
                    col = 1;
                    for (int i = 0; i <board.board.length; i++) {
                        if(board.board[i][col]==0){
                            row = i;
                        }
                    }
                } else if(gameLogic.sumCol(board.board, 2) == 10){
                    col = 2;
                    for (int i = 0; i <board.board.length; i++) {
                        if(board.board[i][col]==0){
                            row = i;
                        }
                    }
                } else if(gameLogic.checkDiagonal1(board.board)==10){
                    if(board.board[0][0] == 0){
                        row = 0;
                        col = 0;
                    } else if (board.board[1][1] == 0){
                        row = 1;
                        col = 1;
                    } else if (board.board[2][2] == 0){
                        row = 2;
                        col = 2;
                    }
                } else if(gameLogic.checkDiagonal2(board.board)==10){
                    if(board.board[0][2] == 0){
                        row = 0;
                        col = 0;
                    } else if (board.board[1][1] == 0){
                        row = 1;
                        col = 1;
                    } else if (board.board[2][0] == 0){
                        row = 2;
                        col = 2;
                    }
                } else {
                    do {
                        row = gameLogic.getRandomNumber();
                        col = gameLogic.getRandomNumber();
                    } while(gameLogic.checkIfChoosen(board.board,row,col));
                }

            }

            if(player1.isHisTurn){
                board.board[row][col] = 3;
            } else if(player2.isHisTurn){
                board.board[row][col] = 5;
            }

            board.printLayer();

            if(gameLogic.checkIfWinner(board.board)){
                System.out.println("Congratulation");
                if(player1.isHisTurn){
                    System.out.println(player1.name + " has won.");
                } else if(player2.isHisTurn) {
                    System.out.println(player2.name + " has won.");
                }
                break;
            }

            if(rounds == 9){
                System.out.println("It's a draw");
            }

            player1.isHisTurn = !player1.isHisTurn;
            player2.isHisTurn = !player2.isHisTurn;

            rounds++;
        }

    }
}
