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

    public District findByDescription(String description) {
        List<District> districts = findByCriteria(DEFAULT_SQL +
                " WHERE description = '" + description + "'");
        return (districts != null && !districts.isEmpty() ? districts.get(0) : null);
    }

    private int updateByCriteria(String sql) {
        if(getConnection() != null) {
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

    public boolean delete(int id) {
        return updateByCriteria("DELETE FROM districts WHERE id = " + String.valueOf(id)) > 0;
    }

    private int getMaxId() {
        String sql = "SELECT MAX(id) AS max_id FROM districts";
        if(getConnection() != null) {
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

    public District create(String description) {
        if(findByDescription(description) == null) {
            if(getConnection() != null) {
                String sql = "INSERT INTO districts(id, description) VALUES(" +
                        String.valueOf(getMaxId() + 1) + ", '" +
                        description + "')";
                int results = updateByCriteria(sql);
                if(results > 0) {
                    District district = new District(getMaxId(), description);
                    return district;
                }
            }
        }
        return null;
    }

    public boolean update(District district) {
        if(findByDescription(district.getDescription()) != null) return false;
        return updateByCriteria(
                "UPDATE districts SET description = '" +
                        district.getDescription() + "'" +
                        " WHERE id = " +
                        String.valueOf(district.getId())) > 0;
    }

}
