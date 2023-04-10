import java.util.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class textParse {
    //define every file paths
    public static final String armorPath = "Legends_Monsters_and_Heroes/Armory.txt";
    public static final String dragonsPath = "Legends_Monsters_and_Heroes/Dragons.txt";
    public static final String exoskeletonPath = "Legends_Monsters_and_Heroes/Exoskeletons.txt";
    public static final String fireSpellPath = "Legends_Monsters_and_Heroes/FireSpells.txt";
    public static final String iceSpellPath = "Legends_Monsters_and_Heroes/IceSpells.txt";
    public static final String lightPath = "Legends_Monsters_and_Heroes/LightningSpells.txt";
    public static final String paladinPath = "Legends_Monsters_and_Heroes/Paladins.txt";
    public static final String potionsPath = "Legends_Monsters_and_Heroes/Potions.txt";
    public static final String sorcererPath = "Legends_Monsters_and_Heroes/Sorcerers.txt";
    public static final String spiritPath = "Legends_Monsters_and_Heroes/Spirits.txt";
    public static final String warriorPath = "Legends_Monsters_and_Heroes/Warriors.txt";
    public static final String weaponPath = "Legends_Monsters_and_Heroes/Weaponry.txt";


//this is used to read text files
    public static List<String> readFileInList(String fileName) {
        List<String> lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }


//read armor text file
    public ArrayList readArmorFile() {
        List<String> armorLine = readFileInList(armorPath);
        ArrayList<armor> armors = new ArrayList<>();
        for (int i = 1; i < armorLine.size(); i++) {
            String[] element = armorLine.get(i).split("\\s+");
            armors.add(new armor(element[0], Integer.parseInt(element[1]), Integer.parseInt(element[2]),
                    Integer.parseInt(element[3])));
        }
        return armors;

    }
    //read weapon text file
    public  ArrayList readWeaponFile() {
        List<String> weaponLine = readFileInList(weaponPath);
        ArrayList<weapon> weapons = new ArrayList<>();
        for (int i = 1; i < weaponLine.size(); i++) {
            String[] element = weaponLine.get(i).split("\\s+");
            weapons.add(new weapon(element[0], Integer.parseInt(element[1]), Integer.parseInt(element[2]),
                    Integer.parseInt(element[3]), Integer.parseInt(element[4])));
        }
        return weapons;
    }
    //read potion text file
    public ArrayList readPotionFile() {
        List<String> potionLine = readFileInList(potionsPath);
        ArrayList<potion> potions = new ArrayList<>();
        for (int i = 1; i < potionLine.size(); i++) {
            String[] element = potionLine.get(i).split("\\s+");
            String[] attributeAffected;
            if(element[4].equals("All")){
                attributeAffected = element[5].split("/");
            }else{
                attributeAffected = element[4].split("/");
            }
            potions.add(new potion(element[0], Integer.parseInt(element[1]), Integer.parseInt(element[2]),
                    Integer.parseInt(element[3]), attributeAffected));
        }
        return potions;
    }
    //read spell text file
    public ArrayList readIceSpellsFile() {
        //read spells text files
        List<String> iceSpellLine = readFileInList(iceSpellPath);
        ArrayList<iceSpells> iceSpell = new ArrayList<>();
        for (int i = 1; i < iceSpellLine.size(); i++) {
            String[] element = iceSpellLine.get(i).split("\\s+");
            iceSpell.add(new iceSpells(element[0], Integer.parseInt(element[1]), Integer.parseInt(element[2]),
                    Integer.parseInt(element[3]), Integer.parseInt(element[4])));
        }
        return iceSpell;
    }

    //read fire spells text file
    public ArrayList readFireSpellsFile() {
        List<String> fireSpellLine = readFileInList(fireSpellPath);
        ArrayList<fireSpells> fireSpell = new ArrayList<>();
        for (int i = 1; i < fireSpellLine.size(); i++) {
            String[] element = fireSpellLine.get(i).split("\\s+");
            fireSpell.add(new fireSpells(element[0], Integer.parseInt(element[1]), Integer.parseInt(element[2]),
                    Integer.parseInt(element[3]), Integer.parseInt(element[4])));
        }
        return fireSpell;
    }
    //read lightning spells text file
    public ArrayList readLightSpellsFile() {
        List<String> lightSpellLine = readFileInList(lightPath);
        ArrayList<lightningSpells> lightSpell = new ArrayList<>();
        for (int i = 1; i < lightSpellLine.size(); i++) {
            String[] element = lightSpellLine.get(i).split("\\s+");
            lightSpell.add(new lightningSpells(element[0], Integer.parseInt(element[1]), Integer.parseInt(element[2]),
                    Integer.parseInt(element[3]), Integer.parseInt(element[4])));
        }
        return lightSpell;
    }

    //read warriors text file
    public ArrayList<warriors> readWarriorFile(){
        List<String> warriorsLine = readFileInList(warriorPath);
        ArrayList<warriors> warrior = new ArrayList<>();
        for (int i = 1; i < warriorsLine.size(); i++) {
            String[] element = warriorsLine.get(i).split("\\s+");
            warrior.add(new warriors(element[0], Integer.parseInt(element[1]), Double.parseDouble(element[2]),
                    Double.parseDouble(element[3]), Double.parseDouble(element[4]), Integer.parseInt(element[5]), Integer.parseInt(element[6])));
        }
        return warrior;
    }
    //read sorcerers text file
    public ArrayList readSorcerersFile() {
        List<String> sorcerersLine = readFileInList(sorcererPath);
        ArrayList<sorcerers> sorcerer = new ArrayList<>();
        for (int i = 1; i < sorcerersLine.size(); i++) {
            String[] element = sorcerersLine.get(i).split("\\s+");
            sorcerer.add(new sorcerers(element[0], Integer.parseInt(element[1]), Double.parseDouble(element[2]),
                    Double.parseDouble(element[3]), Double.parseDouble(element[4]), Integer.parseInt(element[5]), Integer.parseInt(element[6])));
        }
        return sorcerer;
    }
    //read paladins text file
    public ArrayList readPaladinsFile() {
        List<String> paladinsLine = readFileInList(paladinPath);
        ArrayList<paladins> paladin = new ArrayList<>();
        for (int i = 1; i < paladinsLine.size(); i++) {
            String[] element = paladinsLine.get(i).split("\\s+");
            paladin.add(new paladins(element[0], Integer.parseInt(element[1]), Double.parseDouble(element[2]),
                    Double.parseDouble(element[3]), Double.parseDouble(element[4]), Integer.parseInt(element[5]), Integer.parseInt(element[6])));
        }
        return paladin;
    }

    //read dragons text file
    public ArrayList readDragonsFile() {

        List<String> dragonsLine = readFileInList(dragonsPath);
        ArrayList<dragons> dragon = new ArrayList<>();
        for (int i = 1; i < dragonsLine.size(); i++) {
            String[] element = dragonsLine.get(i).split("\\s+");
            dragon.add(new dragons(element[0], Integer.parseInt(element[1]), Integer.parseInt(element[2]),
                    Integer.parseInt(element[3]), Double.parseDouble(element[4])));
        }
        return dragon;
    }
    //read spirits text file
    public ArrayList readSpiritsFile() {
        List<String> spiritsLine = readFileInList(spiritPath);
        ArrayList<spirits> spirit = new ArrayList<>();
        for (int i = 1; i < spiritsLine.size(); i++) {
            String[] element = spiritsLine.get(i).split("\\s+");
            spirit.add(new spirits(element[0], Integer.parseInt(element[1]), Integer.parseInt(element[2]),
                    Integer.parseInt(element[3]), Double.parseDouble(element[4])));
        }
        return spirit;
    }
    //read exoskeleton text file
    public ArrayList readExoFile() {
        List<String> exoskeletonsLine = readFileInList(exoskeletonPath);
        ArrayList<exoskeletons> exoskeleton = new ArrayList<>();
        for (int i = 1; i < exoskeletonsLine.size(); i++) {
            String[] element = exoskeletonsLine.get(i).split("\\s+");
            exoskeleton.add(new exoskeletons(element[0], Integer.parseInt(element[1]), Integer.parseInt(element[2]),
                    Integer.parseInt(element[3]),Double.parseDouble(element[4])));
        }
        return exoskeleton;
    }



}
