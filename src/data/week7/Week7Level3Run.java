
package data.week7;

import io.System;
import mainpackage.AutoRun;


public class Week7Level3Run  extends AutoRun
{

    public void auto(int week, int level) {
        start(week, level);
        System.autoFlush();
    }
    
    public void run(int week, int level) {
        start(week, level);
        System.flush();
    }

    private void start(int week, int level) {  
        System.out.header("Week " + week + ", Level " + level + ": starting");         
        String[] lines = { 
           "joy",
           "ham"
        };
        System.out.println("Inputs:\n");
        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
        }
        System.out.println("\nOutputs:\n");            
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            String word = convert(line);        
            System.out.println(word); 
        }
        System.out.header("Week " + week + ", Level " + level + ": complete");
    }

    final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    
    private String convert(String word) {
        String newWord = "";
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (isVowel(letter)) newWord += letter;
            else newWord += rovarspraket(letter);            
        }
        return newWord;
    }

    public boolean isVowel(char letter) {
        final String VOWELS = "aeiou";
        for (int i = 0; i < VOWELS.length(); i++) {
            if (letter == VOWELS.charAt(i)) return true;
        }
        return false;
    }
    
    private String rovarspraket(char letter) {
        String three = "" + letter;
        int index = ALPHABET.indexOf(letter);
        int forwardVowelMoves  = getMovesToVowel(true,index);
        int backwardVowelMoves = getMovesToVowel(false,index);
        if (forwardVowelMoves == backwardVowelMoves) 
            three += ALPHABET.charAt(index + forwardVowelMoves);
        else if (forwardVowelMoves < backwardVowelMoves) 
            three += ALPHABET.charAt(index + forwardVowelMoves);
        else if (forwardVowelMoves > backwardVowelMoves) 
            three += ALPHABET.charAt(index - backwardVowelMoves);
        three += forwardConsonant(index);
        return three;
    }

    private int getMovesToVowel(boolean isForward, int index) {
        int moves = 0;
        while(!isVowel(ALPHABET.charAt(index))) {
            if (isForward) {
                index++;
                if (index >= ALPHABET.length()) return 27;
            }
            else {
                index--;
                if (index < 0) return 27;
            }
            moves++;
        }
        return moves;
    }
    
    private String forwardConsonant(int index) {
        int end = ALPHABET.length() - 1;        
        if (index == end) {
            return ALPHABET.charAt(end) + "";
        } 
        else {
            char letter = ALPHABET.charAt(index);
            do {
                index++;
                letter = ALPHABET.charAt(index);
            } while (isVowel(letter));
            return letter + "";
        }
    }
    
}
