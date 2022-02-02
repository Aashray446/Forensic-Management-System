package objects.Evidence;
import Helper_class.handle_dbms;
import Helper_class.helper_functions;
import pages.Login;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;



public class Evidence_functions {

    handle_dbms dbms = handle_dbms.getInstance();
    helper_functions functions = helper_functions.getInstance();
    Login login = Login.getInstance();
    boolean found = false;

    public void ViewEvidence(){
        while (true){
            functions.wait_for_user();
            functions.clear_screen();
            functions.print_label("VIEW EVIDENCES");
            System.out.println("[1] to view Evidence by id");
            System.out.println("[2] to view all Evidences");
            System.out.println("[3] to view by date");
            System.out.println("[4] to view by type");
            System.out.println("[5] to view evidences added by you");
            System.out.println("[0] to stop");
            int opt = functions.next_int("Enter : ");
            if (opt==1){
                System.out.println("Enter Evidence id : ");
                int id = functions.next_int("Enter : ");
                if(id==0){
                    System.out.println("ID cannot be zero");
                }else {
                    Searchbyid(id);
                }

            }
            else if (opt==2){
                viewall();

            }
            else if(opt==3){
                System.out.println("Enter date (format : DD-MM-YYYY)");
                String date = functions.next_line("Enter : ");
                viewbydate(date);
            }
            else if(opt==4){
                String type = functions.next_line("Enter type : ");
                viewbytype(type);
            }
            else if (opt==5){
                viewuserevidence();
            }
            else if(opt==0){
                functions.clear_screen();
                break;
            }
            else{
                System.out.println("Wrong Choice !");
            }

        }
    }

    public Evidence AddEvidence(){
        functions.wait_for_user();
        functions.clear_screen();
        functions.print_label("ADD EVIDENCE");
        System.out.println("");
        System.out.println("Please Enter the following details to add new Evidence");
        System.out.println();
        int evidenceid = functions.get_id("Evidences.csv");
        String evidencename = functions.next_line("Enter evidence name : ");
        String evidencedescription = functions.next_line("Enter evidence Description : ");
        String evidencetype = functions.next_line("Enter evidence Type : ");
        String timeofcollection = functions.next_line("Enter Time of collection : ");
        String dateofcollection = functions.next_line("Enter Date of collection (DD-MM-YYYY) : ");
        String placeofcollection = functions.next_line("Enter Place of collection : ");
        String collectedby = functions.next_line("Enter Collected by: ");
        String addedby = login.user_name;
        Evidence EvidenceObject = new Evidence(evidenceid,evidencename,evidencedescription,evidencetype,timeofcollection,dateofcollection,placeofcollection,collectedby,addedby);
        String content = EvidenceObject.toString();
        dbms.append(content,"Evidences.csv");
        System.out.println();
        System.out.println("Evidences Added!");
        functions.wait_for_user();
        functions.clear_screen();
        return EvidenceObject;
    }
    public void UpdateEvidence(){
        functions.wait_for_user();
        functions.clear_screen();
        functions.print_label("UPDATE EVIDENCE");
        System.out.println("Enter following details to Update evidences.");
        System.out.println();
        int id = functions.next_int("Enter Evidence id : ");
        System.out.println("[1] to change Evidence name");
        System.out.println("[2] to change Evidence description");
        System.out.println("[3] to change Evidence Type ");
        System.out.println("[4] to change Time of collection");
        System.out.println("[5] to change Date of collection");
        System.out.println("[6] to change Place of collection");
        System.out.println("[7] to change Collected by");
        int key = functions.next_int("Enter : ");
        String value = functions.next_line("Enter value to change : ");
        try {
            Updatebyid(id,key,value);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sortbyid();
        System.out.println();
        System.out.println("Evidences Updated!");
        functions.wait_for_user();
        functions.clear_screen();

    }
    public void RemoveEvidence(){
        functions.wait_for_user();
        functions.clear_screen();
        functions.print_label("REMOVE EVIDENCE");
        System.out.println("Enter following details to Delete Evidence.");
        System.out.println();
        System.out.println("Enter Evidence id : ");
        int id  = functions.next_int("Enter : ");
        try {
            Deletebyid(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sortbyid();
        System.out.println();
        System.out.println("Evidences Removed!");
        functions.wait_for_user();
        functions.clear_screen();

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

    private void viewall(){
        ArrayList<Evidence> objects = copyObjectFromFile();
        if(objects.size()==0){
            System.out.println("Evidence is Empty!");
        }
        else {
            for (int i = 0; i < objects.size(); i++) {
                print(objects.get(i));
            }
        }

    }

    private void viewbydate(String d){
        ArrayList<Evidence> objects = copyObjectFromFile();
        System.out.println(" ");
        if(objects.size()<1){
            if(objects.get(0).getEvidenceid()==0){
                System.out.println("Evidence is Empty!");
            }
        }
        else {
            for (int i = 0; i < objects.size(); i++) {
                if (objects.get(i).getDateofcollection().equals(d)) {
                    print(objects.get(i));
                    found=true;
                }
            }
            if(found==false){
                System.out.println("Couldn't find!");
            }

        }

    }

    private  void viewuserevidence(){
        ArrayList<Evidence> objects = copyObjectFromFile();
        System.out.println(" ");
        if(objects.size()<1){
            if(objects.get(0).getEvidenceid()==0){
                System.out.println("Evidence is Empty!");
            }
        }
        else {
            for (int i = 0; i < objects.size(); i++) {
                if (objects.get(i).getAddedby().equals(login.user_name)) {
                    print(objects.get(i));
                    found = true;
                }
            }
            if(found==false){
                System.out.println("Couldn't find!");
            }

        }

    }

    private void viewbytype(String t){

        ArrayList<Evidence> objects = copyObjectFromFile();
        if(objects.size()==0){
            if(objects.get(0).getEvidenceid()==0){
                System.out.println("Evidence is Empty!");
            }
        }
        else {
            System.out.println(" ");
            for (int i = 0; i < objects.size(); i++) {
                if ((objects.get(i).getEvidencetype().toUpperCase().trim()).equals(t.toUpperCase().trim())) {
                    print(objects.get(i));
                    found=true;
                }
            }
            if(found==false){
                System.out.println("Couldn't find!");
            }

        }

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
                try{
                    Evidence EvidenceObject = new Evidence(Integer.valueOf(evidences[0]), evidences[1], evidences[2], evidences[3], evidences[4], evidences[5], evidences[6], evidences[7],evidences[8]);
                    Evidences.add(EvidenceObject);

                }catch (NumberFormatException e){
                    Evidence EvidenceObject = new Evidence(0, "name","description","type","time","date", "place","collectedby","addedby");
                    Evidences.add(EvidenceObject);

                }

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
        System.out.println("Place of collection  : "+evidencePropertiesObject.getPlaceofcollection());
        System.out.println("Collected by         : "+evidencePropertiesObject.getCollectedby());
        System.out.println();
        functions.print_label("-");
    }

}



