import java.util.*;

public class marketCell extends cell{
    ArrayList<armor> armors;
    ArrayList<weapon> weapons;
    ArrayList<potion> potions;
    ArrayList<spells> spell;


    Scanner myObj = new Scanner(System.in);

    public marketCell(){
        super('M');

    }
    //constructor to initialize the marketcell with variables type, random list of weapon, armor, potion and spell
    public marketCell(char type, ArrayList<weapon> w, ArrayList<spells> s, ArrayList<armor> a, ArrayList<potion> p) {
        super(type);
        setType(type);
        this.armors = a;
        this.weapons = w;
        this.potions = p;
        this.spell = s;


    }
//the method is to start market including buying and selling two main streams.
    public void marketStart(ArrayList<heroes> playerList){
        displayMessage();
        System.out.println();
        //the heroes will get into the shopping area first
        System.out.println("---------------------------------It's time to shopping-----------------------------");
        System.out.println();
        System.out.println(ConsoleColor.ANSI_RED+"Do you want to buy weapon/armor/potion/spell?[y/n]"+ConsoleColor.ANSI_RESET);
        while(true){
            String input = myObj.next();
            if(input.equalsIgnoreCase("n")){
                break;
            }else if(input.equalsIgnoreCase("y")) {
                for (heroes h : playerList) {
                    System.out.println(ConsoleColor.ANSI_GREEN+h.getName()+ConsoleColor.ANSI_RESET+ConsoleColor.ANSI_RED+", would you like to buy items?[y/n]"+ConsoleColor.ANSI_RESET);
                    boolean buying = true;
                    while(buying){
                        String input2 = myObj.next();
                        if(input2.equalsIgnoreCase("n")){
                            break;
                        }else if(input2.equalsIgnoreCase("y")) {
                            boolean buyingAgain = true;
                            do {
                                displayItems();
                                buy(h);
                                System.out.println(ConsoleColor.ANSI_RED + "Is there anything else you would like to buy[y/n]?" + ConsoleColor.ANSI_RESET);
                                String input3 = myObj.next();
                                while (true) {
                                    if (input3.equalsIgnoreCase("n")) {
                                        buyingAgain = false;
                                        break;
                                    } else if (input3.equalsIgnoreCase("y")) {
                                        break;
                                    } else {
                                        System.out.println(ConsoleColor.ANSI_RED + "Invalid input, enter 'y' or 'n'." + ConsoleColor.ANSI_RESET);
                                        input3 = myObj.next();
                                    }
                                }
                            }while(buyingAgain);
                            buying = false;
//
                        }else{
                            System.out.println(ConsoleColor.ANSI_RED+"Invalid input, enter 'y' or 'n'."+ConsoleColor.ANSI_RESET);
                        }
                    }
                    h.printInventory();
                }

                break;
            }else{
                System.out.println(ConsoleColor.ANSI_RED+"Invalid input, enter 'y' or 'n'!"+ConsoleColor.ANSI_RESET);
            }
        }

//after buying items, they will go to selling area
        System.out.println("---------------------------------It's time to selling--------------------------------");
        System.out.println(ConsoleColor.ANSI_RED+"Do you want to sell weapon/armor/potion/spell?[y/n]"+ConsoleColor.ANSI_RESET);
        while(true){
            String input4 = myObj.next();
            if(input4.equalsIgnoreCase("n")){
                break;
            }else if(input4.equalsIgnoreCase("y")){
                for(heroes h :  playerList){
                    System.out.println(ConsoleColor.ANSI_GREEN+h.getName()+ConsoleColor.ANSI_RESET+ConsoleColor.ANSI_RED+", would you like to sell items?[y/n]"+ConsoleColor.ANSI_RESET);
                    boolean selling = true;
                    while(selling){
                        String input5 = myObj.next();
                        if(input5.equalsIgnoreCase("n")){
                            selling = false;
                        }else if(input5.equalsIgnoreCase("y")){
                            while(true){
                                sell(h);
                                System.out.println(ConsoleColor.ANSI_RED+"Is there anything else you would like to sell[y/n]?"+ConsoleColor.ANSI_RESET);
                                String input6 = myObj.next();
                                if(input6.equalsIgnoreCase("n")){
                                    selling = false;
                                    break;
                                }else if(input6.equalsIgnoreCase("y")){

                                }else{
                                    do{
                                        System.out.println(ConsoleColor.ANSI_RED+"Invalid input, enter 'y' or 'n'!"+ConsoleColor.ANSI_RESET);
                                        input6 = myObj.next();
                                    }while(!input6.equalsIgnoreCase("y") && !input6.equalsIgnoreCase("n"));
                                    if(input6.equalsIgnoreCase("n")){
                                        break;
                                    }
                                }
                            }
                        }else{
                            System.out.println(ConsoleColor.ANSI_RED+"Invalid Input, enter 'y' or 'n'!"+ConsoleColor.ANSI_RESET);
                        }
                    }
                    h.printInventory();
                }
                break;
            }else{
                System.out.println(ConsoleColor.ANSI_RED+"Invalid Input, Enter 'y' or 'n'!"+ConsoleColor.ANSI_RESET);
            }
        }


//end of the market
        System.out.println("-----------------------------------------------------------------------");
        System.out.println(ConsoleColor.ANSI_PURPLE+"=================You finished shopping and selling!===================="+ConsoleColor.ANSI_RESET);
        System.out.println(ConsoleColor.ANSI_PURPLE+"============Good Luck in the game and see you next time!==============="+ConsoleColor.ANSI_RESET);
        System.out.println("-----------------------------------------------------------------------");

    }

