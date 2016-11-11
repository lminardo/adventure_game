package snippets.inventory_test;

public class MainInventoryTest
{
    public static void main(String [] args)
    {
        System.out.println("Create array of items (as if from saved file)");
        int[] items = {3, 3, 1, 3, 28};
        System.out.println("Creating inventory...");
        Inventory inventory = new Inventory(items);
        System.out.println("Inventory size = "+inventory.getSize());
        inventory.print();
    }
}