import java.io.FileNotFoundException;

public class Run {
    public static void main (String [] args) throws FileNotFoundException{
        DataSaver.writeToFile(LineReader.readLineBR("C:\\Users\\aburd\\Desktop\\weldnums.txt"));
        DataSaver.parseToMap(DataSaver.weldsFile);
    }   
}

