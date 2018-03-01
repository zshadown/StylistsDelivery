package pe.edu.utp.stylistsdeliveryp.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicesEntity extends BaseEntity {
    private static String DEFAULT_SQL = "SELECT * FROM services";

    private List<Service> findByCriteria(String sql, UsersEntity usersEntity){
        List<Service> services = new ArrayList<>();
        if (getConnection()!=null){
            try {
                ResultSet resultSet =  getConnection()
                        .createStatement()
                        .executeQuery(sql);
                while (resultSet.next()){
                    Service service = new Service(
                            resultSet.getInt("id"),
                            resultSet.getString("description"),
                            resultSet.getDouble("cost"),
                            resultSet.getInt("time"),
                            usersEntity.findById(resultSet.getInt("users_id"))
                    );
                    services.add(service);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<Service> findAll(UsersEntity usersEntity){
        return findByCriteria(DEFAULT_SQL, usersEntity);
    }

    public Service findById(int id){
        List<Service> services = findByCriteria(DEFAULT_SQL +
                " WHERE id = "+ String.valueOf(id), null);
        return (services!=null ? services.get(0) : null);
    }

    public Service findByCost(Double cost){
        List<Service> services = findByCriteria(DEFAULT_SQL +
                " WHERE cost < " + String.valueOf(cost),null);
        return (services != null ? services.get(0) : null);
    }

    private int updateByCriteria(String sql){
        if (getConnection()!=null){
            try {
                return getConnection()
                        .createStatement()
                        .executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    private int getMaxId(){
        String sql = "SELECT MAX(id) AS max_id FROM services";
        if (getConnection()!=null){
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                return resultSet.next() ?
                        resultSet.getInt("max_id") : 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    private Service create(Service service){
        if (getConnection()!=null){
            String sql = "INSERT INTO services(id, description," +
                    "cost, time, users_id, users_user_type_id," +
                    "users_districts_id) VALUES(" +
                    String.valueOf(getMaxId()+1) + ", '" + service.getDescription()+"', " +
                    String.valueOf(service.getCost()) + ", " + service.getTime() +", " +
                    String.valueOf(service.getUser().getId()) + ", " + service.getUser().getUserType().getId() + ", " +
                    String.valueOf(service.getUser().getDistrict().getId());
        }
        return null;
    }

}
