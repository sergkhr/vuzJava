package Recurssiontask;

import java.util.Scanner;

//todo more tasks
public class RecursionTasks {
	private static Scanner in = new Scanner(System.in);

	public static void taskPicker(){
		System.out.println("Choose a task to run: 1-3 (print number (no fool proof))");
		int task = in.nextInt();
		switch (task){
			case 1:
				task1();
				break;
			case 2:
				task2();
				break;
			case 3:
				task3();
				break;
			default:
				break;
		}
	}


	private static void task1(){
		System.out.println("Enter a number");
		int n = in.nextInt();
		task1Rec(n);
	}
	private static void task1Rec(int n){
		if(n > 0){
			task1Rec(n-1);
			for(int i = 0; i < n; i++){
				System.out.print(n + " ");
			}
		}
		return;
	}


	private static void task2(){
		System.out.println("Enter a number");
		int n = in.nextInt();
		task2Rec(n);
	}
	private static void task2Rec(int n){
		if(n > 0){
			task2Rec(n-1);
			System.out.print(n + " ");
		}
		return;
	}


	private static void task3(){
		System.out.println("Enter two numbers");
		int a = in.nextInt();
		int b = in.nextInt();
		task3Rec(a, b);
	}
	private static void task3Rec(int a, int b){
		if(a != b){
			System.out.print(a + " ");
			task3Rec(a + (b-a)/Math.abs(b-a), b); //I think this is less efficient than if... but... it's more fun
		}
		else {
			System.out.println(a);
		}
	}
}
