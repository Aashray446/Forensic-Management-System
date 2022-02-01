package pages;
import java.util.Scanner;
import java.util.ArrayList;

import Helper_class.handle_dbms;
import Helper_class.helper_functions;

public class Login {
    
    public String user_name;
    private String password;
    public String  role;

    Scanner in = new Scanner(System.in);
    helper_functions help = helper_functions.getInstance();
    handle_dbms dbms = handle_dbms.getInstance();

    private static Login instance;

    public static Login getInstance(){
        if(instance == null){
            instance  = new Login();
        }
        return instance;

    }

    
    public void start() {
        help.clear_screen();
        help.print_label("Welcome");
        help.print_label("Forensice Management System");
        System.out.println();
        System.out.print("Enter the Username: ");
        this.user_name = in.next();
        in.nextLine();
        System.out.print("Enter the Password: ");
        
        this.password = in.next();
    }

    public Boolean check_password() {
        ArrayList<String[]> user_data = dbms.read("Users.csv");
        for (String[] line : user_data) {
            if(line[1].equals(user_name) && line[2].equals(password)) {
                help.print_label("Login Successful");
                this.role = line[3];
                this.user_name = line[1];
                return true;
            }     
        }
        System.out.println("Wrong Credentials");
        return false;
    }

    public void login(){
        Scanner in = new Scanner(System.in);
        Login login_session = Login.getInstance();
        while(true) {
            login_session.start();
            if(login_session.check_password()) {
                break;
            }
            else {
                System.out.println("Press Any Key To Try Again");
                in.nextLine();
            }
        }

        if (login_session.role.equals("admin")) {
            Page as = new Admin_page();
            as.start(login_session.user_name);
        }

        else if (login_session.role.equals("forensic")) {
            Page as = new Forensic_page();
            as.start(login_session.user_name);
        }

        else if(login_session.role.equals("police")) {
            Page as = new Police_page();
            as.start(login_session.user_name);
        }

        else{
            System.out.println("Something went wrong");
        }
    }

    public void logout(){
        System.out.println("Logged out!");
        login();
    }

    public void exit() {
        help.clear_screen();
        help.print_label("Thank You For Using Our System");
        help.print_label("NAMAH SHIVAYA");
        System.exit(0);
    }

    

}
