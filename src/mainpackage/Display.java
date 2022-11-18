
/** required package class namespace */
package mainpackage;

import io.Defaults;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.net.URL;
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
        URL    url      = getClass().getResource(filename);
        Icon   icon     = null;
        if (url != null) icon = new ImageIcon(url);
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
    
    public void showTimedDialog(String text, int delay) {
        showTimedDialog(getScrollArea(text), "", null, delay);
    }
    
    public void showTimedDialog(Object message, String title, Icon icon, int delay) {
        JOptionPane jOptionDialog = new JOptionPane(message, 
                JOptionPane.PLAIN_MESSAGE,JOptionPane.DEFAULT_OPTION,icon);
        setBackgrounds(jOptionDialog);
        final JDialog dialog = jOptionDialog.createDialog(title);
        setBackgrounds(dialog);
        dialog.getContentPane().setBackground(Defaults.DIALOG_BACKGROUND);
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
    
    public void showDialog(String text, String title, int width, int height) { 
        JOptionPane.showMessageDialog(null, getScrollArea(text, width, height), 
                title, JOptionPane.PLAIN_MESSAGE);
    }
    
    private JScrollPane getScrollArea(String text) {
        JTextArea   area       = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(area);
        area.setFont(Defaults.DIALOG_FONT);
        area.setText(text);
        area.setBorder(null);
        area.setLineWrap(true);  
        area.setWrapStyleWord(true); 
        setBackgrounds(area);
        setBackgrounds(scrollPane);
        scrollPane.setPreferredSize(Defaults.DIALOG_DIMENSION);
        scrollPane.setBorder(null);
        return scrollPane;
    }
    
    private JScrollPane getScrollArea(String text, int width, int height) {
        JTextArea   area       = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(area);
        area.setFont(Defaults.DIALOG_FONT);
        area.setText(text);
        area.setBorder(null);
        area.setLineWrap(true);  
        area.setWrapStyleWord(true); 
        setBackgrounds(area);
        setBackgrounds(scrollPane);
        Dimension dimension = new Dimension(width, height);
        scrollPane.setPreferredSize(dimension);
        scrollPane.setBorder(null);
        return scrollPane;
    }
    
    private void setBackgrounds(Container container) {
        container.setBackground(Defaults.DIALOG_BACKGROUND);
        Component[] components = container.getComponents();
        for (int i = 0; i < components.length; i++) {
            components[i].setBackground(Defaults.DIALOG_BACKGROUND);
        }
    }
    
}
