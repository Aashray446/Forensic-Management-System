package objects.Case;
import Helper_class.handle_dbms;

import java.util.ArrayList;
import java.util.Comparator;

public class Case {
    private int id;
    private String name;
    private String description;
    private ArrayList<Integer> evidence_id;
    private String added_by;
    private ArrayList<Integer> people_id;

    handle_dbms functions = handle_dbms.getInstance();

    public Case(int id, String name, String description, ArrayList<Integer> evidence_id, String added_by, ArrayList<Integer> people_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.evidence_id = evidence_id;
        this.added_by = added_by;
        this.people_id = people_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Integer> getEvidence_id() {
        return evidence_id;
    }

    public void setEvidence_id(ArrayList<Integer> evidence_id) {
        this.evidence_id = evidence_id;
    }

    public String getAdded_by() {
        return added_by;
    }

    public void setAdded_by(String added_by) {
        this.added_by = added_by;
    }

    public ArrayList<Integer> getPeople_id() {
        return people_id;
    }

    public void setPeople_id(ArrayList<Integer> people_id) {
        this.people_id = people_id;
    }


    public static Comparator<Case> StuCaseId = new Comparator<>() {

        public int compare(Case c1, Case c2) {

            int id1 = c1.getId();
            int id2 = c2.getId();
            return id1 - id2;

        }
    };

    @Override
    public String toString(){
        String evid = "";
        String peid = "";
        try {
            for (int i = 0; i < this.evidence_id.size(); i++) {
                evid += evidence_id.get(i);
                if (i != evidence_id.size() - 1) {
                    evid += " ";
                }
            }
            for (int i = 0; i < this.people_id.size(); i++) {
                peid += people_id.get(i);
                if (i!= people_id.size()-1){
                    peid += " ";
                }

            }
        }
        catch (NullPointerException e){}
        return this.id+","+this.name+","+this.description+","+evid+","+this.added_by+","+peid+"\n";
    }
}
