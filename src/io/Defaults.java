
/** required package class namespace */
package io;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

 
/**
 * Colors.java - the color codes for standard outputs
 *
 * @author Mr. Wachs
 * @since Dec. 16, 2019, 2:32:24 p.m.
 */
public class Defaults 
{
    
    private final static int DIALOG_FONT_SIZE = 18;
    private final static int DIALOG_COLOR_RGB = 238;
    private final static int DIALOG_WIDTH     = 1000;
    private final static int DIALOG_HEIGHT    = 800;
    
    
    public final static int LINE_LENGTH = 50;
                
    public final static String[] FONTS = {
        "Courier New",
        "Consolas",
        "Trebuchet MS",
        "Tahoma",
        "Bookman Old Style",
    };
    
    public final static Font   DIALOG_FONT = new Font(FONTS[0],
            Font.PLAIN,DIALOG_FONT_SIZE);
    public final static Color  DIALOG_BACKGROUND = new Color(DIALOG_COLOR_RGB,
            DIALOG_COLOR_RGB,DIALOG_COLOR_RGB);
    public final static Dimension DIALOG_DIMENSION = new Dimension(
            DIALOG_WIDTH, DIALOG_HEIGHT);
    
    public final static String NEW_LINE = "\n";
    public final static String COMMENT  = "\\ ";
    public final static String NULL     = "null";
    public final static String LINE     = ".";
        
    public static final String RESET                    = "\033[0m";  
    public static final String BLACK                    = "\033[0;30m";   
    public static final String RED                      = "\033[0;31m";   
    public static final String GREEN                    = "\033[0;32m";  
    public static final String YELLOW                   = "\033[0;33m";  
    public static final String BLUE                     = "\033[0;34m";   
    public static final String PURPLE                   = "\033[0;35m";  
    public static final String CYAN                     = "\033[0;36m";  
    public static final String WHITE                    = "\033[0;37m";  
    public static final String BLACK_BOLD               = "\033[1;30m";  
    public static final String RED_BOLD                 = "\033[1;31m";   
    public static final String GREEN_BOLD               = "\033[1;32m"; 
    public static final String YELLOW_BOLD              = "\033[1;33m"; 
    public static final String BLUE_BOLD                = "\033[1;34m";  
    public static final String PURPLE_BOLD              = "\033[1;35m"; 
    public static final String CYAN_BOLD                = "\033[1;36m";  
    public static final String WHITE_BOLD               = "\033[1;37m"; 
    public static final String BLACK_UNDERLINED         = "\033[4;30m"; 
    public static final String RED_UNDERLINED           = "\033[4;31m";  
    public static final String GREEN_UNDERLINED         = "\033[4;32m"; 
    public static final String YELLOW_UNDERLINED        = "\033[4;33m"; 
    public static final String BLUE_UNDERLINED          = "\033[4;34m";  
    public static final String PURPLE_UNDERLINED        = "\033[4;35m";
    public static final String CYAN_UNDERLINED          = "\033[4;36m";  
    public static final String WHITE_UNDERLINED         = "\033[4;37m"; 
    public static final String BLACK_BACKGROUND         = "\033[40m";  
    public static final String RED_BACKGROUND           = "\033[41m";  
    public static final String GREEN_BACKGROUND         = "\033[42m"; 
    public static final String YELLOW_BACKGROUND        = "\033[43m"; 
    public static final String BLUE_BACKGROUND          = "\033[44m";   
    public static final String PURPLE_BACKGROUND        = "\033[45m"; 
    public static final String CYAN_BACKGROUND          = "\033[46m";   
    public static final String WHITE_BACKGROUND         = "\033[47m";  
    public static final String BLACK_BRIGHT             = "\033[0;90m";  
    public static final String RED_BRIGHT               = "\033[0;91m"; 
    public static final String GREEN_BRIGHT             = "\033[0;92m";  
    public static final String YELLOW_BRIGHT            = "\033[0;93m"; 
    public static final String BLUE_BRIGHT              = "\033[0;94m";  
    public static final String PURPLE_BRIGHT            = "\033[0;95m"; 
    public static final String CYAN_BRIGHT              = "\033[0;96m";  
    public static final String WHITE_BRIGHT             = "\033[0;97m";  
    public static final String BLACK_BOLD_BRIGHT        = "\033[1;90m"; 
    public static final String RED_BOLD_BRIGHT          = "\033[1;91m";  
    public static final String GREEN_BOLD_BRIGHT        = "\033[1;92m"; 
    public static final String YELLOW_BOLD_BRIGHT       = "\033[1;93m";
    public static final String BLUE_BOLD_BRIGHT         = "\033[1;94m"; 
    public static final String PURPLE_BOLD_BRIGHT       = "\033[1;95m";
    public static final String CYAN_BOLD_BRIGHT         = "\033[1;96m";  
    public static final String WHITE_BOLD_BRIGHT        = "\033[1;97m"; 
    public static final String BLACK_BACKGROUND_BRIGHT  = "\033[0;100m";
    public static final String RED_BACKGROUND_BRIGHT    = "\033[0;101m";
    public static final String GREEN_BACKGROUND_BRIGHT  = "\033[0;102m";
    public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";
    public static final String BLUE_BACKGROUND_BRIGHT   = "\033[0;104m";
    public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; 
    public static final String CYAN_BACKGROUND_BRIGHT   = "\033[0;106m";  
    public static final String WHITE_BACKGROUND_BRIGHT  = "\033[0;107m";  
    
    private static final String[] COLORS = {
        RESET,BLACK,RED,GREEN,YELLOW,BLUE,PURPLE,CYAN,WHITE,BLACK_BOLD,
        RED_BOLD,GREEN_BOLD,YELLOW_BOLD,BLUE_BOLD,PURPLE_BOLD,CYAN_BOLD,
        WHITE_BOLD,BLACK_UNDERLINED,RED_UNDERLINED,GREEN_UNDERLINED,
        YELLOW_UNDERLINED,BLUE_UNDERLINED,PURPLE_UNDERLINED,CYAN_UNDERLINED,
        WHITE_UNDERLINED,BLACK_BACKGROUND,RED_BACKGROUND,GREEN_BACKGROUND,
        YELLOW_BACKGROUND,BLUE_BACKGROUND,PURPLE_BACKGROUND,CYAN_BACKGROUND,
        WHITE_BACKGROUND,BLACK_BRIGHT,RED_BRIGHT,GREEN_BRIGHT,YELLOW_BRIGHT,
        BLUE_BRIGHT,PURPLE_BRIGHT,CYAN_BRIGHT,WHITE_BRIGHT,BLACK_BOLD_BRIGHT,
        RED_BOLD_BRIGHT,GREEN_BOLD_BRIGHT,YELLOW_BOLD_BRIGHT,BLUE_BOLD_BRIGHT,
        PURPLE_BOLD_BRIGHT,CYAN_BOLD_BRIGHT,WHITE_BOLD_BRIGHT,
        BLACK_BACKGROUND_BRIGHT,RED_BACKGROUND_BRIGHT,GREEN_BACKGROUND_BRIGHT,
        YELLOW_BACKGROUND_BRIGHT,BLUE_BACKGROUND_BRIGHT,
        PURPLE_BACKGROUND_BRIGHT,CYAN_BACKGROUND_BRIGHT,WHITE_BACKGROUND_BRIGHT
    };

}
