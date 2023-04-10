
/*This class is to start the legend game*/
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class gameInit {
    multiplayerInit players;
    ArrayList<heroes> heroPlayers;
    protected ArrayList<armor> armors;
    protected ArrayList<weapon> weapons;
    protected ArrayList<potion> potions;
    protected ArrayList<spells> spell;

    Random rand = new Random();
    textParse txt = new textParse();
    worldMap map;
    marketCell market;
    commonCell common;
    private int armorSize;
    private int weaponSize;
    private int potionSize;
    private int spellSize;
    ArrayList<armor> itemListA = new ArrayList<>();
    ArrayList<weapon> itemListW = new ArrayList<>();
    ArrayList<potion> itemListP = new ArrayList<>();
    ArrayList<spells> itemListS = new ArrayList<>();
    Scanner myObj = new Scanner(System.in);

    private int boardSize = 8;

    // initialize the variables in the constructor gameInit
    public gameInit() {
        players = new multiplayerInit();
        heroPlayers = new ArrayList<>();
        armors = txt.readArmorFile();
        weapons = txt.readWeaponFile();
        potions = txt.readPotionFile();
        spell = txt.readFireSpellsFile();
        spell.addAll(txt.readLightSpellsFile());
        spell.addAll(txt.readIceSpellsFile());
        armorSize = armors.size();
        weaponSize = weapons.size();
        potionSize = potions.size();
        spellSize = spell.size();
        randWList();

    }

    // display the welcome message, initialize the players, create and print out
    // board
    public void gameInitialize() {
        displayWelcomeMess();
        heroPlayers = players.addPlayer();
        map = new worldMap(boardSize, heroPlayers);

        map.creatBoardMap();
        map.printBoard();
        market = new marketCell('M', itemListW, itemListS, itemListA, itemListP);
        common = new commonCell(' ');
    }

    // give users instructions when playing the game
    public void gameMain() {
        while (true) {
            System.out.println();
            System.out.println("================================================================================");
            displayInfo();
            String direction;
            direction = myObj.next();
            switch (direction.toUpperCase()) {
                case "I":
                    players.showSelectedHero();
                    break;
                case "Q":
                    System.out.println(ConsoleColor.ANSI_RED + "EXITING....." + ConsoleColor.ANSI_RESET);
                    System.out.println(ConsoleColor.ANSI_RED + "SEE YOU NEXT TIME!" + ConsoleColor.ANSI_RESET);
                    System.exit(0);
                case "M":
                    move();
                    break;
                default:
                    System.out.println("Invalid Input, try again!");
                    myObj.nextLine();
            }
        }

    }

    // display the welcome messages
    public void displayWelcomeMess() {
        System.out.println("===========================================================================");
        System.out.println();
        System.out.println(
                ConsoleColor.ANSI_GREEN + "===== <::::::::(}]==0 WELCOME TO LEGEND HEROES AND MONSTERS 0==[):::::::::>"
                        + ConsoleColor.ANSI_RESET);
        System.out.println();
        System.out.println("===========================================================================");
        System.out.println();
        System.out.println(ConsoleColor.ANSI_RED + "THERE ARE SOMETHING YOU NEED TO KNOW BEFORE THE GAME STARTS: "
                + ConsoleColor.ANSI_RESET);
        System.out.println();
        System.out.println(ConsoleColor.ANSI_BLUE
                + "The monsters and heroes live in a fictional world. They do not get along and therefore fight each other. \n"
                +
                "Every time the heroes win, they gain experience and money. Heroes use the money to buy a variety of items to aid them in their battles with the monsters. When they accumulate enough experience, they "
                +
                "level up, which improves their skills. The goal of the game is for the heroes to defeat monsters and level up indefinitely"
                + ConsoleColor.ANSI_RESET);

        System.out.println();
        System.out.println(
                "There are three types of heroes: warrior, paladin and sorcerers. You can choose what heroes you want to play. All heroes level will start from 1.");
        System.out.println();
        System.out.println(
                "There are three types of monsters: dragons, exoskeletons and spirits. Monsters will be randomly distributed based on the heroes level");
        System.out.println();
    }

    // display the hero move directions
    public void displayMoveDirection() {
        System.out.println("Move Up: W/w");
        System.out.println("Move Down: S/s");
        System.out.println("Move Left: A/a");
        System.out.println("Move Right: D/d");
        System.out.println("Show Hero Information: I/i");
        System.out.println("Quit the game: Q/q");
    }

    // display the user action info
    public void displayInfo() {
        System.out.println(ConsoleColor.ANSI_RED + "Select one of the following actions:" + ConsoleColor.ANSI_RESET);
        System.out.println("Show Hero Team Information: I/i");
        System.out.println("Move Hero Team: M/m");
        System.out.println("Quit: Q/q");
    }

    // move function is used to check the if hero's move get into inaccessible
    // place, common place or market place
    public void move() {
        while (true) {
            map.printBoard();
            displayMoveDirection();
            String moveDir;
            moveDir = myObj.next();
            switch (moveDir.toUpperCase()) {
                // move up
                case "W":
                    int newX = map.getHeroX();
                    int newY = map.getHeroY();
                    if (newX == 0) {
                        System.out.println("Invalid Move, try again");
                    } else {
                        if (map.board[newX - 1][newY] instanceof inaccessibleCell) {
                            System.out.println(ConsoleColor.ANSI_RED + "THIS IS INACCESSIBLE PLACE, YOU CANNOT ENTER"
                                    + ConsoleColor.ANSI_RESET);
                        } else if (map.board[newX - 1][newY] instanceof marketCell) {
                            // TODO not sure if it works here or not
                            if (map.board[newX][newY] instanceof marketCell) {
                                map.board[newX][newY].setType('M');
                            } else {
                                map.board[newX][newY].setType(' ');
                            }
                            map.board[newX - 1][newY].setType('H');
                            map.setHeroX(newX - 1);
                            map.printBoard();
                            market.marketStart(heroPlayers);
                        } else if (map.board[newX - 1][newY] instanceof commonCell) {
                            if (map.board[newX][newY] instanceof marketCell) {
                                map.board[newX][newY].setType('M');
                            } else {
                                map.board[newX][newY].setType(' ');
                            }
                            map.board[newX - 1][newY].setType('H');
                            map.setHeroX(newX - 1);
                            map.printBoard();
                            common.rollADice(heroPlayers);
                        }
                    }
                    break;
                // move down
                case "S":
                    int newX1 = map.getHeroX();
                    int newY1 = map.getHeroY();
                    if (newX1 + 1 >= boardSize) {
                        System.out.println("Invalid Move, try again");
                    } else {
                        if (map.board[newX1 + 1][newY1] instanceof inaccessibleCell) {
                            System.out.println(ConsoleColor.ANSI_RED + "THIS IS INACCESSIBLE PLACE, YOU CANNOT ENTER"
                                    + ConsoleColor.ANSI_RESET);
                        } else if (map.board[newX1 + 1][newY1] instanceof marketCell) {
                            // TODO not sure if it works here or not
                            if (map.board[newX1][newY1] instanceof marketCell) {
                                map.board[newX1][newY1].setType('M');
                            } else {
                                map.board[newX1][newY1].setType(' ');
                            }
                            map.board[newX1 + 1][newY1].setType('H');
                            map.setHeroX(newX1 + 1);
                            map.printBoard();
                            market.marketStart(heroPlayers);
                        } else if (map.board[newX1 + 1][newY1] instanceof commonCell) {
                            if (map.board[newX1][newY1] instanceof marketCell) {
                                map.board[newX1][newY1].setType('M');
                            } else {
                                map.board[newX1][newY1].setType(' ');
                            }
                            map.board[newX1 + 1][newY1].setType('H');
                            map.setHeroX(newX1 + 1);
                            map.printBoard();
                            common.rollADice(heroPlayers);
                        }
                    }

                    break;
                // move left
                case "A":
                    int newX2 = map.getHeroX();
                    int newY2 = map.getHeroY();
                    if (newY2 - 1 < 0) {
                        System.out.println("Invalid Move, try again");
                    } else {
                        if (map.board[newX2][newY2 - 1] instanceof inaccessibleCell) {
                            System.out.println(ConsoleColor.ANSI_RED + "THIS IS INACCESSIBLE PLACE, YOU CANNOT ENTER"
                                    + ConsoleColor.ANSI_RESET);
                        } else if (map.board[newX2][newY2 - 1] instanceof marketCell) {
                            // TODO not sure if it works here or not
                            if (map.board[newX2][newY2] instanceof marketCell) {
                                map.board[newX2][newY2].setType('M');
                            } else {
                                map.board[newX2][newY2].setType(' ');
                            }
                            map.board[newX2][newY2 - 1].setType('H');
                            map.setHeroY(newY2 - 1);
                            map.printBoard();
                            market.marketStart(heroPlayers);
                        } else if (map.board[newX2][newY2 - 1] instanceof commonCell) {
                            if (map.board[newX2][newY2] instanceof marketCell) {
                                map.board[newX2][newY2].setType('M');
                            } else {
                                map.board[newX2][newY2].setType(' ');
                            }
                            map.board[newX2][newY2 - 1].setType('H');
                            map.setHeroY(newY2 - 1);
                            map.printBoard();
                            common.rollADice(heroPlayers);
                        }
                    }

                    break;
                // move left
                case "D":
                    int newX3 = map.getHeroX();
                    int newY3 = map.getHeroY();
                    if (newY3 + 1 >= boardSize) {
                        System.out.println("Invalid Move, try again");
                    } else {
                        if (map.board[newX3][newY3 + 1] instanceof inaccessibleCell) {
                            System.out.println(ConsoleColor.ANSI_RED + "THIS IS INACCESSIBLE PLACE, YOU CANNOT ENTER"
                                    + ConsoleColor.ANSI_RESET);
                        } else if (map.board[newX3][newY3 + 1] instanceof marketCell) {
                            // TODO not sure if it works here or not
                            if (map.board[newX3][newY3] instanceof marketCell) {
                                map.board[newX3][newY3].setType('M');
                            } else {
                                map.board[newX3][newY3].setType(' ');
                            }
                            map.board[newX3][newY3 + 1].setType('H');
                            map.setHeroY(newY3 + 1);
                            map.printBoard();
                            market.marketStart(heroPlayers);
                        } else if (map.board[newX3][newY3 + 1] instanceof commonCell) {
                            if (map.board[newX3][newY3] instanceof marketCell) {
                                map.board[newX3][newY3].setType('M');
                            } else {
                                map.board[newX3][newY3].setType(' ');
                            }
                            map.board[newX3][newY3 + 1].setType('H');
                            map.setHeroY(newY3 + 1);
                            map.printBoard();
                            common.rollADice(heroPlayers);
                        }
                    }
                    break;
                // show player's information
                case "I":
                    for (heroes h : heroPlayers) {
                        h.printHeroInfo();
                        h.printInventory();
                    }
                    break;
                // quit the game
                case "Q":
                    System.out.println(ConsoleColor.ANSI_RED + "EXITING THE GAME..." + ConsoleColor.ANSI_RESET);
                    System.exit(0);
                default:
                    System.out.println("Invalid input, try again");
                    myObj.nextLine();
            }

        }
    }

    // random select armor, weapon, potion and spells and put them into market,
    // every market has different items
    public void randWList() {
        for (int i = 0; i < 3; i++) {

            while (true) {
                int randA = rand.nextInt(armorSize);
                if (!itemListA.contains(armors.get(randA))) {
                    itemListA.add(armors.get(randA));
                    break;
                }
            }
            while (true) {
                int randW = rand.nextInt(weaponSize);
                if (!itemListW.contains(weapons.get(randW))) {
                    itemListW.add(weapons.get(randW));
                    break;
                }
            }

            while (true) {
                int randP = rand.nextInt(potionSize);
                if (!itemListP.contains(potions.get(randP))) {
                    itemListP.add(potions.get(randP));
                    break;
                }
            }

            while (true) {
                int randS = rand.nextInt(spellSize);
                if (!itemListS.contains(spell.get(randS))) {
                    itemListS.add(spell.get(randS));
                    break;
                }
            }

        }
    }

}