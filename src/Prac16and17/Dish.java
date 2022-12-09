package Prac16and17;

public final class Dish implements Item {
	private String name;
	private int price;
	private String description;

	private final static int STARTING_PRICE = 0;

	public Dish(String name, int price, String description) {
		this.name = name;
		this.price = price;
		this.description = description;
	}
	public Dish(String name, String description) {
		this.name = name;
		this.description = description;
		this.price = STARTING_PRICE;
	}

	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public String getDescription() {
		return description;
	}
}
