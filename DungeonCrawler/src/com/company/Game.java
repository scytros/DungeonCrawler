package com.company;

import com.company.HelperClasses.Commands;

import java.util.Scanner;

public class Game
{
    private Player _player;
    private Scanner _scanner;
    private Dungeon _dungeon;

    public Game()
    {
        _scanner = new Scanner(System.in);
        _dungeon = new Dungeon();
        _player = new Player();
        Room room = _dungeon.GetRooms().get(0);
        _player.Move(room);
        //TODO: nullpointer for some reason

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
        }
        else if (splitArray.length == 2)
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
        }
        else
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
                System.out.println(_dungeon.GetRooms().get(_player.GetCurrentRoom().GetRoomId()).GetRoomId());
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

    private void HandleQuitCommand()
    {
        System.out.println("Thanks for playing!");
        System.exit(0);
    }
}