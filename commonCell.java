/*This class extends from cell, one type of cells in the gameboard*/
import java.util.ArrayList;


public class commonCell extends cell{

    private double prob;
    battleField battle;

    //constructor to initialize the type variable since it might be set to 'H' when hero get into common space
    public commonCell(char type) {
        super(type);
        setType(type);
        this.prob = 0.2;
    }

    //this method is to invoke the battle based on the random numbers and probability
    public void rollADice(ArrayList<heroes> playerList){
        double rand = Math.random();
        if(rand> this.prob){
           battle = new battleField(playerList);
           battle.battleStart();
        }else{
            System.out.println(ConsoleColor.ANSI_RED+"Continue move, No battle this time"+ConsoleColor.ANSI_RESET);
            System.out.println();
        }

    }

    //Getter and setter method
    public double getProb() {return prob;}

    public void setProb(double prob) {this.prob = prob;}
}
