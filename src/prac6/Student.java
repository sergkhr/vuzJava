package prac6;

import java.util.Arrays;

public class Student {
	private String name;
	private int idNumber;

	public Student(String name, int idNumber) {
		this.name = name;
		this.idNumber = idNumber;
	}
	public Student(){
		this.name = "John Doe";
		this.idNumber = 0;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}
	public String toString() {
		return "[" + name + ", idNumber " + idNumber + "]";
	}

	public static void studentTest(){
		Student[] students = new Student[10];
		for (int i = 0; i < students.length; i++) {
			students[i] = new Student("Student " + i, (int)(Math.random()*100));
		}
		System.out.println(Arrays.toString(students));
		insertionSort(students);
		System.out.println(Arrays.toString(students));
	}
	public static void insertionSort(Student[] arr){
		for (int i = 1; i < arr.length; i++) {
			Student temp = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j].idNumber > temp.idNumber) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = temp;
		}
	}
}
