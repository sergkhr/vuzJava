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

	public static void main(String[] args) {
		MyGenericArray<Integer> intArray = new MyGenericArray<Integer>(10);
		for (int i = 0; i < intArray.getSize(); i++) {
			intArray.set(i, i);
		}
		for (int i = 0; i < intArray.getSize(); i++) {
			System.out.println(intArray.get(i));
		}
		MyGenericArray<Double> doubleArray = new MyGenericArray<Double>(10);
		for (int i = 0; i < doubleArray.getSize(); i++) {
			doubleArray.set(i, i * 1.1);
		}
		for (int i = 0; i < doubleArray.getSize(); i++) {
			System.out.println(doubleArray.get(i));
		}
	}
}
