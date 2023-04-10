/*heroes is an abstract class extends from the character */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;


public abstract class heroes extends character{
    private int MP_value;
    private int init_Level;
    private int HP_initValue;
    private double strength;
    private double dexterity;
    private double agility;
    private int money;
    private int experience_points;
    private double heroDodge;
    private  int curLevel;
    private int curHP;
    private int points;
    private boolean heroFaint;
    private weapon curWeapon;
    private armor preArmor;
    private armor curArmor;
    private weapon preWeapon;
    private potion curPotion;

    private spells curSpell;

    private ArrayList<weapon> Weapon;
    private ArrayList<armor> Armor;
    private ArrayList<spells> Spell;
    private ArrayList<potion> Potion;

    //heroes constructor to initialize name, MP_value, strength, agility, dexterity, int money, int experience_points
    public heroes(String name, int MP_value, double strength,  double agility, double dexterity, int money, int experience_points) {
        super(name);
        this.init_Level = 1;
        this.HP_initValue = 200;
        this.MP_value = MP_value;
        this.strength = strength;
        this.dexterity = dexterity;
        this.agility = agility;
        this.money = money;
        this.experience_points = experience_points;
        //initialize the weapon to null
        this.heroDodge = agility*0.002;
        curWeapon = null;
        preArmor = null;
        heroFaint = false;
        this.Weapon = new ArrayList<>();
        this.Armor = new ArrayList<>();
        this.Spell = new ArrayList<>();
        this.Potion = new ArrayList<>();
        curLevel = 1;
        curHP = 200;
    }



    //hero attack method, if hero equip a weapon, it can increase its strength
    public void attackMethod(monsters M){
        int damage;
        if(Math.random() >= M.getDodgeAbility()*0.01){
            if(curWeapon==null){
                damage = (int)this.strength;
            }else{
                damage = (int)((this.strength + curWeapon.getDamage())*0.05);
            }
            if(damage-M.getDefenseValue()/2<0){
                System.out.println(ConsoleColor.ANSI_GREEN+M.getName()+ConsoleColor.ANSI_RESET + " successfully defensed " );
            }else{
                double residualValue = M.getHP_value()-damage + M.getDefenseValue()/2;
                if(residualValue<0){
                    System.out.println(ConsoleColor.ANSI_GREEN+super.getName()+ConsoleColor.ANSI_RESET + " attacked the " + ConsoleColor.ANSI_YELLOW+M.getName()+ConsoleColor.ANSI_RESET + " for " + M.getHP_value() + " damage!" );
                    M.setHP_value(0);
                    System.out.println();
                }else{
                    M.setHP_value((int)residualValue);
                    System.out.println(ConsoleColor.ANSI_GREEN+super.getName()+ConsoleColor.ANSI_RESET + " attacked the " + ConsoleColor.ANSI_YELLOW+M.getName()+ConsoleColor.ANSI_RESET + " for " + (damage-M.getDefenseValue()) + " damage!" );
                }
            }

        }else{
            System.out.println(ConsoleColor.ANSI_YELLOW+M.getName()+ConsoleColor.ANSI_RESET+" dodged from your attack!");
        }
    }

//if hero has an armor in its inventory, it can decide to use it or not to increase its defend ability
    public void wearArmor(){
        if (Armor.size() == 0){
            System.out.println(ConsoleColor.ANSI_RED+"You do not have any available armor to wear/change."+ConsoleColor.ANSI_RESET);
        }else{
            Scanner myObj = new Scanner(System.in);
            System.out.println("Select the number of Armors you would like to wear");
            System.out.println("+-------+----------------+-------------------+-----------------+");
            System.out.println("|  No.  |    name        |       level       | damage Reduction|");
            System.out.println("+-------+----------------+-------------------+-----------------+");
            for(int i =0; i< Armor.size();i++ ){
                String noCell = String.format("|%1$-8s", (i+1));
                String nameCell = String.format("|%1$-16s", Armor.get(i).getName());
                String levelCell = String.format("|%1$-19s", Armor.get(i).getLevel());
                String damCell = String.format("|%1$-17s", Armor.get(i).getDamageReduction());
                System.out.println(noCell + nameCell + levelCell + damCell);
                System.out.println("+-------+----------------+-------------------+-----------------+");

            }
            int num = myObj.nextInt();
            while(true){
                if(num<=Armor.size() && num >0){
                    if(preArmor==null){
                        curArmor = Armor.get(num-1);
                    }else{
                        Armor.add(preArmor);
                        curArmor = Armor.get(num-1);
                        Armor.remove(curArmor);
                    }
                    System.out.println(ConsoleColor.ANSI_BLUE+"You successfully equipped the "+ curArmor.getName() + " armor."+ConsoleColor.ANSI_RESET);
                    System.out.println();
                    System.out.println(ConsoleColor.ANSI_RED+"Good Luck in your Battle!"+ConsoleColor.ANSI_RESET);
                    System.out.println();
                    System.out.println(ConsoleColor.ANSI_RED+"Choose another action!"+ConsoleColor.ANSI_RESET);
                    break;
                }else{
                    System.out.println("Invalid Input");
                    num = myObj.nextInt();
                }
            }


        }

    }

