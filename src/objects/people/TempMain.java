package objects.people;

import objects.Evidence.Evidence_functions;

import java.util.Scanner;

public class TempMain {
    public static void main(String[] args) {
        People_functions people_functions = new People_functions();
        Scanner in = new Scanner(System.in);
        while (true){
            System.out.println("1->view, 2->add, 3->update, 4-> remove");
            int input = in.nextInt();
            if (input==1){
                people_functions.AddPeople();
            }
            else if (input==2){
                people_functions.ViewPeople();
            }
            else if (input==3){
                people_functions.UpdatePeople();

            }
            else if (input==4){
                people_functions.RemovePeople();
            }
            else {
                break;
            }
        }
    }
}
