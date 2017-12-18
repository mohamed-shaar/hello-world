import javax.swing.*;
import javax.xml.crypto.Data;
import java.util.Scanner;
import java.util.Vector;

public class Customer extends Person {
    protected String address;
    protected int creditCardNumber;
    protected CustomerView customerView = new CustomerView(this);
    protected Voucher voucher = new Voucher(20000);
    public void getView() {
        customerView.main();
    }
    public Customer() {
    }
    public Customer(String name, String email, String password) {
        super(name, email, password);
    }
}

class CustomerController {
    public boolean purchase(Voucher voucher, Product product) {
        return voucher.purchase(product);
    }
    public void addSuggestion(String suggestion) {
        Database.addSuggestion(suggestion);
    }
}

class CustomerView {
    protected CustomerController customerController = new CustomerController();
    Customer currentCustomer;
    CustomerView(Customer customer){
        currentCustomer=customer;
    }
    public void suggestAddingProductToDatabase() {
        cust customer = new cust();
        String suggestion = JOptionPane.showInputDialog("Enter product name and a brief description\nAdmin should revise your suggestion within 24 hours.");
        customerController.addSuggestion(suggestion);
        JOptionPane.showMessageDialog(customer.customer, "Your suggestion has been sent!");
    }

    public void exploreStores() {
        viewProducts view=new viewProducts();
        JFrame frame = new JFrame("view products");
        frame.setContentPane(view.explore);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(400, 300);
        frame.setVisible(true);
        Database.viewStores(view.stores);
    }
    public void main() {
        exploreStores();

    }
}
