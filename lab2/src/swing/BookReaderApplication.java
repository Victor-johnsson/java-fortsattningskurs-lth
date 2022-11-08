package swing;

import selma.GeneralWordCounter;
import selma.MultiWordCounter;
import selma.SingleWordCounter;
import selma.TextProcessor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BookReaderApplication {
    public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
            "halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
            "södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
            "öland", "östergötland" };

    public static void main(String[] args) throws FileNotFoundException {




        Scanner scanner = new Scanner(new File("lab2/src/undantagsord.txt"));
        scanner.findWithinHorizon("\uFEFF", 1);
        scanner.useDelimiter(" ");
        Set<String> undantagsord = new HashSet<>();
        while (scanner.hasNext()){
            undantagsord.add(scanner.next().toLowerCase());
        }



        GeneralWordCounter counter = new GeneralWordCounter(undantagsord);

        Scanner s = new Scanner(new File("lab2/src/nilsholg.txt"));
        s.findWithinHorizon("\uFEFF", 1);
        s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning


        while (s.hasNext()) {
            String word = s.next().toLowerCase();
                counter.process(word);
        }



        s.close();

        BookReaderController controller = new BookReaderController(counter);

    }
}
