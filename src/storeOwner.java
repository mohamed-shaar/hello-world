import java.util.Scanner;
import java.util.Vector;

public class StoreOwner extends Person {
    protected StoreOwnerView storeOwnerView;

    public StoreOwner(String name, String email, String password) {
        super(name,email,password);
    }
}
class StoreOwnerController{
    protected Vector<Store>stores;
    public void addStore(Store store){
        stores.add(store);
    }
}
class StoreOwnerView{
    protected StoreOwnerController storeOwnerController=new StoreOwnerController();
    public void addStore(){
        Scanner cin=new Scanner(System.in);
        System.out.print("Enter store name: ");
        String name=cin.nextLine();
        System.out.println("Enter store type (online/onsite): ");
        String type=cin.nextLine();
        System.out.println("Enter store address (enter null in case of online stores): ");
        String address=cin.nextLine();
        storeOwnerController.addStore(new Store(name,type,address));
    }
}