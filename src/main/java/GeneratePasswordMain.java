import javax.swing.*;
import java.util.Arrays;

public class GeneratePasswordMain {
    public static int passwordLengthCount;
    public static void main(String[] args) {
        // Determine password character length count
        if (args.length != 0) {
            //Value should be first argument
            String value = args[0];
            // Determine if argument value is integer; if not then exit application
            if (!CommandLineInputHelper.isArgumentInteger(value)){
                System.out.println("Argument " + value + " is not a integer so will not generate a password");
                exit();
            }
            //Set password length count
            passwordLengthCount = Integer.parseInt(value);
        } else {
            //Set default value to 15
            passwordLengthCount = 15;
            System.out.println("Using a default password length of " + passwordLengthCount);
        }
        // Print out what the password length will be
        System.out.println("password length value: " + passwordLengthCount);

        PasswordGenerator pg = new PasswordGenerator(passwordLengthCount);
        String password = pg.generate();
        JTextArea tA = new JTextArea();
        tA.setText(password);
        tA.setEditable(true);
        String message = "New password is \n".concat(password);

        System.out.println(message);
        //Show password in pop up window
        //Jframe.showPopUp(message,tA); //TODO set up so message can pop up in text box 
    }

    private static void exit() {
        System.out.println("Exiting program early....");
        System.exit(0);
    }
}
