import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class viewProducts {
    public JPanel explore;
    public JTextArea stores;
    public JTextField textField1;
    public JTextArea products;
    public JTextField textField2;
    public JTextArea product;
    public JButton exploreButton;
    public JButton viewButton;

    public viewProducts() {
        exploreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = Integer.parseInt(textField1.getText());
                Store currentStore = Database.getStore(choice);
                if (currentStore == null) {
                    JOptionPane.showMessageDialog(explore,"Cannot find store");
                } else
                    currentStore.getStoreView().exploreProducts(products);

            }
        });
        textField2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StoreController storeController = new StoreController();
                int choice=Integer.parseInt(textField2.getText());
                Product currentProduct = storeController.getProduct(choice);
                if (currentProduct == null) {
                    JOptionPane.showMessageDialog(explore,"Cannot find!");
                }else {
                    product.append(currentProduct.print());
                }
            }
        });
    }
}
