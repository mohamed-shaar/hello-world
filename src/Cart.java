import java.util.Vector;

public class Cart {
    protected int id,userID;
    protected CartController cartController;
}
class CartController{
    protected Vector<Order> orders=new Vector<>();
    public void addOrder(Order order){
        orders.add(order);
    }
    public void payOnline(){

    }
    public void payOnDelivery(){

    }
    public void payUsingVoucher(){

    }
}