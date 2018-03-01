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
    protected UsersTypeEntity getUsersTypeEntity(){
        if(getConnection() != null) {
            if(usersTypeEntity == null) {
                usersTypeEntity = new UsersTypeEntity();
                usersTypeEntity.setConnection(getConnection());
            }
        }
        return usersTypeEntity;
    }



    /*Metodo update, create, delete, find de Users*/

    public User findUserById(int id){
        return getUsersEntity() != null ?
                getUsersEntity().findById(id) : null;
    }

    public List<User> findAllUsers(){
        return getUsersEntity() != null ?
                getUsersEntity().findAllUser(getUsersTypeEntity(), getDistrictsEntity()) : null;
    }

    public User findUserByEmail(String email){
        return getUsersEntity() != null ?
                getUsersEntity().findByEmail(email) : null;
    }

    public User createUser(User user){
        return getUsersEntity() != null ?
                getUsersEntity().create(user) : null;
    }

    public boolean updateUser(User user){
        return getUsersEntity() != null ?
                getUsersEntity().update(user) : false;
    }

    public boolean deleteUser(int id){
        return getUsersEntity() != null ?
                getUsersEntity().delete(id) : false;
    }


    /*Metodo update, create, delete, find de UserType*/

    public List<UserType> findAllUsersType(){
        return getUsersTypeEntity() != null ?
                getUsersTypeEntity().findAll() : null;
    }

    public UserType findUserTypeById(int id){
        return getUsersTypeEntity() != null ?
                getUsersTypeEntity().findById(id) : null;
    }

    public UserType findUserTypeByName(String name){
        return getUsersTypeEntity() != null ?
                getUsersTypeEntity().findByName(name) : null;
    }

    public UserType createUserType(String name){
        return getUsersTypeEntity() != null?
                getUsersTypeEntity().create(name) : null;
    }

    public boolean deleteUserType(int id){
        return getUsersTypeEntity() != null ?
                getUsersTypeEntity().delete(id) : false;
    }

    public boolean updateUserType(UserType userType){
        return getUsersTypeEntity() != null ?
                getUsersTypeEntity().update(userType) : false;
    }


    /*Metodo update, create, delete, find de Provinces*/

    public List<Province> findAllProvinces() {
        return getProvincesEntity() != null?
                getProvincesEntity().findAll() : null;
    }

    public Province findProvinceById(int id){
        return getProvincesEntity() != null ?
                getProvincesEntity().findById(id) : null;
    }

    public Province findProvinceByDescription(String description){
        return getProvincesEntity() != null ?
                getProvincesEntity().findByDescription(description) : null;
    }

    public Province createProvince(String description){
        return getProvincesEntity() != null?
                getProvincesEntity().create(description) : null;
    }

    public boolean deleteProvince(int id){
        return getProvincesEntity() != null ?
                getProvincesEntity().delete(id) : false;
    }

    public boolean updateProvince(Province province){
        return getProvincesEntity() != null ?
                getProvincesEntity().update(province) : false;
    }

    /*Metodo update, create, delete, find de Districts*/
    public  List<District> findAllDistricts(){
        return  getDistrictsEntity() != null ?
                getDistrictsEntity().findAll(getProvincesEntity()) : null;
    }

    public District findDistricById(int id){
        return getDistrictsEntity() != null ?
                getDistrictsEntity().findById(id) : null;
    }

    public District findDistricByDescription(String description){
        return getDistrictsEntity() != null ?
                getDistrictsEntity().findByDescription(description) : null;
    }

    public District createDistrict(String description){
        return getDistrictsEntity() != null?
                getDistrictsEntity().create(description) : null;
    }

    public boolean deleteDistrict(int id){
        return getDistrictsEntity() != null ?
                getDistrictsEntity().delete(id) : false;
    }

    public boolean updateDistrict(District district){
        return getDistrictsEntity() != null ?
                getDistrictsEntity().update(district) : false;
    }

////////////////////////////////////////

    /*Metodo update, create, delete, find de Services*/
    public Service findServiceById(int id){
        return getServicesEntity() != null ?
                getServicesEntity().findById(id) : null;
    }

    public List<Service> findAllService(){
        return getServicesEntity() != null ?
                getServicesEntity().findAll(getUsersEntity()) :null;
    }

    public Service findServiceByCost(Double cost){
        return getServicesEntity() != null ?
                getServicesEntity().findByCost(cost) : null;
    }

    public Service createService(Service service){
        return getServicesEntity() != null ?
                getServicesEntity().create(service) : null;
    }

    public boolean updateService(Service service){
        return getServicesEntity() != null ?
                getServicesEntity().update(service) : false;
    }

    public boolean deleteService(int id){
        return getServicesEntity()!= null?
                getServicesEntity().delete(id) : false;
    }
}
