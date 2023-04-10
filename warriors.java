/*This class extends from heroes class as one type of hero*/
public class warriors extends heroes{
    public warriors(String name, int MP_value, double strength, double agility, double dexterity, int money, int experience_points) {
        super(name, MP_value, strength, agility, dexterity, money, experience_points);
    }
    //override the favoredLevelUp method, specify which attribute is favored by this hero
    @Override
    public void favoredLevelUp() {
        super.setStrength(super.getStrength()*1.1);
        super.setAgility(super.getAgility()*1.1);
        super.setDexterity(super.getDexterity()*1.05);
    }

}
