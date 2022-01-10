package pages;


import Helper_class.helper_functions;

import Users.Investigator;

import java.util.Scanner;

public class Police_page {

    private helper_functions print_work = helper_functions.getInstance();
    private Investigator investigator = new Investigator();
    private String user_name;
    private Scanner in = new Scanner(System.in);

    // Listing Out The available Functions
    private String[] available_functions = new String[]{
            "View Evidence",
            "Create New Evidence",
            "Update Evidence",
            "Remove Evidence",
            "View Case",
            "Start New Case",
            "Update Case",
            "Remove Case",
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
        String old_password = print_work.next_line("Enter old password : ");
        if(old_password.equals(investigator.password)){
            String new_password = print_work.next_line("Enter new password : ");
            investigator.change_password(this.user_name,new_password);
        }
    }

    public void updateProfile(){
        Scanner in = new Scanner(System.in);
        String name = investigator.name;
        String address = investigator.address;
        String phone_number = investigator.phone_number;
        while (true){
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
        investigator.update_user(name,address,phone_number, investigator.password);
    }

    //Showing the options and taking input from the User
    private void home_page() {
        while (current_choice != 100) {
            print_work.print_function(available_functions);
            print_work.show_exit_option();
            current_choice = in.nextInt();

            //Selection Based on choices
            if (current_choice == 0) {
                investigator.View_Evidence();
            } else if (current_choice == 1) {
                investigator.Add_Evidence();
            } else if (current_choice == 2) {
                investigator.Update_Evidence();
            } else if (current_choice == 3) {
                investigator.Delete_Evidence();
            } else if (current_choice == 4) {
                investigator.View_Case();
            } else if (current_choice == 5) {
                investigator.Add_Case();
            } else if (current_choice == 6) {
                investigator.Update_Case();
            } else if (current_choice == 7) {
                investigator.Delete_case();
            } else if (current_choice == 8) {
                checkChangePassword();
            } else if (current_choice == 9) {
                updateProfile();
            }

            if (current_choice == 100) {
                print_work.exit();
            }

        }

    }
}
