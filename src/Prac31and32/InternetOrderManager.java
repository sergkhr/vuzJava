package Prac31and32;

import java.util.HashMap;

public class InternetOrderManager implements OrdersManager{
	private int size;
	private HashMap<String, Order> orders;

	public InternetOrderManager() {
		this.size = 0;
		this.orders = new HashMap<String, Order>();
	}

	public boolean add(String address, Order order){
		if(order instanceof InternetOrder){
			throw new IllegalArgumentException("Order is not an internet order");
		}
		orders.put(address, order);
		size++;
		return true;
	}

	public boolean add(String address, Item item) {
		if (orders.containsKey(address)) {
			return orders.get(address).add(item);
		} else {
			throw new IllegalArgumentException("Address " + address + " is not in use");
		}
	}

	public Order getOrder(String address) {
		return orders.get(address);
	}

	public boolean remove(String address) {
		if (orders != null && orders.containsKey(address)) {
			orders.remove(address);
			return true;
		} else {
			return false;
		}
	}

	public Order[] getOrders() {
		return orders.values().toArray(new Order[0]);
	}

	public int ordersCostSummary() { //orders cost summary is for internet orders
		int cost = 0;
		for (Order order : orders.values()) {
			cost += order.costTotal();
		}
		return cost;
	}

	public int itemsQuantity(String itemName) {
		int quantity = 0;
		for (Order order : orders.values()) {
			quantity += order.itemsQuantity(itemName);
		}
		return quantity;
	}

	public int itemsQuantity(Item item) {
		int quantity = 0;
		for (Order order : orders.values()) {
			quantity += order.itemsQuantity(item);
		}
		return quantity;
	}

	public int ordersQuantity() {
		return size;
	}
}
