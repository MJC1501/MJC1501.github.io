//import java.util.Scanner;
public class DungeonPlayer {
    public static int RandomInt (int Min, int Max){//random number generator.
        Max++;
        return (int)(Math.random() * (Max - Min) + Min);
    }
    int MaxHealth;//variables to store player stats. These will be loaded from the save file or generated for a new character.
    int Health;
    int Strength;
    int LightDamageModifier;
    int HeavyDamageModifier;
    int Defense;
    int Gold;
    int Level;
    int Experience;
    int FloorsCleared;
    int Keys;
    int Kills;

    DungeonPlayer(){}  
    
    public void Stats(){//Command to print player stats.
        System.out.println("Health: " + Health + "/" + MaxHealth);
        System.out.println("Strength: " + Strength);
        System.out.println("Light Damage Modifier: " + LightDamageModifier);
        System.out.println("Heavy Damage Modifier: " + HeavyDamageModifier);
        System.out.println("Defense: " + Defense);
        System.out.println("Gold: " + Gold);
        System.out.println("Level: " + Level);
        System.out.println("Experience: " + Experience);
        System.out.println("Floors Cleared: " + FloorsCleared);
        System.out.println("Keys: " + Keys);
        System.out.println("Kills: " + Kills);
    }

    public void GainEXP(int EXP){//Command to gain experience and level up if necessary.
        System.out.println("You gain: "+ EXP +" Experience!");
        Experience += EXP;
        int requirement = (int) Math.pow(5, Level);
        if (Experience >= requirement){
            Level++;
            System.out.println();
            System.out.println("You leveled up! You are now level " + Level + "!");
            MaxHealth += Level;//Max Health increses by your level.
            Health += Level;
            System.out.println("Health raised to " + Health + "/" + MaxHealth);
            Strength += (int)Math.ceil((double) Level/2);//Strength increses by half your level, rounded up.
            System.out.println("Strength raised to " + Strength);
            Defense += (int)Math.ceil((double) Level/3);//Defense increases by a third of your level, rounded up.
            System.out.println("Defense raised to " + Defense);
            System.out.println();
        }
        System.out.println("You now have " + Experience + "EXP");
        System.out.println((((int) Math.pow(5, Level)) - Experience) + "EXP until next level.");
    }

    //Deprecated
    /*public void Monster(int Difficulty){//Sets up a fight with a monster. Enemy stats are determined by the difficulty of the floor.
        Fight(Difficulty+2, (Difficulty+1)*5, RandomInt(Difficulty, Difficulty+5), 1, Difficulty);
    }
    
    public void Elite(int Difficulty){//Sets up a fight with an elite monster. Enemy stats are determined by the difficulty of the floor.
        Fight(Difficulty+5, (Difficulty+1)*10, RandomInt(Difficulty+5, Difficulty+10), 2, Difficulty);
    }*/
  
