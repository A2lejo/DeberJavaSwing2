import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class form1 {
    JPanel Principal;
    private JTextField us;
    private JButton ingresarButton;
    private JPasswordField contra;

    String usu, contrasena, biografia;
    public form1(JFrame secu){

        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dbURL="jdbc:mysql://localhost:3306/deber-swing";
                String dbuserName="root";
                String dbpassword="A2lejx0227";
                java.sql.Connection connection=null;
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connection = DriverManager.getConnection(dbURL,dbuserName, dbpassword);
                    Statement statement;
                    statement=connection.createStatement();
                    java.sql.ResultSet resultset;
                    resultset=statement.executeQuery("select *from personas");

                    while (resultset.next()) {
                        usu = resultset.getString("Usuario");
                        contrasena = resultset.getString("Contraseña");
                        biografia = resultset.getString("Biografia");
                        char[] pass = contra.getPassword();
                        String password = String.valueOf(pass);
                        if (us.getText().equals(usu) && password.equals(contrasena)) {
                            JFrame frame2 = new JFrame("Biografia");
                            frame2.setContentPane(new form2(biografia).Secundario);
                            frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            frame2.pack();
                            frame2.setSize(640, 480);
                            frame2.setVisible(true);
                            secu.dispose();
                            break;
                        }
                    }



                }catch (Exception exception){
                    System.out.println(exception);
                }
            }
        });
    }
}

