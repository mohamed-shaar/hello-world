import java.util.Scanner;
import java.util.Vector;

public class Customer extends Person {
    protected String address;
    protected int creditCardNumber;
    protected CustomerView customerView;
    public Customer(String name, String email, String password) {
        super(name,email,password);
    }
    public CustomerView getCustomerView() {
        return customerView;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getCreditCardNumber() {
        return creditCardNumber;
    }
    public void setCreditCardNumber(int creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
}
class CustomerController{
    protected Voucher voucher=new Voucher(0);
    public Voucher getVoucher() {
        return voucher;
    }
    public void addSuggestion(String suggestion){
        Database.addSuggestion(suggestion);
    }
    public boolean purchase(Product product){
        return voucher.purchase(product);
    }
}
class CustomerView{
    protected CustomerController customerController=new CustomerController();
    protected static Vector<Store> Stores = new Vector<Store>();
    public static void viewallStore(){
        for (Store store:Stores){
            //store.storeController;
        }
    }
    public void suggestAddingProductToDatabase(){
        Scanner cin=new Scanner(System.in);
        System.out.println("Enter product name and a brief description\nAdmin should revise your suggestion within 24 hours.");
        String suggestion=cin.nextLine();
        customerController.addSuggestion(suggestion);
        System.out.println("Your suggestion has been sent!");
    }
}
