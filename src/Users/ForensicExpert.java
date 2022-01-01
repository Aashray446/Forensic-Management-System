package Users;

import Main_objects.Evidence.Evidence;
import Main_objects.Case.Case;

public class ForensicExpert extends User {

    Evidence evidence = new Evidence();
    Case case = new Case();


    public void ViewEvidence(){
        evidence.ViewEvidence();
    }
    public void AddEvidence(){
        evidence.AddEvidence();
    }
    public void UpdateEvidence(){
        evidence.UpdateEvidence();
    }
    public void DeleteEvidence(){
        evidence.RemoveEvidences();
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

