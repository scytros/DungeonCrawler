package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Room
{
    //TODO:
    //- collection of all items available
    //- has exit to 'room number'
    //- room number
    //- description

    private int _id;
    private String _description;

    private ArrayList<Item> _items = new ArrayList<Item>();
    private HashMap<String, Room> _exits = new HashMap<String, Room>();

    public Room(int id, String description)
    {
        _id = id;
        _description = description;
    }

    public HashMap<String, Room> GetPossibleDirections()
    {
        return _exits;
    }

    public void SetExit(String direction, Room room)
    {
        _exits.put(direction, room);
    }

    public Room GetNextRoom()
    {
        //Return the next room
        return null;
    }
}