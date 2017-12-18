import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vouch {
    public JTextField email;
    public JTextField points;
    public JPanel voucher;
    private JButton provideVoucherButton;

    public vouch() {
        provideVoucherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminController adminController = new AdminController();
                String mail =email.getText() ;
                String Points=points.getText();
                Integer p = Integer.parseInt(Points);

                for (int i = 0; i < Database.customers.size(); i++) {
                    if (mail.equals(Database.customers.get(i).email)) {
                        for(int j=0;j<p.intValue();j++){
                            adminController.provideVouchers(Database.customers.get(i));
                        }
                    }
                }

            }
        });
    }
}
