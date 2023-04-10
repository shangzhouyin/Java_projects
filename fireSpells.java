/*This class extends from Spells as one type of spells*/
public class fireSpells extends spells{
    private int monsterDefenseReduce;
    private spellType type;
    private monsters monster;

    //constructor to initialize the variables of fire spells
    public fireSpells(String name, int price, int level, int damage, int manaCost) {
        super(name, price, level, damage, manaCost);
        super.setSp(spellType.FIRE);
    }




    //Getter and setter method
    public spellType getType() {
        return type;
    }

    public int getMonsterDefenceReduce() {return monsterDefenseReduce;}

    public void setMonsterDefenceReduce(int monsterDefenceReduce) {
        this.monsterDefenseReduce = monsterDefenceReduce;
    }
}
