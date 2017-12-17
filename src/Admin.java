import javax.swing.*;
import java.util.Scanner;

public class Admin extends Person {
    protected AdminView adminView = new AdminView();
    public Admin(){}
    public Admin(String name, String email, String password) {
        super(name, email, password);
    }
    public void getView() {
        adminView.main();
    }
}

class AdminController {
    public void addBrand(String brand) {
        Database.addBrand(brand);
    }
    public void addProduct(Product product) {
        Database.addProduct(product);
    }
    public void removeBrand(String brand) {
        Database.removeBrand(brand);
    }
    public void provideVouchers(Customer customer) {
        customer.voucher.points++;
    }
}


class AdminView {
    public void main() {
        boolean x = true;
        Scanner scan = new Scanner(System.in);
        while (x) {
            commands();
            switch (scan.nextInt()) {
                case 1:
                    this.addProduct();
                case 2:
                    this.addBrand();
                case 3:
                    this.provideVouchers();
                case 4:
                    x = false;
                default:
                    System.out.println("enter something ");

            }
        }
    }
    protected AdminController adminController = new AdminController();
    static void commands() {
        System.out.println("1. add product\n2. add brand" +
                "\n3. provide vouchers\n4. Exit ");
    }
    public void addProduct() {
        String name, category, brand, price;
        prod product = new prod();
        JFrame frame = new JFrame("product");
        frame.setContentPane(product.product);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(400, 300);
        frame.setVisible(true);
        name = product.name.getText();
        category = product.category.getText();
        brand = product.brand.getText();
        price = product.price.getText();
        adminController.addProduct(new Product(name, Double.parseDouble(price), category, brand));
    }
    public void addBrand() {
        bran brand = new bran();
        JFrame frame = new JFrame("brand");
        frame.setContentPane(brand.brand);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(400, 300);
        frame.setVisible(true);
        String name =brand.name.getText();
        adminController.addBrand(new String(name));
    }
    public void provideVouchers() {
        vouch voucher=new vouch();
        JFrame frame = new JFrame("voucher card");
        frame.setContentPane(voucher.voucher);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(400, 300);
        frame.setVisible(true);
        String mail =voucher.email.getText() ;
        String points=voucher.points.getText();

        Integer point = Integer.parseInt(points);

        for (int i = 0; i < Database.customers.size(); i++) {
            if (mail.equals(Database.customers.get(i).email)) {
                adminController.provideVouchers(Database.customers.get(i));
            }
        }

    }
    public void removeBrand(){
        String brandName=JOptionPane.showInputDialog("Enter brand name");
        adminController.removeBrand(brandName);
    }
}
