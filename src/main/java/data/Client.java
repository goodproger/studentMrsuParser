package data;

public class Client {
    private long id;
    private String name;
    private String personnelNumber;
    private long addressId;

    public Client(long id, String name, String personnelNumber, long addressId) {
        this.id = id;
        this.name = name;
        this.personnelNumber = personnelNumber;
        this.addressId = addressId;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", personnelNumber='" + personnelNumber + '\'' +
                ", addressId=" + addressId +
                '}';
    }
}
