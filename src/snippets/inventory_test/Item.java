package snippets.inventory_test;

import java.awt.image.BufferedImage;

class Item extends Inventory
{
    private int itemId, itemValue;
    BufferedImage itemImage;
    private boolean isDropable;
    private String name;

    Item(int c)
    {
        itemId = c;
        determineProperties();
    }

    private void determineProperties()
    {
        isDropable = itemId < super.KEY_ITEMS; //all items with itemId <25 is key and can't be dropped
        //if(itemId = x) itemImage = y;
        //if(itemId = x) itemValue = y;
        if(isDropable)
            determineValue();
        else
            itemValue = 0;
        determineName();
    }

    private void determineValue()
    {
        switch(itemId)
        {
            case 1: itemValue = 5;break;
            case 2: itemValue = 10;break;
            case 3: itemValue = 1;break;
            case 28: itemValue = 100000;break;
            default: itemValue = 1;
        }
    }

    private void determineName()
    {
        switch(itemId)
        {
            case 1: name = "Rock";break;
            case 2: name = "Paper";break;
            case 3: name = "Scissors";break;
            case 28: name = "Key";break;
            default: name = "Poop";
        }
    }

    int getitemId()
    {
        return itemId;
    }

    int getItemValue()
    {
        return itemValue;
    }

    String getName()
    {
        return name;
    }

    boolean isDropable()
    {
        return isDropable;
    }

    public String toString()
    {
        return("Name:\t\t"+name+"\nItem Id:\t"+itemId+ "\nItem Value:\t"+
                (itemValue>0?itemValue:"N/A")+"\nIs Dropable:"+isDropable+"\n\n");
    }
}