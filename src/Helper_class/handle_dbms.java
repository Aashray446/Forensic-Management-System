package Helper_class;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.String;

public class handle_dbms {
    

    private handle_dbms(){

    }

    private static handle_dbms instance;
    private String base_location = "src/Database/";

    public static handle_dbms getInstance(){
        //check whether 1 obj is created or not
        if(instance == null){
            instance  = new handle_dbms();
        }
        return instance;

    }

   public boolean write_to_file(String data, String file_name) {
        try{
            String content = data;
            //Specify the file name and path here
            File file =new File(base_location + file_name);
    
            /* This logic is to create the file if the
             * file is not already present
             */
            if(!file.exists()){
               file.createNewFile();
            }
    
            //Here true is to append the content to file
            FileWriter fw = new FileWriter(file);
            //BufferedWriter writer give better performance
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            //Closing BufferedWriter Stream
            bw.close();
    
            return true;
    
          }catch(IOException ioe){
             System.out.println("Exception occurred:");
             ioe.printStackTrace();
             return false;
           }
       }
    
    //Reading file
   public ArrayList read(String file_name) {
        File file = new File(base_location + file_name);
        BufferedReader bis = null;
        FileReader  fis= null;
        String line = "";
        ArrayList<String[]> all_Data = new ArrayList<String[]>();
        try
        {
            //FileInputStream to read the file
            fis = new FileReader(file);
  
            /*Passed the FileInputStream to BufferedInputStream
             *For Fast read using the buffer array.*/
            bis = new BufferedReader(fis);
  
            /*available() method of BufferedInputStream
             * returns 0 when there are no more bytes
             * present in the file to be read*/
            while( (line = bis.readLine()) != null ){             
                all_Data.add(line.split(","));
            }
  }
  catch(FileNotFoundException fnfe)
          {
              System.out.println("The specified file not found" + fnfe);
          }
          catch(IOException ioe)
          {
              System.out.println("I/O Exception: " + ioe); 
          }
          finally
          {
              try{
                 if(bis != null && fis!=null)
                 {
                       fis.close();
                    bis.close();
                 }      
               }catch(IOException ioe)
                {
                    System.out.println("Error in InputStream close(): " + ioe);
                }         
          }
          return all_Data;
          // Converting every single line to multiple String[]
          //ArrayList<String[]> converted_data = new ArrayList<String[]>();
    }
    
    //Write Array 
   public boolean append(String data, String file_name) {
        FileOutputStream fos = null;
        File file;
        String mycontent = data;
        try {
            //Specify the file path here
        file = new File(base_location + file_name);
        fos = new FileOutputStream(file,true);
  
            /* This logic will check whether the file
         * exists or not. If the file is not found
         * at the specified location it would create
         * a new file*/
        if (!file.exists()) {
           file.createNewFile();
        }
        
        /*String content cannot be directly written into
         * a file. It needs to be converted into bytes
         */
        byte[] bytesArray = mycontent.getBytes();
  
        fos.write(bytesArray);
        fos.flush();
        return true;
         } 
         catch (IOException ioe) {
        ioe.printStackTrace();
         } 
         finally {
        try {
           if (fos != null) 
           {
           fos.close();
           }
            } 
        catch (IOException ioe) {
           System.out.println("Error in closing the Stream");
           return false;
        }
         }
         return false;
    }

    public String convert_to_string(ArrayList<String[]> data) {
        String converted_data = "";
        for (String[] line : data) {
            for(String word : line){
                converted_data = converted_data + word + ',';
            }
            converted_data = converted_data+"\n";
        }
        return converted_data;
    }

}



