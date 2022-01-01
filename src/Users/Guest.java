package User;

import Main_objects.Case.Case;
import Main_objects.Evidence.Evidence;
import Users.User;

public class Guest extends User{
    Evidence evidence = new Evidence();
    Case case = new Case();


    public void ViewEvidence(){
        evidence.ViewEvidence();
    }
    public void ViewCase(){
        case.ViewCase();
    }
    
}
