package pe.edu.utp.stylistsdeliveryp.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProvincesEntity extends BaseEntity{
    private static String DEFAULT_SQL = "SELECT * FROM stylistsdelivery.provinces";
    private List<Province> findByCriteria(String sql) {
        List<Province> provinces;
        if (getConnection() != null) {
            provinces = new ArrayList<>();
            try{
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                while (resultSet.next()) {
                    Province province = new Province()
                            .setId(resultSet.getInt("id"))
                            .setDescription(resultSet.getString("description"));
                    provinces.add(province);
                }
                return  provinces;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<Province> findAll() {
        return findByCriteria(DEFAULT_SQL);
    }

    public Province findById(int id){
        List<Province> provinces = findByCriteria(DEFAULT_SQL +
                " WHERE id = "+ String.valueOf(id));
        return (provinces!= null && !provinces.isEmpty() ? provinces.get(0) : null);
    }

    public Province findByDescription(String description) {
        List<Province> provinces = findByCriteria(DEFAULT_SQL +
                " WHERE description = '" + description + "'");
        return (provinces != null && !provinces.isEmpty() ? provinces.get(0) : null);
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
        return updateByCriteria("DELETE FROM provinces WHERE id = " + String.valueOf(id)) > 0;
    }

    private int getMaxId() {
        String sql = "SELECT MAX(id) AS max_id FROM provinces";
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

    public Province create(String description) {
        if(findByDescription(description) == null) {
            if(getConnection() != null) {
                String sql = "INSERT INTO provinces(id, description) VALUES(" +
                        String.valueOf(getMaxId() + 1) + ", '" +
                        description + "')";
                int results = updateByCriteria(sql);
                if(results > 0) {
                    Province province = new Province(getMaxId(), description);
                    return province;
                }
            }
        }
        return null;
    }

    public boolean update(Province province) {
        if(findByDescription(province.getDescription()) != null) return false;
        return updateByCriteria(
                "UPDATE provinces SET description = '" +
                        province.getDescription() + "'" +
                        " WHERE id = " +
                        String.valueOf(province.getId())) > 0;
    }



}
