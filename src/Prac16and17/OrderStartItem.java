package Prac16and17;

public class OrderStartItem implements Item{
	private String name;
	private int price;
	private String description;

	public OrderStartItem() {
		this.name = "Order start";
		this.price = 0;
		this.description = "beginning of order";
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
}
