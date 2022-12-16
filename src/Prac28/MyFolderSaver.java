package Prac28;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class MyFolderSaver {
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("enter the path to the folder");
		String path = in.nextLine();
		File folder = new File(path);
		LinkedList<String> list = new LinkedList<String>();
		for (File file : folder.listFiles()) {
			list.add(file.getName());
		}
		for (int i = 0; i < 5 && i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	//path starts at vuzJava by default
}
