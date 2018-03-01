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

    public Date getDayPrincipal(){
        return this.getReservation().getDayPrincipal();
    }

    public void setDayPrincipal(Date dayPrincipal){
        this.getReservation().setDayPrincipal(dayPrincipal);
    }

    public String getAddress() {
        return this.getReservation().getAddress();
    }

    public void setAddress(String address) {
        this.getReservation().setAddress(address);
    }

    public Date getHourPrincipal(){
        return this.getReservation().getHourPrincipal();
    }

    public void setHourPrincipal(Date hourPrincipal){
        this.getReservation().setHourPrincipal(hourPrincipal);
    }

    public int getStatus(){
        return this.getReservation().getStatus();
    }

    public void setStatus(int status){
        this.getReservation().setStatus(status);
    }

    public Service getService(){
        return this.getReservation().getService();
    }

    public void setService(Service service){
        this.getReservation().setService(service);
    }

    public User getUserCli(){
        return this.getReservation().getUserCli();
    }

    public void setUserCli(User userCli){
        this.getReservation().setUserCli(userCli);
    }

    public User getUserSty(){
        return this.getReservation().getUserSty();
    }

    public void setUserSty(User userSty){
        this.getReservation().setUserSty(userSty);
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
