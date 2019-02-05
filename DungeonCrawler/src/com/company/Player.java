package com.company;

import java.util.ArrayList;
import java.util.List;

public class Player
{
    private Room _currentRoom;
    private List<Item> _items;

    public Player()
    {
        _items = new ArrayList<>();
    }

    public Room GetCurrentRoom()
    {
        return _currentRoom;
    }

    public List<Item> GetAllItems()
    {
        return _items;
    }

    public boolean AddItemToBackpack(String itemName)
    {
        //Add item to backpack
        return false;
    }

    public boolean RemoveItemFromBackpack()
    {
        //Remove item from backpack
        return false;
    }

    public void Move(Room room)
    {
        _currentRoom = room;
        System.out.println("Players current room changed to: " + _currentRoom.GetRoomId());
        //Go to next room based on direction
    }
}