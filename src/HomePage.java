import javax.xml.crypto.Data;
import java.util.Scanner;

public class HomePage {
    private static Person currentUser=null;
    private static Scanner cin=null;
    private static boolean login(){
        System.out.println("Enter email and password");
        cin=new Scanner(System.in);
        String name=cin.next();
        String password=cin.next();
        currentUser= Database.verifyLoginType(name,password);
        return currentUser!=null;
    }
    private static boolean register(){
        cin=new Scanner(System.in);
        System.out.println("1.Customer\n2.StoreOwner\n3.Admin");
        int choice=cin.nextInt();
        String name=cin.nextLine();
        String email=cin.nextLine();
        String password=cin.nextLine();
        if(choice==1){
            Database.addCustomer(new Customer(name,email,password));
        }
        else if(choice==2){
            Database.addStoreOwner(new StoreOwner(name,email,password));
        }
        else{
            Database.addAdmin(new Admin(name,email,password));
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println("1.login\n2.Register");
        cin=new Scanner(System.in);
        if(cin.nextInt()==1){
            if(login()){
                System.out.println("login successfully");
            }
            else{
                System.out.println("login failed");
            }
        }
        else{
            if(register()){
                System.out.println("Registered successfully");
            }
            else{
                System.out.println("Registeration failed");
            }
        }
    }
}
