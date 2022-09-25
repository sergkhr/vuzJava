package Prac25;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class FileWorker {
	public static void main(String[] args) throws FileNotFoundException { //well I thought why not make this thing able to throw exception instead of writing try-catch block
		File file = new File("src/Prac25/file.txt");

		Scanner in = new Scanner(System.in);
		try{
			Scanner fin = new Scanner(file);
		}
		catch(FileNotFoundException e){
			System.out.println("file not found, creating new one");
			try{
				file.createNewFile();
			}
			catch(Exception e1){
				System.out.println("something went wrong");
			}
		}

		System.out.println("insert your text here");
		String text = in.nextLine();
		System.out.println("do you want to append or rewrite file? (a/r)   (default is rewrite)");
		String answer = in.nextLine();
		if (answer.equals("a")) {
			try {
				FileWriter writer = new FileWriter(file, true);
				writer.write((text + "\n")); //what the fuck, for it to actually concatenate strings i need to add additional () around them
				writer.close();
			} catch (Exception e) {
				System.out.println("something went wrong");
			}
		} else {
			try {
				FileWriter writer = new FileWriter(file);
				writer.write((text + "\n"));
				writer.close();
			} catch (Exception e) {
				System.out.println("something went wrong");
			}
		}
		System.out.println("your file contains:");
		try{
			Scanner fin = new Scanner(file);
			while(fin.hasNextLine()){
				System.out.println(fin.nextLine());
			}
		}
		catch(FileNotFoundException e){
			System.out.println("file not found");
		}
	}
}
