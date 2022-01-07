package Main_objects.Case;

import Helper_class.helper_functions;

public class Case {
    private int id;
    private String name;
    private String description;
    private int case_id;
    private String added_by_whom;


    void update_clues(){

    }

    public Case(int id, String name, String description, int case_id, String added_by_whom) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.case_id = case_id;
        this.added_by_whom = added_by_whom;
        dislplay();
    }
    //
    void dislplay() {
        // Defined some helper functions that would be used everywhere in classes 
        helper_functions help = helper_functions.getInstance();
        help.clear_screen();
        System.out.println("Congratulations, Case had been  ");
        System.out.println( "With Details: - " );
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.printf("%10s %20s %20s %20s %20s", "ID", "NAME", "DESCRIPTION", "CASE ID", "ADDED BY WHOM");
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            System.out.format("%10s %20s %20s %20s %20s",
                    this.id, this.name, this.description, this.case_id, this.added_by_whom);
            System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------");
    }

    
}
