package objects.Evidence;

import java.util.Comparator;

public class Evidence {

    private int  evidenceid;
    private String evidencename;
    private String evidencedescription;
    private String evidencetype;
    private String timeofcollection;
    private String dateofcollection;
    private String placeofcollection;
    private String collectedby;
    private String addedby;

    public Evidence(int evidenceid, String evidencename, String evidencedescription, String evidencetype, String timeofcollection, String dateofcollection, String placeofcollection, String collectedby, String addedby) {
        this.evidenceid = evidenceid;
        this.evidencename = evidencename;
        this.evidencedescription = evidencedescription;
        this.evidencetype = evidencetype;
        this.timeofcollection = timeofcollection;
        this.dateofcollection = dateofcollection;
        this.placeofcollection = placeofcollection;
        this.collectedby = collectedby;
        this.addedby = addedby;
    }

    public int getEvidenceid() {
        return evidenceid;
    }

    public String getEvidencename() {
        return evidencename;
    }

    public String getEvidencedescription() {
        return evidencedescription;
    }

    public String getEvidencetype() {
        return evidencetype;
    }

    public String getTimeofcollection() {
        return timeofcollection;
    }

    public String getDateofcollection() {
        return dateofcollection;
    }

    public String getPlaceofcollection() {
        return placeofcollection;
    }

    public String getCollectedby() {
        return collectedby;
    }

    public String getAddedby() {
        return addedby;
    }

    public void setAddedby(String addedby) {
        this.addedby = addedby;
    }

    public void setEvidencename(String evidencename) {
        this.evidencename = evidencename;
    }

    public void setEvidencedescription(String evidencedescription) {
        this.evidencedescription = evidencedescription;
    }

    public void setEvidencetype(String evidencetype) {
        this.evidencetype = evidencetype;
    }

    public void setTimeofcollection(String timeofcollection) {
        this.timeofcollection = timeofcollection;
    }

    public void setDateofcollection(String dateofcollection) {
        this.dateofcollection = dateofcollection;
    }

    public void setPlaceofcollection(String placeofcollection) {
        this.placeofcollection = placeofcollection;
    }

    public void setCollectedby(String collectedby) {
        this.collectedby = collectedby;
    }

    public static Comparator<Evidence> StuEvidenceId = new Comparator<>() {

        public int compare(Evidence s1, Evidence s2) {

            int id1 = s1.getEvidenceid();
            int id2 = s2.getEvidenceid();
            return id1 - id2;

        }
    };
    @Override
    public String toString() {
        return evidenceid +"," +evidencename + ","+evidencedescription +"," +evidencetype +"," +timeofcollection + ","+dateofcollection +","+ placeofcollection +","+ collectedby+","+addedby+"\n";
    }


}

