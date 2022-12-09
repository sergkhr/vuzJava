package Prac16and17;

public class InternetOrder {
	private MyLinkedList<Item> list;

	public InternetOrder() {
		list = new MyLinkedList<Item>(new OrderStartItem());
	}
	public InternetOrder(Item[] items) {
		list = new MyLinkedList<Item>(new OrderStartItem());
		for (Item item : items) {
			list.add(item);
		}
	}

	public boolean add(Item item) {
		list.add(item);
		return true;
	}
}
