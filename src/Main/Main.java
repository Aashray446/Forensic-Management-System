package Main;

import pages.Login;


public class Main {

    public static void main(String[] args) {
        Login login = Login.getInstance();
        login.login();
    }

}
