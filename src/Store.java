import java.util.Vector;

public class Store {
    protected String name;
    protected String type;
    protected StoreController storeController;
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