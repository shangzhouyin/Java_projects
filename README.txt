# CS611-<Assignment 3>
## <Legends Monsters and Heores>
---------------------------------------------------------------------------
<Shangzhou Yin>
<syin10@bu.edu>
<U63027471>

## Notes
---------------------------------------------------------------------------
cell.java: This is an abtract class is to create cell as an object.

gameBoard.java: 
	This class is to build and printout the board.

armor.java: 
	This class contains armor information

battleField.java: 
	This class contains the main logic of battle

character.java: 
	This abstract class is extended by heroes and monsters class, contains the common attributes that heroes and monsters both have.

commonCell.java: 
	This class extends from cell, when hero goes into the commoncell, there might be a battle.

ConsoleColor.java: 
	This class contains several colors which will be used by other class print statement.

dragons.java: 
	This class extends from monsters class as one type of monsters

exoskeletons.java: 
	This class extends from monsters class as one type of monsters

fireSpells.java: 
	This class extends from Spells as one type of spells

gameInit.java: 
	initialize the main game

heroes.java: 
	This class extends from character class, contains heroes' attack function, weapon, armor, potion and spell use function 

iceSpells.java: 
	This class extends from Spells as one type of spells

inaccessibleCell.java:
	This class extends from cell, when hero encounters the inaccessiblecell, it is not able to get into it

itemAttributes.java:
	weapon, potion, armor and spells share some common attributes

lightningSpells.java:
	This class extends from Spells as one type of spells

Main.java:
	The main class to run the program

marketCell.java:
	This class extends from cell, when hero encounters the marketCell, it will get into the market to buy or sell items

monsters.java:
	This class extends from character class, contains monsters' attack function

multiplayerInit.java:
	This class initialize hero playerlist, allows 1-3 players to play the game

paladins.java:
	This class extends from heroes class as one type of hero

PlayMusic.java:
	This class is used to start, play and stop the specified music

potion.java:
	This class contains potion information with basic attributes

sorcerers.java:
	This class extends from heroes class as one type of hero

sound.java:
	Set up for the audio 

spells.java:
	This class contains spells information with basic attributes

spellType.java: 
	Enumerate class, contains three types of spells

spirits.java:
	This class extends from monsters class as one type of monsters

textParse.java:
	This class is used to parse the text documents

warriors.java:
	This class extends from heroes class as one type of hero

weapon.java:
	This class contains weapon information with basic features

worldMap.java:
	This class is used to create the map for the game.	

## Notes
Bonus:
1. use color 
2. insert the audio
3. Enumerate class
4. use several abstract class

## How to compile and run
---------------------------------------------------------------------------
1. Navigate to the directory "Assignment3_submit" after unzipping the files
2. Run the following instructions:
javac Main.java
java Main


##UML Graph 
---------------------------------------------------------------------------
This part is separated and put in the folder

## Input/Output Example
---------------------------------------------------------------------------


===========================================================================

===== <::::::::(}]==0 WELCOME TO LEGEND HEROES AND MONSTERS 0==[):::::::::>

===========================================================================

THERE ARE SOMETHING YOU NEED TO KNOW BEFORE THE GAME STARTS:

The monsters and heroes live in a fictional world. They do not get along and therefore fight each other.
Every time the heroes win, they gain experience and money. Heroes use the money to buy a variety of items to aid them in their battles with the monsters. When they accumulate enough experience, they level up, which improves their skills. The goal of the game is for the heroes to defeat monsters and level up indefinitely

There are three types of heroes: warrior, paladin and sorcerers. You can choose what heroes you want to play. All heroes level will start from 1.

There are three types of monsters: dragons, exoskeletons and spirits. Monsters will be randomly distributed based on the heroes level

Choose the number(1-3) of Heroes you want to play (Enter number 1-3):
1
Warriors 1

Hero Gaerdal_Ironhand 's Information is as follows
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|  Level   |   HP   |   MP   | Strength | Dexterity |  Agility  |   Gold   |  Experience |
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|1         |200     |100     |700       |600        |500        |1354      |7            |
+----------+--------+--------+----------+-----------+-----------+----------+--------------


Warriors 2

Hero Sehanine_Monnbow 's Information is as follows
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|  Level   |   HP   |   MP   | Strength | Dexterity |  Agility  |   Gold   |  Experience |
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|1         |200     |600     |700       |500        |800        |2500      |8            |
+----------+--------+--------+----------+-----------+-----------+----------+--------------


