package Users;

import java.util.ArrayList;

import Helper_class.handle_dbms;

public class Admin extends User {

    private handle_dbms dbms = handle_dbms.getInstance();

    public void create_new_user(String name, String address, String phone_number, String user_name, String password, String role ) {

    }

    //==================================Available searching methods =======================================================================
    // By name and By id
    public String[] search_user_by_name(String name){
        ArrayList<String[]> user_data = dbms.read("user.csv");
        for (String[] line : user_data) {
            if(line[0].equals(name)) {
            return line;
            }     
        }
        return String["Error Not Found"];
    }

    public String[] search_user_by_id(String id){
        ArrayList<String[]> user_data = dbms.read("user.csv");
        for (String[] line : user_data) {
            if(line[0].equals(id)) {
            return line;
            }     
        }
        return String["Error Not Found"];
    }

    //================================ Deleting methods ================================================================
    // By name and By Id
    public boolean delete_user_by_id(String id){
        ArrayList<String[]> user_data = dbms.read("user.csv");
        for (int counter = 0; counter < user_data.size(); counter++) { 		      
            if(user_data.get(counter)[0].equals(id)) {
                user_data.remove(counter);
                dbms.append(user_data, "user.csv");
                return true;
            }
        } 
        return false; 
    }

    public boolean delete_user_by_name(String name){
        ArrayList<String[]> user_data = dbms.read("user.csv");
        for (int counter = 0; counter < user_data.size(); counter++) { 		      
            if(user_data.get(counter)[0].equals(id)) {
                user_data.remove(counter);
                return true;
            }
        } 
        return false;
        dbms.append(user_data, "user.csv");
    }    

    

}
