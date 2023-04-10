/*This class extends from Spells as one type of spells*/
public class iceSpells extends spells{
private int heroDamageReduce;
private monsters monster;
private spellType type;

    //constructor to initialize the variables of ice spells
    public iceSpells(String name, int price, int level, int damage, int manaCost) {
        super(name, price, level, damage, manaCost);
        super.setSp(spellType.ICE);
    }






//Getter and setter method
    public int getHeroDamageReduce() {
        return heroDamageReduce;
    }

    public void setHeroDamageReduce(int heroDamageReduce) {
        this.heroDamageReduce = heroDamageReduce;
    }

}
