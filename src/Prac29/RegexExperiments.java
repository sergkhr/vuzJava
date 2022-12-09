package Prac29;

import java.util.Scanner;
import java.util.regex.*;

public class RegexExperiments {
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("insert line with prices");
		String line = in.nextLine();
		Pattern pattern = Pattern.compile("\\d+[.]?\\d+\\s(USD|EU|RUB)");
		Matcher matcher = pattern.matcher(line);
		while(matcher.find()){
			System.out.println(matcher.group());
		}

		System.out.println("insert line with digits and symbols");
		line = in.nextLine();
		pattern = Pattern.compile("\\d\\s[+]");
		matcher = pattern.matcher(line);
		System.out.println("is there a digit followed by symbol '+' in the line?");
		if(matcher.find()){
			System.out.print("there is: ");
			System.out.println(matcher.group());
		}
		else{
			System.out.println("there is no");
		}

		System.out.println("insert line with date");
		line = in.nextLine();
		//date format: dd/mm/yyyy from year 1900 to year 9999 and checks february has no more than 28 days and 29 days in leap years
		pattern = Pattern.compile("((0[1-9]|[12][0-9]|3[01])/(0[13578]|1[02])/((19|[2-9]\\d)\\d\\d))|((0[1-9]|[12][0-9]|30)/(0[469]|11)/((19|[2-9]\\d)\\d\\d))|((0[1-9]|1\\d|2[0-8])/02/((19|[2-9]\\d)\\d\\d))|((29)/02/(((19|[2-9]\\d)(0[48]|[2468][048]|[13579][26]))|(([2468][048]|[3579][26])(00))))");
		//in this shit above I explicitly check for 29 february, tha is when year can be devided by 4 not by 100 but by 400 can.
		//pattern = Pattern.compile("((0[1-9])|([12][0-9])|(3[01]))/((0[1-9])|(1[012]))/((19[0-9][0-9])|([2-9][0-9][0-9][0-9]))");
		matcher = pattern.matcher(line);
		System.out.println("is the line a date?");
		if(matcher.matches()){
			System.out.print("it is: ");
			System.out.println(matcher.group());
		}
		else{
			System.out.println("it is not");
		}
	}
}
