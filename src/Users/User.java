package Users;

import Helper_class.handle_dbms;

public class User {
    int id;
    String name;
    String address;
    String phone_number;
    String user_name;
    String password;
    String role;
    
    handle_dbms dbms = handle_dbms.getInstance();

    public boolean update_user(String name, String address, String phone_number, String password) {
        this.name = name;
        this.address = address;
        this.phone_number = phone_number;
        this.password = password;
        return false;
    }
    public boolean change_password() {

        return false;
    }

    private String[] convert_to_array(){
        Strings[] array_data = {this.id, this.name, this.address, this.phone_number, this.user_name, this.password, this.role};
    }
}