import java.util.Vector;

public class Database {
    protected static Vector<Customer>customers=new Vector<>();
    protected static Vector<StoreOwner>storeOwners=new Vector<>();
    protected static Vector<Admin>admins=new Vector<>();
    protected static Vector<Product>products=new Vector<>();
    protected static Vector<Brand>brands=new Vector<>();
    protected static Vector<Store>stores=new Vector<>();
    public static Person verifyLoginType(String email,String password){
        for(Customer customer:customers){
            if(customer.getEmail().equals(email)&&customer.getPassword().equals(password)){
                return customer;
            }
        }
        for(StoreOwner storeOwner:storeOwners){
            if(storeOwner.getEmail().equals(email)&&storeOwner.getPassword().equals(password)){
                return storeOwner;
            }
        }
        for(Admin admin:admins){
            if(admin.getEmail().equals(email)&&admin.getPassword().equals(password)){
                return admin;
            }
        }
        return null;
    }
    public static void addCustomer(Customer customer){
        customers.add(customer);
    }
    public static void addStoreOwner(StoreOwner storeOwner){
        storeOwners.add(storeOwner);
    }
    public static void addAdmin(Admin admin){
        admins.add(admin);
    }
    public static void addProduct(Product product){
        products.add(product);
    }
    public static void addBrand(Brand brand){
        brands.add(brand);
    }
    public static void addStore(Store store){
        stores.add(store);
    }
    public static void removeBrand(Brand brand){ brands.remove(brand); }
}
