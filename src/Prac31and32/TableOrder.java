package Prac31and32;

public class TableOrder implements Order {
	private Item[] items;
	private int size;
	private int capacity;
	private int tableNumber;
	private Customer customer;

	public TableOrder(int capacity, int tableNumber) {
		this.capacity = capacity;
		this.items = new Item[capacity];
		this.tableNumber = tableNumber;
		this.size = 0;
	}

	public boolean add(Item item) {
		if (size < capacity) {
			items[size] = item;
			size++;
			return true;
		} else {
			return false;
		}
	}

	public String[] itemsNames() {
		String[] names = new String[size];
		for (int i = 0; i < size; i++) {
			//check for duplicates
			boolean duplicate = false;
			for (int j = 0; j < i; j++) {
				if (items[i].getName().equals(names[j])) {
					duplicate = true;
				}
			}
			if (!duplicate) {
				names[i] = items[i].getName();
			}
		}
		return names;
	}

	public int itemsQuantity() {
		return size;
	}

	public int itemsQuantity(String name) {
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (items[i].getName().equals(name)) {
				count++;
			}
		}
		return count;
	}

	public int itemsQuantity(Item item) {
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (items[i].equals(item)) {
				count++;
			}
		}
		return count;
	}

	public Item[] getItems() {return items;}

	public boolean remove(String name){
		for (int i = 0; i < size; i++) {
			if (items[i].getName().equals(name)) {
				for (int j = i; j < size - 1; j++) {
					items[j] = items[j + 1];
				}
				size--;
				return true;
			}
		}
		return false;
	}

	public boolean remove(Item item){
		for (int i = 0; i < size; i++) {
			if (items[i].equals(item)) {
				for (int j = i; j < size - 1; j++) {
					items[j] = items[j + 1];
				}
				size--;
				return true;
			}
		}
		return false;
	}

	public int removeAll(String name){
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (items[i].getName().equals(name)) {
				for (int j = i; j < size - 1; j++) {
					items[j] = items[j + 1];
				}
				size--;
				count++;
			}
		}
		return count;
	}

	public int removeAll(Item item){
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (items[i].equals(item)) {
				for (int j = i; j < size - 1; j++) {
					items[j] = items[j + 1];
				}
				size--;
				count++;
			}
		}
		return count;
	}

	public Item[] sortedItemsByCostDesc() {
		Item[] sortedItems = new Item[size];
		for (int i = 0; i < size; i++) {
			sortedItems[i] = items[i];
		}
		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				if (sortedItems[i].getCost() < sortedItems[j].getCost()) {
					Item temp = sortedItems[i];
					sortedItems[i] = sortedItems[j];
					sortedItems[j] = temp;
				}
			}
		}
		return sortedItems;
	}

	public int costTotal() {
		int total = 0;
		for (int i = 0; i < size; i++) {
			total += items[i].getCost();
		}
		return total;
	}

	public Customer getCustomer() {return customer;}
	public void setCustomer(Customer customer) {this.customer = customer;}

	public int getCapacity() {
		return capacity;
	}

	public int getTableNumber() {
		return tableNumber;
	}
	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}

	public boolean isEmpty() {
		return size == 0;
	}
}
