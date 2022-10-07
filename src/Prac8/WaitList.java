package Prac8;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * class for Wait list classes based on ConcurrentLinkedQueue
 * @param <E> type of elements in the list
 * @author Irvindt
 */

public class WaitList<E> implements IWaitList<E> {
    protected ConcurrentLinkedQueue<E> content;
    public WaitList() {
        content = new ConcurrentLinkedQueue<E>();
    }
    public WaitList(Collection<E> c) {
        content = new ConcurrentLinkedQueue<E>(c);
    }

    /**
     * add element to the end of the queue
     * @param element to add
     */
    public void add(E element) {
        content.add(element);
    }
    /**
     * remove element from the beginning of the queue
     * @return removed element
     */
    public E remove() {
        return content.poll();
    }
    public boolean contains(E element) {
        return content.contains(element);
    }
    public boolean containsAll(Collection<E> c) {
        return content.containsAll(c);
    }
    public boolean isEmpty() {
        return content.isEmpty();
    }

    @Override
    public String toString() {
        return content.toString();
    }
}
