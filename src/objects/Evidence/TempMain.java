package objects.Evidence;

import java.util.Scanner;

public class TempMain {
    public static void main(String[] args) {
        Evidence_functions Evidence_functions = new Evidence_functions();
        Scanner in = new Scanner(System.in);
        while (true){
            System.out.println("1->view, 2->add, 3->update, 4-> remove");
            int input = in.nextInt();
            if (input==1){
                Evidence_functions.ViewEvidence();
            }
            else if (input==2){
                Evidence_functions.AddEvidence();
            }
            else if (input==3){
                Evidence_functions.UpdateEvidence();

            }
            else if (input==4){
                Evidence_functions.RemoveEvidence();
            }
            else {
                break;
            }
        }
    }
}
