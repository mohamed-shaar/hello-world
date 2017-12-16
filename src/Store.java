import java.util.Scanner;
import java.util.Vector;
public class Store {
    protected String name;
    protected String type;
    protected String address;
    protected StoreView storeView=new StoreView();
    public StoreView getStoreView() {
        return storeView;
    }
    public void setStoreView(StoreView storeView) {
        this.storeView = storeView;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Store(String name, String type, String address) {
        this.name = name;
        this.type = type;
        this.address = address;
    }
}
class StoreController{
    protected Vector<Product>products = new Vector<>();
    public Vector<Product> getAllProducts(){
        return products;
    }
    public void addProduct(Product product){ products.add(product);}
    public Product getProduct(int index){
        return products.get(index);
    }
}
class StoreView{
    protected StoreController storeController=new StoreController();
    public void addProduct(){
        Scanner cin=new Scanner(System.in);
        System.out.print("Enter product name: ");
        String name=cin.nextLine();
        System.out.print("Enter product category: ");
        String category=cin.nextLine();
        System.out.print("Enter product brand: ");
        String brand=cin.nextLine();
        System.out.print("Enter product price: ");
        String price=cin.nextLine();
        storeController.addProduct(new Product(name,Double.parseDouble(price),category,brand));
        System.out.println("Product has been added!");
    }
    public void exploreProducts()
    {
        Scanner cin=new Scanner(System.in);
        Vector<Product>products=storeController.getAllProducts();
        System.out.println(products);
        System.out.print("Enter product number you would like to explore: ");
        int choice=cin.nextInt();
        Product currentProduct=storeController.getProduct(choice);


    }
    public void viewBrands(){}

}