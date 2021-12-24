package pages.java;
import java.util.Scanner;
import java.util.ArrayList;

import Helper_class.handle_dbms;
import Helper_class.helper_functions;

public class Login {
    
    private String user_name;
    private String password;
    public String  role;

    Scanner in = new Scanner(System.in);

    public Login() {
        helper_functions.clear_screen();
        helper_functions.print_label("Welcome");
        helper_functions.print_label("Forensice Management System");
        System.out.println();
        System.out.print("Enter the Username: ");
        this.user_name = in.next();
        in.nextLine();
        System.out.print("Enter the Password: ");
        this.password = in.next();
    }   


    public Boolean check_password() {
        handle_dbms dbms = new handle_dbms();
        ArrayList<String[]> user_data = dbms.read("user.csv");
        for (String[] line : user_data) {
            if(line[1].equals(user_name) && line[2].equals(password)) {
                helper_functions.print_label("Login Successful");
                this.role = line[3];
                return true;
            }     
        }
        System.out.println("Wrong Credentials");
        return false;
    }

    public void log_out() {
        this.user_name = "";
        this.password = "";
        this.role = "";

    }
    

}