    //Deprecated
    /*public void Shop(int Difficulty){//Allows the player to buy upgrades. Prices are determined by the difficulty of the floor.
        Scanner Scanner = new Scanner(System.in);
        for (int i=0; i<Difficulty; i++){//You may purchase items up to the Diffculty of the floor.
            System.out.println("You have " + Gold + " Gold. You may purchase up to " + (Difficulty-i) + " more items.");
            System.out.println("0: Leave Shop");
            System.out.println("1: Increase Strength by 1 for " + (7*Difficulty) + " Gold.");
            System.out.println("2: Increase Light Damage Modifier by 1 for " + (2*Difficulty) + " Gold.");
            System.out.println("3: Increase Heavy Damage Modifier by 1 for " + (3*Difficulty) + " Gold.");
            System.out.println("4: Increase Defense by 1 for " + (5*Difficulty) + " Gold.");
            System.out.println("5: Increase Max Health by 5 for " + (10*Difficulty) + " Gold.");
            System.out.println("6: Buy 1 key for " + (15*Difficulty) + " Gold.");
            String choice = Scanner.nextLine();
            if (choice.equals("0")){
                break;
            }
            else if (choice.equals("1") && Gold >= (7*Difficulty)){
                Strength++;
                Gold -= (7*Difficulty);
                System.out.println("Strength increased to " + Strength + "!");
            }
            else if (choice.equals("2") && Gold >= (2*Difficulty)){
                LightDamageModifier++;
                Gold -= (2*Difficulty);
                System.out.println("Light Damage Modifier increased to " + LightDamageModifier + "!");
            }
            else if (choice.equals("3") && Gold >= (3*Difficulty)){
                HeavyDamageModifier++;
                Gold -= (3*Difficulty);
                System.out.println("Heavy Damage Modifier increased to " + HeavyDamageModifier + "!");
            }
            else if (choice.equals("4") && Gold >= (5*Difficulty)){
                Defense++;
                Gold -= (5*Difficulty);
                System.out.println("Defense increased to " + Defense + "!");
            }
            else if (choice.equals("5") && Gold >= (10*Difficulty)){
                MaxHealth += 5;
                Health += 5;
                Gold -= (10*Difficulty);
                System.out.println("Max Health increased to " + MaxHealth + "! Health increased to " + Health + "!");
            }
            else if (choice.equals("6") && Gold >= (15*Difficulty)){
                Keys++;
                Gold -= (15*Difficulty);
                System.out.println("You bought a key! You now have " + Keys + " keys.");
            }
            else{
                System.out.println("Invalid choice or not enough gold.");
            }
            System.out.println();
        }
        System.out.println("The Shopkepper packs up and leaves.");
        Scanner.close();
    }*/
    
    public void Treasure(int Difficulty){//Gives the player a random reward based on the difficulty of the floor.
        if (RandomInt(0, 2)==0){// 1/3 chance for random gear upgrade.
            if (RandomInt(0,1)==1){//1/2 chance for random damage type increase.
                if (RandomInt(0,1)==1){//1/2 chance for light damage increase.
                    LightDamageModifier += (int)Math.ceil((double) Difficulty/4);
                    System.out.println("You found a book on light attack techniques! Light Damage Modifier increased by " + (int)Math.ceil((double) Difficulty/4) + "!");
                }
                else{//1/2 chance for heavy damage increase.
                    HeavyDamageModifier += (int)Math.ceil((double) Difficulty/3);
                    System.out.println("You found 'The Adventure's Guide to Finishers: Volume " + (RandomInt(0,5)) + "'! Heavy Damage Modifier increased by " + (int)Math.ceil((double) Difficulty/3) + "!");
                }
            }
            else{//1/2 chance for stat increase.
                if (RandomInt(0,2)==1){//1/3 chance for strength increase.
                    Strength += (int)Math.ceil((double) Difficulty*(2/3));
                    System.out.println("You found a better weapon! Strength increased by " + (int)Math.ceil((double) Difficulty*(2/3)) + "!");
                }
                else if (RandomInt(0,1)==1){//1/3 chance for defense increase.
                    Defense += (int)Math.ceil((double) Difficulty/2);
                    System.out.println("You found a better shield! Defense increased by " + (int)Math.ceil((double) Difficulty/2) + "!");
                }
                else{//1/3 chance for health increase.
                    MaxHealth += Difficulty*2;
                    Health += Difficulty*2;
                    System.out.println("You found better armor! Max Health increased by " + (Difficulty*2) + "!");
                }

            }
        }
        else{//2/3 chance for gold or key.
            if (RandomInt(0,2)==1){//1/3 chance for key.
                Keys+=(int) Math.ceil((double) Difficulty/2);
                System.out.println("You found " + (int) Math.ceil((double) Difficulty/2) + " key/s! You now have " + Keys + " key/s.");
            }
            else{//2/3 chance for gold.
                Gold+=Difficulty*10;
                System.out.println("You found " + (Difficulty*10) + " gold!");
            }
        }

    
    }
    
