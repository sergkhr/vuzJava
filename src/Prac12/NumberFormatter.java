package Prac12;

import java.util.Scanner;

public class NumberFormatter {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter phone number");
		String number = in.nextLine();
		StringBuffer formattedNumber = new StringBuffer();
		if(!((number.substring(0, 1).equals("8") && number.length() == 11) || number.substring(0,1).equals("+"))){
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
			int numberLength = number.length();
			formattedNumber.append(number.substring(0, numberLength - 10));
			formattedNumber.append(number.substring(numberLength - 10, numberLength - 7));
			formattedNumber.append("-");
			formattedNumber.append(number.substring(numberLength - 7, numberLength - 4));
			formattedNumber.append("-");
			formattedNumber.append(number.substring(numberLength - 4));
		}
		System.out.println(formattedNumber);
	}
}

