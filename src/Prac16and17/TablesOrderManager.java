package Prac16and17;

public class TablesOrderManager {
	private Order[] orders;
	private int size;
	private int capacity;

	public TablesOrderManager(int capacity) {
		this.capacity = capacity;
		this.orders = new Order[capacity];
		this.size = 0;
	}

	public boolean add(Order order, int tableNumber) {
		if (size < capacity) {
			orders[size] = order;
			size++;
			return true;
		} else {
			return false;
		}
	}

	public boolean add(Item item, int tableNumber) {
		for (int i = 0; i < size; i++) {
			if (orders[i].getTableNumber() == tableNumber) {
				return orders[i].add(item);
			}
		}
		return false;
	}

	public boolean remove(int tableNumber) {
		for (int i = 0; i < size; i++) {
			if (orders[i].getTableNumber() == tableNumber) {
				for (int j = i; j < size - 1; j++) {
					orders[j] = orders[j + 1];
				}
				size--;
				return true;
			}
		}
		return false;
	}

	public Order[] getOrders() {
		return orders;
	}
}
