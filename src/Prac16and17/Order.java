package Prac16and17;

public class Order {
	private Item[] items;
	private int size;
	private int capacity;
	private int tableNumber;

	public Order(int capacity, int tableNumber) {
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

	public boolean delete(Item item){
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

	public int getTotalPrice() {
		int total = 0;
		for (int i = 0; i < size; i++) {
			total += items[i].getPrice();
		}
		return total;
	}

	public String[] getNames() {
		String[] names = new String[size];
		for (int i = 0; i < size; i++) {
			names[i] = items[i].getName();
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

	public int getCapacity() {
		return capacity;
	}

	public int getSize() {
		return size;
	}

	public Item[] getItems() {
		return items;
	}

	public int getTableNumber(){
		return tableNumber;
	}
}
