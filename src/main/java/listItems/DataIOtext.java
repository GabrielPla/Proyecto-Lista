
package listItems;
import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author Gabriel
 */
public class DataIOtext {
    
    final String directory = System.getProperty("user.home");
    final String fileName = "sample.txt";
    final String absolutePath = directory + File.separator + fileName;
    
    public DataIOtext(){
        
    }

    public void writeArray(ArrayList<Task> items) {
        // write the content in file 
        ArrayList<Task> listWrite = items;
        String fileContent = "";
        for (int i = 0; i < listWrite.size(); i++){
            fileContent += listWrite.get(i).getOnlyDetail() + "$" + listWrite.get(i).getStateString() + "/";
        }
        try(FileWriter fileWriter = new FileWriter(absolutePath)) {
            fileWriter.write(fileContent);
        } catch (IOException e) {
        // exception handling
        }
    }
    
    public ArrayList<Task> readFile() {
        //ArrayList that is going to be returned with the data on the file
        ArrayList<Task> returnData = new ArrayList<>(); 
        //String of all the data in the file, the Detail of the task and the boolean.
        String var;
        String test = "";
        //The Method to read the file
        try(FileReader fileReader = new FileReader(absolutePath)) {
            int ch = fileReader.read();
            while(ch != -1) {
                test += String.valueOf((char)ch);
                ch = fileReader.read();
            }
        } catch (FileNotFoundException e) {
            // exception handling
        } catch (IOException e) {
            // exception handling
        }
        for(int i = 0; test.contains("/"); i++){
            
            int detail = test.indexOf("$") ;
            var = test.substring(0, detail);
            
            Task taskCreated = new Task(var);
            returnData.add(taskCreated);
            
            test = test.substring((detail+1));
            
            detail = test.indexOf("/") - 1;
            var = test.substring(0, detail+1);
            System.out.print(var);
            returnData.get(i).setState(Boolean.valueOf(var));
            test = test.substring((detail+2));
        }
       
        
        return returnData;
    }
}