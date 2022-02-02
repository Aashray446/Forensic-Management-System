package objects.People;

import Helper_class.handle_dbms;
import Helper_class.helper_functions;
import pages.Login;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class People_functions {

    handle_dbms dbms = handle_dbms.getInstance();
    helper_functions functions = helper_functions.getInstance();
    Login login = Login.getInstance();

    public void ViewPeople() {
        while (true){
            functions.wait_for_user();
            functions.clear_screen();
            functions.print_label("VIEW PEOPLE");
            System.out.println("[1] to view People by id");
            System.out.println("[2] to view all People");
            System.out.println("[3] to view people added by you");
            System.out.println("[0] to stop");
            String opt = functions.next_line("Enter the option : ");
            if (opt.equals("1")){
                System.out.println("Enter People id : ");
                int id = functions.next_int("Enter : ");
                if(id==0){
                    System.out.println("ID cannor be zero");
                }
                else {
                    Searchbyid(id);
                }
            }
            else if (opt.equals("2")){
                viewall();

            }
            else if(opt.equals("0")){
                functions.clear_screen();
                break;
            }
            else if(opt.equals("3")){
                viewuserpeople();
            }
            else{
                System.out.println("Wrong Choice !");
            }

        }
    }

    public People AddPeople() {
        functions.wait_for_user();
        functions.clear_screen();
        functions.print_label("ADD PEOPLE");
        System.out.println();
        System.out.println("Enter following details to add people");
        int id = functions.get_id("People.csv");
        String name = functions.next_line("Enter name : ");
        String address = functions.next_line("Enter address : ");
        String desription = functions.next_line("Enter description : ");
        String category = functions.next_line("Enter category : ");
        String reason = functions.next_line("Enter reason : ");
        String comments = functions.next_line("Enter comment : ");
        String addedby = login.user_name;
        String statements_given = functions.next_line("Enter statements given :");
        People PeopleObject = new People(id, name, address, desription, category, reason, comments, addedby, statements_given);
        String content = PeopleObject.toString();
        dbms.append(content, "People.csv");
        System.out.println();
        System.out.println("PEOPLE ADDED!");
        functions.wait_for_user();
        functions.clear_screen();
        return PeopleObject;

    }

    public void UpdatePeople() {
        functions.wait_for_user();
        functions.clear_screen();
        functions.print_label("UPDATE PEOPLE");
        System.out.println();
        System.out.println("Enter followind details to update people.");
        int id = functions.next_int("Enter People id : ");
        System.out.println("[1] to change name");
        System.out.println("[2] to change address");
        System.out.println("[3] to change description ");
        System.out.println("[4] to change category");
        System.out.println("[5] to change reason");
        System.out.println("[6] to change comment");
        System.out.println("[7] to change added by");
        System.out.println("[8] to change statements given");
        System.out.println("Enter key :");
        int key = functions.next_int("Enter : ");
        String value = functions.next_line("Enter value to change : ");
        try {
            Updatebyid(id, key, value);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sortbyid();
        System.out.println();
        System.out.println("PEOPLE UPDATED!");
        functions.wait_for_user();
        functions.clear_screen();

    }

    public void RemovePeople() {
        functions.wait_for_user();
        functions.clear_screen();
        functions.print_label("REMOVE PEOPLE");
        System.out.println();
        System.out.println("Enter following details to remove people.");
        functions.clear_screen();
        int id = functions.next_int("Enter People id : ");
        try {
            Deletebyid(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sortbyid();
        System.out.println();
        System.out.println("PEOPLE REMOVED!");
        functions.wait_for_user();
        functions.clear_screen();

    }
    public boolean checkid(int id){
        ArrayList<People> person = copyObjectFromFile();
        People E = Checkbyid(person,id);
        if (E  ==  null){
            return false;
        }
        else {
            return true;
        }

    }
    private void viewall(){
        ArrayList<People> objects = copyObjectFromFile();
        if(objects.size()==0){
            System.out.println("People data is empty!");
        }
        else {
            for (int i = 0; i < objects.size(); i++) {
                print(objects.get(i));
            }
        }


    }

    private  void viewuserpeople(){
        ArrayList<People> objects = copyObjectFromFile();
        System.out.println(" ");
        if(objects.size()==0){
            System.out.println("People is Empty!");
        }
        else {
            boolean found = false;
            for (int i = 0; i < objects.size(); i++) {
                if (objects.get(i).getAdded_by().equals(login.user_name)) {
                    print(objects.get(i));
                    found = true;
                }
            }
            if(found==false){
                System.out.println("Couldn't find!");
            }
        }

    }

    private void Deletebyid(int id) throws IOException {
        ArrayList<People> people = copyObjectFromFile();
        People pep = Checkbyid(people, id);
        people.remove(pep);
        write(people);
        sortbyid();
    }

    private void Updatebyid(int id, int key, String value) throws IOException {
        ArrayList<People> people = copyObjectFromFile();
        People pep = Checkbyid(people, id);
        people.remove(pep);
        if (pep != null) {
            if (key == 1) {
                pep.setName(value);
            } else if (key == 2) {
                pep.setAddress(value);
            } else if (key == 3) {
                pep.setDescription(value);
            } else if (key == 4) {
                pep.setCategory(value);
            } else if (key == 5) {
                pep.setReason(value);
            } else if (key == 6) {
                pep.setReason(value);
            } else if (key == 7) {
                pep.setComment(value);
            } else if (key == 8) {
                pep.setStatements_given(value);
            } else {
                System.out.println("Wrong Choice !");
                System.out.println();
            }
            people.add(pep);
            write(people);
        } else {
            System.out.println("ID not found!");
            System.out.println();
        }

    }

    private void sortbyid() {
        ArrayList<People> people = copyObjectFromFile();
        Collections.sort(people, People.StuPeopleId);
        try {
            write(people);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void write(ArrayList<People> people) throws IOException {
        String content = people.get(0).toString();
        dbms.write_to_file(content, "People.csv");
        if (people.size() > 1) {
            for (int i = 1; i < people.size(); i++) {
                content = people.get(i).toString();
                dbms.append(content, "People.csv");
            }
        }
    }

    private void Searchbyid(int id) {
        ArrayList<People> people = copyObjectFromFile();
        People pep = Checkbyid(people, id);
        if (pep != null) {
            print(pep);
        } else {
            System.out.println("ID not found!");
            System.out.println();
        }

    }

    private People Checkbyid(ArrayList<People> people, int id) {
        for (int i = 0; i < people.size(); i++) {
            if (Integer.valueOf(people.get(i).getId()) == id) {
                return people.get(i);
            }
        }
        return null;
    }

    private ArrayList<People> copyObjectFromFile() {
        ArrayList<People> people = new ArrayList<>();
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Database/People.csv"));
            while ((line = br.readLine()) != null) {
                String[] pep = line.split(",");
                try {
                    People PeopleObject = new People(Integer.valueOf(pep[0]), pep[1], pep[2], pep[3], pep[4], pep[5], pep[6], pep[7], pep[8]);
                    people.add(PeopleObject);
                }
                catch (NumberFormatException e){
                    People PeopleObject = new People(0, "name", "address", "description", "category", "reason", "comment", "addedby", "statementsgiven");
                    people.add(PeopleObject);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return people;

    }

    private void print(People PeopleObject) {
        functions.print_label("-");
        System.out.println();
        System.out.println("People id           : " + PeopleObject.getId());
        System.out.println("People name         : " + PeopleObject.getName());
        System.out.println("People address      : " + PeopleObject.getAddress());
        System.out.println("People description  : " + PeopleObject.getDescription());
        System.out.println("People category     : " + PeopleObject.getCategory());
        System.out.println("Reason              : " + PeopleObject.getReason());
        System.out.println("Comment             : " + PeopleObject.getComment());
        System.out.println("Added by            : " + PeopleObject.getAdded_by());
        System.out.println("Statements given    : " + PeopleObject.getStatements_given());
        System.out.println();
        functions.print_label("-");
    }

}