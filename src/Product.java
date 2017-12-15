import java.util.Vector;

public class Product {
    protected String name;
    protected double price;
    protected Brand brand;
    protected int searchcounter;
    protected int boughtcounter;
    protected ProductController productController;
    public void increasesearchcounter(){searchcounter++;}
    public void increaseboughtcounter(){boughtcounter++;}
    public String getName() { return name; }
}
class ProductController{
    protected Vector<Product>products = new Vector<>();
    public Product returnsearchcounter(){
        Product temp = products.get(0);
        for (Product p:products){
            if(p.searchcounter > temp.searchcounter){ temp = p;}
        }
        return temp;
    }
    public Product returnboughtcounter(){
        Product temp = products.get(0);
        for (Product p:products){
            if(p.boughtcounter > temp.boughtcounter){ temp = p;}
        }
        return temp;
    }
}