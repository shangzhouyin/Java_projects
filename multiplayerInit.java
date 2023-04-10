/*
* This class is adapted from the Assignment2 multiplayer class, it initializes hero playerlist, allows 1-3 players to play the game
*/
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class multiplayerInit{

    private ArrayList<warriors> warrior;
    private ArrayList<paladins> paladin;
    private ArrayList<sorcerers> sorcerer;
    Scanner myObj = new Scanner(System.in);
    private ArrayList<heroes> heroList;
    textParse txt;

//constructor to initialize the multiplayer
    public multiplayerInit() {

        this.txt = new textParse();
        warrior = txt.readWarriorFile();
        paladin = txt.readPaladinsFile();
        sorcerer = txt.readSorcerersFile();
        this.heroList =  new ArrayList<>();
    }

    //display every player's information
    public void showAllPlayer(){
        for(int i = 0; i<warrior.size();i++){
            System.out.println(ConsoleColor.ANSI_GREEN+"Warriors " + (i+1)+ConsoleColor.ANSI_RESET);
            warrior.get(i).printHeroInfo();
        }

        for(int i = 0; i<sorcerer.size();i++){
            System.out.println(ConsoleColor.ANSI_GREEN+"Sorcerers " + (i+7)+ConsoleColor.ANSI_RESET);
            sorcerer.get(i).printHeroInfo();
        }

        for(int i = 0; i<paladin.size();i++){
            System.out.println(ConsoleColor.ANSI_GREEN+"Paladins " + (i+13)+ConsoleColor.ANSI_RESET);
            paladin.get(i).printHeroInfo();
        }
    }

    //add player, allow users to select different 1-3 heroes
    public ArrayList<heroes> addPlayer() {
        int numHeroes;
        System.out.println(ConsoleColor.ANSI_RED+"Choose the number(1-3) of Heroes you want to play (Enter number 1-3): "+ConsoleColor.ANSI_RESET);
        numHeroes = checkNum(3);
        showAllPlayer();
        for (int i = 0; i < numHeroes; i++) {
            System.out.println(ConsoleColor.ANSI_RED + "Select Heroes you want to play (Enter hero " + (i + 1) + " 's Number(1-18)): " + ConsoleColor.ANSI_RESET);
            myObj.nextLine();

            int heroNum;
            while(true){
                try {
                    heroNum = myObj.nextInt();
                    heroes selectedHero = null;

                    if(heroNum>0 && heroNum <=6){
                        selectedHero = warrior.get(heroNum-1);
                    }


                    else if(heroNum>6 && heroNum <=12){
                        selectedHero = sorcerer.get(heroNum-7);
                    }

                    else if(heroNum >12 && heroNum < 18){
                        selectedHero = paladin.get(heroNum-13);
                    }
                    if (selectedHero != null && !heroList.contains(selectedHero)) {
                        heroList.add(selectedHero);
                        System.out.println("Welcome Hero "+ConsoleColor.ANSI_GREEN+selectedHero.getName()+ConsoleColor.ANSI_RESET + " join the team!");
                        break;
                    }else if(heroList.contains(selectedHero)){
                        System.out.println("This hero is already exist, try input anther one:");
                        myObj.nextLine();
                    }else{
                        System.out.println("Invalid Input! Re-Enter a hero's Number:");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Re-Enter a hero's Number:");
                    myObj.nextLine();
                }
            }

        }
        return heroList;

    }

    //display the selected heroes information
    public void showSelectedHero(){
        System.out.println("Selected Heroes are ");
        for(int i = 0; i<heroList.size(); i++){
            heroList.get(i).printHeroInfo();
        }
    }


//check if user's input is between 1-3
    public int checkNum(int num) {
            int in;
            while (true) {
                try {
                    in = myObj.nextInt();
                    while (in <= 0 && in > num) {
                        System.out.println("Re-enter the number(1-3)");
                        in = myObj.nextInt();
                    }
                    break;

                } catch (InputMismatchException e) {
                    System.out.print("Invalid integer! try again: ");
                    myObj.nextLine();
                }
            }
            return in;
    }

    //Getter and setter method
    public ArrayList<heroes> getHeroList() {
        return heroList;
    }

    public void setHeroList(ArrayList<heroes> heroList) {
        this.heroList = heroList;
    }

    public ArrayList<warriors> getWarrior() {
        return warrior;
    }

    public void setWarrior(ArrayList<warriors> warrior) {
        this.warrior = warrior;
    }

    public ArrayList<paladins> getPaladin() {
        return paladin;
    }

    public void setPaladin(ArrayList<paladins> paladin) {
        this.paladin = paladin;
    }

    public ArrayList<sorcerers> getSorcerer() {
        return sorcerer;
    }

    public void setSorcerer(ArrayList<sorcerers> sorcerer) {
        this.sorcerer = sorcerer;
    }
}
