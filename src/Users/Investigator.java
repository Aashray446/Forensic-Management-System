package Users;

import Main_objects.Case.Case;
import Main_objects.Evidence.Evidence;

public class Investigator extends User{
    Evidence evidence = new Evidence();
    Case case = new Case();

    public int getId() {
        return id;
    }

    public void ViewEvidence(){
        evidence.ViewEvidence();
    }
    public void AddEvidence(){
        evidence.AddEvidence();
    }
    public void UpdateEvidence(){
        evidence.UpdateEvidence();
    }
    public void RemoveEvidences(){
        evidence.RemoveEvidence();
    }
    public void ViewCase(){
        case.ViewCase();
    }
    public void AddCase(){
        case.AddCase();
    }
    public void UpdateCase(){
        case.UpdateCase();
    }
    
}
