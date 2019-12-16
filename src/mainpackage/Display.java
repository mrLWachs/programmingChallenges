
/** required package class namespace */
package mainpackage;

import io.Defaults;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

 
/**
 * Display.java - description
 *
 * @author Mr. Wachs
 * @since Nov. 7, 2019, 1:07:47 p.m.
 */
public class Display 
{
    
    public boolean choose(int week, int level) {
        String title    = "Week " + week + " - Level " + level + " Problem";
        String filename = "/media/Week" + week + "Level" + level + ".png";
        Icon   icon     = new ImageIcon(getClass().getResource(filename));
        String[] choices = {
          "Pre-set Test Values","Input Test Values"  
        };        
        if (JOptionPane.showOptionDialog(null, "", title, 
                JOptionPane.YES_NO_CANCEL_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, icon, 
                choices, choices[0]) == JOptionPane.YES_OPTION) return false;
        return true;
    }
    
    public void showProblem(int week, int level) {
        String title    = "Week " + week + " - Level " + level + " Problem";
        String filename = "/media/Week" + week + "Level" + level + ".png";
        Icon   icon     = new ImageIcon(getClass().getResource(filename));
        showTimedDialog("", title, icon, 3000);
    }
    
    public void showSolution(String text) {
        
    }
    
    public void showTimedDialog(String text, int delay) {
        showTimedDialog(getScrollArea(text), "", null, delay);
    }
    
    public void showTimedDialog(Object message, String title, Icon icon, int delay) {
        JOptionPane jOptionDialog = new JOptionPane(message, 
                JOptionPane.PLAIN_MESSAGE,JOptionPane.DEFAULT_OPTION,icon);
        final JDialog dialog = jOptionDialog.createDialog(title);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        Runnable run = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(delay);
                } 
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                dialog.dispose();
            }
        };
        Thread thread = new Thread(run);
        thread.start();
        dialog.setVisible(true);
    }
        
    /**
     * Adds all the output to a visual output
     */
    public void showDialog(String text) {  
        JOptionPane.showMessageDialog(null, getScrollArea(text), 
                "Outputs...", JOptionPane.PLAIN_MESSAGE);
    }
    
    private JScrollPane getScrollArea(String text) {
        JTextArea   area       = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(area);
        area.setFont(Defaults.DIALOG_FONT);
        area.setBackground(Defaults.DIALOG_BACKGROUND);
        area.setText(text);
        area.setBorder(null);
        area.setLineWrap(true);  
        area.setWrapStyleWord(true); 
        scrollPane.setPreferredSize(Defaults.DIALOG_DIMENSION);
        scrollPane.setBorder(null);
        return scrollPane;
    }
    
}
