public class RoomContents {
    public static int RandomInt (int Min, int Max){//random number generator.
        Max++;
        return (int)(Math.random() * (Max - Min) + Min);
    }
    
    private boolean Entrance;
    private int Contents;
    
    RoomContents(boolean Entrance){//Constructor. If the room is the entrance, it will be empty.
        this.Entrance=Entrance;
        if (Entrance){
            Contents=-1;
        }
        else{
            Contents=RandomInt(0, 5);//-1 is entrance/exit, 0 is empty/looted, 1 is monster, 2 is elite, 3 is campfire, 4 is shop, and 5 is treasure.
        }
    }

    public int EnterRoom(){//Returns the contents of the room.
        return Contents;
    }
    public void ClearRoom(){//The Room has been looted.
        if (Entrance){
        }
        else{
            Contents=0;
        }
    }
}