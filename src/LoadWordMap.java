import java.util.*;

public class LoadWordMap {
    //public HashMap <String, Word> dynamicWordMap = new HashMap <String,Word>() ; //New HashMap with String key and Word value

    // public LoadWordMap(HashMap <String, Word> wordMap){
    //this.dynamicWordMap = wordMap;
    // }
   
    public static void addToMap (HashMap <String, Word> wordMap, Word newWord) {    //Method to add new words to map
        //If the map doesn't have a copy of the word already, it is added.
        //If the map does have the word, its frequency will be raised.
        if (wordMap.containsKey(newWord.getKeyword()) == false) {
            wordMap.put(newWord.getKeyword(), newWord);
        }
        else{
            Word tempWord = wordMap.get(newWord.getKeyword());
            tempWord.setKeywordFrequency(tempWord.getKeywordFrequency() + 1);
        }
    }

    public static Word getFromMap (HashMap <String, Word> wordMap, String searchWord) {     //Returns word from the map, given its keyword.
        Word wordReturn = wordMap.get(searchWord);
        return wordReturn;
    }

    public static Word getFromMap (HashMap <String, Word> wordMap, Word wordObject) {
        Word wordReturn = new Word();
        wordReturn = wordMap.get(wordReturn.getKeyword());
        return wordReturn;
    }

    
}
