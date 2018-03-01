package pe.edu.utp.stylistsdeliveryp.models;

public class Province {
    private int id;
    private String description;

    public Province() {
    }

    public Province(int id, String description) {
        this.setId(id);
        this.setDescription(description);
    }


    public int getId() {
        return id;
    }

    public Province setId(int id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Province setDescription(String description) {
        this.description = description;
        return this;
    }
}
