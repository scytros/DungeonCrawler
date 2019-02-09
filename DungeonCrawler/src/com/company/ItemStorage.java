package com.company;

import com.company.Items.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemStorage
{
    private List<Item> _items;

    public ItemStorage()
    {
        _items = new ArrayList<>();
    }

    //TODO: Optimise this search
    public Item GetItemByName(String itemName)
    {
        for (int i = 0; i < _items.size(); i++)
        {
            if (_items.get(i).GetName().equals(itemName))
            {
                return _items.get(i);
            }
        }

        return null;
    }

    //Puts an item in the item collection
    public boolean PutItem(Item item)
    {
        if (item != null)
        {
            _items.add(item);
            return true;
        }

        return false;
    }

    //Returns an item based on name and removes it from this collection
    public Item TakeItem(String itemName)
    {
        Item item = GetItemByName(itemName);

        if (item != null)
        {
            _items.remove(item);
            return item;
        }

        return null;
    }

    //Returns the entire item collection
    public List<Item> Storage()
    {
        return _items;
    }
}