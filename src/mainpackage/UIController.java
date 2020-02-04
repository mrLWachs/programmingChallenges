
/** required package class namespace */
package mainpackage;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

 
/**
 * UIController.java - description
 *
 * @author Mr. Wachs
 * @since Feb. 3, 2020, 8:40:15 a.m.
 */
public class UIController 
{

    private UIView        uiView;
    private JLabel        titleLabel;
    private JLabel        yearLabel;
    private JLabel        weekLabel;
    private JLabel        levelLabel;
    private JList<String> yearList;
    private JList<String> weekList;
    private JList<String> levelList;
    private JScrollPane   yearScrollPane;
    private JScrollPane   weekScrollPane;
    private JScrollPane   levelScrollPane;
    private JButton       runProblemButton;
    private JButton       runAllProblemsButton;
    
    private DefaultListModel yearListModel;
    private DefaultListModel weekListModel;
    private DefaultListModel levelListModel;
    
    private JComponent[] controls;
    
    private final int MAX_CONTROLS = 12;
    
    
    /**
     * Default constructor, set class properties
     */
    public UIController(UIView uiView, 
                        JLabel titleLabel, 
                        JLabel yearLabel, 
                        JLabel weekLabel, 
                        JLabel levelLabel, 
                        JList<String> yearList, 
                        JList<String> weekList, 
                        JList<String> levelList, 
                        JScrollPane yearScrollPane, 
                        JScrollPane weekScrollPane, 
                        JScrollPane levelScrollPane, 
                        JButton runProblemButton, 
                        JButton runAllProblemsButton) {
        this.uiView               = uiView;
        this.titleLabel           = titleLabel;
        this.yearLabel            = yearLabel;
        this.weekLabel            = weekLabel;
        this.levelLabel           = levelLabel;
        this.yearList             = yearList;
        this.weekList             = weekList;
        this.levelList            = levelList;
        this.yearScrollPane       = yearScrollPane;
        this.weekScrollPane       = weekScrollPane;
        this.levelScrollPane      = levelScrollPane;
        this.runProblemButton     = runProblemButton;
        this.runAllProblemsButton = runAllProblemsButton;                
        // put all components (controls) in an array
        controls     = new JComponent[MAX_CONTROLS];
        controls[0]  = titleLabel;
        controls[1]  = yearLabel;
        controls[2]  = weekLabel;
        controls[3]  = levelLabel;
        controls[4]  = yearList;
        controls[5]  = weekList;
        controls[6]  = levelList;
        controls[7]  = runProblemButton;
        controls[8]  = runAllProblemsButton;
        controls[9]  = yearScrollPane;
        controls[10] = weekScrollPane;
        controls[11] = levelScrollPane;
        // loop through array
        for (JComponent control : controls) {
            control.setFont(UIModel.CONTROL_FONT);
            control.setBackground(UIModel.CONTROL_BACKGROUND);
            control.setForeground(UIModel.DEFAULT_FOREGROUND_COLOR);
        }
        
        // instantiate all list models
        yearListModel  = new DefaultListModel();
        weekListModel = new DefaultListModel();
        levelListModel = new DefaultListModel();
        // set list models to the UI list box controls
        yearList.setModel(  yearListModel  );
        weekList.setModel(  weekListModel );
        levelList.setModel( levelListModel );
        
        // look through lists and add options
        fillList(yearList,yearListModel,UIModel.YEARS);
        fillList(weekList,weekListModel,UIModel.WEEKS);
        fillList(levelList,levelListModel,UIModel.LEVELS);
        
        // set the properties of the user interface view
        uiView.setBackground(UIModel.CONTROL_BACKGROUND);
        uiView.getContentPane().setBackground(UIModel.CONTROL_BACKGROUND);
        uiView.setTitle(UIModel.TITLE);
        uiView.setSize(UIModel.APP_WIDTH, UIModel.APP_HEIGHT);
        uiView.setResizable(false);
        uiView.setLocationRelativeTo(null);
        uiView.setVisible(true);
    }

    public void runSelectedProblem() {
        int year = yearList.getSelectedIndex();
        if (year == -1) JOptionPane.showMessageDialog(uiView, 
                UIModel.PROMPT_1,UIModel.TITLE,JOptionPane.ERROR_MESSAGE);        
        int week = weekList.getSelectedIndex();
        if (week == -1) JOptionPane.showMessageDialog(uiView, 
                UIModel.PROMPT_2,UIModel.TITLE,JOptionPane.ERROR_MESSAGE);        
        int level = levelList.getSelectedIndex();
        if (level == -1) JOptionPane.showMessageDialog(uiView, 
                UIModel.PROMPT_3,UIModel.TITLE,JOptionPane.ERROR_MESSAGE);
        level++;
        week++;
        if (UIModel.choose(week, level)) UIModel.input(week, level);
        else                             UIModel.run(week, level);
    }

    public void runAllProblems() {
        
    }

    public void windowClosing() {
        System.exit(0);
    }

    private void fillList(JList<String> list, DefaultListModel model, 
            String[] array) {
        for (int i = 0; i < array.length; i++) {
            model.addElement(array[i]);
        }
        list.ensureIndexIsVisible(model.getSize() - 1);
        list.setSelectedIndex(model.getSize() - 1);
    }

}


//do {            
//    int week  = get(Globals.PROMPT_2,Globals.WEEKS);
//    if (week == Globals.WEEKS.length - 1) Globals.runAll();
//    else {
//        int level = get(Globals.PROMPT_3,Globals.LEVELS);             
//        if (Globals.choose(week, level)) Globals.input(week, level);
//        else                             Globals.run(week, level);
//    }
//} while (true);