package pe.edu.utp.stylistsdeliveryp.beans;

import pe.edu.utp.stylistsdeliveryp.models.SdService;
import pe.edu.utp.stylistsdeliveryp.models.UserType;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
//UserTypeBean
@SessionScoped
@Named
public class UsersTypeBean implements Serializable{
    private SdService sdService;
    private UserType userType;

    public UsersTypeBean(){
        sdService = new SdService();
    }

    public List<UserType> getUserTypes(){
        return sdService.findAllUsersType();
    }

    public UserType getUserType(){
        return userType;
    }

    public void setUserType(UserType userType){
        this.userType = userType;
    }

    public String getDescription(){
        return this.getUserType().getDescription();
    }

    public void setDescription(String description){
        this.getUserType().setDescription(description);
    }

    public String newUserType(){
        this.setUserType(new UserType());
        return "success";
    }

    public String createUserType(){
        sdService.createUserType(this.getDescription());
        return "success";
    }

    public String editUserType(UserType userType){
        this.setUserType(userType);
        return "success";
    }

    public String updateUserType(){
        sdService.updateUserType(this.getUserType());
        return "success";
    }

    public String deleteUserType(UserType userType){
        sdService.deleteUserType(userType.getId());
        return "success";
    }

}
