package Prac31and32;

import java.util.HashMap;

public class InternetOrderManager implements OrderManager {
	private int size;
	private HashMap<Customer, Order> orders;

	public InternetOrderManager() {
		this.size = 0;
		this.orders = new HashMap<Customer, Order>();
	}

	public boolean add(Customer customer, Order order){
		if(!(order instanceof InternetOrder)){
			throw new IllegalArgumentException("Order is not an internet order");
		}
		if(orders.containsKey(customer)){
			throw new IllegalArgumentException("Customer already has as order");
		}
		orders.put(customer, order);
		size++;
		return true;
	}

	public boolean add(Customer customer, Item item) {
		if (orders.containsKey(customer)) {
			return orders.get(customer).add(item);
		} else {
			throw new IllegalArgumentException("Customer " + customer + " has no orders");
		}
	}

	public Order getOrder(Customer customer) {
		return orders.get(customer);
	}

	public boolean remove(Customer customer) {
		if (orders != null && orders.containsKey(customer)) {
			orders.remove(customer);
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
