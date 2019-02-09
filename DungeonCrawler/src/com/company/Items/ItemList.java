package com.company.Items;

import com.company.Items.Types.*;

import java.util.ArrayList;
import java.util.List;

public class ItemList
{
    private List<Item> _availableItems;

    public enum ItemTypes
    {
        ROCK,
        STICK,
        IDOL,
        MAGICBONE,
        TELEPORTSTONE
    }

    public ItemList()
    {
        _availableItems = new ArrayList<>();

        CreateItemList();
    }

    public List<Item> GetAvailableItems()
    {
        return _availableItems;
    }

    //TODO: Going to refactor this
    public Item GetSpecificItem(ItemTypes itemTypes)
    {
        switch (itemTypes)
        {
            case ROCK:
                return _availableItems.get(0);
            case STICK:
                return _availableItems.get(1);
            case IDOL:
                return _availableItems.get(2);
            case MAGICBONE:
                return _availableItems.get(3);
            case TELEPORTSTONE:
                return _availableItems.get(4);
        }

        return null;
    }

    private void CreateItemList()
    {
        Item rock = new Rock("rock", "has no purpose", "it's just a rock");
        Item stick = new Stick("stick", "crack!", "wonder what this could do...");
        Item idol = new Idol("idol", "*a message appears* find an item and bring it back to this area...", "some weird voodoo doll..don't know if it has any use though...");
        Item magicbone = new MagicBone("magicbone", "*magic bone shakes.* a thought appears: 'bring this back to the starting area'.", "might win the game or something stupid like that");
        Item teleportStone = new TeleportStone("teleportstone", "It's not going to be that simple :), you can walk back to the starting area", "some silly stone");

        _availableItems.add(rock);
        _availableItems.add(stick);
        _availableItems.add(idol);
        _availableItems.add(magicbone);
        _availableItems.add(teleportStone);
    }
}