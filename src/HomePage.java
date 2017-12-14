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
        //todo
        return false;
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
            register();
        }
    }
}
