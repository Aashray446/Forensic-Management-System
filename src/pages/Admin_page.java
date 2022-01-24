package pages;

import java.util.Scanner;

import Users.Admin;

public class Admin_page extends Page {

    private Admin admin = new Admin();
    private Scanner in = new Scanner(System.in);

    // Listing Out The available Functions
    private String[] available_functions = new String[]{
            "Create New User",
            "Change User Password",
            "Delete user",
            "Print all Available Users",
            "Search User By Name",
            "Update profile",
            "Change Password",
           
    };

    @Override
    public void start(String user_name) {
        this.user_name = user_name;
        print_work.wait_for_user();
        print_work.clear_screen();
        print_work.print_label("Welcome To Admin Control Panel");
        print_work.print_label(this.user_name);
        System.out.println();
        home_page();
    }

    @Override
    void checkChangePassword() {
        admin.set_current_user(user_name);
        String old_password = print_work.next_line("Enter old password : ");
        if (old_password.equals(admin.password)) {
            String new_password = print_work.next_line("Enter new password : ");
            admin.change_password(this.user_name, new_password);
        }
    }



    @Override
    public void updateProfile(){
        admin.set_current_user(user_name);
        String name = admin.name;
        String address = admin.address;
        String phone_number = admin.phone_number;
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
        if(admin.update_user(name,address,phone_number)) {
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
    void home_page() {
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
            } else if (current_choice.equals("5")){
                updateProfile();
            } else if (current_choice.equals("6")){
                checkChangePassword();
            }
            else if(current_choice.equals("100")) {
                login.logout();
            }else if(current_choice.equals("101")) {
                login.exit();
            }else{
                System.out.println("Wrong Choice, try again!");
            }


        }
    }



}