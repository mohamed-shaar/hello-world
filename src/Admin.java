public class Admin extends Person {
    protected AdminController adminController;
}
class AdminController{
    public void addBrand(Brand brand){
        Database.addBrand(brand);
    }
    public void addProduct(Product product){
        Database.addProduct(product);
    }
    public void removeBrand(Brand brand){
        Database.removeBrand(brand);
    }

}
