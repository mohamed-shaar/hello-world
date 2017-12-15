import java.util.Vector;

public class Store {
    protected String name;
    protected String type;
    protected String address;
    protected StoreController storeController;

    public Store(String name, String type, String address) {
        this.name = name;
        this.type = type;
        this.address = address;
    }
}
class StoreController{
    protected static Vector<Product>products = new Vector<>();
    public static void addProduct(Product product){ products.add(product);}
}
class StoreView{
    protected static Vector<Store> stores = new Vector<>();
    public static void viewProducts(){
        for (Store store:stores) {
            System.out.println(store.storeController.products.getname());//problem: can not see product name.
        }
    }
    public static void viewBrands(){}
}