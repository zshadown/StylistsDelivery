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

    public Province findById(int id) {
        List<Province> provinces = findByCriteria(DEFAULT_SQL +
                " WHERE id = "+ String.valueOf(id));
        return (provinces != null && !provinces.isEmpty() ? provinces.get(0) : null);
    }




}
