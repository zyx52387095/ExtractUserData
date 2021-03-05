

import com.ibm.db2.jcc.DB2SimpleDataSource;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DataSourceFactory {

    public static Connection getDB2Connection(String username, String password) {
        Properties props = new Properties();
        FileInputStream fis = null;
//        static DataSource dataSource = DataSourceFactory.getPostgresDataSource("postgres", "897t4sgx8at");
        Connection conn;
        DB2SimpleDataSource dataSource = new com.ibm.db2.jcc.DB2SimpleDataSource();
        String url = "169.48.24.52";
        String dbName = "FSDP211";

        dataSource.setServerName(url);
        dataSource.setPortNumber(50001);
        dataSource.setDatabaseName(dbName);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        dataSource.setDriverType(4);

        try {
            conn = dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return conn;
    }
    public static Connection getPGConnection(String username, String password) {
        Properties props = new Properties();
        FileInputStream fis = null;
        Connection conn;

        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        String url = "jdbc:postgresql://ext-ody-db.ccmauy4qik1d.us-east-1.rds.amazonaws.com/postgres";

        dataSource.setURL(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        try {
            conn = dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return conn;
    }
}
