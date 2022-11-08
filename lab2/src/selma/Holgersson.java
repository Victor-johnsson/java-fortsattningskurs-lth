package selma;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Holgersson {

    public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
            "halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
            "södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
            "öland", "östergötland" };

    public static void main(String[] args) throws FileNotFoundException {

        long t0 = System.nanoTime();



        Scanner scanner = new Scanner(new File("lab2/src/undantagsord.txt"));
        scanner.findWithinHorizon("\uFEFF", 1);
        scanner.useDelimiter(" ");
        Set<String> undantagsord = new HashSet<>();
        while (scanner.hasNext()){
            undantagsord.add(scanner.next().toLowerCase());
        }


        TextProcessor p = new SingleWordCounter("nils");
        List<TextProcessor> textProcessors = new ArrayList<TextProcessor>();
        //textProcessors.add(p);
        //textProcessors.add(new SingleWordCounter("norge"));
        textProcessors.add(new MultiWordCounter(REGIONS));
        textProcessors.add(new GeneralWordCounter(undantagsord));
        Scanner s = new Scanner(new File("lab2/src/nilsholg.txt"));
        s.findWithinHorizon("\uFEFF", 1);
        s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning



        while (s.hasNext()) {
            String word = s.next().toLowerCase();
            for (var tp : textProcessors){
                tp.process(word);
            }

        }

        s.close();

        for (var tp : textProcessors){
            tp.report();
        }

        long t1 = System.nanoTime();
        System.out.println("tid: " + (t1 - t0) / 1000000.0 + " ms");

    }
}