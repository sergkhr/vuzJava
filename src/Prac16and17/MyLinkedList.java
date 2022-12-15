package Prac16and17;

public class MyLinkedList<E> {
	private MyLinkedList<E> next;
	private MyLinkedList<E> prev;
	private E data;

	public MyLinkedList(E data) {
		this.data = data;
		this.next = this;
		this.prev = this;
	}
	public MyLinkedList(E data, MyLinkedList<E> next, MyLinkedList<E> prev) {
		this.data = data;
		this.next = next;
		this.prev = prev;
	}
	public MyLinkedList<E> getNext() {
		return next;
	}
	public void setNext(MyLinkedList<E> next) {
		this.next = next;
	}
	public MyLinkedList<E> getPrev() {
		return prev;
	}
	public void setPrev(MyLinkedList<E> prev) {
		this.prev = prev;
	}
	public E getData() {
		return data;
	}
	public void setData(E data) {
		this.data = data;
	}

	public void add(E data) {
		MyLinkedList<E> temp = new MyLinkedList<E>(data);
		temp.setNext(this);
		temp.setPrev(this.getPrev());
		this.getPrev().setNext(temp);
		this.setPrev(temp);
	}

	public void remove() {
		this.getPrev().setNext(this.getNext());
		this.getNext().setPrev(this.getPrev());
	}

	public E get(int index) {
		MyLinkedList<E> temp = this;
		for (int i = 0; i < index; i++) {
			temp = temp.getNext();
		}
		return temp.getData();
	}

	public MyLinkedList<E> getFirstByName(String name) {
		MyLinkedList<E> temp = this;
		while (temp.getNext() != this) {
			temp = temp.getNext();
			if (temp.getData().toString().equals(name)) {
				return temp;
			}
		}
		return null;
	}

	public MyLinkedList<E> getLastByName(String name) {
		MyLinkedList<E> temp = this;
		while (temp.getPrev() != this) {
			temp = temp.getPrev();
			if (temp.getData().toString().equals(name)) {
				return temp;
			}
		}
		return null;
	}

	public int size() {
		MyLinkedList<E> temp = this;
		int size = 0;
		while (temp.getNext() != this) {
			temp = temp.getNext();
			size++;
		}
		return size;
	}
}
