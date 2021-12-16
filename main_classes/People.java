package main_classes;


public class People {
    int id;
    String Name;
    String Address;
    String Relation;
    boolean is_suspect;
    String reason;
    String comment;
    int added_by;
    String statements_given;

    public void create() {
        System.out.println("Created");
    }

    public void update() {
        System.out.println("updated");
    }

    public void delete() {
        System.out.println("Delted");
    }

}
