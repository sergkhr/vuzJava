package Prac11;

import java.util.LinkedList;

public class MyLinkedQueue<E> implements MyQueueInterface<E>{
    private LinkedList<E> list = new LinkedList<E>();
    public MyLinkedQueue() {
    }
    public MyLinkedQueue(LinkedList<E> list) {
        this.list = list;
    }
    @Override
    public void pushBack(E element) {
        list.addLast(element);
    }
    @Override
    public E popFront() {
        return list.removeFirst();
    }
    @Override
    public E peekFront() {
        return list.getFirst();
    }
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
    @Override
    public int size() {
        return list.size();
    }
    @Override
    public String toString() {
        return list.toString();
    }
}
