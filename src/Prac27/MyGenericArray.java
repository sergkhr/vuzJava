package Prac27;

public class MyGenericArray <E> {
	private E[] array;
	private int size;

	public MyGenericArray(int size) {
		this.size = size;
		array = (E[]) new Object[size];
	}

	public void set(int index, E element) {
		array[index] = element;
	}

	public E get(int index) {
		return array[index];
	}

	public int getSize() {
		return size;
	}
}
