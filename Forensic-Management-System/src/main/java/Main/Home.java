package Main;

import User.Admin;
import User.ForensicExpert;
import User.Guest;
import User.Investigator;

public class Home {
    void callAdmin(){
        Admin admin = new Admin();
    }
    void callInvestigator(){
        Investigator investigator = new Investigator();

    }
    void callForensicExpert(){
        ForensicExpert forensicExpert = new ForensicExpert();
    }
    void callGuest(){
        Guest guest = new Guest();

    }
}
