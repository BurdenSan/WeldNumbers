import java.io.*;
import java.util.*;
//import java.nio.charset.Charset;
//import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class LineReader {

    public static HashMap <String, WeldNumber> readLineBR(String fileName, String robotNumber) throws FileNotFoundException {
         
       HashMap <String, WeldNumber> weldNumbers = new HashMap <String, WeldNumber>();
       
       Scanner indata = new Scanner (new FileReader(fileName));
       int currentLine = 0;
       while (indata.hasNextLine()){           
           String line = indata.nextLine();           
           String [] splitString = line.split("\\s");
            for (int i=0; i<splitString.length; i++){
                if (splitString [i].equalsIgnoreCase("weld") && isStringNumber(splitString [i +1])){
                    if (weldNumbers.containsKey(splitString [i])){                //If the map already contains the word contained in this line of the file
                        }
                    else{
                        //Here we will create the weld number object that will get added to our map
                        //It currently holds its name, its map key, and the name of the file it came from
                        WeldNumber tempNumber = new WeldNumber(splitString [i] + " " + splitString [i+1], currentLine + 1, fileName);
                        tempNumber.setRobotNumber(robotNumber);
                        weldNumbers.put(tempNumber.getMapKey(), tempNumber);
                    }
                }
                
            }
            currentLine++;
       }     
       indata.close();   
       return weldNumbers;
       
       
    }

    public static boolean isStringNumber (String test) {
        try {
            int intValue = Integer.parseInt(test);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
