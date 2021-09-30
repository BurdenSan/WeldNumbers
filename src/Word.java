


public class Word {

	
	//Word object that stores a String (the word you entered), its frequency, and the line numbers it appears on in your document(s).
	

	protected String keyword;
	
	protected int keywordFrequency;

	protected int [] lineNumbers;

	public Word(){
		setKeyword(null);
		setKeywordFrequency(0);
		int [] initialArray = new int [100];
		setLineNumbers(initialArray);
	}

	public Word(String word){
		setKeyword(word);
		setKeywordFrequency(1);
		int [] initialArray = new int [100];
		setLineNumbers(initialArray);
	}

	public Word(String word, int lineNum){
		setKeyword(word);
		setKeywordFrequency(1);
		int [] initialArray = new int [100];
		setLineNumbers(initialArray);
		addLineNumber(lineNum);
	}
		
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getKeywordFrequency() {
		return keywordFrequency;
	}

	public void setKeywordFrequency(int keywordFrequency) {
		this.keywordFrequency = keywordFrequency;
	}
	
	public void incrementFrequency() {
		keywordFrequency = keywordFrequency + 1;
	}

	public int [] getLineNumber() {
		return lineNumbers;
	}

	public void setLineNumbers(int [] lineNum) {
		this.lineNumbers = lineNum;
	}

	public void addLineNumber(int num) {
		for (int i=0; i<this.lineNumbers.length; i++){
			if (this.lineNumbers [i] == num){
				i = this.lineNumbers.length;
			}
			else {
				if (this.lineNumbers [i] == 0){
					this.lineNumbers [i] = num;
					i = this.lineNumbers.length;
				}
				else {
				}
			}
			
		}
			
	}
}
