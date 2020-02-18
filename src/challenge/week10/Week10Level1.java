
package challenge.week10;

import java.util.ArrayList;
import java.util.Scanner;
import mainpackage.Problem;


public class Week10Level1 extends Problem
{

    public static void main(String[] args) {
        new Week10Level1().start();
    }
    
    public void start() {        
        Scanner input = new Scanner(System.in);      
        ArrayList<String> subjects = new ArrayList<>();
        ArrayList<String> verbs    = new ArrayList<>();
        ArrayList<String> objects  = new ArrayList<>();        
        String line = input.nextLine();
        int dataSets = Integer.parseInt(line);
        for (int dataSet = 0; dataSet < dataSets; dataSet++) {
            line = input.nextLine();
            int totalSubjects = Integer.parseInt(line);
            line = input.nextLine();
            int totalVerbs    = Integer.parseInt(line);
            line = input.nextLine();
            int totalObjects  = Integer.parseInt(line); 
            for (int currentSubject = 0; currentSubject < totalSubjects; currentSubject++) {
                line = input.nextLine();
                subjects.add(line);                
            }
            for (int currentVerb = 0; currentVerb < totalVerbs; currentVerb++) {
                line = input.nextLine();
                verbs.add(line);                
            }
            for (int currentObject = 0; currentObject < totalObjects; currentObject++) {
                line = input.nextLine();
                objects.add(line);                
            }
        }
        displayAll(subjects,verbs,objects);        
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
            io.System.out.print(subject + " ");
            io.System.out.print(verb + " ");
            io.System.out.println(object + ".");
        }        
    }
    
}