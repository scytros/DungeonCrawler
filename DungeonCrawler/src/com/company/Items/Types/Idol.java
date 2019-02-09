package com.company.Items.Types;

import com.company.Items.Item;

public class Idol extends Item
{
    public Idol(String name, String usageText, String description)
    {
        super(name, usageText, description);
    }

    @Override
    public void Use()
    {
        super.Use();

        System.out.println("*a message appears* find an item and bring it back to this area...");
    }
}