    //if hero has a weapon in its inventory, it can decide to use it or not to increase its attack damage
    public void useWeapon(){
        if (Weapon.size() == 0){
            System.out.println("You do not have any available weapon to equip/change.");
        }else{
            Scanner myObj = new Scanner(System.in);
            System.out.println("Select the number of Weapons you would like to equip");
            System.out.println("+-------+-----------------+--------------+--------------+---------------+");
            System.out.println("|  No.  |       name      |     level    |    damage    |    #hands     |");
            System.out.println("+-------+-----------------+--------------+--------------+---------------+");
            for(int i =0; i< Weapon.size();i++ ){
                String noCell = String.format("|%1$-7s", (i+1) );
                String wName = String.format("|%1$-17s", Weapon.get(i).getName());
                String levelCell = String.format("|%1$-14s", Weapon.get(i).getLevel());
                String damageCell = String.format("|%1$-14s", Weapon.get(i).getDamage());
                String handsCell = String.format("|%1$-15s", Weapon.get(i).getHandsNum());
                System.out.println(noCell+ wName+ levelCell + damageCell + handsCell);
                System.out.println("+-------+-----------------+--------------+--------------+---------------+");
            }
            int num = myObj.nextInt();
            while(true){
                if(num<=Weapon.size() && num > 0){
                    if(preWeapon==null){
                        curWeapon = Weapon.get(num-1);
                    }else{
                        Weapon.add(preWeapon);
                        curWeapon = Weapon.get(num-1);
                        Weapon.remove(curWeapon);
                    }
                    System.out.println(ConsoleColor.ANSI_BLUE+"You successfully equipped the "+ curWeapon.getName() + "weapon."+ConsoleColor.ANSI_RESET);
                    System.out.println();
                    System.out.println(ConsoleColor.ANSI_RED+"Good Luck in your Battle!"+ConsoleColor.ANSI_RESET);
                    System.out.println();
                    System.out.println(ConsoleColor.ANSI_RED+"Choose another action!"+ConsoleColor.ANSI_RESET);
                    break;
                }else{
                    System.out.println("Invalid Input");
                    num = myObj.nextInt();
                }
            }


        }
    }

    //if hero has a potion in its inventory, it can decide to use it or not to revive HP value
    public void usePotion(){
        if(Potion.size()==0){
            System.out.println("You do not have any available potion to drink.");
        }else{
            Scanner myObj = new Scanner(System.in);
            System.out.println("Select the number of Potions you would like to drink");
            System.out.println("+-------+------------------+---------+----------------------+-------------------------------------+");
            System.out.println("|  No.  |   name           |  level  |  Attribute Increase  | Affected Attributes                 |");
            System.out.println("+-------+------------------+---------+----------------------+-------------------------------------+");
            for(int i =0; i< Potion.size();i++ ){
                String noCell = String.format("|%1$-7s", (i+1) );
                String poName = String.format("|%1$-18s", Potion.get(i).getName());
                String levelCell = String.format("|%1$-9s", Potion.get(i).getLevel());
                String InreCell = String.format("|%1$-22s", Potion.get(i).getAttrIncrease());
                String attrCell = String.format("|%1$-37s", Arrays.deepToString(Potion.get(i).getAttrAffected()));

                System.out.println(noCell+ poName+ levelCell + InreCell + attrCell);
                System.out.println("+-------+------------------+---------+----------------------+-------------------------------------+");
            }
            int num = myObj.nextInt();
            while(true){
                if(num<=Potion.size() && num > 0){
                    curPotion = Potion.get(num-1);
                    for(String p : curPotion.getAttrAffected()){
                        if(p.equals("Health")){
                            this.HP_initValue += curPotion.getAttrIncrease();
                        }else if(p.equals("Strength")){
                            this.strength += curPotion.getAttrIncrease();
                        }else if(p.equals("Mana")){
                            this.MP_value += curPotion.getAttrIncrease();
                        }else if(p.equals("Agility")){
                            this.agility += curPotion.getAttrIncrease();
                        }else if(p.equals("Dexterity")){
                            this.dexterity += curPotion.getAttrIncrease();
                        }
                        System.out.println("You increased" + p +" "+ curPotion.getAttrIncrease() );
                    }
                    Potion.remove(curPotion);
                    System.out.println(ConsoleColor.ANSI_BLUE+"You successfully used the "+ curPotion.getName() + " potion."+ConsoleColor.ANSI_RESET);
                    System.out.println();
                    System.out.println(ConsoleColor.ANSI_RED+"Good Luck in your Battle"+ConsoleColor.ANSI_RESET);
                    System.out.println();
                    System.out.println(ConsoleColor.ANSI_RED+"Choose another action!"+ConsoleColor.ANSI_RESET);
                    break;
                }else{
                    System.out.println("Invalid Input");
                    num = myObj.nextInt();
                }
            }


        }

    }

