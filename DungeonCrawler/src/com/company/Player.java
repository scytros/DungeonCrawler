package com.company;

public class Player
{
    private Room _currentRoom;
    private ItemStorage _itemStorage;

    public Player(Room startingRoom)
    {
        _itemStorage = new ItemStorage();

        SetRoom(startingRoom);
    }

    public ItemStorage ItemStorage()
    {
        return _itemStorage;
    }

    private void SetRoom(Room room)
    {
        _currentRoom = room;
        System.out.println(room.GetRoomDescription());
    }

    public Room GetCurrentRoom()
    {
        return _currentRoom;
    }

    public boolean Move(String direction)
    {
        if (_currentRoom.GetPossibleExits().containsKey(direction))
        {
            SetRoom(_currentRoom.GetPossibleExits().get(direction));
            return true;
        }

        return false;
    }
}