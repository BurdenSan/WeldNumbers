

import java.io.File;
import java.io.Serializable;
import java.util.*;
public class WeldNumber implements Serializable {

    protected String weldNum;
    protected int lineNumber;
    protected int amountOfTimesRetaught;
    protected List <String> datesTimesRetaught;
    protected List <String> shiftRetaught;
    protected List <String> reasonRetaught;
    protected List <String> reteachMethod;
    protected String programName;
    protected String mapKey;
    protected HashMap <String, ReteachHistory> reteachMap;
    protected String robotNumber;
    protected ArrayList <File> pic1List;
    protected ArrayList <File> pic2List;

    public WeldNumber () {
        setWeldNum("");
        setLineNumber(0);
        setAmountOfTimesRetaught(0);
        this.datesTimesRetaught = new ArrayList <String>();
        this.shiftRetaught = new ArrayList <String>();
        this.reasonRetaught = new ArrayList <String> ();
        this.reteachMethod = new ArrayList <String> ();
        setProgramName(null);
        setMapKey(getProgramName() + getWeldNum());
        pic1List = new ArrayList <File>();
        pic2List = new ArrayList <File>();
    }
    
    public WeldNumber (String weldNum, String program, String robotNum) {
        setWeldNum(weldNum);
        setLineNumber(0);
        setAmountOfTimesRetaught(0);
        this.datesTimesRetaught = new ArrayList <String>();
        this.shiftRetaught = new ArrayList <String>();
        this.reasonRetaught = new ArrayList <String> ();
        this.reteachMethod = new ArrayList <String> ();
        setProgramName(program);
        setMapKey(getProgramName() + getWeldNum());
        this.robotNumber = robotNum;
        pic1List = new ArrayList <File>();
        pic1List.add(new File(""));
        pic2List = new ArrayList <File>();
        pic2List.add(new File(""));
    }

    public WeldNumber (String weldNum, int lineNum, String program) {
        setWeldNum(weldNum);
        setLineNumber(lineNum);
        setAmountOfTimesRetaught(0);
        this.datesTimesRetaught = new ArrayList <String>();
        this.shiftRetaught = new ArrayList <String>();
        this.reasonRetaught = new ArrayList <String> ();
        this.reteachMethod = new ArrayList <String> ();
        setProgramName(program);
        setMapKey(getProgramName() + getWeldNum());
        pic1List = new ArrayList <File>();
        pic2List = new ArrayList <File>();
    }

    public WeldNumber (String weldNum, int lineNum, String program, int amountOfTimesRetaught, String mapKey, ArrayList <String> list) {
        setWeldNum(weldNum);
        setLineNumber(lineNum);
        setAmountOfTimesRetaught(amountOfTimesRetaught);
        this.datesTimesRetaught = new ArrayList <String>();
        this.shiftRetaught = new ArrayList <String>();
        this.reasonRetaught = new ArrayList <String> ();
        this.reteachMethod = new ArrayList <String> ();
        setProgramName(program);
        setMapKey(mapKey);
        pic1List = new ArrayList <File>();
        pic2List = new ArrayList <File>();
    }

    public String getRobotNumber() {
        return robotNumber;
    }

    public void setRobotNumber(String robotNumber) {
        this.robotNumber = robotNumber;
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
        this.amountOfTimesRetaught++;
    }
    
    public void decrementRetaught() {
        this.amountOfTimesRetaught--;
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
    
    public void addAtDateTime (String dateAndTime, int index){
        datesTimesRetaught.add(index, dateAndTime);
    }
    
    public void replaceDateTime (String dateAndTime, int index){
        datesTimesRetaught.set(index, dateAndTime);
    }
    
    public void removeDateTime (int index){
        datesTimesRetaught.remove(index);
    }

    public void setShift (ArrayList <String> shift){
        this.shiftRetaught = shift;
    }
    
    public ArrayList <String> getShift () {
        return (ArrayList <String>) this.shiftRetaught;
    }

    public void addShift (String shift) {
        shiftRetaught.add(shift);
    }
    
    public void addAtShift (String shift, int index){
        shiftRetaught.add(index, shift);
    }
    
    public void replaceShift (String shift, int index){
        shiftRetaught.set(index, shift);
    }
    
    public void removeShift (int index){
        shiftRetaught.remove(index);
    }

    public void setReasonForReteach (ArrayList <String> reasonForReteach){
        this.reasonRetaught = reasonForReteach;
    }
    
    public ArrayList <String> getReason () {
        return (ArrayList <String>) this.reasonRetaught;
    }

    public void addReason (String reasonForReteach) {
        reasonRetaught.add(reasonForReteach);
    }
    
    public void addAtReason (String reason, int index){
        reasonRetaught.add(index, reason);
    }
    
    public void replaceReason (String reason, int index){
        reasonRetaught.set(index, reason);
    }
    
    public void removeReason (int index){
        reasonRetaught.remove(index);
    }

    public void setModification (ArrayList <String> modification){
        this.reteachMethod = modification;
    }
    
    public ArrayList <String> getModification () {
        return (ArrayList <String>) this.reteachMethod;
    }

    public void addModification (String modification) {
        reteachMethod.add(modification);
    }
    
    public void addAtModification (String modification, int index){
        reteachMethod.add(index, modification);
    }
    
    public void replaceModification (String modification, int index){
        reteachMethod.set(index, modification);
    }
    
    public void removeModification (int index){
        reteachMethod.remove(index);
    }
    
    public void setBeforePicList (ArrayList <File> beforePics){
        this.pic1List = beforePics;
    }
    
    public void replaceBeforePic (int index, File replacement){
        this.pic1List.set(index, replacement);
    }
    
    public ArrayList <File> getBeforePicList () {
        return (ArrayList <File>) this.pic1List;
    }
    
    public File getAtBeforePicList (int index) {
        return this.pic1List.get(index);
    }

    public void addBeforePic (File beforePic) {
        pic1List.add(beforePic);
    }
    
    public void addAtPic1 (File pic1, int index){
        pic1List.add(index, pic1);
    }
    
    public File getPic1Index (int index){
        return pic1List.get(index);        
    }
    
    public void removePic1 (int index){
        pic1List.remove(index);
    }
    
    public void setAfterPicList (ArrayList <File> afterPics){
        this.pic2List = afterPics;
    }
    
    public void replaceAfterPic (int index, File replacement){
        this.pic2List.set(index, replacement);
    }
    
    public ArrayList <File> getAfterPicList () {
        return (ArrayList <File>) this.pic2List;
    }
    
    public File getAtAfterPicList (int index) {
        return this.pic2List.get(index);
    }

    public void addAfterPic (File afterPic) {
        pic2List.add(afterPic);
    }
    
    public void addAtPic2 (File pic2, int index){
        pic2List.add(index, pic2);
    }
    
    public File getPic2Index (int index){
        return pic2List.get(index);        
    }
    
    public void removePic2 (int index){
        pic2List.remove(index);
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


