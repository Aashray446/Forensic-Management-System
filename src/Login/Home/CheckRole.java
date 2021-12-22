package Login.Home;
import Login.Admin.Admin;

public class CheckRole {
    public static void Role(String user_id)
    {
                String role =user_id.split("@")[0];
                
                switch(role)
                {    
                case "police": 
                { 
                    System.out.println();
                System.out.println(" Redirecting to the police dashboard ");
                try {
                    // Delay for 2 seonds
                    Thread.sleep(2000);   
                  }
                  catch (InterruptedException ex)
                  {
                      ex.printStackTrace();
                  }
                  System.out.println("------------------------------------------welcome to the police dashboard------------------------------------------");
                break; 
                }
                 case "lab":
                 { 
                    System.out.println();
                    System.out.println(" Redirecting to the Labratory dashboard ");
                    try {
                        // Delay for 2 seonds
                        Thread.sleep(2000);   
                      }
                      catch (InterruptedException ex)
                      {
                          ex.printStackTrace();
                      }
                      System.out.println("------------------------------------------welcome to the Lab dashboard------------------------------------------");
                    break; 
                    }
                    case "admin":
                 { 
                    System.out.println();
                    System.out.println(" Redirecting to the Admin dashboard");
                    try {
                        // Delay for 2 seonds
                        Thread.sleep(2000);   
                      }
                      catch (InterruptedException ex)
                      {
                          ex.printStackTrace();
                      }
                      Admin.admin();
                      
                    break; 
                    }

                    default:     
                   System.out.println("No roles found for you"); 
               
                 }
    }
    
}
