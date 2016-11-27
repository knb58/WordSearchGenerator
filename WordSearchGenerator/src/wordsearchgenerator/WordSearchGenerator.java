package wordsearchgenerator;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This class creates the introductory GUI for data collection
 *
 * @author Kirsten Baker
 */
public class WordSearchGenerator {

    public WordSearchGenerator() {

        //features
        JPanel features = new JPanel();
        JLabel advFeat = new JLabel("Advanced Features");
        JCheckBox diagonal = new JCheckBox("Diagonal");
        JCheckBox backwards = new JCheckBox("Backwards");
        JCheckBox numbers = new JCheckBox("Numbers");
        features.add(advFeat);
        features.add(diagonal);
        features.add(backwards);
        features.add(numbers);

        JPanel gameInfo = new JPanel();

        //Read in from file
        JLabel fileWords = new JLabel("File Name");
        JTextField file = new JTextField(20);

        //Size wanted
        JLabel size = new JLabel("Size");
        JTextField prefSize = new JTextField(4);
        prefSize.setText("10");

        JButton create = new JButton("Create");
        gameInfo.add(fileWords);
        gameInfo.add(file);
        gameInfo.add(size);
        gameInfo.add(prefSize);

        class create implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent event) {

                //get needed info
                String fileName = file.getText();
                String gridSize = prefSize.getText();
                ReadFile rf = new ReadFile(fileName);
                WordSearch game = new WordSearch(Integer.parseInt(gridSize), diagonal.isSelected(), backwards.isSelected(), numbers.isSelected());
            }
        }

        ActionListener createGame = new create();
        create.addActionListener(createGame);

        JFrame generator = new JFrame();
        generator.add(gameInfo, BorderLayout.NORTH);
        generator.add(features, BorderLayout.CENTER);
        generator.add(create, BorderLayout.SOUTH);

        generator.setSize(450, 140);
        generator.setTitle("Word Search Generator");
        generator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        generator.setLocationRelativeTo(null);
        generator.setResizable(false);
        generator.setVisible(true);
    }

    public static void main(String[] args) {
        WordSearchGenerator generate = new WordSearchGenerator();
        //    C:\\Users\\User\\Desktop\\WordSearchGenerator\\test1.txt
        //    C:\\Users\\User\\Desktop\\WordSearchGenerator\\numbertest1.txt
    }
}
