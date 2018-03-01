package pe.edu.utp.stylistsdeliveryp.models;

public class Reservation {

    private int id;
    private String day;
    private String address;
    private String time;
    private String state;
    private Service service;
    private User user;

    public Reservation() {
    }

    public Reservation(int id, String day, String address, String time, String state, Service service, User user) {
        this.setId(id);
        this.setDay(day);
        this.setAddress(address);
        this.setTime(time);
        this.setState(state);
        this.setService(service);
        this.setUser(user);
    }

    public int getId() {
        return id;
    }

    public Reservation setId(int id) {
        this.id = id;
        return this;
    }

    public String getDay() {
        return day;
    }

    public Reservation setDay(String day) {
        this.day = day;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Reservation setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getTime() {
        return time;
    }

    public Reservation setTime(String time) {
        this.time = time;
        return this;
    }

    public String getState() {
        return state;
    }

    public Reservation setState(String state) {
        this.state = state;
        return this;
    }

    public Service getService() {
        return service;
    }

    public Reservation setService(Service service) {
        this.service = service;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Reservation setUser(User user) {
        this.user = user;
        return this;
    }
}
