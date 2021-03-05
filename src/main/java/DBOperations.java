
import java.sql.Connection;


public class DBOperations {
    static Connection conn;

    public DBOperations(String dbUserName, String dbPassword) {
        conn=getConnection(dbUserName, dbPassword);
    }

    public Connection getConnection(String userName, String passWord) {

        Connection conn = DataSourceFactory.getPGConnection(userName,passWord);
        return conn;
    }
    static String merMinmumWithoutDeleted = "select pass.login_name, phg.group_id,cust.CUSTOMER_STATUS, cust.ID" +
            " from principal p" +
            " join credential c on c.principal_id = p.id" +
            " join password_credential pass on pass.id = c.id" +
            " join customer cust on cust.id = p.id" +
            " join principal_has_group phg on p.id = phg.principal_id" +
            " where CUSTOMER_STATUS!='DELETED'";
    static String opsMinimumWithoutDeleted ="select pass.login_name, phg.group_id, fuser.STATUS, fuser.ID" +
            " from principal p" +
            " join credential c on c.principal_id = p.id" +
            " join password_credential pass on pass.id = c.id" +
            " join fsdp_user fuser on fuser.id = p.id" +
            " join principal_has_group phg on p.id = phg.principal_id"+
            " where fuser.STATUS!='DELETED'";
}
