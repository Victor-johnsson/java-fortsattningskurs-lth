package selma;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MultiWordCounter implements TextProcessor{
    private Map<String, Integer> wordList;
    public MultiWordCounter(String[] wordList){
        this.wordList = new TreeMap<>();
        for (String s : wordList){
            this.wordList.put(s, 0);
        }



    }
    @Override
    public void process(String w) {
        if (wordList.containsKey(w)){
            wordList.put(w, wordList.get(w)+1);

        }
    }

    @Override
    public void report() {
        for (String key : wordList.keySet()){
            System.out.println(key + ": " + wordList.get(key));
        }
    }
}
