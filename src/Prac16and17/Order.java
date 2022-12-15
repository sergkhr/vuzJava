package Prac16and17;

public interface Order {
	boolean add(Item item);
	boolean remove(String name);
	int size();
	Item[] items();
	int costTotal();
	int countByName(String name);
	String[] getNames();
	Item[] getSortedItems();
}
