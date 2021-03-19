import models.Merchant;
import models.Operator;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ExtractUserDataMain {
    public static void main(String[] args) throws IOException {
//        BufferedReader c = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("username?");
//        String dbUsername = c.readLine();
        Console console = System.console();
        console.printf("Please enter your username: ");
        String username = console.readLine();
        console.printf(username + "\n");
        console.printf("Please enter your password: ");
        char[] passwordChars = console.readPassword();
        String passwordString = new String(passwordChars);


        ExtractUserDataService extractUserDataService = new ExtractUserDataService(username,passwordString);
        List<Merchant> merchantList =extractUserDataService.getAllMerchantUser();
        WriteToJson.writeToFile(merchantList,"MerchantUsers");

        List<Operator> operatorList = extractUserDataService.getAllOperatorUser();
        WriteToJson.writeToFile(operatorList,"OperatorUsers");
    }
}


//class EraserThread implements Runnable {
//    private boolean stop;
//
//    /**
//     *@param  prompt displayed to the user
//     */
//    public EraserThread(String prompt) {
//        System.out.print(prompt);
//    }
//
//    /**
//     * Begin masking...display asterisks (*)
//     */
//    public void run () {
//        stop = true;
//        while (stop) {
//            System.out.print("\010*");
//            try {
//                Thread.currentThread().sleep(1);
//            } catch(InterruptedException ie) {
//                ie.printStackTrace();
//            }
//        }
//    }
//
//    /**
//     * Instruct the thread to stop masking
//     */
//    public void stopMasking() {
//        this.stop = false;
//    }
//}
