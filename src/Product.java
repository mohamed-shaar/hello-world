import java.util.Scanner;
import java.util.Vector;
public class Product {
    protected String name;
    protected double price;
    protected String category;
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Product(String name, double price, String category, String brand) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.brand = brand;
    }
    protected String brand;
    protected int searchcounter=0;
    protected int boughtcounter=0;
    protected ProductController productController;
    public void increasesearchcounter(){searchcounter++;}
    public void increaseboughtcounter(){boughtcounter++;}
    public int getSearchCounter(){return searchcounter;}
    public int getBoughtCounter(){return boughtcounter;}
    public String getName() { return name; }
    public String toString(){
        return String.format(" %s",name);
    }
    public String print(){
        return String.format(" %s, %s, %s, %f",name,category,brand,price);
    }
}
class ProductController{
    protected boolean purchase(Product product){
        Customer current=new Customer();
        return current.voucher.purchase(product);
    }
}
class ProductView{
    protected ProductController productController=new ProductController();
    protected void viewDetails(Product product){
        System.out.println(product);
        product.increasesearchcounter();
    }
    protected void purchase(Product product){
        if(productController.purchase(product)){
            System.out.println("Successfully purchased");
            product.increaseboughtcounter();
        }
        else System.out.println("No enough credits");
    }
    protected void exploreProduct(Product product){
        System.out.println("1.View details\n2.Purchase");
        Scanner cin=new Scanner(System.in);
        int choice=cin.nextInt();
        if(choice==1){
            viewDetails(product);
        }
        else if(choice==2){
            purchase(product);
        }
    }

}