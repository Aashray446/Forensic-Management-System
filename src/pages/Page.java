package pages;
import Helper_class.helper_functions;

public abstract class Page {

    helper_functions print_work = helper_functions.getInstance();
    Login login = new Login();
    String user_name;
    String current_choice = "-1";

    abstract void start(String user_name);
    abstract  void checkChangePassword();
    abstract void home_page();
    abstract void updateProfile();
}

