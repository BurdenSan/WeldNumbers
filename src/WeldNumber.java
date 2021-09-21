import java.util.*;
public class WeldNumber {

    protected String weldNum;
    protected int lineNumber;
    protected int amountOfTimesRetaught;
    protected List <String> datesTimesRetaught;
    protected String programName;
    protected String mapKey;

    public WeldNumber () {
        setWeldNum(null);;
        setLineNumber(0);
        setAmountOfTimesRetaught(0);
        this.datesTimesRetaught = new ArrayList <String>();
        setProgramName(null);
        setMapKey(getProgramName() + getWeldNum());
    }

    public WeldNumber (String weldNum, int lineNum, String program) {
        setWeldNum(weldNum);
        setLineNumber(lineNum);
        setAmountOfTimesRetaught(0);
        this.datesTimesRetaught = new ArrayList <String> ();
        setProgramName(program);
        setMapKey(getProgramName() + getWeldNum());
    }

    public WeldNumber (String weldNum, int lineNum, String program, int amountOfTimesRetaught, String mapKey, ArrayList <String> list) {
        setWeldNum(weldNum);
        setLineNumber(lineNum);
        setAmountOfTimesRetaught(amountOfTimesRetaught);
        this.datesTimesRetaught = list;
        setProgramName(program);
        setMapKey(mapKey);
    }

    public String getWeldNum() {
		return weldNum;
	}
    
	public void setWeldNum(String weldNum) {
		this.weldNum = weldNum;
	}

    public int getlineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int line) {
		this.lineNumber = line;
	}

    public int getAmountOfTimesRetaught() {
		return amountOfTimesRetaught;
	}

	public void setAmountOfTimesRetaught(int numTimes) {
		this.amountOfTimesRetaught = numTimes;
	}

    public void incrementRetaught() {
        this.amountOfTimesRetaught = this.amountOfTimesRetaught++;
    }

    public void setDatesTimes (ArrayList <String> datesTimes){
        this.datesTimesRetaught = datesTimes;
    }
    
    public ArrayList <String> getDatesTimes () {
        return (ArrayList <String>) this.datesTimesRetaught;
    }

    public void addDateTime (String dateAndTime) {
        datesTimesRetaught.add(dateAndTime);
    }

    public String getProgramName () {
        return programName;
    }

    public void setProgramName (String name) {
        this.programName = name;
    }

    public String getMapKey () {
        return mapKey;
    }

    public void setMapKey (String key) {
        this.mapKey = key;
    }
}
