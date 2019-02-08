package com.company;

import java.util.ArrayList;
import java.util.List;

public class Player
{
    private Room _currentRoom;
    private List<Item> _items;

    public Player(Room startingRoom)
    {
        _items = new ArrayList<>();
        SetRoom(startingRoom);
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

    public List<Item> GetAllItemsFromBackpack()
    {
        return _items;
    }

    public boolean AddItemToBackpack(Item item)
    {
        if (item != null)
        {
            _items.add(item);
            return true;
        }

        return false;
    }

    public Item RemoveItemFromBackpack(String itemName)
    {
        for (int i = 0; i < _items.size(); i++)
        {
            if (_items.get(i).GetName().equals(itemName))
            {
                Item item = _items.get(i);
                _items.remove(item);
                return item;
            }
        }

        return null;
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