package pe.edu.utp.stylistsdeliveryp.models;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SdService {
    private Connection connection;
    private ProvincesEntity provincesEntity;
    private DistrictsEntity districtsEntity;
    private ServicesEntity servicesEntity;
    private UsersEntity usersEntity;
    private UsersTypeEntity usersTypeEntity;

    /*Connection con la BD MySQLSource1 del Glafish*/
    private Connection getConnection() {
        if(connection ==null){
            try {
                connection = ((DataSource) InitialContext.doLookup("jdbc/MySQLDataSource1"))
                        .getConnection();
            } catch (NamingException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    /*Metodo Entity Provinces*/
    protected ProvincesEntity getProvincesEntity() {
        if(getConnection() != null) {
            if(provincesEntity == null) {
                provincesEntity = new ProvincesEntity();
                provincesEntity.setConnection(getConnection());
            }
        }
        return provincesEntity;
    }

    /*Metodo Entity Districts*/
    protected DistrictsEntity getDistrictsEntity(){
        if(getConnection() != null) {
            if(districtsEntity == null) {
               districtsEntity = new DistrictsEntity();
               districtsEntity.setConnection(getConnection());
            }
        }
        return districtsEntity;
    }

    /*Metodo Entity Services*/
    protected ServicesEntity getServicesEntity(){
        if(getConnection() != null) {
            if(servicesEntity == null) {
                servicesEntity = new ServicesEntity();
                servicesEntity.setConnection(getConnection());
            }
        }
        return servicesEntity;
    }

    /*Metodo Entity Users*/
    protected UsersEntity getUsersEntity(){
        if(getConnection() != null) {
            if(usersEntity== null) {
                usersEntity = new UsersEntity();
                usersEntity.setConnection(getConnection());
            }
        }
        return usersEntity;
    }

    /*Metodo Entity UsersType*/
    protected UsersTypeEntity getUsersType(){
        if(getConnection() != null) {
            if(usersTypeEntity == null) {
                usersTypeEntity = new UsersTypeEntity();
                usersTypeEntity.setConnection(getConnection());
            }
        }
        return usersTypeEntity;
    }


    /*Metodo update, create, delete, find de Users*/



    /*Metodo update, create, delete, find de UserType*/

    /*Metodo update, create, delete, find de Provinces*/
    public List<Province> findAllProvinces() {
        return getProvincesEntity() != null?
                getProvincesEntity().findAll() : null;
    }
    /*Metodo update, create, delete, find de Districts*/
    public  List<District> findAllDistricts(ProvincesEntity provincesEntity){
        return  getDistrictsEntity() != null ?
                getDistrictsEntity().findAll(provincesEntity) : null;
    }



    /*Metodo update, create, delete, find de Services*/

        





}
