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

    public String getDescription() {
        return this.getService().getDescription();
    }

    public void setDescription(String description) {
        this.getService().setDescription(description);
    }

    public double getCost() {
        return this.getService().getCost();
    }

    public void setCost(double cost) {
        this.getService().setCost(cost);
    }

    public int getTime() {
        return this.getService().getDuration();
    }

    public void setDuration(int time) {
        this.getService().setDuration(time);
    }

    public User getUser(){
        return this.getService().getUser();
    }

    public void setUser(User user){
        this.getService().setUser(user);
    }

    public String newService(){
        this.setService(new Service());
        return "success";
    }

    public String createService(){
        sdService.createService(this.getService());
        return "success";
    }

    public String editService(Service service){
        this.setService(service);
        return "success";
    }

    public String updateService(){
        sdService.updateService(this.getService());
        return "success";
    }

    public String deleteService(Service service){
        sdService.deleteService(service.getId());
        return "success";
    }

}
