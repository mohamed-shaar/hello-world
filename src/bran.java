import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bran {
    public JTextField name;
    public JButton addBrandButton;
    public JPanel brand;

    public bran() {
        addBrandButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminController adminController = new AdminController();
                String Name =name.getText();
                adminController.addBrand(new String(Name));
                JOptionPane.showMessageDialog(brand,"Brand has been added!");
            }
        });
    }
}
