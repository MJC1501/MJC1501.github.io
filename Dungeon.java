public class Dungeon {
    public static int RandomInt (int Min, int Max){//random number generator.
        Max++;
        return (int)(Math.random() * (Max - Min) + Min);
    }
    public static boolean RandomDoor(){//Random number generator for doors. 0 is door, 1 or 2 is wall.
        int X = (int)(Math.random()*(2));
        if (X==0){
            return true;
        }
        else {
            return false;
        }
    }
    Room Current;
    Room Entrance = null;
    int FloorGoal;//What a player must do to progress to the next floor. 0 is open, 1 is levels, 2 is keys, 3 is kills, 4 is mini-boss, 5 is boss, 6 is final boss.
    int Difficulty;//Determines the requirement of the goal, strength of enemies, price of shops, rewards etc.

    Dungeon(int FloorsCleared){
        Current=new Room(true, true, true, true, true);//The entrance room has all doors and is empty.
        Entrance = Current;

        //The goal and difficulty is determined by the floor.
        if (FloorsCleared==0){//First floor.
            FloorGoal=RandomInt(1,2);
            Difficulty=1;
        }
        else{
            if (FloorsCleared%5==0){//Floor is divisible by 5 so it will be some kind of boss floor.
                Current.EDoor=false;
                Current.WDoor=false;
                Current.NDoor=false;
                Current.SDoor=false;//Boss Floors have no doors.
                Difficulty=FloorsCleared;
                if (FloorsCleared%10==0){//Floor is divisible by 10.
                    if (FloorsCleared%20==0){//Floor is divisible by 20. final boss floor.
                        FloorGoal=6;
                    }
                    else{//Floor is divisible only by 10. boss floor.
                        FloorGoal=5;
                    }
                }
                else{//Floor is divisible only by 5. mini-boss floor.
                    FloorGoal=4;  
                }
            }
            else{//Normal floor.
                FloorGoal=RandomInt(1, 3);
                int Temp=FloorsCleared%5;
                if (Temp==1 || Temp==2){//
                    Temp=1;
                }
                else{
                    Temp=2;
                }
                Difficulty=Temp+(2*(int)Math.floor(FloorsCleared/5)+1);//The difficulty increases every 2 non-boss floors.
            }
        }

        
    }
    
    //commands to move in each direction. If there is a door, it will generate a new room if there isn't one already, and then move the player into that room. If there is no door, it will return -2 to indicate that the player is blocked by a wall.
    public int MoveN(){
        if (Current.NDoor){
            if (Current.North == null){
                Current.North = new Room(RandomDoor(), true, RandomDoor(), RandomDoor(), false);
                Current.North.SetSouth(Current);
            }
            if (GetRoom()==-1){
                Entrance = Current;//update the entrance.
            }
            Current=Current.North;
            return Current.EnterRoom();
        }
        else{
            return -2;//Blocked by wall
        }
    }
    public int MoveS(){
        if (Current.SDoor){
            if (Current.South == null){
                Current.South = new Room(true, RandomDoor(), RandomDoor(), RandomDoor(), false);
                Current.South.SetNorth(Current);
            }
            if (GetRoom()==-1){
                Entrance = Current;//update the entrance.
            }
            Current=Current.South;
            return Current.EnterRoom();
        }
        else{
            return -2;//Blocked by wall
        }
    }
    public int MoveE(){
        if (Current.EDoor){
            if (Current.East == null){
                Current.East = new Room(RandomDoor(), RandomDoor(),  RandomDoor(), true, false);
                Current.East.SetWest(Current);
            }
            if (GetRoom()==-1){
                Entrance = Current;//update the entrance.
            }
            Current=Current.East;
            return Current.EnterRoom();
        }
        else{
            return -2;//Blocked by wall
        }
    }
    public int MoveW(){
        if (Current.WDoor){
            if (Current.West == null){
                Current.West = new Room(RandomDoor(), RandomDoor(), true, RandomDoor(), false);
                Current.West.SetEast(Current);
            }
            if (GetRoom()==-1){
                Entrance = Current;//update the entrance.
            }
            Current=Current.West;
            return Current.EnterRoom();
        }
        else{
            return -2;//Blocked by wall
        }
    }

    public void ClearRoom(){//Loots the current room.
        Current.ClearRoom();
    }
    public int GetRoom(){//Returns the contents of the current room.
        return Current.EnterRoom();
    }
    public void Teleport(){//Return to the entrance.
        Current=Entrance;
    }
}