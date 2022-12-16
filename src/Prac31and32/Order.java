package Prac31and32;

public interface Order {
	boolean add(Item item);
	String[] itemsNames();
	int itemsQuantity();
	int itemsQuantity(String name);
	int itemsQuantity(Item item);
	Item[] getItems();
	boolean remove(String name);
	boolean remove(Item item);
	int removeAll(String name);
	int removeAll(Item item);
	Item[] sortedItemsByCostDesc();
	int costTotal();
	Customer getCustomer();
	void setCustomer(Customer customer);
}
