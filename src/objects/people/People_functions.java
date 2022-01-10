package objects.people;

import Helper_class.handle_dbms;
import Helper_class.helper_functions;
import objects.Evidence.Evidence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class People_functions {

    handle_dbms dbms = handle_dbms.getInstance();
    helper_functions functions = helper_functions.getInstance();

    public void ViewPeople() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter People id : ");
        int id = in.nextInt();
        Searchbyid(id);
    }

    public void AddPeople() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter id : ");
        int id = in.nextInt();
        String name = functions.next_line("Enter name : ");
        String address = functions.next_line("Enter address : ");
        String desription = functions.next_line("Enter description : ");
        String category = functions.next_line("Enter category : ");
        String reason = functions.next_line("Enter reason : ");
        String comments = functions.next_line("Enter comment : ");
        String addedby = functions.next_line("Enter addedby : ");
        String statements_given = functions.next_line("Enter statements given :");

        People PeopleObject = new People(id, name, address, desription, category, reason, comments, addedby, statements_given);
        String content = PeopleObject.toString();
        dbms.append(content, "People.csv");
        sortbyid();
    }

    public void UpdatePeople() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter People id : ");
        int id = in.nextInt();
        System.out.println("[1] to change name");
        System.out.println("[2] to change address");
        System.out.println("[3] to change description ");
        System.out.println("[4] to change category");
        System.out.println("[5] to change reason");
        System.out.println("[6] to change comment");
        System.out.println("[7] to change added by");
        System.out.println("[8] to change statements given");
        System.out.println("Enter key :");
        int key = in.nextInt();
        String value = functions.next_line("Enter value to change : ");
        try {
            Updatebyid(id, key, value);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sortbyid();

    }

    public void RemovePeople() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter People id : ");
        int id = in.nextInt();
        try {
            Deletebyid(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sortbyid();

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
                System.out.println("Wrong input");
            }
            people.add(pep);
            write(people);
        } else {
            System.out.println("ID not found!");
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
                People PeopleObject = new People(Integer.valueOf(pep[0]), pep[1], pep[2], pep[3], pep[4], pep[5], pep[6], pep[8], pep[7]);
                people.add(PeopleObject);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return people;

    }

    private void print(People PeopleObject) {
        System.out.println("People id : " + PeopleObject.getId());
        System.out.println("People name : " + PeopleObject.getName());
        System.out.println("People address : " + PeopleObject.getAddress());
        System.out.println("People description : " + PeopleObject.getDescription());
        System.out.println("People category  : " + PeopleObject.getCategory());
        System.out.println("Reason : " + PeopleObject.getReason());
        System.out.println("Comment : " + PeopleObject.getComment());
        System.out.println("Added by : " + PeopleObject.getAdded_by());
        System.out.println("Statements given" + PeopleObject.getStatements_given());
    }

}