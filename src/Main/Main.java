package Main;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import pages.Login;
import pages.Admin_page;
import Helper_class.handle_dbms;
public class Main {

    public static void main(String[] args) {
        // The Login starts from here
        // Will keep running on loop until users enter right password
        Scanner in = new Scanner(System.in);
        Login login_session = new Login();
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
            Admin_page as = new Admin_page();
            as.start(login_session.user_name);
        }

        else if (login_session.role.equals("forensic")) {
           
        }

        else if(login_session.role.equals("police")) {
         
        }

        else{
          System.out.println("Something went wrong");
        }
    }

}
