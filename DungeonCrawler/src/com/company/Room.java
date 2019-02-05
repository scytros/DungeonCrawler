package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room
{
    //TODO:
    //- collection of all items available
    //- has exit to 'room number'
    //- room number
    //- description

    private int _id;
    private String _description;

    private List<Item> _items = new ArrayList<>();
    private Map<String, Room> _exits = new HashMap<>();

    public Map<String, Room> GetPossibleExits()
    {
        return _exits;
    }

    public int GetRoomId()
    {
        return _id;
    }

    public Room(int id, String description)
    {
        _id = id;
        _description = description;
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