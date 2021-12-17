package Main;

import Login.Login;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Login User = new Login(in.next(),in.next());
        if(User.checkCredentials()){

        }
    }
}
