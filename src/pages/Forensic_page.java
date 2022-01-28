package pages;


import Users.ForensicExpert;

import java.util.Scanner;

public class Forensic_page extends Page {

    private ForensicExpert forensic_expert = new ForensicExpert();
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


    @Override
    public void start(String user_name) {
        this.user_name = user_name;
        print_work.wait_for_user();
        print_work.clear_screen();
        print_work.print_label("Welcome To Forensic Control Panel");
        print_work.print_label(this.user_name);
        System.out.println();
        home_page();
    }


    @Override
    public  void checkChangePassword(){
        Scanner in  = new Scanner(System.in);
        forensic_expert.set_current_user(user_name);
        String old_password = print_work.next_line("Enter old password : ");
        if(old_password.equals(forensic_expert.password)){
            String new_password = print_work.next_line("Enter new password : ");
            forensic_expert.change_password(this.user_name,new_password);
        }
    }

    @Override
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
    @Override
    public void home_page() {
        while (!current_choice.equals("100")) {
            print_work.print_function(available_functions);
            print_work.show_exit_option();
            print_work.print_label("-");
            current_choice = print_work.next_line("Enter : ");
            print_work.print_label("-");

            //Selection Based on choices
            if (current_choice.equals("0")) {
                forensic_expert.View_Evidence();
            } else if (current_choice.equals("1")) {
                forensic_expert.Add_Evidence();
            } else if (current_choice.equals("2")) {
                forensic_expert.Update_Evidence();
            } else if (current_choice.equals("3")) {
                forensic_expert.View_Case();
            } else if (current_choice.equals("4")) {
                forensic_expert.Add_Case();
            } else if (current_choice.equals("5")) {
                forensic_expert.Update_Case();
            } else if (current_choice.equals("6")){
                forensic_expert.View_People();
            } else if (current_choice.equals("7")) {
                checkChangePassword();
            } else if (current_choice.equals("8")) {
                updateProfile();
            } else if(current_choice.equals("100")) {
                login.logout();
            } else if(current_choice.equals("101")) {
                login.exit();
            } else {
                System.out.println("Wrong Choice, try again!");
            }


        }

    }
}
