package com.company;

import java.util.ArrayList;
import java.util.List;

public class Dungeon
{
    private List<Room> _rooms;
    private ItemList _itemList;

    public List<Room> GetRooms()
    {
        return _rooms;
    }

    public Dungeon()
    {
        _itemList = new ItemList();
        _rooms = new ArrayList<>();

        SetupDungeon();
    }

    private void SetupDungeon()
    {
        _rooms.add(new Room(0, "The starting area..."));
        _rooms.add(new Room(1, "A weird looking cellar..."));
        _rooms.add(new Room(2, "A very dark and humid place..."));
        _rooms.add(new Room(3, "This place has a strange smell..."));
        _rooms.add(new Room(4, "A very scary place full of horrors..."));
        _rooms.add(new Room(5, "Weird looking chairs all around me for some reason..."));
        _rooms.add(new Room(6, "I notice something that might be useful around here..."));
        _rooms.add(new Room(7, "I wonder what happened in this place..."));
        _rooms.add(new Room(8, "The only thing i see here are big weird looking rocks..."));
        _rooms.add(new Room(9, "Will i ever find an exit...?"));
        _rooms.add(new Room(10, "A huge skeleton lays here with some sort of a weird bone attached to it..."));

        _rooms.get(0).SetExits(_rooms.get(1), _rooms.get(5), _rooms.get(2), _rooms.get(4));
        _rooms.get(1).SetExits(null, null, _rooms.get(0), null);
        _rooms.get(2).SetExits(_rooms.get(0), _rooms.get(8), null, _rooms.get(3));
        _rooms.get(3).SetExits(_rooms.get(4), _rooms.get(2), null, null);
        _rooms.get(4).SetExits(_rooms.get(0), null, _rooms.get(3), null);
        _rooms.get(5).SetExits(null, _rooms.get(6), _rooms.get(8), _rooms.get(0));
        _rooms.get(6).SetExits(null, null, _rooms.get(7), _rooms.get(5));
        _rooms.get(7).SetExits(_rooms.get(6), null, _rooms.get(9), _rooms.get(8));
        _rooms.get(8).SetExits(_rooms.get(5), _rooms.get(7), _rooms.get(10), _rooms.get(2));
        _rooms.get(9).SetExits(_rooms.get(7), null, null, _rooms.get(10));
        _rooms.get(10).SetExits(_rooms.get(8), _rooms.get(9), null, null);

        _rooms.get(0).AddItems(_itemList.GetAvailableItems());
        //TODO:
        //- Room 1 has a stick
        //- Room 4 has a doll
        //- Room 6 has the teleporting stone
        //- Room 8 has a rock
        //- Room 10 has the magicbone

        //PrintDungeonMap();
    }

    private void PrintDungeonMap()
    {
        for (int i = 0; i < _rooms.size(); i++)
        {
            System.out.print("Room " + _rooms.get(i).GetRoomId() + " [");

            for (String key : _rooms.get(i).GetPossibleExits().keySet())
            {
                System.out.print(key + ": ");
                System.out.print("Room " + _rooms.get(i).GetPossibleExits().get(key).GetRoomId() + ", ");
            }

            System.out.println("]");
        }
    }
}
