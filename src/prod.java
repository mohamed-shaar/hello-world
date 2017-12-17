import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class prod {
    public JTextField name;
    public JTextField category;
    public JTextField brand;
    public JTextField price;
    public JButton addButton;
    public JPanel product;

    public prod() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(product,"Product has been added!");
            }
        });
    }
}
