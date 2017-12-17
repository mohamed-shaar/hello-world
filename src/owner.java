import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class owner {
    public JButton addStoreButton;
    public JButton addProductButton;
    public JButton suggestProductButton;
    public JLabel label;
    public JPanel store_owner;
    private JButton productViewsbtn;
    private JButton mostViewedbtn;
    public StoreOwner owner=new StoreOwner();

    public owner() {
        addStoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                owner.storeOwnerView.addStore();

            }
        });
        addProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                owner.storeOwnerView.addProduct();

            }
        });
        suggestProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                owner.storeOwnerView.suggestAddingProductToDatabase();

            }
        });
        productViewsbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                owner.storeOwnerView.exploreViews();
            }
        });
        mostViewedbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                owner.storeOwnerView.getMostViewed();
            }
        });
    }
}
