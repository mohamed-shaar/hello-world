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
                String Name, Category, Brand, Price;
                AdminController adminController = new AdminController();
                Name = name.getText();
                Category = category.getText();
                Brand = brand.getText();
                Price = price.getText();
                adminController.addProduct(new Product(Name, Double.parseDouble(Price), Category, Brand));
                JOptionPane.showMessageDialog(product, "Product has been added!");
            }
        });
    }
}
