package objects.People;
import java.util.Comparator;

public class People {

    private int id;
    private String Name;
    private String Address;
    private String Description;
    private String category;
    private String reason;
    private String comment;
    private String added_by;
    private String statements_given;

    public People(int id, String name, String address, String description, String category, String reason, String comment, String added_by, String statements_given) {
        this.id = id;
        Name = name;
        Address = address;
        Description = description;
        this.category = category;
        this.reason = reason;
        this.comment = comment;
        this.added_by = added_by;
        this.statements_given = statements_given;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAdded_by() {
        return added_by;
    }

    public void setAdded_by(String added_by) {
        this.added_by = added_by;
    }

    public String getStatements_given() {
        return statements_given;
    }

    public void setStatements_given(String statements_given) {
        this.statements_given = statements_given;
    }
    public static Comparator<People> StuPeopleId = new Comparator<>() {

        public int compare(People p1, People p2) {

            int id1 = p1.getId();
            int id2 = p2.getId();
            return id1 - id2;

        }
    };
    @Override
    public String toString() {
        return id +","+Name+","+Address+ ","+Description +"," + category +"," +reason+ ","+comment+","+ added_by+","+ statements_given+"\n";
    }
}
