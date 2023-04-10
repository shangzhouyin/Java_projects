/* Monster is an abstract class extended from the character class*/
public abstract class monsters extends character{

    private int HP_value;
    private int baseDamage;
    private int defenseValue;
    private double dodgeAbility;
    private boolean monsterFaint;

    //constructors to initialize and define the variables
    public monsters(String name, int level, int baseDamage, int defenseValue, double dodgeAbility) {
        super(name, level);
        super.setHP_value(level*100);
        this.baseDamage = baseDamage;
        this.defenseValue = defenseValue;
        this.dodgeAbility = dodgeAbility*0.01;
        this.monsterFaint = false;
    }

    //defend method when monsters are attacked by heroes
    public void defendMethod(heroes H){
        int damage = (int)(H.getStrength() - this.defenseValue/2);
        if(Math.random() >= dodgeAbility){
            this.HP_value -= damage;
            if(this.HP_value <=0 ){
                System.out.println(ConsoleColor.ANSI_RED+"Monster "+ConsoleColor.ANSI_RESET+ConsoleColor.ANSI_YELLOW+super.getName()+ConsoleColor.ANSI_RESET +ConsoleColor.ANSI_RED+ " is dead."+ConsoleColor.ANSI_RESET);
                this.monsterFaint = true;
            }

        }
    }
    //the method that monster attack heroes
    public void attackMethod(heroes H){
        if(Math.random() >= H.getHeroDodge()){
            int damage;
            if(H.getCurArmor()!= null){
                damage = this.baseDamage-H.getCurArmor().getDamageReduction();
                H.setHP_value(H.getHP_value()-damage);
                System.out.println(ConsoleColor.ANSI_YELLOW+super.getName() +ConsoleColor.ANSI_RESET+ " attacked the " + ConsoleColor.ANSI_GREEN+H.getName()+ConsoleColor.ANSI_RESET + "for " + baseDamage + " damage!" );
            }else{
                damage = H.getHP_value()-this.baseDamage;
                H.setHP_value(damage);
                System.out.println(ConsoleColor.ANSI_YELLOW+super.getName()+ConsoleColor.ANSI_RESET + "attacked the " + ConsoleColor.ANSI_GREEN+H.getName()+ConsoleColor.ANSI_RESET + "for " + baseDamage + " damage!" );
            }
            if(H.getHP_value() < 0){
                System.out.println(ConsoleColor.ANSI_RED+"Hero "+ConsoleColor.ANSI_RESET + ConsoleColor.ANSI_GREEN+H.getName()+ConsoleColor.ANSI_RESET + ConsoleColor.ANSI_RED+" is dead."+ConsoleColor.ANSI_RESET);
                H.setHeroFaint(true);
            }
        }else{
            System.out.println(H.getName()+" dodged from your attack!");
        }
    }

    //print out the monsters information including name, level, HP, base damage, defense value and dodge ability
    public void printMonInfo(){
        System.out.println();
        System.out.println("Monster " + ConsoleColor.ANSI_YELLOW+super.getName()+ConsoleColor.ANSI_RESET + " 's Information is as follows");
        System.out.println("+---------+---------+---------------+-----------------+---------------+");
        System.out.println("|  Level  |  HP     |  Base Damage  |  Defense Value  | Dodge Ability |");
        System.out.println("+---------+---------+---------------+-----------------+---------------+");
        String levelCell = String.format("|%1$-9s", super.getLevel());
        String hpCell = String.format("|%1$-9s", super.getHP_value());
        String baseCell = String.format("|%1$-15s", this.baseDamage);
        String defendCell = String.format("|%1$-17s", this.defenseValue);
        String dodgeCell = String.format("|%1$-15s|", String.format("%.2f", this.dodgeAbility));
        System.out.println(levelCell + hpCell+ baseCell + defendCell + dodgeCell);
        System.out.println("+---------+---------+---------------+-----------------+---------------+");
    }


    //Getter and setter method
    public boolean isFaint() {return monsterFaint;}

    public void setFaint(boolean faint) {this.monsterFaint = faint;}

    public int getBaseDamage() {return baseDamage;}

    public void setBaseDamage(int baseDamage) {this.baseDamage = baseDamage;}

    public int getDefenseValue() {return defenseValue;}

    public void setDefenseValue(int defenseValue) {this.defenseValue = defenseValue;}

    public double getDodgeAbility() {return dodgeAbility;}

    public void setDodgeAbility(double dodgeAbility) {this.dodgeAbility = dodgeAbility;}
}
