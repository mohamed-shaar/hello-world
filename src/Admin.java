import java.util.Scanner;
public class Admin extends Person {
    protected AdminView adminView;
    public Admin(String name, String email, String password) {
        super(name,email,password);
    }

    public void getView() {
        adminView.main();
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
    public void provideVouchers(Customer customer){
        customer.voucher.points++;
    }
}
class AdminView{
    public  void main() {
        System.out.println("maaaain");
        boolean x=true;
        Scanner scan= new Scanner(System.in);
        while(x){
            commands();
            switch (scan.nextInt()){
                case 1: this.addProduct();
                case 2: this.addBrand();
                case 3: this.provideVouchers();
                case 4: x=false;
                default:System.out.println("enter something ");
                    
            }
        }
    }
    
    protected AdminController adminController=new AdminController();
    static void commands(){
        System.out.println("1. add product\n2. add brand" +
                           "\n3. provide vouchers\n4. Exit ");}
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
        Scanner scan=new Scanner(System.in);
        System.out.println("enter customer Email");
        String mail=scan.nextLine();
        System.out.println("enter number of points");
        
        int point=scan.nextInt();
        
        for(int i=0;i<Database.customers.size();i++){
            if(mail.equals(Database.customers.get(i).email)){
                adminController.provideVouchers(Database.customers.get(i));
            }
        }
        
        
    }
}
