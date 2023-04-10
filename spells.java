/*	This class contains spells information with basic attributes*/
public class spells extends itemAttributes  {

    private String name;
    private int price;
    private int level;
    private int damage;
    private int manaCost;
    private heroes hero;

    private spellType sp;


    //constructor to initialize the variables of spells

    public spells(String name, int price, int level,  int damage, int manaCost) {
        super(name, price, level);
        this.damage = damage;
        this.manaCost = manaCost;
        this.sp = null;
    }
//calculate the damage caused by spells
    public int spellDamage(int damage){
        int spellDam = (int)(damage + (hero.getDexterity()/10000) *damage);
        return spellDam;
    }
    //override the method in the itemAttributes class to print out the item information
    @Override
    public void printAttributes() {
        System.out.println("+------------------+---------+---------+----------+---------+---------+");
        System.out.println("|      Name        |  Type   |  Level  |  Price   | Damage  | ManaCost|");
        System.out.println("+------------------+---------+---------+----------+---------+---------+");
        String nameCell = String.format("|%1$-18s", super.getName());
        String typeCell = String.format("|%1$-9s", this.sp);
        String levelCell = String.format("|%1$-9s", super.getLevel());
        String priceCell = String.format("|%1$-9s", super.getPrice());
        String damageCell = String.format("|%1$-10s", this.damage);
        String manaCell = String.format("|%1$-9s|", this.manaCost);
        System.out.println(nameCell + typeCell + levelCell + priceCell + damageCell + manaCell);
        System.out.println("+------------------+---------+---------+----------+---------+---------+");
    }

//Getter and setter method

    public int getDamage() {return damage;}

    public void setDamage(int damage) {this.damage = damage;}

    public spellType getSp() {
        return sp;
    }

    public void setSp(spellType sp) {
        this.sp = sp;
    }

    public int getManaCost() {return manaCost;}
    public void setManaCost(int manaCost) {this.manaCost = manaCost;}
}
