/*This class is to create the game map*/
import java.util.*;
public class worldMap extends gameBoard {
    //initialize the variables
    private int inaccessibleNum;
    private int commonNum;
    private int marketNum;
    private int heroX;
    private int heroY;

    ArrayList<armor> itemListA  = new ArrayList<>();
    ArrayList<weapon> itemListW  = new ArrayList<>();
    ArrayList<potion> itemListP  = new ArrayList<>();
    ArrayList<spells> itemListS  = new ArrayList<>();

    private double prob;
    ArrayList<heroes> playerList;



//constructor to initialize the worldmap with attributes boardSize, playerList
    public worldMap(int boardSize, ArrayList<heroes> playerList) {
        super(boardSize);
        this.playerList  = playerList;
        this.prob = 0.5;
    }


//create the world map , randomly select a place as hero, initialize 20% cells as inaccessible place, 30% cells as market place, and the rest will be common place which might have a battle there
    public void creatBoardMap(){
        Set<String> selectedCells = new HashSet<String>();
        inaccessibleNum = (int)(boardSize * boardSize * 0.2);
        marketNum = (int)(boardSize * boardSize * 0.3);
        commonNum = boardSize*boardSize-inaccessibleNum-marketNum;

        //initialize hero coordinates
        heroX = rand.nextInt(boardSize);
        heroY = rand.nextInt(boardSize);

        board[heroX][heroY]= new commonCell(' ');
        board[heroX][heroY].setType('H');

        selectedCells.add(heroX + "/" + heroY);
        int i = 0;

        //randomly select inaccessible cells
        while(i<inaccessibleNum){
            int row_random = rand.nextInt(boardSize);
            int col_random = rand.nextInt(boardSize);
            String pos = row_random + "/" + col_random;
            if(!selectedCells.contains(pos) ){
                board[row_random][col_random] = new inaccessibleCell('I');
                selectedCells.add(pos);
                i++;
            }
        }


        //randomly select common cells
        int c = 0;
        while(c<commonNum-1){
            int row_random = rand.nextInt(boardSize);
            int col_random = rand.nextInt(boardSize);
            String pos = row_random + "/" + col_random;
            if(!selectedCells.contains(pos) ){
                board[row_random][col_random] = new commonCell(' ');
                selectedCells.add(pos);
                c++;
            }
        }

        //randomly select market cells
        int m = 0;
        while(m<marketNum){
            int row_random = rand.nextInt(boardSize);
            int col_random = rand.nextInt(boardSize);
            String pos = row_random + "/" + col_random;
            if(!selectedCells.contains(pos) ){
                board[row_random][col_random] = new marketCell();
                selectedCells.add(pos);
                m++;
            }
        }
    }


    //override the printboard() method in the gameboard class to print out the colorful worldmap
    @Override
    public void printBoard() {
        for (int k = 0; k < boardSize; k++) {
            System.out.print("+---");
        }
        System.out.println("+");
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (board[i][j] instanceof inaccessibleCell) {
                    System.out.print("| ");
                    System.out.print(ConsoleColor.ANSI_BLUE + board[i][j].getType() + ConsoleColor.ANSI_RESET + " ");
                } else if (board[i][j] instanceof marketCell) {
                    System.out.print("| ");
                    System.out.print(ConsoleColor.ANSI_YELLOW + board[i][j].getType() + ConsoleColor.ANSI_RESET + " ");
                } else if(board[i][j] instanceof commonCell ) {
                    if(i == heroX && j == heroY){
                        System.out.print("| ");
                        System.out.print(ConsoleColor.ANSI_RED + board[i][j].getType() + ConsoleColor.ANSI_RESET + " ");
                    }else{
                        System.out.print("| " + board[i][j].getType() + " ");
                    }
                }
            }
            System.out.println("|");
            for (int k = 0; k < boardSize; k++) {
                System.out.print("+---");
            }
            System.out.println("+");
        }
    }

    //getter and setter method
    public int getInaccessibleNum() {return inaccessibleNum;}

    public void setInaccessibleNum(int inaccessibleNum) {this.inaccessibleNum = inaccessibleNum;}

    public int getCommonNum() {return commonNum;}

    public void setCommonNum(int commonNum) {this.commonNum = commonNum;}

    public int getMarketNum() {return marketNum;}

    public void setMarketNum(int marketNum) {this.marketNum = marketNum;}

    public int getHeroX() {return heroX;}

    public void setHeroX(int heroX) {this.heroX = heroX;}

    public int getHeroY() {return heroY;}

    public void setHeroY(int heroY) {this.heroY = heroY;}


    public ArrayList<armor> getItemListA() {return itemListA;}

    public void setItemListA(ArrayList<armor> itemListA) {this.itemListA = itemListA;}

    public ArrayList<weapon> getItemListW() {return itemListW;}

    public void setItemListW(ArrayList<weapon> itemListW) {this.itemListW = itemListW;}

    public ArrayList<potion> getItemListP() {return itemListP;}

    public void setItemListP(ArrayList<potion> itemListP) {this.itemListP = itemListP;}

    public ArrayList<spells> getItemListS() {return itemListS;}

    public void setItemListS(ArrayList<spells> itemListS) {this.itemListS = itemListS;}
}

