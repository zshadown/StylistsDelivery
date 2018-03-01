package pe.edu.utp.stylistsdeliveryp.beans;

import pe.edu.utp.stylistsdeliveryp.models.Service;
import pe.edu.utp.stylistsdeliveryp.models.User;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;

@Named
@SessionScoped
public class ReservationsBean implements Serializable{
    private int id;
    private Date date;
    private  String address;
    private Service service;
    private User userst;
    private User userCli;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public User getUserst() {
        return userst;
    }

    public void setUserst(User userst) {
        this.userst = userst;
    }

    public User getUserCli() {
        return userCli;
    }

    public void setUserCli(User userCli) {
        this.userCli = userCli;
    }
}
