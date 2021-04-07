//This class creates a connection to a database. A MySQL database through XAMPP was used
package connectivity;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {

    public Connection connection;

    public Connection getConnection() {


        String dbName = "ipc14";
        String userName = "root";
        String password = "root";
        String url = "jdbc:mysql://127.0.0.1:3306/ipc14";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            connection = DriverManager.getConnection(url, userName, password);

        } catch (Exception e) {
            e.printStackTrace();
        }


        return connection;
    }

}