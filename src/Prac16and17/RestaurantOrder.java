package Prac16and17;

public class RestaurantOrder implements Order {
	private Item[] items;
	private int size;
	private int capacity;
	private int tableNumber;

	public RestaurantOrder(int capacity, int tableNumber) {
		this.capacity = capacity;
		this.items = new Item[capacity];
		this.size = 0;
		this.tableNumber = tableNumber;
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

	public int costTotal() {
		int total = 0;
		for (int i = 0; i < size; i++) {
			total += items[i].getCost();
		}
		return total;
	}

	public String[] getNames() {
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

	public String[] getDescriptions() {
		String[] descriptions = new String[size];
		for (int i = 0; i < size; i++) {
			descriptions[i] = items[i].getDescription();
		}
		return descriptions;
	}

	public int countByName(String name) {
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (items[i].getName().equals(name)) {
				count++;
			}
		}
		return count;
	}

	public int getCapacity() {
		return capacity;
	}

	public int size() {
		return size;
	}

	public Item[] items() {return items;}

	public int getTableNumber(){
		return tableNumber;
	}

	public void setTableNumber(int tableNumber){
		this.tableNumber = tableNumber;
	}

	public Item[] getSortedItems() {
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
}
