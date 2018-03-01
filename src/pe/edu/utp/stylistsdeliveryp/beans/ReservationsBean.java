package pe.edu.utp.stylistsdeliveryp.beans;

import pe.edu.utp.stylistsdeliveryp.models.Reservation;
import pe.edu.utp.stylistsdeliveryp.models.SdService;
import pe.edu.utp.stylistsdeliveryp.models.Service;
import pe.edu.utp.stylistsdeliveryp.models.User;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Named
@SessionScoped
public class ReservationsBean implements Serializable{

    private SdService sdService;
    private Reservation reservation;

    public ReservationsBean(){
        sdService = new SdService();
    }

    public List<Reservation> getReservations(){
        return sdService.findAllReservation();
    }

    public Reservation getReservation(){
        return reservation;
    }

    public void setReservation(Reservation reservation){
        this.reservation = reservation;
    }

    public String getDay(){
        return this.getReservation().getDay();
    }

    public void setDay(String day){
        this.getReservation().setDay(day);
    }

    public String getAddress() {
        return this.getReservation().getAddress();
    }

    public void setAddress(String address) {
        this.getReservation().setAddress(address);
    }

    public String getTime(){
        return this.getReservation().getTime();
    }

    public void setTime(String time){
        this.getReservation().setTime(time);
    }

    public String getState(){
        return this.getReservation().getState();
    }

    public void setState(String state){
        this.getReservation().setState(state);
    }

    public Service getService(){
        return this.getReservation().getService();
    }

    public void setService(Service service){
        this.getReservation().setService(service);
    }

    public User getUser(){
        return this.getReservation().getUser();
    }

    public void setUser(User user){
        this.getReservation().setUser(user);
    }

    public String newReservation(){
        this.setReservation(new Reservation());
        return "success";
    }

    public String createReservation(){
        sdService.createReservation(this.getReservation());
        return "success";
    }

    public String editReservation(Reservation reservation){
        this.setReservation(reservation);
        return "success";
    }

    public String updateReservation(){
        sdService.updateReservation(this.getReservation());
        return "success";
    }

    public String deleteReservation(Reservation reservation){
        sdService.deleteReservation(reservation.getId());
        return "success";
    }


}
