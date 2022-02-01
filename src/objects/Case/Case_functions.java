package objects.Case;

import Helper_class.handle_dbms;
import Helper_class.helper_functions;
import objects.Evidence.Evidence;
import objects.Evidence.Evidence_functions;
import objects.People.People;
import objects.People.People_functions;
import pages.Login;

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
    Login login = Login.getInstance();



    public void AddCase(){
        functions.clear_screen();
        int caseid = functions.get_id("Cases.csv");
        String casename = functions.next_line("Enter case name : ");
        String casedescription = functions.next_line("Enter case Description : ");
        String addedby = login.user_name;

        ArrayList<Integer> evidence_id = new ArrayList<>();
        ArrayList<Integer> people_id = new ArrayList<>();


        System.out.println("Please Enter id to add evidences , if it doesn't exist u can add new evidence.");
        while (true){
            int id = functions.next_int("Enter evidence id (Enter 0 to stop):");
            boolean hasid = evidence.checkid(id);
            if (id == 0 && evidence_id.size()>0){
                break;
            }
            else if (id==0){
                System.out.println("Enter add atleast one evidence id!");
            }
            else if (hasid){
                if(checkpeoplevidence(id,'e',evidence_id)){
                    System.out.println("Evidence id already exists! Enter again!");
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

        }

        System.out.println("Please Enter id to add evidences , if it doesn't exist u can add new people.");
        while (true){
            int id = functions.next_int("Enter people id (Enter 0 to stop):");
            boolean hasid = person.checkid(id);
            if (id == 0 && people_id.size()>0){
                break;
            }
            else if (id==0){
                System.out.println("Enter add atleast one people id!");
            }
            else if (hasid){
                if (checkpeoplevidence(id,'p',people_id)){
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

        }

        Case CaseObject = new Case(caseid,casename,casedescription,evidence_id,addedby,people_id);
        dbms.append(String.valueOf(CaseObject),"Cases.csv");
    }

    private boolean checkpeoplevidence(int id, char x, ArrayList<Integer> List){
        ArrayList<Case> cases = copyObjectFromFile();
        for (int i = 0; i < List.size(); i++) {
            if (Integer.valueOf(List.indexOf(i))==id){
                return true;
            }
        }
        Case thisobject = Checkbyid(cases,id);
        try {
            String[] line = String.valueOf(thisobject).trim().split(",");
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
        catch (NullPointerException | ArrayIndexOutOfBoundsException e){
            return false;
        }
        return false;


    }

    private Case Checkbyid(ArrayList<Case> Cases, int id) {
        for (Case aCase : Cases) {
            if (aCase.getId() == id) {
                return aCase;
            }
        }
        return null;
    }



    public void ViewCase(){
        functions.clear_screen();
        while (true){
            System.out.println("[1] to view case by id");
            System.out.println("[2] to view all case");
            System.out.println("[3] to view cases added by you");
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
            else if (opt==3){
                viewusercase();
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
        ArrayList<Integer> arrvalues = null;
        ArrayList<Case> cases = copyObjectFromFile();
        Case acase = Checkbyid(cases,id);
        if (key == 4){
            System.out.println("Enter index of id to change from 0. If index doesn't exist it will be appended.");
            System.out.println("Enter index to change : ");
            int index = functions.next_int("Enter : ");
            System.out.println("Enter new id : ");
            int intvalue = functions.next_int("Enter : ");
            try {
                assert acase != null;
                arrvalues = acase.getEvidence_id();
                arrvalues.set(index, intvalue);
            }
            catch (IndexOutOfBoundsException e){
                if (checkpeoplevidence(intvalue,'e',arrvalues)){
                    System.out.println("Index not found , id already exist");
                }
                else {
                    boolean hasid = evidence.checkid(intvalue);
                    if (hasid) {
                        System.out.println("Index not found but added it at last index!");
                        arrvalues.add(intvalue);
                    }
                    else {
                        System.out.println("Evidence id doesnt exist!");
                    }
                }
            }

        }
        else if (key ==5){
            System.out.println("Enter index of id to change from 0. If index doesnt exist it will be appended.");
            System.out.println("Enter index to change : ");
            int index = functions.next_int("Enter : ");
            System.out.println("Enter new id :");
            int intvalue = functions.next_int("Enter : ");
            try {
                assert acase != null;
                arrvalues = acase.getPeople_id();
                arrvalues.set(index, intvalue);
            }
            catch (IndexOutOfBoundsException e){
                if (checkpeoplevidence(intvalue,'p',arrvalues)){
                    System.out.println("Index not found , id already exist");
                }
                else {
                    boolean hasid = person.checkid(intvalue);
                    if (hasid) {
                        System.out.println("Index not found but added it at last index!");
                        arrvalues.add(intvalue);
                    }
                    else {
                        System.out.println("People id doesnt exist");
                    }
                }
            }
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
    }


    private void viewall(){
        ArrayList<Case> objects = copyObjectFromFile();
        if (objects.size()==1){
            System.out.println("Case is Empty");

        }
        else {
            for (int i = 0; i < objects.size(); i++) {
                if (objects.get(i).getId() != 0){
                    print(objects.get(i));
                }
            }
        }


    }

    private  void viewusercase(){
        ArrayList<Case> objects = copyObjectFromFile();
        System.out.println(" ");
        System.out.println(" ");
        if(objects.size()==1){
            if(objects.get(0).getId()==0){
                System.out.println("Evidence is Empty!");
            }
        }
        else {
            for (int i = 0; i < objects.size(); i++) {
                if (objects.get(i).getAdded_by().equals(login.user_name)) {
                    print(objects.get(i));
                }
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
        sortbyid();

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
                dbms.append(String.valueOf(Cases.get(i)),"Cases.csv");
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


    private ArrayList<Case> copyObjectFromFile() {
        ArrayList<Case> Cases = new ArrayList<>();
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Database/Cases.csv"));
            while ((line = br.readLine()) != null) {
                try{
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
                    Case CaseObject = new Case(Integer.valueOf(cases[0]), cases[1], cases[2], evidence_id, cases[4], people_id);
                    Cases.add(CaseObject);

                }catch (NumberFormatException | ArrayIndexOutOfBoundsException e){
                    Case CaseObject = new Case(0,null, null,null,null,null);
                    Cases.add(CaseObject);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Cases;

    }

    private void print(Case CaseObject) {
        functions.clear_screen();
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
