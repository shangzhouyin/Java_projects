public class armor extends itemAttributes {
    private int damageReduction;
    //constructor to initialize the variables of armor
    public armor(String name, int price, int level, int damageReduction) {
        super(name, price, level);
        this.damageReduction = damageReduction;
    }

    //override the method in the itemAttributes class to print out the item information
    @Override
    public void printAttributes() {
        System.out.println("+------------------+---------+---------+--------------------+");
        System.out.println("|      Name        |  Level  |  Price  |  Damage Reduction  |");
        System.out.println("+------------------+---------+---------+--------------------+");
        String nameCell = String.format("|%1$-18s", super.getName());
        String levelCell = String.format("|%1$-9s", super.getLevel());
        String priceCell = String.format("|%1$-9s", super.getPrice());
        String damRecCell = String.format("|%1$-19s", this.damageReduction);
        System.out.println(nameCell + levelCell + priceCell + damRecCell);
        System.out.println("+------------------+---------+---------+--------------------+");
    }

    //getter and setter method
    public int getDamageReduction() {return damageReduction;}
    public void setDamageReduction(int damageReduction) {this.damageReduction = damageReduction;}
}
