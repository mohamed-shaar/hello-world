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
    private JButton purchasebtn;
    private Store currentStore;

    public viewProducts() {
        exploreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = Integer.parseInt(textField1.getText());
                currentStore = Database.getStore(choice);
                if (currentStore == null) {
                    JOptionPane.showMessageDialog(explore,"Cannot find store");
                } else
                    currentStore.getStoreView().exploreProducts(products);

            }
        });
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice=Integer.parseInt(textField2.getText());
                Product currentProduct = currentStore.getStoreView().storeController.getProduct(choice);
                if (currentProduct == null) {
                    JOptionPane.showMessageDialog(explore,"Cannot find!");
                }else {
                    JOptionPane.showMessageDialog(explore,currentProduct.productView.print());
                    currentProduct.productView.viewDetails(currentProduct);
                    product.append(currentProduct.productView.print());
                    currentProduct.increasesearchcounter();
                }
            }
        });
        purchasebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice=Integer.parseInt(textField2.getText());
                Product currentProduct =  currentStore.getStoreView().storeController.getProduct(choice);
                if (currentProduct == null) {
                    JOptionPane.showMessageDialog(explore,"Cannot find!");
                }else {
                    if(!login.currentCustomer.voucher.purchase(currentProduct)){
                        JOptionPane.showMessageDialog(explore,"Transaction has failed!");
                    }
                    else{
                        JOptionPane.showMessageDialog(explore,"Transaction has succeeded!");
                        currentProduct.increaseboughtcounter();
                    }
                }
            }
        });
    }
}
