package Login;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Login {
    private String name;
    private String password;

    public Login(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public boolean checkCredentials() {
        try {
            Object obj = new JSONParser().parse(new FileReader("Forensic-Management-System/src/main/java/Login/credentials.json"));
            JSONObject jo = (JSONObject) obj;
            String Checkname = (String) jo.get(this.name);
            if (Checkname==null) {
                System.out.println("Invalid username");
            } else if (Checkname.equals(this.password)) {
                System.out.println("Password matched");
                return true;
            }else{
                System.out.println("Password wrong");
            }

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    public String checkRoles(){
        try{
            Object obj = new JSONParser().parse(new FileReader("src/main/java/Login/roles.json"));
            JSONObject jo = (JSONObject) obj;
            String role = (String) jo.get(this.name);
            return role;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
