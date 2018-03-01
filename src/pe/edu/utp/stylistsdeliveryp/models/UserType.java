package pe.edu.utp.stylistsdeliveryp.models;

public class UserType {
    private int id;
    private String description;

    public UserType() {
    }

    public UserType(int id, String description) {
        this.setId(id);
        this.setDescription(description);
    }

    public int getId() {
        return id;
    }

    public UserType setId(int id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public UserType setDescription(String description) {
        this.description = description;
        return this;
    }
}
