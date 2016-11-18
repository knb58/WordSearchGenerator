package wordsearchgenerator;


import java.util.Arrays;
import java.util.Random;
import java.util.Vector;


/**
 *
 * @author Kirsten Baker
 */

public class WordSearch {
    
    private char[][] words;
    private int GRIDSIZE=10;
    
    public WordSearch(){
              
        Vector wordList= new Vector();
        //if file 
        {
//            String fileName= "", line;
//            FileReader fileReader; BufferedReader bufferedReader;
//
//            try {
//                fileReader = new FileReader(fileName);
//                bufferedReader = new BufferedReader(fileReader);
//
//                while((line = bufferedReader.readLine()) != null) {
//                    insertWord(line); 
//                    wordList.add(line);
//                }  
//
//                bufferedReader.close();         
//            }
//            catch(FileNotFoundException ex) {System.out.println( "Unable to open file '" +fileName + "'");}
//            catch(IOException ex) {System.out.println("Error reading file '"+ fileName + "'");}
        }
        wordList.addElement("hello");
        wordList.addElement("sup");
        wordList.addElement("supercalifrag");
        
        //choose graph size
        int wordL=0;
        for (int i=0; i<wordList.size(); i++){
            int wl= wordList.elementAt(i).toString().length();
            if(wl>wordL){
                wordL=wl;
            }
        }
        
        // WILL MOST LIKELY GET CHANGED!!! KEEP @ 10 UNLESS < WORD LENGTH || #WORDS 
        // USER WILL BE ABLE TO PICK THE SIZE OF THE ARRAY!!!! 
        //50 words max?
        if(wordList.size() > GRIDSIZE || wordL > GRIDSIZE){
            if(wordList.size() > GRIDSIZE) 
                GRIDSIZE= wordList.size()+1; 
            if(wordL > GRIDSIZE) 
                GRIDSIZE= wordL+1; 
        }
        words= new char[GRIDSIZE][GRIDSIZE]; 
        
        //initialize words
        for (int i=0; i<words.length; i++){
           for(int j=0; j<words[0].length; j++){
               words[i][j]= ' ';
           }
        }
        
        //put largest words in first
        while(wordList.size()>0){
            int largest=0, wordIndex=0;
            String wlargest="";
            for (int j=0; j<wordList.size(); j++){
                String w= wordList.elementAt(j).toString();
                int wl= w.length();
                if(wl>largest){
                    largest=wl;
                    wordIndex=j;
                    wlargest=w;
                }
            }
            insertWord(wlargest, largest, false, false);
            wordList.remove(wordIndex);
        }
        
        
        fillIn(); //fill in the rest of the graph with random letters
    }
   
    
    //put the word into the array
    private void insertWord(String line, int length, boolean backwards, boolean diagonal ){
        
        int direction=2; 
        if(backwards || diagonal) {
            direction=4; 
            if (backwards && diagonal){
                direction=8;
            }
        }
        int direc=rand(direction);
      
        /*  
        Direction numbers
        
                6
            5   ^   7
              \   /
         4  <   x   >  0
              /   \  
            3   v   1
                2
        */
        
        int stringL=line.length();
        
        //initially puts words in at the beginning of a line that contains all ' '
        int emptyCount=0; //count how many empty characters are in the line
        
        for(int i=0; i<words.length; i++){
            if(words[i][0]== ' '){
                for (int j=0; j<words[0].length; j++){
                    if(line.length()>j)
                        words[i][j]=line.charAt(j);
                }
                break;
            }
        stringL--;
        }
        
        
        if(fits(line, length, direc)){
            
        }
       
    }
    
    //makes sure the word fits into the array
    private boolean fits(String line, int length, int direction){
        boolean fit=true;
        
        //based on direction, see if enough room for the word, even if it intersects another
        
        return fit;
    }
    
    private int rand(int x) {
        Random random = new Random();
        int r = random.nextInt(x);
        return r;
    }
    
    private void fillIn(){
       
        for (int i=0; i<words.length; i++){
            for(int j=0; j<words[0].length; j++){
                if (words[i][j]== ' '){
                    //fill with letters or numbers
                    words[i][j]=(char) ('a'+ rand(26)); //fills in with random letters
                }
              System.out.print((words[i][j])+ " ");  
            }
            System.out.println("");
        }
        
    }
    
}
