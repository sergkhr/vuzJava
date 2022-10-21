package Prac11;

public class MyArrayQueue<E> implements MyQueueInterface<E>{
    private E[] array;
    private int size;
    private  int capacity;
    private int front;
    private int back;
    public MyArrayQueue(int capacity) {
        array = (E[]) new Object[capacity];
        size = 0;
        front = 0;
        back = 0;
        this.capacity = capacity;
    }
    public MyArrayQueue() {
        this(10);
    }
    @Override
    public void pushBack(E element) {
        if (size == capacity) {
            E[] newArray = (E[]) new Object[capacity * 2];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[(front + i) % capacity];
            }
            array = newArray;
            front = 0;
            back = size;
            capacity *= 2;
        }
        array[back] = element;
        back = (back + 1) % capacity;
        size++;
    }
    @Override
    public E popFront() {
        E element = array[front];
        front = (front + 1) % capacity;
        size--;
        return element;
    }
    @Override
    public E peekFront() {
        return array[front];
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public String toString() {
        String str = "[";
        for (int i = 0; i < size; i++) {
            str += array[(front + i) % capacity];
            if (i != size - 1) {
                str += ", ";
            }
        }
        str += "]";
        return str;
    }
}
