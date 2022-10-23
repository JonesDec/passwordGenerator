import java.util.Scanner;

public class CommandLineInputHelper {

    public static boolean isArgumentInteger(String value) {
        Scanner sc = new Scanner(value.trim());
        if (!sc.hasNextInt()) return false;
        sc.nextInt();
        return !sc.hasNext();
    }
}
