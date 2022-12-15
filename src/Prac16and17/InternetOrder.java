package Prac16and17;

public class InternetOrder implements Order {
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

	public boolean remove(String name){
		list.getLastByName(name).remove();
		return true;
	}

	public int size() {
		return list.size() - 1; //-1 is for start item
	}

	public Item[] items() {
		Item[] items = new Item[size()];
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

	public int countByName(String name) {
		int count = 0;
		MyLinkedList<Item> temp;
		for (temp = list.getNext(); temp != list; temp = temp.getNext()) {
			if(temp.getData() != null) {
				if(temp.getData().getName().equals(name)) {
					count++;
				}
			}
		}
		return count;
	}

	public String[] getNames() {
		String[] names = new String[size()];
		int i = 0;
		MyLinkedList<Item> temp;
		for (temp = list.getNext(); temp != list; temp = temp.getNext()) {
			if(temp.getData() != null) {
				boolean isDuplicate = false;
				for (int j = 0; j < i; j++) {
					if(temp.getData().getName().equals(names[j])) {
						isDuplicate = true;
						break;
					}
				}
				if(!isDuplicate) {
					names[i] = temp.getData().getName();
					i++;
				}
			}
		}
		return names;
	}

	public Item[] getSortedItems() {
		Item[] items = items();
		for (int i = 0; i < items.length; i++) {
			for (int j = 0; j < items.length - 1; j++) {
				if(items[j].getCost() < items[j + 1].getCost()) {
					Item temp = items[j];
					items[j] = items[j + 1];
					items[j + 1] = temp;
				}
			}
		}
		return items;
	}
}
