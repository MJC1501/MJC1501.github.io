public class Room {
    Room North;//All the variables I need to make a room.
    Room South;
    Room East;
    Room West;
    boolean NDoor;
    boolean SDoor;
    boolean EDoor;
    boolean WDoor;
    RoomContents Contents;

    //generating a room.
    Room(boolean NDoor, boolean SDoor, boolean EDoor, boolean WDoor, boolean Entrance){
        this.NDoor=NDoor;
        this.SDoor=SDoor;
        this.EDoor=EDoor;
        this.WDoor=WDoor;
        Contents=new RoomContents(Entrance);
    }

    //commands to set and get the rooms in each direction.
    public void SetNorth(Room North){
        this.North=North;
    }
    public void SetSouth(Room South){
        this.South=South;
    }
    public void SetEast(Room East){
        this.East=East;
    }
    public void SetWest(Room West){
        this.West=West;
    }

    public Room GetNorth(){
        return North;
    }
    public Room GetSouth(){
        return South;
    }
    public Room GetEast(){
        return East;
    }
    public Room GetWest(){
        return West;
    }

    //commands to enter and loot the room.
    public int EnterRoom(){
        return Contents.EnterRoom();
    }
    public void ClearRoom(){
        Contents.ClearRoom();
    }
}