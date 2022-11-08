package selma;

import java.util.*;

import static java.util.Map.Entry.comparingByValue;

public class GeneralWordCounter implements TextProcessor{
    private Set<String> stopwords;
    private Map<String, Integer> wordList = new HashMap<>();
    public GeneralWordCounter(Set set){
        this.stopwords = set;
    }
    @Override
    public void process(String w) {
        if (!stopwords.contains(w)){
            if (!wordList.containsKey(w)){
                wordList.put(w, 1);
            } else {
                wordList.put(w, wordList.get(w) + 1);
            }
        }

    }

    @Override
    public void report() {

        Set<Map.Entry<String, Integer>> wordSet = wordList.entrySet();
        List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);

        /*
        Comparator<Integer> intComparator = Comparator.comparingInt(value -> {
            return Map.Entry.comparingByValue();
        });

         */
       // wordList.sort(Comparator.comparingInt(Map.Entry<String,Integer>::getValue).thenComparing());

        wordList.sort((c1,c2)->{
            if(!c1.getValue().equals(c2.getValue())){
                return c1.getValue() - c2.getValue();
            }else{
               return c1.getKey().compareTo(c2.getKey());
            }
        });


        //wordList.sort(Map.Entry.comparingByKey());
      //  wordList.sort((c1,c2)-> c1.getKey().compareTo(c2.getKey()));
       // wordList.sort((c1,c2) -> c2.getValue() - c1.getValue());

        for (int i = 0; i < 100; i++){
            System.out.println(wordList.get(i));
        }




    }

    public List<Map.Entry<String, Integer>> getWordList() {
        Set<Map.Entry<String, Integer>> wordSet = wordList.entrySet();
        List<Map.Entry<String, Integer>> words = new ArrayList<>(wordSet);
        return words;

    }
}
