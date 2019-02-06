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

    public List<Item> GetAllItemsFromBackpack()
    {
        return _items;
    }

    public boolean AddItemToBackpack(Item item)
    {
        _items.add(item);

        return true;
    }

    public boolean RemoveItemFromBackpack(String itemName)
    {
        for (int i = 0; i < _items.size(); i++)
        {
            if (_items.get(i).GetName().equals(itemName))
            {
                _items.remove(_items.get(i));
                return true;
            }
        }

        return false;
    }

    public void Move(Room room)
    {
        _currentRoom = room;
        System.out.println(_currentRoom.GetRoomDescription());
    }
}