package Main;
import Main_objects.*;
import Main_objects.Evidence.Evidence;

import java.lang.reflect.Array;
import java.util.ArrayList;

import pages.*;
import pages.java.Login;
import Helper_class.handle_dbms;

public class Main {

    public static void main(String[] args) {

      Login login_session = new Login();

      login_session.check_password();
      
      
    }


    //Trying to implement Routing Logic Based on Session storage
   /* static void routing_loop(boolean logged_in, Login login_session) {
      while(logged_in) {
        if(login_session.role.equals("admin")) {
          while(true) {
            
          }
        }
      }
    } */

}
