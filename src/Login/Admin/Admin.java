package Login.Admin;
import java.util.Scanner;
import Login.Main.Main;

public class Admin {
    public static void admin()
    {
        System.out.println("------------------------------------------welcome to the Admin dashboard------------------------------------------");

         feature();
    }

private  static void feature() {
  Scanner input = new Scanner(System.in);;
         String obj = input.next();
         try {
            // Delay for 7 seonds
            Thread.sleep(2000);   
          }
          catch (InterruptedException ex)
          {
              ex.printStackTrace();
          }
    //list all the Actions that can be done in this project
         switch(obj)
         {    
         case "help": 
         {
            System.out.println();
         System.out.println("--commands--   :  --------Actions---------------------- ");
         System.out.println("  create       :        create cases profile");
         System.out.println("  view         :        To view the cases profile");
         System.out.println(" update        :        To update the cases details/ user details");
         System.out.println(" change psw    :        to change the password");
         System.out.println(" create user   :        to create a new user profile");
         System.out.println(" logout        :        to logout");
         System.out.println("-----------------------------------------------------------------------------------------------");
         feature();
         break; 
         }
          case "create":
          {
         
        
         break;
          }
          case "view":
          {
         
        
         break;
          }
          case "update":
          {
         
        
         break;
          }

          case "change psw":
          {
         
        
         break;
          }
          case "create user":
          {
         
        
         break;
          }
          case "logout":
          {
         
            Main.getID_psw();
        
         break;
          }


            default:     
            System.out.println("Invalid Input /type 'help' "); 
            feature();
            
        }
        input.close();  
    }
}


     

