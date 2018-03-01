package pe.edu.utp.stylistsdeliveryp.models;

import java.sql.Connection;

public class BaseEntity {
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection){
        this.connection = connection;
    }


}
