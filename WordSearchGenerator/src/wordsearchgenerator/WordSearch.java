package wordsearchgenerator;

import java.util.Random;
import java.util.Vector;

/**
 * This class creates the word search
 * 
 * @author Kirsten Baker
 * 
 */
public class WordSearch {

    static char[][] puzzle;
    private int GRIDSIZE = 10;
    boolean diag = false, backwards = false, numbers=false;
    static Vector wordList, wordsUsed = new Vector();

    public WordSearch(int size, boolean diagonal, boolean back, boolean num) {

        diag = diagonal;
        backwards = back;
        numbers=num;
        wordList = ReadFile.wordList;
        GRIDSIZE = size;
        puzzle = new char[GRIDSIZE][GRIDSIZE];

        //initialize words
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle.length; j++) {
                puzzle[i][j] = ' ';
            }
        }

        while (wordList.size() > 0) { makeGame(); }
        fillIn();
        //print out the final game
        PrintGame print= new PrintGame(puzzle, wordsUsed, GRIDSIZE);
    }

    //creates the game using the largest words first so more can fit
    private void makeGame() {
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

        boolean input = false;
        word = word.toLowerCase();
        wordsUsed.addElement(word);

        //saves the original puzzle so it's not destroyed
        char[][] origPuzzle = new char[puzzle.length][puzzle.length];
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle.length; j++) {
                origPuzzle[i][j] = puzzle[i][j];
            }
        }

        if (word.length() <= puzzle.length) {
            //try 500 times to put the word into the game
            for (int tries = 0; tries < 500; tries++) {
                int back = 0, direc;

                //get the direction and figure out if backwards
                if (diagonal) { direc = rand(3); }
                else { direc = rand(2); }
                //decide if backwards
                if (backwards) { back = rand(2); }
                //reverses string
                if (back == 1) { word = new StringBuilder(word).reverse().toString(); }
                
                //how far down and out can it be?
                int row, col;
                if (word.length() == puzzle.length) { row = col = 0;} 
                else {
                    row = col = rand(puzzle.length - word.length());
                    if (direc == 0){ row = rand(puzzle.length); }
                }

                //try to input word into the grid
                int i;
                for (i = 0; i < word.length(); i++) {
                    if (puzzle[row][col] == ' ' || puzzle[row][col] == word.charAt(i)) {
                        puzzle[row][col] = word.charAt(i);

                        if (direc == 0) { col++; }
                        if (direc == 1) { row++; }
                        if (direc == 2) { col++; row++; }

                    } else {
                        for (int j = i; j > 0; j--) {
                            if (direc == 0) { col--; }
                            if (direc == 1) { row--; }
                            if (direc == 2) { col--; row--; }
                            
                            puzzle[row][col] = origPuzzle[row][col];
                        }
                        //not input correctly so reset i and break to try again
                        i=0;
                        break;
                    }
                }
                //if word was input correctly, stop trying
                if (i > 0) { input = true; break; }
            }
        }
        //if word cannot fit, take it out of used words vector
        if (!input && wordsUsed.size() > 0) { wordsUsed.remove(wordsUsed.size() - 1); }
    }

    private int rand(int x) {
        Random random = new Random();
        int r = random.nextInt(x);
        return r;
    }
    
    //fill in rest of puzzle
    private void fillIn() {
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle.length; j++) {
                if (puzzle[i][j] == ' ') {
                    if (numbers){ puzzle[i][j] = (char)(rand(9)+48); }
                    else{ puzzle[i][j] = (char)('a' + rand(26)); }
                }
            }
        }
    }
}
