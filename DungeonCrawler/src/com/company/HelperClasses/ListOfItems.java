package com.company.HelperClasses;

import com.company.Item;

import java.util.ArrayList;
import java.util.List;

public class ListOfItems
{
    private List<Item> _items;

    public ListOfItems()
    {
        _items = new ArrayList<>();
    }

    //TODO: Optimise this search
    //Checks if
    public boolean HasItem(String itemName)
    {
        for (int i = 0; i < _items.size(); i++)
        {
            if (_items.get(i).GetName().equals(itemName))
            {
                return true;
            }
        }

        return false;
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
        for (int i = 0; i < _items.size(); i++)
        {
            if (_items.get(i).GetName().equals(itemName))
            {
                Item item = _items.get(i);
                _items.remove(item);
                return item;
            }
        }

        return null;
    }
}