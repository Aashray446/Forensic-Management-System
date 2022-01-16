package pages;

import java.util.Scanner;

import Helper_class.helper_functions;
import Users.Admin;

public class Admin_page {
    
    private helper_functions print_work = helper_functions.getInstance();
    private Admin admin = new Admin();
    private String user_name;
    private Scanner in = new Scanner(System.in);
    // Listing Out The available Functions
    private String[] available_functions = new String[] {
        "Create New User",
        "Change User Password",
        "Delete user",
        "Print all Available Users",
        "Search User By Name"
    };

    //Choice of the User
    private int current_choice = -1;
    //Start
    public void start(String user_name) {
        this.user_name = user_name;
        print_work.wait_for_user();
        print_work.clear_screen();
        print_work.print_label("Welcome To Admin Control Panel");
        print_work.print_label(this.user_name);
        System.out.println();
        home_page();
    }

    //Showing the options and taking input from the User
    private void home_page() {
        while(current_choice != 100) {
        print_work.print_function(available_functions);
        print_work.show_exit_option();
        current_choice = in.nextInt();
        
            //Selection Based on choices
            if(current_choice==0) {
                admin.create_new_user();
            }

            if(current_choice==1) {
                admin.change_user_password();
            }

            if(current_choice==2) {
                admin.delete_user();
            }

            if(current_choice==3) {
                admin.display_all_user();
            }

            if(current_choice==4) {
                admin.search_user_by_name();
            }

            if(current_choice == 100) {
                print_work.exit();
            }
        }
    }



}