/*This class contains potion information with basic attributes*/
public class potion extends itemAttributes{
    private int attrIncrease;
    private String[] attrAffected;


    //constructor to initialize the potion
    public potion(String name, int price, int level, int attrIncrease, String[] attrAffected) {
        super(name, price, level);
        this.attrIncrease = attrIncrease;
        this.attrAffected = attrAffected;
    }

    //override the method in the itemAttributes class to print out the item information
    @Override
    public void printAttributes() {
        System.out.println("+------------------+---------+---------+-------------------+-------------------------+");
        System.out.println("|      Name        |  Level  |  Price  |Attributes Increase|    Affected Attributes  |");
        System.out.println("+------------------+---------+---------+-------------------+-------------------------+");
        String nameCell = String.format("|%1$-18s", super.getName());
        String levelCell = String.format("|%1$-9s", super.getLevel());
        String priceCell = String.format("|%1$-9s", super.getPrice());
        String attrCell = String.format("|%1$-19s", this.attrIncrease);
        String affectCell = String.format("|%1$-25s|", this.attrAffected);
        System.out.println(nameCell + levelCell + priceCell + attrCell + affectCell);
        System.out.println("+------------------+---------+---------+-------------------+-------------------------+");
    }

    //Getter and setter method
    public int getAttrIncrease() {
        return attrIncrease;
    }

    public void setAttrIncrease(int attrIncrease) {
        this.attrIncrease = attrIncrease;
    }

    public String[] getAttrAffected() {
        return attrAffected;
    }

    public void setAttrAffected(String[] attrAffected) {
        this.attrAffected = attrAffected;
    }


}
