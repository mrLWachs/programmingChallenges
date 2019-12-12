
package challenge.week6;


import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import mainpackage.Problem;


public class Week6Level4 extends Problem
{

    public static void main(String[] args) {
        new Week6Level4().start();
    }
    
    public void start() {
        Scanner input = new Scanner(System.in); 
        String line = input.nextLine();
        int n = Integer.parseInt(line);
        for (int i = 0; i < n; i++) {
            String line1 = input.nextLine();
            String line2 = input.nextLine();
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
    }

}
