/*	This class contains spells information with basic attributes*/

public class weapon extends itemAttributes{
    private int damage;
    private int handsNum;
    //constructor to initialize the variables of weapon
    public weapon(String name, int price, int level, int damage, int handsNum) {
        super(name, price, level);
        this.damage = damage;
        this.handsNum = handsNum;
    }
    //override the method in the itemAttributes class to print out the item information
    @Override
    public void printAttributes() {
        System.out.println("+------------------+---------+---------+----------+---------+");
        System.out.println("|      Name        |  Level  |  Price  |  Damage  | #Hands  |");
        System.out.println("+------------------+---------+---------+----------+---------+");
        String nameCell = String.format("|%1$-18s", this.getName());
        String levelCell = String.format("|%1$-9s", this.getLevel());
        String priceCell = String.format("|%1$-9s", this.getPrice());
        String damageCell = String.format("|%1$-10s", this.damage);
        String handsCell = String.format("|%1$-9s|", this.handsNum);
        System.out.println(nameCell + levelCell + priceCell + damageCell + handsCell);
        System.out.println("+------------------+---------+---------+----------+---------+");
    }
//Getter and setter method
    public int getDamage() {return damage;}

    public void setDamage(int damage) {this.damage = damage;}

    public int getHandsNum() {return handsNum;}

    public void setHandsNum(int handsNum) {this.handsNum = handsNum;}
}
