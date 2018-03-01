package pe.edu.utp.stylistsdeliveryp.beans;

import pe.edu.utp.stylistsdeliveryp.models.Province;
import pe.edu.utp.stylistsdeliveryp.models.ProvincesEntity;
import pe.edu.utp.stylistsdeliveryp.models.SdService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
//ProvicesBean
@Named
@SessionScoped
public class ProvincesBean implements Serializable {
    private SdService sdService;
    private Province province;


    public ProvincesBean(){
        sdService = new SdService();
    }

    public List<Province> getProvinces(ProvincesEntity provincesEntity){
        return sdService.findAllProvinces();
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public String getDescription() {
        return this.getProvince().getDescription ();
    }

    public void setDescription(String description) {

        this.getProvince().setDescription(description);
    }

    public String newProvince() {
        this.setProvince(new Province());
        return "success";
    }

    public String createProvince() {
        sdService.createProvince(this.getDescription());
        return "success";
    }

    public String editProvince(Province province) {
        this.setProvince(province);
        return "success";
    }

    public String updateProvince() {
        sdService.updateProvince(this.getProvince());
        return "success";
    }

    public String deleteProvince(Province province) {
        sdService.deleteProvince(province.getId());
        return "success";
    }
}
