package pe.edu.utp.stylistsdeliveryp.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationsEntity extends BaseEntity {
    private static String DEFAULT_SQL="SELECT * FROM reservations";

    private List<Reservation> findByCriteria(String sql, ServicesEntity servicesEntity, UsersEntity usersCliEntity, UsersEntity usersStyEntity){
        List<Reservation> reservations = new ArrayList<>();
        if (getConnection()!=null){
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                while (resultSet.next()){
                    Reservation reservation = new Reservation(
                            resultSet.getInt("id"),
                            resultSet.getDate("day_principal"),
                            resultSet.getString("address"),
                            resultSet.getDate("hour_principal"),
                            resultSet.getInt("status"),
                            servicesEntity.findById(resultSet.getInt("services_id")),
                            usersCliEntity.findById(resultSet.getInt("users_cli_id")),
                            usersStyEntity.findById(resultSet.getInt("users_sty_id"))
                    );
                    reservations.add(reservation);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<Reservation> findAll(ServicesEntity servicesEntity, UsersEntity usersCliEntity, UsersEntity usersStyEntity){
        return findByCriteria(DEFAULT_SQL, servicesEntity, usersCliEntity, usersStyEntity);
    }

    public Reservation findById(int id){
        List<Reservation> reservations = findByCriteria(DEFAULT_SQL +
        " WHERE id = "+String.valueOf(id), null, null, null);
        return (reservations != null ? reservations.get(0) : null);
    }

    public Reservation findByDay(String dayPrincipal){
        List<Reservation> reservations = findByCriteria(DEFAULT_SQL +
        " WHERE day_principal = '"+dayPrincipal+"'",null,null, null);
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
            String sql = "INSERT INTO reservations(id, day_principal, address, hour_principal," +
                    "status, services_id, users_cli_id, " +
                    "users_sty_id) VALUES(" +
                    String.valueOf(getMaxId()+1)+", '"+String.valueOf(reservation.getDayPrincipal())+"', '"+
                    reservation.getAddress()+"', '"+String.valueOf(reservation.getHourPrincipal())+"', "+
                    String.valueOf(reservation.getStatus())+", "+String.valueOf(reservation.getService().getId())+", "+
                    String.valueOf(reservation.getUserCli().getId())+", "+
                    String.valueOf(reservation.getUserSty().getId())+")";
            int results = updateByCriteria(sql);
            if (results>0){
                reservation = new Reservation(getMaxId(),reservation.getDayPrincipal(), reservation.getAddress(),
                        reservation.getHourPrincipal(), reservation.getStatus(), reservation.getService(),
                        reservation.getUserCli(), reservation.getUserCli());
                return reservation;
            }
        }
        return null;
    }

    public boolean update(Reservation reservation){
        if (findById(reservation.getId())!=null) return false;
        return updateByCriteria(
                "UPDATE reservations SET " +
                        "day_principal = '"+reservation.getDayPrincipal()+"', "+
                        "address = '"+reservation.getAddress()+"', "+
                        "hour_principal = '"+reservation.getHourPrincipal()+"', "+
                        "status = "+String.valueOf(reservation.getStatus())+", "+
                        "services_id = "+String.valueOf(reservation.getService().getId())+", "+
                        "users_cli_id = "+String.valueOf(reservation.getUserCli().getId())+", "+
                        "user_sty_id = "+String.valueOf(reservation.getUserSty().getId())+
                        " WHERE id = "+String.valueOf(reservation.getId()))>0;
    }

    public boolean delete(int id){
        return updateByCriteria("DELETE FROM reservations WHERE id = "+String.valueOf(id))>0;
    }

}
