package Prac31and32;

public final class Dish implements Item {
	private String name;
	private int price;
	private String description;

	private final static int STARTING_PRICE = 0;

	public Dish(String name, int price, String description) {
		if(price < 0) {
			throw new IllegalArgumentException("Price cannot be negative");
		}
		if(name == null || name.equals("")) {
			throw new IllegalArgumentException("Name cannot be null or empty");
		}
		if(description == null || description.equals("")) {
			throw new IllegalArgumentException("Description cannot be null or empty");
		}
		this.name = name;
		this.price = price;
		this.description = description;
	}
	public Dish(String name, String description) {
		if(name == null || name.equals("")) {
			throw new IllegalArgumentException("Name cannot be null or empty");
		}
		if(description == null || description.equals("")) {
			throw new IllegalArgumentException("Description cannot be null or empty");
		}
		this.name = name;
		this.description = description;
		this.price = STARTING_PRICE;
	}

	public String getName() {
		return name;
	}
	public int getCost() {
		return price;
	}
	public String getDescription() {
		return description;
	}
	public void setName(String name) {this.name = name;}
	public void setCost(int price) {this.price = price;}
	public void setDescription(String description) {this.description = description;}

	@Override
	public String toString() {
		return "Dish: " + name + " - " + description + " - price: " + price;
	}
}
