package Users;

import objects.Case.Case_functions;
import objects.Evidence.Evidence_functions;

public class Guest extends User {
    Evidence_functions evidence = new Evidence_functions();
    Case_functions acase = new Case_functions();


    public void ViewEvidence(){
        evidence.ViewEvidence();
    }
    public void ViewCase(){
        acase.ViewCase();
    }
    
}
