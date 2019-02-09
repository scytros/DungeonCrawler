package com.company.Items;

import com.company.Items.Types.*;

import java.util.ArrayList;
import java.util.List;

public class ItemList
{
    private List<Item> _availableItems;

    enum Items
    {
        ROCK,
        STICK,
        IDOL,
        MAGICBONE,
        TELEPORTSTONE
    }

    public List<Item> GetAvailableItems()
    {
        return _availableItems;
    }

    public ItemList()
    {
        _availableItems = new ArrayList<>();

        CreateItemList();
    }

    private void CreateItemList()
    {
        Item rock = new Rock("rock", "has no purpose", "it's just a rock");
        Item stick = new Stick("stick", "crack!", "wonder what this could do...");
        Item idol = new Idol("idol", "unleash the voodoo!", "some weird voodoo doll..don't know if it has any use though...");
        Item magicbone = new MagicBone("magicbone", "use this to win the game", "might win the game or something stupid like that");
        Item teleportStone = new TeleportStone("teleportstone", "teleports the user to the starting point", "some silly teleporting stone");

        _availableItems.add(rock);
        _availableItems.add(stick);
        _availableItems.add(idol);
        _availableItems.add(magicbone);
        _availableItems.add(teleportStone);
    }
}