package objects.Case;
import Helper_class.handle_dbms;
import Helper_class.helper_functions;
import objects.Evidence.Evidence;;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Case_functions {
    handle_dbms dbms = handle_dbms.getInstance();
    helper_functions functions = helper_functions.getInstance();


    public void AddCase(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Case id : ");
        int caseid = in.nextInt();
        String casename = functions.next_line("Enter case name : ");
        String casedescription = functions.next_line("Enter case Description : ");
        String addedby = functions.next_line("Enter your name : ");
        ArrayList<Integer> evidence_id = new ArrayList<>();
        while (true){
            System.out.println("Enter 0 to stop");
            System.out.println("Enter evidence id :");
            int id = in.nextInt();
            if (id == 0){
                break;
            }
            else{
                evidence_id.add(id);
            }

        }
        ArrayList<Integer> people_id = new ArrayList<>();
        while (true){
            System.out.println("Enter 0 to stop");
            System.out.println("Enter people id :");
            int id = in.nextInt();
            if (id == 0){
                break;
            }
            else{
                people_id.add(id);
            }

        }

        Case CaseObject = new Case(caseid,casename,casedescription,evidence_id,addedby,people_id);
        String content = CaseObject.toString();
        dbms.append(content,"Cases.csv");
        //sortbyid();
    }

    public void ViewCase(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Case id : ");
        int id = in.nextInt();
        Searchbyid(id);
    }

    public void UpdateEvidence(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Case id : ");
        int id = in.nextInt();
        System.out.println("[1] to change Case name");
        System.out.println("[2] to change Case description");
        System.out.println("[3] to change added_by");
        System.out.println("[4] to change time of collection");
        System.out.println("[5] to change date of collection");
        System.out.println("[6] to change place of collection");
        System.out.println("[7] to change collected by");
        System.out.println("Enter key :");
        int key = in.nextInt();
        String value = functions.next_line("Enter value to change : ");
        try {
            //Updatebyid(id,key,value);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //sortbyid();

    }

    private void Searchbyid(int id) {
        ArrayList<Case> Cases = copyObjectFromFile();
        Case acase = Checkbyid(Cases,id);
        if (acase != null){
            print(acase);
        }
        else {
            System.out.println("ID not found!");
        }

    }
    private Case Checkbyid(ArrayList<Case> Cases, int id) {
        for (int i = 0; i < Cases.size(); i++) {
            if (Integer.valueOf(Cases.get(i).getId())==id) {
                return Cases.get(i);
            }
        }
        return null;
    }
    private ArrayList<Case> copyObjectFromFile() {
        ArrayList<Case> Cases = new ArrayList<>();
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Database/Cases.csv"));
            while ((line = br.readLine()) != null) {
                String[] cases = line.split(",");
                String[] evid = cases[3].split(" ");
                String[] peid = cases[5].split(" ");
                ArrayList<Integer> evidence_id = new ArrayList<>();
                ArrayList<Integer> people_id = new ArrayList<>();
                for (int i = 0; i < evid.length  ; i++) {
                    evidence_id.add(Integer.valueOf(evid[i]));
                }
                for (int i = 0; i < peid.length  ; i++) {
                    people_id.add(Integer.valueOf(peid[i]));
                }
                Case CaseObject = new Case(Integer.valueOf(cases[0]), cases[1], cases[2], evidence_id, cases[4], people_id);
                Cases.add(CaseObject);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Cases;

    }
    private void print(Case CaseObject) {
        System.out.println("Case id : "+CaseObject.getId());
        System.out.println("Case name : "+CaseObject.getName());
        System.out.println("Case description : "+CaseObject.getDescription());
        System.out.println("Collected by : "+CaseObject.getAdded_by());
        System.out.println("Evidence ids : "+CaseObject.getEvidence_id());
        System.out.println("People ids :  "+CaseObject.getPeople_id());
    }

}
