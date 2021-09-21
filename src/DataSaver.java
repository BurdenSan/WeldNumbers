
import java.io.*;
//import java.time.temporal.WeekFields;
import java.util.*;


public class DataSaver {
    public static File weldsFile = new File ("C:\\Users\\aburd\\.vscode\\Robot Weld Search\\weldNumbers.txt");
    
    public static void fileMaker (){
        try {
            if (weldsFile.createNewFile() == false){
                System.out.println("File already exists.");
            }
        }
        catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void writeToFile(HashMap <String, WeldNumber> map){
        try {
            FileWriter writer = new FileWriter (weldsFile);
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()){
                HashMap.Entry <String, WeldNumber> pair = (HashMap.Entry <String, WeldNumber>)it.next();
                WeldNumber tempWeld = pair.getValue();
                if (tempWeld.getMapKey()!=null) writer.write("new " + tempWeld.getMapKey() +"\r\n");
                else writer.write("new " +"null"+ "\r\n");
                if (tempWeld.getProgramName()!=null) writer.write("prog " + tempWeld.getProgramName()+ "\r\n");
                else writer.write("prog " + "null"+ "\r\n");
                if (tempWeld.getWeldNum()!=null) writer.write("num " + tempWeld.getWeldNum() + "\r\n");
                else writer.write("num " + "null"+ "\r\n");
                writer.write("reteaches " + tempWeld.getAmountOfTimesRetaught() + "\r\n");
                writer.write("line " + tempWeld.getlineNumber() + "\r\n");
                writer.write("dates ");
                Iterator dIterator = tempWeld.getDatesTimes().iterator();
                if (dIterator.hasNext()) {
                    while (dIterator.hasNext()){
                        writer.write((String)dIterator.next() + " ");
                    }
                }
                else writer.write("null "+ "\r\n");          
                
            }
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        


    }

    public static HashMap <String, WeldNumber> parseToMap (File textFile) throws FileNotFoundException{
        HashMap <String, WeldNumber> weldNumbersMap = new HashMap <String, WeldNumber>();
        Scanner indata = new Scanner (new FileReader(textFile));
        String weldNum = null;
        int lineNumber = 0;
        int amountOfTimesRetaught = 0;
        ArrayList <String> datesTimesRetaught = new ArrayList <String> ();
        String programName = null;
        String mapKey = null;
        while (indata.hasNextLine()){
            String line = indata.nextLine();           
            String [] splitString = line.split("\\s");
            
            for (int i=0; i<splitString.length; i++){
                if (splitString [i].equals("new")){
                    mapKey = splitString [i +1] + splitString [i+2];
                }
                else if (splitString [0].equals("prog")) {
                    programName = splitString [i+1];
                    i = splitString.length;
                } 
                else if (splitString [0].equals("num")) {
                    weldNum = (splitString[i+1] + " " +splitString [i+2]);
                    i = splitString.length;
                }
                else if (splitString [0].equals("reteaches")) {
                    amountOfTimesRetaught = Integer.parseInt(splitString[i +1]);
                    i = splitString.length;
                } 
                else if (splitString [0].equals("line")) {
                    lineNumber = Integer.parseInt(splitString[i+1]);
                    i = splitString.length;
                } 
                else if (splitString [0].equals("dates")){
                    if (splitString.length > i + 2 ) {
                        datesTimesRetaught.add(splitString [i+1]);
                    }
                    else{
                        weldNumbersMap.put(mapKey, new WeldNumber(weldNum, lineNumber, programName, amountOfTimesRetaught, mapKey, datesTimesRetaught));
                    }
                }
            }
       }
       return weldNumbersMap;
    }
}

