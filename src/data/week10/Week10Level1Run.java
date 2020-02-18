
package data.week10;

import io.System;
import java.util.ArrayList;
import mainpackage.AutoRun;


public class Week10Level1Run  extends AutoRun
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
            "1",
            "3",
            "3",
            "2",
            "He",
            "The cat",
            "The dog",
            "bit",
            "kicked",
            "saw",
            "him",
            "the mouse"
        };
        System.out.println("Inputs:\n");
        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
        }
        System.out.println("\nOutputs:\n");  
        ArrayList<String> subjects = new ArrayList<>();
        ArrayList<String> verbs    = new ArrayList<>();
        ArrayList<String> objects  = new ArrayList<>();
        int currentLine = 0;
        int dataSets = Integer.parseInt(lines[0]);
        for (int dataSet = 0; dataSet < dataSets; dataSet++) {
            currentLine++;
            int totalSubjects = Integer.parseInt(lines[currentLine]);
            currentLine++;
            int totalVerbs    = Integer.parseInt(lines[currentLine]);
            currentLine++;
            int totalObjects  = Integer.parseInt(lines[currentLine]);            
            for (int currentSubject = 0; currentSubject < totalSubjects; currentSubject++) {
                currentLine++;
                subjects.add(lines[currentLine]);                
            }
            for (int currentVerb = 0; currentVerb < totalVerbs; currentVerb++) {
                currentLine++;
                verbs.add(lines[currentLine]);                
            }
            for (int currentObject = 0; currentObject < totalObjects; currentObject++) {
                currentLine++;
                objects.add(lines[currentLine]);                
            }
        }
        displayAll(subjects,verbs,objects);
        System.out.header("Week " + week + ", Level " + level + ": complete");
    }

    private void displayAll(
            ArrayList<String> subjects, 
            ArrayList<String> verbs, 
            ArrayList<String> objects) {
        for (int i = 0; i < subjects.size(); i++) {
            String subject = subjects.get(i);
            display(subject,verbs,objects);
        }
    }

    private void display(
            String subject, 
            ArrayList<String> verbs, 
            ArrayList<String> objects) {
        for (int i = 0; i < verbs.size(); i++) {
            String verb = verbs.get(i);
            display(subject,verb,objects);
        }
    }

    private void display(
            String subject,
            String verb, 
            ArrayList<String> objects) {        
        for (int i = 0; i < objects.size(); i++) {
            String object = objects.get(i);            
            System.out.print(subject + " ");
            System.out.print(verb + " ");
            System.out.println(object + ".");
        }        
    }
    
}
