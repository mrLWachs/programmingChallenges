
package mainpackage;

import javax.swing.JOptionPane;

public class MainClass 
{

    public static void main(String[] args) {
        do {            
            int week  = get(Globals.PROMPT_1,Globals.WEEKS);
            int level = get(Globals.PROMPT_2,Globals.LEVELS);         
            if (Globals.choose(week, level)) Globals.input(week, level);
            else                             Globals.run(week, level);
        } while (true);
    }
        
    private static int get(String prompt, String[] choices) {
        String choice = JOptionPane.showInputDialog(null, prompt, 
                Globals.TITLE, JOptionPane.QUESTION_MESSAGE, null, 
                choices, choices[0]).toString();
        if (choice == null)            System.exit(0);
        if (choice.equals(choices[0])) System.exit(0);
        int value = 0;
        for (int i = 0; i < choices.length; i++) {
            if (choice.equals(choices[i])) value = i;
        }  
        return value;
    }

}
