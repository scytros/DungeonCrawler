package com.company.Items.Types;

import com.company.Items.Item;

public class Rock extends Item
{
    public Rock(String name, String usageText, String description)
    {
        super(name, usageText, description);
    }

    @Override
    public void Use()
    {
        super.Use();

        System.out.println("*rumble*");
    }
}