    //display the welcome market message
    public void displayMessage(){
        System.out.println("=====================================================================================");
        System.out.println(ConsoleColor.ANSI_PURPLE+"                                Welcome to the market!                               "+ConsoleColor.ANSI_RESET);
        System.out.println("=====================================================================================");
    }

    //display market's available items, each category will have three available items
    public void displayItems(){
        System.out.println(ConsoleColor.ANSI_BLUE+"Available "+ConsoleColor.ANSI_RESET+ConsoleColor.ANSI_RED+"Armors"+ConsoleColor.ANSI_RESET+ConsoleColor.ANSI_BLUE+" in the market"+ConsoleColor.ANSI_RESET);
        int i = 0;
        for (armor a: armors){
            System.out.println(ConsoleColor.ANSI_BLUE+"Item " + (i+1)+ConsoleColor.ANSI_RESET);
            a.printAttributes();
            i++;
        }
        System.out.println(ConsoleColor.ANSI_BLUE+"Available "+ConsoleColor.ANSI_RESET+ConsoleColor.ANSI_RED+"Weapons"+ConsoleColor.ANSI_RESET+ConsoleColor.ANSI_BLUE+" in the market"+ConsoleColor.ANSI_RESET);
        for (weapon w: weapons){
            System.out.println(ConsoleColor.ANSI_BLUE+"Item " + (i+1)+ConsoleColor.ANSI_RESET);
            w.printAttributes();
            i++;
        }
        System.out.println(ConsoleColor.ANSI_BLUE+"Available "+ConsoleColor.ANSI_RESET+ConsoleColor.ANSI_RED+"Potions"+ConsoleColor.ANSI_RESET+ConsoleColor.ANSI_BLUE+" in the market"+ConsoleColor.ANSI_RESET);
        for (potion p: potions){
            System.out.println(ConsoleColor.ANSI_BLUE+"Item " + (i+1)+ConsoleColor.ANSI_RESET);
            p.printAttributes();
            i++;
        }
        System.out.println(ConsoleColor.ANSI_BLUE+"Available "+ConsoleColor.ANSI_RESET+ConsoleColor.ANSI_RED+"Spells"+ConsoleColor.ANSI_RESET+ConsoleColor.ANSI_BLUE+" in the market"+ConsoleColor.ANSI_RESET);
        for (spells s: spell){
            System.out.println(ConsoleColor.ANSI_BLUE+"Item " + (i+1)+ConsoleColor.ANSI_RESET);
            s.printAttributes();
            i++;
        }

    }

    //sell items logic, first check heroes inventory, if nothing in inventory, then they have nothing to sell
    public void sell(heroes hero){
        if(hero.getArmor().size()==0 && hero.getSpell().size()==0 && hero.getWeapon().size() == 0 && hero.getPotion().size() == 0){
            System.out.println(ConsoleColor.ANSI_GREEN+"You have nothing in your inventory, come back later to sell items."+ConsoleColor.ANSI_RESET);
        }else{
            hero.printInventory();
            System.out.println(ConsoleColor.ANSI_GREEN+hero.getName()+ConsoleColor.ANSI_RESET+ConsoleColor.ANSI_RED+", what item would you like to sell?"+ConsoleColor.ANSI_RESET);
            String itemName = myObj.next();
            while(true){
                if(inArmorInvent(hero,itemName)==false && inPoInvent(hero,itemName) ==false&& inSpInvent(hero,itemName)==false && inWeapInvent(hero,itemName)==false){
                    System.out.println("Invalid input, try again!");
                    itemName = myObj.next();
                }else{
                    break;
                }
            }
            sellItem(itemName,hero);
        }

    }


