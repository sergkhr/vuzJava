package Prac24;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class ArrayListTester {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
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

		ArrayList<Integer> list2 = new ArrayList<Integer>(5);
		list2.add(1);
		list2.add(2);
		list2.add(3);
		list2.add(4);
		list2.add(5);
		System.out.println(list2);
		ArrayList list3 = new ArrayList(list2);
		list3.add(6);
		list3.add(7);
		System.out.println(list3);
		list3.addAll(list2);
		System.out.println(list3);
		System.out.println(list3.subList(1, 4)); //will be index 1, 2, 3
	}
}
