package pages;

import Helper_class.helper_functions;

import Users.ForensicExpert;

import java.util.Scanner;

public class Forensic_page {

    private helper_functions print_work = helper_functions.getInstance();
    private ForensicExpert forensic_expert = new ForensicExpert();
    private String user_name;
    private Scanner in = new Scanner(System.in);

    // Listing Out The available Functions
    private String[] available_functions = new String[]{
            "View Evidence",
            "Create New Evidence",
            "Update Evidence",
            "View Case",
            "Start New Case",
            "Update Case",
            "View People",
            "Change Password",
            "Update profile"
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


    public  void checkChangePassword(){
        Scanner in  = new Scanner(System.in);
        String new_password = print_work.next_line("Enter new password : ");
        if (forensic_expert.change_password(this.user_name,new_password)) {
            System.out.println("The Password Has Been Sucessfully Changed");
            print_work.wait_for_user();
            print_work.clear_screen();
        }
        else {
            System.out.println("Sorry , Something went Wrong Try again");
            print_work.wait_for_user();
            print_work.clear_screen();
        }
    }

    public void updateProfile(){
        Scanner in = new Scanner(System.in);
        forensic_expert.set_current_user(user_name);
        String name = forensic_expert.name;
        String address = forensic_expert.address;
        String phone_number = forensic_expert.phone_number;
        while (true){
            print_work.clear_screen();
            System.out.println("Enter [1] to change name");
            System.out.println("Enter [2] to change address");
            System.out.println("Enter [3] to change phone number");
            System.out.println("Enter [0] to stop;");
            int option = in.nextInt();

            if(option==1){
                name = print_work.next_line("Enter your name :  ");
            }
            else if(option==2){
                address = print_work.next_line("Enter new Address : ");
            }
            else if(option==3){
                phone_number = print_work.next_line("Enter new contact number :");
            }
            else if(option==0){
                break;
            }
        }
        if(forensic_expert.update_user(name,address,phone_number)) {
            System.out.println("The User Details has been updated");
            print_work.wait_for_user();
            print_work.clear_screen();
        }
        else {
            System.out.println("Sorry Something Went Wrong");
            print_work.wait_for_user();
            print_work.clear_screen();
        }
    }

    //Showing the options and taking input from the User
    private void home_page() {
        while (current_choice != 100) {
            print_work.print_function(available_functions);
            print_work.show_exit_option();
            current_choice = in.nextInt();

            //Selection Based on choices
            if (current_choice == 0) {
                forensic_expert.View_Evidence();
            } else if (current_choice == 1) {
                forensic_expert.Add_Evidence();
            } else if (current_choice == 2) {
                forensic_expert.Update_Evidence();
            } else if (current_choice == 3) {
                forensic_expert.View_Case();
            } else if (current_choice == 4) {
                forensic_expert.Add_Case();
            } else if (current_choice == 5) {
                forensic_expert.Update_Case();
            }
            else if (current_choice == 6){
                forensic_expert.View_People();
            }
            else if (current_choice == 7) {
                checkChangePassword();
            } else if (current_choice == 8) {
                updateProfile();
            }
            if (current_choice == 100) {
                print_work.exit();
            }

        }

    }
}
