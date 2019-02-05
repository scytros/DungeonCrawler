package com.company;

import java.util.ArrayList;
import java.util.List;

public class Dungeon
{
    private List<Room> _rooms;

    public List<Room> GetRooms()
    {
        return _rooms;
    }

    public Dungeon()
    {
        _rooms = new ArrayList<>();

        SetupDungeon();
    }

    private void SetupDungeon()
    {
        _rooms.add(new Room(0, "The starting area"));
        _rooms.add(new Room(1, "The first room after the starting area"));
        _rooms.add(new Room(2, "The second room after the starting area"));
        _rooms.add(new Room(3, "The third room after the starting area"));
        _rooms.add(new Room(4, "The fourth room after the starting area"));
        _rooms.add(new Room(5, "The fifth room after the starting area"));
        _rooms.add(new Room(6, "The sixth room after the starting area"));
        _rooms.add(new Room(7, "The seventh room after the starting area"));
        _rooms.add(new Room(8, "The eight room after the starting area"));
        _rooms.add(new Room(9, "The ninth room after the starting area"));
        _rooms.add(new Room(10, "The tenth room after the starting area"));

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
