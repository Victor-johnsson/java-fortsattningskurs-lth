package swing;

import selma.GeneralWordCounter;
import textproc.SortedListModel;

import javax.swing.*;
import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

public class BookReaderController {
    private JList list;
    private SortedListModel<Map.Entry<String, Integer>> sortedList;
    private JButton alphabeticButton;
    private JButton frequencyButton;
    private JTextField textField;
    private JButton searchButton;

    private JRadioButton alphabeticRadioButton;

    private JRadioButton frequencyRadioButton;


    public BookReaderController(GeneralWordCounter counter) {
        sortedList = new SortedListModel(counter.getWordList());
        SwingUtilities.invokeLater(() -> createWindow(counter, "BookReader", 100, 300));





    }
    private void createWindow(GeneralWordCounter counter, String title, int width, int height) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = frame.getContentPane();
        // pane är en behållarkomponent till vilken de övriga komponenterna
        //(listvy, knappar etc.) ska läggas till.
        JPanel panel = new JPanel();
        textField = new JTextField(10);
        list =new JList(sortedList);
       // list.setPreferedSize(200,200);
        pane.setPreferredSize(new Dimension(400,400));
        alphabeticButton = new JButton("Alphabetic");
        frequencyButton = new JButton("Frequency");
        searchButton = new JButton("Search");

        alphabeticRadioButton = new JRadioButton("Alphabetic");
        frequencyRadioButton = new JRadioButton("Frequency");
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(alphabeticRadioButton);
        radioGroup.add(frequencyRadioButton);

        textField.setSize(100,100);
        //pane.add(list);
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.add(list);


       // panel.add(alphabeticButton);
        //panel.add(frequencyButton);
        panel.add(alphabeticRadioButton);
        panel.add(frequencyRadioButton);
        panel.add(searchButton);
        panel.add(textField);

        pane.add(scrollPane);
        pane.add(panel, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);

        frame.getRootPane().setDefaultButton(searchButton);
        declareListeners();

    }

    public void declareListeners(){

        alphabeticRadioButton.addActionListener(b -> sortedList.sort((c1,c2)-> c1.getKey().compareTo(c2.getKey())));
        frequencyRadioButton.addActionListener(b -> sortedList.sort((c1,c2) -> c2.getValue() - c1.getValue()));

        searchButton.addActionListener(b -> {
            String s = textField.getText();
            ArrayList<String> list1 = new ArrayList<>();
            var model = list.getModel();

            for( int i = 0; i<model.getSize(); i++){
                Map.Entry<String,Integer> map =(Map.Entry<String,Integer>) model.getElementAt(i);
                if(map.getKey().equals(s)){
                    list.setSelectedIndex(i);

                    list.ensureIndexIsVisible(i);
                    break;
                }
                if(i==model.getSize()-1){
                    JOptionPane.showMessageDialog(null, "Word not found!");

                }
            }

        });
    }


}
