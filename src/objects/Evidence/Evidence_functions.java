package objects.Evidence;
import Helper_class.handle_dbms;
import Helper_class.helper_functions;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Evidence_functions {

    handle_dbms dbms = handle_dbms.getInstance();
    helper_functions functions = helper_functions.getInstance();

    public void ViewEvidence(){
        functions.clear_screen();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Evidence id : ");
        int id = in.nextInt();
        Searchbyid(id);
    }

    public Evidence AddEvidence(){
        functions.clear_screen();
        System.out.println("Please Enter the following details to add new Evidence");
        System.out.println();
        int evidenceid = functions.get_id("Evidences.csv");
        String evidencename = functions.next_line("Enter evidence name : ");
        String evidencedescription = functions.next_line("Enter evidence Description : ");
        String evidencetype = functions.next_line("Enter evidence Type : ");
        String timeofcollection = functions.next_line("Enter Time of collection : ");
        String dateofcollection = functions.next_line("Enter Date of collection : ");
        String placeofcollection = functions.next_line("Enter Place of collection : ");
        String collectedby = functions.next_line("Enter Collected by: ");
        Evidence EvidenceObject = new Evidence(evidenceid,evidencename,evidencedescription,evidencetype,timeofcollection,dateofcollection,placeofcollection,collectedby);
        String content = EvidenceObject.toString();
        dbms.append(content,"Evidences.csv");
        sortbyid();
        return EvidenceObject;
    }
    public void UpdateEvidence(){
        functions.clear_screen();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter following details to Update evidences.");
        System.out.println();
        System.out.println("Enter Evidence id : ");
        int id = in.nextInt();
        System.out.println("[1] to change Evidence name");
        System.out.println("[2] to change Evidence description");
        System.out.println("[3] to change Evidence Type ");
        System.out.println("[4] to change Time of collection");
        System.out.println("[5] to change Date of collection");
        System.out.println("[6] to change Place of collection");
        System.out.println("[7] to change Collected by");
        System.out.println("Enter key :");
        int key = in.nextInt();
        String value = functions.next_line("Enter value to change : ");
        try {
            Updatebyid(id,key,value);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sortbyid();

    }
    public void RemoveEvidence(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter following details to Delete Evidence.");
        System.out.println();
        System.out.println("Enter Evidence id : ");
        int id  = in.nextInt();
        try {
            Deletebyid(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sortbyid();

    }

    private void Deletebyid(int id) throws IOException {
        ArrayList<Evidence> Evidences = copyObjectFromFile();
        Evidence evidence = Checkbyid(Evidences,id);
        Evidences.remove(evidence);
        write(Evidences);
        sortbyid();
    }

    private void Updatebyid(int id, int key, String value) throws IOException {
        ArrayList<Evidence> Evidences = copyObjectFromFile();
        Evidence evidence = Checkbyid(Evidences,id);
        Evidences.remove(evidence);
        if (evidence != null){
            if (key == 1){
                evidence.setEvidencename(value);
            }
            else if (key == 2){
                evidence.setEvidencedescription(value);
            }
            else if (key == 3){
                evidence.setEvidencetype(value);
            }
            else if (key == 4){
                evidence.setTimeofcollection(value);
            }
            else if (key == 5){
                evidence.setDateofcollection(value);
            }
            else if (key == 6){
                evidence.setPlaceofcollection(value);
            }
            else if (key == 7){
                evidence.setCollectedby(value);
            }
            else {
                System.out.println("Wrong Choice!");
                System.out.println();
            }
            Evidences.add(evidence);
            write(Evidences);
        }
        else {
            System.out.println("ID not found!");
            System.out.println();
        }

    }

    public int giveid(Evidence evidence){
        return evidence.getEvidenceid();
    }

    public boolean checkid(int id){
        ArrayList<Evidence> Evidences = copyObjectFromFile();
        Evidence E = Checkbyid(Evidences,id);
        if (E  ==  null){
            return false;
        }
        else {
            return true;
        }

    }

    private void sortbyid(){
        ArrayList<Evidence> Evidences = copyObjectFromFile();
        Collections.sort(Evidences, Evidence.StuEvidenceId);
        try {
            write(Evidences);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void write(ArrayList<Evidence> Evidences) throws IOException {
        String content = Evidences.get(0).toString();
        dbms.write_to_file(content,"Evidences.csv");
        if (Evidences.size()>1){
            for (int i = 1; i < Evidences.size(); i++) {
                content = Evidences.get(i).toString();
                dbms.append(content, "Evidences.csv");
            }
        }
    }

    private void Searchbyid(int id) {
        ArrayList<Evidence> Evidences = copyObjectFromFile();
        Evidence evidence = Checkbyid(Evidences,id);
        if (evidence != null){
            print(evidence);
        }
        else {
            System.out.println("ID not found!");
            System.out.println();
        }

    }
    private Evidence Checkbyid(ArrayList<Evidence> Evidences, int id) {
        for (int i = 0; i < Evidences.size(); i++) {
            if (Integer.valueOf(Evidences.get(i).getEvidenceid())==id) {
                return Evidences.get(i);
            }
        }
        return null;
    }

    private ArrayList<Evidence> copyObjectFromFile() {
        ArrayList<Evidence> Evidences = new ArrayList<>();
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Database/Evidences.csv"));
            while ((line = br.readLine()) != null) {
                String[] evidences = line.split(",");
                Evidence EvidenceObject = new Evidence(Integer.valueOf(evidences[0]), evidences[1], evidences[2], evidences[3], evidences[4], evidences[5], evidences[6], evidences[7]);
                Evidences.add(EvidenceObject);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Evidences;

    }
    private void print(Evidence evidencePropertiesObject) {
        functions.print_label("-");
        System.out.println();
        System.out.println("Evidence id          : "+evidencePropertiesObject.getEvidenceid());
        System.out.println("Evidence name        : "+evidencePropertiesObject.getEvidencename());
        System.out.println("Evidence type        : "+evidencePropertiesObject.getEvidencetype());
        System.out.println("Evidence description : "+evidencePropertiesObject.getEvidencedescription());
        System.out.println("Time of collection   : "+evidencePropertiesObject.getTimeofcollection());
        System.out.println("Date of collection   : "+evidencePropertiesObject.getDateofcollection());
        System.out.println("Place of collection  : "+evidencePropertiesObject.getDateofcollection());
        System.out.println("Collected by         : "+evidencePropertiesObject.getCollectedby());
        System.out.println();
        functions.print_label("-");
    }

}



