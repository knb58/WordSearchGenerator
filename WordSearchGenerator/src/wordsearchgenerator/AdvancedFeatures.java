package wordsearchgenerator;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Kirsten Baker
 */
public class AdvancedFeatures extends JFrame {
    
    public AdvancedFeatures(){
        
        JPanel features= new JPanel();
        
        JLabel border= new JLabel("Border options");
        final JCheckBox fullBorder = new JCheckBox ("Border");
        final JCheckBox bubbleLetter = new JCheckBox ("Bubble around letters");
        
        JLabel numbers= new JLabel("Numbers");
        JRadioButton letters= new JRadioButton("Letters");
        JRadioButton number= new JRadioButton("Numbers");
        
        JLabel direction= new JLabel("Word Direction");
        final JCheckBox backwards = new JCheckBox ("Backwards");
        final JCheckBox diagonal = new JCheckBox ("Diagonal");
        
        features.add(border);
        features.add(fullBorder);
        features.add(bubbleLetter);
        features.add(direction);
        features.add(backwards);
        features.add(diagonal);
            
    }
}
