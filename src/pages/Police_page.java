package pages;


import Helper_class.helper_functions;

import Users.Investigator;

import java.util.Scanner;

public class Police_page extends Page {

    private Investigator investigator = new Investigator();
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
            "View People",
            "Add People",
            "Update People",
            "Delete People",
            "Change Password",
            "Update profile"
    };

    @Override
    public void start(String user_name) {
        this.user_name = user_name;
        print_work.wait_for_user();
        print_work.clear_screen();
        print_work.print_label("Welcome To Investigator Control Panel");
        print_work.print_label(this.user_name);
        System.out.println();
        home_page();
    }


    @Override
    public  void checkChangePassword(){
        Scanner in  = new Scanner(System.in);
        investigator.set_current_user(user_name);
        String old_password = print_work.next_line("Enter old password : ");
        if(old_password.equals(investigator.password)){
            String new_password = print_work.next_line("Enter new password : ");
            investigator.change_password(this.user_name,new_password);
        }
    }

    @Override
    public void updateProfile(){
        Scanner in = new Scanner(System.in);
        investigator.set_current_user(user_name);
        String name = investigator.name;
        String address = investigator.address;
        String phone_number = investigator.phone_number;
        while (true){
            System.out.println("Enter [1] to change name");
            System.out.println("Enter [2] to change address");
            System.out.println("Enter [3] to change phone number");
            System.out.println("Enter [0] to stop");
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
        if(investigator.update_user(name,address,phone_number)) {
            System.out.println("The Data has been updated");
            print_work.wait_for_user();
            print_work.clear_screen();
        }
        else {
            System.out.println("There is something wrong");
            print_work.wait_for_user();
            print_work.clear_screen();
        }
    }

    //Showing the options and taking input from the User
    @Override
    void home_page() {
        while (!current_choice.equals("100")) {
            print_work.print_function(available_functions);
            print_work.show_exit_option();
            print_work.print_label("-");
            current_choice = print_work.next_line("Enter : ");
            print_work.print_label("-");

            //Selection Based on choices
            if (current_choice.equals("0")) {
                investigator.View_Evidence();
            } else if (current_choice.equals("1")) {
                investigator.Add_Evidence();
            } else if (current_choice.equals("2")) {
                investigator.Update_Evidence();
            } else if (current_choice.equals("3")) {
                investigator.Delete_Evidence();
            } else if (current_choice.equals("4")) {
                investigator.View_Case();
            } else if (current_choice.equals("5")) {
                investigator.Add_Case();
            } else if (current_choice.equals("6")) {
                investigator.Update_Case();
            } else if (current_choice.equals("7")) {
                investigator.Delete_case();
            } else if (current_choice.equals("8")) {
                investigator.View_People();
            } else if (current_choice.equals("9")) {
                investigator.Add_People();
            } else if (current_choice.equals("10")){
                investigator.Update_people();
            } else if (current_choice.equals("11")){
                investigator.Delete_people();
            } else if (current_choice.equals("12")) {
                checkChangePassword();
            } else if (current_choice.equals("13")) {
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
