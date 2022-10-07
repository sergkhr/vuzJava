package Prac8;

import java.util.Collection;

/**
 * interface for Wait list classes
 * @param <E> type of elements in the list
 * @author Irvindt
 */
public interface IWaitList<E> {
    public void add(E element);
    public E remove();
    public boolean contains(E element);
    public boolean containsAll(Collection<E> c);
    public boolean isEmpty();

    public static void main(String[] args) {
        BoundedWaitList<Integer> boundedWaitList = new BoundedWaitList<Integer>(5);
        boundedWaitList.add(1);
        WaitList<Integer> waitList = new WaitList<Integer>();
        waitList.add(2);
        waitList.add(3);
        waitList.add(4);
        System.out.println(waitList);
        boundedWaitList.add(2);
        boundedWaitList.add(3);
        System.out.println(boundedWaitList);
        System.out.println("taking from boundedWaitList: " + boundedWaitList.remove());
        System.out.println(boundedWaitList);
        System.out.println("adding to boundedW wait list 1, 2, 3, 4, 5");
        boundedWaitList.add(1);
        boundedWaitList.add(2);
        boundedWaitList.add(3);
        boundedWaitList.add(4);
        boundedWaitList.add(5);
        System.out.println(boundedWaitList);
    }
}
