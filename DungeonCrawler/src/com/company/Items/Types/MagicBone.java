package com.company.Items.Types;

import com.company.Items.Item;

public class MagicBone extends Item
{
    public MagicBone(String name, String usageText, String description)
    {
        super(name, usageText, description);
    }

    @Override
    public void Use()
    {
        super.Use();

        System.out.println(super.GetUsageText());
    }
}
