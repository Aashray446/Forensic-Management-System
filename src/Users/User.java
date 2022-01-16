package Users;
import java.util.ArrayList;

import Helper_class.handle_dbms;

public class User {
    int id;
    public String user_name;
    public String password;
    public String role;
    public String name;
    public String address;
    public String phone_number;
    //Setup for the the Database
    handle_dbms dbms = handle_dbms.getInstance();
    private String database_name = "Users.csv";


    public boolean save_new_user() {
        id = get_next_id();
        if(dbms.append(convert_to_string(), database_name)){
            return true;
        }
        return false;
    }

    public void set_current_user( String user_name) {
        String[] user_data = search_user_by_name(user_name);
        this.user_name = user_name;
        this.password = user_data[2];
        this.role = user_data[3];
        this.name = user_data[4];
        this.address = user_data[5];
        this.phone_number = user_data[6];
    }

    public boolean update_user(String name, String address, String phone_number) {
        this.name = name;
        this.address = address;
        this.phone_number = phone_number;
        ArrayList<String[]> user_data = dbms.read(database_name);
        for (String[] line : user_data) {
            if(line[1].equals(this.user_name)) {
                line[4] = this.name;
                line[5] = this.address;
                line[6] = this.phone_number;
                if(dbms.write_to_file(dbms.convert_to_string(user_data), database_name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean change_password(String name, String password) {
        ArrayList<String[]> user_data = dbms.read(database_name);
        for ( String[] line : user_data) {
            if(line[1].equals(name) ) {
                line[2] = password;
                if(dbms.write_to_file(dbms.convert_to_string(user_data), database_name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String[] search_user_by_name(String name) {
        ArrayList<String[]> user_data = dbms.read(database_name);
        for ( String[] line : user_data) {
            if(line[1].equals(name) ) {
                return line;
            }
        }
        
        return new String[] {String.valueOf('N')};
    }

    public boolean delete_user(String name) {
        ArrayList<String[]> user_data = dbms.read(database_name);
        for(int i = 0; i < user_data.size(); i++) {
            if(user_data.get(i)[1].equals(name)) {
                user_data.remove(i);
                if(dbms.write_to_file(dbms.convert_to_string(user_data), database_name)) {
                    return true;
                }
            }
        }
        return false;
    }


    public int get_next_id() {
        ArrayList<String[]> user_data = dbms.read(database_name);
        int i = user_data.size() - 1;
        return Integer.parseInt(user_data.get(i)[0]) + 1;
    }


    private String convert_to_string(){
        String user_in_string =  String.valueOf(this.id) + ',' + this.user_name + ',' + this.password+ ',' + this.role + ',' + this.name + ',' + this.address + ',' + this.phone_number + '\n';
        return user_in_string;
    }


    public ArrayList<String[]> get_all_user() {
        return dbms.read(database_name);
    }

    
    
}