    //buy item logic, they only can buy item that they have the same level with
    public void buy(heroes hero){
        hero.printHeroInfo();
        System.out.println(ConsoleColor.ANSI_GREEN+hero.getName()+ConsoleColor.ANSI_RESET+ConsoleColor.ANSI_RED+", which item would you like to buy? (Enter item's name)"+ConsoleColor.ANSI_RESET);
        String itemName  = myObj.next();
        while(true){
            if(inArmor(itemName)==false && inPotion(itemName) ==false&& inSpell(itemName)==false && inWeapon(itemName)==false){
                System.out.println(ConsoleColor.ANSI_RED+"Invalid input, try again!"+ConsoleColor.ANSI_RESET);
                itemName = myObj.next();
            }else{
                break;
            }
        }
        buyItem(itemName,hero);
    }

    //check the validation of user input about armor
    public boolean inArmor(String itemName){
        for(armor a : armors){
            if(a.getName().equalsIgnoreCase(itemName)){
                return true;
            }
        }
        return false;
    }
    //check the validation of user input about weapon
    public boolean inWeapon(String itemName){
        for(weapon w : weapons){
            if(w.getName().equalsIgnoreCase(itemName)){
                return true;
            }
        }
        return false;
    }
    //check the validation of user input about spells
    public boolean inSpell(String itemName){
        for(spells s : spell){
            if(s.getName().equalsIgnoreCase(itemName)){
                return true;
            }
        }
        return false;
    }

    //check the validation of user input about potion
    public boolean inPotion(String itemName){
        for(potion p : potions){
            if(p.getName().equalsIgnoreCase(itemName)){
                return true;
            }
        }
        return false;
    }
    //specifically check user have enough money or level to buy the item for each category and update the inventory after buying
    public void buyItem(String itemName, heroes selectedHero) {
        Iterator<armor> armorIterator = armors.iterator();
        while (armorIterator.hasNext()) {
            armor a = armorIterator.next();
            ArrayList<armor> newItem = new ArrayList<>();
            if (a.getName().equalsIgnoreCase(itemName)) {
                if (selectedHero.getCurLevel() >= a.getLevel()) {
                    if (selectedHero.getMoney() >= a.getPrice()) {
                        selectedHero.setMoney(selectedHero.getMoney() - a.getPrice());
                        System.out.println("You successfully bought " + ConsoleColor.ANSI_BLUE + a.getName() + ConsoleColor.ANSI_RESET + " armor for " + a.getPrice() + " gold.");
                        newItem = selectedHero.getArmor();
                        newItem.add(a);
                        selectedHero.setArmor(newItem);
                        armorIterator.remove(); // use Iterator to remove item
                    } else {
                        System.out.println("You do not have enough money, try later again");
                        break;
                    }
                } else {
                    System.out.println("Your level is not enough to buy it");
                    break;
                }
            }
        }

        Iterator<weapon> weaponIterator = weapons.iterator();
        while (weaponIterator.hasNext()) {
            weapon w = weaponIterator.next();
            ArrayList<weapon> newItem = new ArrayList<>();
            if (w.getName().equalsIgnoreCase(itemName)) {
                if (selectedHero.getCurLevel() >= w.getLevel()) {
                    if (selectedHero.getMoney() >= w.getPrice()) {
                        selectedHero.setMoney(selectedHero.getMoney() - w.getPrice());
                        System.out.println("You successfully bought " + ConsoleColor.ANSI_BLUE + w.getName() + ConsoleColor.ANSI_RESET + " weapon for " + w.getPrice() + " gold.");
                        newItem = selectedHero.getWeapon();
                        newItem.add(w);
                        selectedHero.setWeapon(newItem);
                        weaponIterator.remove(); // use Iterator to remove item
                    } else {
                        System.out.println("You do not have enough money, try later again");
                        break;
                    }
                } else {
                    System.out.println("Your level is not enough to buy it");
                    break;
                }
            }
        }

        Iterator<spells> spellIterator = spell.iterator();
        while (spellIterator.hasNext()) {
            spells s = spellIterator.next();
            ArrayList<spells> newItem = new ArrayList<>();
            if (s instanceof iceSpells || s instanceof fireSpells || s instanceof lightningSpells) {
                if (s.getName().equalsIgnoreCase(itemName)) {
                    if (selectedHero.getCurLevel() >= s.getLevel()) {
                        if (selectedHero.getMoney() >= s.getPrice()) {
                            selectedHero.setMoney(selectedHero.getMoney() - s.getPrice());
                            System.out.println("You successfully bought " + ConsoleColor.ANSI_BLUE + s.getName() + ConsoleColor.ANSI_RESET + " spell for " + s.getPrice() + " gold.");
                            newItem = selectedHero.getSpell();
                            newItem.add(s);
                            selectedHero.setSpell(newItem);
                            spellIterator.remove(); // use Iterator to remove item
                            break;
                        } else {
                            System.out.println("You do not have enough money, try later again");
                            break;

                        }
                    } else {
                        System.out.println("Your level is not enough to buy it");
                        break;

                    }
                }
            }
        }

        Iterator<potion> potionIterator = potions.iterator();
        while (potionIterator.hasNext()) {
            potion p = potionIterator.next();
            ArrayList<potion> newItem = new ArrayList<>();
            if (p.getName().equalsIgnoreCase(itemName)) {
                if (selectedHero.getCurLevel() >= p.getLevel()) {
                    if (selectedHero.getMoney() >= p.getPrice()) {
                        selectedHero.setMoney(selectedHero.getMoney() - p.getPrice());
                        System.out.println("You successfully bought " + ConsoleColor.ANSI_BLUE + p.getName() + ConsoleColor.ANSI_RESET + " potion for " + p.getPrice() + " gold.");
                        newItem = selectedHero.getPotion();
                        newItem.add(p);
                        selectedHero.setPotion(newItem);
                        potionIterator.remove();
                    } else {
                        System.out.println("You do not have enough money, try later again");
                        break;
                    }
                } else {
                    System.out.println("Your level is not enough to buy it");
                    break;
                }
            }
        }
    }

//sell items and update their inventory and their attributes such as money
    public void sellItem(String itemName, heroes selectedHero){
        double depreciationPercent = 0.5;
        Iterator<armor> armorIterator = selectedHero.getArmor().iterator();
        while (armorIterator.hasNext()) {
            armor a = armorIterator.next();
            if (a.getName().equalsIgnoreCase(itemName)) {
                int sellPrice = (int)(a.getPrice()*(1-depreciationPercent));
                System.out.println("You successfully sold the" + a.getName()+" armor and received "+sellPrice+ "golds" );
                selectedHero.setMoney(selectedHero.getMoney()+sellPrice);
                armorIterator.remove();
            }
        }

        Iterator<weapon> weaponIterator = selectedHero.getWeapon().iterator();
        while (weaponIterator.hasNext()) {
            weapon w = weaponIterator.next();
            if (w.getName().equalsIgnoreCase(itemName)) {
                int sellPrice = (int)(w.getPrice()*(1-depreciationPercent));
                System.out.println("You successfully sold the" + w.getName()+" weapon and received "+sellPrice+ "golds" );
                selectedHero.setMoney(selectedHero.getMoney()+sellPrice);
                weaponIterator.remove();
            }

        }

        Iterator<spells> spellIterator = selectedHero.getSpell().iterator();
        while (spellIterator.hasNext()) {
            spells s = spellIterator.next();
            if (s.getName().equalsIgnoreCase(itemName)) {
                int sellPrice = (int)(s.getPrice()*(1-depreciationPercent));
                System.out.println("You successfully sold the" + s.getName()+" spell and received "+sellPrice+ "golds" );
                selectedHero.setMoney(selectedHero.getMoney()+sellPrice);
                spellIterator.remove();
            }
        }

        Iterator<potion> potionIterator = selectedHero.getPotion().iterator();
        while (potionIterator.hasNext()) {
            potion p = potionIterator.next();
            if (p.getName().equalsIgnoreCase(itemName)) {
                int sellPrice = (int)(p.getPrice()*(1-depreciationPercent));
                System.out.println("You successfully sold the" + p.getName()+" potion and received "+sellPrice+ "golds" );
                selectedHero.setMoney(selectedHero.getMoney()+sellPrice);
                potionIterator.remove();
            }
        }
    }

