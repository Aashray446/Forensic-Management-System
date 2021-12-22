package Main_objects.Evidence;

public class Evidence {

    //COMMON PROPERTIES
    private int evidenceid;
    private String evidencename;
    private String evidencedescription;
    private String evidencetype;
    private String timeofcollection;
    private String dateofcollection;
    private String placeofcollection;
    private String collectedby;
    private String additionalinfo;


    //TODO -> add functions to methods


    public void setValue(int evidenceid, String evidencename, String evidencedescription, String evidencetype, String timeofcollection, String dateofcollection, String placeofcollection, String collectedby, String additionalinfo) {
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

    public void viewEvidences(){

    }
    public void updateEvidences(int evidenceid){

    }
    public void addEvidences(){

    }
    public void deleteEvidences(int evidenceid){

    }
}

