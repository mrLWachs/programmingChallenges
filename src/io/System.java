
/** required package class namespace */
package io;

/** required imports */
import java.awt.event.KeyEvent;
import java.io.InputStream;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import mainpackage.Display;


/**
 * System.java - this class simulates the java.lang class that does the 
 * standard outputs and redirects those outputs to a custom output style 
 * (either System.out, to a custom user interface, a permanent file, or all
 * of these)
 *
 * @author Mr. Wachs 
 * @since 8-Mar-2019 
 */
public class System 
{
    
    private static String     allOutput = "";
    public static InputStream in        = java.lang.System.in;
    
    
    /**
     * Internal class to properly simulate the java.lang.System.out class
     */
    public static class out 
    {
        
        /**
         * Simulates the 'Printing' of an object
         * 
         * @param object The Object type to be 'printed'
         */
        public static void println(Object object) {
            output(object,true);
        }
       
        /**
         * Simulates the 'Printing' of an object
         * 
         * @param object The Object type to be 'printed'
         */
        public static void println(boolean object) {
            println(new Boolean(object));
        }
        
        /**
         * Simulates the 'Printing' of an object
         * 
         * @param object The Object type to be 'printed'
         */
        public static void println(int object) {
            println(new Integer(object));
        }
        
        /**
         * Simulates the 'Printing' of an object
         * 
         * @param object The Object type to be 'printed'
         */
        public static void println(long object) {
            println(new Long(object));
        }
        
        /**
         * Simulates the 'Printing' of an object
         * 
         * @param object The Object type to be 'printed'
         */
        public static void println(float object) {
            println(new Float(object));
        }
        
        /**
         * Simulates the 'Printing' of an object
         * 
         * @param object The Object type to be 'printed'
         */
        public static void println(double object) {
            println(new Double(object));
        }
        
        /**
         * Simulates the 'Printing' of an object
         * 
         * @param object The Object type to be 'printed'
         */
        public static void print(Object object) {
            output(object,false);
        }
        
        /**
         * Simulates the 'Printing' of an object
         * 
         * @param object The Object type to be 'printed'
         */
        public static void print(boolean object) {
            print(new Boolean(object));
        }
        
        /**
         * Simulates the 'Printing' of an object
         * 
         * @param object The Object type to be 'printed'
         */
        public static void print(int object) {
            print(new Integer(object));
        }
        
        /**
         * Simulates the 'Printing' of an object
         * 
         * @param object The Object type to be 'printed'
         */
        public static void print(long object) {
            print(new Long(object));
        }
        
        /**
         * Simulates the 'Printing' of an object
         * 
         * @param object The Object type to be 'printed'
         */
        public static void print(float object) {
            print(new Float(object));
        }
        
        /**
         * Simulates the 'Printing' of an object
         * 
         * @param object The Object type to be 'printed'
         */
        public static void print(double object) {
            print(new Double(object));
        }
        
        /**
         * Simulates the 'Printing' of an object but uses a header style of 
         * formatting
         * 
         * @param object The Object type to be 'printed'
         */
        public static void header(Object object) {   
            if (object == null) return;
            String text = object.toString() + line(); 
            simpleOutput(Defaults.NEW_LINE);
            simpleColorOutput(text, "", Defaults.BLUE, Defaults.RESET);
            simpleOutput(Defaults.NEW_LINE);
            allOutput += Defaults.NEW_LINE + text + Defaults.NEW_LINE + 
                         Defaults.NEW_LINE;
        }
        
        /**
         * Simulates the 'Printing' of an object but uses a comment style of 
         * formatting
         * 
         * @param object The Object type to be 'printed'
         */
        public static void comment(Object object) {  
            if (object == null) object = new String(Defaults.NULL); 
            String text = Defaults.COMMENT + object.toString();
            simpleColorOutput(text, "", Defaults.YELLOW, Defaults.RESET);
        }
        
            
        /**
         * Adds this object to the dynamic list of outputs with or 
         * without a new line
         * 
         * @param object the object (as a string) to add to output
         * @param newLine adds a new line (true) or not (false)
         */
        private static void output(Object object, boolean newLine) {
            if (object == null) object = new String(Defaults.NULL);
            if (newLine) {
                allOutput += object.toString() + Defaults.NEW_LINE;
                simpleOutput(object.toString() + Defaults.NEW_LINE);
            }
            else {
                allOutput += object.toString();
                simpleOutput(object.toString());
            } 
        }
        
        /**
         * Does a simple output with the passed message combined with other
         * textual data
         * 
         * @param message the message to output
         * @param font the font to use
         * @param color the starting color
         * @param reset the color reset
         */
        private static void simpleColorOutput(String message, String font, 
                String color, String reset) {
            simpleOutput("");
            simpleOutput(color + message + reset);
            simpleOutput(font);
            simpleOutput(Defaults.NEW_LINE);
        }
        
        /**
         * Does a simple output with the passed message
         * 
         * @param message the message to output 
         */
        private static void simpleOutput(String message) {
            java.lang.System.out.print(message);
        }
        
        
        
        /**
         * Creates a line of 50 '.' dots to add to an output
         * 
         * @return a text line of 50 dots
         */
        private static String line() {
            String text = Defaults.LINE;
            for (int i = 0; i < Defaults.LINE_LENGTH; i++) {
                text += Defaults.LINE;
            }
            return text;
        }
        
    }    
    
    /**
     * Exits the application
     * 
     * @param event the keyboard event to check
     */
    public static void exit(KeyEvent event) {
        if (event == null || 
            event.getKeyCode() == KeyEvent.VK_ENTER ||
            event.getKeyCode() == KeyEvent.VK_ESCAPE) {
            java.lang.System.exit(0);
        }
    }
    
    /**
     * Adds all the output to a visual output
     */
    public static void flush() {  
        new Display().showDialog(allOutput);
        allOutput = "";
    }
    
    public static void autoFlush() {  
        new Display().showTimedDialog(allOutput,3000);
        allOutput = "";
    }
    
}
