package Users;

import java.util.ArrayList;
import java.util.Scanner;
import Helper_class.*;

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

    //--------------------------------------DELETE USER-----------------------------------------------------------//
    public void delete_user() {
        System.out.println("Enter the user_name of the person you want to delete");
        if(user_obj.delete_user(in.next())) {
            System.out.println("User successfully deleted");
        }
        else {
            System.out.println("User Not Found");
        }
        print_work.wait_for_user();
        print_work.clear_screen();
    }
   
    // -------------------------------------CHANGE USER PASSWORD-----------------------------------------------------------//    
    public void change_user_password() {
        print_work.clear_screen();
        System.out.println("Enther the user_name of the person");
        String name = in.next();
        System.out.println("Enter the password u want to change");
        String password = in.next();
        if(super.change_password(name, password)) {
            System.out.println("The password is sucessfully changed");
        }
        else {
            System.out.println("The User is not found");
        }
        print_work.wait_for_user();
        print_work.clear_screen();
    }
    // ---------------------------------------DISPLAY ALL USERS----------------------------------------------------------//
    public void display_all_user(){
        ArrayList<String[]> user_data = user_obj.get_all_user();
        for (String[] line : user_data) {
            System.out.println(line[0] + ", " + line[1] + ", " + line[3]);
        }
        print_work.wait_for_user();
        print_work.clear_screen();
    }

    // -------------------------------------------SEARCH MY NAME------------------------------------------------------//

    public void search_user_by_name() {
        print_work.print_label("Enter the username of the User");
        String name = in.next();
        String[] user_data = super.search_user_by_name(name);
        if(user_data.length > 2) {
            for(int i = 1; i < user_data.length; i++ ) {
                System.out.print(user_data[i]);
                System.out.print(", ");
            }
            print_work.wait_for_user();
            print_work.clear_screen();
        }
        else {
            print_work.print_label("User not found");
            print_work.wait_for_user();
            print_work.clear_screen();
        }

    }


}
