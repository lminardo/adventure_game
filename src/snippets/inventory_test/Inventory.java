package snippets.inventory_test;

import java.util.ArrayList;

class Inventory
{
    private int size;
    final int MAX_SIZE = 100, CATEGORIES = 1, KEY_ITEMS = 25/*if we want 25 key items*/;
    private ArrayList<Item> inventory;

    Inventory(){}

    Inventory(int[] items)
    {
        if(items.length <= MAX_SIZE)
        {
            inventory = new ArrayList<>();
            for (int i : items)
            {
                inventory.add(new Item(i));
            }
            size = inventory.size();
        }
        else
            System.out.println("Too many items");
    }

    int getSize()
    {
        return size;
    }

    void print()
    {
        for (Item i : inventory)
        {
            System.out.println(i.toString());
        }
    }
}