package com.company;

public class Item
{
    private String _description;
    private String _usageText;
    private String _name;

    public String GetName()
    {
        return _name;
    }

    public Item(String name, String usageText, String description)
    {
        _name = name;
        _usageText = usageText;
        _description = description;
    }
}