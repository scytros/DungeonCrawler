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
        _player = new Player(_dungeon.GetRooms().get(0));

        Run();
    }

    private void Run()
    {
        while (true)
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
        //TODO: Use items (in room and in backpack)
        //- Check if item in room and use it if it is (remove)
        //- Check if item in backpack and use it if it is (remove)

        Item playerItem = _player.ItemStorage().GetItemByName(itemName);

        if (playerItem != null)
        {
            playerItem.Use();
            //TODO: Remove after use?
            System.out.println("has " + itemName);
        } else
        {
            System.out.println("doesn't have " + itemName);
        }
    }

    private void HandleDropCommand(String itemName)
    {
        Item item = _player.ItemStorage().TakeItem(itemName);

        if (item != null)
        {
            _player.GetCurrentRoom().ItemStorage().PutItem(item);
            System.out.println(String.format("%s has been removed from backpack", itemName));
        } else
        {
            System.out.println(String.format("%s wasn't found in backpack", itemName));
        }
    }

    private void HandleGetCommand(String itemName)
    {
        Item item = _player.GetCurrentRoom().ItemStorage().TakeItem(itemName);

        boolean succes = _player.ItemStorage().PutItem(item);

        if (succes)
        {
            System.out.println("Added " + itemName + " to backpack");
        } else
        {
            System.out.println(itemName + " wasn't found");
        }
    }

    private void CheckRoomTravel(String command)
    {
        //_player.Move(_player.GetCurrentRoom().GetPossibleExits().get(command));
        boolean succes = _player.Move(command);

        if (!succes)
        {
            System.out.println("Not a valid direction, or direction is not available");
        }
    }

    private void HandlePackCommand()
    {
        System.out.println("Backpack: ");

        for (int i = 0; i < _player.ItemStorage().Storage().size(); i++)
        {
            System.out.println("- " + _player.ItemStorage().Storage().get(i).GetName());
        }
    }

    private void HandleHelpCommand()
    {
        System.out.println("\nAvailable Commands:");
        System.out.println("1. 'go <value> (north, east, south, west)': moves the player to another room in the given direction. (if possible)");
        System.out.println("2. 'get <value> (name of the item to pickup)': Gets an item in the current room. (if possible)");
        System.out.println("3. 'drop <value> (name of the item to drop)': Drops an item. (if possible)");
        System.out.println("4. 'use <value> (name of the item to use)': Uses an item. (if possible)");
        System.out.println("5. 'pack': Shows all available items in the players backpack");
        System.out.println("6. 'help': Shows all available commands");
        System.out.println("7. 'look': Tells the player what options there are in the current room");
        System.out.println("8. 'quit': Quits the game.");
    }

    private void HandleLookCommand()
    {
        System.out.println(_player.GetCurrentRoom().GetRoomDescription());
    }

    private void HandleQuitCommand()
    {
        System.out.println("Thanks for playing!");
        System.exit(0);
    }
}