    //if hero has a spell in its inventory, it can decide to cast it or not
    public void useSpells(monsters M){
        if(Spell.size() == 0){
            System.out.println("You do not have any available spells to use.");
        }else{
            Scanner myObj = new Scanner(System.in);
            System.out.println("Select the number of Spells you would like to use");
            System.out.println("+-------+--------+----------+--------------+---------------+---------------+");
            System.out.println("|  No.  |  Type  |  name    |    level     |     damage    |   mana cost   |");
            System.out.println("+-------+--------+----------+--------------+---------------+---------------+");
            for(int i =0; i< Spell.size();i++ ){
                String noCell = String.format("|%1$-7s", (i+1) );
                String type = String.format("|%1$-8s", Spell.get(i).getSp());
                String name = String.format("|%1$-11s", Spell.get(i).getName());
                String levelCell = String.format("|%1$-15s", Spell.get(i).getLevel());
                String damCell = String.format("|%1$-16s", Spell.get(i).getDamage());
                String manaCell = String.format("|%1$-16s", Spell.get(i).getManaCost());

                    System.out.println(noCell+ type + name + levelCell + damCell + manaCell);
                System.out.println("+-------+--------+----------+--------------+---------------+---------------+");
                }


            int num = myObj.nextInt();
            while(true){
                if(num<=Spell.size() && num>0){
                    if(this.MP_value > Spell.get(num-1).getManaCost()){
                        curSpell = Spell.get(num-1);
                        this.MP_value = this.MP_value - Spell.get(num-1).getManaCost();
                        int damage = curSpell.spellDamage(curSpell.getDamage());
                        Spell.remove(curSpell);
                        System.out.println(ConsoleColor.ANSI_BLUE+"You successfully used the "+curSpell +"spell."+ConsoleColor.ANSI_RESET);
                        System.out.println();
                        System.out.println(ConsoleColor.ANSI_GREEN+super.getName()+ConsoleColor.ANSI_RESET + " attacked the " + M.getName() + " for " + damage + " damage!");
                        System.out.println();
                        System.out.println(ConsoleColor.ANSI_RED+"Choose another action!"+ConsoleColor.ANSI_RESET);
                    }else{
                        System.out.println(ConsoleColor.ANSI_RED+"You do not have enough MP to cast a spell"+ConsoleColor.ANSI_RESET);
                    }
                    break;
                }else{
                    System.out.println("Invalid Input");
                    num = myObj.nextInt();
                }
            }

        }

    }

    //print hero inventory, available armor, weapon, spell, potion
    public void printInventory(){
        System.out.println("---------------------------------------------------------------");
        System.out.println("Hero " + ConsoleColor.ANSI_GREEN+super.getName()+ConsoleColor.ANSI_RESET + " 's Inventory is as follows");

        System.out.println("Weapon");
        System.out.println(ConsoleColor.ANSI_RED+"+------------------+---------+---------+-------------------+-------------------------+"+ConsoleColor.ANSI_RESET);

        for(weapon w : Weapon){
            w.printAttributes();
        }


        System.out.println("Armor");
        System.out.println(ConsoleColor.ANSI_RED+"+------------------+---------+---------+-------------------+-------------------------+"+ConsoleColor.ANSI_RESET);

        for(armor a : Armor){
            a.printAttributes();
        }



        System.out.println("Spells");
        System.out.println(ConsoleColor.ANSI_RED+"+------------------+---------+---------+-------------------+-------------------------+"+ConsoleColor.ANSI_RESET);

        for(spells s : Spell){
            s.printAttributes();
        }


        System.out.println("Potions");
        System.out.println(ConsoleColor.ANSI_RED+"+------------------+---------+---------+-------------------+-------------------------+"+ConsoleColor.ANSI_RESET);

        for(potion p : Potion){
            p.printAttributes();
        }


    }

