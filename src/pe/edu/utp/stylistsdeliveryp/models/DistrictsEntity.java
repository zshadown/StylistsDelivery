package pe.edu.utp.stylistsdeliveryp.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DistrictsEntity extends BaseEntity {
    private static String DEFAULT_SQL = "SELECT * FROM districts";

    private List<District> findByCriteria(String sql){
        List<District> districts = new ArrayList<>();
        if (getConnection()!=null){
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                while (resultSet.next()){
                    District district = new District(
                            resultSet.getInt("id"),
                            resultSet.getString("description")
                    );
                    districts.add(district);
                }
                return districts;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private List<District> findByCriteriaVar(String sql, ProvincesEntity provincesEntity){
        List<District> districts = new ArrayList<>();
        if (getConnection()!=null){
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                while (resultSet.next()){
                    District district = new District(
                            resultSet.getInt("id"),
                            resultSet.getString("description"),
                            provincesEntity.findById(resultSet.getInt("id"))
                    );
                    districts.add(district);
                }
                return districts;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<District> findAll(ProvincesEntity provincesEntity){
        return findByCriteriaVar(DEFAULT_SQL, provincesEntity);
    }

    public District findById(int id){
        List<District> districts = findByCriteria(DEFAULT_SQL +
                " WHERE id = "+ String.valueOf(id));
        return (districts!= null && !districts.isEmpty() ? districts.get(0) : null);
    }

}
