/*
*This class is adapted from the Assignment2 cell class, it only has one variable type, can be 'M' as market, ' ' as common place and 'I' as inaccessible place
*/
public class cell {
    private char type;

    public cell(char type) {
        this.type = type;
    }

    //Getter and setter method
    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }
}
