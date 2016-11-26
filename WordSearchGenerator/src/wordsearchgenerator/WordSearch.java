package wordsearchgenerator;

import java.util.Arrays;
import java.util.Random;
import java.util.Vector;
import javax.swing.JComponent;

/**
 *
 * @author Kirsten Baker
 */
public class WordSearch extends JComponent {

    private char[][] puzzle;
    private int GRIDSIZE = 10;
    boolean diag=false, backwards= false;
    Vector wordList, wordsUsed;

    public WordSearch(int size, boolean diagonal, boolean back){

        diag= diagonal;
        backwards= back;
        wordList= ReadFile.wordList;
        GRIDSIZE=size;
        
        wordList.addElement("HELLOITSME");
        wordList.addElement("AMERICA");
        wordList.addElement("SUPERCALIFRAG");
        wordList.addElement(" ");

//        //choose graph size
//        int wordL = 0;
//        for (int i = 0; i < wordList.size(); i++) {
//            int wl = wordList.elementAt(i).toString().length();
//            if (wl > wordL) {
//                wordL = wl;
//            }
//        }

//        // WILL MOST LIKELY GET CHANGED!!! KEEP @ 10 UNLESS < WORD LENGTH || #WORDS 
//        // USER WILL BE ABLE TO PICK THE SIZE OF THE ARRAY!!!! 
//        //50 words max?
//        if (wordList.size() > GRIDSIZE || wordL > GRIDSIZE) {
//            if (wordList.size() > GRIDSIZE) {
//                GRIDSIZE = wordList.size() + 1;
//            }
//            if (wordL > GRIDSIZE) {
//                GRIDSIZE = wordL + 1;
//            }
//        }
        
        puzzle = new char[GRIDSIZE][GRIDSIZE];
        //initialize words
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle.length; j++) {
                puzzle[i][j] = ' ';
            }
        }

        //put largest words in first so more are guaranteed to fit
        while (wordList.size() > 0) {
            getLargest();
        }
        fillIn(); //fill in the rest of the graph with random letters
    }
    
    private void getLargest(){
        int largest = 0, wordIndex = 0;
            String wlargest = "";
            for (int j = 0; j < wordList.size(); j++) {
                String w = wordList.elementAt(j).toString();
                int wl = w.length();
                if (wl > largest) {
                    largest = wl;
                    wordIndex = j;
                    wlargest = w;
                }
            }
            insertWord(wlargest, backwards, diag);
            wordList.remove(wordIndex);
    }

    //put the word into the array
    private void insertWord(String word, boolean backwards, boolean diagonal) {

        word = word.toLowerCase();

        //saves the original puzzle so it's not destroyed
        char[][] origPuzzle = new char[puzzle.length][puzzle.length];
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle.length; j++) {
                origPuzzle[i][j] = puzzle[i][j];
            }
        }
       
        if(word.length() <= puzzle.length){
            //try 100 times to put the word into the game
            for (int tries = 0; tries < 100; tries++) {
                int back = 0, direc;

                //get the direction and figure out if backwards
                if (diagonal) {
                    direc = rand(3);
                } else {
                    direc = rand(2);
                }
                //decide if backwards
                if (backwards) {
                    back = rand(2);
                }
                //reverses string
                if (back == 1) {
                    word = new StringBuilder(word).reverse().toString();
                }

                int row, col;
                //how far down and out can it be?
                if(word.length() == puzzle.length){
                    row=0;
                }
                else{
                    row = rand(puzzle.length - word.length());
                }
                col = row;

                int i;
                for (i = 0; i < word.length(); i++) {
                    if (puzzle[row][col] == ' ' || puzzle[row][col] == word.charAt(i)) {
                        puzzle[row][col] = word.charAt(i);

                        if (direc == 0) {
                            col++;
                        }
                        if (direc == 1) {
                            row++;
                        }
                        if (direc == 2) {
                            col++;
                            row++;
                        }

                    } else {
                        for (int j = i; j > 0; j--) {
                            if (direc == 0) {
                                col--;
                            }
                            if (direc == 1) {
                                row--;
                            }
                            if (direc == 2) {
                                col--;
                                row--;
                            }

                            puzzle[row][col] = origPuzzle[row][col];
                        }
                        break;
                    }
                }
                //if word was input correctly, stop trying
                if (--i > 0) {
                    wordsUsed.add(word);
                    break;
                }
            }
        }
    }

    private int rand(int x) {
        Random random = new Random();
        int r = random.nextInt(x);
        return r;
    }

    private void fillIn() {

        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle.length; j++) {
                if (puzzle[i][j] == ' ') {
                    //fill with letters or numbers
                    puzzle[i][j] = (char) ('a' + rand(26)); //fills in with random letters
                }
                System.out.print((puzzle[i][j]) + " ");
            }
            System.out.println("");
        }

    }

}
