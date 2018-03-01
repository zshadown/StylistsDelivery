package pe.edu.utp.stylistsdeliveryp.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersTypeEntity extends BaseEntity {
    private static String DEFAULT_SQL = "SELECT * FROM user_type";

    private List<UserType> findByCriteria(String sql){
        List<UserType> userTypes;
        if (getConnection()!=null){
            userTypes = new ArrayList<>();
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                while (resultSet.next()){
                    UserType userType = new UserType()
                            .setId(resultSet.getInt("id"))
                            .setDescription(resultSet.getString("description"));
                    userTypes.add(userType);
                }
                return userTypes;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<UserType> findAll(){
        return findByCriteria(DEFAULT_SQL);
    }

    public UserType findById(int id){
        List<UserType> userTypes = findByCriteria(DEFAULT_SQL +
                " WHERE id = "+String.valueOf(id));
        return (userTypes !=null && !userTypes.isEmpty() ? userTypes.get(0) : null);
    }

    public UserType findByName(String name){
        List<UserType> userTypes = findByCriteria(DEFAULT_SQL +
                " WHERE description = '" + name + "'");
        return (userTypes !=null && !userTypes.isEmpty() ? userTypes.get(0) : null);
    }

    private int updateByCriteria(String sql){
        if (getConnection() != null){
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
        String sql = "SELECT MAX(id) AS max_id FROM user_type";
        if (getConnection() !=null){
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

    public UserType create(String name){
        if (findByName(name) == null){
            if (getConnection()!=null){
                String sql = "INSERT INTO user_type(id, description) VALUES(" +
                        String.valueOf(getMaxId()+1) + ", '" +
                        name + "')";
                int results = updateByCriteria(sql);
                if (results>0){
                    UserType userType = new UserType(getMaxId(),name);
                    return userType;
                }
            }
        }
        return null;
    }

    public boolean update(UserType userType){
        if(findByName(userType.getDescription()) != null) return false;
        return updateByCriteria(
                "UPDATE user_type SET description = '"+
                        userType.getDescription() + "'" +
                        " WHERE id = " +
                        String.valueOf(userType.getId()))>0;
    }

    public boolean delete(int id){
        return updateByCriteria("DELETE FROM user_type " +
                "WHERE id = " + String.valueOf(id))>0;
    }
}