Warriors 3

Hero Muamman_Duathall 's Information is as follows
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|  Level   |   HP   |   MP   | Strength | Dexterity |  Agility  |   Gold   |  Experience |
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|1         |200     |300     |900       |750        |500        |2546      |6            |
+----------+--------+--------+----------+-----------+-----------+----------+--------------


Warriors 4

Hero Flandal_Steelskin 's Information is as follows
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|  Level   |   HP   |   MP   | Strength | Dexterity |  Agility  |   Gold   |  Experience |
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|1         |200     |200     |750       |700        |650        |2500      |7            |
+----------+--------+--------+----------+-----------+-----------+----------+--------------


Warriors 5

Hero Undefeated_Yoj 's Information is as follows
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|  Level   |   HP   |   MP   | Strength | Dexterity |  Agility  |   Gold   |  Experience |
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|1         |200     |400     |800       |700        |400        |2500      |7            |
+----------+--------+--------+----------+-----------+-----------+----------+--------------


Warriors 6

Hero Eunoia_Cyn 's Information is as follows
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|  Level   |   HP   |   MP   | Strength | Dexterity |  Agility  |   Gold   |  Experience |
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|1         |200     |400     |700       |600        |800        |2500      |6            |
+----------+--------+--------+----------+-----------+-----------+----------+--------------


Sorcerers 7

Hero Rillifane_Rallathil 's Information is as follows
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|  Level   |   HP   |   MP   | Strength | Dexterity |  Agility  |   Gold   |  Experience |
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|1         |200     |1300    |750       |500        |450        |2500      |9            |
+----------+--------+--------+----------+-----------+-----------+----------+--------------


Sorcerers 8

Hero Segojan_Earthcaller 's Information is as follows
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|  Level   |   HP   |   MP   | Strength | Dexterity |  Agility  |   Gold   |  Experience |
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|1         |200     |900     |800       |650        |500        |2500      |5            |
+----------+--------+--------+----------+-----------+-----------+----------+--------------


Sorcerers 9

Hero Reign_Havoc 's Information is as follows
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|  Level   |   HP   |   MP   | Strength | Dexterity |  Agility  |   Gold   |  Experience |
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|1         |200     |800     |800       |800        |800        |2500      |8            |
+----------+--------+--------+----------+-----------+-----------+----------+--------------


Sorcerers 10

Hero Reverie_Ashels 's Information is as follows
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|  Level   |   HP   |   MP   | Strength | Dexterity |  Agility  |   Gold   |  Experience |
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|1         |200     |900     |800       |400        |700        |2500      |7            |
+----------+--------+--------+----------+-----------+-----------+----------+--------------


Sorcerers 11

Hero Kalabar 's Information is as follows
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|  Level   |   HP   |   MP   | Strength | Dexterity |  Agility  |   Gold   |  Experience |
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|1         |200     |800     |850       |600        |400        |2500      |6            |
+----------+--------+--------+----------+-----------+-----------+----------+--------------


Sorcerers 12

Hero Skye_Soar 's Information is as follows
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|  Level   |   HP   |   MP   | Strength | Dexterity |  Agility  |   Gold   |  Experience |
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|1         |200     |1000    |700       |500        |400        |2500      |5            |
+----------+--------+--------+----------+-----------+-----------+----------+--------------


Paladins 13

Hero Parzival 's Information is as follows
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|  Level   |   HP   |   MP   | Strength | Dexterity |  Agility  |   Gold   |  Experience |
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|1         |200     |300     |750       |700        |650        |2500      |7            |
+----------+--------+--------+----------+-----------+-----------+----------+--------------


Paladins 14

Hero Sehanine_Moonbow 's Information is as follows
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|  Level   |   HP   |   MP   | Strength | Dexterity |  Agility  |   Gold   |  Experience |
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|1         |200     |300     |750       |700        |700        |2500      |7            |
+----------+--------+--------+----------+-----------+-----------+----------+--------------


Paladins 15

Hero Skoraeus_Stonebones 's Information is as follows
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|  Level   |   HP   |   MP   | Strength | Dexterity |  Agility  |   Gold   |  Experience |
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|1         |200     |250     |650       |350        |600        |2500      |4            |
+----------+--------+--------+----------+-----------+-----------+----------+--------------


Paladins 16

