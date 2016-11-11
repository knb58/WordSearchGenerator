package wordsearchgenerator;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Kirsten Baker
 */
public class WordSearchGenerator {

    /**
     * @param args the command line arguments
     */
    public WordSearchGenerator(){
        JFrame generator = new JFrame();
        generator.setSize(900,900);
        generator.setTitle("Word Search Generator");
        generator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        generator.setLocationRelativeTo(null);
        generator.setResizable(false);
        generator.setVisible(true);
        
        JPanel features= new JPanel();
        
        JButton advFeat= new JButton("Advanced Features");
        
        //Read in from file
        JButton fileWords= new JButton("Words from file");
        
        //Write in words
        
        //Size wanted
        
        //Remake it if not liked
        JButton again= new JButton("Again!");
    
        class advFeatures implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent event){
                
                JFrame advFrame = new JFrame();
                final int FRAME_WIDTH = 700;
                final int FRAME_HEIGHT = 730;
                advFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
                advFrame.setTitle("Advanced Features");
                advFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                advFrame.setLocationRelativeTo(null);
                AdvancedFeatures af= new AdvancedFeatures();
                advFrame.add(af);
                advFrame.setResizable(false);
                advFrame.setVisible(true);
            }
        }
        
        ActionListener advFeatListener = new advFeatures();
        advFeat.addActionListener(advFeatListener);
        features.add(advFeat);
        features.add(fileWords);
        features.add(again);
        
        generator.add(features, BorderLayout.NORTH);
    }
    
    public static void main(String[] args) {
        //WordSearchGenerator generate= new WordSearchGenerator();
        WordSearch generator= new WordSearch();
    }
    
    
    
}
