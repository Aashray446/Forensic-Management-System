package main_classes;

public class Case {
    private int id;
    private String name;
    private String description;
    private int case_id;
    private int added_by_whom;

    void update_clues(){

    }

    public Case(int id, String name, String description, int case_id, int added_by_whom) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.case_id = case_id;
        this.added_by_whom = added_by_whom;
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

    public int getCase_id() {
        return case_id;
    }

    public int getAdded_by_whom() {
        return added_by_whom;
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

    public void setCase_id(int case_id) {
        this.case_id = case_id;
    }

    public void setAdded_by_whom(int added_by_whom) {
        this.added_by_whom = added_by_whom;
    }
}
