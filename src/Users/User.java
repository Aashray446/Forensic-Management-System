package Users;
import java.util.ArrayList;

import Helper_class.handle_dbms;
import Helper_class.helper_functions;

public class User {
    int id;
    protected String user_name;
    protected String name;
    protected String address;
    protected String phone_number;
    protected String password;
    protected String role;
    
    //Setup for the the Database
    handle_dbms dbms = handle_dbms.getInstance();
    private String database_name = "Users.csv";


    protected boolean save_new_user() {
        id = get_next_id();
        if(dbms.append(convert_to_string(), database_name)){
            return true;
        }
        return false;
    }


    protected boolean update_user(String name, String address, String phone_number, String password) {
        this.name = name;
        this.address = address;
        this.phone_number = phone_number;
        this.password = password;
        return false;
    }

    protected boolean change_password(String name, String password) {
        ArrayList<String[]> user_data = dbms.read(database_name);
        for ( String[] line : user_data) {
            if(line[1].equals(name) ) {
                line[2] = password;
                if(dbms.append(dbms.convert_to_string(user_data), database_name)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected String[] search_user_by_name(String name) {
        ArrayList<String[]> user_data = dbms.read(database_name);
        for ( String[] line : user_data) {
            if(line[1].equals(name) ) {
                return line;
            }
        }
        
        return new String[] {String.valueOf('N')};
    }

    protected boolean delete_user(String name) {
        ArrayList<String[]> user_data = dbms.read(database_name);
        for(int i = 0; i < user_data.size(); i++) {
            if(user_data.get(i)[1].equals(name)) {
                user_data.remove(i);
                if(dbms.append(dbms.convert_to_string(user_data), database_name)) {
                    return true;
                }
            }
        }
        return false;
    }


    protected int get_next_id() {
        ArrayList<String[]> user_data = dbms.read(database_name);
        int i = user_data.size() - 1;
        return Integer.parseInt(user_data.get(i)[0]) + 1;
    }


    private String convert_to_string(){
        String user_in_string =  String.valueOf(this.id) + ',' + this.user_name + ',' + this.password+ ',' + this.role + '\n';
        return user_in_string;
    }


    protected ArrayList<String[]> get_all_user() {
        return dbms.read(database_name);
    }

    
    
}