    //check the validation of user input if they have armor in their inventory
    public boolean inArmorInvent(heroes h, String itemName){
        for(armor a: h.getArmor()){
            if(a.getName().equalsIgnoreCase(itemName)){
                return true;
            }
        }
        return false;
    }

    //check the validation of user input if they have weapon in their inventory
    public boolean inWeapInvent(heroes h, String itemName){
        for(weapon w: h.getWeapon()){
            if(w.getName().equalsIgnoreCase(itemName)){
                return true;
            }
        }
        return false;
    }

    //check the validation of user input if they have potion in their inventory
    public boolean inPoInvent(heroes h, String itemName){
        for(potion p: h.getPotion()){
            if(p.getName().equalsIgnoreCase(itemName)){
                return true;
            }
        }
        return false;
    }
    //check the validation of user input if they have spells in their inventory
    public boolean inSpInvent(heroes h, String itemName){
        for(spells s: h.getSpell()){
            if(s.getName().equalsIgnoreCase(itemName)){
                return true;
            }
        }
        return false;
    }

    //Getter and setter method
    public ArrayList<armor> getArmors() {
        return armors;
    }

    public void setArmors(ArrayList<armor> armors) {
        this.armors = armors;
    }

    public ArrayList<weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(ArrayList<weapon> weapons) {
        this.weapons = weapons;
    }

    public ArrayList<potion> getPotions() {
        return potions;
    }

    public void setPotions(ArrayList<potion> potions) {
        this.potions = potions;
    }

    public ArrayList<spells> getSpell() {
        return spell;
    }

    public void setSpell(ArrayList<spells> spell) {
        this.spell = spell;
    }
}




