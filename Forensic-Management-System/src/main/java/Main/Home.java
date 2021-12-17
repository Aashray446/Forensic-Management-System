package Main;

import userclasses.Admin;
import userclasses.ForensicExpert;
import userclasses.Guest;
import userclasses.Investigator;

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
