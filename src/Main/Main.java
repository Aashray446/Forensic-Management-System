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
      
      if (login_session.role.equals("admin")) {
        
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
