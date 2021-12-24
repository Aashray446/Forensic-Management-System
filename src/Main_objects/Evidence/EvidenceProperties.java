package Main_objects.Evidence;
public class EvidenceProperties {

    private String evidenceid;
    private String evidencename;
    private String evidencedescription;
    private String evidencetype;
    private String timeofcollection;
    private String dateofcollection;
    private String placeofcollection;
    private String collectedby;
    private String additionalinfo;

    public EvidenceProperties(String evidenceid, String evidencename, String evidencedescription, String evidencetype, String timeofcollection, String dateofcollection, String placeofcollection, String collectedby, String additionalinfo) {
        this.evidenceid = evidenceid;
        this.evidencename = evidencename;
        this.evidencedescription = evidencedescription;
        this.evidencetype = evidencetype;
        this.timeofcollection = timeofcollection;
        this.dateofcollection = dateofcollection;
        this.placeofcollection = placeofcollection;
        this.collectedby = collectedby;
        this.additionalinfo = additionalinfo;
    }

    public String getEvidenceid() {
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

    public String getAdditionalinfo() {
        return additionalinfo;
    }

    public void setEvidenceid(String evidenceid) {
        this.evidenceid = evidenceid;
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

    public void setAdditionalinfo(String additionalinfo) {
        this.additionalinfo = additionalinfo;
    }

}

