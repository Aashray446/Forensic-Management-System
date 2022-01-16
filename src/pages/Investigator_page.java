package pages;
import java.util.Scanner;
import Helper_class.helper_functions;


public class Investigator_page {
    
    private helper_functions print_work = helper_functions.getInstance();
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
        //TODO this.user_name = user_name;
        print_work.wait_for_user();
        print_work.clear_screen();
        print_work.print_label("Welcome To Admin Control Panel");
        //TODO print_work.print_label(this.user_name);
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
                //TODO BUG admin.create_new_user();
            }

            if(current_choice==1) {
                System.out.println("Do Seomtasdhing_!1");
            }

            if(current_choice==2) {
                System.out.println("Do Sasdeomthing_!1");
            }

            if(current_choice==3) {
                //TODO bug here use some instance of admin or make a class admin admin.display_all_user();
            }

            if(current_choice==4) {

            }

            if(current_choice == 100) {
                print_work.exit();
            }
        }
    }



}