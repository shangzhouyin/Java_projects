/*This class extends from Spells as one type of spells*/
public class lightningSpells extends spells{
    private float dodgeChanceReduce;

    private monsters monster;

    //constructor to initialize the variables of lightning spells
    public lightningSpells(String name, int price, int level, int damage, int manaCost) {
        super(name, price, level, damage, manaCost);
        super.setSp(spellType.LIGHTNING);
    }




    //Getter and setter method
    public float getDodgeChanceReduce() {
        return dodgeChanceReduce;
    }

    public void setDodgeChanceReduce(float dodgeChanceReduce) {
        this.dodgeChanceReduce = dodgeChanceReduce;
    }
}
