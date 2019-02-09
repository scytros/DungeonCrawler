package com.company;

import com.company.Items.Item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room
{
    private int _id;
    private String _description;

    private ItemStorage _itemStorage;
    private Map<String, Room> _exits = new HashMap<>();

    public Room(int id, String description)
    {
        _id = id;
        _description = description;
        _itemStorage = new ItemStorage();
    }

    public ItemStorage ItemStorage()
    {
        return _itemStorage;
    }

    public Map<String, Room> GetPossibleExits()
    {
        return _exits;
    }

    public int GetRoomId()
    {
        return _id;
    }

    public String GetRoomDescription()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Currently in room: ");
        stringBuilder.append(_id);
        stringBuilder.append("\nDescription: ");
        stringBuilder.append(_description);
        stringBuilder.append("\nPossible exits: ");

        for (String key : _exits.keySet())
        {
            stringBuilder.append(key);
            stringBuilder.append(": ");
            stringBuilder.append("room ");
            stringBuilder.append(_exits.get(key).GetRoomId());
            stringBuilder.append(", ");
        }

        stringBuilder.append("\nItems in room: ");

        for (int i = 0; i < _itemStorage.Storage().size(); i++)
        {
            stringBuilder.append("\n- ");
            stringBuilder.append(_itemStorage.Storage().get(i).GetName());
        }

        return stringBuilder.toString();
    }

    //Adds the starting items to the rooms
    public void AddItems(List<Item> items)
    {
        for (int i = 0; i < items.size(); i++)
        {
            _itemStorage.Storage().add(items.get(i));
        }
    }

    //Sets the possible exits to others rooms
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