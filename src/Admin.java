public class Admin extends Person {
    protected AdminController adminController;
    protected AdminView adminView;

    public Admin(String name, String email, String password) {
        super(name,email,password);
    }
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
class AdminView{

}
