package wordsearchgenerator;

import java.awt.BorderLayout;
import java.awt.Image;
import static java.awt.PageAttributes.MediaType.C;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This class creates the introductory GUI for data collection for the generator
 *
 * @author Kirsten Baker
 */
public class WordSearchGenerator {

    public WordSearchGenerator() {
        JFrame generator = new JFrame("Word Search Generator");
        ImageIcon img = new ImageIcon("raven.jpg");
        generator.setIconImage(img.getImage());
        
        //features
        JPanel features = new JPanel();
        JLabel advFeat = new JLabel("Advanced Features");
        JCheckBox diagonal = new JCheckBox("Diagonal");
        JCheckBox backwards = new JCheckBox("Backwards");
        features.add(advFeat);
        features.add(diagonal);
        features.add(backwards);

        JPanel gameInfo = new JPanel();

        //Read in from file
        JLabel fileWords = new JLabel("File Name");
        JTextField file = new JTextField(20);

        //Size wanted
        JLabel size = new JLabel("Size");
        JTextField prefSize = new JTextField(4);
        prefSize.setText("10");
        
        gameInfo.add(fileWords);
        gameInfo.add(file);
        gameInfo.add(size);
        gameInfo.add(prefSize);
        
        //create button
        JPanel button= new JPanel();
        JButton create = new JButton("Create");
        button.add(create);
            
        class create implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent event) {

                //get needed info
                String fileName = file.getText();
                String gridSize = prefSize.getText();
                boolean read;
                ReadFile rf = new ReadFile(fileName); 
                read= rf.open(fileName);
                if(read){
                    WordSearch game = new WordSearch(Integer.parseInt(gridSize), diagonal.isSelected(), backwards.isSelected());
                }
                else{ //create 'cannot open file' frame
                    JFrame fileErr= new JFrame("File Error");
                    fileErr.setIconImage(img.getImage());
                    JPanel err= new JPanel();
                    JLabel errMsg= new JLabel("There was a problem opening your file.  Please try again.");
                    err.add(errMsg);
                    fileErr.add(err);
                    fileErr.setSize(350, 75);
                    fileErr.setLocationRelativeTo(null);
                    fileErr.setResizable(false);
                    fileErr.setVisible(true);
                }
            }
        }
        
        ActionListener createGame = new create();
        create.addActionListener(createGame);
        
       
        
        generator.setSize(450, 140);
        generator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        generator.setLocationRelativeTo(null);
        generator.setResizable(false);
        generator.setVisible(true);
      
        generator.add(gameInfo, BorderLayout.NORTH);
        generator.add(features, BorderLayout.CENTER);
        generator.add(button, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        WordSearchGenerator generate = new WordSearchGenerator();
    }
}
