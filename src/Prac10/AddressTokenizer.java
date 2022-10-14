package Prac10;

import java.util.StringTokenizer;

public class AddressTokenizer {
	private String country;
	private String region;
	private String city;
	private String street;
	private String house;
	private String building;
	private String flat;

	public void tokenizeBySymbol(String address, String symbol) {
		String[] tokens = address.split(symbol);
		if(tokens.length != 7) {
			System.out.println("Wrong address");
			return;
		}
		country = tokens[0].strip();
		region = tokens[1].strip();
		city = tokens[2].strip();
		street = tokens[3].strip();
		house = tokens[4].strip();
		building = tokens[5].strip();
		flat = tokens[6].strip();
	}

	public void tokenize(String address){
		StringTokenizer tokenizer = new StringTokenizer(address, ",.;-");
		if(tokenizer.countTokens() != 7) {
			System.out.println("Wrong address");
			return;
		}
		country = tokenizer.nextToken().strip();
		region = tokenizer.nextToken().strip();
		city = tokenizer.nextToken().strip();
		street = tokenizer.nextToken().strip();
		house = tokenizer.nextToken().strip();
		building = tokenizer.nextToken().strip();
		flat = tokenizer.nextToken().strip();
	}

	public String getCountry() {
		return country;
	}

	public String getRegion() {
		return region;
	}

	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}

	public String getHouse() {
		return house;
	}

	public String getBuilding() {
		return building;
	}

	public String getFlat() {
		return flat;
	}
	@Override
	public String toString() {
		return "AddressTokenizer [country=" + country + ", region=" + region + ", city=" + city + ", street=" + street
				+ ", house=" + house + ", building=" + building + ", flat=" + flat + "]";
	}

	public static void main(String[] args) {
		AddressTokenizer tokenizer = new AddressTokenizer();
		String address = "Russia; Moscow, Moscow. Lenina, 1-1, 1";
		tokenizer.tokenize(address);
		System.out.println(address);
		System.out.println(tokenizer.getCountry());
		System.out.println(tokenizer.getRegion());
		System.out.println(tokenizer.getCity());
		System.out.println(tokenizer.getStreet());
		System.out.println(tokenizer.getHouse());
		System.out.println(tokenizer.getBuilding());
		System.out.println(tokenizer.getFlat());
		String address2 = "Russia; Moscow; Moscow;Lenina; 1;1; 1";
		tokenizer.tokenizeBySymbol(address2, ";");
		System.out.println(address2);
		System.out.println(tokenizer.getCountry());
		System.out.println(tokenizer.getRegion());
		System.out.println(tokenizer.getCity());
		System.out.println(tokenizer.getStreet());
		System.out.println(tokenizer.getHouse());
		System.out.println(tokenizer.getBuilding());
		System.out.println(tokenizer.getFlat());
		String address3 = "Russia.Moscow.Moscow;Levia; 54,112 . 1";
		tokenizer.tokenize(address3);
		System.out.println(tokenizer);
		String address4 = "Russia.SPB.SPB-Gde_to- 666,123 .191";
		tokenizer.tokenize(address4);
		System.out.println(tokenizer);
	}
}
