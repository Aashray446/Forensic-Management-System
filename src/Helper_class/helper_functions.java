package Helper_class;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class helper_functions {
    private Scanner in = new Scanner(System.in);
    private handle_dbms dbms = handle_dbms.getInstance();
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
        System.out.println();
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
        System.out.println("100 :: Log Out");
        System.out.println("101 :: Log Out And Exit");
    }


    public String next_line(String ask){
        String get = "";
        System.out.print(ask);
        get = in.nextLine();
        if (get.equals("")){
            return null;
        }
        return get;
    }


    public int next_int(String ask){
        int get ;
        do{
            try {
                //this scanner is needed
                Scanner in = new Scanner(System.in);
                System.out.println(ask);
                get = in.nextInt();
                return get;
            }catch (NumberFormatException | InputMismatchException e){
                System.out.println("Enter Numbers only!");

            }
        }while (true);
    }

    public int get_id(String file_name){
        try {
            ArrayList<String[]> user_data = dbms.read(file_name);
            int i = user_data.size() - 1;
            return Integer.valueOf(user_data.get(i)[0]) + 1;
        }
        catch (IndexOutOfBoundsException | NumberFormatException e){
            return 1;
        }
    }

}
