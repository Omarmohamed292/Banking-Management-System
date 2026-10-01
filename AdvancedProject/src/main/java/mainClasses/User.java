package mainClasses;

public class User {
    private String name;
    private String id;
    private String phoneNumber;

    public User(String name, String phoneNumber, String id) {
        setName(name);
        setPhoneNumber(phoneNumber);
        setId(id);
    }

    public String getId() { return id; }
    public void setId(String id) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("ID cannot be blank");
        this.id = id.trim();
    }

    public String getName() { return name; }
    public void setName(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name cannot be blank");
        this.name = name.trim();
    }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isBlank()) throw new IllegalArgumentException("Phone cannot be blank");
        this.phoneNumber = phoneNumber.trim();
    }
}
