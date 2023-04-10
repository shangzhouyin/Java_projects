import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class battleField{

    private ArrayList<monsters> monsterList;
    private ArrayList<heroes> hero;
    private ArrayList<monsters> battleMonster;
    private boolean heroTurn;
    private boolean heroWin;
    private boolean monWin;
    textParse txt = new textParse();
    Scanner myObj = new Scanner(System.in);


    //battleField constructor, input parameter is hero player list, initialize the monster player list and other variables
    public battleField(ArrayList<heroes> hero) {
        this.monsterList=txt.readDragonsFile();
        this.monsterList.addAll(txt.readExoFile());
        this.monsterList.addAll(txt.readSpiritsFile());
        this.battleMonster = new ArrayList<>();
        heroTurn = true;
        this.hero = hero;
        heroWin = false;
        monWin = false;
    }

    // this method is used to start the battle
    public void battleStart(){
        initialize();
        performRound();
    }

    //initialize the battle, generate monsters the same level the selected heroes
    public void initialize(){
        //initialize monsters and print all players information
        int level = Integer.MIN_VALUE;
        for(heroes h : hero){
            if(h.getCurLevel()> level){
                level = h.getCurLevel();
            }
            h.printHeroInfo();
            for(monsters m: monsterList){
                if(level == m.getLevel()){
                    if(!battleMonster.contains(m)){
                        m.printMonInfo();
                        battleMonster.add(m);
                        break;
                    }

                }
            }

        }
        System.out.println();
        System.out.println(ConsoleColor.ANSI_RED+"========================================================================"+ConsoleColor.ANSI_RESET);
        System.out.println(ConsoleColor.ANSI_RED+"-----------------------------Battle Begins------------------------------"+ConsoleColor.ANSI_RESET);

    }

    //round method, hero take first turn and then monster, show inventory or hero information does not consume the turn
    public void performRound(){
        int i = 0;
        int j = 0;
        int round = 1;
        while(i<hero.size() && j<battleMonster.size()) {
            while (true) {
                System.out.println();
                System.out.println(ConsoleColor.ANSI_PURPLE+"Round " + round+ConsoleColor.ANSI_RESET);
                if (heroTurn) {
                    heroRound(hero.get(i), battleMonster.get(j));
                    heroTurn = false;
                    hero.get(i).setHP_value((int) (hero.get(i).getHP_value() * 1.1));
                    hero.get(i).setMP_value((int) (hero.get(i).getMP_value() * 1.1));
                    hero.get(i).printHeroInfo();
                    battleMonster.get(j).printMonInfo();
                } else {
                    monsterRound(hero.get(i), battleMonster.get(j));
                    heroTurn = true;
                    hero.get(i).printHeroInfo();
                    battleMonster.get(j).printMonInfo();
                }
                if(hero.get(i).isHeroFaint()){
                    System.out.println(ConsoleColor.ANSI_PURPLE+"Round "+round+" finished"+ConsoleColor.ANSI_RESET);
                    System.out.println();
                    i++;
                }else if(battleMonster.get(j).isFaint()){
                    System.out.println(ConsoleColor.ANSI_PURPLE+"Round "+round+" finished"+ConsoleColor.ANSI_RESET);
                    System.out.println();
                    j++;
                }else{
                    System.out.println(ConsoleColor.ANSI_PURPLE+"Round "+round+" finished"+ConsoleColor.ANSI_RESET);
                }
                break;
            }
            round++;
        }
        if(i<j){
            isHeroWin();

        }else{
            isMonWin();
        }




        System.out.println();
        System.out.println(ConsoleColor.ANSI_RED+"----------------------------Battle is Over------------------------------"+ConsoleColor.ANSI_RESET);
        System.out.println(ConsoleColor.ANSI_RED+"========================================================================"+ConsoleColor.ANSI_RESET);
    }


    //when a hero win the battle, HP, level, MP value wll be leveled up
    public void levelUpNew(heroes h){
        int heroCurrent_HP = h.getHP_initValue() + h.getCurLevel()*100;
        h.setCurHP(heroCurrent_HP);
        h.setCurLevel(h.getInit_Level()+h.getExperience_points()/10);
        int heroCurrent_MP = (int)(h.getMP_value()*1.1);
        h.setMP_value(heroCurrent_MP);

    }
    //check if hero team wins or not, if hero team wins, every hero will get experience points and money.
    public void isHeroWin(){
        for(heroes h: hero){
            if(!h.isHeroFaint()){
                if(h instanceof warriors){
                    h.favoredLevelUp();
                }
                if(h instanceof sorcerers){
                    h.favoredLevelUp();
                }
                if(h instanceof paladins){
                    h.favoredLevelUp();
                }
                h.setExperience_points(h.getExperience_points()+hero.size()*2);
                h.setMoney(h.getCurLevel()*100+h.getMoney());
                levelUpNew(h);
                System.out.println();
                System.out.println(ConsoleColor.ANSI_RED+"Congratulations! "+ h.getName() + ", you won the battle!"+ConsoleColor.ANSI_RESET);
                System.out.println();
                heroWin = true;
            }else{
                heroWin = false;
            }
            System.out.println(ConsoleColor.ANSI_BLUE+"Heroes' statistics is as follows"+ConsoleColor.ANSI_RESET);
            h.printHeroInfo();
        }
    }

    //check if monster wins or not
    public void isMonWin(){
        for(monsters m: battleMonster){
            if(!m.isFaint()){
                System.out.println();
                System.out.println(ConsoleColor.ANSI_RED+"Congratulations! "+ m.getName() + ", you won the battle!"+ConsoleColor.ANSI_RESET);
                System.out.println();
                System.out.println(ConsoleColor.ANSI_BLUE+"Monster' statistics is as follows"+ConsoleColor.ANSI_RESET);
                m.printMonInfo();
                monWin = true;
            }else{
                monWin = false;
                System.out.println(ConsoleColor.ANSI_BLUE+"Monster' statistics is as follows"+ConsoleColor.ANSI_RESET);
                m.printMonInfo();
            }

        }
    }

    //display the attack methods messages
    public void displayAttackMes(){
        System.out.println("[1] Attack with/without weapon");
        System.out.println("[2] Cast a spell");
        System.out.println("[3] Use a potion to revive");
        System.out.println("[4] Equip an armor");
        System.out.println("[5] Equip a weapon");
        System.out.println("[6] Display hero's information");
        System.out.println("[7] Display hero's Inventory");
        System.out.println("[8] Quit");
        System.out.println("Choose the number of action");
    }

    //hero round, hero chooses methods to attack monster
    public void heroRound(heroes h, monsters m){
            System.out.println("It's " + ConsoleColor.ANSI_GREEN+h.getName()+ConsoleColor.ANSI_RESET+ " turn");
            displayAttackMes();
            int action;
            while (true) {
                try {
                    action = myObj.nextInt();
                    switch (action){
                        case 1:
                            h.attackMethod(m);
                            m.defendMethod(h);
                            break;
                        case 2:
                            if((h.getSpell()).size() == 0){
                                System.out.println("You do not have any spells, choose another action");
                                displayAttackMes();
                                continue;
                            }else{
                                h.useSpells(m);
                            }
                            break;
                        case 3:
                            if((h.getPotion()).size() == 0){
                                System.out.println("You do not have any available potion to drink, choose another action");
                                displayAttackMes();
                                continue;
                            }else{
                                h.usePotion();
                                continue;
                            }

                        case 4:
                            if((h.getArmor()).size() == 0){
                                System.out.println("You do not have any available armor to wear, choose another action");
                                displayAttackMes();
                                continue;
                            }else{
                                h.wearArmor();
                                continue;
                            }
                        case 5:
                            if((h.getWeapon()).size() == 0){
                                System.out.println("You do not have any available weapon to use, choose another action");
                                displayAttackMes();
                                continue;
                            }else{
                                h.useWeapon();
                                continue;
                            }
                        case 6:
                            h.printHeroInfo();
                            displayAttackMes();
                            continue;
                        case 7:
                            h.printInventory();
                            displayAttackMes();
                            continue;
                        case 8:
                            System.out.println("EXITING THE GAME...");
                            System.exit(0);
                        default:
                            System.out.println("Re-enter the number(1-8)");
                    }
                    break;

                } catch (InputMismatchException e) {
                    System.out.print("Invalid Integer! try again: ");
                    myObj.nextLine();
                }
            }
    }

    //monster round, monster can only attack the hero with it's base damage since it does not have any weapon or armor
    public void monsterRound(heroes h, monsters m){
            System.out.println("It's " +ConsoleColor.ANSI_YELLOW+ m.getName()+ConsoleColor.ANSI_RESET + " 's turn");
            m.attackMethod(h);

    }


    //getter and setter method
    public ArrayList<monsters> getMonsterList() {return monsterList;}

    public void setMonsterList(ArrayList<monsters> monsterList) {this.monsterList = monsterList;}

    public ArrayList<monsters> getBattleMonster() {return battleMonster;}

    public void setBattleMonster(ArrayList<monsters> battleMonster) {this.battleMonster = battleMonster;}
}
