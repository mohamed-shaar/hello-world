import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ad {
    public JButton addProductButton;
    public JButton addBrandButton;
    public JButton provideVouchersButton;
    public JLabel label;
    public JPanel admin;
    public JButton removeBrandButton;
    private JButton viewSuggestionsbtn;
    private JButton viewStores;
    private JButton viewAllProductsButton;
    private JButton viewAllBrandsButton;
    public Admin adm=new Admin();



    public ad() {
        addProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adm.adminView.addProduct();
            }
        });
        addBrandButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adm.adminView.addBrand();
            }
        });
        provideVouchersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adm.adminView.provideVouchers();
            }
        });
        removeBrandButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adm.adminView.removeBrand();
            }
        });
        viewSuggestionsbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(admin, Database.suggestions);
            }
        });
        viewStores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(admin, Database.stores);
            }
        });
        viewAllProductsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(admin, Database.products);
            }
        });
        viewAllBrandsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(admin, Database.brands);
            }
        });
    }
}
