package Main_objects.Evidence;

public class Evidence {

    //TODO->add,remove properties and constructors

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

    //MATERIALISTIC PROPERTIES
    private String color;
    private String manufacturer;
    private String type;
    private String physical_state;
    private float height;
    private float weight;

    //VEHICLE PROPERTIES
    private String vehiclenumber;

    //BIOLOGICAL PROPERTIES
    private String dna;
    private String bloodgroup;
    private String drugcontent;
    private String proteins;
    private String enzymes;
    private String antigens;
    private String Rh_grouping;


    //PERSON
    private String name;
    private String ethnicity;
    private String religion;
    private String gender;
    private String mothertongue;
    private String criminalrecords;
    private String Address;
    private String DOB;
    private String ID_Proofs;
    private String contactinfo;
    private String identification_marks;



    //ADDING ALL EVIDENCE TOGETHER
    public Evidence(int evidenceid, String evidencename, String evidencedescription, String evidencetype, String timeofcollection, String dateofcollection, String placeofcollection, String collectedby, String additionalinfo, String color,float height,float weight, String manufacturer, String type, String physical_state, String vehiclenumber, String dna, String bloodgroup, String drugcontent, String proteins, String enzymes, String antigens, String rh_grouping, String name, String ethnicity, String religion, String gender, String mothertongue, String criminalrecords, String address, String DOB, String ID_Proofs, String contactinfo, String identification_marks) {
        this.evidenceid = evidenceid;
        this.evidencename = evidencename;
        this.evidencedescription = evidencedescription;
        this.evidencetype = evidencetype;
        this.timeofcollection = timeofcollection;
        this.dateofcollection = dateofcollection;
        this.placeofcollection = placeofcollection;
        this.collectedby = collectedby;
        this.additionalinfo = additionalinfo;
        this.color = color;
        this.manufacturer = manufacturer;
        this.type = type;
        this.height = height;
        this.weight = weight;
        this.physical_state = physical_state;
        this.vehiclenumber = vehiclenumber;
        this.dna = dna;
        this.bloodgroup = bloodgroup;
        this.drugcontent = drugcontent;
        this.proteins = proteins;
        this.enzymes = enzymes;
        this.antigens = antigens;
        this.Rh_grouping = rh_grouping;
        this.name = name;
        this.ethnicity = ethnicity;
        this.religion = religion;
        this.gender = gender;
        this.mothertongue = mothertongue;
        this.criminalrecords = criminalrecords;
        this.Address = address;
        this.DOB = DOB;
        this.ID_Proofs = ID_Proofs;
        this.contactinfo = contactinfo;
        this.identification_marks = identification_marks;
    }

    //ADDING GENERAL FEATURES
    public Evidence(int evidenceid, String evidencename, String evidencedescription, String evidencetype, String timeofcollection, String dateofcollection, String placeofcollection, String collectedby, String additionalinfo) {
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

    //VEHICLE DETAILS
    public Evidence(String color, String manufacturer, String type, String physical_state, String vehiclenumber) {
        this.color = color;
        this.manufacturer = manufacturer;
        this.type = type;
        this.physical_state = physical_state;
        this.vehiclenumber = vehiclenumber;
    }

    //BIOLOGICAL
    public Evidence(String dna, String bloodgroup,String color, String drugcontent, String proteins, String enzymes, String antigens, String rh_grouping) {
        this.dna = dna;
        this.bloodgroup = bloodgroup;
        this.color = color;
        this.drugcontent = drugcontent;
        this.proteins = proteins;
        this.enzymes = enzymes;
        this.antigens = antigens;
        Rh_grouping = rh_grouping;
    }

    //PEOPLE

    public Evidence(String name, String ethnicity, String religion, String gender, String mothertongue,float height,float weight, String criminalrecords, String address, String DOB, String ID_Proofs, String contactinfo, String identification_marks) {
        this.name = name;
        this.ethnicity = ethnicity;
        this.religion = religion;
        this.gender = gender;
        this.height=height;
        this.weight = weight;
        this.mothertongue = mothertongue;
        this.criminalrecords = criminalrecords;
        Address = address;
        this.DOB = DOB;
        this.ID_Proofs = ID_Proofs;
        this.contactinfo = contactinfo;
        this.identification_marks = identification_marks;
    }

    //TODO -> add functions to methods

    public void viewEvidences(){

    }
    public void updateEvidences(int evidenceid){

    }
    public void addEvidences(){

    }
    public void deleteEvidences(int evidenceid){

    }
}

