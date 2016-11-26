package wordsearchgenerator;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Kirsten Baker
 */
public class WordSearchGenerator {
    
    public WordSearchGenerator(){
        JFrame generator = new JFrame();
        
        
        JPanel features= new JPanel();
        
        JLabel advFeat= new JLabel("Advanced Features");
        JCheckBox diagonal= new JCheckBox("Diagonal");
        JCheckBox backwards= new JCheckBox("Backwards");
        
        features.add(advFeat);
        features.add(diagonal);
        features.add(backwards);
        
        
        JPanel gameInfo= new JPanel();
        
        //Read in from file
        JLabel fileWords= new JLabel("File Name");
        JTextField file= new JTextField(20);
        
        //Write in words
        
        //Size wanted
        JLabel size= new JLabel("Size");
        JTextField prefSize= new JTextField(4);
        prefSize.setText("10");
        
        JButton create= new JButton("Create");
        gameInfo.add(fileWords);
        gameInfo.add(file); 
        gameInfo.add(size);
        gameInfo.add(prefSize);
        gameInfo.add(create);
    
//        class advFeatures implements ActionListener {
//
//            @Override
//            public void actionPerformed(ActionEvent event){
//                
//                JFrame advFrame = new JFrame();
//                final int FRAME_WIDTH = 700;
//                final int FRAME_HEIGHT = 730;
//                advFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
//                advFrame.setTitle("Advanced Features");
//                advFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                advFrame.setLocationRelativeTo(null);
//                AdvancedFeatures af= new AdvancedFeatures();
//                advFrame.add(af);
//                advFrame.setResizable(false);
//                advFrame.setVisible(true);
//            }
//        }
        
        class create implements ActionListener {
            
            @Override
            public void actionPerformed(ActionEvent event){
                
                String fileName= file.getText();
                String gridSize= prefSize.getText();
                ReadFile rf= new ReadFile(fileName);
                WordSearch game= new WordSearch(Integer.parseInt(gridSize), diagonal.isSelected(), backwards.isSelected());
                generator.add(game, BorderLayout.CENTER);
            }
        }
        
        //add listener to the advanced features
        
//        //add listener to file read
//        ActionListener readFile= new fileRead();
//        fileWords.addActionListener(readFile);

        ActionListener createGame= new create();
        create.addActionListener(createGame);
                
        generator.add(gameInfo, BorderLayout.NORTH);
        generator.add(features, BorderLayout.SOUTH);
       
       
        generator.setSize(900,900);
        generator.setTitle("Word Search Generator");
        generator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        generator.setLocationRelativeTo(null);
        generator.setResizable(false);
        generator.setVisible(true);
    }
    
    public static void main(String[] args) {
        WordSearchGenerator generate= new WordSearchGenerator();
        //ReadFile rf= new ReadFile("C:\\Users\\User\\Desktop\\WordSearchGenerator\\test1.txt");
        //WordSearch game = new WordSearch();
    }
    
}
