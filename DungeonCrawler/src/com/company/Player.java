package com.company;

import java.util.ArrayList;

public class Player
{
    private Room _currentRoom;
    private ArrayList<Item> _items = new ArrayList<Item>();

    public Room GetCurrentRoom()
    {
        return _currentRoom;
    }

    public ArrayList GetAllItems()
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

    public void GoToNextRoom()
    {
        //Go to next room based on direction
    }
}