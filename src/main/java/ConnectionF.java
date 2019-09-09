import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionF {
    public Connection getConnection() throws SQLException {

        Connection conn = null;
        try {
            //return DriverManager.getConnection("jdbc:sqlserver://localhost\\sqlexpress:1433;databaseName=PRIMEIRO_BD","sa","123456");

            String dbURL = "jdbc:sqlserver://localhost\\sqlexpress:1433;databaseName=PRIMEIRO_BD;integratedSecurity=true";

            conn = DriverManager.getConnection(dbURL,"sa","123456");
            if (conn != null) {
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
}
