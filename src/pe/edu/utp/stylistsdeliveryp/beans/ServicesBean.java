package pe.edu.utp.stylistsdeliveryp.beans;

import pe.edu.utp.stylistsdeliveryp.models.SdService;
import pe.edu.utp.stylistsdeliveryp.models.Service;
import pe.edu.utp.stylistsdeliveryp.models.User;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ServicesBean implements Serializable{
    private SdService sdService;
    private Service service;

    public ServicesBean(){
        sdService = new SdService();
    }

    public List<Service> getServices(){
        return sdService.findAllService();
    }

    public Service getService(){
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }




}
