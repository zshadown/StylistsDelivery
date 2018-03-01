package pe.edu.utp.stylistsdeliveryp.beans;

import pe.edu.utp.stylistsdeliveryp.models.District;
import pe.edu.utp.stylistsdeliveryp.models.Province;
import pe.edu.utp.stylistsdeliveryp.models.ProvincesEntity;
import pe.edu.utp.stylistsdeliveryp.models.SdService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

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

}
