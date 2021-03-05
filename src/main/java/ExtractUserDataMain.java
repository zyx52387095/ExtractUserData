import models.Merchant;
import models.Operator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ExtractUserDataMain {
    public static void main(String[] args) throws IOException {
        BufferedReader c = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("username?");
        String dbUsername = c.readLine();
        System.out.println("password?");
        String dbPassword = c.readLine();


        ExtractUserDataService extractUserDataService = new ExtractUserDataService(dbUsername,dbPassword);
        List<Merchant> merchantList =extractUserDataService.getAllMerchantUser();
        WriteToJson.writeToFile(merchantList,"MerchantUsers");

        List<Operator> operatorList = extractUserDataService.getAllOperatorUser();
        WriteToJson.writeToFile(operatorList,"OperatorUsers");
    }
}
