import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class DungeonGame {
    public static int RandomInt (int Min, int Max){//random number generator.
        Max++;
        return (int)(Math.random() * (Max - Min) + Min);
    }
    public static void main(String[] args) {

        Scanner Input = new Scanner(System.in);
        
        int LoadSave = 0;

        DungeonPlayer Player = new DungeonPlayer();

        System.out.println("Load Save? (Y/N)");
        String Response = Input.nextLine();
        if (Response.equals("Sh0wM3")){//Credits

            System.out.println();
            System.out.println(".");
            System.out.println("..");
            System.out.println("...");
            System.out.println("Loading...");
            System.out.println();
            System.out.println("Welcome to the Secret Menu! Where you can find tons of insider imformation about the true ending and my insperation for this game...");
            System.out.println("Wait...");
            System.out.println("Nevermind. It will hold all that fun stuff but for now it's just the credits.");
            System.out.println("Enjoy!");
            System.out.println();
            System.out.println("Secret Menu Options:");
            System.out.println("0: Credits");
            System.out.println("1: Credits");
            System.out.println("2: Credits");
            System.out.println("3: Locations of the Three Keys to Unlock the True Ending. JK Credits");
            System.out.println("4: Credits");
            System.out.println("Literaly Any Input: Credits");
            System.out.println();
            
            Input.nextLine();

            System.out.println();
            System.out.println("Lead Developer: ");
            System.out.println("Brandon Rollins");
            System.out.println();
            System.out.println("Ideas Specialist: ");
            System.out.println("Brandon Rollins");
            System.out.println();
            System.out.println("Employee of the Week: ");
            System.out.println("Brandon Rollins");
            System.out.println();
            System.out.println("Most Distracted: ");
            System.out.println("Brandon Rollins");
            System.out.println();
            System.out.println("Award for putting up with being the villan and all the slander asosiated with that depite being really nice: ");
            System.out.println("Blight_Blaze");
            System.out.println();
            System.out.println("Music Design, Sprite Work, and Art: ");
            System.out.println("Nobody");
            System.out.println();
            System.out.println("Special Thanks To:");
            System.out.println();
            System.out.println();
            System.out.println("My Family");
            System.out.println();
            System.out.println("My Insperation");
            System.out.println();
            System.out.println("God");
            System.out.println();
            System.out.println("My Play Testers");
            System.out.println();
            System.out.println("My System Tech Teacher");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("You!");
            System.out.println("For Playing My Game and Being Awesome!");
            System.out.println();
            System.out.println();
            System.out.println();
            Input.close();
            System.exit(0);            
        }
        else if (Response.equals("Y") || Response.equals("y") || Response.equals("Yes") || Response.equals("yes")) {//Every way to say yes.
            LoadSave = 1;//Load save file.
            System.out.println("Loading save file...");
        }
        else {//Don't load save file.
            System.out.println("Starting new game...");
        }

        if (LoadSave == 1){//Try to load save file. If it doesn't exist, start new game.
            try {//Code to read save file and load character goes here.
                Scanner SaveFile = new Scanner(new FileReader("InfiniteDungeonSave.txt"));

                Player.MaxHealth = Integer.parseInt(SaveFile.nextLine());
                Player.Health = Integer.parseInt(SaveFile.nextLine());
                Player.Strength = Integer.parseInt(SaveFile.nextLine());
                Player.LightDamageModifier = Integer.parseInt(SaveFile.nextLine());
                Player.HeavyDamageModifier = Integer.parseInt(SaveFile.nextLine());
                Player.Defense = Integer.parseInt(SaveFile.nextLine());
                Player.Gold = Integer.parseInt(SaveFile.nextLine());
                Player.Level = Integer.parseInt(SaveFile.nextLine());
                Player.Experience = Integer.parseInt(SaveFile.nextLine());
                Player.FloorsCleared = Integer.parseInt(SaveFile.nextLine());
                Player.Keys = Integer.parseInt(SaveFile.nextLine());
                Player.Kills = Integer.parseInt(SaveFile.nextLine());

                SaveFile.close();
                System.out.println("Save file loaded.");
            }
            catch (FileNotFoundException e) {
                System.out.println("Save file not found. Starting new game...");
                LoadSave = 0;
            }
            catch (Exception e) {
                System.out.println("Error loading save file. Starting new game...");
                LoadSave = 0;
            }
        }
        if (LoadSave == 0){//Code to generate new character goes here.
            Player.MaxHealth = 50;
            Player.Health = Player.MaxHealth;
            Player.Strength = 5;
            Player.LightDamageModifier = 0;
            Player.HeavyDamageModifier = 3;
            Player.Defense = 4;
            Player.Gold = 0;
            Player.Level = 1;
            Player.Experience = 0;
            Player.FloorsCleared = 0;
            Player.Keys = 0;
            Player.Kills = 0;
            System.out.println("New character generated.");

            System.out.println("The dungeon is a maze of rooms.");
            System.out.println("You can try to map out the dungeon but you will find that the rooms overlap thanks to the third dimension.");
            System.out.println("In order to progress, you must complete the goal of the floor and return to the starting room.");
            System.out.println("Goals include reaching a certain level, finding a key, or killing a certain number of monsters.");
            System.out.println("Every 10th floor is a boss and every 5th floor is a mini-boss. Boss floors have no doors and require you to defeat the boss to progress.");
            System.out.println("Your goal is to reach the final boss on the 20th floor and defeat him.");
        }

        System.out.println();
        System.out.println("Generating dungeon...");

        Dungeon Dungeon = new Dungeon(Player.FloorsCleared);

        System.out.println();

        System.out.println("Actions: N, S, E, W, Stats, Wait, Quit, TP, Descend, Help.");
        for (int i=0; i==0;){//Main game loop. This will run until the player dies or quits the game.

            if (Dungeon.GetRoom()==-1){
                System.out.println("You are in a room with many staircases.");
                System.out.print("To unlock the exit you must: ");
                if (Dungeon.FloorGoal==1){
                    System.out.println("Reach Level " + Dungeon.Difficulty*2 + ".");
                }
                else if (Dungeon.FloorGoal==2){
                    System.out.println("Obtain " + Dungeon.Difficulty + " keys.");
                }
                else if (Dungeon.FloorGoal==3){
                    System.out.println("Reach " + Dungeon.Difficulty*3 + " monster kills.");
                }
                else if (Dungeon.FloorGoal==0){
                    System.out.println("The way deeper is open. You can descend to the next floor.");
                }
                else {
                    System.out.println("Defeat the strong enemy.");
                }
                System.out.println();
            }
            else if (Dungeon.GetRoom()==0){
                System.out.println("You are in an empty room.");
            }
            else if (Dungeon.GetRoom()==1){
                System.out.println("You are in a room with a monster.");
            }
            else if (Dungeon.GetRoom()==2){
                System.out.println("You are in a room with an elite monster.");
            }
            else if (Dungeon.GetRoom()==3){
                System.out.println("You are in a room with a campfire.");
            }
            else if (Dungeon.GetRoom()==4){
                System.out.println("You are in a room with a shop.");
            }
            else if (Dungeon.GetRoom()==5){
                System.out.println("You are in a room with treasure.");
            }

            System.out.println();
            System.out.print("There are doors to the: ");//Quality of life feature to list the doors in the room.
            if (Dungeon.Current.NDoor){
                System.out.print("N ");
            }
            if (Dungeon.Current.SDoor){
                System.out.print("S ");
            }
            if (Dungeon.Current.EDoor){
                System.out.print("E ");
            }
            if (Dungeon.Current.WDoor){
                System.out.print("W ");
            }
            System.out.println();
            
            String Action = "";
            Action = Input.nextLine();

            //first four halndle movment.
            if (Action.equals("N") || Action.equals("n") || Action.equals("North") || Action.equals("north")){
                int Room = Dungeon.MoveN();
                if (Room==-2){
                    System.out.println("You are blocked by a wall.");
                }
                else if (Room==-1){
                    System.out.println("You find the entrance room.");
                }
                else if (Room==0){
                    System.out.println("You enter an empty room.");
                }
                else if (Room==1){
                    System.out.println("You are attacked by a monster!");
                    Dungeon.ClearRoom();
                    int EnemyStrength=Dungeon.Difficulty+2;
                    int EnemyHealth=(Dungeon.Difficulty+1)*5;
                    int EnemyDefense=RandomInt(Dungeon.Difficulty, Dungeon.Difficulty+5);
                    int EnemyType=1;

                    System.out.println();
                    int PlayerDamage;
                    int EnemyDamage;
                    String MonsterName="";//Allows me to refer to the monster later.
                    if (EnemyType==1){//Monster
                        System.out.print("You encounter ");
                        int X = RandomInt(1, 10);
                        if (X==1){
                            System.out.println("A Slime!");
                            MonsterName="The Slime";
                        }
                        else if (X==2){
                            System.out.println("A Ghost");
                            MonsterName="The Ghost";
                        }
                        else if (X==3){
                            System.out.println("A Putrid Rat!");
                            MonsterName="The Rat";
                        }
                        else if (X==4){
                            System.out.println("A Goblin!");
                            MonsterName="The Goblin";
                        }
                        else if (X==5){
                            System.out.println("A Thief!");
                            MonsterName="The Thief";
                        }
                        else if (X==6){
                            System.out.println("A Bat Swarm!");
                            MonsterName="The Bats";
                        }
                        else if (X==7){
                            System.out.println("A Wlidcat");
                            MonsterName="The Wildcat";
                        }
                        else if (X==8){
                            System.out.println("A Undead Adventure!");
                            MonsterName="The Skeleton";
                        }
                        else if (X==9){
                            System.out.println("A Strangling Vine!");
                            MonsterName="The Plant";
                        }
                        else{
                            System.out.println("'MISSINGNO.'!");
                            MonsterName="The *&%$$#_*^%&^";
                        }
                        System.out.println("You ready for combat!");
                    }
                    else if (EnemyType==2){//Elite
                        System.out.print("You are suddenly ambushed by ");
                        int X = RandomInt(1, 7);
                        if (X==1){
                            System.out.println("A Killer Bunny!");
                            MonsterName="The Killer Bunny";
                        }
                        else if (X==2){
                            System.out.println("A Dark Mage!");
                            MonsterName="The Dark Mage";
                        }
                        else if (X==3){
                            System.out.println("A Troll!");
                            MonsterName="The Cave Troll";
                        }
                        else if (X==4){
                            System.out.println("A Whelpling!");
                            MonsterName="The Dragonnet";
                        }
                        else if (X==5){
                            System.out.println("A Chest Mimic!");
                            MonsterName="The Mimic";
                        }
                        else if (X==6){
                            System.out.println("A Fallen Knight!");
                            MonsterName="The Knight";
                        }
                        else{
                            System.out.println("A Giant Centipede!");
                            MonsterName="The Centipede";
                        } 
                        System.out.println("You recover in time to fight back!");
                    }       
                    else if (EnemyType==3){//Mini-boss
                        System.out.print("Your path is blocked by ");
                        int X = RandomInt(1, 5);
                        if (X==1){
                            System.out.println("Giant Enemy Crab!");
                            MonsterName="The 'Giant Enemy Crab!'";
                        }
                        else if (X==2){
                            System.out.println("A Living Wall!");
                            MonsterName="The Wall";
                        }
                        else if (X==3){
                            System.out.println("A Giant Mole!");
                            MonsterName="The Giant Mole";
                        }
                        else if (X==4){
                            System.out.println("A Large Serpent!");
                            MonsterName="The Snake";
                        }
                        else{
                            System.out.println("A Swarm of Spiders!");
                            MonsterName="The Spiders";
                        }
                        System.out.println("They won't go down without a fight! Neither will you!");
                    }
                    else if (EnemyType==4){//Boss
                        System.out.print("You come face to face with ");
                        int X = RandomInt(1, 3);
                        if (X==1){
                            System.out.println("A Young But Fierce Drake!");
                            MonsterName="The Young Dragon";
                        }
                        else if (X==2){
                            System.out.println("A Rock Golem!");
                            MonsterName="The Golem";
                        }
                        else{
                            System.out.println("A Necromancer.");
                            MonsterName="The Necromancer";
                        }
                        System.out.println("A fierce battle ensues!");
                    }
                    else if (EnemyType==5){//Final Boss
                        MonsterName="The Dragon";
                        System.out.println();
                        if (Player.FloorsCleared<21){//This is the first time fighting the Dragon this run.
                            System.out.println("The final challange stands before you");
                            System.out.println("The Dragon has been the cause of countless tragedies, the downfall of empires, and the end of heroes.");
                            System.out.println("You face the draconic scourge, the fearsome terror of the Seven Realms.");
                            System.out.println("The Feind of the Sky, Humanity's Green Scaled Plague.");
                            System.out.println("The Feared, the Destroyer, the Devourer, the End of All Things.");
                            System.out.println("This is it. Everything has lead to this final and ultimate battle.");
                            System.out.println("Against The Dragon.");
                            System.out.println("Blight_Blaze.");
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }
                        else if (Player.FloorsCleared<41){//First re-fight
                            System.out.println("Impossible... You killed the Dragon... But they stand before you once again.");
                            System.out.println("Blight_Blaze, the bane of your existence.");
                            System.out.println("He looks as menacing as ever, but you are stronger now.");
                            System.out.println("Unfortunately, you realize he has gotten stronger as well.");
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }
                        else if (Player.FloorsCleared<61){//Second re-fight
                            System.out.println("Depite all odds, both of you are still alive.");
                            System.out.println("Blight_Blaze gives you a look of pity. He sees the trap you are in. The infinite looping.");
                            System.out.println("He understands.");
                            System.out.println("After all... Isn't he trapped too?");
                            System.out.println();
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }
                        else {//Future re-fights
                            System.out.println("You face the Dragon once more.");
                            System.out.println("...");
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }

                    }
//fights are based on a system where both parties have three actions they can take that function like rock paper scissors.The player chooses an action and the enemy's action is randomly generated. The fight continues until either the player or the enemy's health drops to 0 or below.       
                    for (int z=0; z==0;){
                        System.out.println();
                        System.out.println("Enemy Health: " + EnemyHealth);
                        System.out.println("Your Health: " + Player.Health + "/" + Player.MaxHealth);
                        System.out.println("Choose your action: Light Attack, Heavy Attack, Block");
                        System.out.println();
                        String Combat = Input.nextLine();
                        int PlayerAction = 0;
                        if (Combat.equals("Light Attack") || Combat.equals("light attack") || Combat.equals("L") || Combat.equals("l") || Combat.equals("Light") || Combat.equals("light")){
                            PlayerAction = 1;
                        }
                        else if (Combat.equals("Heavy Attack") || Combat.equals("heavy attack") || Combat.equals("H") || Combat.equals("h") || Combat.equals("Heavy") || Combat.equals("heavy")){
                            PlayerAction = 2;
                        }
                        else if (Combat.equals("Block") || Combat.equals("block") || Combat.equals("B") || Combat.equals("b")){
                            PlayerAction = 3;
                        }
                        else{
                            System.out.println("Invalid action. Please choose Light Attack, Heavy Attack, or Block.");
                            continue;
                        }
                        System.out.println();
//Enemy turn
                        int EnemyAction=0;
                        if (EnemyType==1){//Monster
                            int Y=RandomInt(1,5);
                            if (Y<3){//light
                                EnemyAction=1;
                            }
                            else if (Y==3){//heavy
                                EnemyAction=2;
                            }
                                else{//block
                                EnemyAction=3;
                            }
                        }
                        else if (EnemyType==2){//Elite
                            int Y=RandomInt(1,4);
                            if (Y==1){//light
                                EnemyAction=1;
                            }
                            else if (Y<4){//heavy
                                EnemyAction=2;
                            }
                            else{//block
                                EnemyAction=3;
                            }
                        }
                        else if (EnemyType==3){//Mini
                            int Y=RandomInt(1,5);
                            if (Y<3){//light
                                EnemyAction=1;
                            }
                            else if (Y==3){//heavy
                                EnemyAction=2;
                            }
                            else if (Y==4){//block
                                EnemyAction=3;
                            }
                            else{//Special
                                EnemyAction=4;
                            }
                        }
                        else if (EnemyType==4){//Boss
                            int Y=RandomInt(1,6);
                            if (Y==1){//light
                                EnemyAction=1;
                            }
                            else if (Y==2){//heavy
                                EnemyAction=2;
                            }
                            else if (Y==3){//block
                                EnemyAction=3;
                            }
                            else if (Y<6){//Special
                                EnemyAction=4;
                            }
                            else{//Other Special
                                EnemyAction=5;
                            }
                        }
                        else {//Dragon
                            int Y = RandomInt(1, 18);
                            if (Y<4){//Light
                                EnemyAction=1;
                            }
                            else if (Y<8){//Heavy
                                EnemyAction=2;
                            }
                            else if (Y<11){//Block
                                EnemyAction=3;
                            }
                            else if (Y<13){//Special
                                EnemyAction=4;
                            }
                            else if (Y<15){//Other Special
                                EnemyAction=5;
                            }
                            else{//Dragon Special
                                EnemyAction=6;
                            }
                        }
//Resolve Round of Combat.
                        if (PlayerAction==1){//Light
                            if (EnemyAction==1){//Light
                                PlayerDamage = Player.Strength + Player.LightDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("You Slash At " + MonsterName + "! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;
                                EnemyDamage= EnemyStrength - ((int)Math.floor(Player.Defense/2));
                                System.out.println("They Strike Back For " + EnemyDamage + " Points of Damage!");
                                Player.Health-=EnemyDamage;
                            }
                            else if (EnemyAction==2){//Heavy
                                PlayerDamage = Player.Strength + Player.LightDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("You Slash At " + MonsterName + "! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;
                                System.out.println("They Were Staggered and Can't Attack!");
                            }
                            else if (EnemyAction==3){//Block
                                System.out.println("You Attack! However " + MonsterName + " Parried Your Attack!");
                                System.out.println("They Reposte For " + EnemyStrength + " Points of Damage!");
                                Player.Health-=EnemyStrength;
                            }
                            else{//Special
                                PlayerDamage = Player.Strength + Player.LightDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("You Slash At " + MonsterName + "! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;

                            if (EnemyAction==4){//Heal
                                    System.out.println(MonsterName + " Regenerates " + Dungeon.Difficulty + " Health!");
                                    EnemyHealth+=Dungeon.Difficulty;
                                }
                                else if (EnemyAction==5){//Buff
                                    System.out.println(MonsterName + " Grows Stronger!");
                                    EnemyStrength+=((int)Math.floor(Dungeon.Difficulty/2));
                                    EnemyDefense+=((int)Math.floor(Dungeon.Difficulty/3));
                                }
                                else{//Fire-Ball
                                    System.out.println("The Dragon Spits A Fireball At You!");
                                    System.out.println("You Take " + Dungeon.Difficulty + " Points of Burning Damage.");
                                    Player.Health-=Dungeon.Difficulty;
                                }
                            }
                        }
                        else if (PlayerAction==2){//Heavy
                            if (EnemyAction==1){//Light
                                EnemyDamage= EnemyStrength - ((int)Math.floor(Player.Defense/2));
                                System.out.println(MonsterName + " Strikes You For " + EnemyDamage + " Points of Damage!");
                                Player.Health-=EnemyDamage;
                                System.out.println("You Were Staggered and Can't Attack!");
                            }
                            else if (EnemyAction==2){//Heavy
                                PlayerDamage= ((int)Math.floor(Player.Strength*1.5)) + Player.HeavyDamageModifier - ((int)Math.floor(EnemyDefense/3));
                                System.out.println("You Strike " + MonsterName + " With a Heavy Blow! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;
                                EnemyDamage= ((int)Math.floor(EnemyStrength*1.5)) - ((int)Math.floor(Player.Defense/3));
                                System.out.println("They Respond With an Attack of Their Own For " + EnemyDamage + " Points of Damage");
                                Player.Health-=EnemyDamage;
                            }       
                            else if (EnemyAction==3){//Block
                                PlayerDamage= ((int)Math.floor(Player.Strength*1.5)) + Player.HeavyDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("Your Heavy Strike Pierces " + MonsterName + "'s Defense!");
                                System.out.println("You Deal " + PlayerDamage + " Points of Dammage!");
                                EnemyHealth-=PlayerDamage;
                            }
                            else{//Special
                                PlayerDamage= ((int)Math.floor(Player.Strength*1.5)) + Player.HeavyDamageModifier - ((int)Math.floor(EnemyDefense/3));
                                System.out.println("You Strike " + MonsterName + " With a Heavy Blow! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;

                                if (EnemyAction==4){//Heal
                                    System.out.println(MonsterName + " Regenerates " + Dungeon.Difficulty + " Health!");
                                    EnemyHealth+=Dungeon.Difficulty;
                                }
                                else if (EnemyAction==5){//Buff
                                    System.out.println(MonsterName + " Grows Stronger!");
                                    EnemyStrength+=((int)Math.floor(Dungeon.Difficulty/2));
                                    EnemyDefense+=((int)Math.floor(Dungeon.Difficulty/3));
                                }
                                else{//Fire-Ball
                                    System.out.println("The Dragon Spits A Fireball At You!");
                                    System.out.println("You Take " + Dungeon.Difficulty + " Points of Burning Damage.");
                                    Player.Health-=Dungeon.Difficulty;
                                }
                            }
                        }
                        else{//Block
                            if (EnemyAction==1){//Light
                                System.out.println("You Parry " + MonsterName + "'s Attack!");
                                System.out.println("You Reposte For " + Player.Strength + " Points of Damage!");
                                EnemyHealth-=Player.Strength;
                            }
                            else if (EnemyAction==2){//Heavy
                                EnemyDamage = ((int)Math.floor(EnemyStrength*1.5)) - ((int)Math.floor(Player.Defense/2));
                                System.out.println("You Block But Are Unable to Parry " + MonsterName  + "'s Heavy Blow!");
                                System.out.println("You Are Hit For " + EnemyDamage + " Points of Damage!");
                                Player.Health-=EnemyDamage;
                            }
                            else if (EnemyAction==3){//Block
                                System.out.println("You Block at the Same Time as " + MonsterName + "!");
                                System.out.println("You Both Look Stupid!");
                            }
                            else{//Special
                                System.out.println("You Block But " + MonsterName + " Used An Ability!");

                                if (EnemyAction==4){//Heal
                                    System.out.println(MonsterName + " Regenerates " + Dungeon.Difficulty + " Health!");
                                    EnemyHealth+=Dungeon.Difficulty;
                                }
                                else if (EnemyAction==5){//Buff
                                    System.out.println(MonsterName + " Grows Stronger!");
                                    EnemyStrength+=((int)Math.floor(Dungeon.Difficulty/2));
                                    EnemyDefense+=((int)Math.floor(Dungeon.Difficulty/3));
                                }
                                else{//Fire-Ball
                                    System.out.println("The Dragon Spits A Fireball At You!");
                                    System.out.println("You Take " + Dungeon.Difficulty + " Points of Burning Damage.");
                                    Player.Health-=Dungeon.Difficulty;
                                }
                            }
                        }
                        System.out.println();
//Check For Death
                        if (Player.Health<=0){//Player Death overrides monster death.
                            System.out.println("After a particularly nasty blow, you fall unconscious!");
                            z=1;
                        }
                        else if (EnemyHealth<=0){//Enemy Death
                            if (EnemyType<3){
                                Player.Kills++;
                                System.out.println("You deal a final blow and finish off your opponent!");
                            }
                            int XP=(int) Math.pow(10, EnemyType);
                            Player.Gold+=((EnemyType+1)*(Dungeon.Difficulty+1));
                            System.out.println("You Gained " + ((EnemyType+1)*(Dungeon.Difficulty+1)) + " Gold!");
                            Player.GainEXP((int)Math.ceil(XP)*(Dungeon.Difficulty));//You get more XP on deeper floors, but less as you level up.
                            z=1;
                        }
                    }
                }
                else if (Room==2){
                    System.out.println("You are attacked by an elite monster!");
                    Dungeon.ClearRoom();
                    int EnemyStrength=Dungeon.Difficulty+5;
                    int EnemyHealth=(Dungeon.Difficulty+1)*10;
                    int EnemyDefense=RandomInt(Dungeon.Difficulty+5, Dungeon.Difficulty+10);
                    int EnemyType=2;

                    System.out.println();
                    int PlayerDamage;
                    int EnemyDamage;
                    String MonsterName="";//Allows me to refer to the monster later.
                    if (EnemyType==1){//Monster
                        System.out.print("You encounter ");
                        int X = RandomInt(1, 10);
                        if (X==1){
                            System.out.println("A Slime!");
                            MonsterName="The Slime";
                        }
                        else if (X==2){
                            System.out.println("A Ghost");
                            MonsterName="The Ghost";
                        }
                        else if (X==3){
                            System.out.println("A Putrid Rat!");
                            MonsterName="The Rat";
                        }
                        else if (X==4){
                            System.out.println("A Goblin!");
                            MonsterName="The Goblin";
                        }
                        else if (X==5){
                            System.out.println("A Thief!");
                            MonsterName="The Thief";
                        }
                        else if (X==6){
                            System.out.println("A Bat Swarm!");
                            MonsterName="The Bats";
                        }
                        else if (X==7){
                            System.out.println("A Wlidcat");
                            MonsterName="The Wildcat";
                        }
                        else if (X==8){
                            System.out.println("A Undead Adventure!");
                            MonsterName="The Skeleton";
                        }
                        else if (X==9){
                            System.out.println("A Strangling Vine!");
                            MonsterName="The Plant";
                        }
                        else{
                            System.out.println("'MISSINGNO.'!");
                            MonsterName="The *&%$$#_*^%&^";
                        }
                        System.out.println("You ready for combat!");
                    }
                    else if (EnemyType==2){//Elite
                        System.out.print("You are suddenly ambushed by ");
                        int X = RandomInt(1, 7);
                        if (X==1){
                            System.out.println("A Killer Bunny!");
                            MonsterName="The Killer Bunny";
                        }
                        else if (X==2){
                            System.out.println("A Dark Mage!");
                            MonsterName="The Dark Mage";
                        }
                        else if (X==3){
                            System.out.println("A Troll!");
                            MonsterName="The Cave Troll";
                        }
                        else if (X==4){
                            System.out.println("A Whelpling!");
                            MonsterName="The Dragonnet";
                        }
                        else if (X==5){
                            System.out.println("A Chest Mimic!");
                            MonsterName="The Mimic";
                        }
                        else if (X==6){
                            System.out.println("A Fallen Knight!");
                            MonsterName="The Knight";
                        }
                        else{
                            System.out.println("A Giant Centipede!");
                            MonsterName="The Centipede";
                        } 
                        System.out.println("You recover in time to fight back!");
                    }       
                    else if (EnemyType==3){//Mini-boss
                        System.out.print("Your path is blocked by ");
                        int X = RandomInt(1, 5);
                        if (X==1){
                            System.out.println("Giant Enemy Crab!");
                            MonsterName="The 'Giant Enemy Crab!'";
                        }
                        else if (X==2){
                            System.out.println("A Living Wall!");
                            MonsterName="The Wall";
                        }
                        else if (X==3){
                            System.out.println("A Giant Mole!");
                            MonsterName="The Giant Mole";
                        }
                        else if (X==4){
                            System.out.println("A Large Serpent!");
                            MonsterName="The Snake";
                        }
                        else{
                            System.out.println("A Swarm of Spiders!");
                            MonsterName="The Spiders";
                        }
                        System.out.println("They won't go down without a fight! Neither will you!");
                    }
                    else if (EnemyType==4){//Boss
                        System.out.print("You come face to face with ");
                        int X = RandomInt(1, 3);
                        if (X==1){
                            System.out.println("A Young But Fierce Drake!");
                            MonsterName="The Young Dragon";
                        }
                        else if (X==2){
                            System.out.println("A Rock Golem!");
                            MonsterName="The Golem";
                        }
                        else{
                            System.out.println("A Necromancer.");
                            MonsterName="The Necromancer";
                        }
                        System.out.println("A fierce battle ensues!");
                    }
                    else if (EnemyType==5){//Final Boss
                        MonsterName="The Dragon";
                        System.out.println();
                        if (Player.FloorsCleared<21){//This is the first time fighting the Dragon this run.
                            System.out.println("The final challange stands before you");
                            System.out.println("The Dragon has been the cause of countless tragedies, the downfall of empires, and the end of heroes.");
                            System.out.println("You face the draconic scourge, the fearsome terror of the Seven Realms.");
                            System.out.println("The Feind of the Sky, Humanity's Green Scaled Plague.");
                            System.out.println("The Feared, the Destroyer, the Devourer, the End of All Things.");
                            System.out.println("This is it. Everything has lead to this final and ultimate battle.");
                            System.out.println("Against The Dragon.");
                            System.out.println("Blight_Blaze.");
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }
                        else if (Player.FloorsCleared<41){//First re-fight
                            System.out.println("Impossible... You killed the Dragon... But they stand before you once again.");
                            System.out.println("Blight_Blaze, the bane of your existence.");
                            System.out.println("He looks as menacing as ever, but you are stronger now.");
                            System.out.println("Unfortunately, you realize he has gotten stronger as well.");
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }
                        else if (Player.FloorsCleared<61){//Second re-fight
                            System.out.println("Depite all odds, both of you are still alive.");
                            System.out.println("Blight_Blaze gives you a look of pity. He sees the trap you are in. The infinite looping.");
                            System.out.println("He understands.");
                            System.out.println("After all... Isn't he trapped too?");
                            System.out.println();
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }
                        else {//Future re-fights
                            System.out.println("You face the Dragon once more.");
                            System.out.println("...");
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }

                    }
//fights are based on a system where both parties have three actions they can take that function like rock paper scissors.The player chooses an action and the enemy's action is randomly generated. The fight continues until either the player or the enemy's health drops to 0 or below.       
                    for (int z=0; z==0;){
                        System.out.println();
                        System.out.println("Enemy Health: " + EnemyHealth);
                        System.out.println("Your Health: " + Player.Health + "/" + Player.MaxHealth);
                        System.out.println("Choose your action: Light Attack, Heavy Attack, Block");
                        System.out.println();
                        String Combat = Input.nextLine();
                        int PlayerAction = 0;
                        if (Combat.equals("Light Attack") || Combat.equals("light attack") || Combat.equals("L") || Combat.equals("l") || Combat.equals("Light") || Combat.equals("light")){
                            PlayerAction = 1;
                        }
                        else if (Combat.equals("Heavy Attack") || Combat.equals("heavy attack") || Combat.equals("H") || Combat.equals("h") || Combat.equals("Heavy") || Combat.equals("heavy")){
                            PlayerAction = 2;
                        }
                        else if (Combat.equals("Block") || Combat.equals("block") || Combat.equals("B") || Combat.equals("b")){
                            PlayerAction = 3;
                        }
                        else{
                            System.out.println("Invalid action. Please choose Light Attack, Heavy Attack, or Block.");
                            continue;
                        }
                        System.out.println();
//Enemy turn
                        int EnemyAction=0;
                        if (EnemyType==1){//Monster
                            int Y=RandomInt(1,5);
                            if (Y<3){//light
                                EnemyAction=1;
                            }
                            else if (Y==3){//heavy
                                EnemyAction=2;
                            }
                                else{//block
                                EnemyAction=3;
                            }
                        }
                        else if (EnemyType==2){//Elite
                            int Y=RandomInt(1,4);
                            if (Y==1){//light
                                EnemyAction=1;
                            }
                            else if (Y<4){//heavy
                                EnemyAction=2;
                            }
                            else{//block
                                EnemyAction=3;
                            }
                        }
                        else if (EnemyType==3){//Mini
                            int Y=RandomInt(1,5);
                            if (Y<3){//light
                                EnemyAction=1;
                            }
                            else if (Y==3){//heavy
                                EnemyAction=2;
                            }
                            else if (Y==4){//block
                                EnemyAction=3;
                            }
                            else{//Special
                                EnemyAction=4;
                            }
                        }
                        else if (EnemyType==4){//Boss
                            int Y=RandomInt(1,6);
                            if (Y==1){//light
                                EnemyAction=1;
                            }
                            else if (Y==2){//heavy
                                EnemyAction=2;
                            }
                            else if (Y==3){//block
                                EnemyAction=3;
                            }
                            else if (Y<6){//Special
                                EnemyAction=4;
                            }
                            else{//Other Special
                                EnemyAction=5;
                            }
                        }
                        else {//Dragon
                            int Y = RandomInt(1, 18);
                            if (Y<4){//Light
                                EnemyAction=1;
                            }
                            else if (Y<8){//Heavy
                                EnemyAction=2;
                            }
                            else if (Y<11){//Block
                                EnemyAction=3;
                            }
                            else if (Y<13){//Special
                                EnemyAction=4;
                            }
                            else if (Y<15){//Other Special
                                EnemyAction=5;
                            }
                            else{//Dragon Special
                                EnemyAction=6;
                            }
                        }
//Resolve Round of Combat.
                        if (PlayerAction==1){//Light
                            if (EnemyAction==1){//Light
                                PlayerDamage = Player.Strength + Player.LightDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("You Slash At " + MonsterName + "! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;
                                EnemyDamage= EnemyStrength - ((int)Math.floor(Player.Defense/2));
                                System.out.println("They Strike Back For " + EnemyDamage + " Points of Damage!");
                                Player.Health-=EnemyDamage;
                            }
                            else if (EnemyAction==2){//Heavy
                                PlayerDamage = Player.Strength + Player.LightDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("You Slash At " + MonsterName + "! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;
                                System.out.println("They Were Staggered and Can't Attack!");
                            }
                            else if (EnemyAction==3){//Block
                                System.out.println("You Attack! However " + MonsterName + " Parried Your Attack!");
                                System.out.println("They Reposte For " + EnemyStrength + " Points of Damage!");
                                Player.Health-=EnemyStrength;
                            }
                            else{//Special
                                PlayerDamage = Player.Strength + Player.LightDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("You Slash At " + MonsterName + "! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;

                            if (EnemyAction==4){//Heal
                                    System.out.println(MonsterName + " Regenerates " + Dungeon.Difficulty + " Health!");
                                    EnemyHealth+=Dungeon.Difficulty;
                                }
                                else if (EnemyAction==5){//Buff
                                    System.out.println(MonsterName + " Grows Stronger!");
                                    EnemyStrength+=((int)Math.floor(Dungeon.Difficulty/2));
                                    EnemyDefense+=((int)Math.floor(Dungeon.Difficulty/3));
                                }
                                else{//Fire-Ball
                                    System.out.println("The Dragon Spits A Fireball At You!");
                                    System.out.println("You Take " + Dungeon.Difficulty + " Points of Burning Damage.");
                                    Player.Health-=Dungeon.Difficulty;
                                }
                            }
                        }
                        else if (PlayerAction==2){//Heavy
                            if (EnemyAction==1){//Light
                                EnemyDamage= EnemyStrength - ((int)Math.floor(Player.Defense/2));
                                System.out.println(MonsterName + " Strikes You For " + EnemyDamage + " Points of Damage!");
                                Player.Health-=EnemyDamage;
                                System.out.println("You Were Staggered and Can't Attack!");
                            }
                            else if (EnemyAction==2){//Heavy
                                PlayerDamage= ((int)Math.floor(Player.Strength*1.5)) + Player.HeavyDamageModifier - ((int)Math.floor(EnemyDefense/3));
                                System.out.println("You Strike " + MonsterName + " With a Heavy Blow! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;
                                EnemyDamage= ((int)Math.floor(EnemyStrength*1.5)) - ((int)Math.floor(Player.Defense/3));
                                System.out.println("They Respond With an Attack of Their Own For " + EnemyDamage + " Points of Damage");
                                Player.Health-=EnemyDamage;
                            }       
                            else if (EnemyAction==3){//Block
                                PlayerDamage= ((int)Math.floor(Player.Strength*1.5)) + Player.HeavyDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("Your Heavy Strike Pierces " + MonsterName + "'s Defense!");
                                System.out.println("You Deal " + PlayerDamage + " Points of Dammage!");
                                EnemyHealth-=PlayerDamage;
                            }
                            else{//Special
                                PlayerDamage= ((int)Math.floor(Player.Strength*1.5)) + Player.HeavyDamageModifier - ((int)Math.floor(EnemyDefense/3));
                                System.out.println("You Strike " + MonsterName + " With a Heavy Blow! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;

                                if (EnemyAction==4){//Heal
                                    System.out.println(MonsterName + " Regenerates " + Dungeon.Difficulty + " Health!");
                                    EnemyHealth+=Dungeon.Difficulty;
                                }
                                else if (EnemyAction==5){//Buff
                                    System.out.println(MonsterName + " Grows Stronger!");
                                    EnemyStrength+=((int)Math.floor(Dungeon.Difficulty/2));
                                    EnemyDefense+=((int)Math.floor(Dungeon.Difficulty/3));
                                }
                                else{//Fire-Ball
                                    System.out.println("The Dragon Spits A Fireball At You!");
                                    System.out.println("You Take " + Dungeon.Difficulty + " Points of Burning Damage.");
                                    Player.Health-=Dungeon.Difficulty;
                                }
                            }
                        }
                        else{//Block
                            if (EnemyAction==1){//Light
                                System.out.println("You Parry " + MonsterName + "'s Attack!");
                                System.out.println("You Reposte For " + Player.Strength + " Points of Damage!");
                                EnemyHealth-=Player.Strength;
                            }
                            else if (EnemyAction==2){//Heavy
                                EnemyDamage = ((int)Math.floor(EnemyStrength*1.5)) - ((int)Math.floor(Player.Defense/2));
                                System.out.println("You Block But Are Unable to Parry " + MonsterName  + "'s Heavy Blow!");
                                System.out.println("You Are Hit For " + EnemyDamage + " Points of Damage!");
                                Player.Health-=EnemyDamage;
                            }
                            else if (EnemyAction==3){//Block
                                System.out.println("You Block at the Same Time as " + MonsterName + "!");
                                System.out.println("You Both Look Stupid!");
                            }
                            else{//Special
                                System.out.println("You Block But " + MonsterName + " Used An Ability!");

                                if (EnemyAction==4){//Heal
                                    System.out.println(MonsterName + " Regenerates " + Dungeon.Difficulty + " Health!");
                                    EnemyHealth+=Dungeon.Difficulty;
                                }
                                else if (EnemyAction==5){//Buff
                                    System.out.println(MonsterName + " Grows Stronger!");
                                    EnemyStrength+=((int)Math.floor(Dungeon.Difficulty/2));
                                    EnemyDefense+=((int)Math.floor(Dungeon.Difficulty/3));
                                }
                                else{//Fire-Ball
                                    System.out.println("The Dragon Spits A Fireball At You!");
                                    System.out.println("You Take " + Dungeon.Difficulty + " Points of Burning Damage.");
                                    Player.Health-=Dungeon.Difficulty;
                                }
                            }
                        }
                        System.out.println();
//Check For Death
                        if (Player.Health<=0){//Player Death overrides monster death.
                            System.out.println("After a particularly nasty blow, you fall unconscious!");
                            z=1;
                        }
                        else if (EnemyHealth<=0){//Enemy Death
                            if (EnemyType<3){
                                Player.Kills++;
                                System.out.println("You deal a final blow and finish off your opponent!");
                            }
                            int XP=(int) Math.pow(10, EnemyType);
                            Player.Gold+=((EnemyType+1)*(Dungeon.Difficulty+1));
                            System.out.println("You Gained " + ((EnemyType+1)*(Dungeon.Difficulty+1)) + " Gold!");
                            Player.GainEXP((int)Math.ceil(XP)*(Dungeon.Difficulty));//You get more XP on deeper floors, but less as you level up.
                            z=1;
                        }
                    }
                }
                else if (Room==3){
                    System.out.println("You find a Rest Spot and heal to full health.");
                    if (!(Player.Health==Player.MaxHealth)){//Only Heal if Hurt
                        Player.Health = Player.MaxHealth;
                        Dungeon.ClearRoom();
                    }
                    
                }
                else if (Room==4){
                    System.out.println("You find a shop. You can buy upgrades here.");
                    Dungeon.ClearRoom();
                    for (int q=0; q<Dungeon.Difficulty; q++){//You may purchase items up to the Diffculty of the floor.
                        System.out.println("You have " + Player.Gold + " Gold. You may purchase up to " + (Dungeon.Difficulty-q) + " more items.");
                        System.out.println("0: Leave Shop");
                        System.out.println("1: Increase Strength by 1 for " + (7*Dungeon.Difficulty) + " Gold.");
                        System.out.println("2: Increase Light Damage Modifier by 1 for " + (2*Dungeon.Difficulty) + " Gold.");
                        System.out.println("3: Increase Heavy Damage Modifier by 1 for " + (3*Dungeon.Difficulty) + " Gold.");
                        System.out.println("4: Increase Defense by 1 for " + (5*Dungeon.Difficulty) + " Gold.");
                        System.out.println("5: Increase Max Health by 5 for " + (10*Dungeon.Difficulty) + " Gold.");
                        System.out.println("6: Buy 1 key for " + (15*Dungeon.Difficulty) + " Gold.");
                        System.out.println("Stats: Prints your stats.");
                        String choice = Input.nextLine();
                        if (choice.equals("0")){
                            break;
                        }
                        else if (choice.equals("1") && Player.Gold >= (7*Dungeon.Difficulty)){
                            Player.Strength++;
                            Player.Gold -= (7*Dungeon.Difficulty);
                            System.out.println("Strength increased to " + Player.Strength + "!");
                        }
                        else if (choice.equals("2") && Player.Gold >= (2*Dungeon.Difficulty)){
                            Player.LightDamageModifier++;
                            Player.Gold -= (2*Dungeon.Difficulty);
                            System.out.println("Light Damage Modifier increased to " + Player.LightDamageModifier + "!");
                        }
                        else if (choice.equals("3") && Player.Gold >= (3*Dungeon.Difficulty)){
                            Player.HeavyDamageModifier++;
                            Player.Gold -= (3*Dungeon.Difficulty);
                            System.out.println("Heavy Damage Modifier increased to " + Player.HeavyDamageModifier + "!");
                        }
                        else if (choice.equals("4") && Player.Gold >= (5*Dungeon.Difficulty)){
                            Player.Defense++;
                            Player.Gold -= (5*Dungeon.Difficulty);
                            System.out.println("Defense increased to " + Player.Defense + "!");
                        }
                        else if (choice.equals("5") && Player.Gold >= (10*Dungeon.Difficulty)){
                            Player.MaxHealth += 5;
                            Player.Health += 5;
                            Player.Gold -= (10*Dungeon.Difficulty);
                            System.out.println("Max Health increased to " + Player.MaxHealth + "! Health increased to " + Player.Health + "!");
                        }
                        else if (choice.equals("6") && Player.Gold >= (15*Dungeon.Difficulty)){
                            Player.Keys++;
                            Player.Gold -= (15*Dungeon.Difficulty);
                            System.out.println("You bought a key! You now have " + Player.Keys + " keys.");
                        }
                        else if (Action.equals("Stats") || Action.equals("stats")){//Prints the player's stats.
                            Player.Stats();
                        }
                        else{
                            System.out.println("Invalid choice or not enough gold.");
                            q--;
                        }
                        System.out.println();
                    }
                    System.out.println("The Shopkepper packs up and leaves.");
                }
                else if (Room==5){
                    System.out.println("You find a treasure chest!");
                    Player.Treasure(Dungeon.Difficulty);
                    Dungeon.ClearRoom();
                }
            }
            else if (Action.equals("S") || Action.equals("s") || Action.equals("South") || Action.equals("south")){
                int Room = Dungeon.MoveS();
                if (Room==-2){
                    System.out.println("You are blocked by a wall.");
                }
                else if (Room==-1){
                    System.out.println("You find the entrance room.");
                }
                else if (Room==0){
                    System.out.println("You enter an empty room.");
                }
                else if (Room==1){
                    System.out.println("You are attacked by a monster!");
                    Dungeon.ClearRoom();
                    int EnemyStrength=Dungeon.Difficulty+2;
                    int EnemyHealth=(Dungeon.Difficulty+1)*5;
                    int EnemyDefense=RandomInt(Dungeon.Difficulty, Dungeon.Difficulty+5);
                    int EnemyType=1;

                    System.out.println();
                    int PlayerDamage;
                    int EnemyDamage;
                    String MonsterName="";//Allows me to refer to the monster later.
                    if (EnemyType==1){//Monster
                        System.out.print("You encounter ");
                        int X = RandomInt(1, 10);
                        if (X==1){
                            System.out.println("A Slime!");
                            MonsterName="The Slime";
                        }
                        else if (X==2){
                            System.out.println("A Ghost");
                            MonsterName="The Ghost";
                        }
                        else if (X==3){
                            System.out.println("A Putrid Rat!");
                            MonsterName="The Rat";
                        }
                        else if (X==4){
                            System.out.println("A Goblin!");
                            MonsterName="The Goblin";
                        }
                        else if (X==5){
                            System.out.println("A Thief!");
                            MonsterName="The Thief";
                        }
                        else if (X==6){
                            System.out.println("A Bat Swarm!");
                            MonsterName="The Bats";
                        }
                        else if (X==7){
                            System.out.println("A Wlidcat");
                            MonsterName="The Wildcat";
                        }
                        else if (X==8){
                            System.out.println("A Undead Adventure!");
                            MonsterName="The Skeleton";
                        }
                        else if (X==9){
                            System.out.println("A Strangling Vine!");
                            MonsterName="The Plant";
                        }
                        else{
                            System.out.println("'MISSINGNO.'!");
                            MonsterName="The *&%$$#_*^%&^";
                        }
                        System.out.println("You ready for combat!");
                    }
                    else if (EnemyType==2){//Elite
                        System.out.print("You are suddenly ambushed by ");
                        int X = RandomInt(1, 7);
                        if (X==1){
                            System.out.println("A Killer Bunny!");
                            MonsterName="The Killer Bunny";
                        }
                        else if (X==2){
                            System.out.println("A Dark Mage!");
                            MonsterName="The Dark Mage";
                        }
                        else if (X==3){
                            System.out.println("A Troll!");
                            MonsterName="The Cave Troll";
                        }
                        else if (X==4){
                            System.out.println("A Whelpling!");
                            MonsterName="The Dragonnet";
                        }
                        else if (X==5){
                            System.out.println("A Chest Mimic!");
                            MonsterName="The Mimic";
                        }
                        else if (X==6){
                            System.out.println("A Fallen Knight!");
                            MonsterName="The Knight";
                        }
                        else{
                            System.out.println("A Giant Centipede!");
                            MonsterName="The Centipede";
                        } 
                        System.out.println("You recover in time to fight back!");
                    }       
                    else if (EnemyType==3){//Mini-boss
                        System.out.print("Your path is blocked by ");
                        int X = RandomInt(1, 5);
                        if (X==1){
                            System.out.println("Giant Enemy Crab!");
                            MonsterName="The 'Giant Enemy Crab!'";
                        }
                        else if (X==2){
                            System.out.println("A Living Wall!");
                            MonsterName="The Wall";
                        }
                        else if (X==3){
                            System.out.println("A Giant Mole!");
                            MonsterName="The Giant Mole";
                        }
                        else if (X==4){
                            System.out.println("A Large Serpent!");
                            MonsterName="The Snake";
                        }
                        else{
                            System.out.println("A Swarm of Spiders!");
                            MonsterName="The Spiders";
                        }
                        System.out.println("They won't go down without a fight! Neither will you!");
                    }
                    else if (EnemyType==4){//Boss
                        System.out.print("You come face to face with ");
                        int X = RandomInt(1, 3);
                        if (X==1){
                            System.out.println("A Young But Fierce Drake!");
                            MonsterName="The Young Dragon";
                        }
                        else if (X==2){
                            System.out.println("A Rock Golem!");
                            MonsterName="The Golem";
                        }
                        else{
                            System.out.println("A Necromancer.");
                            MonsterName="The Necromancer";
                        }
                        System.out.println("A fierce battle ensues!");
                    }
                    else if (EnemyType==5){//Final Boss
                        MonsterName="The Dragon";
                        System.out.println();
                        if (Player.FloorsCleared<21){//This is the first time fighting the Dragon this run.
                            System.out.println("The final challange stands before you");
                            System.out.println("The Dragon has been the cause of countless tragedies, the downfall of empires, and the end of heroes.");
                            System.out.println("You face the draconic scourge, the fearsome terror of the Seven Realms.");
                            System.out.println("The Feind of the Sky, Humanity's Green Scaled Plague.");
                            System.out.println("The Feared, the Destroyer, the Devourer, the End of All Things.");
                            System.out.println("This is it. Everything has lead to this final and ultimate battle.");
                            System.out.println("Against The Dragon.");
                            System.out.println("Blight_Blaze.");
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }
                        else if (Player.FloorsCleared<41){//First re-fight
                            System.out.println("Impossible... You killed the Dragon... But they stand before you once again.");
                            System.out.println("Blight_Blaze, the bane of your existence.");
                            System.out.println("He looks as menacing as ever, but you are stronger now.");
                            System.out.println("Unfortunately, you realize he has gotten stronger as well.");
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }
                        else if (Player.FloorsCleared<61){//Second re-fight
                            System.out.println("Depite all odds, both of you are still alive.");
                            System.out.println("Blight_Blaze gives you a look of pity. He sees the trap you are in. The infinite looping.");
                            System.out.println("He understands.");
                            System.out.println("After all... Isn't he trapped too?");
                            System.out.println();
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }
                        else {//Future re-fights
                            System.out.println("You face the Dragon once more.");
                            System.out.println("...");
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }

                    }
//fights are based on a system where both parties have three actions they can take that function like rock paper scissors.The player chooses an action and the enemy's action is randomly generated. The fight continues until either the player or the enemy's health drops to 0 or below.       
                    for (int z=0; z==0;){
                        System.out.println();
                        System.out.println("Enemy Health: " + EnemyHealth);
                        System.out.println("Your Health: " + Player.Health + "/" + Player.MaxHealth);
                        System.out.println("Choose your action: Light Attack, Heavy Attack, Block");
                        System.out.println();
                        String Combat = Input.nextLine();
                        int PlayerAction = 0;
                        if (Combat.equals("Light Attack") || Combat.equals("light attack") || Combat.equals("L") || Combat.equals("l") || Combat.equals("Light") || Combat.equals("light")){
                            PlayerAction = 1;
                        }
                        else if (Combat.equals("Heavy Attack") || Combat.equals("heavy attack") || Combat.equals("H") || Combat.equals("h") || Combat.equals("Heavy") || Combat.equals("heavy")){
                            PlayerAction = 2;
                        }
                        else if (Combat.equals("Block") || Combat.equals("block") || Combat.equals("B") || Combat.equals("b")){
                            PlayerAction = 3;
                        }
                        else{
                            System.out.println("Invalid action. Please choose Light Attack, Heavy Attack, or Block.");
                            continue;
                        }
                        System.out.println();
//Enemy turn
                        int EnemyAction=0;
                        if (EnemyType==1){//Monster
                            int Y=RandomInt(1,5);
                            if (Y<3){//light
                                EnemyAction=1;
                            }
                            else if (Y==3){//heavy
                                EnemyAction=2;
                            }
                                else{//block
                                EnemyAction=3;
                            }
                        }
                        else if (EnemyType==2){//Elite
                            int Y=RandomInt(1,4);
                            if (Y==1){//light
                                EnemyAction=1;
                            }
                            else if (Y<4){//heavy
                                EnemyAction=2;
                            }
                            else{//block
                                EnemyAction=3;
                            }
                        }
                        else if (EnemyType==3){//Mini
                            int Y=RandomInt(1,5);
                            if (Y<3){//light
                                EnemyAction=1;
                            }
                            else if (Y==3){//heavy
                                EnemyAction=2;
                            }
                            else if (Y==4){//block
                                EnemyAction=3;
                            }
                            else{//Special
                                EnemyAction=4;
                            }
                        }
                        else if (EnemyType==4){//Boss
                            int Y=RandomInt(1,6);
                            if (Y==1){//light
                                EnemyAction=1;
                            }
                            else if (Y==2){//heavy
                                EnemyAction=2;
                            }
                            else if (Y==3){//block
                                EnemyAction=3;
                            }
                            else if (Y<6){//Special
                                EnemyAction=4;
                            }
                            else{//Other Special
                                EnemyAction=5;
                            }
                        }
                        else {//Dragon
                            int Y = RandomInt(1, 18);
                            if (Y<4){//Light
                                EnemyAction=1;
                            }
                            else if (Y<8){//Heavy
                                EnemyAction=2;
                            }
                            else if (Y<11){//Block
                                EnemyAction=3;
                            }
                            else if (Y<13){//Special
                                EnemyAction=4;
                            }
                            else if (Y<15){//Other Special
                                EnemyAction=5;
                            }
                            else{//Dragon Special
                                EnemyAction=6;
                            }
                        }
//Resolve Round of Combat.
                        if (PlayerAction==1){//Light
                            if (EnemyAction==1){//Light
                                PlayerDamage = Player.Strength + Player.LightDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("You Slash At " + MonsterName + "! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;
                                EnemyDamage= EnemyStrength - ((int)Math.floor(Player.Defense/2));
                                System.out.println("They Strike Back For " + EnemyDamage + " Points of Damage!");
                                Player.Health-=EnemyDamage;
                            }
                            else if (EnemyAction==2){//Heavy
                                PlayerDamage = Player.Strength + Player.LightDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("You Slash At " + MonsterName + "! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;
                                System.out.println("They Were Staggered and Can't Attack!");
                            }
                            else if (EnemyAction==3){//Block
                                System.out.println("You Attack! However " + MonsterName + " Parried Your Attack!");
                                System.out.println("They Reposte For " + EnemyStrength + " Points of Damage!");
                                Player.Health-=EnemyStrength;
                            }
                            else{//Special
                                PlayerDamage = Player.Strength + Player.LightDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("You Slash At " + MonsterName + "! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;

                            if (EnemyAction==4){//Heal
                                    System.out.println(MonsterName + " Regenerates " + Dungeon.Difficulty + " Health!");
                                    EnemyHealth+=Dungeon.Difficulty;
                                }
                                else if (EnemyAction==5){//Buff
                                    System.out.println(MonsterName + " Grows Stronger!");
                                    EnemyStrength+=((int)Math.floor(Dungeon.Difficulty/2));
                                    EnemyDefense+=((int)Math.floor(Dungeon.Difficulty/3));
                                }
                                else{//Fire-Ball
                                    System.out.println("The Dragon Spits A Fireball At You!");
                                    System.out.println("You Take " + Dungeon.Difficulty + " Points of Burning Damage.");
                                    Player.Health-=Dungeon.Difficulty;
                                }
                            }
                        }
                        else if (PlayerAction==2){//Heavy
                            if (EnemyAction==1){//Light
                                EnemyDamage= EnemyStrength - ((int)Math.floor(Player.Defense/2));
                                System.out.println(MonsterName + " Strikes You For " + EnemyDamage + " Points of Damage!");
                                Player.Health-=EnemyDamage;
                                System.out.println("You Were Staggered and Can't Attack!");
                            }
                            else if (EnemyAction==2){//Heavy
                                PlayerDamage= ((int)Math.floor(Player.Strength*1.5)) + Player.HeavyDamageModifier - ((int)Math.floor(EnemyDefense/3));
                                System.out.println("You Strike " + MonsterName + " With a Heavy Blow! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;
                                EnemyDamage= ((int)Math.floor(EnemyStrength*1.5)) - ((int)Math.floor(Player.Defense/3));
                                System.out.println("They Respond With an Attack of Their Own For " + EnemyDamage + " Points of Damage");
                                Player.Health-=EnemyDamage;
                            }       
                            else if (EnemyAction==3){//Block
                                PlayerDamage= ((int)Math.floor(Player.Strength*1.5)) + Player.HeavyDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("Your Heavy Strike Pierces " + MonsterName + "'s Defense!");
                                System.out.println("You Deal " + PlayerDamage + " Points of Dammage!");
                                EnemyHealth-=PlayerDamage;
                            }
                            else{//Special
                                PlayerDamage= ((int)Math.floor(Player.Strength*1.5)) + Player.HeavyDamageModifier - ((int)Math.floor(EnemyDefense/3));
                                System.out.println("You Strike " + MonsterName + " With a Heavy Blow! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;

                                if (EnemyAction==4){//Heal
                                    System.out.println(MonsterName + " Regenerates " + Dungeon.Difficulty + " Health!");
                                    EnemyHealth+=Dungeon.Difficulty;
                                }
                                else if (EnemyAction==5){//Buff
                                    System.out.println(MonsterName + " Grows Stronger!");
                                    EnemyStrength+=((int)Math.floor(Dungeon.Difficulty/2));
                                    EnemyDefense+=((int)Math.floor(Dungeon.Difficulty/3));
                                }
                                else{//Fire-Ball
                                    System.out.println("The Dragon Spits A Fireball At You!");
                                    System.out.println("You Take " + Dungeon.Difficulty + " Points of Burning Damage.");
                                    Player.Health-=Dungeon.Difficulty;
                                }
                            }
                        }
                        else{//Block
                            if (EnemyAction==1){//Light
                                System.out.println("You Parry " + MonsterName + "'s Attack!");
                                System.out.println("You Reposte For " + Player.Strength + " Points of Damage!");
                                EnemyHealth-=Player.Strength;
                            }
                            else if (EnemyAction==2){//Heavy
                                EnemyDamage = ((int)Math.floor(EnemyStrength*1.5)) - ((int)Math.floor(Player.Defense/2));
                                System.out.println("You Block But Are Unable to Parry " + MonsterName  + "'s Heavy Blow!");
                                System.out.println("You Are Hit For " + EnemyDamage + " Points of Damage!");
                                Player.Health-=EnemyDamage;
                            }
                            else if (EnemyAction==3){//Block
                                System.out.println("You Block at the Same Time as " + MonsterName + "!");
                                System.out.println("You Both Look Stupid!");
                            }
                            else{//Special
                                System.out.println("You Block But " + MonsterName + " Used An Ability!");

                                if (EnemyAction==4){//Heal
                                    System.out.println(MonsterName + " Regenerates " + Dungeon.Difficulty + " Health!");
                                    EnemyHealth+=Dungeon.Difficulty;
                                }
                                else if (EnemyAction==5){//Buff
                                    System.out.println(MonsterName + " Grows Stronger!");
                                    EnemyStrength+=((int)Math.floor(Dungeon.Difficulty/2));
                                    EnemyDefense+=((int)Math.floor(Dungeon.Difficulty/3));
                                }
                                else{//Fire-Ball
                                    System.out.println("The Dragon Spits A Fireball At You!");
                                    System.out.println("You Take " + Dungeon.Difficulty + " Points of Burning Damage.");
                                    Player.Health-=Dungeon.Difficulty;
                                }
                            }
                        }
                        System.out.println();
//Check For Death
                        if (Player.Health<=0){//Player Death overrides monster death.
                            System.out.println("After a particularly nasty blow, you fall unconscious!");
                            z=1;
                        }
                        else if (EnemyHealth<=0){//Enemy Death
                            if (EnemyType<3){
                                Player.Kills++;
                                System.out.println("You deal a final blow and finish off your opponent!");
                            }
                            int XP=(int) Math.pow(10, EnemyType);
                            Player.Gold+=((EnemyType+1)*(Dungeon.Difficulty+1));
                            System.out.println("You Gained " + ((EnemyType+1)*(Dungeon.Difficulty+1)) + " Gold!");
                            Player.GainEXP((int)Math.ceil(XP)*(Dungeon.Difficulty));//You get more XP on deeper floors, but less as you level up.
                            z=1;
                        }
                    }
                }
                else if (Room==2){
                    System.out.println("You are attacked by an elite monster!");
                    Dungeon.ClearRoom();
                    int EnemyStrength=Dungeon.Difficulty+5;
                    int EnemyHealth=(Dungeon.Difficulty+1)*10;
                    int EnemyDefense=RandomInt(Dungeon.Difficulty+5, Dungeon.Difficulty+10);
                    int EnemyType=2;

                    System.out.println();
                    int PlayerDamage;
                    int EnemyDamage;
                    String MonsterName="";//Allows me to refer to the monster later.
                    if (EnemyType==1){//Monster
                        System.out.print("You encounter ");
                        int X = RandomInt(1, 10);
                        if (X==1){
                            System.out.println("A Slime!");
                            MonsterName="The Slime";
                        }
                        else if (X==2){
                            System.out.println("A Ghost");
                            MonsterName="The Ghost";
                        }
                        else if (X==3){
                            System.out.println("A Putrid Rat!");
                            MonsterName="The Rat";
                        }
                        else if (X==4){
                            System.out.println("A Goblin!");
                            MonsterName="The Goblin";
                        }
                        else if (X==5){
                            System.out.println("A Thief!");
                            MonsterName="The Thief";
                        }
                        else if (X==6){
                            System.out.println("A Bat Swarm!");
                            MonsterName="The Bats";
                        }
                        else if (X==7){
                            System.out.println("A Wlidcat");
                            MonsterName="The Wildcat";
                        }
                        else if (X==8){
                            System.out.println("A Undead Adventure!");
                            MonsterName="The Skeleton";
                        }
                        else if (X==9){
                            System.out.println("A Strangling Vine!");
                            MonsterName="The Plant";
                        }
                        else{
                            System.out.println("'MISSINGNO.'!");
                            MonsterName="The *&%$$#_*^%&^";
                        }
                        System.out.println("You ready for combat!");
                    }
                    else if (EnemyType==2){//Elite
                        System.out.print("You are suddenly ambushed by ");
                        int X = RandomInt(1, 7);
                        if (X==1){
                            System.out.println("A Killer Bunny!");
                            MonsterName="The Killer Bunny";
                        }
                        else if (X==2){
                            System.out.println("A Dark Mage!");
                            MonsterName="The Dark Mage";
                        }
                        else if (X==3){
                            System.out.println("A Troll!");
                            MonsterName="The Cave Troll";
                        }
                        else if (X==4){
                            System.out.println("A Whelpling!");
                            MonsterName="The Dragonnet";
                        }
                        else if (X==5){
                            System.out.println("A Chest Mimic!");
                            MonsterName="The Mimic";
                        }
                        else if (X==6){
                            System.out.println("A Fallen Knight!");
                            MonsterName="The Knight";
                        }
                        else{
                            System.out.println("A Giant Centipede!");
                            MonsterName="The Centipede";
                        } 
                        System.out.println("You recover in time to fight back!");
                    }       
                    else if (EnemyType==3){//Mini-boss
                        System.out.print("Your path is blocked by ");
                        int X = RandomInt(1, 5);
                        if (X==1){
                            System.out.println("Giant Enemy Crab!");
                            MonsterName="The 'Giant Enemy Crab!'";
                        }
                        else if (X==2){
                            System.out.println("A Living Wall!");
                            MonsterName="The Wall";
                        }
                        else if (X==3){
                            System.out.println("A Giant Mole!");
                            MonsterName="The Giant Mole";
                        }
                        else if (X==4){
                            System.out.println("A Large Serpent!");
                            MonsterName="The Snake";
                        }
                        else{
                            System.out.println("A Swarm of Spiders!");
                            MonsterName="The Spiders";
                        }
                        System.out.println("They won't go down without a fight! Neither will you!");
                    }
                    else if (EnemyType==4){//Boss
                        System.out.print("You come face to face with ");
                        int X = RandomInt(1, 3);
                        if (X==1){
                            System.out.println("A Young But Fierce Drake!");
                            MonsterName="The Young Dragon";
                        }
                        else if (X==2){
                            System.out.println("A Rock Golem!");
                            MonsterName="The Golem";
                        }
                        else{
                            System.out.println("A Necromancer.");
                            MonsterName="The Necromancer";
                        }
                        System.out.println("A fierce battle ensues!");
                    }
                    else if (EnemyType==5){//Final Boss
                        MonsterName="The Dragon";
                        System.out.println();
                        if (Player.FloorsCleared<21){//This is the first time fighting the Dragon this run.
                            System.out.println("The final challange stands before you");
                            System.out.println("The Dragon has been the cause of countless tragedies, the downfall of empires, and the end of heroes.");
                            System.out.println("You face the draconic scourge, the fearsome terror of the Seven Realms.");
                            System.out.println("The Feind of the Sky, Humanity's Green Scaled Plague.");
                            System.out.println("The Feared, the Destroyer, the Devourer, the End of All Things.");
                            System.out.println("This is it. Everything has lead to this final and ultimate battle.");
                            System.out.println("Against The Dragon.");
                            System.out.println("Blight_Blaze.");
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }
                        else if (Player.FloorsCleared<41){//First re-fight
                            System.out.println("Impossible... You killed the Dragon... But they stand before you once again.");
                            System.out.println("Blight_Blaze, the bane of your existence.");
                            System.out.println("He looks as menacing as ever, but you are stronger now.");
                            System.out.println("Unfortunately, you realize he has gotten stronger as well.");
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }
                        else if (Player.FloorsCleared<61){//Second re-fight
                            System.out.println("Depite all odds, both of you are still alive.");
                            System.out.println("Blight_Blaze gives you a look of pity. He sees the trap you are in. The infinite looping.");
                            System.out.println("He understands.");
                            System.out.println("After all... Isn't he trapped too?");
                            System.out.println();
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }
                        else {//Future re-fights
                            System.out.println("You face the Dragon once more.");
                            System.out.println("...");
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }

                    }
//fights are based on a system where both parties have three actions they can take that function like rock paper scissors.The player chooses an action and the enemy's action is randomly generated. The fight continues until either the player or the enemy's health drops to 0 or below.       
                    for (int z=0; z==0;){
                        System.out.println();
                        System.out.println("Enemy Health: " + EnemyHealth);
                        System.out.println("Your Health: " + Player.Health + "/" + Player.MaxHealth);
                        System.out.println("Choose your action: Light Attack, Heavy Attack, Block");
                        System.out.println();
                        String Combat = Input.nextLine();
                        int PlayerAction = 0;
                        if (Combat.equals("Light Attack") || Combat.equals("light attack") || Combat.equals("L") || Combat.equals("l") || Combat.equals("Light") || Combat.equals("light")){
                            PlayerAction = 1;
                        }
                        else if (Combat.equals("Heavy Attack") || Combat.equals("heavy attack") || Combat.equals("H") || Combat.equals("h") || Combat.equals("Heavy") || Combat.equals("heavy")){
                            PlayerAction = 2;
                        }
                        else if (Combat.equals("Block") || Combat.equals("block") || Combat.equals("B") || Combat.equals("b")){
                            PlayerAction = 3;
                        }
                        else{
                            System.out.println("Invalid action. Please choose Light Attack, Heavy Attack, or Block.");
                            continue;
                        }
                        System.out.println();
//Enemy turn
                        int EnemyAction=0;
                        if (EnemyType==1){//Monster
                            int Y=RandomInt(1,5);
                            if (Y<3){//light
                                EnemyAction=1;
                            }
                            else if (Y==3){//heavy
                                EnemyAction=2;
                            }
                                else{//block
                                EnemyAction=3;
                            }
                        }
                        else if (EnemyType==2){//Elite
                            int Y=RandomInt(1,4);
                            if (Y==1){//light
                                EnemyAction=1;
                            }
                            else if (Y<4){//heavy
                                EnemyAction=2;
                            }
                            else{//block
                                EnemyAction=3;
                            }
                        }
                        else if (EnemyType==3){//Mini
                            int Y=RandomInt(1,5);
                            if (Y<3){//light
                                EnemyAction=1;
                            }
                            else if (Y==3){//heavy
                                EnemyAction=2;
                            }
                            else if (Y==4){//block
                                EnemyAction=3;
                            }
                            else{//Special
                                EnemyAction=4;
                            }
                        }
                        else if (EnemyType==4){//Boss
                            int Y=RandomInt(1,6);
                            if (Y==1){//light
                                EnemyAction=1;
                            }
                            else if (Y==2){//heavy
                                EnemyAction=2;
                            }
                            else if (Y==3){//block
                                EnemyAction=3;
                            }
                            else if (Y<6){//Special
                                EnemyAction=4;
                            }
                            else{//Other Special
                                EnemyAction=5;
                            }
                        }
                        else {//Dragon
                            int Y = RandomInt(1, 18);
                            if (Y<4){//Light
                                EnemyAction=1;
                            }
                            else if (Y<8){//Heavy
                                EnemyAction=2;
                            }
                            else if (Y<11){//Block
                                EnemyAction=3;
                            }
                            else if (Y<13){//Special
                                EnemyAction=4;
                            }
                            else if (Y<15){//Other Special
                                EnemyAction=5;
                            }
                            else{//Dragon Special
                                EnemyAction=6;
                            }
                        }
//Resolve Round of Combat.
                        if (PlayerAction==1){//Light
                            if (EnemyAction==1){//Light
                                PlayerDamage = Player.Strength + Player.LightDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("You Slash At " + MonsterName + "! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;
                                EnemyDamage= EnemyStrength - ((int)Math.floor(Player.Defense/2));
                                System.out.println("They Strike Back For " + EnemyDamage + " Points of Damage!");
                                Player.Health-=EnemyDamage;
                            }
                            else if (EnemyAction==2){//Heavy
                                PlayerDamage = Player.Strength + Player.LightDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("You Slash At " + MonsterName + "! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;
                                System.out.println("They Were Staggered and Can't Attack!");
                            }
                            else if (EnemyAction==3){//Block
                                System.out.println("You Attack! However " + MonsterName + " Parried Your Attack!");
                                System.out.println("They Reposte For " + EnemyStrength + " Points of Damage!");
                                Player.Health-=EnemyStrength;
                            }
                            else{//Special
                                PlayerDamage = Player.Strength + Player.LightDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("You Slash At " + MonsterName + "! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;

                            if (EnemyAction==4){//Heal
                                    System.out.println(MonsterName + " Regenerates " + Dungeon.Difficulty + " Health!");
                                    EnemyHealth+=Dungeon.Difficulty;
                                }
                                else if (EnemyAction==5){//Buff
                                    System.out.println(MonsterName + " Grows Stronger!");
                                    EnemyStrength+=((int)Math.floor(Dungeon.Difficulty/2));
                                    EnemyDefense+=((int)Math.floor(Dungeon.Difficulty/3));
                                }
                                else{//Fire-Ball
                                    System.out.println("The Dragon Spits A Fireball At You!");
                                    System.out.println("You Take " + Dungeon.Difficulty + " Points of Burning Damage.");
                                    Player.Health-=Dungeon.Difficulty;
                                }
                            }
                        }
                        else if (PlayerAction==2){//Heavy
                            if (EnemyAction==1){//Light
                                EnemyDamage= EnemyStrength - ((int)Math.floor(Player.Defense/2));
                                System.out.println(MonsterName + " Strikes You For " + EnemyDamage + " Points of Damage!");
                                Player.Health-=EnemyDamage;
                                System.out.println("You Were Staggered and Can't Attack!");
                            }
                            else if (EnemyAction==2){//Heavy
                                PlayerDamage= ((int)Math.floor(Player.Strength*1.5)) + Player.HeavyDamageModifier - ((int)Math.floor(EnemyDefense/3));
                                System.out.println("You Strike " + MonsterName + " With a Heavy Blow! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;
                                EnemyDamage= ((int)Math.floor(EnemyStrength*1.5)) - ((int)Math.floor(Player.Defense/3));
                                System.out.println("They Respond With an Attack of Their Own For " + EnemyDamage + " Points of Damage");
                                Player.Health-=EnemyDamage;
                            }       
                            else if (EnemyAction==3){//Block
                                PlayerDamage= ((int)Math.floor(Player.Strength*1.5)) + Player.HeavyDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("Your Heavy Strike Pierces " + MonsterName + "'s Defense!");
                                System.out.println("You Deal " + PlayerDamage + " Points of Dammage!");
                                EnemyHealth-=PlayerDamage;
                            }
                            else{//Special
                                PlayerDamage= ((int)Math.floor(Player.Strength*1.5)) + Player.HeavyDamageModifier - ((int)Math.floor(EnemyDefense/3));
                                System.out.println("You Strike " + MonsterName + " With a Heavy Blow! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;

                                if (EnemyAction==4){//Heal
                                    System.out.println(MonsterName + " Regenerates " + Dungeon.Difficulty + " Health!");
                                    EnemyHealth+=Dungeon.Difficulty;
                                }
                                else if (EnemyAction==5){//Buff
                                    System.out.println(MonsterName + " Grows Stronger!");
                                    EnemyStrength+=((int)Math.floor(Dungeon.Difficulty/2));
                                    EnemyDefense+=((int)Math.floor(Dungeon.Difficulty/3));
                                }
                                else{//Fire-Ball
                                    System.out.println("The Dragon Spits A Fireball At You!");
                                    System.out.println("You Take " + Dungeon.Difficulty + " Points of Burning Damage.");
                                    Player.Health-=Dungeon.Difficulty;
                                }
                            }
                        }
                        else{//Block
                            if (EnemyAction==1){//Light
                                System.out.println("You Parry " + MonsterName + "'s Attack!");
                                System.out.println("You Reposte For " + Player.Strength + " Points of Damage!");
                                EnemyHealth-=Player.Strength;
                            }
                            else if (EnemyAction==2){//Heavy
                                EnemyDamage = ((int)Math.floor(EnemyStrength*1.5)) - ((int)Math.floor(Player.Defense/2));
                                System.out.println("You Block But Are Unable to Parry " + MonsterName  + "'s Heavy Blow!");
                                System.out.println("You Are Hit For " + EnemyDamage + " Points of Damage!");
                                Player.Health-=EnemyDamage;
                            }
                            else if (EnemyAction==3){//Block
                                System.out.println("You Block at the Same Time as " + MonsterName + "!");
                                System.out.println("You Both Look Stupid!");
                            }
                            else{//Special
                                System.out.println("You Block But " + MonsterName + " Used An Ability!");

                                if (EnemyAction==4){//Heal
                                    System.out.println(MonsterName + " Regenerates " + Dungeon.Difficulty + " Health!");
                                    EnemyHealth+=Dungeon.Difficulty;
                                }
                                else if (EnemyAction==5){//Buff
                                    System.out.println(MonsterName + " Grows Stronger!");
                                    EnemyStrength+=((int)Math.floor(Dungeon.Difficulty/2));
                                    EnemyDefense+=((int)Math.floor(Dungeon.Difficulty/3));
                                }
                                else{//Fire-Ball
                                    System.out.println("The Dragon Spits A Fireball At You!");
                                    System.out.println("You Take " + Dungeon.Difficulty + " Points of Burning Damage.");
                                    Player.Health-=Dungeon.Difficulty;
                                }
                            }
                        }
                        System.out.println();
//Check For Death
                        if (Player.Health<=0){//Player Death overrides monster death.
                            System.out.println("After a particularly nasty blow, you fall unconscious!");
                            z=1;
                        }
                        else if (EnemyHealth<=0){//Enemy Death
                            if (EnemyType<3){
                                Player.Kills++;
                                System.out.println("You deal a final blow and finish off your opponent!");
                            }
                            int XP=(int) Math.pow(10, EnemyType);
                            Player.Gold+=((EnemyType+1)*(Dungeon.Difficulty+1));
                            System.out.println("You Gained " + ((EnemyType+1)*(Dungeon.Difficulty+1)) + " Gold!");
                            Player.GainEXP((int)Math.ceil(XP)*(Dungeon.Difficulty));//You get more XP on deeper floors, but less as you level up.
                            z=1;
                        }
                    }
                }
                else if (Room==3){
                    System.out.println("You find a Rest Spot and heal to full health.");
                    if (!(Player.Health==Player.MaxHealth)){//Only Heal if Hurt
                        Player.Health = Player.MaxHealth;
                        Dungeon.ClearRoom();
                    }
                }
                else if (Room==4){
                    System.out.println("You find a shop. You can buy upgrades here.");
                    Dungeon.ClearRoom();
                    for (int q=0; q<Dungeon.Difficulty; q++){//You may purchase items up to the Diffculty of the floor.
                        System.out.println("You have " + Player.Gold + " Gold. You may purchase up to " + (Dungeon.Difficulty-q) + " more items.");
                        System.out.println("0: Leave Shop");
                        System.out.println("1: Increase Strength by 1 for " + (7*Dungeon.Difficulty) + " Gold.");
                        System.out.println("2: Increase Light Damage Modifier by 1 for " + (2*Dungeon.Difficulty) + " Gold.");
                        System.out.println("3: Increase Heavy Damage Modifier by 1 for " + (3*Dungeon.Difficulty) + " Gold.");
                        System.out.println("4: Increase Defense by 1 for " + (5*Dungeon.Difficulty) + " Gold.");
                        System.out.println("5: Increase Max Health by 5 for " + (10*Dungeon.Difficulty) + " Gold.");
                        System.out.println("6: Buy 1 key for " + (15*Dungeon.Difficulty) + " Gold.");
                        System.out.println("Stats: Prints your stats.");
                        String choice = Input.nextLine();
                        if (choice.equals("0")){
                            break;
                        }
                        else if (choice.equals("1") && Player.Gold >= (7*Dungeon.Difficulty)){
                            Player.Strength++;
                            Player.Gold -= (7*Dungeon.Difficulty);
                            System.out.println("Strength increased to " + Player.Strength + "!");
                        }
                        else if (choice.equals("2") && Player.Gold >= (2*Dungeon.Difficulty)){
                            Player.LightDamageModifier++;
                            Player.Gold -= (2*Dungeon.Difficulty);
                            System.out.println("Light Damage Modifier increased to " + Player.LightDamageModifier + "!");
                        }
                        else if (choice.equals("3") && Player.Gold >= (3*Dungeon.Difficulty)){
                            Player.HeavyDamageModifier++;
                            Player.Gold -= (3*Dungeon.Difficulty);
                            System.out.println("Heavy Damage Modifier increased to " + Player.HeavyDamageModifier + "!");
                        }
                        else if (choice.equals("4") && Player.Gold >= (5*Dungeon.Difficulty)){
                            Player.Defense++;
                            Player.Gold -= (5*Dungeon.Difficulty);
                            System.out.println("Defense increased to " + Player.Defense + "!");
                        }
                        else if (choice.equals("5") && Player.Gold >= (10*Dungeon.Difficulty)){
                            Player.MaxHealth += 5;
                            Player.Health += 5;
                            Player.Gold -= (10*Dungeon.Difficulty);
                            System.out.println("Max Health increased to " + Player.MaxHealth + "! Health increased to " + Player.Health + "!");
                        }
                        else if (choice.equals("6") && Player.Gold >= (15*Dungeon.Difficulty)){
                            Player.Keys++;
                            Player.Gold -= (15*Dungeon.Difficulty);
                            System.out.println("You bought a key! You now have " + Player.Keys + " keys.");
                        }
                        else if (Action.equals("Stats") || Action.equals("stats")){//Prints the player's stats.
                            Player.Stats();
                        }
                        else{
                            System.out.println("Invalid choice or not enough gold.");
                            q--;
                        }
                        System.out.println();
                    }
                    System.out.println("The Shopkepper packs up and leaves.");
                }
                else if (Room==5){
                    System.out.println("You find a treasure chest!");
                    Player.Treasure(Dungeon.Difficulty);
                    Dungeon.ClearRoom();
                }
            }
            else if (Action.equals("E") || Action.equals("e") || Action.equals("East") || Action.equals("east")){
                int Room = Dungeon.MoveE();
                if (Room==-2){
                    System.out.println("You are blocked by a wall.");
                }
                else if (Room==-1){
                    System.out.println("You find the entrance room.");
                }
                else if (Room==0){
                    System.out.println("You enter an empty room.");
                }
                else if (Room==1){
                    System.out.println("You are attacked by a monster!");
                    Dungeon.ClearRoom();
                    int EnemyStrength=Dungeon.Difficulty+2;
                    int EnemyHealth=(Dungeon.Difficulty+1)*5;
                    int EnemyDefense=RandomInt(Dungeon.Difficulty, Dungeon.Difficulty+5);
                    int EnemyType=1;

                    System.out.println();
                    int PlayerDamage;
                    int EnemyDamage;
                    String MonsterName="";//Allows me to refer to the monster later.
                    if (EnemyType==1){//Monster
                        System.out.print("You encounter ");
                        int X = RandomInt(1, 10);
                        if (X==1){
                            System.out.println("A Slime!");
                            MonsterName="The Slime";
                        }
                        else if (X==2){
                            System.out.println("A Ghost");
                            MonsterName="The Ghost";
                        }
                        else if (X==3){
                            System.out.println("A Putrid Rat!");
                            MonsterName="The Rat";
                        }
                        else if (X==4){
                            System.out.println("A Goblin!");
                            MonsterName="The Goblin";
                        }
                        else if (X==5){
                            System.out.println("A Thief!");
                            MonsterName="The Thief";
                        }
                        else if (X==6){
                            System.out.println("A Bat Swarm!");
                            MonsterName="The Bats";
                        }
                        else if (X==7){
                            System.out.println("A Wlidcat");
                            MonsterName="The Wildcat";
                        }
                        else if (X==8){
                            System.out.println("A Undead Adventure!");
                            MonsterName="The Skeleton";
                        }
                        else if (X==9){
                            System.out.println("A Strangling Vine!");
                            MonsterName="The Plant";
                        }
                        else{
                            System.out.println("'MISSINGNO.'!");
                            MonsterName="The *&%$$#_*^%&^";
                        }
                        System.out.println("You ready for combat!");
                    }
                    else if (EnemyType==2){//Elite
                        System.out.print("You are suddenly ambushed by ");
                        int X = RandomInt(1, 7);
                        if (X==1){
                            System.out.println("A Killer Bunny!");
                            MonsterName="The Killer Bunny";
                        }
                        else if (X==2){
                            System.out.println("A Dark Mage!");
                            MonsterName="The Dark Mage";
                        }
                        else if (X==3){
                            System.out.println("A Troll!");
                            MonsterName="The Cave Troll";
                        }
                        else if (X==4){
                            System.out.println("A Whelpling!");
                            MonsterName="The Dragonnet";
                        }
                        else if (X==5){
                            System.out.println("A Chest Mimic!");
                            MonsterName="The Mimic";
                        }
                        else if (X==6){
                            System.out.println("A Fallen Knight!");
                            MonsterName="The Knight";
                        }
                        else{
                            System.out.println("A Giant Centipede!");
                            MonsterName="The Centipede";
                        } 
                        System.out.println("You recover in time to fight back!");
                    }       
                    else if (EnemyType==3){//Mini-boss
                        System.out.print("Your path is blocked by ");
                        int X = RandomInt(1, 5);
                        if (X==1){
                            System.out.println("Giant Enemy Crab!");
                            MonsterName="The 'Giant Enemy Crab!'";
                        }
                        else if (X==2){
                            System.out.println("A Living Wall!");
                            MonsterName="The Wall";
                        }
                        else if (X==3){
                            System.out.println("A Giant Mole!");
                            MonsterName="The Giant Mole";
                        }
                        else if (X==4){
                            System.out.println("A Large Serpent!");
                            MonsterName="The Snake";
                        }
                        else{
                            System.out.println("A Swarm of Spiders!");
                            MonsterName="The Spiders";
                        }
                        System.out.println("They won't go down without a fight! Neither will you!");
                    }
                    else if (EnemyType==4){//Boss
                        System.out.print("You come face to face with ");
                        int X = RandomInt(1, 3);
                        if (X==1){
                            System.out.println("A Young But Fierce Drake!");
                            MonsterName="The Young Dragon";
                        }
                        else if (X==2){
                            System.out.println("A Rock Golem!");
                            MonsterName="The Golem";
                        }
                        else{
                            System.out.println("A Necromancer.");
                            MonsterName="The Necromancer";
                        }
                        System.out.println("A fierce battle ensues!");
                    }
                    else if (EnemyType==5){//Final Boss
                        MonsterName="The Dragon";
                        System.out.println();
                        if (Player.FloorsCleared<21){//This is the first time fighting the Dragon this run.
                            System.out.println("The final challange stands before you");
                            System.out.println("The Dragon has been the cause of countless tragedies, the downfall of empires, and the end of heroes.");
                            System.out.println("You face the draconic scourge, the fearsome terror of the Seven Realms.");
                            System.out.println("The Feind of the Sky, Humanity's Green Scaled Plague.");
                            System.out.println("The Feared, the Destroyer, the Devourer, the End of All Things.");
                            System.out.println("This is it. Everything has lead to this final and ultimate battle.");
                            System.out.println("Against The Dragon.");
                            System.out.println("Blight_Blaze.");
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }
                        else if (Player.FloorsCleared<41){//First re-fight
                            System.out.println("Impossible... You killed the Dragon... But they stand before you once again.");
                            System.out.println("Blight_Blaze, the bane of your existence.");
                            System.out.println("He looks as menacing as ever, but you are stronger now.");
                            System.out.println("Unfortunately, you realize he has gotten stronger as well.");
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }
                        else if (Player.FloorsCleared<61){//Second re-fight
                            System.out.println("Depite all odds, both of you are still alive.");
                            System.out.println("Blight_Blaze gives you a look of pity. He sees the trap you are in. The infinite looping.");
                            System.out.println("He understands.");
                            System.out.println("After all... Isn't he trapped too?");
                            System.out.println();
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }
                        else {//Future re-fights
                            System.out.println("You face the Dragon once more.");
                            System.out.println("...");
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }

                    }
//fights are based on a system where both parties have three actions they can take that function like rock paper scissors.The player chooses an action and the enemy's action is randomly generated. The fight continues until either the player or the enemy's health drops to 0 or below.       
                    for (int z=0; z==0;){
                        System.out.println();
                        System.out.println("Enemy Health: " + EnemyHealth);
                        System.out.println("Your Health: " + Player.Health + "/" + Player.MaxHealth);
                        System.out.println("Choose your action: Light Attack, Heavy Attack, Block");
                        System.out.println();
                        String Combat = Input.nextLine();
                        int PlayerAction = 0;
                        if (Combat.equals("Light Attack") || Combat.equals("light attack") || Combat.equals("L") || Combat.equals("l") || Combat.equals("Light") || Combat.equals("light")){
                            PlayerAction = 1;
                        }
                        else if (Combat.equals("Heavy Attack") || Combat.equals("heavy attack") || Combat.equals("H") || Combat.equals("h") || Combat.equals("Heavy") || Combat.equals("heavy")){
                            PlayerAction = 2;
                        }
                        else if (Combat.equals("Block") || Combat.equals("block") || Combat.equals("B") || Combat.equals("b")){
                            PlayerAction = 3;
                        }
                        else{
                            System.out.println("Invalid action. Please choose Light Attack, Heavy Attack, or Block.");
                            continue;
                        }
                        System.out.println();
//Enemy turn
                        int EnemyAction=0;
                        if (EnemyType==1){//Monster
                            int Y=RandomInt(1,5);
                            if (Y<3){//light
                                EnemyAction=1;
                            }
                            else if (Y==3){//heavy
                                EnemyAction=2;
                            }
                                else{//block
                                EnemyAction=3;
                            }
                        }
                        else if (EnemyType==2){//Elite
                            int Y=RandomInt(1,4);
                            if (Y==1){//light
                                EnemyAction=1;
                            }
                            else if (Y<4){//heavy
                                EnemyAction=2;
                            }
                            else{//block
                                EnemyAction=3;
                            }
                        }
                        else if (EnemyType==3){//Mini
                            int Y=RandomInt(1,5);
                            if (Y<3){//light
                                EnemyAction=1;
                            }
                            else if (Y==3){//heavy
                                EnemyAction=2;
                            }
                            else if (Y==4){//block
                                EnemyAction=3;
                            }
                            else{//Special
                                EnemyAction=4;
                            }
                        }
                        else if (EnemyType==4){//Boss
                            int Y=RandomInt(1,6);
                            if (Y==1){//light
                                EnemyAction=1;
                            }
                            else if (Y==2){//heavy
                                EnemyAction=2;
                            }
                            else if (Y==3){//block
                                EnemyAction=3;
                            }
                            else if (Y<6){//Special
                                EnemyAction=4;
                            }
                            else{//Other Special
                                EnemyAction=5;
                            }
                        }
                        else {//Dragon
                            int Y = RandomInt(1, 18);
                            if (Y<4){//Light
                                EnemyAction=1;
                            }
                            else if (Y<8){//Heavy
                                EnemyAction=2;
                            }
                            else if (Y<11){//Block
                                EnemyAction=3;
                            }
                            else if (Y<13){//Special
                                EnemyAction=4;
                            }
                            else if (Y<15){//Other Special
                                EnemyAction=5;
                            }
                            else{//Dragon Special
                                EnemyAction=6;
                            }
                        }
//Resolve Round of Combat.
                        if (PlayerAction==1){//Light
                            if (EnemyAction==1){//Light
                                PlayerDamage = Player.Strength + Player.LightDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("You Slash At " + MonsterName + "! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;
                                EnemyDamage= EnemyStrength - ((int)Math.floor(Player.Defense/2));
                                System.out.println("They Strike Back For " + EnemyDamage + " Points of Damage!");
                                Player.Health-=EnemyDamage;
                            }
                            else if (EnemyAction==2){//Heavy
                                PlayerDamage = Player.Strength + Player.LightDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("You Slash At " + MonsterName + "! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;
                                System.out.println("They Were Staggered and Can't Attack!");
                            }
                            else if (EnemyAction==3){//Block
                                System.out.println("You Attack! However " + MonsterName + " Parried Your Attack!");
                                System.out.println("They Reposte For " + EnemyStrength + " Points of Damage!");
                                Player.Health-=EnemyStrength;
                            }
                            else{//Special
                                PlayerDamage = Player.Strength + Player.LightDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("You Slash At " + MonsterName + "! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;

                            if (EnemyAction==4){//Heal
                                    System.out.println(MonsterName + " Regenerates " + Dungeon.Difficulty + " Health!");
                                    EnemyHealth+=Dungeon.Difficulty;
                                }
                                else if (EnemyAction==5){//Buff
                                    System.out.println(MonsterName + " Grows Stronger!");
                                    EnemyStrength+=((int)Math.floor(Dungeon.Difficulty/2));
                                    EnemyDefense+=((int)Math.floor(Dungeon.Difficulty/3));
                                }
                                else{//Fire-Ball
                                    System.out.println("The Dragon Spits A Fireball At You!");
                                    System.out.println("You Take " + Dungeon.Difficulty + " Points of Burning Damage.");
                                    Player.Health-=Dungeon.Difficulty;
                                }
                            }
                        }
                        else if (PlayerAction==2){//Heavy
                            if (EnemyAction==1){//Light
                                EnemyDamage= EnemyStrength - ((int)Math.floor(Player.Defense/2));
                                System.out.println(MonsterName + " Strikes You For " + EnemyDamage + " Points of Damage!");
                                Player.Health-=EnemyDamage;
                                System.out.println("You Were Staggered and Can't Attack!");
                            }
                            else if (EnemyAction==2){//Heavy
                                PlayerDamage= ((int)Math.floor(Player.Strength*1.5)) + Player.HeavyDamageModifier - ((int)Math.floor(EnemyDefense/3));
                                System.out.println("You Strike " + MonsterName + " With a Heavy Blow! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;
                                EnemyDamage= ((int)Math.floor(EnemyStrength*1.5)) - ((int)Math.floor(Player.Defense/3));
                                System.out.println("They Respond With an Attack of Their Own For " + EnemyDamage + " Points of Damage");
                                Player.Health-=EnemyDamage;
                            }       
                            else if (EnemyAction==3){//Block
                                PlayerDamage= ((int)Math.floor(Player.Strength*1.5)) + Player.HeavyDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("Your Heavy Strike Pierces " + MonsterName + "'s Defense!");
                                System.out.println("You Deal " + PlayerDamage + " Points of Dammage!");
                                EnemyHealth-=PlayerDamage;
                            }
                            else{//Special
                                PlayerDamage= ((int)Math.floor(Player.Strength*1.5)) + Player.HeavyDamageModifier - ((int)Math.floor(EnemyDefense/3));
                                System.out.println("You Strike " + MonsterName + " With a Heavy Blow! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;

                                if (EnemyAction==4){//Heal
                                    System.out.println(MonsterName + " Regenerates " + Dungeon.Difficulty + " Health!");
                                    EnemyHealth+=Dungeon.Difficulty;
                                }
                                else if (EnemyAction==5){//Buff
                                    System.out.println(MonsterName + " Grows Stronger!");
                                    EnemyStrength+=((int)Math.floor(Dungeon.Difficulty/2));
                                    EnemyDefense+=((int)Math.floor(Dungeon.Difficulty/3));
                                }
                                else{//Fire-Ball
                                    System.out.println("The Dragon Spits A Fireball At You!");
                                    System.out.println("You Take " + Dungeon.Difficulty + " Points of Burning Damage.");
                                    Player.Health-=Dungeon.Difficulty;
                                }
                            }
                        }
                        else{//Block
                            if (EnemyAction==1){//Light
                                System.out.println("You Parry " + MonsterName + "'s Attack!");
                                System.out.println("You Reposte For " + Player.Strength + " Points of Damage!");
                                EnemyHealth-=Player.Strength;
                            }
                            else if (EnemyAction==2){//Heavy
                                EnemyDamage = ((int)Math.floor(EnemyStrength*1.5)) - ((int)Math.floor(Player.Defense/2));
                                System.out.println("You Block But Are Unable to Parry " + MonsterName  + "'s Heavy Blow!");
                                System.out.println("You Are Hit For " + EnemyDamage + " Points of Damage!");
                                Player.Health-=EnemyDamage;
                            }
                            else if (EnemyAction==3){//Block
                                System.out.println("You Block at the Same Time as " + MonsterName + "!");
                                System.out.println("You Both Look Stupid!");
                            }
                            else{//Special
                                System.out.println("You Block But " + MonsterName + " Used An Ability!");

                                if (EnemyAction==4){//Heal
                                    System.out.println(MonsterName + " Regenerates " + Dungeon.Difficulty + " Health!");
                                    EnemyHealth+=Dungeon.Difficulty;
                                }
                                else if (EnemyAction==5){//Buff
                                    System.out.println(MonsterName + " Grows Stronger!");
                                    EnemyStrength+=((int)Math.floor(Dungeon.Difficulty/2));
                                    EnemyDefense+=((int)Math.floor(Dungeon.Difficulty/3));
                                }
                                else{//Fire-Ball
                                    System.out.println("The Dragon Spits A Fireball At You!");
                                    System.out.println("You Take " + Dungeon.Difficulty + " Points of Burning Damage.");
                                    Player.Health-=Dungeon.Difficulty;
                                }
                            }
                        }
                        System.out.println();
//Check For Death
                        if (Player.Health<=0){//Player Death overrides monster death.
                            System.out.println("After a particularly nasty blow, you fall unconscious!");
                            z=1;
                        }
                        else if (EnemyHealth<=0){//Enemy Death
                            if (EnemyType<3){
                                Player.Kills++;
                                System.out.println("You deal a final blow and finish off your opponent!");
                            }
                            int XP=(int) Math.pow(10, EnemyType);
                            Player.Gold+=((EnemyType+1)*(Dungeon.Difficulty+1));
                            System.out.println("You Gained " + ((EnemyType+1)*(Dungeon.Difficulty+1)) + " Gold!");
                            Player.GainEXP((int)Math.ceil(XP)*(Dungeon.Difficulty));//You get more XP on deeper floors, but less as you level up.
                            z=1;
                        }
                    }
                }
                else if (Room==2){
                    System.out.println("You are attacked by an elite monster!");
                    Dungeon.ClearRoom();
                    int EnemyStrength=Dungeon.Difficulty+5;
                    int EnemyHealth=(Dungeon.Difficulty+1)*10;
                    int EnemyDefense=RandomInt(Dungeon.Difficulty+5, Dungeon.Difficulty+10);
                    int EnemyType=2;

                    System.out.println();
                    int PlayerDamage;
                    int EnemyDamage;
                    String MonsterName="";//Allows me to refer to the monster later.
                    if (EnemyType==1){//Monster
                        System.out.print("You encounter ");
                        int X = RandomInt(1, 10);
                        if (X==1){
                            System.out.println("A Slime!");
                            MonsterName="The Slime";
                        }
                        else if (X==2){
                            System.out.println("A Ghost");
                            MonsterName="The Ghost";
                        }
                        else if (X==3){
                            System.out.println("A Putrid Rat!");
                            MonsterName="The Rat";
                        }
                        else if (X==4){
                            System.out.println("A Goblin!");
                            MonsterName="The Goblin";
                        }
                        else if (X==5){
                            System.out.println("A Thief!");
                            MonsterName="The Thief";
                        }
                        else if (X==6){
                            System.out.println("A Bat Swarm!");
                            MonsterName="The Bats";
                        }
                        else if (X==7){
                            System.out.println("A Wlidcat");
                            MonsterName="The Wildcat";
                        }
                        else if (X==8){
                            System.out.println("A Undead Adventure!");
                            MonsterName="The Skeleton";
                        }
                        else if (X==9){
                            System.out.println("A Strangling Vine!");
                            MonsterName="The Plant";
                        }
                        else{
                            System.out.println("'MISSINGNO.'!");
                            MonsterName="The *&%$$#_*^%&^";
                        }
                        System.out.println("You ready for combat!");
                    }
                    else if (EnemyType==2){//Elite
                        System.out.print("You are suddenly ambushed by ");
                        int X = RandomInt(1, 7);
                        if (X==1){
                            System.out.println("A Killer Bunny!");
                            MonsterName="The Killer Bunny";
                        }
                        else if (X==2){
                            System.out.println("A Dark Mage!");
                            MonsterName="The Dark Mage";
                        }
                        else if (X==3){
                            System.out.println("A Troll!");
                            MonsterName="The Cave Troll";
                        }
                        else if (X==4){
                            System.out.println("A Whelpling!");
                            MonsterName="The Dragonnet";
                        }
                        else if (X==5){
                            System.out.println("A Chest Mimic!");
                            MonsterName="The Mimic";
                        }
                        else if (X==6){
                            System.out.println("A Fallen Knight!");
                            MonsterName="The Knight";
                        }
                        else{
                            System.out.println("A Giant Centipede!");
                            MonsterName="The Centipede";
                        } 
                        System.out.println("You recover in time to fight back!");
                    }       
                    else if (EnemyType==3){//Mini-boss
                        System.out.print("Your path is blocked by ");
                        int X = RandomInt(1, 5);
                        if (X==1){
                            System.out.println("Giant Enemy Crab!");
                            MonsterName="The 'Giant Enemy Crab!'";
                        }
                        else if (X==2){
                            System.out.println("A Living Wall!");
                            MonsterName="The Wall";
                        }
                        else if (X==3){
                            System.out.println("A Giant Mole!");
                            MonsterName="The Giant Mole";
                        }
                        else if (X==4){
                            System.out.println("A Large Serpent!");
                            MonsterName="The Snake";
                        }
                        else{
                            System.out.println("A Swarm of Spiders!");
                            MonsterName="The Spiders";
                        }
                        System.out.println("They won't go down without a fight! Neither will you!");
                    }
                    else if (EnemyType==4){//Boss
                        System.out.print("You come face to face with ");
                        int X = RandomInt(1, 3);
                        if (X==1){
                            System.out.println("A Young But Fierce Drake!");
                            MonsterName="The Young Dragon";
                        }
                        else if (X==2){
                            System.out.println("A Rock Golem!");
                            MonsterName="The Golem";
                        }
                        else{
                            System.out.println("A Necromancer.");
                            MonsterName="The Necromancer";
                        }
                        System.out.println("A fierce battle ensues!");
                    }
                    else if (EnemyType==5){//Final Boss
                        MonsterName="The Dragon";
                        System.out.println();
                        if (Player.FloorsCleared<21){//This is the first time fighting the Dragon this run.
                            System.out.println("The final challange stands before you");
                            System.out.println("The Dragon has been the cause of countless tragedies, the downfall of empires, and the end of heroes.");
                            System.out.println("You face the draconic scourge, the fearsome terror of the Seven Realms.");
                            System.out.println("The Feind of the Sky, Humanity's Green Scaled Plague.");
                            System.out.println("The Feared, the Destroyer, the Devourer, the End of All Things.");
                            System.out.println("This is it. Everything has lead to this final and ultimate battle.");
                            System.out.println("Against The Dragon.");
                            System.out.println("Blight_Blaze.");
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }
                        else if (Player.FloorsCleared<41){//First re-fight
                            System.out.println("Impossible... You killed the Dragon... But they stand before you once again.");
                            System.out.println("Blight_Blaze, the bane of your existence.");
                            System.out.println("He looks as menacing as ever, but you are stronger now.");
                            System.out.println("Unfortunately, you realize he has gotten stronger as well.");
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }
                        else if (Player.FloorsCleared<61){//Second re-fight
                            System.out.println("Depite all odds, both of you are still alive.");
                            System.out.println("Blight_Blaze gives you a look of pity. He sees the trap you are in. The infinite looping.");
                            System.out.println("He understands.");
                            System.out.println("After all... Isn't he trapped too?");
                            System.out.println();
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }
                        else {//Future re-fights
                            System.out.println("You face the Dragon once more.");
                            System.out.println("...");
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }

                    }
//fights are based on a system where both parties have three actions they can take that function like rock paper scissors.The player chooses an action and the enemy's action is randomly generated. The fight continues until either the player or the enemy's health drops to 0 or below.       
                    for (int z=0; z==0;){
                        System.out.println();
                        System.out.println("Enemy Health: " + EnemyHealth);
                        System.out.println("Your Health: " + Player.Health + "/" + Player.MaxHealth);
                        System.out.println("Choose your action: Light Attack, Heavy Attack, Block");
                        System.out.println();
                        String Combat = Input.nextLine();
                        int PlayerAction = 0;
                        if (Combat.equals("Light Attack") || Combat.equals("light attack") || Combat.equals("L") || Combat.equals("l") || Combat.equals("Light") || Combat.equals("light")){
                            PlayerAction = 1;
                        }
                        else if (Combat.equals("Heavy Attack") || Combat.equals("heavy attack") || Combat.equals("H") || Combat.equals("h") || Combat.equals("Heavy") || Combat.equals("heavy")){
                            PlayerAction = 2;
                        }
                        else if (Combat.equals("Block") || Combat.equals("block") || Combat.equals("B") || Combat.equals("b")){
                            PlayerAction = 3;
                        }
                        else{
                            System.out.println("Invalid action. Please choose Light Attack, Heavy Attack, or Block.");
                            continue;
                        }
                        System.out.println();
//Enemy turn
                        int EnemyAction=0;
                        if (EnemyType==1){//Monster
                            int Y=RandomInt(1,5);
                            if (Y<3){//light
                                EnemyAction=1;
                            }
                            else if (Y==3){//heavy
                                EnemyAction=2;
                            }
                                else{//block
                                EnemyAction=3;
                            }
                        }
                        else if (EnemyType==2){//Elite
                            int Y=RandomInt(1,4);
                            if (Y==1){//light
                                EnemyAction=1;
                            }
                            else if (Y<4){//heavy
                                EnemyAction=2;
                            }
                            else{//block
                                EnemyAction=3;
                            }
                        }
                        else if (EnemyType==3){//Mini
                            int Y=RandomInt(1,5);
                            if (Y<3){//light
                                EnemyAction=1;
                            }
                            else if (Y==3){//heavy
                                EnemyAction=2;
                            }
                            else if (Y==4){//block
                                EnemyAction=3;
                            }
                            else{//Special
                                EnemyAction=4;
                            }
                        }
                        else if (EnemyType==4){//Boss
                            int Y=RandomInt(1,6);
                            if (Y==1){//light
                                EnemyAction=1;
                            }
                            else if (Y==2){//heavy
                                EnemyAction=2;
                            }
                            else if (Y==3){//block
                                EnemyAction=3;
                            }
                            else if (Y<6){//Special
                                EnemyAction=4;
                            }
                            else{//Other Special
                                EnemyAction=5;
                            }
                        }
                        else {//Dragon
                            int Y = RandomInt(1, 18);
                            if (Y<4){//Light
                                EnemyAction=1;
                            }
                            else if (Y<8){//Heavy
                                EnemyAction=2;
                            }
                            else if (Y<11){//Block
                                EnemyAction=3;
                            }
                            else if (Y<13){//Special
                                EnemyAction=4;
                            }
                            else if (Y<15){//Other Special
                                EnemyAction=5;
                            }
                            else{//Dragon Special
                                EnemyAction=6;
                            }
                        }
//Resolve Round of Combat.
                        if (PlayerAction==1){//Light
                            if (EnemyAction==1){//Light
                                PlayerDamage = Player.Strength + Player.LightDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("You Slash At " + MonsterName + "! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;
                                EnemyDamage= EnemyStrength - ((int)Math.floor(Player.Defense/2));
                                System.out.println("They Strike Back For " + EnemyDamage + " Points of Damage!");
                                Player.Health-=EnemyDamage;
                            }
                            else if (EnemyAction==2){//Heavy
                                PlayerDamage = Player.Strength + Player.LightDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("You Slash At " + MonsterName + "! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;
                                System.out.println("They Were Staggered and Can't Attack!");
                            }
                            else if (EnemyAction==3){//Block
                                System.out.println("You Attack! However " + MonsterName + " Parried Your Attack!");
                                System.out.println("They Reposte For " + EnemyStrength + " Points of Damage!");
                                Player.Health-=EnemyStrength;
                            }
                            else{//Special
                                PlayerDamage = Player.Strength + Player.LightDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("You Slash At " + MonsterName + "! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;

                            if (EnemyAction==4){//Heal
                                    System.out.println(MonsterName + " Regenerates " + Dungeon.Difficulty + " Health!");
                                    EnemyHealth+=Dungeon.Difficulty;
                                }
                                else if (EnemyAction==5){//Buff
                                    System.out.println(MonsterName + " Grows Stronger!");
                                    EnemyStrength+=((int)Math.floor(Dungeon.Difficulty/2));
                                    EnemyDefense+=((int)Math.floor(Dungeon.Difficulty/3));
                                }
                                else{//Fire-Ball
                                    System.out.println("The Dragon Spits A Fireball At You!");
                                    System.out.println("You Take " + Dungeon.Difficulty + " Points of Burning Damage.");
                                    Player.Health-=Dungeon.Difficulty;
                                }
                            }
                        }
                        else if (PlayerAction==2){//Heavy
                            if (EnemyAction==1){//Light
                                EnemyDamage= EnemyStrength - ((int)Math.floor(Player.Defense/2));
                                System.out.println(MonsterName + " Strikes You For " + EnemyDamage + " Points of Damage!");
                                Player.Health-=EnemyDamage;
                                System.out.println("You Were Staggered and Can't Attack!");
                            }
                            else if (EnemyAction==2){//Heavy
                                PlayerDamage= ((int)Math.floor(Player.Strength*1.5)) + Player.HeavyDamageModifier - ((int)Math.floor(EnemyDefense/3));
                                System.out.println("You Strike " + MonsterName + " With a Heavy Blow! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;
                                EnemyDamage= ((int)Math.floor(EnemyStrength*1.5)) - ((int)Math.floor(Player.Defense/3));
                                System.out.println("They Respond With an Attack of Their Own For " + EnemyDamage + " Points of Damage");
                                Player.Health-=EnemyDamage;
                            }       
                            else if (EnemyAction==3){//Block
                                PlayerDamage= ((int)Math.floor(Player.Strength*1.5)) + Player.HeavyDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("Your Heavy Strike Pierces " + MonsterName + "'s Defense!");
                                System.out.println("You Deal " + PlayerDamage + " Points of Dammage!");
                                EnemyHealth-=PlayerDamage;
                            }
                            else{//Special
                                PlayerDamage= ((int)Math.floor(Player.Strength*1.5)) + Player.HeavyDamageModifier - ((int)Math.floor(EnemyDefense/3));
                                System.out.println("You Strike " + MonsterName + " With a Heavy Blow! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;

                                if (EnemyAction==4){//Heal
                                    System.out.println(MonsterName + " Regenerates " + Dungeon.Difficulty + " Health!");
                                    EnemyHealth+=Dungeon.Difficulty;
                                }
                                else if (EnemyAction==5){//Buff
                                    System.out.println(MonsterName + " Grows Stronger!");
                                    EnemyStrength+=((int)Math.floor(Dungeon.Difficulty/2));
                                    EnemyDefense+=((int)Math.floor(Dungeon.Difficulty/3));
                                }
                                else{//Fire-Ball
                                    System.out.println("The Dragon Spits A Fireball At You!");
                                    System.out.println("You Take " + Dungeon.Difficulty + " Points of Burning Damage.");
                                    Player.Health-=Dungeon.Difficulty;
                                }
                            }
                        }
                        else{//Block
                            if (EnemyAction==1){//Light
                                System.out.println("You Parry " + MonsterName + "'s Attack!");
                                System.out.println("You Reposte For " + Player.Strength + " Points of Damage!");
                                EnemyHealth-=Player.Strength;
                            }
                            else if (EnemyAction==2){//Heavy
                                EnemyDamage = ((int)Math.floor(EnemyStrength*1.5)) - ((int)Math.floor(Player.Defense/2));
                                System.out.println("You Block But Are Unable to Parry " + MonsterName  + "'s Heavy Blow!");
                                System.out.println("You Are Hit For " + EnemyDamage + " Points of Damage!");
                                Player.Health-=EnemyDamage;
                            }
                            else if (EnemyAction==3){//Block
                                System.out.println("You Block at the Same Time as " + MonsterName + "!");
                                System.out.println("You Both Look Stupid!");
                            }
                            else{//Special
                                System.out.println("You Block But " + MonsterName + " Used An Ability!");

                                if (EnemyAction==4){//Heal
                                    System.out.println(MonsterName + " Regenerates " + Dungeon.Difficulty + " Health!");
                                    EnemyHealth+=Dungeon.Difficulty;
                                }
                                else if (EnemyAction==5){//Buff
                                    System.out.println(MonsterName + " Grows Stronger!");
                                    EnemyStrength+=((int)Math.floor(Dungeon.Difficulty/2));
                                    EnemyDefense+=((int)Math.floor(Dungeon.Difficulty/3));
                                }
                                else{//Fire-Ball
                                    System.out.println("The Dragon Spits A Fireball At You!");
                                    System.out.println("You Take " + Dungeon.Difficulty + " Points of Burning Damage.");
                                    Player.Health-=Dungeon.Difficulty;
                                }
                            }
                        }
                        System.out.println();
//Check For Death
                        if (Player.Health<=0){//Player Death overrides monster death.
                            System.out.println("After a particularly nasty blow, you fall unconscious!");
                            z=1;
                        }
                        else if (EnemyHealth<=0){//Enemy Death
                            if (EnemyType<3){
                                Player.Kills++;
                                System.out.println("You deal a final blow and finish off your opponent!");
                            }
                            int XP=(int) Math.pow(10, EnemyType);
                            Player.Gold+=((EnemyType+1)*(Dungeon.Difficulty+1));
                            System.out.println("You Gained " + ((EnemyType+1)*(Dungeon.Difficulty+1)) + " Gold!");
                            Player.GainEXP((int)Math.ceil(XP)*(Dungeon.Difficulty));//You get more XP on deeper floors, but less as you level up.
                            z=1;
                        }
                    }
                }
                else if (Room==3){
                    System.out.println("You find a Rest Spot and heal to full health.");
                    if (!(Player.Health==Player.MaxHealth)){//Only Heal if Hurt
                        Player.Health = Player.MaxHealth;
                        Dungeon.ClearRoom();
                    }
                }
                else if (Room==4){
                    System.out.println("You find a shop. You can buy upgrades here.");
                    Dungeon.ClearRoom();
                    for (int q=0; q<Dungeon.Difficulty; q++){//You may purchase items up to the Diffculty of the floor.
                        System.out.println("You have " + Player.Gold + " Gold. You may purchase up to " + (Dungeon.Difficulty-q) + " more items.");
                        System.out.println("0: Leave Shop");
                        System.out.println("1: Increase Strength by 1 for " + (7*Dungeon.Difficulty) + " Gold.");
                        System.out.println("2: Increase Light Damage Modifier by 1 for " + (2*Dungeon.Difficulty) + " Gold.");
                        System.out.println("3: Increase Heavy Damage Modifier by 1 for " + (3*Dungeon.Difficulty) + " Gold.");
                        System.out.println("4: Increase Defense by 1 for " + (5*Dungeon.Difficulty) + " Gold.");
                        System.out.println("5: Increase Max Health by 5 for " + (10*Dungeon.Difficulty) + " Gold.");
                        System.out.println("6: Buy 1 key for " + (15*Dungeon.Difficulty) + " Gold.");
                        System.out.println("Stats: Prints your stats.");
                        String choice = Input.nextLine();
                        if (choice.equals("0")){
                            break;
                        }
                        else if (choice.equals("1") && Player.Gold >= (7*Dungeon.Difficulty)){
                            Player.Strength++;
                            Player.Gold -= (7*Dungeon.Difficulty);
                            System.out.println("Strength increased to " + Player.Strength + "!");
                        }
                        else if (choice.equals("2") && Player.Gold >= (2*Dungeon.Difficulty)){
                            Player.LightDamageModifier++;
                            Player.Gold -= (2*Dungeon.Difficulty);
                            System.out.println("Light Damage Modifier increased to " + Player.LightDamageModifier + "!");
                        }
                        else if (choice.equals("3") && Player.Gold >= (3*Dungeon.Difficulty)){
                            Player.HeavyDamageModifier++;
                            Player.Gold -= (3*Dungeon.Difficulty);
                            System.out.println("Heavy Damage Modifier increased to " + Player.HeavyDamageModifier + "!");
                        }
                        else if (choice.equals("4") && Player.Gold >= (5*Dungeon.Difficulty)){
                            Player.Defense++;
                            Player.Gold -= (5*Dungeon.Difficulty);
                            System.out.println("Defense increased to " + Player.Defense + "!");
                        }
                        else if (choice.equals("5") && Player.Gold >= (10*Dungeon.Difficulty)){
                            Player.MaxHealth += 5;
                            Player.Health += 5;
                            Player.Gold -= (10*Dungeon.Difficulty);
                            System.out.println("Max Health increased to " + Player.MaxHealth + "! Health increased to " + Player.Health + "!");
                        }
                        else if (choice.equals("6") && Player.Gold >= (15*Dungeon.Difficulty)){
                            Player.Keys++;
                            Player.Gold -= (15*Dungeon.Difficulty);
                            System.out.println("You bought a key! You now have " + Player.Keys + " keys.");
                        }
                        else if (Action.equals("Stats") || Action.equals("stats")){//Prints the player's stats.
                            Player.Stats();
                        }
                        else{
                            System.out.println("Invalid choice or not enough gold.");
                            q--;
                        }
                        System.out.println();
                    }
                    System.out.println("The Shopkepper packs up and leaves.");
                }
                else if (Room==5){
                    System.out.println("You find a treasure chest!");
                    Player.Treasure(Dungeon.Difficulty);
                    Dungeon.ClearRoom();
                }
            }
            else if (Action.equals("W") || Action.equals("w") || Action.equals("West") || Action.equals("west")){
                int Room = Dungeon.MoveW();
                if (Room==-2){
                    System.out.println("You are blocked by a wall.");
                }
                else if (Room==-1){
                    System.out.println("You find the entrance room.");
                }
                else if (Room==0){
                    System.out.println("You enter an empty room.");
                }
                else if (Room==1){
                    System.out.println("You are attacked by a monster!");
                    Dungeon.ClearRoom();
                    int EnemyStrength=Dungeon.Difficulty+2;
                    int EnemyHealth=(Dungeon.Difficulty+1)*5;
                    int EnemyDefense=RandomInt(Dungeon.Difficulty, Dungeon.Difficulty+5);
                    int EnemyType=1;

                    System.out.println();
                    int PlayerDamage;
                    int EnemyDamage;
                    String MonsterName="";//Allows me to refer to the monster later.
                    if (EnemyType==1){//Monster
                        System.out.print("You encounter ");
                        int X = RandomInt(1, 10);
                        if (X==1){
                            System.out.println("A Slime!");
                            MonsterName="The Slime";
                        }
                        else if (X==2){
                            System.out.println("A Ghost");
                            MonsterName="The Ghost";
                        }
                        else if (X==3){
                            System.out.println("A Putrid Rat!");
                            MonsterName="The Rat";
                        }
                        else if (X==4){
                            System.out.println("A Goblin!");
                            MonsterName="The Goblin";
                        }
                        else if (X==5){
                            System.out.println("A Thief!");
                            MonsterName="The Thief";
                        }
                        else if (X==6){
                            System.out.println("A Bat Swarm!");
                            MonsterName="The Bats";
                        }
                        else if (X==7){
                            System.out.println("A Wlidcat");
                            MonsterName="The Wildcat";
                        }
                        else if (X==8){
                            System.out.println("A Undead Adventure!");
                            MonsterName="The Skeleton";
                        }
                        else if (X==9){
                            System.out.println("A Strangling Vine!");
                            MonsterName="The Plant";
                        }
                        else{
                            System.out.println("'MISSINGNO.'!");
                            MonsterName="The *&%$$#_*^%&^";
                        }
                        System.out.println("You ready for combat!");
                    }
                    else if (EnemyType==2){//Elite
                        System.out.print("You are suddenly ambushed by ");
                        int X = RandomInt(1, 7);
                        if (X==1){
                            System.out.println("A Killer Bunny!");
                            MonsterName="The Killer Bunny";
                        }
                        else if (X==2){
                            System.out.println("A Dark Mage!");
                            MonsterName="The Dark Mage";
                        }
                        else if (X==3){
                            System.out.println("A Troll!");
                            MonsterName="The Cave Troll";
                        }
                        else if (X==4){
                            System.out.println("A Whelpling!");
                            MonsterName="The Dragonnet";
                        }
                        else if (X==5){
                            System.out.println("A Chest Mimic!");
                            MonsterName="The Mimic";
                        }
                        else if (X==6){
                            System.out.println("A Fallen Knight!");
                            MonsterName="The Knight";
                        }
                        else{
                            System.out.println("A Giant Centipede!");
                            MonsterName="The Centipede";
                        } 
                        System.out.println("You recover in time to fight back!");
                    }       
                    else if (EnemyType==3){//Mini-boss
                        System.out.print("Your path is blocked by ");
                        int X = RandomInt(1, 5);
                        if (X==1){
                            System.out.println("Giant Enemy Crab!");
                            MonsterName="The 'Giant Enemy Crab!'";
                        }
                        else if (X==2){
                            System.out.println("A Living Wall!");
                            MonsterName="The Wall";
                        }
                        else if (X==3){
                            System.out.println("A Giant Mole!");
                            MonsterName="The Giant Mole";
                        }
                        else if (X==4){
                            System.out.println("A Large Serpent!");
                            MonsterName="The Snake";
                        }
                        else{
                            System.out.println("A Swarm of Spiders!");
                            MonsterName="The Spiders";
                        }
                        System.out.println("They won't go down without a fight! Neither will you!");
                    }
                    else if (EnemyType==4){//Boss
                        System.out.print("You come face to face with ");
                        int X = RandomInt(1, 3);
                        if (X==1){
                            System.out.println("A Young But Fierce Drake!");
                            MonsterName="The Young Dragon";
                        }
                        else if (X==2){
                            System.out.println("A Rock Golem!");
                            MonsterName="The Golem";
                        }
                        else{
                            System.out.println("A Necromancer.");
                            MonsterName="The Necromancer";
                        }
                        System.out.println("A fierce battle ensues!");
                    }
                    else if (EnemyType==5){//Final Boss
                        MonsterName="The Dragon";
                        System.out.println();
                        if (Player.FloorsCleared<21){//This is the first time fighting the Dragon this run.
                            System.out.println("The final challange stands before you");
                            System.out.println("The Dragon has been the cause of countless tragedies, the downfall of empires, and the end of heroes.");
                            System.out.println("You face the draconic scourge, the fearsome terror of the Seven Realms.");
                            System.out.println("The Feind of the Sky, Humanity's Green Scaled Plague.");
                            System.out.println("The Feared, the Destroyer, the Devourer, the End of All Things.");
                            System.out.println("This is it. Everything has lead to this final and ultimate battle.");
                            System.out.println("Against The Dragon.");
                            System.out.println("Blight_Blaze.");
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }
                        else if (Player.FloorsCleared<41){//First re-fight
                            System.out.println("Impossible... You killed the Dragon... But they stand before you once again.");
                            System.out.println("Blight_Blaze, the bane of your existence.");
                            System.out.println("He looks as menacing as ever, but you are stronger now.");
                            System.out.println("Unfortunately, you realize he has gotten stronger as well.");
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }
                        else if (Player.FloorsCleared<61){//Second re-fight
                            System.out.println("Depite all odds, both of you are still alive.");
                            System.out.println("Blight_Blaze gives you a look of pity. He sees the trap you are in. The infinite looping.");
                            System.out.println("He understands.");
                            System.out.println("After all... Isn't he trapped too?");
                            System.out.println();
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }
                        else {//Future re-fights
                            System.out.println("You face the Dragon once more.");
                            System.out.println("...");
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }

                    }
//fights are based on a system where both parties have three actions they can take that function like rock paper scissors.The player chooses an action and the enemy's action is randomly generated. The fight continues until either the player or the enemy's health drops to 0 or below.       
                    for (int z=0; z==0;){
                        System.out.println();
                        System.out.println("Enemy Health: " + EnemyHealth);
                        System.out.println("Your Health: " + Player.Health + "/" + Player.MaxHealth);
                        System.out.println("Choose your action: Light Attack, Heavy Attack, Block");
                        System.out.println();
                        String Combat = Input.nextLine();
                        int PlayerAction = 0;
                        if (Combat.equals("Light Attack") || Combat.equals("light attack") || Combat.equals("L") || Combat.equals("l") || Combat.equals("Light") || Combat.equals("light")){
                            PlayerAction = 1;
                        }
                        else if (Combat.equals("Heavy Attack") || Combat.equals("heavy attack") || Combat.equals("H") || Combat.equals("h") || Combat.equals("Heavy") || Combat.equals("heavy")){
                            PlayerAction = 2;
                        }
                        else if (Combat.equals("Block") || Combat.equals("block") || Combat.equals("B") || Combat.equals("b")){
                            PlayerAction = 3;
                        }
                        else{
                            System.out.println("Invalid action. Please choose Light Attack, Heavy Attack, or Block.");
                            continue;
                        }
                        System.out.println();
//Enemy turn
                        int EnemyAction=0;
                        if (EnemyType==1){//Monster
                            int Y=RandomInt(1,5);
                            if (Y<3){//light
                                EnemyAction=1;
                            }
                            else if (Y==3){//heavy
                                EnemyAction=2;
                            }
                                else{//block
                                EnemyAction=3;
                            }
                        }
                        else if (EnemyType==2){//Elite
                            int Y=RandomInt(1,4);
                            if (Y==1){//light
                                EnemyAction=1;
                            }
                            else if (Y<4){//heavy
                                EnemyAction=2;
                            }
                            else{//block
                                EnemyAction=3;
                            }
                        }
                        else if (EnemyType==3){//Mini
                            int Y=RandomInt(1,5);
                            if (Y<3){//light
                                EnemyAction=1;
                            }
                            else if (Y==3){//heavy
                                EnemyAction=2;
                            }
                            else if (Y==4){//block
                                EnemyAction=3;
                            }
                            else{//Special
                                EnemyAction=4;
                            }
                        }
                        else if (EnemyType==4){//Boss
                            int Y=RandomInt(1,6);
                            if (Y==1){//light
                                EnemyAction=1;
                            }
                            else if (Y==2){//heavy
                                EnemyAction=2;
                            }
                            else if (Y==3){//block
                                EnemyAction=3;
                            }
                            else if (Y<6){//Special
                                EnemyAction=4;
                            }
                            else{//Other Special
                                EnemyAction=5;
                            }
                        }
                        else {//Dragon
                            int Y = RandomInt(1, 18);
                            if (Y<4){//Light
                                EnemyAction=1;
                            }
                            else if (Y<8){//Heavy
                                EnemyAction=2;
                            }
                            else if (Y<11){//Block
                                EnemyAction=3;
                            }
                            else if (Y<13){//Special
                                EnemyAction=4;
                            }
                            else if (Y<15){//Other Special
                                EnemyAction=5;
                            }
                            else{//Dragon Special
                                EnemyAction=6;
                            }
                        }
//Resolve Round of Combat.
                        if (PlayerAction==1){//Light
                            if (EnemyAction==1){//Light
                                PlayerDamage = Player.Strength + Player.LightDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("You Slash At " + MonsterName + "! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;
                                EnemyDamage= EnemyStrength - ((int)Math.floor(Player.Defense/2));
                                System.out.println("They Strike Back For " + EnemyDamage + " Points of Damage!");
                                Player.Health-=EnemyDamage;
                            }
                            else if (EnemyAction==2){//Heavy
                                PlayerDamage = Player.Strength + Player.LightDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("You Slash At " + MonsterName + "! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;
                                System.out.println("They Were Staggered and Can't Attack!");
                            }
                            else if (EnemyAction==3){//Block
                                System.out.println("You Attack! However " + MonsterName + " Parried Your Attack!");
                                System.out.println("They Reposte For " + EnemyStrength + " Points of Damage!");
                                Player.Health-=EnemyStrength;
                            }
                            else{//Special
                                PlayerDamage = Player.Strength + Player.LightDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("You Slash At " + MonsterName + "! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;

                            if (EnemyAction==4){//Heal
                                    System.out.println(MonsterName + " Regenerates " + Dungeon.Difficulty + " Health!");
                                    EnemyHealth+=Dungeon.Difficulty;
                                }
                                else if (EnemyAction==5){//Buff
                                    System.out.println(MonsterName + " Grows Stronger!");
                                    EnemyStrength+=((int)Math.floor(Dungeon.Difficulty/2));
                                    EnemyDefense+=((int)Math.floor(Dungeon.Difficulty/3));
                                }
                                else{//Fire-Ball
                                    System.out.println("The Dragon Spits A Fireball At You!");
                                    System.out.println("You Take " + Dungeon.Difficulty + " Points of Burning Damage.");
                                    Player.Health-=Dungeon.Difficulty;
                                }
                            }
                        }
                        else if (PlayerAction==2){//Heavy
                            if (EnemyAction==1){//Light
                                EnemyDamage= EnemyStrength - ((int)Math.floor(Player.Defense/2));
                                System.out.println(MonsterName + " Strikes You For " + EnemyDamage + " Points of Damage!");
                                Player.Health-=EnemyDamage;
                                System.out.println("You Were Staggered and Can't Attack!");
                            }
                            else if (EnemyAction==2){//Heavy
                                PlayerDamage= ((int)Math.floor(Player.Strength*1.5)) + Player.HeavyDamageModifier - ((int)Math.floor(EnemyDefense/3));
                                System.out.println("You Strike " + MonsterName + " With a Heavy Blow! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;
                                EnemyDamage= ((int)Math.floor(EnemyStrength*1.5)) - ((int)Math.floor(Player.Defense/3));
                                System.out.println("They Respond With an Attack of Their Own For " + EnemyDamage + " Points of Damage");
                                Player.Health-=EnemyDamage;
                            }       
                            else if (EnemyAction==3){//Block
                                PlayerDamage= ((int)Math.floor(Player.Strength*1.5)) + Player.HeavyDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("Your Heavy Strike Pierces " + MonsterName + "'s Defense!");
                                System.out.println("You Deal " + PlayerDamage + " Points of Dammage!");
                                EnemyHealth-=PlayerDamage;
                            }
                            else{//Special
                                PlayerDamage= ((int)Math.floor(Player.Strength*1.5)) + Player.HeavyDamageModifier - ((int)Math.floor(EnemyDefense/3));
                                System.out.println("You Strike " + MonsterName + " With a Heavy Blow! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;

                                if (EnemyAction==4){//Heal
                                    System.out.println(MonsterName + " Regenerates " + Dungeon.Difficulty + " Health!");
                                    EnemyHealth+=Dungeon.Difficulty;
                                }
                                else if (EnemyAction==5){//Buff
                                    System.out.println(MonsterName + " Grows Stronger!");
                                    EnemyStrength+=((int)Math.floor(Dungeon.Difficulty/2));
                                    EnemyDefense+=((int)Math.floor(Dungeon.Difficulty/3));
                                }
                                else{//Fire-Ball
                                    System.out.println("The Dragon Spits A Fireball At You!");
                                    System.out.println("You Take " + Dungeon.Difficulty + " Points of Burning Damage.");
                                    Player.Health-=Dungeon.Difficulty;
                                }
                            }
                        }
                        else{//Block
                            if (EnemyAction==1){//Light
                                System.out.println("You Parry " + MonsterName + "'s Attack!");
                                System.out.println("You Reposte For " + Player.Strength + " Points of Damage!");
                                EnemyHealth-=Player.Strength;
                            }
                            else if (EnemyAction==2){//Heavy
                                EnemyDamage = ((int)Math.floor(EnemyStrength*1.5)) - ((int)Math.floor(Player.Defense/2));
                                System.out.println("You Block But Are Unable to Parry " + MonsterName  + "'s Heavy Blow!");
                                System.out.println("You Are Hit For " + EnemyDamage + " Points of Damage!");
                                Player.Health-=EnemyDamage;
                            }
                            else if (EnemyAction==3){//Block
                                System.out.println("You Block at the Same Time as " + MonsterName + "!");
                                System.out.println("You Both Look Stupid!");
                            }
                            else{//Special
                                System.out.println("You Block But " + MonsterName + " Used An Ability!");

                                if (EnemyAction==4){//Heal
                                    System.out.println(MonsterName + " Regenerates " + Dungeon.Difficulty + " Health!");
                                    EnemyHealth+=Dungeon.Difficulty;
                                }
                                else if (EnemyAction==5){//Buff
                                    System.out.println(MonsterName + " Grows Stronger!");
                                    EnemyStrength+=((int)Math.floor(Dungeon.Difficulty/2));
                                    EnemyDefense+=((int)Math.floor(Dungeon.Difficulty/3));
                                }
                                else{//Fire-Ball
                                    System.out.println("The Dragon Spits A Fireball At You!");
                                    System.out.println("You Take " + Dungeon.Difficulty + " Points of Burning Damage.");
                                    Player.Health-=Dungeon.Difficulty;
                                }
                            }
                        }
                        System.out.println();
//Check For Death
                        if (Player.Health<=0){//Player Death overrides monster death.
                            System.out.println("After a particularly nasty blow, you fall unconscious!");
                            z=1;
                        }
                        else if (EnemyHealth<=0){//Enemy Death
                            if (EnemyType<3){
                                Player.Kills++;
                                System.out.println("You deal a final blow and finish off your opponent!");
                            }
                            int XP=(int) Math.pow(10, EnemyType);
                            Player.Gold+=((EnemyType+1)*(Dungeon.Difficulty+1));
                            System.out.println("You Gained " + ((EnemyType+1)*(Dungeon.Difficulty+1)) + " Gold!");
                            Player.GainEXP((int)Math.ceil(XP)*(Dungeon.Difficulty));//You get more XP on deeper floors, but less as you level up.
                            z=1;
                        }
                    }
                }
                else if (Room==2){
                    System.out.println("You are attacked by an elite monster!");
                    Dungeon.ClearRoom();
                    int EnemyStrength=Dungeon.Difficulty+5;
                    int EnemyHealth=(Dungeon.Difficulty+1)*10;
                    int EnemyDefense=RandomInt(Dungeon.Difficulty+5, Dungeon.Difficulty+10);
                    int EnemyType=2;

                    System.out.println();
                    int PlayerDamage;
                    int EnemyDamage;
                    String MonsterName="";//Allows me to refer to the monster later.
                    if (EnemyType==1){//Monster
                        System.out.print("You encounter ");
                        int X = RandomInt(1, 10);
                        if (X==1){
                            System.out.println("A Slime!");
                            MonsterName="The Slime";
                        }
                        else if (X==2){
                            System.out.println("A Ghost");
                            MonsterName="The Ghost";
                        }
                        else if (X==3){
                            System.out.println("A Putrid Rat!");
                            MonsterName="The Rat";
                        }
                        else if (X==4){
                            System.out.println("A Goblin!");
                            MonsterName="The Goblin";
                        }
                        else if (X==5){
                            System.out.println("A Thief!");
                            MonsterName="The Thief";
                        }
                        else if (X==6){
                            System.out.println("A Bat Swarm!");
                            MonsterName="The Bats";
                        }
                        else if (X==7){
                            System.out.println("A Wlidcat");
                            MonsterName="The Wildcat";
                        }
                        else if (X==8){
                            System.out.println("A Undead Adventure!");
                            MonsterName="The Skeleton";
                        }
                        else if (X==9){
                            System.out.println("A Strangling Vine!");
                            MonsterName="The Plant";
                        }
                        else{
                            System.out.println("'MISSINGNO.'!");
                            MonsterName="The *&%$$#_*^%&^";
                        }
                        System.out.println("You ready for combat!");
                    }
                    else if (EnemyType==2){//Elite
                        System.out.print("You are suddenly ambushed by ");
                        int X = RandomInt(1, 7);
                        if (X==1){
                            System.out.println("A Killer Bunny!");
                            MonsterName="The Killer Bunny";
                        }
                        else if (X==2){
                            System.out.println("A Dark Mage!");
                            MonsterName="The Dark Mage";
                        }
                        else if (X==3){
                            System.out.println("A Troll!");
                            MonsterName="The Cave Troll";
                        }
                        else if (X==4){
                            System.out.println("A Whelpling!");
                            MonsterName="The Dragonnet";
                        }
                        else if (X==5){
                            System.out.println("A Chest Mimic!");
                            MonsterName="The Mimic";
                        }
                        else if (X==6){
                            System.out.println("A Fallen Knight!");
                            MonsterName="The Knight";
                        }
                        else{
                            System.out.println("A Giant Centipede!");
                            MonsterName="The Centipede";
                        } 
                        System.out.println("You recover in time to fight back!");
                    }       
                    else if (EnemyType==3){//Mini-boss
                        System.out.print("Your path is blocked by ");
                        int X = RandomInt(1, 5);
                        if (X==1){
                            System.out.println("Giant Enemy Crab!");
                            MonsterName="The 'Giant Enemy Crab!'";
                        }
                        else if (X==2){
                            System.out.println("A Living Wall!");
                            MonsterName="The Wall";
                        }
                        else if (X==3){
                            System.out.println("A Giant Mole!");
                            MonsterName="The Giant Mole";
                        }
                        else if (X==4){
                            System.out.println("A Large Serpent!");
                            MonsterName="The Snake";
                        }
                        else{
                            System.out.println("A Swarm of Spiders!");
                            MonsterName="The Spiders";
                        }
                        System.out.println("They won't go down without a fight! Neither will you!");
                    }
                    else if (EnemyType==4){//Boss
                        System.out.print("You come face to face with ");
                        int X = RandomInt(1, 3);
                        if (X==1){
                            System.out.println("A Young But Fierce Drake!");
                            MonsterName="The Young Dragon";
                        }
                        else if (X==2){
                            System.out.println("A Rock Golem!");
                            MonsterName="The Golem";
                        }
                        else{
                            System.out.println("A Necromancer.");
                            MonsterName="The Necromancer";
                        }
                        System.out.println("A fierce battle ensues!");
                    }
                    else if (EnemyType==5){//Final Boss
                        MonsterName="The Dragon";
                        System.out.println();
                        if (Player.FloorsCleared<21){//This is the first time fighting the Dragon this run.
                            System.out.println("The final challange stands before you");
                            System.out.println("The Dragon has been the cause of countless tragedies, the downfall of empires, and the end of heroes.");
                            System.out.println("You face the draconic scourge, the fearsome terror of the Seven Realms.");
                            System.out.println("The Feind of the Sky, Humanity's Green Scaled Plague.");
                            System.out.println("The Feared, the Destroyer, the Devourer, the End of All Things.");
                            System.out.println("This is it. Everything has lead to this final and ultimate battle.");
                            System.out.println("Against The Dragon.");
                            System.out.println("Blight_Blaze.");
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }
                        else if (Player.FloorsCleared<41){//First re-fight
                            System.out.println("Impossible... You killed the Dragon... But they stand before you once again.");
                            System.out.println("Blight_Blaze, the bane of your existence.");
                            System.out.println("He looks as menacing as ever, but you are stronger now.");
                            System.out.println("Unfortunately, you realize he has gotten stronger as well.");
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }
                        else if (Player.FloorsCleared<61){//Second re-fight
                            System.out.println("Depite all odds, both of you are still alive.");
                            System.out.println("Blight_Blaze gives you a look of pity. He sees the trap you are in. The infinite looping.");
                            System.out.println("He understands.");
                            System.out.println("After all... Isn't he trapped too?");
                            System.out.println();
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }
                        else {//Future re-fights
                            System.out.println("You face the Dragon once more.");
                            System.out.println("...");
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }

                    }
//fights are based on a system where both parties have three actions they can take that function like rock paper scissors.The player chooses an action and the enemy's action is randomly generated. The fight continues until either the player or the enemy's health drops to 0 or below.       
                    for (int z=0; z==0;){
                        System.out.println();
                        System.out.println("Enemy Health: " + EnemyHealth);
                        System.out.println("Your Health: " + Player.Health + "/" + Player.MaxHealth);
                        System.out.println("Choose your action: Light Attack, Heavy Attack, Block");
                        System.out.println();
                        String Combat = Input.nextLine();
                        int PlayerAction = 0;
                        if (Combat.equals("Light Attack") || Combat.equals("light attack") || Combat.equals("L") || Combat.equals("l") || Combat.equals("Light") || Combat.equals("light")){
                            PlayerAction = 1;
                        }
                        else if (Combat.equals("Heavy Attack") || Combat.equals("heavy attack") || Combat.equals("H") || Combat.equals("h") || Combat.equals("Heavy") || Combat.equals("heavy")){
                            PlayerAction = 2;
                        }
                        else if (Combat.equals("Block") || Combat.equals("block") || Combat.equals("B") || Combat.equals("b")){
                            PlayerAction = 3;
                        }
                        else{
                            System.out.println("Invalid action. Please choose Light Attack, Heavy Attack, or Block.");
                            continue;
                        }
                        System.out.println();
//Enemy turn
                        int EnemyAction=0;
                        if (EnemyType==1){//Monster
                            int Y=RandomInt(1,5);
                            if (Y<3){//light
                                EnemyAction=1;
                            }
                            else if (Y==3){//heavy
                                EnemyAction=2;
                            }
                                else{//block
                                EnemyAction=3;
                            }
                        }
                        else if (EnemyType==2){//Elite
                            int Y=RandomInt(1,4);
                            if (Y==1){//light
                                EnemyAction=1;
                            }
                            else if (Y<4){//heavy
                                EnemyAction=2;
                            }
                            else{//block
                                EnemyAction=3;
                            }
                        }
                        else if (EnemyType==3){//Mini
                            int Y=RandomInt(1,5);
                            if (Y<3){//light
                                EnemyAction=1;
                            }
                            else if (Y==3){//heavy
                                EnemyAction=2;
                            }
                            else if (Y==4){//block
                                EnemyAction=3;
                            }
                            else{//Special
                                EnemyAction=4;
                            }
                        }
                        else if (EnemyType==4){//Boss
                            int Y=RandomInt(1,6);
                            if (Y==1){//light
                                EnemyAction=1;
                            }
                            else if (Y==2){//heavy
                                EnemyAction=2;
                            }
                            else if (Y==3){//block
                                EnemyAction=3;
                            }
                            else if (Y<6){//Special
                                EnemyAction=4;
                            }
                            else{//Other Special
                                EnemyAction=5;
                            }
                        }
                        else {//Dragon
                            int Y = RandomInt(1, 18);
                            if (Y<4){//Light
                                EnemyAction=1;
                            }
                            else if (Y<8){//Heavy
                                EnemyAction=2;
                            }
                            else if (Y<11){//Block
                                EnemyAction=3;
                            }
                            else if (Y<13){//Special
                                EnemyAction=4;
                            }
                            else if (Y<15){//Other Special
                                EnemyAction=5;
                            }
                            else{//Dragon Special
                                EnemyAction=6;
                            }
                        }
//Resolve Round of Combat.
                        if (PlayerAction==1){//Light
                            if (EnemyAction==1){//Light
                                PlayerDamage = Player.Strength + Player.LightDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("You Slash At " + MonsterName + "! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;
                                EnemyDamage= EnemyStrength - ((int)Math.floor(Player.Defense/2));
                                System.out.println("They Strike Back For " + EnemyDamage + " Points of Damage!");
                                Player.Health-=EnemyDamage;
                            }
                            else if (EnemyAction==2){//Heavy
                                PlayerDamage = Player.Strength + Player.LightDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("You Slash At " + MonsterName + "! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;
                                System.out.println("They Were Staggered and Can't Attack!");
                            }
                            else if (EnemyAction==3){//Block
                                System.out.println("You Attack! However " + MonsterName + " Parried Your Attack!");
                                System.out.println("They Reposte For " + EnemyStrength + " Points of Damage!");
                                Player.Health-=EnemyStrength;
                            }
                            else{//Special
                                PlayerDamage = Player.Strength + Player.LightDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("You Slash At " + MonsterName + "! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;

                            if (EnemyAction==4){//Heal
                                    System.out.println(MonsterName + " Regenerates " + Dungeon.Difficulty + " Health!");
                                    EnemyHealth+=Dungeon.Difficulty;
                                }
                                else if (EnemyAction==5){//Buff
                                    System.out.println(MonsterName + " Grows Stronger!");
                                    EnemyStrength+=((int)Math.floor(Dungeon.Difficulty/2));
                                    EnemyDefense+=((int)Math.floor(Dungeon.Difficulty/3));
                                }
                                else{//Fire-Ball
                                    System.out.println("The Dragon Spits A Fireball At You!");
                                    System.out.println("You Take " + Dungeon.Difficulty + " Points of Burning Damage.");
                                    Player.Health-=Dungeon.Difficulty;
                                }
                            }
                        }
                        else if (PlayerAction==2){//Heavy
                            if (EnemyAction==1){//Light
                                EnemyDamage= EnemyStrength - ((int)Math.floor(Player.Defense/2));
                                System.out.println(MonsterName + " Strikes You For " + EnemyDamage + " Points of Damage!");
                                Player.Health-=EnemyDamage;
                                System.out.println("You Were Staggered and Can't Attack!");
                            }
                            else if (EnemyAction==2){//Heavy
                                PlayerDamage= ((int)Math.floor(Player.Strength*1.5)) + Player.HeavyDamageModifier - ((int)Math.floor(EnemyDefense/3));
                                System.out.println("You Strike " + MonsterName + " With a Heavy Blow! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;
                                EnemyDamage= ((int)Math.floor(EnemyStrength*1.5)) - ((int)Math.floor(Player.Defense/3));
                                System.out.println("They Respond With an Attack of Their Own For " + EnemyDamage + " Points of Damage");
                                Player.Health-=EnemyDamage;
                            }       
                            else if (EnemyAction==3){//Block
                                PlayerDamage= ((int)Math.floor(Player.Strength*1.5)) + Player.HeavyDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("Your Heavy Strike Pierces " + MonsterName + "'s Defense!");
                                System.out.println("You Deal " + PlayerDamage + " Points of Dammage!");
                                EnemyHealth-=PlayerDamage;
                            }
                            else{//Special
                                PlayerDamage= ((int)Math.floor(Player.Strength*1.5)) + Player.HeavyDamageModifier - ((int)Math.floor(EnemyDefense/3));
                                System.out.println("You Strike " + MonsterName + " With a Heavy Blow! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;

                                if (EnemyAction==4){//Heal
                                    System.out.println(MonsterName + " Regenerates " + Dungeon.Difficulty + " Health!");
                                    EnemyHealth+=Dungeon.Difficulty;
                                }
                                else if (EnemyAction==5){//Buff
                                    System.out.println(MonsterName + " Grows Stronger!");
                                    EnemyStrength+=((int)Math.floor(Dungeon.Difficulty/2));
                                    EnemyDefense+=((int)Math.floor(Dungeon.Difficulty/3));
                                }
                                else{//Fire-Ball
                                    System.out.println("The Dragon Spits A Fireball At You!");
                                    System.out.println("You Take " + Dungeon.Difficulty + " Points of Burning Damage.");
                                    Player.Health-=Dungeon.Difficulty;
                                }
                            }
                        }
                        else{//Block
                            if (EnemyAction==1){//Light
                                System.out.println("You Parry " + MonsterName + "'s Attack!");
                                System.out.println("You Reposte For " + Player.Strength + " Points of Damage!");
                                EnemyHealth-=Player.Strength;
                            }
                            else if (EnemyAction==2){//Heavy
                                EnemyDamage = ((int)Math.floor(EnemyStrength*1.5)) - ((int)Math.floor(Player.Defense/2));
                                System.out.println("You Block But Are Unable to Parry " + MonsterName  + "'s Heavy Blow!");
                                System.out.println("You Are Hit For " + EnemyDamage + " Points of Damage!");
                                Player.Health-=EnemyDamage;
                            }
                            else if (EnemyAction==3){//Block
                                System.out.println("You Block at the Same Time as " + MonsterName + "!");
                                System.out.println("You Both Look Stupid!");
                            }
                            else{//Special
                                System.out.println("You Block But " + MonsterName + " Used An Ability!");

                                if (EnemyAction==4){//Heal
                                    System.out.println(MonsterName + " Regenerates " + Dungeon.Difficulty + " Health!");
                                    EnemyHealth+=Dungeon.Difficulty;
                                }
                                else if (EnemyAction==5){//Buff
                                    System.out.println(MonsterName + " Grows Stronger!");
                                    EnemyStrength+=((int)Math.floor(Dungeon.Difficulty/2));
                                    EnemyDefense+=((int)Math.floor(Dungeon.Difficulty/3));
                                }
                                else{//Fire-Ball
                                    System.out.println("The Dragon Spits A Fireball At You!");
                                    System.out.println("You Take " + Dungeon.Difficulty + " Points of Burning Damage.");
                                    Player.Health-=Dungeon.Difficulty;
                                }
                            }
                        }
                        System.out.println();
//Check For Death
                        if (Player.Health<=0){//Player Death overrides monster death.
                            System.out.println("After a particularly nasty blow, you fall unconscious!");
                            z=1;
                        }
                        else if (EnemyHealth<=0){//Enemy Death
                            if (EnemyType<3){
                                Player.Kills++;
                                System.out.println("You deal a final blow and finish off your opponent!");
                            }
                            int XP=(int) Math.pow(10, EnemyType);
                            Player.Gold+=((EnemyType+1)*(Dungeon.Difficulty+1));
                            System.out.println("You Gained " + ((EnemyType+1)*(Dungeon.Difficulty+1)) + " Gold!");
                            Player.GainEXP((int)Math.ceil(XP)*(Dungeon.Difficulty));//You get more XP on deeper floors, but less as you level up.
                            z=1;
                        }
                    }
                }
                else if (Room==3){
                    System.out.println("You find a Rest Spot and heal to full health.");
                    if (!(Player.Health==Player.MaxHealth)){//Only Heal if Hurt
                        Player.Health = Player.MaxHealth;
                        Dungeon.ClearRoom();
                    }
                }
                else if (Room==4){
                    System.out.println("You find a shop. You can buy upgrades here.");
                    Dungeon.ClearRoom();
                    for (int q=0; q<Dungeon.Difficulty; q++){//You may purchase items up to the Diffculty of the floor.
                        System.out.println("You have " + Player.Gold + " Gold. You may purchase up to " + (Dungeon.Difficulty-q) + " more items.");
                        System.out.println("0: Leave Shop");
                        System.out.println("1: Increase Strength by 1 for " + (7*Dungeon.Difficulty) + " Gold.");
                        System.out.println("2: Increase Light Damage Modifier by 1 for " + (2*Dungeon.Difficulty) + " Gold.");
                        System.out.println("3: Increase Heavy Damage Modifier by 1 for " + (3*Dungeon.Difficulty) + " Gold.");
                        System.out.println("4: Increase Defense by 1 for " + (5*Dungeon.Difficulty) + " Gold.");
                        System.out.println("5: Increase Max Health by 5 for " + (10*Dungeon.Difficulty) + " Gold.");
                        System.out.println("6: Buy 1 key for " + (15*Dungeon.Difficulty) + " Gold.");
                        System.out.println("Stats: Prints your stats.");
                        String choice = Input.nextLine();
                        if (choice.equals("0")){
                            break;
                        }
                        else if (choice.equals("1") && Player.Gold >= (7*Dungeon.Difficulty)){
                            Player.Strength++;
                            Player.Gold -= (7*Dungeon.Difficulty);
                            System.out.println("Strength increased to " + Player.Strength + "!");
                        }
                        else if (choice.equals("2") && Player.Gold >= (2*Dungeon.Difficulty)){
                            Player.LightDamageModifier++;
                            Player.Gold -= (2*Dungeon.Difficulty);
                            System.out.println("Light Damage Modifier increased to " + Player.LightDamageModifier + "!");
                        }
                        else if (choice.equals("3") && Player.Gold >= (3*Dungeon.Difficulty)){
                            Player.HeavyDamageModifier++;
                            Player.Gold -= (3*Dungeon.Difficulty);
                            System.out.println("Heavy Damage Modifier increased to " + Player.HeavyDamageModifier + "!");
                        }
                        else if (choice.equals("4") && Player.Gold >= (5*Dungeon.Difficulty)){
                            Player.Defense++;
                            Player.Gold -= (5*Dungeon.Difficulty);
                            System.out.println("Defense increased to " + Player.Defense + "!");
                        }
                        else if (choice.equals("5") && Player.Gold >= (10*Dungeon.Difficulty)){
                            Player.MaxHealth += 5;
                            Player.Health += 5;
                            Player.Gold -= (10*Dungeon.Difficulty);
                            System.out.println("Max Health increased to " + Player.MaxHealth + "! Health increased to " + Player.Health + "!");
                        }
                        else if (choice.equals("6") && Player.Gold >= (15*Dungeon.Difficulty)){
                            Player.Keys++;
                            Player.Gold -= (15*Dungeon.Difficulty);
                            System.out.println("You bought a key! You now have " + Player.Keys + " keys.");
                        }
                        else if (Action.equals("Stats") || Action.equals("stats")){//Prints the player's stats.
                            Player.Stats();
                        }
                        else{
                            System.out.println("Invalid choice or not enough gold.");
                            q--;
                        }
                        System.out.println();
                    }
                    System.out.println("The Shopkepper packs up and leaves.");
                }
                else if (Room==5){
                    System.out.println("You find a treasure chest!");
                    Player.Treasure(Dungeon.Difficulty);
                    Dungeon.ClearRoom();
                }
            }
            
            else if (Action.equals("Stats") || Action.equals("stats")){//Prints the player's stats.
                Player.Stats();
            }
            else if (Action.equals("Wait") || Action.equals("wait")){//Waiting reencounters the room the player is in.
                int Room = Dungeon.GetRoom();
                if (Room==-1){
                    System.out.println("Nothing happens.");
                }
                else if (Room==0){
                    System.out.println("Nothing happens.");
                }
                else if (Room==1){
                    System.out.println("You are attacked by a monster!");
                    Dungeon.ClearRoom();
                    int EnemyStrength=Dungeon.Difficulty+2;
                    int EnemyHealth=(Dungeon.Difficulty+1)*5;
                    int EnemyDefense=RandomInt(Dungeon.Difficulty, Dungeon.Difficulty+5);
                    int EnemyType=1;

                    System.out.println();
                    int PlayerDamage;
                    int EnemyDamage;
                    String MonsterName="";//Allows me to refer to the monster later.
                    if (EnemyType==1){//Monster
                        System.out.print("You encounter ");
                        int X = RandomInt(1, 10);
                        if (X==1){
                            System.out.println("A Slime!");
                            MonsterName="The Slime";
                        }
                        else if (X==2){
                            System.out.println("A Ghost");
                            MonsterName="The Ghost";
                        }
                        else if (X==3){
                            System.out.println("A Putrid Rat!");
                            MonsterName="The Rat";
                        }
                        else if (X==4){
                            System.out.println("A Goblin!");
                            MonsterName="The Goblin";
                        }
                        else if (X==5){
                            System.out.println("A Thief!");
                            MonsterName="The Thief";
                        }
                        else if (X==6){
                            System.out.println("A Bat Swarm!");
                            MonsterName="The Bats";
                        }
                        else if (X==7){
                            System.out.println("A Wlidcat");
                            MonsterName="The Wildcat";
                        }
                        else if (X==8){
                            System.out.println("A Undead Adventure!");
                            MonsterName="The Skeleton";
                        }
                        else if (X==9){
                            System.out.println("A Strangling Vine!");
                            MonsterName="The Plant";
                        }
                        else{
                            System.out.println("'MISSINGNO.'!");
                            MonsterName="The *&%$$#_*^%&^";
                        }
                        System.out.println("You ready for combat!");
                    }
                    else if (EnemyType==2){//Elite
                        System.out.print("You are suddenly ambushed by ");
                        int X = RandomInt(1, 7);
                        if (X==1){
                            System.out.println("A Killer Bunny!");
                            MonsterName="The Killer Bunny";
                        }
                        else if (X==2){
                            System.out.println("A Dark Mage!");
                            MonsterName="The Dark Mage";
                        }
                        else if (X==3){
                            System.out.println("A Troll!");
                            MonsterName="The Cave Troll";
                        }
                        else if (X==4){
                            System.out.println("A Whelpling!");
                            MonsterName="The Dragonnet";
                        }
                        else if (X==5){
                            System.out.println("A Chest Mimic!");
                            MonsterName="The Mimic";
                        }
                        else if (X==6){
                            System.out.println("A Fallen Knight!");
                            MonsterName="The Knight";
                        }
                        else{
                            System.out.println("A Giant Centipede!");
                            MonsterName="The Centipede";
                        } 
                        System.out.println("You recover in time to fight back!");
                    }       
                    else if (EnemyType==3){//Mini-boss
                        System.out.print("Your path is blocked by ");
                        int X = RandomInt(1, 5);
                        if (X==1){
                            System.out.println("Giant Enemy Crab!");
                            MonsterName="The 'Giant Enemy Crab!'";
                        }
                        else if (X==2){
                            System.out.println("A Living Wall!");
                            MonsterName="The Wall";
                        }
                        else if (X==3){
                            System.out.println("A Giant Mole!");
                            MonsterName="The Giant Mole";
                        }
                        else if (X==4){
                            System.out.println("A Large Serpent!");
                            MonsterName="The Snake";
                        }
                        else{
                            System.out.println("A Swarm of Spiders!");
                            MonsterName="The Spiders";
                        }
                        System.out.println("They won't go down without a fight! Neither will you!");
                    }
                    else if (EnemyType==4){//Boss
                        System.out.print("You come face to face with ");
                        int X = RandomInt(1, 3);
                        if (X==1){
                            System.out.println("A Young But Fierce Drake!");
                            MonsterName="The Young Dragon";
                        }
                        else if (X==2){
                            System.out.println("A Rock Golem!");
                            MonsterName="The Golem";
                        }
                        else{
                            System.out.println("A Necromancer.");
                            MonsterName="The Necromancer";
                        }
                        System.out.println("A fierce battle ensues!");
                    }
                    else if (EnemyType==5){//Final Boss
                        MonsterName="The Dragon";
                        System.out.println();
                        if (Player.FloorsCleared<21){//This is the first time fighting the Dragon this run.
                            System.out.println("The final challange stands before you");
                            System.out.println("The Dragon has been the cause of countless tragedies, the downfall of empires, and the end of heroes.");
                            System.out.println("You face the draconic scourge, the fearsome terror of the Seven Realms.");
                            System.out.println("The Feind of the Sky, Humanity's Green Scaled Plague.");
                            System.out.println("The Feared, the Destroyer, the Devourer, the End of All Things.");
                            System.out.println("This is it. Everything has lead to this final and ultimate battle.");
                            System.out.println("Against The Dragon.");
                            System.out.println("Blight_Blaze.");
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }
                        else if (Player.FloorsCleared<41){//First re-fight
                            System.out.println("Impossible... You killed the Dragon... But they stand before you once again.");
                            System.out.println("Blight_Blaze, the bane of your existence.");
                            System.out.println("He looks as menacing as ever, but you are stronger now.");
                            System.out.println("Unfortunately, you realize he has gotten stronger as well.");
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }
                        else if (Player.FloorsCleared<61){//Second re-fight
                            System.out.println("Depite all odds, both of you are still alive.");
                            System.out.println("Blight_Blaze gives you a look of pity. He sees the trap you are in. The infinite looping.");
                            System.out.println("He understands.");
                            System.out.println("After all... Isn't he trapped too?");
                            System.out.println();
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }
                        else {//Future re-fights
                            System.out.println("You face the Dragon once more.");
                            System.out.println("...");
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }

                    }
//fights are based on a system where both parties have three actions they can take that function like rock paper scissors.The player chooses an action and the enemy's action is randomly generated. The fight continues until either the player or the enemy's health drops to 0 or below.       
                    for (int z=0; z==0;){
                        System.out.println();
                        System.out.println("Enemy Health: " + EnemyHealth);
                        System.out.println("Your Health: " + Player.Health + "/" + Player.MaxHealth);
                        System.out.println("Choose your action: Light Attack, Heavy Attack, Block");
                        System.out.println();
                        String Combat = Input.nextLine();
                        int PlayerAction = 0;
                        if (Combat.equals("Light Attack") || Combat.equals("light attack") || Combat.equals("L") || Combat.equals("l") || Combat.equals("Light") || Combat.equals("light")){
                            PlayerAction = 1;
                        }
                        else if (Combat.equals("Heavy Attack") || Combat.equals("heavy attack") || Combat.equals("H") || Combat.equals("h") || Combat.equals("Heavy") || Combat.equals("heavy")){
                            PlayerAction = 2;
                        }
                        else if (Combat.equals("Block") || Combat.equals("block") || Combat.equals("B") || Combat.equals("b")){
                            PlayerAction = 3;
                        }
                        else{
                            System.out.println("Invalid action. Please choose Light Attack, Heavy Attack, or Block.");
                            continue;
                        }
                        System.out.println();
//Enemy turn
                        int EnemyAction=0;
                        if (EnemyType==1){//Monster
                            int Y=RandomInt(1,5);
                            if (Y<3){//light
                                EnemyAction=1;
                            }
                            else if (Y==3){//heavy
                                EnemyAction=2;
                            }
                                else{//block
                                EnemyAction=3;
                            }
                        }
                        else if (EnemyType==2){//Elite
                            int Y=RandomInt(1,4);
                            if (Y==1){//light
                                EnemyAction=1;
                            }
                            else if (Y<4){//heavy
                                EnemyAction=2;
                            }
                            else{//block
                                EnemyAction=3;
                            }
                        }
                        else if (EnemyType==3){//Mini
                            int Y=RandomInt(1,5);
                            if (Y<3){//light
                                EnemyAction=1;
                            }
                            else if (Y==3){//heavy
                                EnemyAction=2;
                            }
                            else if (Y==4){//block
                                EnemyAction=3;
                            }
                            else{//Special
                                EnemyAction=4;
                            }
                        }
                        else if (EnemyType==4){//Boss
                            int Y=RandomInt(1,6);
                            if (Y==1){//light
                                EnemyAction=1;
                            }
                            else if (Y==2){//heavy
                                EnemyAction=2;
                            }
                            else if (Y==3){//block
                                EnemyAction=3;
                            }
                            else if (Y<6){//Special
                                EnemyAction=4;
                            }
                            else{//Other Special
                                EnemyAction=5;
                            }
                        }
                        else {//Dragon
                            int Y = RandomInt(1, 18);
                            if (Y<4){//Light
                                EnemyAction=1;
                            }
                            else if (Y<8){//Heavy
                                EnemyAction=2;
                            }
                            else if (Y<11){//Block
                                EnemyAction=3;
                            }
                            else if (Y<13){//Special
                                EnemyAction=4;
                            }
                            else if (Y<15){//Other Special
                                EnemyAction=5;
                            }
                            else{//Dragon Special
                                EnemyAction=6;
                            }
                        }
//Resolve Round of Combat.
                        if (PlayerAction==1){//Light
                            if (EnemyAction==1){//Light
                                PlayerDamage = Player.Strength + Player.LightDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("You Slash At " + MonsterName + "! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;
                                EnemyDamage= EnemyStrength - ((int)Math.floor(Player.Defense/2));
                                System.out.println("They Strike Back For " + EnemyDamage + " Points of Damage!");
                                Player.Health-=EnemyDamage;
                            }
                            else if (EnemyAction==2){//Heavy
                                PlayerDamage = Player.Strength + Player.LightDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("You Slash At " + MonsterName + "! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;
                                System.out.println("They Were Staggered and Can't Attack!");
                            }
                            else if (EnemyAction==3){//Block
                                System.out.println("You Attack! However " + MonsterName + " Parried Your Attack!");
                                System.out.println("They Reposte For " + EnemyStrength + " Points of Damage!");
                                Player.Health-=EnemyStrength;
                            }
                            else{//Special
                                PlayerDamage = Player.Strength + Player.LightDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("You Slash At " + MonsterName + "! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;

                            if (EnemyAction==4){//Heal
                                    System.out.println(MonsterName + " Regenerates " + Dungeon.Difficulty + " Health!");
                                    EnemyHealth+=Dungeon.Difficulty;
                                }
                                else if (EnemyAction==5){//Buff
                                    System.out.println(MonsterName + " Grows Stronger!");
                                    EnemyStrength+=((int)Math.floor(Dungeon.Difficulty/2));
                                    EnemyDefense+=((int)Math.floor(Dungeon.Difficulty/3));
                                }
                                else{//Fire-Ball
                                    System.out.println("The Dragon Spits A Fireball At You!");
                                    System.out.println("You Take " + Dungeon.Difficulty + " Points of Burning Damage.");
                                    Player.Health-=Dungeon.Difficulty;
                                }
                            }
                        }
                        else if (PlayerAction==2){//Heavy
                            if (EnemyAction==1){//Light
                                EnemyDamage= EnemyStrength - ((int)Math.floor(Player.Defense/2));
                                System.out.println(MonsterName + " Strikes You For " + EnemyDamage + " Points of Damage!");
                                Player.Health-=EnemyDamage;
                                System.out.println("You Were Staggered and Can't Attack!");
                            }
                            else if (EnemyAction==2){//Heavy
                                PlayerDamage= ((int)Math.floor(Player.Strength*1.5)) + Player.HeavyDamageModifier - ((int)Math.floor(EnemyDefense/3));
                                System.out.println("You Strike " + MonsterName + " With a Heavy Blow! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;
                                EnemyDamage= ((int)Math.floor(EnemyStrength*1.5)) - ((int)Math.floor(Player.Defense/3));
                                System.out.println("They Respond With an Attack of Their Own For " + EnemyDamage + " Points of Damage");
                                Player.Health-=EnemyDamage;
                            }       
                            else if (EnemyAction==3){//Block
                                PlayerDamage= ((int)Math.floor(Player.Strength*1.5)) + Player.HeavyDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("Your Heavy Strike Pierces " + MonsterName + "'s Defense!");
                                System.out.println("You Deal " + PlayerDamage + " Points of Dammage!");
                                EnemyHealth-=PlayerDamage;
                            }
                            else{//Special
                                PlayerDamage= ((int)Math.floor(Player.Strength*1.5)) + Player.HeavyDamageModifier - ((int)Math.floor(EnemyDefense/3));
                                System.out.println("You Strike " + MonsterName + " With a Heavy Blow! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;

                                if (EnemyAction==4){//Heal
                                    System.out.println(MonsterName + " Regenerates " + Dungeon.Difficulty + " Health!");
                                    EnemyHealth+=Dungeon.Difficulty;
                                }
                                else if (EnemyAction==5){//Buff
                                    System.out.println(MonsterName + " Grows Stronger!");
                                    EnemyStrength+=((int)Math.floor(Dungeon.Difficulty/2));
                                    EnemyDefense+=((int)Math.floor(Dungeon.Difficulty/3));
                                }
                                else{//Fire-Ball
                                    System.out.println("The Dragon Spits A Fireball At You!");
                                    System.out.println("You Take " + Dungeon.Difficulty + " Points of Burning Damage.");
                                    Player.Health-=Dungeon.Difficulty;
                                }
                            }
                        }
                        else{//Block
                            if (EnemyAction==1){//Light
                                System.out.println("You Parry " + MonsterName + "'s Attack!");
                                System.out.println("You Reposte For " + Player.Strength + " Points of Damage!");
                                EnemyHealth-=Player.Strength;
                            }
                            else if (EnemyAction==2){//Heavy
                                EnemyDamage = ((int)Math.floor(EnemyStrength*1.5)) - ((int)Math.floor(Player.Defense/2));
                                System.out.println("You Block But Are Unable to Parry " + MonsterName  + "'s Heavy Blow!");
                                System.out.println("You Are Hit For " + EnemyDamage + " Points of Damage!");
                                Player.Health-=EnemyDamage;
                            }
                            else if (EnemyAction==3){//Block
                                System.out.println("You Block at the Same Time as " + MonsterName + "!");
                                System.out.println("You Both Look Stupid!");
                            }
                            else{//Special
                                System.out.println("You Block But " + MonsterName + " Used An Ability!");

                                if (EnemyAction==4){//Heal
                                    System.out.println(MonsterName + " Regenerates " + Dungeon.Difficulty + " Health!");
                                    EnemyHealth+=Dungeon.Difficulty;
                                }
                                else if (EnemyAction==5){//Buff
                                    System.out.println(MonsterName + " Grows Stronger!");
                                    EnemyStrength+=((int)Math.floor(Dungeon.Difficulty/2));
                                    EnemyDefense+=((int)Math.floor(Dungeon.Difficulty/3));
                                }
                                else{//Fire-Ball
                                    System.out.println("The Dragon Spits A Fireball At You!");
                                    System.out.println("You Take " + Dungeon.Difficulty + " Points of Burning Damage.");
                                    Player.Health-=Dungeon.Difficulty;
                                }
                            }
                        }
                        System.out.println();
//Check For Death
                        if (Player.Health<=0){//Player Death overrides monster death.
                            System.out.println("After a particularly nasty blow, you fall unconscious!");
                            z=1;
                        }
                        else if (EnemyHealth<=0){//Enemy Death
                            if (EnemyType<3){
                                Player.Kills++;
                                System.out.println("You deal a final blow and finish off your opponent!");
                            }
                            int XP=(int) Math.pow(10, EnemyType);
                            Player.Gold+=((EnemyType+1)*(Dungeon.Difficulty+1));
                            System.out.println("You Gained " + ((EnemyType+1)*(Dungeon.Difficulty+1)) + " Gold!");
                            Player.GainEXP((int)Math.ceil(XP)*(Dungeon.Difficulty));//You get more XP on deeper floors, but less as you level up.
                            z=1;
                        }
                    }                   
                }
                else if (Room==2){
                    System.out.println("You are attacked by an elite monster!");
                    Dungeon.ClearRoom();
                    int EnemyStrength=Dungeon.Difficulty+5;
                    int EnemyHealth=(Dungeon.Difficulty+1)*10;
                    int EnemyDefense=RandomInt(Dungeon.Difficulty+5, Dungeon.Difficulty+10);
                    int EnemyType=2;

                    System.out.println();
                    int PlayerDamage;
                    int EnemyDamage;
                    String MonsterName="";//Allows me to refer to the monster later.
                    if (EnemyType==1){//Monster
                        System.out.print("You encounter ");
                        int X = RandomInt(1, 10);
                        if (X==1){
                            System.out.println("A Slime!");
                            MonsterName="The Slime";
                        }
                        else if (X==2){
                            System.out.println("A Ghost");
                            MonsterName="The Ghost";
                        }
                        else if (X==3){
                            System.out.println("A Putrid Rat!");
                            MonsterName="The Rat";
                        }
                        else if (X==4){
                            System.out.println("A Goblin!");
                            MonsterName="The Goblin";
                        }
                        else if (X==5){
                            System.out.println("A Thief!");
                            MonsterName="The Thief";
                        }
                        else if (X==6){
                            System.out.println("A Bat Swarm!");
                            MonsterName="The Bats";
                        }
                        else if (X==7){
                            System.out.println("A Wlidcat");
                            MonsterName="The Wildcat";
                        }
                        else if (X==8){
                            System.out.println("A Undead Adventure!");
                            MonsterName="The Skeleton";
                        }
                        else if (X==9){
                            System.out.println("A Strangling Vine!");
                            MonsterName="The Plant";
                        }
                        else{
                            System.out.println("'MISSINGNO.'!");
                            MonsterName="The *&%$$#_*^%&^";
                        }
                        System.out.println("You ready for combat!");
                    }
                    else if (EnemyType==2){//Elite
                        System.out.print("You are suddenly ambushed by ");
                        int X = RandomInt(1, 7);
                        if (X==1){
                            System.out.println("A Killer Bunny!");
                            MonsterName="The Killer Bunny";
                        }
                        else if (X==2){
                            System.out.println("A Dark Mage!");
                            MonsterName="The Dark Mage";
                        }
                        else if (X==3){
                            System.out.println("A Troll!");
                            MonsterName="The Cave Troll";
                        }
                        else if (X==4){
                            System.out.println("A Whelpling!");
                            MonsterName="The Dragonnet";
                        }
                        else if (X==5){
                            System.out.println("A Chest Mimic!");
                            MonsterName="The Mimic";
                        }
                        else if (X==6){
                            System.out.println("A Fallen Knight!");
                            MonsterName="The Knight";
                        }
                        else{
                            System.out.println("A Giant Centipede!");
                            MonsterName="The Centipede";
                        } 
                        System.out.println("You recover in time to fight back!");
                    }       
                    else if (EnemyType==3){//Mini-boss
                        System.out.print("Your path is blocked by ");
                        int X = RandomInt(1, 5);
                        if (X==1){
                            System.out.println("Giant Enemy Crab!");
                            MonsterName="The 'Giant Enemy Crab!'";
                        }
                        else if (X==2){
                            System.out.println("A Living Wall!");
                            MonsterName="The Wall";
                        }
                        else if (X==3){
                            System.out.println("A Giant Mole!");
                            MonsterName="The Giant Mole";
                        }
                        else if (X==4){
                            System.out.println("A Large Serpent!");
                            MonsterName="The Snake";
                        }
                        else{
                            System.out.println("A Swarm of Spiders!");
                            MonsterName="The Spiders";
                        }
                        System.out.println("They won't go down without a fight! Neither will you!");
                    }
                    else if (EnemyType==4){//Boss
                        System.out.print("You come face to face with ");
                        int X = RandomInt(1, 3);
                        if (X==1){
                            System.out.println("A Young But Fierce Drake!");
                            MonsterName="The Young Dragon";
                        }
                        else if (X==2){
                            System.out.println("A Rock Golem!");
                            MonsterName="The Golem";
                        }
                        else{
                            System.out.println("A Necromancer.");
                            MonsterName="The Necromancer";
                        }
                        System.out.println("A fierce battle ensues!");
                    }
                    else if (EnemyType==5){//Final Boss
                        MonsterName="The Dragon";
                        System.out.println();
                        if (Player.FloorsCleared<21){//This is the first time fighting the Dragon this run.
                            System.out.println("The final challange stands before you");
                            System.out.println("The Dragon has been the cause of countless tragedies, the downfall of empires, and the end of heroes.");
                            System.out.println("You face the draconic scourge, the fearsome terror of the Seven Realms.");
                            System.out.println("The Feind of the Sky, Humanity's Green Scaled Plague.");
                            System.out.println("The Feared, the Destroyer, the Devourer, the End of All Things.");
                            System.out.println("This is it. Everything has lead to this final and ultimate battle.");
                            System.out.println("Against The Dragon.");
                            System.out.println("Blight_Blaze.");
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }
                        else if (Player.FloorsCleared<41){//First re-fight
                            System.out.println("Impossible... You killed the Dragon... But they stand before you once again.");
                            System.out.println("Blight_Blaze, the bane of your existence.");
                            System.out.println("He looks as menacing as ever, but you are stronger now.");
                            System.out.println("Unfortunately, you realize he has gotten stronger as well.");
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }
                        else if (Player.FloorsCleared<61){//Second re-fight
                            System.out.println("Depite all odds, both of you are still alive.");
                            System.out.println("Blight_Blaze gives you a look of pity. He sees the trap you are in. The infinite looping.");
                            System.out.println("He understands.");
                            System.out.println("After all... Isn't he trapped too?");
                            System.out.println();
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }
                        else {//Future re-fights
                            System.out.println("You face the Dragon once more.");
                            System.out.println("...");
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }

                    }
//fights are based on a system where both parties have three actions they can take that function like rock paper scissors.The player chooses an action and the enemy's action is randomly generated. The fight continues until either the player or the enemy's health drops to 0 or below.       
                    for (int z=0; z==0;){
                        System.out.println();
                        System.out.println("Enemy Health: " + EnemyHealth);
                        System.out.println("Your Health: " + Player.Health + "/" + Player.MaxHealth);
                        System.out.println("Choose your action: Light Attack, Heavy Attack, Block");
                        System.out.println();
                        String Combat = Input.nextLine();
                        int PlayerAction = 0;
                        if (Combat.equals("Light Attack") || Combat.equals("light attack") || Combat.equals("L") || Combat.equals("l") || Combat.equals("Light") || Combat.equals("light")){
                            PlayerAction = 1;
                        }
                        else if (Combat.equals("Heavy Attack") || Combat.equals("heavy attack") || Combat.equals("H") || Combat.equals("h") || Combat.equals("Heavy") || Combat.equals("heavy")){
                            PlayerAction = 2;
                        }
                        else if (Combat.equals("Block") || Combat.equals("block") || Combat.equals("B") || Combat.equals("b")){
                            PlayerAction = 3;
                        }
                        else{
                            System.out.println("Invalid action. Please choose Light Attack, Heavy Attack, or Block.");
                            continue;
                        }
                        System.out.println();
//Enemy turn
                        int EnemyAction=0;
                        if (EnemyType==1){//Monster
                            int Y=RandomInt(1,5);
                            if (Y<3){//light
                                EnemyAction=1;
                            }
                            else if (Y==3){//heavy
                                EnemyAction=2;
                            }
                                else{//block
                                EnemyAction=3;
                            }
                        }
                        else if (EnemyType==2){//Elite
                            int Y=RandomInt(1,4);
                            if (Y==1){//light
                                EnemyAction=1;
                            }
                            else if (Y<4){//heavy
                                EnemyAction=2;
                            }
                            else{//block
                                EnemyAction=3;
                            }
                        }
                        else if (EnemyType==3){//Mini
                            int Y=RandomInt(1,5);
                            if (Y<3){//light
                                EnemyAction=1;
                            }
                            else if (Y==3){//heavy
                                EnemyAction=2;
                            }
                            else if (Y==4){//block
                                EnemyAction=3;
                            }
                            else{//Special
                                EnemyAction=4;
                            }
                        }
                        else if (EnemyType==4){//Boss
                            int Y=RandomInt(1,6);
                            if (Y==1){//light
                                EnemyAction=1;
                            }
                            else if (Y==2){//heavy
                                EnemyAction=2;
                            }
                            else if (Y==3){//block
                                EnemyAction=3;
                            }
                            else if (Y<6){//Special
                                EnemyAction=4;
                            }
                            else{//Other Special
                                EnemyAction=5;
                            }
                        }
                        else {//Dragon
                            int Y = RandomInt(1, 18);
                            if (Y<4){//Light
                                EnemyAction=1;
                            }
                            else if (Y<8){//Heavy
                                EnemyAction=2;
                            }
                            else if (Y<11){//Block
                                EnemyAction=3;
                            }
                            else if (Y<13){//Special
                                EnemyAction=4;
                            }
                            else if (Y<15){//Other Special
                                EnemyAction=5;
                            }
                            else{//Dragon Special
                                EnemyAction=6;
                            }
                        }
//Resolve Round of Combat.
                        if (PlayerAction==1){//Light
                            if (EnemyAction==1){//Light
                                PlayerDamage = Player.Strength + Player.LightDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("You Slash At " + MonsterName + "! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;
                                EnemyDamage= EnemyStrength - ((int)Math.floor(Player.Defense/2));
                                System.out.println("They Strike Back For " + EnemyDamage + " Points of Damage!");
                                Player.Health-=EnemyDamage;
                            }
                            else if (EnemyAction==2){//Heavy
                                PlayerDamage = Player.Strength + Player.LightDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("You Slash At " + MonsterName + "! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;
                                System.out.println("They Were Staggered and Can't Attack!");
                            }
                            else if (EnemyAction==3){//Block
                                System.out.println("You Attack! However " + MonsterName + " Parried Your Attack!");
                                System.out.println("They Reposte For " + EnemyStrength + " Points of Damage!");
                                Player.Health-=EnemyStrength;
                            }
                            else{//Special
                                PlayerDamage = Player.Strength + Player.LightDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("You Slash At " + MonsterName + "! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;

                            if (EnemyAction==4){//Heal
                                    System.out.println(MonsterName + " Regenerates " + Dungeon.Difficulty + " Health!");
                                    EnemyHealth+=Dungeon.Difficulty;
                                }
                                else if (EnemyAction==5){//Buff
                                    System.out.println(MonsterName + " Grows Stronger!");
                                    EnemyStrength+=((int)Math.floor(Dungeon.Difficulty/2));
                                    EnemyDefense+=((int)Math.floor(Dungeon.Difficulty/3));
                                }
                                else{//Fire-Ball
                                    System.out.println("The Dragon Spits A Fireball At You!");
                                    System.out.println("You Take " + Dungeon.Difficulty + " Points of Burning Damage.");
                                    Player.Health-=Dungeon.Difficulty;
                                }
                            }
                        }
                        else if (PlayerAction==2){//Heavy
                            if (EnemyAction==1){//Light
                                EnemyDamage= EnemyStrength - ((int)Math.floor(Player.Defense/2));
                                System.out.println(MonsterName + " Strikes You For " + EnemyDamage + " Points of Damage!");
                                Player.Health-=EnemyDamage;
                                System.out.println("You Were Staggered and Can't Attack!");
                            }
                            else if (EnemyAction==2){//Heavy
                                PlayerDamage= ((int)Math.floor(Player.Strength*1.5)) + Player.HeavyDamageModifier - ((int)Math.floor(EnemyDefense/3));
                                System.out.println("You Strike " + MonsterName + " With a Heavy Blow! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;
                                EnemyDamage= ((int)Math.floor(EnemyStrength*1.5)) - ((int)Math.floor(Player.Defense/3));
                                System.out.println("They Respond With an Attack of Their Own For " + EnemyDamage + " Points of Damage");
                                Player.Health-=EnemyDamage;
                            }       
                            else if (EnemyAction==3){//Block
                                PlayerDamage= ((int)Math.floor(Player.Strength*1.5)) + Player.HeavyDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("Your Heavy Strike Pierces " + MonsterName + "'s Defense!");
                                System.out.println("You Deal " + PlayerDamage + " Points of Dammage!");
                                EnemyHealth-=PlayerDamage;
                            }
                            else{//Special
                                PlayerDamage= ((int)Math.floor(Player.Strength*1.5)) + Player.HeavyDamageModifier - ((int)Math.floor(EnemyDefense/3));
                                System.out.println("You Strike " + MonsterName + " With a Heavy Blow! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;

                                if (EnemyAction==4){//Heal
                                    System.out.println(MonsterName + " Regenerates " + Dungeon.Difficulty + " Health!");
                                    EnemyHealth+=Dungeon.Difficulty;
                                }
                                else if (EnemyAction==5){//Buff
                                    System.out.println(MonsterName + " Grows Stronger!");
                                    EnemyStrength+=((int)Math.floor(Dungeon.Difficulty/2));
                                    EnemyDefense+=((int)Math.floor(Dungeon.Difficulty/3));
                                }
                                else{//Fire-Ball
                                    System.out.println("The Dragon Spits A Fireball At You!");
                                    System.out.println("You Take " + Dungeon.Difficulty + " Points of Burning Damage.");
                                    Player.Health-=Dungeon.Difficulty;
                                }
                            }
                        }
                        else{//Block
                            if (EnemyAction==1){//Light
                                System.out.println("You Parry " + MonsterName + "'s Attack!");
                                System.out.println("You Reposte For " + Player.Strength + " Points of Damage!");
                                EnemyHealth-=Player.Strength;
                            }
                            else if (EnemyAction==2){//Heavy
                                EnemyDamage = ((int)Math.floor(EnemyStrength*1.5)) - ((int)Math.floor(Player.Defense/2));
                                System.out.println("You Block But Are Unable to Parry " + MonsterName  + "'s Heavy Blow!");
                                System.out.println("You Are Hit For " + EnemyDamage + " Points of Damage!");
                                Player.Health-=EnemyDamage;
                            }
                            else if (EnemyAction==3){//Block
                                System.out.println("You Block at the Same Time as " + MonsterName + "!");
                                System.out.println("You Both Look Stupid!");
                            }
                            else{//Special
                                System.out.println("You Block But " + MonsterName + " Used An Ability!");

                                if (EnemyAction==4){//Heal
                                    System.out.println(MonsterName + " Regenerates " + Dungeon.Difficulty + " Health!");
                                    EnemyHealth+=Dungeon.Difficulty;
                                }
                                else if (EnemyAction==5){//Buff
                                    System.out.println(MonsterName + " Grows Stronger!");
                                    EnemyStrength+=((int)Math.floor(Dungeon.Difficulty/2));
                                    EnemyDefense+=((int)Math.floor(Dungeon.Difficulty/3));
                                }
                                else{//Fire-Ball
                                    System.out.println("The Dragon Spits A Fireball At You!");
                                    System.out.println("You Take " + Dungeon.Difficulty + " Points of Burning Damage.");
                                    Player.Health-=Dungeon.Difficulty;
                                }
                            }
                        }
                        System.out.println();
//Check For Death
                        if (Player.Health<=0){//Player Death overrides monster death.
                            System.out.println("After a particularly nasty blow, you fall unconscious!");
                            z=1;
                        }
                        else if (EnemyHealth<=0){//Enemy Death
                            if (EnemyType<3){
                                Player.Kills++;
                                System.out.println("You deal a final blow and finish off your opponent!");
                            }
                            int XP=(int) Math.pow(10, EnemyType);
                            Player.Gold+=((EnemyType+1)*(Dungeon.Difficulty+1));
                            System.out.println("You Gained " + ((EnemyType+1)*(Dungeon.Difficulty+1)) + " Gold!");
                            Player.GainEXP((int)Math.ceil(XP)*(Dungeon.Difficulty));//You get more XP on deeper floors, but less as you level up.
                            z=1;
                        }
                    }
                }
                else if (Room==3){
                    System.out.println("You find a Rest Spot and heal to full health.");
                    if (!(Player.Health==Player.MaxHealth)){//Only Heal if Hurt
                        Player.Health = Player.MaxHealth;
                        Dungeon.ClearRoom();
                    }
                }
                else if (Room==4){
                    System.out.println("You find a shop. You can buy upgrades here.");
                    Dungeon.ClearRoom();
                    for (int q=0; q<Dungeon.Difficulty; q++){//You may purchase items up to the Diffculty of the floor.
                        System.out.println("You have " + Player.Gold + " Gold. You may purchase up to " + (Dungeon.Difficulty-q) + " more items.");
                        System.out.println("0: Leave Shop");
                        System.out.println("1: Increase Strength by 1 for " + (7*Dungeon.Difficulty) + " Gold.");
                        System.out.println("2: Increase Light Damage Modifier by 1 for " + (2*Dungeon.Difficulty) + " Gold.");
                        System.out.println("3: Increase Heavy Damage Modifier by 1 for " + (3*Dungeon.Difficulty) + " Gold.");
                        System.out.println("4: Increase Defense by 1 for " + (5*Dungeon.Difficulty) + " Gold.");
                        System.out.println("5: Increase Max Health by 5 for " + (10*Dungeon.Difficulty) + " Gold.");
                        System.out.println("6: Buy 1 key for " + (15*Dungeon.Difficulty) + " Gold.");
                        System.out.println("Stats: Prints your stats.");
                        String choice = Input.nextLine();
                        if (choice.equals("0")){
                            break;
                        }
                        else if (choice.equals("1") && Player.Gold >= (7*Dungeon.Difficulty)){
                            Player.Strength++;
                            Player.Gold -= (7*Dungeon.Difficulty);
                            System.out.println("Strength increased to " + Player.Strength + "!");
                        }
                        else if (choice.equals("2") && Player.Gold >= (2*Dungeon.Difficulty)){
                            Player.LightDamageModifier++;
                            Player.Gold -= (2*Dungeon.Difficulty);
                            System.out.println("Light Damage Modifier increased to " + Player.LightDamageModifier + "!");
                        }
                        else if (choice.equals("3") && Player.Gold >= (3*Dungeon.Difficulty)){
                            Player.HeavyDamageModifier++;
                            Player.Gold -= (3*Dungeon.Difficulty);
                            System.out.println("Heavy Damage Modifier increased to " + Player.HeavyDamageModifier + "!");
                        }
                        else if (choice.equals("4") && Player.Gold >= (5*Dungeon.Difficulty)){
                            Player.Defense++;
                            Player.Gold -= (5*Dungeon.Difficulty);
                            System.out.println("Defense increased to " + Player.Defense + "!");
                        }
                        else if (choice.equals("5") && Player.Gold >= (10*Dungeon.Difficulty)){
                            Player.MaxHealth += 5;
                            Player.Health += 5;
                            Player.Gold -= (10*Dungeon.Difficulty);
                            System.out.println("Max Health increased to " + Player.MaxHealth + "! Health increased to " + Player.Health + "!");
                        }
                        else if (choice.equals("6") && Player.Gold >= (15*Dungeon.Difficulty)){
                            Player.Keys++;
                            Player.Gold -= (15*Dungeon.Difficulty);
                            System.out.println("You bought a key! You now have " + Player.Keys + " keys.");
                        }
                        else if (Action.equals("Stats") || Action.equals("stats")){//Prints the player's stats.
                            Player.Stats();
                        }
                        else{
                            System.out.println("Invalid choice or not enough gold.");
                            q--;
                        }
                        System.out.println();
                    }
                    System.out.println("The Shopkepper packs up and leaves.");
                }
                else if (Room==5){
                    System.out.println("You find a treasure chest!");
                    Player.Treasure(Dungeon.Difficulty);
                    Dungeon.ClearRoom();
                }
            }
            else if (Action.equals("Quit") || Action.equals("quit") || Action.equals("Exit") || Action.equals("exit") || Action.equals("Q") || Action.equals("q")){//Quit the game.
                System.out.println("Are you sure you want to quit? (Y/N)");
                String Choice = Input.nextLine();
                if (Choice.equals("Y") || Choice.equals("y") || Choice.equals("Yes") || Choice.equals("yes")){
                    i=1;
                    System.out.println("You have quit the game.");
                }
                else{
                    System.out.println("You can't give up while the Dungeon still stands!");
                }
//               
            }
            else if (Action.equals("TP") || Action.equals("tp") || Action.equals("Tp") || Action.equals("T") || Action.equals("t")){//Returns the player to the start.
                Dungeon.Teleport();
                System.out.println("You return to the Start Room.");
            }
            else if (Action.equals("Descend") || Action.equals("descend")|| Action.equals("Down") || Action.equals("down") || Action.equals("D") || Action.equals("d")){//complete a floor and move to the next. This will require the player to have completed a goal (reach a certin level, kill X monsters, find a key) and will save the game.
                if (Dungeon.GetRoom()==-1){
//code to check if the player can descend.
                    if (Dungeon.FloorGoal==0){
//Player can descend.
                        System.out.println("Are you sure? Once you leave this floor, you won't be able to return. (Y/N)");
                        String Choice = Input.nextLine();
                        if (Choice.equals("Y") || Choice.equals("y") || Choice.equals("Yes") || Choice.equals("yes")){
                            System.out.println("You descend to floor " + (Player.FloorsCleared+1) + ".");
                            Player.FloorsCleared++;
                            Player.GainEXP(10*Player.Level);
                            Player.Health = Player.MaxHealth;//Heal the player to full health upon completing a floor.
                            System.out.println("Your health has been restored to " + Player.Health + "/" + Player.MaxHealth);
//Code to save the game goes here.
                            try{
                                java.io.FileWriter Save = new java.io.FileWriter("InfiniteDungeonSave.txt");
                                Save.write(Integer.toString(Player.MaxHealth) + "\n");
                                Save.write(Integer.toString(Player.Health) + "\n");
                                Save.write(Integer.toString(Player.Strength) + "\n");
                                Save.write(Integer.toString(Player.LightDamageModifier) + "\n");
                                Save.write(Integer.toString(Player.HeavyDamageModifier) + "\n");
                                Save.write(Integer.toString(Player.Defense) + "\n");
                                Save.write(Integer.toString(Player.Gold) + "\n");
                                Save.write(Integer.toString(Player.Level) + "\n");
                                Save.write(Integer.toString(Player.Experience) + "\n");
                                Save.write(Integer.toString(Player.FloorsCleared) + "\n");
                                Save.write(Integer.toString(Player.Keys) + "\n");
                                Save.write(Integer.toString(Player.Kills) + "\n");
                                Save.close();
                                System.out.println("Game saved.");
                                Dungeon = new Dungeon(Player.FloorsCleared);
                            }
                            catch (Exception e){
                                System.out.println("Error saving game.");
                            }
                        }
                        else{
                            System.out.println("Maybe later...");
                        }    
                    }
                    else if (Dungeon.FloorGoal==1 && Player.Level >= Dungeon.Difficulty*2){
                        System.out.println("Through your growth the bindings on the door are loosened.");
                        Dungeon.FloorGoal=0;
                        System.out.println("The way deeper has opened.");
                    }
                    else if (Dungeon.FloorGoal==2 && Player.Keys >= Dungeon.Difficulty){
                        Player.Keys -= Dungeon.Difficulty;
                        System.out.println("The key/s fit perfectly in the lock/s.");
                        Dungeon.FloorGoal=0;
                        System.out.println("The way deeper has opened.");
                    }
                    else if (Dungeon.FloorGoal==3 && Player.Kills >= Dungeon.Difficulty*3){
                        System.out.println("The Dungeon is satisfied by your bloodshed.");
                        Dungeon.FloorGoal=0;
                        System.out.println("The way deeper has opened.");
                    }
                    else if (Dungeon.FloorGoal>3){//Boss.
                        System.out.println("A powerful foe blocks your path. You have no choice but to fight.");
                        if (Dungeon.FloorGoal==4){//Mini-boss.
                    Dungeon.ClearRoom();
                    int EnemyStrength=(int)Math.ceil(Dungeon.Difficulty*1.5);
                    int EnemyHealth=Dungeon.Difficulty*10;
                    int EnemyDefense=Dungeon.Difficulty+5;
                    int EnemyType=3;

                    System.out.println();
                    int PlayerDamage;
                    int EnemyDamage;
                    String MonsterName="";//Allows me to refer to the monster later.
                    if (EnemyType==1){//Monster
                        System.out.print("You encounter ");
                        int X = RandomInt(1, 10);
                        if (X==1){
                            System.out.println("A Slime!");
                            MonsterName="The Slime";
                        }
                        else if (X==2){
                            System.out.println("A Ghost");
                            MonsterName="The Ghost";
                        }
                        else if (X==3){
                            System.out.println("A Putrid Rat!");
                            MonsterName="The Rat";
                        }
                        else if (X==4){
                            System.out.println("A Goblin!");
                            MonsterName="The Goblin";
                        }
                        else if (X==5){
                            System.out.println("A Thief!");
                            MonsterName="The Thief";
                        }
                        else if (X==6){
                            System.out.println("A Bat Swarm!");
                            MonsterName="The Bats";
                        }
                        else if (X==7){
                            System.out.println("A Wlidcat");
                            MonsterName="The Wildcat";
                        }
                        else if (X==8){
                            System.out.println("A Undead Adventure!");
                            MonsterName="The Skeleton";
                        }
                        else if (X==9){
                            System.out.println("A Strangling Vine!");
                            MonsterName="The Plant";
                        }
                        else{
                            System.out.println("'MISSINGNO.'!");
                            MonsterName="The *&%$$#_*^%&^";
                        }
                        System.out.println("You ready for combat!");
                    }
                    else if (EnemyType==2){//Elite
                        System.out.print("You are suddenly ambushed by ");
                        int X = RandomInt(1, 7);
                        if (X==1){
                            System.out.println("A Killer Bunny!");
                            MonsterName="The Killer Bunny";
                        }
                        else if (X==2){
                            System.out.println("A Dark Mage!");
                            MonsterName="The Dark Mage";
                        }
                        else if (X==3){
                            System.out.println("A Troll!");
                            MonsterName="The Cave Troll";
                        }
                        else if (X==4){
                            System.out.println("A Whelpling!");
                            MonsterName="The Dragonnet";
                        }
                        else if (X==5){
                            System.out.println("A Chest Mimic!");
                            MonsterName="The Mimic";
                        }
                        else if (X==6){
                            System.out.println("A Fallen Knight!");
                            MonsterName="The Knight";
                        }
                        else{
                            System.out.println("A Giant Centipede!");
                            MonsterName="The Centipede";
                        } 
                        System.out.println("You recover in time to fight back!");
                    }       
                    else if (EnemyType==3){//Mini-boss
                        System.out.print("Your path is blocked by ");
                        int X = RandomInt(1, 5);
                        if (X==1){
                            System.out.println("Giant Enemy Crab!");
                            MonsterName="The 'Giant Enemy Crab!'";
                        }
                        else if (X==2){
                            System.out.println("A Living Wall!");
                            MonsterName="The Wall";
                        }
                        else if (X==3){
                            System.out.println("A Giant Mole!");
                            MonsterName="The Giant Mole";
                        }
                        else if (X==4){
                            System.out.println("A Large Serpent!");
                            MonsterName="The Snake";
                        }
                        else{
                            System.out.println("A Swarm of Spiders!");
                            MonsterName="The Spiders";
                        }
                        System.out.println("They won't go down without a fight! Neither will you!");
                    }
                    else if (EnemyType==4){//Boss
                        System.out.print("You come face to face with ");
                        int X = RandomInt(1, 3);
                        if (X==1){
                            System.out.println("A Young But Fierce Drake!");
                            MonsterName="The Young Dragon";
                        }
                        else if (X==2){
                            System.out.println("A Rock Golem!");
                            MonsterName="The Golem";
                        }
                        else{
                            System.out.println("A Necromancer.");
                            MonsterName="The Necromancer";
                        }
                        System.out.println("A fierce battle ensues!");
                    }
                    else if (EnemyType==5){//Final Boss
                        MonsterName="The Dragon";
                        System.out.println();
                        if (Player.FloorsCleared<21){//This is the first time fighting the Dragon this run.
                            System.out.println("The final challange stands before you");
                            System.out.println("The Dragon has been the cause of countless tragedies, the downfall of empires, and the end of heroes.");
                            System.out.println("You face the draconic scourge, the fearsome terror of the Seven Realms.");
                            System.out.println("The Feind of the Sky, Humanity's Green Scaled Plague.");
                            System.out.println("The Feared, the Destroyer, the Devourer, the End of All Things.");
                            System.out.println("This is it. Everything has lead to this final and ultimate battle.");
                            System.out.println("Against The Dragon.");
                            System.out.println("Blight_Blaze.");
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }
                        else if (Player.FloorsCleared<41){//First re-fight
                            System.out.println("Impossible... You killed the Dragon... But they stand before you once again.");
                            System.out.println("Blight_Blaze, the bane of your existence.");
                            System.out.println("He looks as menacing as ever, but you are stronger now.");
                            System.out.println("Unfortunately, you realize he has gotten stronger as well.");
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }
                        else if (Player.FloorsCleared<61){//Second re-fight
                            System.out.println("Depite all odds, both of you are still alive.");
                            System.out.println("Blight_Blaze gives you a look of pity. He sees the trap you are in. The infinite looping.");
                            System.out.println("He understands.");
                            System.out.println("After all... Isn't he trapped too?");
                            System.out.println();
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }
                        else {//Future re-fights
                            System.out.println("You face the Dragon once more.");
                            System.out.println("...");
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }

                    }
//fights are based on a system where both parties have three actions they can take that function like rock paper scissors.The player chooses an action and the enemy's action is randomly generated. The fight continues until either the player or the enemy's health drops to 0 or below.       
                    for (int z=0; z==0;){
                        System.out.println();
                        System.out.println("Enemy Health: " + EnemyHealth);
                        System.out.println("Your Health: " + Player.Health + "/" + Player.MaxHealth);
                        System.out.println("Choose your action: Light Attack, Heavy Attack, Block");
                        System.out.println();
                        String Combat = Input.nextLine();
                        int PlayerAction = 0;
                        if (Combat.equals("Light Attack") || Combat.equals("light attack") || Combat.equals("L") || Combat.equals("l") || Combat.equals("Light") || Combat.equals("light")){
                            PlayerAction = 1;
                        }
                        else if (Combat.equals("Heavy Attack") || Combat.equals("heavy attack") || Combat.equals("H") || Combat.equals("h") || Combat.equals("Heavy") || Combat.equals("heavy")){
                            PlayerAction = 2;
                        }
                        else if (Combat.equals("Block") || Combat.equals("block") || Combat.equals("B") || Combat.equals("b")){
                            PlayerAction = 3;
                        }
                        else{
                            System.out.println("Invalid action. Please choose Light Attack, Heavy Attack, or Block.");
                            continue;
                        }
                        System.out.println();
//Enemy turn
                        int EnemyAction=0;
                        if (EnemyType==1){//Monster
                            int Y=RandomInt(1,5);
                            if (Y<3){//light
                                EnemyAction=1;
                            }
                            else if (Y==3){//heavy
                                EnemyAction=2;
                            }
                                else{//block
                                EnemyAction=3;
                            }
                        }
                        else if (EnemyType==2){//Elite
                            int Y=RandomInt(1,4);
                            if (Y==1){//light
                                EnemyAction=1;
                            }
                            else if (Y<4){//heavy
                                EnemyAction=2;
                            }
                            else{//block
                                EnemyAction=3;
                            }
                        }
                        else if (EnemyType==3){//Mini
                            int Y=RandomInt(1,5);
                            if (Y<3){//light
                                EnemyAction=1;
                            }
                            else if (Y==3){//heavy
                                EnemyAction=2;
                            }
                            else if (Y==4){//block
                                EnemyAction=3;
                            }
                            else{//Special
                                EnemyAction=4;
                            }
                        }
                        else if (EnemyType==4){//Boss
                            int Y=RandomInt(1,6);
                            if (Y==1){//light
                                EnemyAction=1;
                            }
                            else if (Y==2){//heavy
                                EnemyAction=2;
                            }
                            else if (Y==3){//block
                                EnemyAction=3;
                            }
                            else if (Y<6){//Special
                                EnemyAction=4;
                            }
                            else{//Other Special
                                EnemyAction=5;
                            }
                        }
                        else {//Dragon
                            int Y = RandomInt(1, 18);
                            if (Y<4){//Light
                                EnemyAction=1;
                            }
                            else if (Y<8){//Heavy
                                EnemyAction=2;
                            }
                            else if (Y<11){//Block
                                EnemyAction=3;
                            }
                            else if (Y<13){//Special
                                EnemyAction=4;
                            }
                            else if (Y<15){//Other Special
                                EnemyAction=5;
                            }
                            else{//Dragon Special
                                EnemyAction=6;
                            }
                        }
//Resolve Round of Combat.
                        if (PlayerAction==1){//Light
                            if (EnemyAction==1){//Light
                                PlayerDamage = Player.Strength + Player.LightDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("You Slash At " + MonsterName + "! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;
                                EnemyDamage= EnemyStrength - ((int)Math.floor(Player.Defense/2));
                                System.out.println("They Strike Back For " + EnemyDamage + " Points of Damage!");
                                Player.Health-=EnemyDamage;
                            }
                            else if (EnemyAction==2){//Heavy
                                PlayerDamage = Player.Strength + Player.LightDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("You Slash At " + MonsterName + "! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;
                                System.out.println("They Were Staggered and Can't Attack!");
                            }
                            else if (EnemyAction==3){//Block
                                System.out.println("You Attack! However " + MonsterName + " Parried Your Attack!");
                                System.out.println("They Reposte For " + EnemyStrength + " Points of Damage!");
                                Player.Health-=EnemyStrength;
                            }
                            else{//Special
                                PlayerDamage = Player.Strength + Player.LightDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("You Slash At " + MonsterName + "! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;

                            if (EnemyAction==4){//Heal
                                    System.out.println(MonsterName + " Regenerates " + Dungeon.Difficulty + " Health!");
                                    EnemyHealth+=Dungeon.Difficulty;
                                }
                                else if (EnemyAction==5){//Buff
                                    System.out.println(MonsterName + " Grows Stronger!");
                                    EnemyStrength+=((int)Math.floor(Dungeon.Difficulty/2));
                                    EnemyDefense+=((int)Math.floor(Dungeon.Difficulty/3));
                                }
                                else{//Fire-Ball
                                    System.out.println("The Dragon Spits A Fireball At You!");
                                    System.out.println("You Take " + Dungeon.Difficulty + " Points of Burning Damage.");
                                    Player.Health-=Dungeon.Difficulty;
                                }
                            }
                        }
                        else if (PlayerAction==2){//Heavy
                            if (EnemyAction==1){//Light
                                EnemyDamage= EnemyStrength - ((int)Math.floor(Player.Defense/2));
                                System.out.println(MonsterName + " Strikes You For " + EnemyDamage + " Points of Damage!");
                                Player.Health-=EnemyDamage;
                                System.out.println("You Were Staggered and Can't Attack!");
                            }
                            else if (EnemyAction==2){//Heavy
                                PlayerDamage= ((int)Math.floor(Player.Strength*1.5)) + Player.HeavyDamageModifier - ((int)Math.floor(EnemyDefense/3));
                                System.out.println("You Strike " + MonsterName + " With a Heavy Blow! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;
                                EnemyDamage= ((int)Math.floor(EnemyStrength*1.5)) - ((int)Math.floor(Player.Defense/3));
                                System.out.println("They Respond With an Attack of Their Own For " + EnemyDamage + " Points of Damage");
                                Player.Health-=EnemyDamage;
                            }       
                            else if (EnemyAction==3){//Block
                                PlayerDamage= ((int)Math.floor(Player.Strength*1.5)) + Player.HeavyDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("Your Heavy Strike Pierces " + MonsterName + "'s Defense!");
                                System.out.println("You Deal " + PlayerDamage + " Points of Dammage!");
                                EnemyHealth-=PlayerDamage;
                            }
                            else{//Special
                                PlayerDamage= ((int)Math.floor(Player.Strength*1.5)) + Player.HeavyDamageModifier - ((int)Math.floor(EnemyDefense/3));
                                System.out.println("You Strike " + MonsterName + " With a Heavy Blow! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;

                                if (EnemyAction==4){//Heal
                                    System.out.println(MonsterName + " Regenerates " + Dungeon.Difficulty + " Health!");
                                    EnemyHealth+=Dungeon.Difficulty;
                                }
                                else if (EnemyAction==5){//Buff
                                    System.out.println(MonsterName + " Grows Stronger!");
                                    EnemyStrength+=((int)Math.floor(Dungeon.Difficulty/2));
                                    EnemyDefense+=((int)Math.floor(Dungeon.Difficulty/3));
                                }
                                else{//Fire-Ball
                                    System.out.println("The Dragon Spits A Fireball At You!");
                                    System.out.println("You Take " + Dungeon.Difficulty + " Points of Burning Damage.");
                                    Player.Health-=Dungeon.Difficulty;
                                }
                            }
                        }
                        else{//Block
                            if (EnemyAction==1){//Light
                                System.out.println("You Parry " + MonsterName + "'s Attack!");
                                System.out.println("You Reposte For " + Player.Strength + " Points of Damage!");
                                EnemyHealth-=Player.Strength;
                            }
                            else if (EnemyAction==2){//Heavy
                                EnemyDamage = ((int)Math.floor(EnemyStrength*1.5)) - ((int)Math.floor(Player.Defense/2));
                                System.out.println("You Block But Are Unable to Parry " + MonsterName  + "'s Heavy Blow!");
                                System.out.println("You Are Hit For " + EnemyDamage + " Points of Damage!");
                                Player.Health-=EnemyDamage;
                            }
                            else if (EnemyAction==3){//Block
                                System.out.println("You Block at the Same Time as " + MonsterName + "!");
                                System.out.println("You Both Look Stupid!");
                            }
                            else{//Special
                                System.out.println("You Block But " + MonsterName + " Used An Ability!");

                                if (EnemyAction==4){//Heal
                                    System.out.println(MonsterName + " Regenerates " + Dungeon.Difficulty + " Health!");
                                    EnemyHealth+=Dungeon.Difficulty;
                                }
                                else if (EnemyAction==5){//Buff
                                    System.out.println(MonsterName + " Grows Stronger!");
                                    EnemyStrength+=((int)Math.floor(Dungeon.Difficulty/2));
                                    EnemyDefense+=((int)Math.floor(Dungeon.Difficulty/3));
                                }
                                else{//Fire-Ball
                                    System.out.println("The Dragon Spits A Fireball At You!");
                                    System.out.println("You Take " + Dungeon.Difficulty + " Points of Burning Damage.");
                                    Player.Health-=Dungeon.Difficulty;
                                }
                            }
                        }
                        System.out.println();
//Check For Death
                        if (Player.Health<=0){//Player Death overrides monster death.
                            System.out.println("After a particularly nasty blow, you fall unconscious!");
                            z=1;
                        }
                        else if (EnemyHealth<=0){//Enemy Death
                            if (EnemyType<3){
                                Player.Kills++;
                                System.out.println("You deal a final blow and finish off your opponent!");
                            }
                            int XP=(int) Math.pow(10, EnemyType);
                            Player.Gold+=((EnemyType+1)*(Dungeon.Difficulty+1));
                            System.out.println("You Gained " + ((EnemyType+1)*(Dungeon.Difficulty+1)) + " Gold!");
                            Player.GainEXP((int)Math.ceil(XP)*(Dungeon.Difficulty));//You get more XP on deeper floors, but less as you level up.
                            z=1;
                        }
                    }
                        }
                        else if (Dungeon.FloorGoal==5){//Boss.
                    Dungeon.ClearRoom();
                    int EnemyStrength=(int)Math.ceil(Dungeon.Difficulty*2.5);
                    int EnemyHealth=Dungeon.Difficulty*15;
                    int EnemyDefense=Dungeon.Difficulty+10;
                    int EnemyType=4;

                    System.out.println();
                    int PlayerDamage;
                    int EnemyDamage;
                    String MonsterName="";//Allows me to refer to the monster later.
                    if (EnemyType==1){//Monster
                        System.out.print("You encounter ");
                        int X = RandomInt(1, 10);
                        if (X==1){
                            System.out.println("A Slime!");
                            MonsterName="The Slime";
                        }
                        else if (X==2){
                            System.out.println("A Ghost");
                            MonsterName="The Ghost";
                        }
                        else if (X==3){
                            System.out.println("A Putrid Rat!");
                            MonsterName="The Rat";
                        }
                        else if (X==4){
                            System.out.println("A Goblin!");
                            MonsterName="The Goblin";
                        }
                        else if (X==5){
                            System.out.println("A Thief!");
                            MonsterName="The Thief";
                        }
                        else if (X==6){
                            System.out.println("A Bat Swarm!");
                            MonsterName="The Bats";
                        }
                        else if (X==7){
                            System.out.println("A Wlidcat");
                            MonsterName="The Wildcat";
                        }
                        else if (X==8){
                            System.out.println("A Undead Adventure!");
                            MonsterName="The Skeleton";
                        }
                        else if (X==9){
                            System.out.println("A Strangling Vine!");
                            MonsterName="The Plant";
                        }
                        else{
                            System.out.println("'MISSINGNO.'!");
                            MonsterName="The *&%$$#_*^%&^";
                        }
                        System.out.println("You ready for combat!");
                    }
                    else if (EnemyType==2){//Elite
                        System.out.print("You are suddenly ambushed by ");
                        int X = RandomInt(1, 7);
                        if (X==1){
                            System.out.println("A Killer Bunny!");
                            MonsterName="The Killer Bunny";
                        }
                        else if (X==2){
                            System.out.println("A Dark Mage!");
                            MonsterName="The Dark Mage";
                        }
                        else if (X==3){
                            System.out.println("A Troll!");
                            MonsterName="The Cave Troll";
                        }
                        else if (X==4){
                            System.out.println("A Whelpling!");
                            MonsterName="The Dragonnet";
                        }
                        else if (X==5){
                            System.out.println("A Chest Mimic!");
                            MonsterName="The Mimic";
                        }
                        else if (X==6){
                            System.out.println("A Fallen Knight!");
                            MonsterName="The Knight";
                        }
                        else{
                            System.out.println("A Giant Centipede!");
                            MonsterName="The Centipede";
                        } 
                        System.out.println("You recover in time to fight back!");
                    }       
                    else if (EnemyType==3){//Mini-boss
                        System.out.print("Your path is blocked by ");
                        int X = RandomInt(1, 5);
                        if (X==1){
                            System.out.println("Giant Enemy Crab!");
                            MonsterName="The 'Giant Enemy Crab!'";
                        }
                        else if (X==2){
                            System.out.println("A Living Wall!");
                            MonsterName="The Wall";
                        }
                        else if (X==3){
                            System.out.println("A Giant Mole!");
                            MonsterName="The Giant Mole";
                        }
                        else if (X==4){
                            System.out.println("A Large Serpent!");
                            MonsterName="The Snake";
                        }
                        else{
                            System.out.println("A Swarm of Spiders!");
                            MonsterName="The Spiders";
                        }
                        System.out.println("They won't go down without a fight! Neither will you!");
                    }
                    else if (EnemyType==4){//Boss
                        System.out.print("You come face to face with ");
                        int X = RandomInt(1, 3);
                        if (X==1){
                            System.out.println("A Young But Fierce Drake!");
                            MonsterName="The Young Dragon";
                        }
                        else if (X==2){
                            System.out.println("A Rock Golem!");
                            MonsterName="The Golem";
                        }
                        else{
                            System.out.println("A Necromancer.");
                            MonsterName="The Necromancer";
                        }
                        System.out.println("A fierce battle ensues!");
                    }
                    else if (EnemyType==5){//Final Boss
                        MonsterName="The Dragon";
                        System.out.println();
                        if (Player.FloorsCleared<21){//This is the first time fighting the Dragon this run.
                            System.out.println("The final challange stands before you");
                            System.out.println("The Dragon has been the cause of countless tragedies, the downfall of empires, and the end of heroes.");
                            System.out.println("You face the draconic scourge, the fearsome terror of the Seven Realms.");
                            System.out.println("The Feind of the Sky, Humanity's Green Scaled Plague.");
                            System.out.println("The Feared, the Destroyer, the Devourer, the End of All Things.");
                            System.out.println("This is it. Everything has lead to this final and ultimate battle.");
                            System.out.println("Against The Dragon.");
                            System.out.println("Blight_Blaze.");
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }
                        else if (Player.FloorsCleared<41){//First re-fight
                            System.out.println("Impossible... You killed the Dragon... But they stand before you once again.");
                            System.out.println("Blight_Blaze, the bane of your existence.");
                            System.out.println("He looks as menacing as ever, but you are stronger now.");
                            System.out.println("Unfortunately, you realize he has gotten stronger as well.");
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }
                        else if (Player.FloorsCleared<61){//Second re-fight
                            System.out.println("Depite all odds, both of you are still alive.");
                            System.out.println("Blight_Blaze gives you a look of pity. He sees the trap you are in. The infinite looping.");
                            System.out.println("He understands.");
                            System.out.println("After all... Isn't he trapped too?");
                            System.out.println();
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }
                        else {//Future re-fights
                            System.out.println("You face the Dragon once more.");
                            System.out.println("...");
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }

                    }
//fights are based on a system where both parties have three actions they can take that function like rock paper scissors.The player chooses an action and the enemy's action is randomly generated. The fight continues until either the player or the enemy's health drops to 0 or below.       
                    for (int z=0; z==0;){
                        System.out.println();
                        System.out.println("Enemy Health: " + EnemyHealth);
                        System.out.println("Your Health: " + Player.Health + "/" + Player.MaxHealth);
                        System.out.println("Choose your action: Light Attack, Heavy Attack, Block");
                        System.out.println();
                        String Combat = Input.nextLine();
                        int PlayerAction = 0;
                        if (Combat.equals("Light Attack") || Combat.equals("light attack") || Combat.equals("L") || Combat.equals("l") || Combat.equals("Light") || Combat.equals("light")){
                            PlayerAction = 1;
                        }
                        else if (Combat.equals("Heavy Attack") || Combat.equals("heavy attack") || Combat.equals("H") || Combat.equals("h") || Combat.equals("Heavy") || Combat.equals("heavy")){
                            PlayerAction = 2;
                        }
                        else if (Combat.equals("Block") || Combat.equals("block") || Combat.equals("B") || Combat.equals("b")){
                            PlayerAction = 3;
                        }
                        else{
                            System.out.println("Invalid action. Please choose Light Attack, Heavy Attack, or Block.");
                            continue;
                        }
                        System.out.println();
//Enemy turn
                        int EnemyAction=0;
                        if (EnemyType==1){//Monster
                            int Y=RandomInt(1,5);
                            if (Y<3){//light
                                EnemyAction=1;
                            }
                            else if (Y==3){//heavy
                                EnemyAction=2;
                            }
                                else{//block
                                EnemyAction=3;
                            }
                        }
                        else if (EnemyType==2){//Elite
                            int Y=RandomInt(1,4);
                            if (Y==1){//light
                                EnemyAction=1;
                            }
                            else if (Y<4){//heavy
                                EnemyAction=2;
                            }
                            else{//block
                                EnemyAction=3;
                            }
                        }
                        else if (EnemyType==3){//Mini
                            int Y=RandomInt(1,5);
                            if (Y<3){//light
                                EnemyAction=1;
                            }
                            else if (Y==3){//heavy
                                EnemyAction=2;
                            }
                            else if (Y==4){//block
                                EnemyAction=3;
                            }
                            else{//Special
                                EnemyAction=4;
                            }
                        }
                        else if (EnemyType==4){//Boss
                            int Y=RandomInt(1,6);
                            if (Y==1){//light
                                EnemyAction=1;
                            }
                            else if (Y==2){//heavy
                                EnemyAction=2;
                            }
                            else if (Y==3){//block
                                EnemyAction=3;
                            }
                            else if (Y<6){//Special
                                EnemyAction=4;
                            }
                            else{//Other Special
                                EnemyAction=5;
                            }
                        }
                        else {//Dragon
                            int Y = RandomInt(1, 18);
                            if (Y<4){//Light
                                EnemyAction=1;
                            }
                            else if (Y<8){//Heavy
                                EnemyAction=2;
                            }
                            else if (Y<11){//Block
                                EnemyAction=3;
                            }
                            else if (Y<13){//Special
                                EnemyAction=4;
                            }
                            else if (Y<15){//Other Special
                                EnemyAction=5;
                            }
                            else{//Dragon Special
                                EnemyAction=6;
                            }
                        }
//Resolve Round of Combat.
                        if (PlayerAction==1){//Light
                            if (EnemyAction==1){//Light
                                PlayerDamage = Player.Strength + Player.LightDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("You Slash At " + MonsterName + "! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;
                                EnemyDamage= EnemyStrength - ((int)Math.floor(Player.Defense/2));
                                System.out.println("They Strike Back For " + EnemyDamage + " Points of Damage!");
                                Player.Health-=EnemyDamage;
                            }
                            else if (EnemyAction==2){//Heavy
                                PlayerDamage = Player.Strength + Player.LightDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("You Slash At " + MonsterName + "! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;
                                System.out.println("They Were Staggered and Can't Attack!");
                            }
                            else if (EnemyAction==3){//Block
                                System.out.println("You Attack! However " + MonsterName + " Parried Your Attack!");
                                System.out.println("They Reposte For " + EnemyStrength + " Points of Damage!");
                                Player.Health-=EnemyStrength;
                            }
                            else{//Special
                                PlayerDamage = Player.Strength + Player.LightDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("You Slash At " + MonsterName + "! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;

                            if (EnemyAction==4){//Heal
                                    System.out.println(MonsterName + " Regenerates " + Dungeon.Difficulty + " Health!");
                                    EnemyHealth+=Dungeon.Difficulty;
                                }
                                else if (EnemyAction==5){//Buff
                                    System.out.println(MonsterName + " Grows Stronger!");
                                    EnemyStrength+=((int)Math.floor(Dungeon.Difficulty/2));
                                    EnemyDefense+=((int)Math.floor(Dungeon.Difficulty/3));
                                }
                                else{//Fire-Ball
                                    System.out.println("The Dragon Spits A Fireball At You!");
                                    System.out.println("You Take " + Dungeon.Difficulty + " Points of Burning Damage.");
                                    Player.Health-=Dungeon.Difficulty;
                                }
                            }
                        }
                        else if (PlayerAction==2){//Heavy
                            if (EnemyAction==1){//Light
                                EnemyDamage= EnemyStrength - ((int)Math.floor(Player.Defense/2));
                                System.out.println(MonsterName + " Strikes You For " + EnemyDamage + " Points of Damage!");
                                Player.Health-=EnemyDamage;
                                System.out.println("You Were Staggered and Can't Attack!");
                            }
                            else if (EnemyAction==2){//Heavy
                                PlayerDamage= ((int)Math.floor(Player.Strength*1.5)) + Player.HeavyDamageModifier - ((int)Math.floor(EnemyDefense/3));
                                System.out.println("You Strike " + MonsterName + " With a Heavy Blow! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;
                                EnemyDamage= ((int)Math.floor(EnemyStrength*1.5)) - ((int)Math.floor(Player.Defense/3));
                                System.out.println("They Respond With an Attack of Their Own For " + EnemyDamage + " Points of Damage");
                                Player.Health-=EnemyDamage;
                            }       
                            else if (EnemyAction==3){//Block
                                PlayerDamage= ((int)Math.floor(Player.Strength*1.5)) + Player.HeavyDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("Your Heavy Strike Pierces " + MonsterName + "'s Defense!");
                                System.out.println("You Deal " + PlayerDamage + " Points of Dammage!");
                                EnemyHealth-=PlayerDamage;
                            }
                            else{//Special
                                PlayerDamage= ((int)Math.floor(Player.Strength*1.5)) + Player.HeavyDamageModifier - ((int)Math.floor(EnemyDefense/3));
                                System.out.println("You Strike " + MonsterName + " With a Heavy Blow! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;

                                if (EnemyAction==4){//Heal
                                    System.out.println(MonsterName + " Regenerates " + Dungeon.Difficulty + " Health!");
                                    EnemyHealth+=Dungeon.Difficulty;
                                }
                                else if (EnemyAction==5){//Buff
                                    System.out.println(MonsterName + " Grows Stronger!");
                                    EnemyStrength+=((int)Math.floor(Dungeon.Difficulty/2));
                                    EnemyDefense+=((int)Math.floor(Dungeon.Difficulty/3));
                                }
                                else{//Fire-Ball
                                    System.out.println("The Dragon Spits A Fireball At You!");
                                    System.out.println("You Take " + Dungeon.Difficulty + " Points of Burning Damage.");
                                    Player.Health-=Dungeon.Difficulty;
                                }
                            }
                        }
                        else{//Block
                            if (EnemyAction==1){//Light
                                System.out.println("You Parry " + MonsterName + "'s Attack!");
                                System.out.println("You Reposte For " + Player.Strength + " Points of Damage!");
                                EnemyHealth-=Player.Strength;
                            }
                            else if (EnemyAction==2){//Heavy
                                EnemyDamage = ((int)Math.floor(EnemyStrength*1.5)) - ((int)Math.floor(Player.Defense/2));
                                System.out.println("You Block But Are Unable to Parry " + MonsterName  + "'s Heavy Blow!");
                                System.out.println("You Are Hit For " + EnemyDamage + " Points of Damage!");
                                Player.Health-=EnemyDamage;
                            }
                            else if (EnemyAction==3){//Block
                                System.out.println("You Block at the Same Time as " + MonsterName + "!");
                                System.out.println("You Both Look Stupid!");
                            }
                            else{//Special
                                System.out.println("You Block But " + MonsterName + " Used An Ability!");

                                if (EnemyAction==4){//Heal
                                    System.out.println(MonsterName + " Regenerates " + Dungeon.Difficulty + " Health!");
                                    EnemyHealth+=Dungeon.Difficulty;
                                }
                                else if (EnemyAction==5){//Buff
                                    System.out.println(MonsterName + " Grows Stronger!");
                                    EnemyStrength+=((int)Math.floor(Dungeon.Difficulty/2));
                                    EnemyDefense+=((int)Math.floor(Dungeon.Difficulty/3));
                                }
                                else{//Fire-Ball
                                    System.out.println("The Dragon Spits A Fireball At You!");
                                    System.out.println("You Take " + Dungeon.Difficulty + " Points of Burning Damage.");
                                    Player.Health-=Dungeon.Difficulty;
                                }
                            }
                        }
                        System.out.println();
//Check For Death
                        if (Player.Health<=0){//Player Death overrides monster death.
                            System.out.println("After a particularly nasty blow, you fall unconscious!");
                            z=1;
                        }
                        else if (EnemyHealth<=0){//Enemy Death
                            if (EnemyType<3){
                                Player.Kills++;
                                System.out.println("You deal a final blow and finish off your opponent!");
                            }
                            int XP=(int) Math.pow(10, EnemyType);
                            Player.Gold+=((EnemyType+1)*(Dungeon.Difficulty+1));
                            System.out.println("You Gained " + ((EnemyType+1)*(Dungeon.Difficulty+1)) + " Gold!");
                            Player.GainEXP((int)Math.ceil(XP)*(Dungeon.Difficulty));//You get more XP on deeper floors, but less as you level up.
                            z=1;
                        }
                    }
                        }
                        else{//Final boss.
                    Dungeon.ClearRoom();
                    int EnemyStrength=Dungeon.Difficulty*3;
                    int EnemyHealth=Dungeon.Difficulty*30;
                    int EnemyDefense=Dungeon.Difficulty+15;
                    int EnemyType=5;

                    System.out.println();
                    int PlayerDamage;
                    int EnemyDamage;
                    String MonsterName="";//Allows me to refer to the monster later.
                    if (EnemyType==1){//Monster
                        System.out.print("You encounter ");
                        int X = RandomInt(1, 10);
                        if (X==1){
                            System.out.println("A Slime!");
                            MonsterName="The Slime";
                        }
                        else if (X==2){
                            System.out.println("A Ghost");
                            MonsterName="The Ghost";
                        }
                        else if (X==3){
                            System.out.println("A Putrid Rat!");
                            MonsterName="The Rat";
                        }
                        else if (X==4){
                            System.out.println("A Goblin!");
                            MonsterName="The Goblin";
                        }
                        else if (X==5){
                            System.out.println("A Thief!");
                            MonsterName="The Thief";
                        }
                        else if (X==6){
                            System.out.println("A Bat Swarm!");
                            MonsterName="The Bats";
                        }
                        else if (X==7){
                            System.out.println("A Wlidcat");
                            MonsterName="The Wildcat";
                        }
                        else if (X==8){
                            System.out.println("A Undead Adventure!");
                            MonsterName="The Skeleton";
                        }
                        else if (X==9){
                            System.out.println("A Strangling Vine!");
                            MonsterName="The Plant";
                        }
                        else{
                            System.out.println("'MISSINGNO.'!");
                            MonsterName="The *&%$$#_*^%&^";
                        }
                        System.out.println("You ready for combat!");
                    }
                    else if (EnemyType==2){//Elite
                        System.out.print("You are suddenly ambushed by ");
                        int X = RandomInt(1, 7);
                        if (X==1){
                            System.out.println("A Killer Bunny!");
                            MonsterName="The Killer Bunny";
                        }
                        else if (X==2){
                            System.out.println("A Dark Mage!");
                            MonsterName="The Dark Mage";
                        }
                        else if (X==3){
                            System.out.println("A Troll!");
                            MonsterName="The Cave Troll";
                        }
                        else if (X==4){
                            System.out.println("A Whelpling!");
                            MonsterName="The Dragonnet";
                        }
                        else if (X==5){
                            System.out.println("A Chest Mimic!");
                            MonsterName="The Mimic";
                        }
                        else if (X==6){
                            System.out.println("A Fallen Knight!");
                            MonsterName="The Knight";
                        }
                        else{
                            System.out.println("A Giant Centipede!");
                            MonsterName="The Centipede";
                        } 
                        System.out.println("You recover in time to fight back!");
                    }       
                    else if (EnemyType==3){//Mini-boss
                        System.out.print("Your path is blocked by ");
                        int X = RandomInt(1, 5);
                        if (X==1){
                            System.out.println("Giant Enemy Crab!");
                            MonsterName="The 'Giant Enemy Crab!'";
                        }
                        else if (X==2){
                            System.out.println("A Living Wall!");
                            MonsterName="The Wall";
                        }
                        else if (X==3){
                            System.out.println("A Giant Mole!");
                            MonsterName="The Giant Mole";
                        }
                        else if (X==4){
                            System.out.println("A Large Serpent!");
                            MonsterName="The Snake";
                        }
                        else{
                            System.out.println("A Swarm of Spiders!");
                            MonsterName="The Spiders";
                        }
                        System.out.println("They won't go down without a fight! Neither will you!");
                    }
                    else if (EnemyType==4){//Boss
                        System.out.print("You come face to face with ");
                        int X = RandomInt(1, 3);
                        if (X==1){
                            System.out.println("A Young But Fierce Drake!");
                            MonsterName="The Young Dragon";
                        }
                        else if (X==2){
                            System.out.println("A Rock Golem!");
                            MonsterName="The Golem";
                        }
                        else{
                            System.out.println("A Necromancer.");
                            MonsterName="The Necromancer";
                        }
                        System.out.println("A fierce battle ensues!");
                    }
                    else if (EnemyType==5){//Final Boss
                        MonsterName="The Dragon";
                        System.out.println();
                        if (Player.FloorsCleared<21){//This is the first time fighting the Dragon this run.
                            System.out.println("The final challange stands before you");
                            System.out.println("The Dragon has been the cause of countless tragedies, the downfall of empires, and the end of heroes.");
                            System.out.println("You face the draconic scourge, the fearsome terror of the Seven Realms.");
                            System.out.println("The Feind of the Sky, Humanity's Green Scaled Plague.");
                            System.out.println("The Feared, the Destroyer, the Devourer, the End of All Things.");
                            System.out.println("This is it. Everything has lead to this final and ultimate battle.");
                            System.out.println("Against The Dragon.");
                            System.out.println("Blight_Blaze.");
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }
                        else if (Player.FloorsCleared<41){//First re-fight
                            System.out.println("Impossible... You killed the Dragon... But they stand before you once again.");
                            System.out.println("Blight_Blaze, the bane of your existence.");
                            System.out.println("He looks as menacing as ever, but you are stronger now.");
                            System.out.println("Unfortunately, you realize he has gotten stronger as well.");
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }
                        else if (Player.FloorsCleared<61){//Second re-fight
                            System.out.println("Depite all odds, both of you are still alive.");
                            System.out.println("Blight_Blaze gives you a look of pity. He sees the trap you are in. The infinite looping.");
                            System.out.println("He understands.");
                            System.out.println("After all... Isn't he trapped too?");
                            System.out.println();
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }
                        else {//Future re-fights
                            System.out.println("You face the Dragon once more.");
                            System.out.println("...");
                            System.out.println("You steel yourself for the fight ahead.");
                            System.out.println();
                        }

                    }
//fights are based on a system where both parties have three actions they can take that function like rock paper scissors.The player chooses an action and the enemy's action is randomly generated. The fight continues until either the player or the enemy's health drops to 0 or below.       
                    for (int z=0; z==0;){
                        System.out.println();
                        System.out.println("Enemy Health: " + EnemyHealth);
                        System.out.println("Your Health: " + Player.Health + "/" + Player.MaxHealth);
                        System.out.println("Choose your action: Light Attack, Heavy Attack, Block");
                        System.out.println();
                        String Combat = Input.nextLine();
                        int PlayerAction = 0;
                        if (Combat.equals("Light Attack") || Combat.equals("light attack") || Combat.equals("L") || Combat.equals("l") || Combat.equals("Light") || Combat.equals("light")){
                            PlayerAction = 1;
                        }
                        else if (Combat.equals("Heavy Attack") || Combat.equals("heavy attack") || Combat.equals("H") || Combat.equals("h") || Combat.equals("Heavy") || Combat.equals("heavy")){
                            PlayerAction = 2;
                        }
                        else if (Combat.equals("Block") || Combat.equals("block") || Combat.equals("B") || Combat.equals("b")){
                            PlayerAction = 3;
                        }
                        else{
                            System.out.println("Invalid action. Please choose Light Attack, Heavy Attack, or Block.");
                            continue;
                        }
                        System.out.println();
//Enemy turn
                        int EnemyAction=0;
                        if (EnemyType==1){//Monster
                            int Y=RandomInt(1,5);
                            if (Y<3){//light
                                EnemyAction=1;
                            }
                            else if (Y==3){//heavy
                                EnemyAction=2;
                            }
                                else{//block
                                EnemyAction=3;
                            }
                        }
                        else if (EnemyType==2){//Elite
                            int Y=RandomInt(1,4);
                            if (Y==1){//light
                                EnemyAction=1;
                            }
                            else if (Y<4){//heavy
                                EnemyAction=2;
                            }
                            else{//block
                                EnemyAction=3;
                            }
                        }
                        else if (EnemyType==3){//Mini
                            int Y=RandomInt(1,5);
                            if (Y<3){//light
                                EnemyAction=1;
                            }
                            else if (Y==3){//heavy
                                EnemyAction=2;
                            }
                            else if (Y==4){//block
                                EnemyAction=3;
                            }
                            else{//Special
                                EnemyAction=4;
                            }
                        }
                        else if (EnemyType==4){//Boss
                            int Y=RandomInt(1,6);
                            if (Y==1){//light
                                EnemyAction=1;
                            }
                            else if (Y==2){//heavy
                                EnemyAction=2;
                            }
                            else if (Y==3){//block
                                EnemyAction=3;
                            }
                            else if (Y<6){//Special
                                EnemyAction=4;
                            }
                            else{//Other Special
                                EnemyAction=5;
                            }
                        }
                        else {//Dragon
                            int Y = RandomInt(1, 18);
                            if (Y<4){//Light
                                EnemyAction=1;
                            }
                            else if (Y<8){//Heavy
                                EnemyAction=2;
                            }
                            else if (Y<11){//Block
                                EnemyAction=3;
                            }
                            else if (Y<13){//Special
                                EnemyAction=4;
                            }
                            else if (Y<15){//Other Special
                                EnemyAction=5;
                            }
                            else{//Dragon Special
                                EnemyAction=6;
                            }
                        }
//Resolve Round of Combat.
                        if (PlayerAction==1){//Light
                            if (EnemyAction==1){//Light
                                PlayerDamage = Player.Strength + Player.LightDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("You Slash At " + MonsterName + "! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;
                                EnemyDamage= EnemyStrength - ((int)Math.floor(Player.Defense/2));
                                System.out.println("They Strike Back For " + EnemyDamage + " Points of Damage!");
                                Player.Health-=EnemyDamage;
                            }
                            else if (EnemyAction==2){//Heavy
                                PlayerDamage = Player.Strength + Player.LightDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("You Slash At " + MonsterName + "! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;
                                System.out.println("They Were Staggered and Can't Attack!");
                            }
                            else if (EnemyAction==3){//Block
                                System.out.println("You Attack! However " + MonsterName + " Parried Your Attack!");
                                System.out.println("They Reposte For " + EnemyStrength + " Points of Damage!");
                                Player.Health-=EnemyStrength;
                            }
                            else{//Special
                                PlayerDamage = Player.Strength + Player.LightDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("You Slash At " + MonsterName + "! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;

                            if (EnemyAction==4){//Heal
                                    System.out.println(MonsterName + " Regenerates " + Dungeon.Difficulty + " Health!");
                                    EnemyHealth+=Dungeon.Difficulty;
                                }
                                else if (EnemyAction==5){//Buff
                                    System.out.println(MonsterName + " Grows Stronger!");
                                    EnemyStrength+=((int)Math.floor(Dungeon.Difficulty/2));
                                    EnemyDefense+=((int)Math.floor(Dungeon.Difficulty/3));
                                }
                                else{//Fire-Ball
                                    System.out.println("The Dragon Spits A Fireball At You!");
                                    System.out.println("You Take " + Dungeon.Difficulty + " Points of Burning Damage.");
                                    Player.Health-=Dungeon.Difficulty;
                                }
                            }
                        }
                        else if (PlayerAction==2){//Heavy
                            if (EnemyAction==1){//Light
                                EnemyDamage= EnemyStrength - ((int)Math.floor(Player.Defense/2));
                                System.out.println(MonsterName + " Strikes You For " + EnemyDamage + " Points of Damage!");
                                Player.Health-=EnemyDamage;
                                System.out.println("You Were Staggered and Can't Attack!");
                            }
                            else if (EnemyAction==2){//Heavy
                                PlayerDamage= ((int)Math.floor(Player.Strength*1.5)) + Player.HeavyDamageModifier - ((int)Math.floor(EnemyDefense/3));
                                System.out.println("You Strike " + MonsterName + " With a Heavy Blow! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;
                                EnemyDamage= ((int)Math.floor(EnemyStrength*1.5)) - ((int)Math.floor(Player.Defense/3));
                                System.out.println("They Respond With an Attack of Their Own For " + EnemyDamage + " Points of Damage");
                                Player.Health-=EnemyDamage;
                            }       
                            else if (EnemyAction==3){//Block
                                PlayerDamage= ((int)Math.floor(Player.Strength*1.5)) + Player.HeavyDamageModifier - ((int)Math.floor(EnemyDefense/2));
                                System.out.println("Your Heavy Strike Pierces " + MonsterName + "'s Defense!");
                                System.out.println("You Deal " + PlayerDamage + " Points of Dammage!");
                                EnemyHealth-=PlayerDamage;
                            }
                            else{//Special
                                PlayerDamage= ((int)Math.floor(Player.Strength*1.5)) + Player.HeavyDamageModifier - ((int)Math.floor(EnemyDefense/3));
                                System.out.println("You Strike " + MonsterName + " With a Heavy Blow! You Deal " + PlayerDamage + " Points of Damage to Them!");
                                EnemyHealth-=PlayerDamage;

                                if (EnemyAction==4){//Heal
                                    System.out.println(MonsterName + " Regenerates " + Dungeon.Difficulty + " Health!");
                                    EnemyHealth+=Dungeon.Difficulty;
                                }
                                else if (EnemyAction==5){//Buff
                                    System.out.println(MonsterName + " Grows Stronger!");
                                    EnemyStrength+=((int)Math.floor(Dungeon.Difficulty/2));
                                    EnemyDefense+=((int)Math.floor(Dungeon.Difficulty/3));
                                }
                                else{//Fire-Ball
                                    System.out.println("The Dragon Spits A Fireball At You!");
                                    System.out.println("You Take " + Dungeon.Difficulty + " Points of Burning Damage.");
                                    Player.Health-=Dungeon.Difficulty;
                                }
                            }
                        }
                        else{//Block
                            if (EnemyAction==1){//Light
                                System.out.println("You Parry " + MonsterName + "'s Attack!");
                                System.out.println("You Reposte For " + Player.Strength + " Points of Damage!");
                                EnemyHealth-=Player.Strength;
                            }
                            else if (EnemyAction==2){//Heavy
                                EnemyDamage = ((int)Math.floor(EnemyStrength*1.5)) - ((int)Math.floor(Player.Defense/2));
                                System.out.println("You Block But Are Unable to Parry " + MonsterName  + "'s Heavy Blow!");
                                System.out.println("You Are Hit For " + EnemyDamage + " Points of Damage!");
                                Player.Health-=EnemyDamage;
                            }
                            else if (EnemyAction==3){//Block
                                System.out.println("You Block at the Same Time as " + MonsterName + "!");
                                System.out.println("You Both Look Stupid!");
                            }
                            else{//Special
                                System.out.println("You Block But " + MonsterName + " Used An Ability!");

                                if (EnemyAction==4){//Heal
                                    System.out.println(MonsterName + " Regenerates " + Dungeon.Difficulty + " Health!");
                                    EnemyHealth+=Dungeon.Difficulty;
                                }
                                else if (EnemyAction==5){//Buff
                                    System.out.println(MonsterName + " Grows Stronger!");
                                    EnemyStrength+=((int)Math.floor(Dungeon.Difficulty/2));
                                    EnemyDefense+=((int)Math.floor(Dungeon.Difficulty/3));
                                }
                                else{//Fire-Ball
                                    System.out.println("The Dragon Spits A Fireball At You!");
                                    System.out.println("You Take " + Dungeon.Difficulty + " Points of Burning Damage.");
                                    Player.Health-=Dungeon.Difficulty;
                                }
                            }
                        }
                        System.out.println();
//Check For Death
                        if (Player.Health<=0){//Player Death overrides monster death.
                            System.out.println("After a particularly nasty blow, you fall unconscious!");
                            z=1;
                        }
                        else if (EnemyHealth<=0){//Enemy Death
                            if (EnemyType<3){
                                Player.Kills++;
                                System.out.println("You deal a final blow and finish off your opponent!");
                            }
                            int XP=(int) Math.pow(10, EnemyType);
                            Player.Gold+=((EnemyType+1)*(Dungeon.Difficulty+1));
                            System.out.println("You Gained " + ((EnemyType+1)*(Dungeon.Difficulty+1)) + " Gold!");
                            Player.GainEXP((int)Math.ceil(XP)*(Dungeon.Difficulty));//You get more XP on deeper floors, but less as you level up.
                            z=1;
                        }
                    }
                        }
//After the fight, check if the player won or lost. If they won, open the way to the next floor. If they lost, end the game.
                        if (Player.Health > 0){
                            if (Player.FloorsCleared==20){//This is floor 20.
                                System.out.println();
                                System.out.println("You kneel on the floor gasping for breath and gazing at your hands stained in the dragon's blood.");
                                System.out.println("The beast is no more, the terror of the seven realms has breathed his last breath.");
                                System.out.println("As the dragon's corpse turns to dust, a sense of accomplishment and relief washes over you.");
                                System.out.println("You notice as the dust clears that there is a door in the back of the room that wasn't there before.");
                                System.out.println("You hear a roar from deeper in the dungeon, you thought you had destroyed the curse once and for all, but the Dungeon won't be defeated that easily.");
                                System.out.println();
                                System.out.println();
                                System.out.println("Congratulations! You have beaten the game!");
                                System.out.println("You are welcome to stop here or plunge deeper into the Dungeon to see just how far it truely goes...");
                                System.out.println("Enter the Code 'Sh0wM3' when asked to load a save for the secret menu.");
                                System.out.println();
                                System.out.println("Winning Stats:");
                                Player.Stats();
                                System.out.println();
                                System.out.println("Thank you for playing my game! I may add a true ending and more content in the future, but until then...");
                                
                            }
                            else{//Not floor 20.
                                System.out.println("After a hard fought battle, you emerge victorious.");
                                System.out.println("With your foe vanquished, the path is open.");
                            }
                            Dungeon.FloorGoal=0;
                            System.out.println("The way deeper has opened.");
                        }
                        else{
                            i=1;
                            System.out.println("Despite your valiant efforts, you were not able to best your adversary. Game Over.");
                        }


                    }
                    else{
                        System.out.println("The door downward is bound shut. Maybe it will open if you keep exploring...");
                    }
                }
                else{
                    System.out.println("There is no way down here.");
                }
            }
            else if (Action.equals("Help") || Action.equals("help")){//Prints a list of actions.
                System.out.println("Actions: N, S, E, W, Stats, Wait, Quit, Descend, Help.");
            }
            else{//Invalid action.
                System.out.println("Invalid action. Type 'Help' for a list of actions.");
            }
            if (Player.Health <= 0){
                i=1;
                System.out.println("You have fainted. Game Over.");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("The program has been terminated. Thanks for playing!");
        Input.close();
    }
}