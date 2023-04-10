public abstract class character {
    private String name;
    private int level;
    private int HP_value;

    //constructor for hero, all heroes level starts from 1
    public character(String name){
        this.name = name;
    }

    //constructor for monster, monster's level is provided
    public character(String name, int level) {
        this.name = name;
        this.level = level;
        HP_value = 200;
    }

    //Getter and setter method
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getLevel() {return level;}
    public void setLevel(int level) {this.level = level;}
    public int getHP_value() {return HP_value;}
    public void setHP_value(int HP_value) {this.HP_value = HP_value;}
}
