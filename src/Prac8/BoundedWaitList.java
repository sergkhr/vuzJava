package Prac8;

/**
 * class for wait list, bounded by capacity
 * @param <E> type of elements in the list
 * @author Irvindt
 */
public class BoundedWaitList<E> extends WaitList<E> {
    private int capacity;
    public BoundedWaitList(int capacity) {
        super();
        this.capacity = capacity;
    }
    public int getCapacity() {
        return capacity;
    }
    @Override
    /**
     * add element to the end of the queue if the queue is not full
     * @param element to add
     */
    public void add(E element) {
        if (content.size() < capacity) {
            super.add(element);
        }
    }
    @Override
    public String toString() {
        return super.toString() + " capacity: " + capacity;
    }
}
