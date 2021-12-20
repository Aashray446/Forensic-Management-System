package Evidence;

public class Evidence {
    private String id;
    private String description;
    private String type;
    private String time;
    private String date;
    private String collected_by;

    public Evidence(String id, String description, String type, String time, String date, String collected_by) {
        this.id = id;
        this.description = description;
        this.type = type;
        this.time = time;
        this.date = date;
        this.collected_by = collected_by;
    }
}
