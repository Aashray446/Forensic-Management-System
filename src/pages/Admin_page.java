package pages;

import java.util.Scanner;

import Helper_class.helper_functions;


public class Admin_page {
    
    private helper_functions print_work = helper_functions.getInstance();
    private String user_name;
    private Scanner in = new Scanner(System.in);
    private String[] available_functions = new String[] {
        "Create New User",
        "Change User Password",
        "Delete user",
        "Print all Available Users",
        "Search User By Name"
    };
    private int current_choice = -1;

    public void start(String user_name) {
        this.user_name = user_name;
        System.out.println("Press Any Key To Continue");
        in.nextLine();
        print_work.clear_screen();
        print_work.print_label("Welcome To Admin Control Panel");
        print_work.print_label(this.user_name);
        System.out.println();
        home_page();
    }

    private void home_page() {
        print_work.print_function(available_functions);
        current_choice = in.nextInt();

        while(current_choice != 100) {
        print_work.print_function(available_functions);
        current_choice = in.nextInt();
            if(current_choice==0) {
                System.out.println("Do Seomthing_!asd1");
                current_choice = 100;
            }
            if(current_choice==1) {
                System.out.println("Do Seomtasdhing_!1");
            }
            if(current_choice==2) {
                System.out.println("Do Sasdeomthing_!1");
            }
            if(current_choice==3) {
                System.out.println("aDsdo Seomthing_!1");
            } 
            if(current_choice==4) {

            }       
        }
    }

}