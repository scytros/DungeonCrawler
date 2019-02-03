package com.company;

import com.company.HelperClasses.Commands;

import java.util.ArrayList;
import java.util.Scanner;

public class Game
{
    private Player _player = new Player();
    private Scanner _scanner = new Scanner(System.in);
    private ArrayList<Room> _rooms = new ArrayList<Room>();

    public Game()
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

        Room firstRoom = _rooms.get(0);
        firstRoom.SetExit("north", _rooms.get(1));
        firstRoom.SetExit("east", _rooms.get(6));
        firstRoom.SetExit("south", _rooms.get(3));
        firstRoom.SetExit("west", _rooms.get(2));

        Run();
    }

    private void Run()
    {
        boolean keepPlaying = true;
        while (keepPlaying)
        {
            String _userInput = _scanner.nextLine();

            HandleCommand(_userInput);
        }
    }

    private void HandleCommand(String input)
    {
        String[] splitArray = input.toLowerCase().trim().split("\\s+");
        //TODO: make sure input has 1.command and 2.information

        if (splitArray.length == 1)
        {
            switch (splitArray[0])
            {
                case Commands.PACK:
                    HandlePackCommand();
                    break;
                case Commands.HELP:
                    HandleHelpCommand();
                    break;
                case Commands.LOOK:
                    HandleLookCommand();
                    break;
                case Commands.QUIT:
                    HandleQuitCommand();
                    break;
                default:
                    System.out.println("Please use one of the valid input commands.");
            }
        } else if (splitArray.length == 2)
        {
            switch (splitArray[0])
            {
                case Commands.GO:
                    CheckRoomTravel(splitArray[1]);
                    break;
                case Commands.GET:
                    HandleGetCommand(splitArray[1]);
                    break;
                case Commands.DROP:
                    HandleDropCommand(splitArray[1]);
                    break;
                case Commands.USE:
                    HandleUseCommand(splitArray[1]);
                    break;
                default:
                    System.out.println("Please use one of the valid input commands.");
            }
        } else
        {
            System.out.println("Please use one of the valid input commands.");
        }
    }

    private void HandleUseCommand(String itemName)
    {
    }

    private void HandleDropCommand(String itemName)
    {
    }

    private void HandleGetCommand(String itemName)
    {

    }

    private boolean CheckRoomTravel(String command)
    {
        switch (command)
        {
            case "north":
                System.out.println("Going north!");
                break;
            case "east":
                System.out.println("Going east!");
                break;
            case "south":
                System.out.println("Going south!");
                break;
            case "west":
                System.out.println("Going west!");
                break;
            default:
                System.out.println("Invalid direction!");
                break;
        }
        //Check if east, west, north or south
        return false;
    }

    private void HandlePackCommand()
    {
        //Show inventory
    }

    private void HandleHelpCommand()
    {
        System.out.println("\nAvailable Commands:");
        System.out.println("1. 'go': moves the player to another room. (if possible)");
        System.out.println("2. 'get': Gets an item in the current room. (if possible)");
        System.out.println("3. 'drop': Drops an item. (if possible)");
        System.out.println("4. 'use': Uses an item. (if possible)");
        System.out.println("5. 'pack': Shows all available items in the players backpack");
        System.out.println("6. 'help': Shows all available commands");
        System.out.println("7. 'look': Tells the player what options there are in the current room");
        System.out.println("8. 'quit': Quits the game.");
    }

    private void HandleLookCommand()
    {
        //Show entrances and items in room
    }

    //Quits the game
    private void HandleQuitCommand()
    {
        System.out.println("Thanks for playing!");
        System.exit(0);
    }
}