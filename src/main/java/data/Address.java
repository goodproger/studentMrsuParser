package data;

public class Address {
    private long id;
    private String city;
    private String street;
    private int house;
    private int floor;
    private int flatNumber;

    public Address(long id, String city, String street, int house, int floor, int flatNumber) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.house = house;
        this.floor = floor;
        this.flatNumber = flatNumber;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house=" + house +
                ", floor=" + floor +
                ", flatNumber=" + flatNumber +
                '}';
    }
}
