package Users;

import java.util.ArrayList;
import java.util.Scanner;
import Helper_class.*;
import objects.User;

public class Admin extends User {


    private helper_functions print_work = helper_functions.getInstance();
    private Scanner in = new Scanner(System.in);
    private User user_obj = new User();


    public void create_new_user() {
        print_work.clear_screen();
        print_work.print_label("Please Enter The User Details");
        //ASK USERS TO INPUT user_name, password, role, name , address, phone_number serailly
        //Store that to User class 
        //Call new save_new_user()
        System.out.println("Enter the username");
        user_obj.user_name = in.next();
        print_work.print_label(" ");
        System.out.println("Enter the password");
        user_obj.password = in.next();
        print_work.print_label(" ");
        System.out.println("Enter the role");
        user_obj.role = in.next();
        if(user_obj.save_new_user()) {
            print_work.print_label("The USER IS CREATED");
            print_work.wait_for_user();
        }
        else{
            print_work.print_label("THE USER COULDN'T BE CREATED");
            print_work.wait_for_user();
        }
    }
    private void delete_user() {

    }
    private void change_user_password() {

    }
    private void display_all_user(){

    }
    private void search_user_by_name() {

    }

}
