package com.company.Items;

public class Item
{
    private String _description;
    private String _usageText;
    private String _name;

    public String GetName()
    {
        return _name;
    }

    public String GetUsageText()
    {
        return _usageText;
    }

    public Item(String name, String usageText, String description)
    {
        _name = name;
        _usageText = usageText;
        _description = description;
    }

    //Something the item does
    public void Use()
    {
    }
}