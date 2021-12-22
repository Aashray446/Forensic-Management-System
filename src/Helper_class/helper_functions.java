package Helper_class;

public class helper_functions {
    public static void clear_screen () {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }
}
