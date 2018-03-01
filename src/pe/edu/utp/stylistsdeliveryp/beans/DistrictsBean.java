package pe.edu.utp.stylistsdeliveryp.beans;

import pe.edu.utp.stylistsdeliveryp.models.District;
import pe.edu.utp.stylistsdeliveryp.models.Province;
import pe.edu.utp.stylistsdeliveryp.models.ProvincesEntity;
import pe.edu.utp.stylistsdeliveryp.models.SdService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
//DistrictBean
@Named
@SessionScoped
//Districts Beans
public class DistrictsBean implements Serializable {
    private SdService sdService;
    private District district;
    private ProvincesEntity provincesEntity;

    public DistrictsBean(){
        sdService = new SdService();
    }

    public List<District> getDistricts(ProvincesEntity provincesEntity){
        return sdService.findAllDistricts();
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public String getDescription() {
        return this.getDistrict().getDescription ();
    }

    public void setDescription(String description) {

        this.getDistrict().setDescription(description);
    }

    public String newDistric() {
        this.setDistrict(new District());
        return "success";
    }

    public String createDistrict() {
        sdService.createDistrict(this.getDescription());
        return "success";
    }

    public String editDistrict(District district) {
        this.setDistrict(district);
        return "success";
    }

    public String updateDistrict() {
        sdService.updateDistrict(this.getDistrict());
        return "success";
    }

    public String deleteDistric(District district) {
        sdService.deleteDistrict(district.getId());
        return "success";
    }

}




