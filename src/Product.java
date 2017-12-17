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
    protected int searchcounter;
    protected int boughtcounter;
    protected ProductController productController;
    public void increasesearchcounter(){searchcounter++;}
    public void increaseboughtcounter(){boughtcounter++;}
    public String getName() { return name; }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
class ProductController{
    /*public Product returnsearchcounter(){
        Product temp = products.get(0);
        for (Product p:products){
            if(p.searchcounter > temp.searchcounter){ temp = p;}
        }
        return temp;
    }*/
    /*public Product returnboughtcounter(){
        Product temp = products.get(0);
        for (Product p:products){
            if(p.boughtcounter > temp.boughtcounter){ temp = p;}
        }
        return temp;
    }*/
}