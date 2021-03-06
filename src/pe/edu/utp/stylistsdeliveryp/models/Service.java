package pe.edu.utp.stylistsdeliveryp.models;

public class Service {
    private int id;
    private String description;
    private double cost;
    private int duration;
    private User user;
    public Service() {
    }

    public Service(int id, String description, double cost, int duration, User user) {
        this.setId(id);
        this.setDescription(description);
        this.setCost(cost);
        this.setDuration(duration);
        this.setUser(user);
    }

    public int getId() {
        return id;
    }

    public Service setId(int id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Service setDescription(String description) {
        this.description = description;
        return this;
    }

    public double getCost() {
        return cost;
    }

    public Service setCost(double cost) {
        this.cost = cost;
        return this;
    }

    public int getDuration() {
        return duration;
    }

    public Service setDuration(int duration) {
        this.duration = duration;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Service setUser(User user) {
        this.user = user;
        return this;
    }
}
