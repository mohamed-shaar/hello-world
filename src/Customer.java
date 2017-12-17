import javax.xml.crypto.Data;
import java.util.Scanner;
import java.util.Vector;

public class Customer extends Person {
    protected String address;
    protected int creditCardNumber;
    protected CustomerView customerView=new CustomerView();
    protected Voucher voucher=new Voucher(0);
    public void getView() {
        customerView.main();
    }
    public Customer(String name, String email, String password) {
        super(name,email,password);
    }
}
class CustomerController{
    public boolean purchase(Voucher voucher,Product product){
        return voucher.purchase(product);
    }
    public void addSuggestion(String suggestion){
        Database.addSuggestion(suggestion);
    }
}
class CustomerView{
    protected CustomerController customerController=new CustomerController();
    public void suggestAddingProductToDatabase(){
        Scanner cin=new Scanner(System.in);
        System.out.println("Enter product name and a brief description\nAdmin should revise your suggestion within 24 hours.");
        String suggestion=cin.nextLine();
        customerController.addSuggestion(suggestion);
        System.out.println("Your suggestion has been sent!");
    }
    public void exploreStores(){
        Database.viewStores();
        Scanner cin=new Scanner(System.in);
        System.out.print("Enter store number to explore: ");
        int choice=cin.nextInt();
        Store currentStore=Database.getStore(choice);
        if(currentStore==null){
            System.out.println("Cannot find store");
        }
        currentStore.getStoreView().exploreProducts();
    }
    public void main(){
        Scanner cin=new Scanner(System.in);
        while(true){
            System.out.println("1.Explore stores\n2.Suggest adding products");
            switch (cin.nextInt()){
                case 1:exploreStores();break;
                case 2:suggestAddingProductToDatabase();break;
                default:break;
            }
        }

    }
}
