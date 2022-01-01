package Main;

import java.lang.reflect.Array;
import java.util.ArrayList;

import pages.java.ForensicExpert_page;
import pages.java.Investigator_page;
import pages.java.Login;
import Helper_class.handle_dbms;

public class Main {

    public static void main(String[] args) {
      
        Login login_session = new Login();

        login_session.check_password();

        if (login_session.role.equals("admin")) {

        }
        else if (login_session.role.equals("forensic")) {
            new ForensicExpert_page().Forensicpage();

        }
        else if(login_session.role.equals("police")) {
            new Investigator_page().investigatorPage();

        }
        else{
          System.out.println("Something went wrong");
        }
    }

}
