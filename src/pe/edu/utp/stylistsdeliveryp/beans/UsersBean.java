package pe.edu.utp.stylistsdeliveryp.beans;

import pe.edu.utp.stylistsdeliveryp.models.SdService;
import pe.edu.utp.stylistsdeliveryp.models.User;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class UsersBean implements Serializable{
    private SdService sdService;
    private User user;

    public UsersBean() {
        sdService = new SdService();
    }

    /*public List<User> getUsers(){
        return sdService.findAllUsers();
    }*/

    //////////////////COMENTADO

    public User getUser(){
        return user;
    }


}
