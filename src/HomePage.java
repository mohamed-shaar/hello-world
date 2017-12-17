import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class HomePage {
    private static JFrame frame1= new JFrame("Welcome");
    private JPanel welcome;
    private JButton loginButton;
    private JButton registerButton;

    public HomePage() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login login=new login();
                JFrame frame = new JFrame("Login");
                frame.setContentPane(login.login);
                //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setSize(400, 300);
                frame.setVisible(true);
            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Register");
                frame.setContentPane(new Register().Register);
                //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setSize(400, 300);
                frame.setVisible(true);
            }
        });
    }


    public static void main(String[] args) {
        Database.loadAll();
        frame1.setContentPane(new HomePage().welcome);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setSize(400, 300);
        frame1.setVisible(true);
    }

}
