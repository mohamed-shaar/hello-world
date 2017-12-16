import java.util.Scanner;

public class HomePage {
    private static Person currentUser=null;
    private static boolean login(){
        Scanner cin=new Scanner(System.in);
        System.out.print("Enter email: ");
        String email=cin.nextLine();
        System.out.print("Enter password: ");
        String password=cin.nextLine();
        currentUser= Database.verifyLoginType(email,password);
        return currentUser!=null;
    }
    private static boolean register(){
        Scanner cin=new Scanner(System.in);
        System.out.println("1.Customer\n2.StoreOwner\n3.Admin");
        String choice=cin.nextLine();
        System.out.print("Enter name: ");
        String name=cin.nextLine();
        System.out.print("Enter email: ");
        String email=cin.nextLine();
        System.out.print("Enter password: ");
        String password=cin.nextLine();
        if(Database.checkEmailAvailability(email)){
            return false;
        }
        if(choice.equals("1")){
            Database.addCustomer(new Customer(name,email,password));
        }
        else if(choice.equals("2")){
            Database.addStoreOwner(new StoreOwner(name,email,password));
        }
        else if(choice.equals("3")){
            Database.addAdmin(new Admin(name,email,password));
        }
        return true;
    }
    private static void welcomeMessage(){
        System.out.println("************");
        System.out.println("*1.login****\n*2.Register*");
        System.out.println("************");
    }
    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        while(true){
            welcomeMessage();
            if(cin.nextInt()==1){
                if(login()){
                    System.out.println("login successfully");
                    System.out.println("Welcome back "+currentUser.getName());
                    currentUser.getView();
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
                    System.out.println("Registration failed");
                }
            }
        }

    }
}
