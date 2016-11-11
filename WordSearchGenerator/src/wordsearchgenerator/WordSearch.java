package wordsearchgenerator;

import java.io.*;
import java.util.Arrays;
import java.util.Random;


/**
 *
 * @author Kirsten Baker
 */

public class WordSearch {
    
    private char[][] words;
    
    public WordSearch(){
              
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
//                }  
//
//                bufferedReader.close();         
//            }
//            catch(FileNotFoundException ex) {System.out.println( "Unable to open file '" +fileName + "'");}
//            catch(IOException ex) {System.out.println("Error reading file '"+ fileName + "'");}
        }
        words= new char[3][4];
        for (int i=0; i<words.length; i++){
            for(int j=0; j<words[0].length; j++){
                words[i][j]=' ';
            }
        }
        
        fillIn();
    }
    
    //put the word into the array
    private void insertWord(String line){
       
        int direc=rand(2); //0=straight/ 1=diagonal
        int diaDirec= rand(2); //0=forwards/ 1=backwards\
        int back= rand(2); //0=no/ 1=yes
       
        if(fits(line)){
            
        }
        
        
        
        System.out.println(Arrays.toString(words));
    }
    
    //makes sure the word fits into the array
    private boolean fits(String line){
        boolean fit=true;
        
        return fit;
    }
    
    private int rand(int x) {
        Random random = new Random();
        int r = random.nextInt(x);
        return r;
    }
    
    public void fillIn(){
       
        for (int i=0; i<words.length; i++){
            for(int j=0; j<words[0].length; j++){
                if (words[i][j]== ' '){
                    //fill with letters or numbers
                    words[i][j]='a';
                }
              System.out.print((words[i][j])+ " ");  
            }
            System.out.println("");
        }
        
    }
    
}
