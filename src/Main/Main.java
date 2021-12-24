package Main;
import Helper_class.handle_dbms;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        String a = "asdasd asdasda sdea sd";
        handle_dbms dbms = new handle_dbms();
        ArrayList ad = dbms.read("user.csv");
        
        
    }
}
