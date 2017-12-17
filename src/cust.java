import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cust {
    public JButton purchaseButton;
    public JButton addSuggestionButton;
    public JButton exploreStoresButton;
    public JPanel customer;
    public JLabel label;
    public Customer cus=new Customer();


    public cust() {
        addSuggestionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cus.customerView.suggestAddingProductToDatabase();
            }
        });
        exploreStoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cus.customerView.exploreStores();
            }
        });
    }
}
