package Prac12;

import java.util.Scanner;

public class NumberFormatter {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter phone number");
		String number = in.nextLine();
		StringBuffer formattedNumber = new StringBuffer();
		if(!((number.substring(0, 1).equals("8") && number.length() == 11) || (number.substring(0,2).equals("+7") && number.length() == 12))){
			System.out.println("Wrong number");
			return;
		}
		if(number.substring(0, 1).equals("8")){
			formattedNumber.append("+7");
			formattedNumber.append(number.substring(1, 4));
			formattedNumber.append("-");
			formattedNumber.append(number.substring(4, 7));
			formattedNumber.append("-");
			formattedNumber.append(number.substring(7));
		}
		else{
			formattedNumber.append(number.substring(0, 2));
			formattedNumber.append(number.substring(2, 5));
			formattedNumber.append("-");
			formattedNumber.append(number.substring(5, 8));
			formattedNumber.append("-");
			formattedNumber.append(number.substring(8));
		}
		System.out.println(formattedNumber);
	}
}

