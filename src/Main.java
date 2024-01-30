import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Inicio de sesión");
        frame.setContentPane(new form1(frame).Principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(640,480);
        frame.setVisible(true);
    }
}