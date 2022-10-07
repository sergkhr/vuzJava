package Prac8;

/**
 * class for wait list, capable of removing elements from the middle of the queue
 * or moving them to the end of the queue
 * @param <E> type of elements in the list
 * @author Irvindt
 */
public class UnfairWaitList<E> extends WaitList<E> {
    public UnfairWaitList() {
        super();
    }
    /**
     * remove first found element from the queue
     * @param element to remove
     */
    public void remove(E element) {
        content.remove(element);
    }

    /**
     * move first found element to the end of the queue
     * @param element
     */
    public void moveToBack(E element) {
        content.remove(element);
        content.add(element);
    }
}
