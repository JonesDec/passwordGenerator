import javax.swing.*;

public class Jframe {

    public static void showPopUp(String message, JTextArea textArea) {
        JOptionPane.showMessageDialog(null, "message" + new JScrollPane(textArea), "New Password", JOptionPane.INFORMATION_MESSAGE);
    }
}
