package oop;

public class Player {
    public String name;
    public int type;//1: player, 2: Computer
    public boolean isHisTurn;


    public Player(){
        name = "Player";
        type = 1;
        isHisTurn = false;
    }

    public Player (String name, int type, boolean isHisTurn){
        this.name = name;
        this.type = type;
        this.isHisTurn = isHisTurn;
    }



}
