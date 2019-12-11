
package challenge.week6;


import java.util.Scanner;
import mainpackage.Problem;


public class Week6Level1 extends Problem
{

    public static void main(String[] args) {
        new Week6Level1().start();
    }
    
    public void start() {
        Scanner input = new Scanner(System.in); 
        System.out.println("Enter day:");        
        String line1 = input.nextLine();
        System.out.println("Enter the number of days in the month:");        
        String line2 = input.nextLine();
        int startingDay = Integer.parseInt(line1);
        int daysInMonth = Integer.parseInt(line2);
        int currentDay  = 1;
        final String[] DAYS           = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
        final String   SPACE          = " ";
        final String   BLANK_DAY      = "    ";
        final int      HEADER         = 0;
        final int      WEEKS_IN_MONTH = 7;
        final int      DAYS_IN_WEEK   = 7;        
        String[][] month = new String[WEEKS_IN_MONTH][DAYS_IN_WEEK];
        for (int week = 0; week < WEEKS_IN_MONTH; week++) {
            int weekDay = 1;
            for (int day = 0; day < DAYS_IN_WEEK; day++) {                
                if (week == HEADER) {
                    month[week][day] = DAYS[day] + SPACE;
                }                
                else {
                    if (weekDay < startingDay && week == 1) {
                        month[week][day] = BLANK_DAY;
                    }
                    else if (currentDay > daysInMonth) {
                        month[week][day] = BLANK_DAY;
                    }
                    else {
                        if (currentDay < 10) {
                            month[week][day] = SPACE + SPACE + currentDay + SPACE;
                        }
                        else {
                            month[week][day] = SPACE + currentDay + SPACE;
                        }
                        currentDay++;
                    }
                    weekDay++;
                }
            }
        }
        for (int week = 0; week < WEEKS_IN_MONTH; week++) {
            for (int day = 0; day < DAYS_IN_WEEK; day++) {
                System.out.print(month[week][day]);
            }
            System.out.println("");
        }
    }

}
