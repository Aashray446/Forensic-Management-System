package objects.Case;

import Helper_class.handle_dbms;
import Helper_class.helper_functions;
import objects.Evidence.Evidence;
import objects.Evidence.Evidence_functions;
import objects.People.People;
import objects.People.People_functions;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Case_functions {
    handle_dbms dbms = handle_dbms.getInstance();
    helper_functions functions = helper_functions.getInstance();
    Evidence_functions evidence = new Evidence_functions();
    People_functions person = new  People_functions();



    public void AddCase(){
        functions.clear_screen();
        int caseid = functions.get_id("Cases.csv");
        String casename = functions.next_line("Enter case name : ");
        String casedescription = functions.next_line("Enter case Description : ");
        String addedby = functions.next_line("Enter your name : ");
        ArrayList<Integer> evidence_id = new ArrayList<>();
        while (true){
            System.out.print("Enter evidence id :");
            int id = functions.next_int("Enter : ");
            boolean hasid = evidence.checkid(id);
            if (id == 0){
                evidence_id.add(null);
            }
            else if (hasid){
                if(checkpepevid(id,'e')){
                    System.out.println("Evidence id already exists!");
                }
                else{
                    evidence_id.add(id);
                }
            }
            else {
                System.out.println("ID entered is not valid!");
                System.out.println("Enter [1] to add new evidence");
                int opt = functions.next_int("Enter : ");
                if (opt==1){
                    Evidence newevd = evidence.AddEvidence();
                    evidence_id.add(newevd.getEvidenceid());
                }
            }
            System.out.println("Enter [0] to stop enter anything add more:");
            int check  = functions.next_int("Enter : ");
            if (check==0){
                break;
            }

        }
        ArrayList<Integer> people_id = new ArrayList<>();
        while (true){
            System.out.println("Enter people id :");
            int id = functions.next_int("Enter : ");
            boolean hasid = person.checkid(id);
            if (id == 0){
                people_id.add(null);
            }
            else if (hasid){
                if (checkpepevid(id,'p')){
                    System.out.println("People id already exist!");
                }else{
                    people_id.add(id);
                }
            }
            else {
                System.out.println("ID entered is not valid!");
                System.out.println("Enter [1] to add new person");
                int opt = functions.next_int("Enter : ");
                if (opt==1){
                    People newperson = person.AddPeople();
                    people_id.add(newperson.getId());
                }
            }
            System.out.println("Enter [0] to stop enter anything add more:");
            int check  = functions.next_int("Enter : ");
            if (check==0){
                break;
            }

        }

        Case CaseObject = new Case(caseid,casename,casedescription,evidence_id,addedby,people_id);
        String content = CaseObject.toString();
        dbms.append(content,"Cases.csv");
        sortbyid();
    }

    public void ViewCase(){
        functions.clear_screen();
        while (true){
            System.out.println("[1] to view case by id");
            System.out.println("[2] to view all case");
            System.out.println("[0] to stop");
            int opt = functions.next_int("Enter : ");
            if (opt==1){
                System.out.println("Enter Case id : ");
                int id = functions.next_int("Enter : ");
                if (id==0){
                    System.out.println("Id cannot be zero");
                }
                else {
                    Searchbyid(id);

                }

            }
            else if (opt==2){
                viewall();

            }
            else if(opt==0){
                break;
            }
            else{
                System.out.println("Wrong Choice !");
            }

        }
    }

    public void UpdateCase(){
        functions.clear_screen();
        System.out.println("Enter Case id : ");
        int id = functions.next_int("Enter  : ");
        System.out.println("[1] to change Case name");
        System.out.println("[2] to change Case description");
        System.out.println("[3] to change added by");
        System.out.println("[4] to change evidence ids");
        System.out.println("[5] to change people ids");
        System.out.println("Enter key :");
        int key = functions.next_int("Enter : ");
        String value  = "";
        ArrayList<Integer> arrvalues;
        ArrayList<Case> cases = copyObjectFromFile();
        Case acase = Checkbyid(cases,id);
        if (key == 4){
            System.out.println("Enter index to change : ");
            int index = functions.next_int("Enter : ");
            assert acase != null;
            arrvalues = acase.getEvidence_id();
            System.out.println("Enter new id : ");
            int intvalue = functions.next_int("Enter : ");
            arrvalues.set(index,intvalue);

        }
        else if (key ==5){
            System.out.println("Enter index to change : ");
            int index = functions.next_int("Enter : ");
            assert acase != null;
            arrvalues = acase.getPeople_id();
            System.out.println("Enter new id :");
            int intvalue = functions.next_int("Enter : ");
            arrvalues.set(index,intvalue);
        }
        else {
            value = functions.next_line("Enter value to change : ");
            arrvalues = null;
        }
        try {
            Updatebyid(id,key,value,arrvalues);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sortbyid();

    }

    private boolean checkpepevid(int id, char x){
        ArrayList<Case> cases = copyObjectFromFile();
        for (Case aCase : cases) {
            String[] line = String.valueOf(aCase).trim().split(",");
            if (x == 'e') {
                String[] evidenceids = line[3].split(" ");
                for (String evidenceid : evidenceids) {
                    if (Integer.parseInt(evidenceid) == id) {
                        return true;
                    }
                }

            } else if (x == 'p') {
                String[] peopleids = line[5].split(" ");
                for (String peopleid : peopleids) {
                    if (Integer.parseInt(peopleid) == id) {
                        return true;
                    }

                }

            }
        }
        return false;


    }
    private void viewall(){
        ArrayList<Case> objects = copyObjectFromFile();
        if (objects.size()==1){
            System.out.println("Case is Empty");

        }
        else {
            for (int i = 1; i < objects.size(); i++) {
                print(objects.get(i));
            }
        }


    }
    private void Updatebyid(int id, int key, String value, ArrayList<Integer> arrval) throws IOException {
        ArrayList<Case> cases = copyObjectFromFile();
        Case acase = Checkbyid(cases,id);
        cases.remove(acase);
        if (acase != null){
            if (key == 1){
                acase.setName(value);
            }
            else if (key == 2){
                acase.setDescription(value);
            }
            else if (key == 3){
                acase.setAdded_by(value);
            }
            else if (key == 4){
                acase.setEvidence_id(arrval);
            }
            else if (key == 5){
                acase.setPeople_id(arrval);
            }
            else {
                System.out.println("Wrong Choice!");
                System.out.println();
            }
            cases.add(acase);
            write(cases);
        }
        else {
            System.out.println("ID not found!");
            System.out.println();
        }

    }

    public void RemoveCase(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Case id : ");
        int id  = in.nextInt();
        try {
            Deletebyid(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sortbyid();

    }
    private void Deletebyid(int id) throws IOException {
        ArrayList<Case> Cases = copyObjectFromFile();
        Case acase = Checkbyid(Cases,id);
        Cases.remove(acase);
        write(Cases);
    }

    private void sortbyid(){
        ArrayList<Case> Cases = copyObjectFromFile();
        Cases.sort(Case.StuCaseId);
        try {
            write(Cases);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void write(ArrayList<Case> Cases) throws IOException {
        String content = Cases.get(0).toString();
        dbms.write_to_file(content,"Cases.csv");
        if (Cases.size()>1){
            for (int i = 1; i < Cases.size(); i++) {
                content = Cases.get(i).toString();
                dbms.append(content, "Cases.csv");
            }
        }
    }

    private void Searchbyid(int id) {
        ArrayList<Case> Cases = copyObjectFromFile();
        Case acase = Checkbyid(Cases,id);
        if (acase != null){
            print(acase);
        }
        else {
            System.out.println("ID not found!");
            System.out.println();
        }

    }
    private Case Checkbyid(ArrayList<Case> Cases, int id) {
        for (Case aCase : Cases) {
            if (aCase.getId() == id) {
                return aCase;
            }
        }
        return null;
    }
    private ArrayList<Case> copyObjectFromFile() {
        ArrayList<Case> Cases = new ArrayList<>();
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Database/Cases.csv"));
            while ((line = br.readLine()) != null) {
                String[] cases = line.split(",");
                String[] evid = cases[3].split(" ");
                String[] peid = cases[5].split(" ");
                ArrayList<Integer> evidence_id = new ArrayList<>();
                ArrayList<Integer> people_id = new ArrayList<>();
                for (String s : evid) {
                    evidence_id.add(Integer.valueOf(s));
                }
                for (String s : peid) {
                    people_id.add(Integer.valueOf(s));
                }
                try{
                    Case CaseObject = new Case(Integer.parseInt(cases[0]), cases[1], cases[2], evidence_id, cases[4], people_id);
                    Cases.add(CaseObject);

                }catch (NumberFormatException e){
                    Case CaseObject = new Case(0,"name", "description",null,"addedby",null);
                    Cases.add(CaseObject);

                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Cases;

    }
    private void print(Case CaseObject) {
        functions.print_label("-");
        System.out.println();
        System.out.println("Case id          : "+CaseObject.getId());
        System.out.println("Case name        : "+CaseObject.getName());
        System.out.println("Case description : "+CaseObject.getDescription());
        System.out.println("Collected by     : "+CaseObject.getAdded_by());
        System.out.println("Evidence ids     : "+CaseObject.getEvidence_id());
        System.out.println("People ids       : "+CaseObject.getPeople_id());
        System.out.println();
        functions.print_label("-");
    }

}
