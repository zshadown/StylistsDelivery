package pe.edu.utp.stylistsdeliveryp.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationsEntity extends BaseEntity {
    private static String DEFAULT_SQL="SELECT * FROM reservations";

    private List<Reservation> findByCriteria(String sql, UsersEntity usersEntity, ServicesEntity servicesEntity){
        List<Reservation> reservations = new ArrayList<>();
        if (getConnection()!=null){
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                while (resultSet.next()){
                    Reservation reservation = new Reservation(
                            resultSet.getInt("id"),
                            resultSet.getString("day"),
                            resultSet.getString("address"),
                            resultSet.getString("time"),
                            resultSet.getString("state"),
                            servicesEntity.findById(resultSet.getInt("services_id")),
                            usersEntity.findById(resultSet.getInt("users_id"))
                    );
                    reservations.add(reservation);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<Reservation> findAll(UsersEntity usersEntity, ServicesEntity servicesEntity){
        return findByCriteria(DEFAULT_SQL, usersEntity, servicesEntity);
    }

    public Reservation findById(int id){
        List<Reservation> reservations = findByCriteria(DEFAULT_SQL +
        " WHERE id = "+String.valueOf(id), null, null);
        return (reservations != null ? reservations.get(0) : null);
    }

    public Reservation findByDay(String day){
        List<Reservation> reservations = findByCriteria(DEFAULT_SQL +
        " WHERE day = '"+day+"'",null,null);
        return (reservations != null ? reservations.get(0) : null);
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
        String sql = "SELECT MAX(id) AS max_id FROM reservations";
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

    public Reservation create(Reservation reservation){
        if (getConnection()!=null){
            String sql = "INSERT INTO reservations(id, day, address, time," +
                    "state, services_id, services_users_id, services_users_user_type_id," +
                    "services_users_districts_id, users_id, users_user_type_id," +
                    "users_districts_id) VALUES(" +
                    String.valueOf(getMaxId()+1)+", '"+reservation.getDay()+"', '"+
                    reservation.getAddress()+"', '"+reservation.getTime()+"', '"+
                    reservation.getState()+"', "+reservation.getService().getId()+", "+
                    reservation.getService().getUser().getId()+", "+
                    reservation.getService().getUser().getUserType().getId()+", "+
                    reservation.getService().getUser().getDistrict().getId()+", "+
                    reservation.getUser().getId()+", "+
                    reservation.getUser().getUserType().getId()+", "+
                    reservation.getUser().getDistrict().getId()+")";
            int results = updateByCriteria(sql);
            if (results>0){
                reservation = new Reservation(getMaxId(),reservation.getDay(), reservation.getAddress(),
                reservation.getTime(), reservation.getState(), reservation.getService(), reservation.getUser());
                return reservation;
            }
        }
        return null;
    }

    public boolean update(Reservation reservation){
        if (findById(reservation.getId())!=null) return false;
        return updateByCriteria(
                "UPDATE reservations SET " +
                        "day = '"+reservation.getDay()+"', "+
                        "address = '"+reservation.getAddress()+"', "+
                        "time = '"+reservation.getTime()+"', "+
                        "state = '"+reservation.getState()+"', "+
                        "services_id = "+String.valueOf(reservation.getService().getId())+", "+
                        "services_users_id = "+String.valueOf(reservation.getService().getUser().getId())+", "+
                        "services_users_user_type_id = "+String.valueOf(reservation.getService().getUser().getUserType().getId())+", "+
                        "services_users_dictricts_id = "+String.valueOf(reservation.getService().getUser().getDistrict().getId())+", "+
                        "users_id = "+String.valueOf(reservation.getUser().getId())+", "+
                        "users_user_type_id = "+String.valueOf(reservation.getUser().getUserType().getId())+", "+
                        "users_districts_id = "+String.valueOf(reservation.getUser().getDistrict().getId()))>0;
    }

    public boolean delete(int id){
        return updateByCriteria("DELETE FROM reservations WHERE id = "+String.valueOf(id))>0;
    }

}
