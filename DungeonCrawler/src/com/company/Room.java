package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room
{
    private int _id;
    private String _description;

    private List<Item> _items = new ArrayList<>();
    private Map<String, Room> _exits = new HashMap<>();

    public Map<String, Room> GetPossibleExits()
    {
        return _exits;
    }

    public Item GetItemByName(String itemName)
    {
        for (int i = 0; i < _items.size(); i++)
        {
            if (_items.get(i).GetName().equals(itemName))
            {
                _items.remove(_items.get(i));
                return _items.get(i);
            }
        }

        return null; //TODO: Return that th item doesn't exist in the room
    }

    public int GetRoomId()
    {
        return _id;
    }

    public String GetRoomDescription()
    {
        //TODO:
        //- All available items in the room
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Currently In Room: ");
        stringBuilder.append(_id);
        stringBuilder.append("\nDescription: ");
        stringBuilder.append(_description);
        stringBuilder.append("\nPossible Exits: ");

        for (String key : _exits.keySet())
        {
            stringBuilder.append(key);
            stringBuilder.append(": ");
            stringBuilder.append("Room ");
            stringBuilder.append(_exits.get(key).GetRoomId());
            stringBuilder.append(", ");
        }

        stringBuilder.append("\nItems In Room: ");

        for (int i = 0; i < _items.size(); i++)
        {
            stringBuilder.append("\n- ");
            stringBuilder.append(_items.get(i).GetName());
        }

        return stringBuilder.toString();
    }

    public Room(int id, String description)
    {
        _id = id;
        _description = description;
    }

    public void AddItems(List<Item> items)
    {
        for (int i = 0; i < items.size(); i++)
        {
            _items.add(items.get(i));
        }
    }

    //TODO: make this constructor only
    public void SetExits(Room northRoom, Room eastRoom, Room southRoom, Room westRoom)
    {
        if (northRoom != null)
        {
            _exits.put("north", northRoom);
        }

        if (eastRoom != null)
        {
            _exits.put("east", eastRoom);
        }

        if (southRoom != null)
        {
            _exits.put("south", southRoom);
        }

        if (westRoom != null)
        {
            _exits.put("west", westRoom);
        }
    }
}