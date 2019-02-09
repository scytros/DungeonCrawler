package com.company;

import com.company.HelperClasses.ListOfItems;

import java.util.ArrayList;
import java.util.List;

public class Player
{
    private Room _currentRoom;
    private ListOfItems _listOfItems;

    public Player(Room startingRoom)
    {
        _listOfItems = new ListOfItems();

        SetRoom(startingRoom);
    }

    public ListOfItems GetStuff()
    {
        return _listOfItems;
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