package pe.edu.utp.stylistsdeliveryp.models;

public class District {
    private int id;
    private String description;
    private Province province;

    public District() {
    }

    public District(int id, String description){
        this.setId(id);
        this.setDescription(description);
    }

    public District(int id, String description, Province province) {
        this.setId(id);
        this.setDescription(description);
        this.setProvince(province);
    }

    public int getId() {
        return id;
    }

    public District setId(int id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public District setDescription(String description) {
        this.description = description;
        return this;
    }

    public Province getProvince() {
        return province;
    }

    public District setProvince(Province province) {
        this.province = province;
        return this;
    }
}
