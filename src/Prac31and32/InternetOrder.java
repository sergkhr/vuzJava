package Prac31and32;

public class InternetOrder implements Order {
	private MyLinkedList<Item> list;
	private Customer customer;

	public InternetOrder() {
		list = new MyLinkedList<Item>(new OrderStartItem());
	}
	public InternetOrder(Customer customer) {
		list = new MyLinkedList<Item>(new OrderStartItem());
		this.customer = customer;
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

	public String[] itemsNames() {
		String[] names = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			//check for duplicates
			boolean duplicate = false;
			for (int j = 0; j < i; j++) {
				if (list.get(i).getName().equals(names[j])) {
					duplicate = true;
				}
			}
			if (!duplicate) {
				names[i] = list.get(i).getName();
			}
		}
		return names;
	}

//	public int itemsQuantity() {
//		return list.size() - 1; //-1 is for start item
//	}
	//doesn't work with -1, but does without it for some reason
	public int itemsQuantity() {
		return list.size();
	}

	public int itemsQuantity(String name) {
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(name)) {
				count++;
			}
		}
		return count;
	}

	public int itemsQuantity(Item item) {
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(item)) {
				count++;
			}
		}
		return count;
	}

	public Item[] getItems() {
		Item[] items = new Item[itemsQuantity()];
		int i = 0;
		MyLinkedList<Item> temp;
		for (temp = list.getNext(); temp != list; temp = temp.getNext()) {
			if(temp.getData() != null) {
				items[i] = temp.getData();
				i++;
			}
		}
		return items;
	}

	public boolean remove(String name){
		MyLinkedList<Item> temp;
		for(temp = list.getPrev(); temp != list; temp = temp.getPrev()) {
			if(temp.getData().getName().equals(name)) {
				temp.remove();
				return true;
			}
		}
		return false;
	}

	public boolean remove(Item item){
		MyLinkedList<Item> temp;
		for(temp = list.getPrev(); temp != list; temp = temp.getPrev()) {
			if(temp.getData().equals(item)) {
				temp.remove();
				return true;
			}
		}
		return false;
	}

	public int removeAll(String name){
		int count = 0;
		for (MyLinkedList<Item> temp = list.getNext(); temp != list; temp = temp.getNext()) {
			if(temp.getData().getName().equals(name)) {
				temp.remove();
				count++;
			}
		}
		return count;
	}

	public int removeAll(Item item){
		int count = 0;
		for (MyLinkedList<Item> temp = list.getNext(); temp != list; temp = temp.getNext()) {
			if(temp.getData().equals(item)) {
				temp.remove();
				count++;
			}
		}
		return count;
	}

	public Item[] sortedItemsByCostDesc() {
		Item[] items = getItems();
		for (int i = 0; i < items.length; i++) {
			for (int j = 0; j < items.length - 1; j++) {
				if (items[j].getCost() < items[j + 1].getCost()) {
					Item temp = items[j];
					items[j] = items[j + 1];
					items[j + 1] = temp;
				}
			}
		}
		return items;
	}

	public int costTotal() {
		int total = 0;
		MyLinkedList<Item> temp;
		for (temp = list.getNext(); temp != list; temp = temp.getNext()) {
			if(temp.getData() != null) {
				total += temp.getData().getCost();
			}
		}
		return total;
	}

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}
}
