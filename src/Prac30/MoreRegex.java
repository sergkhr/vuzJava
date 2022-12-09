package Prac30;

import java.util.Scanner;
import java.util.regex.*;

public class MoreRegex {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("insert email");
		String line = in.nextLine();
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$");
		// form https://regexr.com/2rhq7 more or less
		Matcher matcher = pattern.matcher(line);
		if (matcher.matches()) {
			System.out.println("email is valid");
		} else {
			System.out.println("email is invalid");
		}

		System.out.println("insert password");
		line = in.nextLine();
		Pattern pattern1 = Pattern.compile("[A-Z]+");
		Pattern pattern2 = Pattern.compile("[a-z]+");
		Pattern pattern3 = Pattern.compile("[0-9]+");
		Matcher matcher1 = pattern1.matcher(line);
		Matcher matcher2 = pattern2.matcher(line);
		Matcher matcher3 = pattern3.matcher(line);
		if (matcher1.find() && matcher2.find() && matcher3.find()) {
			System.out.println("password is valid");
			if(line.length() >= 8) {
				System.out.println("password is strong");
			} else {
				System.out.println("password is weak");
			}
		} else {
			System.out.println("password is invalid");
		}
	}
}
