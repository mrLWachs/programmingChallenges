
/** required package class namespace */
package mainpackage;

import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;

 
/**
 * UIModel.java - description
 *
 * @author Mr. Wachs
 * @since Feb. 3, 2020, 8:58:33 a.m.
 */
public class UIModel 
{

    public final static Font   CONTROL_FONT             = UIManager.getFont("defaultFont");
    public final static Color  CONTROL_BACKGROUND       = UIManager.getColor("Panel.background");
    public final static Color  DEFAULT_FOREGROUND_COLOR = UIManager.getColor("Panel.foreground");
    public final static String APP_TITLE                = "Mr. Wachs' Programming Challenges";
    public final static int    APP_WIDTH                = 427;
    public final static int    APP_HEIGHT               = 320;

    
}