    //print out heroes information including level, HP, MP, Strength, Dexterity, Agility,  Gold, Experience
    public void printHeroInfo(){
        System.out.println();
        System.out.println("Hero " + ConsoleColor.ANSI_GREEN+ super.getName() + ConsoleColor.ANSI_RESET + " 's Information is as follows");
        System.out.println("+----------+--------+--------+----------+-----------+-----------+----------+-------------+");
        System.out.println("|  Level   |   HP   |   MP   | Strength | Dexterity |  Agility  |   Gold   |  Experience |");
        System.out.println("+----------+--------+--------+----------+-----------+-----------+----------+-------------+");
        String levelCell = String.format("|%1$-10s", this.curLevel);
        String HPCell = String.format("|%1$-8s", this.curHP);
        String MPCell = String.format("|%1$-8s", this.MP_value);
        String strengthCell = String.format("|%1$-10s", String.format("%.0f", this.strength));
        String DexCell = String.format("|%1$-11s", String.format("%.0f", this.dexterity));
        String agiCell = String.format("|%1$-11s", String.format("%.0f", this.agility));
        String goldCell = String.format("|%1$-10s", this.money);
        String expCell = String.format("|%1$-13s|", this.experience_points);
        System.out.println( levelCell + HPCell + MPCell + strengthCell + DexCell + agiCell + goldCell + expCell);
        System.out.println("+----------+--------+--------+----------+-----------+-----------+----------+--------------");
        System.out.println();
        System.out.println();
    }


    //abstract method use by warriors, paladins, sorcerers to level up their special attributes
    public abstract void favoredLevelUp();


    //Getter and setter methods
    public int getExperience_points() {return experience_points;}

    public void setExperience_points(int experience_points) {this.experience_points = experience_points;}

    public int getInit_Level() {return init_Level;}

    public void setInit_Level(int init_Level) {this.init_Level = init_Level;}

    public int getHP_initValue() {return HP_initValue;}

    public void setHP_initValue(int HP_initValue) {this.HP_initValue = HP_initValue;}

    public double getHeroDodge() {return heroDodge;}

    public void setHeroDodge(double heroDodge) {this.heroDodge = heroDodge;}

    public int getMP_value() {return MP_value;}
    public void setMP_value(int MP_value) {this.MP_value = MP_value;}
    public double getStrength() {return strength;}
    public void setStrength(double strength) {this.strength = strength;}
    public double getDexterity() {return dexterity;}
    public void setDexterity(double dexterity) {this.dexterity = dexterity;}
    public double getAgility() {return agility;}
    public void setAgility(double agility) {this.agility = agility;}
    public int getMoney() {return money;}
    public void setMoney(int money) {this.money = money;}

    public ArrayList<armor> getArmor() {return Armor;}

    public void setArmor(ArrayList<armor> armor) {Armor = armor;}

    public ArrayList<spells> getSpell() {return Spell;}

    public void setSpell(ArrayList<spells> spell) {Spell = spell;}

    public ArrayList<weapon> getWeapon() {return Weapon;}
    public void setWeapon(ArrayList<weapon> weapon) {Weapon = weapon;}
    public ArrayList<potion> getPotion() {return Potion;}
    public void setPotion(ArrayList<potion> potion) {Potion = potion;}

    public boolean isHeroFaint() {return heroFaint;}

    public void setHeroFaint(boolean heroFaint) {this.heroFaint = heroFaint;}

    public int getCurLevel() {return curLevel;}

    public void setCurLevel(int curLevel) {this.curLevel = curLevel;}

    public int getCurHP() {return curHP;}

    public void setCurHP(int curHP) {this.curHP = curHP;}

    public armor getCurArmor() {return curArmor;}

    public void setCurArmor(armor curArmor) {this.curArmor = curArmor;}

    public weapon getCurWeapon() {return curWeapon;}

    public void setCurWeapon(weapon curWeapon) {this.curWeapon = curWeapon;}
}
