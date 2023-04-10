/*	This abstract class is extended by weapon, potion, armor and spells since they all share some common attributes*/

public abstract class itemAttributes {

    protected String name;
    protected int price;

    protected int level;

    //constructor to initialize variables of the items
    public itemAttributes(String name, int price, int level) {
        this.name = name;
        this.price = price;
        this.level = level;
    }

//abstract method to print out each item's attributes
    public abstract void printAttributes();


    //Getter and setter methods

    public String getName() {return name;}
    public int getPrice() {return price;}

    public int getLevel() {return level;}
    public void setName(String name) {this.name = name;}
    public void setPrice(int price) {this.price = price;}
    public void setLevel(int level) {this.level = level;}



}
