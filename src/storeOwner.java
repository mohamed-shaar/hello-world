import javax.swing.*;
import javax.xml.crypto.Data;
import java.util.Scanner;
import java.util.Vector;

class StoreOwner extends Person {
    protected StoreOwnerView storeOwnerView = new StoreOwnerView();
    public StoreOwner() {
    }
    public StoreOwner(String name, String email, String password) {
        super(name, email, password);
    }
    public void getView() {
        storeOwnerView.main();
    }
}

class StoreOwnerController {
    protected Vector<Store> stores=new Vector<>();
    public void addStore(Store store) {
        stores.add(store);
        Database.addStore(store);
    }
    public Store findStore(String storeName) {
        for (Store store : stores) {
            if (store.getName().equals(storeName)) {
                return store;
            }
        }
        return null;
    }
    public void addSuggestion(String suggestion) {
        Database.addSuggestion(suggestion);
    }
}
class StoreOwnerView {
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
        System.out.println(name+" store has been created successfully!");
        Database.saveAll();
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
        Database.saveAll();
    }
    public void suggestAddingProductToDatabase(){
        owner own = new owner();
        String suggestion = JOptionPane.showInputDialog("Enter product name and a brief description\nAdmin should revise your suggestion within 24 hours.");
        storeOwnerController.addSuggestion(suggestion);
        JOptionPane.showMessageDialog(own.store_owner, "Your suggestion has been sent!");
    }
    public void exploreStores(){

    }
    public void exploreViews(){
        Database.viewCounters();
    }
    public void getMostViewed(){
        Database.mostViewed();
    }
    public void getMostBought(){
        Database.mostBought();
    }
    public void main(){
        while(true){
            System.out.println("Choose what you want to do\n1- Add Store\n2- Add Product\n3- Suggest Product\n4- Explore store" +
                    "\n5- Explore views\n6- Get the most viewed\n7- Exit");
            Scanner cin=new Scanner(System.in);
            int choice=cin.nextInt();
            if(choice==1){
                addStore();
            }else if(choice==2){
                addProduct();
            }else if(choice==3){
                suggestAddingProductToDatabase();
            }else if(choice==4){
                exploreStores();
            }else if(choice==5){
                exploreViews();
            }else if(choice==6){
                getMostViewed();
            }else{
                break;
            }
        }
    }
}