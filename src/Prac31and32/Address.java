package Prac31and32;

public final class Address {
    private String  cityName;
    private int    zipCode;
    private String  streetName;
    private int    buildingNumber;
    private char    buildingLetter;
    private int    apartmentNumber;
    public static final Address EMPTY_ADDRESS = new Address("Unknown", 0, "Unknown", 0, ' ', 0);
    public Address() {
        cityName = "";
        zipCode = 0;
        streetName = "";
        buildingNumber = 0;
        buildingLetter = ' ';
        apartmentNumber = 0;
    }

    public Address(String cityName, int zipCode, String streetName, int buildingNumber, char buildingLetter, int apartmentNumber) {
        this.cityName = cityName;
        this.zipCode = zipCode;
        this.streetName = streetName;
        this.buildingNumber = buildingNumber;
        this.buildingLetter = buildingLetter;
        this.apartmentNumber = apartmentNumber;
    }

    public String getCityName() {
        return cityName;
    }
    public int getZipCode() {
        return zipCode;
    }
    public String getStreetName() {
        return streetName;
    }
    public int getBuildingNumber() {
        return buildingNumber;
    }
    public char getBuildingLetter() {
        return buildingLetter;
    }
    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public boolean equals(Address address) {
        return (this.cityName.equals(address.cityName) && this.zipCode == address.zipCode && this.streetName.equals(address.streetName) && this.buildingNumber == address.buildingNumber && this.buildingLetter == address.buildingLetter && this.apartmentNumber == address.apartmentNumber);
    }
}
