import models.Merchant;
import models.Operator;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExtractUserDataService {
    public ExtractUserDataService(String dbUsername, String dbPassword) {
        new DBOperations(dbUsername, dbPassword);
    }

    public List<Merchant> getAllMerchantUser() {
        List<Merchant> operatorStatusList = new ArrayList<>();
        try (PreparedStatement pstmt = DBOperations.conn.prepareStatement(DBOperations.merMinmumWithoutDeleted)) {

            ResultSet rs = pstmt.executeQuery();
            System.out.println("rs size is "+rs.getFetchSize());
            while (rs.next()) {

                Merchant merchant = new Merchant(rs.getString("ID"),
                        rs.getString("login_name"),
                        rs.getString("login_name"),
                        rs.getString("CUSTOMER_STATUS"),
                        rs.getString("group_id"));
                System.out.println(merchant.getId());

                operatorStatusList.add(merchant);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        System.out.println("size is "+operatorStatusList.size());
        return operatorStatusList;

    }
    public List<Operator> getAllOperatorUser() {
        List<Operator> operatorStatusList = new ArrayList<>();
        try (PreparedStatement pstmt = DBOperations.conn.prepareStatement(DBOperations.opsMinimumWithoutDeleted)) {

            ResultSet rs = pstmt.executeQuery();
            System.out.println("rs size is "+rs.getFetchSize());
            while (rs.next()) {

                Operator operator = new Operator(rs.getString("ID"),
                        rs.getString("login_name"),
                        rs.getString("login_name"),
                        rs.getString("STATUS"),
                        rs.getString("group_id")
                );
                System.out.println(operator.getId());

                operatorStatusList.add(operator);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        System.out.println("size is "+operatorStatusList.size());
        return operatorStatusList;

    }
}
