


import java.io.*;
//import java.time.temporal.WeekFields;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DataSaver {
    static String mydir = System.getProperty("user.home") + "\\welds";
    public static File weldsFile;
    
    public static void fileMaker (String robotNum, String cellName){
        try {
             weldsFile =new File (mydir, cellName + "RB" +robotNum);
            if (weldsFile.createNewFile() == false){
                System.out.println("File already exists.");
            }
        }
        catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void fileMaker (String robotNum, String cellName, String weldNum, String frameStyle){
        try {
             weldsFile = new File (mydir, cellName + "RB" +robotNum + frameStyle +weldNum + ".obj");
            if (weldsFile.createNewFile() == false){
                //System.out.println("File already exists.");
                //Add Handling for File Already Exists
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

    public static void serializerSave (WeldNumber objectToSave) throws IOException {
        FileOutputStream fos = new FileOutputStream(weldsFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(objectToSave);
        fos.close();
        oos.close();
    }
    
    
    public static WeldNumber retrieveSave (String weldFile) throws FileNotFoundException{
        WeldNumber retrievedWeld = new WeldNumber();
        try {
            FileInputStream fis = new FileInputStream(weldFile);
            ObjectInputStream ois = new ObjectInputStream (fis);
            retrievedWeld = (WeldNumber) ois.readObject();
            fis.close();
            ois.close();
        } catch (IOException ex) {
            Logger.getLogger(DataSaver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataSaver.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retrievedWeld;
        
    }

    public static WeldNumber supplyRetrieveSave(String cellName, String weldNumber, String frameStyle) {
        WeldNumber returnMe = new WeldNumber();
        
        File test1 = new File (mydir, cellName + "RB" + "1" + frameStyle + weldNumber + ".obj");
        //why does this only exist if program has been closed and reopened???
        File test2 = new File (mydir, cellName + "RB" + "2" + frameStyle + weldNumber + ".obj");
        if (test1.exists()){
            try {
                String debugString = test1.getAbsolutePath();
                return retrieveSave(test1.getAbsolutePath());
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else if (test2.exists()){
            try {
                return retrieveSave(test2.getAbsolutePath());
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return returnMe;

    }
    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException{
    
}
}

