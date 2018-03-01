package pe.edu.utp.stylistsdeliveryp.beans;

import pe.edu.utp.stylistsdeliveryp.models.District;
import pe.edu.utp.stylistsdeliveryp.models.SdService;
import pe.edu.utp.stylistsdeliveryp.models.User;
import pe.edu.utp.stylistsdeliveryp.models.UserType;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Named
@SessionScoped
public class UsersBean implements Serializable{
    private SdService sdService;
    private User user;

    public UsersBean() {
        sdService = new SdService();
    }

    public List<User> getUsers(){
        return sdService.findAllUsers();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFirstName(){
        return this.getUser().getFirstName();
    }

    public void setFirstName(String firstName){
        this.getUser().setFirstName(firstName);
    }

    public String getLastName(){
        return this.getUser().getLastName();
    }

    public void setLastName(String lastName){
        this.getUser().setLastName(lastName);
    }

    public Date getBirthday(){
        return this.getUser().getBirthday();
    }

    public void setBirthday(Date birthday){
        this.getUser().setBirthday(birthday);
    }

    public String getEmail(){
        return this.getUser().getEmail();
    }

    public void setEmail(String email){
        this.getUser().setEmail(email);
    }

    public int getDni(){
        return this.getUser().getDni();
    }

    public void setDni(int dni){
        this.getUser().setDni(dni);
    }

    public String getPassword(){
        return this.getUser().getPassword();
    }

    public void setPassword(String password){
        this.getUser().setPassword(password);
    }

    public UserType getUserType(){
        return this.getUser().getUserType();
    }

    public void setUserType(UserType userType){
        this.getUser().setUserType(userType);
    }

    public District getDistrict(){
        return this.getUser().getDistrict();
    }

    public void setDistrict(District district){
        this.getUser().setDistrict(district);
    }

    public String newUser(){
        this.setUser(new User());
        return "success";
    }

    public String createUser(){
        sdService.createUser(this.getUser());
        return "success";
    }

    public String editUser(User user){
        this.setUser(user);
        return "success";
    }

    public String updateUser(){
        sdService.updateUser(this.getUser());
        return "success";
    }

    public String deleteUser(User user){
        sdService.deleteUser(user.getId());
        return "success";
    }

}
