package Prac16and17;

public final class Drink implements Item {
	private String name;
	private int price;
	private String description;

	private static final int STARTING_PRICE = 0;

	public Drink(String name, int price, String description) {
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
	public Drink(String name, String description) {
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

	public String getName() {return name;}
	public int getCost() {
		return price;
	}
	public String getDescription() {
		return description;
	}
	public void setName(String name) {this.name = name;}
	public void setCost(int price) {this.price = price;}
	public void setDescription(String description) {this.description = description;}
}
