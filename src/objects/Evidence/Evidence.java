package Main_objects.Evidence;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Evidence {

    public void ViewEvidence(){
        Scanner in = new Scanner(System.in);
        String id = in.next();
        Searchbyid(id);
    }
    public void AddEvidences() throws IOException {
        Scanner in = new Scanner(System.in);
        String evidenceid = in.next();
        String evidencename = in.nextLine();
        String evidencedescription = in.nextLine();
        String evidencetype = in.nextLine();
        String timeofcollection = in.nextLine();
        String dateofcollection = in.nextLine();
        String placeofcollection = in.nextLine();
        String collectedby = in.nextLine();
        String additionalinfo  = in.nextLine();
        EvidenceProperties EvidenceObject = new EvidenceProperties(evidenceid,evidencename,evidencedescription,evidencetype,timeofcollection,dateofcollection,placeofcollection,collectedby,additionalinfo);
        Append(EvidenceObject);
    }
    public void UpdateEvidences() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Evidence id , key , value : ");
        String id = in.next();
        int key = in.nextInt();
        String value = in.nextLine();
        Updatebyid(id,key,value);
    }
    public void RemoveEvidences() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter id : ");
        String id  = in.next();
        Deletebyid(id);
    }


    private void Append(EvidenceProperties EvidenceObject) throws IOException {
        FileOutputStream fos = null;
        File file;
        file = new File("src/Database/Evidences/evidences.csv");
        fos = new FileOutputStream(file, true);
        byte[] bytesArray;
        String content = EvidenceObject.getEvidenceid() + "," + EvidenceObject.getEvidencename() + "," + EvidenceObject.getEvidencetype() + "," + EvidenceObject.getEvidencedescription() + "," + EvidenceObject.getDateofcollection() + "," + EvidenceObject.getTimeofcollection() + "," + EvidenceObject.getPlaceofcollection() + "," + EvidenceObject.getCollectedby() + "," + EvidenceObject.getAdditionalinfo() + "\n";
        bytesArray = content.getBytes();
        fos.write(bytesArray);
        fos.flush();
        fos.close();
    }

    private void write(ArrayList<EvidenceProperties> Evidences , String filename) throws IOException {
        FileOutputStream fos = null;
        File file;
        file = new File(filename);
        fos = new FileOutputStream(file);
        byte[] bytesArray;
        for (int i = 0; i < Evidences.size(); i++) {
            String content = Evidences.get(i).getEvidenceid() + "," + Evidences.get(i).getEvidencename() + "," + Evidences.get(i).getEvidencetype() + "," + Evidences.get(i).getEvidencedescription() + "," + Evidences.get(i).getDateofcollection() + "," + Evidences.get(i).getTimeofcollection() + "," +Evidences.get(i).getPlaceofcollection() + "," + Evidences.get(i).getCollectedby() + "," + Evidences.get(i).getAdditionalinfo() + "\n";
            bytesArray = content.getBytes();
            fos.write(bytesArray);
        }
        fos.flush();
        fos.close();

    }

    private void Searchbyid(String id) {
        ArrayList<EvidenceProperties> Evidences = copyObjectFromFile();
        EvidenceProperties evidence = Checkbyid(Evidences,id);
        if (evidence != null){
            print(evidence);
        }
        else {
            System.out.println("ID not found!");
        }

    }

    private EvidenceProperties Deletebyid(String id) throws IOException {
        ArrayList<EvidenceProperties> Evidences = copyObjectFromFile();
        ArrayList<EvidenceProperties> Evidencestemp = new ArrayList<>();
        for (int i = 0; i < Evidences.size(); i++) {
            if (Evidences.get(i).getEvidenceid().equals(id)) {
            }
            else{
                Evidencestemp.add(Evidences.get(i));
            }
            write(Evidencestemp,"src/Database/Evidences/evidences.csv");
        }
        return null;

    }

    private void Updatebyid(String id, int key, String value) throws IOException {
        ArrayList<EvidenceProperties> Evidences = copyObjectFromFile();
        EvidenceProperties evidence = Checkbyid(Evidences,id);
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
            else if (key == 8){
                evidence.setAdditionalinfo(value);
            }
            write(Evidences,"src/Database/Evidences/evidences.csv");
        }
        else {
            System.out.println("ID not found!");
        }

    }


    private EvidenceProperties Checkbyid(ArrayList<EvidenceProperties> Evidences, String id) {
        EvidenceProperties a = null;
        for (int i = 0; i < Evidences.size(); i++) {
            if (Evidences.get(i).getEvidenceid().equals(id)) {
                return Evidences.get(i);
            }
        }
        return a;
    }

    private ArrayList<EvidenceProperties> copyObjectFromFile() {
        ArrayList<EvidenceProperties> Evidences = new ArrayList<>();
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Database/Evidences/evidences.csv"));
            while ((line = br.readLine()) != null) {
                String[] evidences = line.split(",");
                EvidenceProperties EvidenceObject = new EvidenceProperties(evidences[0], evidences[1], evidences[2], evidences[3], evidences[4], evidences[5], evidences[6], evidences[7], evidences[8]);
                Evidences.add(EvidenceObject);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Evidences;

    }

    private void print(EvidenceProperties evidencePropertiesObject) {
        System.out.println(evidencePropertiesObject.getEvidenceid());
        System.out.println(evidencePropertiesObject.getEvidencename());
        System.out.println(evidencePropertiesObject.getEvidencetype());
        System.out.println(evidencePropertiesObject.getEvidencedescription());
        System.out.println(evidencePropertiesObject.getTimeofcollection());
        System.out.println(evidencePropertiesObject.getDateofcollection());
        System.out.println(evidencePropertiesObject.getCollectedby());
        System.out.println(evidencePropertiesObject.getAdditionalinfo());
    }


}



