package Users;

import objects.Case.Case_functions;
import objects.Evidence.Evidence_functions;
import objects.People.People_functions;


public class ForensicExpert extends User {

    Evidence_functions evidence = new Evidence_functions();
    Case_functions acase = new Case_functions();
    People_functions person = new People_functions();


    public void View_Evidence(){
        evidence.ViewEvidence();
    }
    public void Add_Evidence(){
        evidence.AddEvidence();
    }
    public void Update_Evidence(){
        evidence.UpdateEvidence();
    }
    public void View_Case(){
        acase.ViewCase();
    }
    public void Add_Case(){
        acase.AddCase();
    }
    public void Update_Case(){
        acase.UpdateCase();
    }
    public void View_People(){
        person.ViewPeople();
    }

}

