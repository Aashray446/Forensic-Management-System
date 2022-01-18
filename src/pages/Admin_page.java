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
    private String current_choice = "-1";
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
        while(!current_choice.equals("100")) {
        print_work.print_function(available_functions);
        print_work.show_exit_option();
        print_work.print_label("-");
        current_choice = print_work.next_line("Enter : ");
        print_work.print_label("-");
        
            //Selection Based on choices
            if(current_choice.equals("0")) {
                admin.create_new_user();
            } else if(current_choice.equals("1")) {
                admin.change_user_password();
            } else if(current_choice.equals("2")) {
                admin.delete_user();
            } else if(current_choice.equals("3")) {
                admin.display_all_user();
            } else if(current_choice.equals("4")) {
                admin.search_user_by_name();
            } else if(current_choice.equals("100")) {
                print_work.logout();
            }else if(current_choice.equals("101")) {
                print_work.exit();
            }else{
                System.out.println("Wrong Choice, try again!");
            }


        }
    }



}