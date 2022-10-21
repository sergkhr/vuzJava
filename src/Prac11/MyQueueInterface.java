package Prac11;

public interface MyQueueInterface<E> {
    public void pushBack(E element);
    public E popFront();
    public E peekFront();
    public boolean isEmpty();
    public int size();

    public static void main(String[] args) {
        MyLinkedQueue<Integer> queue = new MyLinkedQueue<Integer>();
        queue.pushBack(1);
        queue.pushBack(2);
        queue.pushBack(3);
        queue.pushBack(4);
        queue.pushBack(5);
        System.out.println(queue);
        System.out.println(queue.popFront());
        System.out.println(queue);
        System.out.println(queue.peekFront());
        System.out.println(queue);
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
        System.out.println("now array queue");
        MyArrayQueue<Integer> queue2 = new MyArrayQueue<Integer>();
        queue2.pushBack(1);
        queue2.pushBack(2);
        queue2.pushBack(3);
        queue2.pushBack(4);
        queue2.pushBack(5);
        System.out.println(queue2);
        System.out.println(queue2.popFront());
        System.out.println(queue2);
        System.out.println(queue2.peekFront());
        System.out.println(queue2);
        System.out.println(queue2.isEmpty());
        System.out.println(queue2.size());

    }
}
