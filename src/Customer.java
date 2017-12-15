import java.util.Vector;

public class Customer extends Person {
    protected String address;
    protected int creditCardNumber;
    protected CustomerController customerController;
    protected CustomerView customerView;

    public Customer(String name, String email, String password) {
        super(name,email,password);
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
    Cart cart;
}
class CustomerView{
    protected static Vector<Store> Stores = new Vector<Store>();
    public static void viewallStore(){
        for (Store store:Stores){
            //store.storeController;
        }
    }
}
