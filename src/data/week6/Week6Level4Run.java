
package data.week6;

import io.System;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import mainpackage.Problem;

public class Week6Level4Run  extends Problem
{

    public void start() {   
        System.out.header("Week 6, Level 4: starting");          
        String[] lines = { 
           "3",
           "1 2 3 4 5",
           "6 7 8 9 10",
           "1 2 3 4 5",
           "5 7 9 11 13",
           "1 4 5 5 7 9",
           "4 6 7 10 11 20"
        };
        System.out.println("Inputs:\n");
        for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
        }
        System.out.println("\nOutputs:\n");
        String line = lines[0];        
        int n = Integer.parseInt(line);
        int lineNumber = 1;
        for (int i = 0; i < n; i++) {
            String line1 = lines[lineNumber];
            lineNumber++;
            String line2 = lines[lineNumber];
            lineNumber++;
            String[] values1 = line1.split("[ ]");
            String[] values2 = line2.split("[ ]");
            Integer[] numbers1 = new Integer[values1.length];
            Integer[] numbers2 = new Integer[values2.length];
            for (int j = 0; j < values1.length; j++) {
                numbers1[j] = new Integer(values1[j]);
            }
            for (int j = 0; j < values2.length; j++) {
                numbers2[j] = new Integer(values2[j]);
            }
            LinkedList<Integer> list1 = new LinkedList<>(Arrays.asList(numbers1));
            LinkedList<Integer> list2 = new LinkedList<>(Arrays.asList(numbers2));
            LinkedList<Integer> list3 = new LinkedList<>();
            list3.addAll(list1);
            list3.addAll(list2);
            Collections.sort(list3);
            LinkedList<Integer> list = new LinkedList<>();
            for (int j = 0; j < list3.size(); j++) {
                Integer a = list3.get(j);
                if (!list.contains(a)) {
                    list.add(a);
                }
            }
            String output = "";
            for (int j = 0; j < list.size(); j++) {
                output += list.get(j) + " ";
            }
            System.out.println(output);
        }
        System.out.header("Week 6, Level 4: complete");
        System.flush();
    }

}
