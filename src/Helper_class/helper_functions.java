package Helper_class;

import java.util.Scanner;

public class helper_functions {
    private Scanner in = new Scanner(System.in);
    private helper_functions(){

    }

    private static helper_functions instance;

    public static helper_functions getInstance(){
        //check whether 1 obj is created or not
        if(instance == null){
            instance  = new helper_functions();
        }
        return instance;

    }

    public void clear_screen () {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    public void print_label(String to_be_printed){
        int spaces;
        int length = to_be_printed.length();
        spaces = (60-length)/2;
        for (int i = 0; i < spaces; i++){
            System.out.print("-");
        }
        System.out.print(to_be_printed);
        for (int i = 0; i < spaces; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public void print_function(String[] function_array) {
        System.out.println("Please Enter the Corresponding Number to Select among the available Functions");
        for(int i = 0; i < function_array.length; i++) {
            System.out.print(i); 
            System.out.print(". ::  ");
            System.out.print(function_array[i]);
            System.out.println();
        }
    }

    public void wait_for_user() {
        System.out.println("Press any key to Continue");
        in.nextLine();
    }

    public void show_exit_option() {
        System.out.println("100 :: Log Out And Exit");
    }

    public void exit() {
        clear_screen();
        print_label("Thank You For Using Our System");
        print_label("NAMAH SHIVAYA");
        System.exit(0);
    }

    public String next_line(String ask){
        String get = "";
        System.out.println(ask);
        Scanner input = new Scanner(System.in);
        get = input.nextLine();
        return get;
    }

}
