package Prac16and17;

import java.util.HashMap;

public class OrderManager {
	private RestaurantOrder[] restaurantOrders;
	private int size;
	private int capacity;
	private HashMap<String, Order> orders;

	public OrderManager(int capacity) {
		this.capacity = capacity;
		this.restaurantOrders = new RestaurantOrder[capacity];
		this.size = 0;
		this.orders = new HashMap<String, Order>();
	}

	public boolean add(RestaurantOrder restaurantOrder, int tableNumber) throws OrderAlreadyAddedException {
		if (size < capacity) {
			//check if table number is already in use
			for (int i = 0; i < size; i++) {
				if (restaurantOrders[i].getTableNumber() == tableNumber) {
					throw new OrderAlreadyAddedException("Table number " + tableNumber + " is already in use");
				}
			}
			restaurantOrders[size] = restaurantOrder;
			size++;
			return true;
		} else {
			return false;
		}
	}

	public boolean add(Item item, int tableNumber) {
		for (int i = 0; i < size; i++) {
			if (restaurantOrders[i].getTableNumber() == tableNumber) {
				return restaurantOrders[i].add(item);
			}
		}
		return false;
	}

	public boolean add(String address, Order order) throws OrderAlreadyAddedException {
		if (orders.containsKey(address)) {
			throw new OrderAlreadyAddedException("Address " + address + " is already in use");
		} else {
			orders.put(address, order);
			return true;
		}
	}

	public boolean add(String address, Item item) {
		if (orders.containsKey(address)) {
			return orders.get(address).add(item);
		} else {
			return false;
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

	public boolean remove(int tableNumber) {
		for (int i = 0; i < size; i++) {
			if (restaurantOrders[i].getTableNumber() == tableNumber) {
				for (int j = i; j < size - 1; j++) {
					restaurantOrders[j] = restaurantOrders[j + 1];
				}
				size--;
				return true;
			}
		}
		return false;
	}

	public RestaurantOrder[] getRestaurantOrders() {
		return restaurantOrders;
	}

	public RestaurantOrder getRestaurantOrder(int tableNumber) {
		for (int i = 0; i < size; i++) {
			if (restaurantOrders[i].getTableNumber() == tableNumber) {
				return restaurantOrders[i];
			}
		}
		return null;
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
			quantity += order.countByName(itemName);
		}
		return quantity;
	}


	public static void main(String[] args) {
		OrderManager orderManager = new OrderManager(10);
		try {
			orderManager.add(new RestaurantOrder(5, 1), 1);
			orderManager.add(new RestaurantOrder(5, 2), 2);
			orderManager.add(new Drink("Coca-Cola", 100, "Coca-Cola"), 1);
			orderManager.add(new Drink("Coca-Cola", 100, "Coca-Cola"), 1);
			orderManager.add(new Dish("Solid-Cola", 50, "Coca-Cola but it's a dish"), 1);
			try{
				orderManager.add(new Drink("Coca-Cola", 100, ""), 1);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			orderManager.add(new Drink("Coca-Cola", 100, "Coca-Cola"), 2);
			orderManager.add(new Dish("Solid-Cola", 50, "Coca-Cola but it's a dish"), 2);
			System.out.println("number of Coca-colas in table 1: " + orderManager.getRestaurantOrder(1).countByName("Coca-Cola"));
			orderManager.add(new Drink("Apple Juice", 200, "Apple Juice"), 1);
			System.out.println("sorted items:");
			for (Item item : orderManager.getRestaurantOrder(1).getSortedItems()) {
				System.out.println(item.getName() + " " + item.getCost());
			}
			System.out.println("cost total of internet orders: " + orderManager.ordersCostSummary());
		} catch (OrderAlreadyAddedException e) {
			System.out.println(e.getMessage());
		}

		try {
			orderManager.add("Moscow", new InternetOrder());
			orderManager.add("Moscow", new Drink("Coca-Cola", 100, "Coca-Cola"));
			orderManager.add("Moscow", new Dish("Solid-Cola", 50, "Coca-Cola but it's a dish"));
			orderManager.add("Moscow", new Drink("Coca-Cola", 100, "Coca-Cola"));
			//two coca colas so we'll see only two positions in getNames
			System.out.println("internet order cost total: " + orderManager.getOrder("Moscow").costTotal());
			for (String name : orderManager.getOrder("Moscow").getNames()) {
				System.out.println(name);
			}
		} catch (OrderAlreadyAddedException e) {
			System.out.println(e.getMessage());
		}

		try {
			orderManager.add("Moscow", new InternetOrder());
			orderManager.add("Moscow", new InternetOrder());
		} catch (OrderAlreadyAddedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("cost total of internet orders: " + orderManager.ordersCostSummary());
	}
}
