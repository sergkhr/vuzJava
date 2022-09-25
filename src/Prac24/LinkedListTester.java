package Prac24;

import java.util.LinkedList;

public class LinkedListTester {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.add("Hello");
		list.add("World");
		list.add("!");
		System.out.println(list);
		list.remove(1);
		System.out.println(list);
		list.add(1, "Strong");
		System.out.println(list);
		list.set(1, "Earth");
		System.out.println(list);
		System.out.println(list.get(1));
		System.out.println(list.size());
		System.out.println(list.indexOf("Earth"));
		System.out.println(list.indexOf("Strong"));
		System.out.println(list.contains("Earth"));
		System.out.println(list.contains("Strong"));
		System.out.println(list.isEmpty());
		list.clear();
		System.out.println(list.isEmpty());

		LinkedList<Integer> list2 = new LinkedList<Integer>();
		list2.add(1);
		list2.add(2);
		list2.add(3);
		list2.add(4);
		list2.add(5);
		System.out.println(list2);
		LinkedList list3 = new LinkedList(list2);
		list3.add(6);
		list3.add(7);
		System.out.println(list3);
		list3.addAll(list2);
		System.out.println(list3);
		System.out.println(list3.subList(1, 4)); //will be index 1, 2, 3

		LinkedList<Integer> list4 = new LinkedList<Integer>();
		list4.addFirst(10);
		list4.addFirst(20);
		list4.addLast(30);
		list4.addLast(40);
		System.out.println(list4);
		System.out.println(list4.getFirst());
		System.out.println(list4.getLast());
		System.out.println(list4);
		System.out.println(list4.removeFirst());
		System.out.println(list4.pollLast());
		System.out.println(list4);;

	}
}