    //Deprecated
    /*public void Fight(int EnemyStrength, int EnemyHealth, int EnemyDefense, int EnemyType, int Difficulty){//Handles fights.
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
                MonsterName="The WildCat";
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
            else {
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
            if (FloorsCleared==19){//This is the first time fighting the Dragon this run.
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
            else if (FloorsCleared==39){//First re-fight
                System.out.println("Impossible... You killed the Dragon... But they stand before you once again.");
                System.out.println("Blight_Blaze, the bane of your existence.");
                System.out.println("He looks as menacing as ever, but you are stronger now.");
                System.out.println("Unfortunately, you realize he has gotten stronger as well.");
                System.out.println("You steel yourself for the fight ahead.");
                System.out.println();
            }
            else if (FloorsCleared==59){//Second re-fight
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
        Scanner Attack = new Scanner(System.in);
        for (int z=0; z==0;){
            System.out.println();
            System.out.println("Enemy Health: " + EnemyHealth);
            System.out.println("Your Health: " + Health + "/" + MaxHealth);
            System.out.println("Choose your action: Light Attack, Heavy Attack, Block");
            System.out.println();
            String Action = Attack.nextLine();
            int PlayerAction = 0;
            if (Action.equals("Light Attack") || Action.equals("light attack") || Action.equals("L") || Action.equals("l") || Action.equals("Light") || Action.equals("light")){
                PlayerAction = 1;
            }
            else if (Action.equals("Heavy Attack") || Action.equals("heavy attack") || Action.equals("H") || Action.equals("h") || Action.equals("Heavy") || Action.equals("heavy")){
                PlayerAction = 2;
            }
            else if (Action.equals("Block") || Action.equals("block") || Action.equals("B") || Action.equals("b")){
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
                    PlayerDamage = Strength + LightDamageModifier - ((int)Math.floor(EnemyDefense/2));
                    System.out.println("You Slash At " + MonsterName + "! You Deal " + PlayerDamage + " Points of Damage to Them!");
                    EnemyHealth-=PlayerDamage;
                    EnemyDamage= EnemyStrength - ((int)Math.floor(Defense/2));
                    System.out.println("They Strike Back For " + EnemyDamage + " Points of Damage!");
                    Health-=EnemyDamage;
                }
                else if (EnemyAction==2){//Heavy
                    PlayerDamage = Strength + LightDamageModifier - ((int)Math.floor(EnemyDefense/2));
                    System.out.println("You Slash At " + MonsterName + "! You Deal " + PlayerDamage + " Points of Damage to Them!");
                    EnemyHealth-=PlayerDamage;
                    System.out.println("They Were Staggered and Can't Attack!");
                }
                else if (EnemyAction==3){//Block
                    System.out.println("You Attack! However " + MonsterName + " Parried Your Attack!");
                    System.out.println("They Reposte For " + EnemyStrength + " Points of Damage!");
                    Health-=EnemyStrength;
                }
                else{//Special
                    PlayerDamage = Strength + LightDamageModifier - ((int)Math.floor(EnemyDefense/2));
                    System.out.println("You Slash At " + MonsterName + "! You Deal " + PlayerDamage + " Points of Damage to Them!");
                    EnemyHealth-=PlayerDamage;

                    if (EnemyAction==4){//Heal
                        System.out.println(MonsterName + " Regenerates " + Difficulty + " Health!");
                        EnemyHealth+=Difficulty;
                    }
                    else if (EnemyAction==5){//Buff
                        System.out.println(MonsterName + " Grows Stronger!");
                        EnemyStrength+=((int)Math.floor(Difficulty/2));
                        EnemyDefense+=((int)Math.floor(Difficulty/3));
                    }
                    else{//Fire-Ball
                        System.out.println("The Dragon Spits A Fireball At You!");
                        System.out.println("You Take " + Difficulty + " Points of Burning Damage.");
                        Health-=Difficulty;
                    }
                }
            }
            else if (PlayerAction==2){//Heavy
                if (EnemyAction==1){//Light
                    EnemyDamage= EnemyStrength - ((int)Math.floor(Defense/2));
                    System.out.println(MonsterName + " Strikes You For " + EnemyDamage + " Points of Damage!");
                    Health-=EnemyDamage;
                    System.out.println("You Were Staggered and Can't Attack!");
                }
                else if (EnemyAction==2){//Heavy
                    PlayerDamage= ((int)Math.floor(Strength*1.5)) + HeavyDamageModifier - ((int)Math.floor(EnemyDefense/3));
                    System.out.println("You Strike " + MonsterName + " With a Heavy Blow! You Deal " + PlayerDamage + " Points of Damage to Them!");
                    EnemyHealth-=PlayerDamage;
                    EnemyDamage= ((int)Math.floor(EnemyStrength*1.5)) - ((int)Math.floor(Defense/3));
                    System.out.println("They Respond With an Attack of Their Own For " + EnemyDamage + " Points of Damage");
                    Health-=EnemyDamage;
                }
                else if (EnemyAction==3){//Block
                    PlayerDamage= ((int)Math.floor(Strength*1.5)) + HeavyDamageModifier - ((int)Math.floor(EnemyDefense/2));
                    System.out.println("Your Heavy Strike Pierces " + MonsterName + "'s Defense!");
                    System.out.println("You Deal " + PlayerDamage + " Points of Dammage!");
                    EnemyHealth-=PlayerDamage;
                }
                else{//Special
                    PlayerDamage= ((int)Math.floor(Strength*1.5)) + HeavyDamageModifier - ((int)Math.floor(EnemyDefense/3));
                    System.out.println("You Strike " + MonsterName + " With a Heavy Blow! You Deal " + PlayerDamage + " Points of Damage to Them!");
                    EnemyHealth-=PlayerDamage;

                    if (EnemyAction==4){//Heal
                        System.out.println(MonsterName + " Regenerates " + Difficulty + " Health!");
                        EnemyHealth+=Difficulty;
                    }
                    else if (EnemyAction==5){//Buff
                        System.out.println(MonsterName + " Grows Stronger!");
                        EnemyStrength+=((int)Math.floor(Difficulty/2));
                        EnemyDefense+=((int)Math.floor(Difficulty/3));
                    }
                    else{//Fire-Ball
                        System.out.println("The Dragon Spits A Fireball At You!");
                        System.out.println("You Take " + Difficulty + " Points of Burning Damage.");
                        Health-=Difficulty;
                    }
                }
            }
            else{//Block
                if (EnemyAction==1){//Light
                    System.out.println("You Parry " + MonsterName + "'s Attack!");
                    System.out.println("You Reposte For " + Strength + " Points of Damage!");
                    EnemyHealth-=Strength;
                }
                else if (EnemyAction==2){//Heavy
                    EnemyDamage = ((int)Math.floor(EnemyStrength*1.5)) - ((int)Math.floor(Defense/2));
                    System.out.println("You Block But Are Unable to Parry " + MonsterName  + "'s Heavy Blow!");
                    System.out.println("You Are Hit For " + EnemyDamage + " Points of Damage!");
                    Health-=EnemyDamage;
                }
                else if (EnemyAction==3){//Block
                    System.out.println("You Block at the Same Time as " + MonsterName + "!");
                    System.out.println("You Both Look Stupid!");
                }
                else{//Special
                    System.out.println("You Block But " + MonsterName + " Used An Ability!");

                    if (EnemyAction==4){//Heal
                        System.out.println(MonsterName + " Regenerates " + Difficulty + " Health!");
                        EnemyHealth+=Difficulty;
                    }
                    else if (EnemyAction==5){//Buff
                        System.out.println(MonsterName + " Grows Stronger!");
                        EnemyStrength+=((int)Math.floor(Difficulty/2));
                        EnemyDefense+=((int)Math.floor(Difficulty/3));
                    }
                    else{//Fire-Ball
                        System.out.println("The Dragon Spits A Fireball At You!");
                        System.out.println("You Take " + Difficulty + " Points of Burning Damage.");
                        Health-=Difficulty;
                    }
                }
            }
            System.out.println();
//Check For Death
            if (Health<=0){//Player Death overrides monster death.
                System.out.println("After a particularly nasty blow, you fall unconscious!");
                z=1;
            }
            else if (EnemyHealth<=0){//Enemy Death
                if (EnemyType<3){
                    Kills++;
                    System.out.println("You deal a final blow and finish off your opponent!");
                }
                int XP=(int) Math.pow(10, EnemyType);
                Gold+=EnemyType*Difficulty;
                System.out.println("You Gained " + EnemyType*Difficulty + " Gold!");
                GainEXP((int)Math.ceil(XP)*(Difficulty/Level));//You get more XP on deeper floors, but less as you level up.
                z=1;
            }
        }
        Attack.close();
    }*/
}