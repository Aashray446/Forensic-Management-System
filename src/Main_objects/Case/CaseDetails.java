package Main_objects.Case;


import java.util.ArrayList;

public class CaseDetails {
    private String destination;
    private ArrayList<Integer> evidence_id;
    private ArrayList<Integer> people_id;
    private ArrayList<Integer>clues_id;

    void fetch_evidence(){

    }
    void fetch_people(){

    }
    void fetch_clue(){

    }
    void add_or_rem_evidence_id(){

    }
    void add_or_rem_people_id(){

    }
    void add_or_rem_clues_id(){

    }

    public CaseDetails(String destination, ArrayList<Integer> evidence_id, ArrayList<Integer> people_id, ArrayList<Integer> clues_id) {
        this.destination = destination;
        this.evidence_id = evidence_id;
        this.people_id = people_id;
        this.clues_id = clues_id;
    }

    public String getDestination() {
        return destination;
    }

    public ArrayList<Integer> getEvidence_id() {
        return evidence_id;
    }

    public ArrayList<Integer> getPeople_id() {
        return people_id;
    }

    public ArrayList<Integer> getClues_id() {
        return clues_id;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setEvidence_id(ArrayList<Integer> evidence_id) {
        this.evidence_id = evidence_id;
    }

    public void setPeople_id(ArrayList<Integer> people_id) {
        this.people_id = people_id;
    }

    public void setClues_id(ArrayList<Integer> clues_id) {
        this.clues_id = clues_id;
    }
}
