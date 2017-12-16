import java.util.Scanner;
public class Admin extends Person {
    protected AdminView adminView;
    public Admin(String name, String email, String password) {
        super(name,email,password);
    }
}
class AdminController{
    public void addBrand(String brand){
        Database.addBrand(brand);
    }
    public void addProduct(Product product){
        Database.addProduct(product);
    }
    public void removeBrand(String brand){
        Database.removeBrand(brand);
    }
}
class AdminView{
    protected AdminController adminController=new AdminController();
    public void addProduct(){
        Scanner cin=new Scanner(System.in);
        System.out.print("Enter product name: ");
        String name=cin.nextLine();
        System.out.print("Enter product category: ");
        String category=cin.nextLine();
        System.out.print("Enter product brand: ");
        String brand=cin.nextLine();
        System.out.print("Enter product price: ");
        String price=cin.nextLine();
        adminController.addProduct(new Product(name,Double.parseDouble(price),category,brand));
        System.out.println("Product has been added!");
    }
    public void addBrand(){
        Scanner cin=new Scanner(System.in);
        System.out.print("Enter brand name: ");
        String name=cin.nextLine();
        adminController.addBrand(new String(name));
        System.out.println("Brand has been added!");
    }
    public void provideVouchers(){

    }
}
