import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class login {
    public JTextField email;
    public JTextField password;
    public JButton loginButton;
    public JPanel login;
    public static Customer currentCustomer;


    public login() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Person p = null;
                String Email, pass;
                Email = email.getText();
                pass = password.getText();
                p = Database.verifyLoginType(Email, pass);
                currentCustomer=new Customer(p.name,p.email,p.password);
                if (p == null) {
                    JOptionPane.showMessageDialog(login, "login failed");
                } else if (p.getType() == "customer") {
                    cust customer = new cust();
                    customer.label.setText("Welcome " + p.getName());
                    JFrame frame = new JFrame("Customer");
                    frame.setContentPane(customer.customer);
                    //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.pack();
                    frame.setSize(400, 300);
                    frame.setVisible(true);

                } else if (p.getType() == "storeOwner") {
                    owner store_owner = new owner();
                    store_owner.label.setText("Welcome " + p.getName());
                    JFrame frame = new JFrame("Store owner");
                    frame.setContentPane(store_owner.store_owner);
                    //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.pack();
                    frame.setSize(400, 300);
                    frame.setVisible(true);

                } else if (p.getType() == "admin") {
                    ad admin = new ad();
                    admin.label.setText("Welcome " + p.getName());
                    JFrame frame = new JFrame("Admin");
                    frame.setContentPane(admin.admin);
                    //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.pack();
                    frame.setSize(400, 300);
                    frame.setVisible(true);
                }
            }
        });
    }
}
