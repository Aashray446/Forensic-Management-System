package Login;

import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;


public class Credential {
    private String name;
    private String password;

    public Credential(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public boolean checkCredentials() {
        try {
            Object obj = new JSONParser().parse(new FileReader("/mnt/1660E61660E5FC7D/AK360/Akshaj/oopsproject/Forensic-Management-System/Forensic-Management-System/src/main/java/Login/credentials.json"));
            JSONObject jo = (JSONObject) obj;
            String Checkname = (String) jo.get(this.name);
            if (Checkname==null) {
                System.out.println("Invalid username");
            } else {
                System.out.println("Valid username");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        return false;
    }
}
