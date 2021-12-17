package evidence;

public class Evidences {
    private int id;
    private String name;
    private String description;
    private int added_by_whom;
    private String date;
    private int case_id;

    public Evidences(int id, String name, String description, int added_by_whom, String date, int case_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.added_by_whom = added_by_whom;
        this.date = date;
        this.case_id = case_id;
    }

    void fetch_related_case(){

    }
    void update_evidence(){

    }
    void delete_evidence(){

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getAdded_by_whom() {
        return added_by_whom;
    }

    public String getDate() {
        return date;
    }

    public int getCase_id() {
        return case_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAdded_by_whom(int added_by_whom) {
        this.added_by_whom = added_by_whom;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCase_id(int case_id) {
        this.case_id = case_id;
    }
}
