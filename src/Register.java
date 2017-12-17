import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register {
    public JTextField name;
    public JTextField email;
    public JRadioButton adminRadioButton;
    public JRadioButton storeOwnerRadioButton;
    public JRadioButton customerRadioButton;
    public JButton registerButton;
    public JTextField password;
    public JPanel Register;

    public Register() {
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Email, pass, Name;
                Email = email.getText();
                Name = name.getText();
                pass = password.getText();

                if (Database.checkEmailAvailability(Email)) {
                    JOptionPane.showMessageDialog(Register,"Registeration failed");
                }else{
                    if(customerRadioButton.isSelected()){
                        Database.addCustomer(new Customer(Name, Email, pass));
                    }else if(adminRadioButton.isSelected()){
                        Database.addAdmin(new Admin(Name, Email, pass));
                    }else if(storeOwnerRadioButton.isSelected()){
                        Database.addStoreOwner(new StoreOwner(Name, Email, pass));
                    }
                    JOptionPane.showMessageDialog(Register,"Registeration succeed");
                }
            }
        });
    }
}
