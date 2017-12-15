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
        Database.addStore(store);
    }
    public Store findStore(String storeName){
        for(Store store:stores){
            if(store.getName().equals(storeName)){
                return store;
            }
        }
        return null;
    }
    public void addSuggestion(String suggestion){
        Database.addSuggestion(suggestion);
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
    public void addProduct(){
        Scanner cin=new Scanner(System.in);
        System.out.print("Enter store name you would like to add product in it: ");
        String storeName=cin.nextLine();
        Store currentStore=null;
        currentStore=storeOwnerController.findStore(storeName);
        if(currentStore!=null){
            currentStore.getStoreView().addProduct();
        }
        else {
            System.out.println("Store not found");
        }
    }
    public void suggestAddingProductToDatabase(){
        Scanner cin=new Scanner(System.in);
        System.out.println("Enter product name and a brief description\nAdmin should revise your suggestion within 24 hours.");
        String suggestion=cin.nextLine();
        storeOwnerController.addSuggestion(suggestion);
        System.out.println("Your suggestion has been sent!");
    }
}