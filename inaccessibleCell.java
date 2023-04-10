/*This class extends from cell, one type of cells in the gameboard, heroes are not able to get into this cell*/
public class inaccessibleCell extends cell{
    //constructor to initialize the variables
    public inaccessibleCell(char type) {
        super(type);
        setType(type);
    }

}