Hero Garl_Glittergold 's Information is as follows
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|  Level   |   HP   |   MP   | Strength | Dexterity |  Agility  |   Gold   |  Experience |
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|1         |200     |100     |600       |400        |500        |2500      |5            |
+----------+--------+--------+----------+-----------+-----------+----------+--------------


Paladins 17

Hero Amaryllis_Astra 's Information is as follows
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|  Level   |   HP   |   MP   | Strength | Dexterity |  Agility  |   Gold   |  Experience |
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|1         |200     |500     |500       |500        |500        |2500      |5            |
+----------+--------+--------+----------+-----------+-----------+----------+--------------


Paladins 18

Hero Caliber_Heist 's Information is as follows
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|  Level   |   HP   |   MP   | Strength | Dexterity |  Agility  |   Gold   |  Experience |
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|1         |200     |400     |400       |400        |400        |2500      |8            |
+----------+--------+--------+----------+-----------+-----------+----------+--------------


Select Heroes you want to play (Enter hero 1 's Number(1-18)):
1
Welcome Hero Gaerdal_Ironhand join the team!
+---+---+---+---+---+---+---+---+
| M |   | M |   | H |   |   | I |
+---+---+---+---+---+---+---+---+
|   |   |   |   | M | M | I |   |
+---+---+---+---+---+---+---+---+
|   | M |   |   | M |   | I |   |
+---+---+---+---+---+---+---+---+
| M |   | M |   |   |   | M |   |
+---+---+---+---+---+---+---+---+
| I | M | I | M | I |   | I | M |
+---+---+---+---+---+---+---+---+
|   | I |   | I | I |   |   | M |
+---+---+---+---+---+---+---+---+
| I |   | M |   |   | I | M | M |
+---+---+---+---+---+---+---+---+
| M |   |   | M |   | M |   |   |
+---+---+---+---+---+---+---+---+

================================================================================
Select one of the following actions:
Show Hero Team Information: I/i
Move Hero Team: M/m
Quit: Q/q
m
+---+---+---+---+---+---+---+---+
| M |   | M |   | H |   |   | I |
+---+---+---+---+---+---+---+---+
|   |   |   |   | M | M | I |   |
+---+---+---+---+---+---+---+---+
|   | M |   |   | M |   | I |   |
+---+---+---+---+---+---+---+---+
| M |   | M |   |   |   | M |   |
+---+---+---+---+---+---+---+---+
| I | M | I | M | I |   | I | M |
+---+---+---+---+---+---+---+---+
|   | I |   | I | I |   |   | M |
+---+---+---+---+---+---+---+---+
| I |   | M |   |   | I | M | M |
+---+---+---+---+---+---+---+---+
| M |   |   | M |   | M |   |   |
+---+---+---+---+---+---+---+---+
Move Up: W/w
Move Down: S/s
Move Left: A/a
Move Right: D/d
Show Hero Information: I/i
Quit the game: Q/q
a
+---+---+---+---+---+---+---+---+
| M |   | M | H |   |   |   | I |
+---+---+---+---+---+---+---+---+
|   |   |   |   | M | M | I |   |
+---+---+---+---+---+---+---+---+
|   | M |   |   | M |   | I |   |
+---+---+---+---+---+---+---+---+
| M |   | M |   |   |   | M |   |
+---+---+---+---+---+---+---+---+
| I | M | I | M | I |   | I | M |
+---+---+---+---+---+---+---+---+
|   | I |   | I | I |   |   | M |
+---+---+---+---+---+---+---+---+
| I |   | M |   |   | I | M | M |
+---+---+---+---+---+---+---+---+
| M |   |   | M |   | M |   |   |
+---+---+---+---+---+---+---+---+

Hero Gaerdal_Ironhand 's Information is as follows
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|  Level   |   HP   |   MP   | Strength | Dexterity |  Agility  |   Gold   |  Experience |
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|1         |200     |100     |700       |600        |500        |1354      |7            |
+----------+--------+--------+----------+-----------+-----------+----------+--------------



Monster Natsunomeryu 's Information is as follows
+---------+---------+---------------+-----------------+---------------+
|  Level  |  HP     |  Base Damage  |  Defense Value  | Dodge Ability |
+---------+---------+---------------+-----------------+---------------+
|1        |100      |100            |200              |0.10           |
+---------+---------+---------------+-----------------+---------------+

========================================================================
-----------------------------Battle Begins------------------------------

Round 1
It's Gaerdal_Ironhand turn
[1] Attack with/without weapon
[2] Cast a spell
[3] Use a potion to revive
[4] Equip an armor
[5] Equip a weapon
[6] Display hero's information
[7] Display hero's Inventory
[8] Quit
Choose the number of action
1
Gaerdal_Ironhand attacked the Natsunomeryu for 100 damage!

Monster Natsunomeryu is dead.

Hero Gaerdal_Ironhand 's Information is as follows
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|  Level   |   HP   |   MP   | Strength | Dexterity |  Agility  |   Gold   |  Experience |
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|1         |200     |110     |700       |600        |500        |1354      |7            |
+----------+--------+--------+----------+-----------+-----------+----------+--------------



Monster Natsunomeryu 's Information is as follows
+---------+---------+---------------+-----------------+---------------+
|  Level  |  HP     |  Base Damage  |  Defense Value  | Dodge Ability |
+---------+---------+---------------+-----------------+---------------+
|1        |0        |100            |200              |0.10           |
+---------+---------+---------------+-----------------+---------------+
Round 1 finished


Congratulations! Gaerdal_Ironhand, you won the battle!

Heroes' statistics is as follows

Hero Gaerdal_Ironhand 's Information is as follows
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|  Level   |   HP   |   MP   | Strength | Dexterity |  Agility  |   Gold   |  Experience |
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|1         |300     |121     |770       |630        |550        |1454      |9            |
+----------+--------+--------+----------+-----------+-----------+----------+--------------



----------------------------Battle is Over------------------------------
========================================================================
+---+---+---+---+---+---+---+---+
| M |   | M | H |   |   |   | I |
+---+---+---+---+---+---+---+---+
|   |   |   |   | M | M | I |   |
+---+---+---+---+---+---+---+---+
|   | M |   |   | M |   | I |   |
+---+---+---+---+---+---+---+---+
| M |   | M |   |   |   | M |   |
+---+---+---+---+---+---+---+---+
| I | M | I | M | I |   | I | M |
+---+---+---+---+---+---+---+---+
|   | I |   | I | I |   |   | M |
+---+---+---+---+---+---+---+---+
| I |   | M |   |   | I | M | M |
+---+---+---+---+---+---+---+---+
| M |   |   | M |   | M |   |   |
+---+---+---+---+---+---+---+---+
Move Up: W/w
Move Down: S/s
Move Left: A/a
Move Right: D/d
Show Hero Information: I/i
Quit the game: Q/q
s
+---+---+---+---+---+---+---+---+
| M |   | M |   |   |   |   | I |
+---+---+---+---+---+---+---+---+
|   |   |   | H | M | M | I |   |
+---+---+---+---+---+---+---+---+
|   | M |   |   | M |   | I |   |
+---+---+---+---+---+---+---+---+
| M |   | M |   |   |   | M |   |
+---+---+---+---+---+---+---+---+
| I | M | I | M | I |   | I | M |
+---+---+---+---+---+---+---+---+
|   | I |   | I | I |   |   | M |
+---+---+---+---+---+---+---+---+
| I |   | M |   |   | I | M | M |
+---+---+---+---+---+---+---+---+
| M |   |   | M |   | M |   |   |
+---+---+---+---+---+---+---+---+

Hero Gaerdal_Ironhand 's Information is as follows
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|  Level   |   HP   |   MP   | Strength | Dexterity |  Agility  |   Gold   |  Experience |
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|1         |300     |121     |770       |630        |550        |1454      |9            |
+----------+--------+--------+----------+-----------+-----------+----------+--------------



Monster Natsunomeryu 's Information is as follows
+---------+---------+---------------+-----------------+---------------+
|  Level  |  HP     |  Base Damage  |  Defense Value  | Dodge Ability |
+---------+---------+---------------+-----------------+---------------+
|1        |100      |100            |200              |0.10           |
+---------+---------+---------------+-----------------+---------------+

========================================================================
-----------------------------Battle Begins------------------------------

Round 1
It's Gaerdal_Ironhand turn
[1] Attack with/without weapon
[2] Cast a spell
[3] Use a potion to revive
[4] Equip an armor
[5] Equip a weapon
[6] Display hero's information
[7] Display hero's Inventory
[8] Quit
Choose the number of action
2
You do not have any spells, choose another action
[1] Attack with/without weapon
[2] Cast a spell
[3] Use a potion to revive
[4] Equip an armor
[5] Equip a weapon
[6] Display hero's information
[7] Display hero's Inventory
[8] Quit
Choose the number of action
1
Gaerdal_Ironhand attacked the Natsunomeryu for 100 damage!


Hero Gaerdal_Ironhand 's Information is as follows
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|  Level   |   HP   |   MP   | Strength | Dexterity |  Agility  |   Gold   |  Experience |
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|1         |300     |133     |770       |630        |550        |1454      |9            |
+----------+--------+--------+----------+-----------+-----------+----------+--------------



Monster Natsunomeryu 's Information is as follows
+---------+---------+---------------+-----------------+---------------+
|  Level  |  HP     |  Base Damage  |  Defense Value  | Dodge Ability |
+---------+---------+---------------+-----------------+---------------+
|1        |0        |100            |200              |0.10           |
+---------+---------+---------------+-----------------+---------------+
Round 1 finished

Round 2
It's Natsunomeryu 's turn
Gaerdal_Ironhand dodged from your attack!

Hero Gaerdal_Ironhand 's Information is as follows
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|  Level   |   HP   |   MP   | Strength | Dexterity |  Agility  |   Gold   |  Experience |
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|1         |300     |133     |770       |630        |550        |1454      |9            |
+----------+--------+--------+----------+-----------+-----------+----------+--------------



Monster Natsunomeryu 's Information is as follows
+---------+---------+---------------+-----------------+---------------+
|  Level  |  HP     |  Base Damage  |  Defense Value  | Dodge Ability |
+---------+---------+---------------+-----------------+---------------+
|1        |0        |100            |200              |0.10           |
+---------+---------+---------------+-----------------+---------------+
Round 2 finished

Round 3
It's Gaerdal_Ironhand turn
[1] Attack with/without weapon
[2] Cast a spell
[3] Use a potion to revive
[4] Equip an armor
[5] Equip a weapon
[6] Display hero's information
[7] Display hero's Inventory
[8] Quit
Choose the number of action
1
Gaerdal_Ironhand attacked the Natsunomeryu for 0 damage!

Monster Natsunomeryu is dead.

Hero Gaerdal_Ironhand 's Information is as follows
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|  Level   |   HP   |   MP   | Strength | Dexterity |  Agility  |   Gold   |  Experience |
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|1         |300     |146     |770       |630        |550        |1454      |9            |
+----------+--------+--------+----------+-----------+-----------+----------+--------------



Monster Natsunomeryu 's Information is as follows
+---------+---------+---------------+-----------------+---------------+
|  Level  |  HP     |  Base Damage  |  Defense Value  | Dodge Ability |
+---------+---------+---------------+-----------------+---------------+
|1        |0        |100            |200              |0.10           |
+---------+---------+---------------+-----------------+---------------+
Round 3 finished


Congratulations! Gaerdal_Ironhand, you won the battle!

Heroes' statistics is as follows

Hero Gaerdal_Ironhand 's Information is as follows
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|  Level   |   HP   |   MP   | Strength | Dexterity |  Agility  |   Gold   |  Experience |
+----------+--------+--------+----------+-----------+-----------+----------+-------------+
|2         |300     |160     |847       |662        |605        |1554      |11           |
+----------+--------+--------+----------+-----------+-----------+----------+--------------



----------------------------Battle is Over------------------------------
========================================================================
+---+---+---+---+---+---+---+---+
| M |   | M |   |   |   |   | I |
+---+---+---+---+---+---+---+---+
|   |   |   | H | M | M | I |   |
+---+---+---+---+---+---+---+---+
|   | M |   |   | M |   | I |   |
+---+---+---+---+---+---+---+---+
| M |   | M |   |   |   | M |   |
+---+---+---+---+---+---+---+---+
| I | M | I | M | I |   | I | M |
+---+---+---+---+---+---+---+---+
|   | I |   | I | I |   |   | M |
+---+---+---+---+---+---+---+---+
| I |   | M |   |   | I | M | M |
+---+---+---+---+---+---+---+---+
| M |   |   | M |   | M |   |   |
+---+---+---+---+---+---+---+---+
Move Up: W/w
Move Down: S/s
Move Left: A/a
Move Right: D/d
Show Hero Information: I/i
Quit the game: Q/q
q
EXITING THE GAME...
