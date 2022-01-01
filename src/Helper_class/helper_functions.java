package Helper_class;

public class helper_functions {

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


}
