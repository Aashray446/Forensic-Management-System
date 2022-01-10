package objects.Case;


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

    public People(int id, String name, String address, String relation, boolean is_suspect, String reason, String comment, int added_by, String statements_given) {
        this.id = id;
        Name = name;
        Address = address;
        Relation = relation;
        this.is_suspect = is_suspect;
        this.reason = reason;
        this.comment = comment;
        this.added_by = added_by;
        this.statements_given = statements_given;
    }


}
