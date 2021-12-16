import java.util.Scanner;

public class Login {
    public static void start_login() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter your username");
        String name = in.next();
        System.out.println("Enter your password");
        String password = in.next();

        if (is_authorized(name, password)) {
            System.out.println("Transfering you to admin page");
        }

    }

    private static boolean is_authorized(String user_name, String password) {
    
        if(user_name.equals("admin")  && password.equals("root")) {
            System.out.println("You are logged in as admin");
            return true;
        }
        else if (user_name.equals("higher_offical") ) {
            System.out.println("Wrong");
            return false;
        }
        return false;
    }
}
