import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

public class Database {
    protected static Scanner cin;
    protected static PrintWriter cout;

    protected static Vector<Customer> customers = new Vector<>();
    protected static Vector<StoreOwner> storeOwners = new Vector<>();
    protected static Vector<Admin> admins = new Vector<>();
    protected static Vector<Product> products = new Vector<>();
    protected static Vector<String> brands = new Vector<>();
    protected static Vector<Store> stores = new Vector<>();
    protected static Vector<String> suggestions = new Vector<>();

    protected static File adminFile=new File("Admin-DB.txt");
    protected static File brandFile=new File("Brand-DB.txt");
    protected static File customerFile=new File("Customer-DB.txt");
    protected static File productFile=new File("Products-DB.txt");
    protected static File storeFile=new File("Store-DB.txt");
    protected static File storeOwnerFile=new File("StoreOwner-DB.txt");
    protected static File suggestionFile=new File("Suggestion-DB.txt");

    public static Person verifyLoginType(String email, String password) {
        Person p=null;
        for (Customer customer : customers) {
            if (customer.getEmail().equals(email) && customer.getPassword().equals(password)) {
                customer.setType("customer");
                return customer;
            }
        }
        for (StoreOwner storeOwner : storeOwners) {
            if (storeOwner.getEmail().equals(email) && storeOwner.getPassword().equals(password)) {
                storeOwner.setType("storeOwner");
                return storeOwner;
            }
        }
        for (Admin admin : admins) {
            if (admin.getEmail().equals(email) && admin.getPassword().equals(password)) {
                admin.setType("admin");
                return admin;
            }
        }
        return null;
    }
    public static void addCustomer(Customer customer) {
        customers.add(customer);
    }
    public static void addStoreOwner(StoreOwner storeOwner) {
        storeOwners.add(storeOwner);
    }
    public static void addAdmin(Admin admin) {
        admins.add(admin);
    }
    public static void addProduct(Product product) {
        products.add(product);
    }
    public static void addBrand(String brand) {
        brands.add(brand);
    }
    public static void addStore(Store store) {
        stores.add(store);
    }
    public static void addSuggestion(String suggestion) {
        suggestions.add(suggestion);
    }
    public static void removeBrand(String brand) {
        brands.remove(brand);
    }
    public static boolean checkEmailAvailability(String email) {
        for (Customer customer : customers) {
            if (customer.getEmail().equals(email)) {
                return true;
            }
        }
        for (StoreOwner storeOwner : storeOwners) {
            if (storeOwner.getEmail().equals(email)) {
                return true;
            }
        }
        for (Admin admin : admins) {
            if (admin.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
    public static void viewStores(JTextArea store) {
        for(int i =0;i<stores.size();i++){
            store.append(stores.get(i).getName()+"  ");
        }
    }
    public static Store getStore(int index) {
        if (index < 0 || index > stores.size()) return null;
        return stores.get(index);
    }
    public static void viewCounters(){
        for(Product product:products){
            System.out.println(product.getName()+" Number of views: "+product.getSearchCounter()+" Number of buys: "+product.getBoughtCounter());

        }
    }
    public static void mostViewed(){
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Integer.compare(o2.getSearchCounter(),o1.getSearchCounter());
            }
        });
        System.out.println(products.get(0).getName()+" viewed "+products.get(0).searchcounter+" times");
    }
    public static void mostBought(){
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Integer.compare(o2.getBoughtCounter(),o1.getBoughtCounter());
            }
        });
        System.out.println(products.get(0).getName()+" bought "+products.get(0).boughtcounter+" times");
    }
    public static Product getProductByName(String name){
        for(Product product:products){
            if(product.getName().equals(name)){
                return product;
            }
        }
        return null;
    }

    public static void loadCustomers(){
        try {
            cin=new Scanner(customerFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(cin.hasNext()){
            customers.add(new Customer(cin.next(),cin.next(),cin.next()));
        }
    }
    public static void loadStoreOwners(){
        try {
            cin=new Scanner(storeOwnerFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(cin.hasNext()){
            storeOwners.add(new StoreOwner(cin.next(),cin.next(),cin.next()));
        }

    }
    public static void loadAdmins(){
        try {
            cin=new Scanner(adminFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(cin.hasNext()){
            admins.add(new Admin(cin.next(),cin.next(),cin.next()));
        }

    }
    public static void loadStores(){
        try {
            cin=new Scanner(storeFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(cin.hasNext()){
            stores.add(new Store(cin.next(),cin.next(),cin.next()));
        }
    }
    public static void loadBrand(){
        try {
            cin=new Scanner(brandFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(cin.hasNext()){
            brands.add(cin.nextLine());
        }
    }
    public static void loadProduct(){
        try {
            cin=new Scanner(productFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(cin.hasNext()){
            products.add(new Product(cin.next(),cin.nextDouble(),cin.next(),cin.next()));
        }
    }
    public static void loadSuggestions(){
        try {
            cin=new Scanner(suggestionFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(cin.hasNext()){
            suggestions.add(cin.nextLine());
        }
    }
    public static void loadAll(){
        loadAdmins();
        loadCustomers();
        loadStoreOwners();
        loadBrand();
        loadProduct();
        loadStores();
        loadSuggestions();
    }


    public static void saveCustomers(){
        try {
            cout=new PrintWriter(new FileOutputStream(customerFile,false ));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(Customer customer:customers){
            cout.println(customer.name+" "+customer.email+" "+customer.password);
        }
        cout.close();
    }
    public static void saveStoreOwners(){
        try {
            cout=new PrintWriter(new FileOutputStream(storeOwnerFile,false ));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(StoreOwner storeOwner:storeOwners){
            cout.println(storeOwner.name+" "+storeOwner.email+" "+storeOwner.password);
        }
        cout.close();
    }
    public static void saveAdmins(){
        try {
            cout=new PrintWriter(new FileOutputStream(adminFile,false ));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(Admin admin:admins){
            cout.println(admin.name+" "+admin.email+" "+admin.password);
        }
        cout.close();
    }
    public static void saveStores(){
        try {
            cout=new PrintWriter(new FileOutputStream(storeFile,false ));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(Store store:stores){
            cout.println(store.name+" "+store.type+" "+store.address);
        }
        cout.close();
    }
    public static void saveProducts(){
        try {
            cout=new PrintWriter(new FileOutputStream(productFile,false ));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(Product product:products){
            cout.println(product.name+" "+product.price+" "+product.category+" "+product.brand);
        }
        cout.close();
    }
    public static void saveBrands(){
        try {
            cout=new PrintWriter(new FileOutputStream(brandFile,false ));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(String brand:brands){
            cout.println(brand);
        }
        cout.close();
    }
    public static void saveSuggestions(){
        try {
            cout=new PrintWriter(new FileOutputStream(suggestionFile,false ));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(String suggestion:suggestions){
            cout.println(suggestion);
        }
        cout.close();
    }
    public static void saveAll(){
        System.out.println("here");
        saveAdmins();
        saveCustomers();
        saveStoreOwners();
        saveStores();
        saveProducts();
        saveBrands();
        saveSuggestions();
    }

}
