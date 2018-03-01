package pe.edu.utp.stylistsdeliveryp.models;

import java.util.Date;

public class Reservation {

    private int id;
    private Date dayPrincipal;
    private String address;
    private Date hourPrincipal;
    private int status;
    private Service service;
    private User userCli;
    private User userSty;

    public Reservation() {
    }

    public Reservation(int id, Date dayPrincipal, String address, Date hourPrincipal, int status, Service service, User userCli, User userSty) {
        this.id = id;
        this.setDayPrincipal(dayPrincipal);
        this.address = address;
        this.setHourPrincipal(hourPrincipal);
        this.setStatus(status);
        this.service = service;
        this.setUserCli(userCli);
        this.setUserSty(userSty);
    }

    public int getId() {
        return id;
    }

    public Reservation setId(int id) {
        this.id = id;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Reservation setAddress(String address) {
        this.address = address;
        return this;
    }

    public Service getService() {
        return service;
    }

    public Reservation setService(Service service) {
        this.service = service;
        return this;
    }

    public Date getDayPrincipal() {
        return dayPrincipal;
    }

    public Reservation setDayPrincipal(Date dayPrincipal) {
        this.dayPrincipal = dayPrincipal;
        return this;
    }

    public Date getHourPrincipal() {
        return hourPrincipal;
    }

    public Reservation setHourPrincipal(Date hourPrincipal) {
        this.hourPrincipal = hourPrincipal;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public Reservation setStatus(int status) {
        this.status = status;
        return this;
    }

    public User getUserCli() {
        return userCli;
    }

    public Reservation setUserCli(User userCli) {
        this.userCli = userCli;
        return this;
    }

    public User getUserSty() {
        return userSty;
    }

    public Reservation setUserSty(User userSty) {
        this.userSty = userSty;
        return this;
    }
}
