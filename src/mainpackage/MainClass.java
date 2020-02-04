
package mainpackage;

import javax.swing.JOptionPane;

public class MainClass 
{

    public static void main(String[] args) {
        
        new UIView();
        
//        dialogs();
        
    }
        
    private static void dialogs() {
        do {            
            int week  = get(UIModel.PROMPT_2,UIModel.WEEKS);
            if (week == UIModel.WEEKS.length - 1) UIModel.runAll();
            else {
                int level = get(UIModel.PROMPT_3,UIModel.LEVELS);             
                if (UIModel.choose(week, level)) UIModel.input(week, level);
                else                             UIModel.run(week, level);
            }
        } while (true);
    }
    
    private static int get(String prompt, String[] choices) {
        String choice = JOptionPane.showInputDialog(null, prompt, 
                UIModel.TITLE, JOptionPane.QUESTION_MESSAGE, null, 
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
