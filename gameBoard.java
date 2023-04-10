/*
 *This class is adapted from the Assignment2 board class
 */
import java.util.*;

public class gameBoard {

    protected int boardSize;
    protected cell[][] board;

    Random rand = new Random();

    //constructor to initialize the gameboard
    public gameBoard(int boardSize) {
        this.boardSize = boardSize;
        board = new cell[boardSize][boardSize];
        buildBoard();
    }

    //build the board with its boardSize
    public void buildBoard(){
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = new cell(' ');
                board[i][j].setType(' ');
            }
        }

    }


//print out the board, adapted from the last assignment
    public void printBoard(){
        for (int k = 0; k < boardSize; k++) {
            System.out.print("+---");
        }
        System.out.println("+");
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                    System.out.print("|   ");
            }
            System.out.println("|");
            for (int k = 0; k < boardSize; k++) {
                System.out.print("+---");
            }
            System.out.println("+");
        }
    }


//Getter and setter method
    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public cell[][] getBoard() {
        return board;
    }

    public void setBoard(cell[][] board) {
        this.board = board;
    }
}
