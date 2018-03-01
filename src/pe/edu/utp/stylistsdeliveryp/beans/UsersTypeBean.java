package pe.edu.utp.stylistsdeliveryp.beans;


import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named (value = "login")
public class UsersTypeBean implements Serializable{
    private String id;
    private String description;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public  String  doValidateInput(){
        return  "succes";
    }
}
