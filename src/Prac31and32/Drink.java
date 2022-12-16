package Prac31and32;

import Prac16and17.Item;

public final class Drink implements Item, Alcoholable {
	private String name;
	private int price;
	private String description;
	private double alcoholVol;
	private DrinkTypeEnum type;

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

	public double getAlcoholVol() {return alcoholVol;}
	public DrinkTypeEnum getType() {return type;}
	public void setAlcoholVol(double alcoholVol) {this.alcoholVol = alcoholVol;}
	public void setType(DrinkTypeEnum type) {this.type = type;}

	public boolean isAlcoholicDrink() {
		if(alcoholVol > 0) {
			return true;
		}
		return false;
	}
}
