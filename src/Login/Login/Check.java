package Login.Login;
import java.io.File;

import Login.Home.CheckRole;
import Login.Main.Main;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Check {

    public static void Validate(String user_id, String password)
       {
           //Enter the pathway of the file in your pc 
        String fileNameDefined = "C:\\Users\\singh\\Desktop\\Forensics\\Forensics\\lib\\Database.csv";
        File file = new File(fileNameDefined);
        try{ 
             Scanner scan = new Scanner(file);
            while(scan.hasNext())
            {   String userid = scan.next();
                String user = userid.split(",")[0];
                String pass = userid.split(",")[1];
                if (user_id.equals(user) && password.equals(pass))
                {
                    try {
                         // Delay for 2 seonds
                         Thread.sleep(2000);   
                       }
                       catch (InterruptedException ex)
                       {
                           ex.printStackTrace();
                       }
                        System.out.println("-------------------------------------Login Successful---------------------------------------------");
                        CheckRole.Role(user_id);
                    }

                }
                scan.close();
                try {
                    // Delay for 2 seonds
                    Thread.sleep(2000);   
                  }
                  catch (InterruptedException ex)
                  {
                      ex.printStackTrace();
                  }
                   System.out.println("Invalid userID /password");
                   Main.getID_psw();
            

            }
            catch (FileNotFoundException e){

                e.printStackTrace();
             } 
        }

    }
