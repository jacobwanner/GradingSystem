import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {
        
        // variables used
        String letterGradeString = "Your Letter Grade is: ";
        //creates array to store all grade scores
        int gradesArray[] = new int[10];
        //# of grades to be entered
        int n = 10;
        // counter integer
        int i;
        //initalizes final score variable
        int studentInputTotal = 0;
        //input listener created
        Scanner studentInput = new Scanner(System.in);


        //Loop runs until # of n grades are input into array
        //adds each input into array
        System.out.println("Input your grade score");
        for (i=0; i<n; i++) {
            gradesArray[i] = studentInput.nextInt();
            //if number 999 is entered, the code is terminated.
            if (gradesArray[i]==999) {
                studentInput.close();
                System.out.println("You've entered the magic number: 999. Program Terminated.");
                System.exit(0);
            }
        }

        //prints out all elements of the array. This is MUCH simplier than creating a loop to do it.
        System.out.println(Arrays.toString(gradesArray));

        //runs when 10 ints have been placed in array
        //adds all scores up and divides by 10 to find the average
        while (i==10) {
            int sum = IntStream.of(gradesArray).sum();
            studentInputTotal = (sum/10);
            System.out.println("Your Final Grade is: " + studentInputTotal);
                break;
        }
        
        //checks the final score limits then returns a string of the letter grade
        if (isBetween(studentInputTotal, 0, 59)) {
            System.out.println(letterGradeString + "F");
        } else if (isBetween(studentInputTotal, 60, 69)) {
            System.out.println(letterGradeString + "D");
        } else if (isBetween(studentInputTotal, 70, 79)) {
            System.out.println(letterGradeString + "C");
        }  else if (isBetween(studentInputTotal, 80, 89)) {
            System.out.println(letterGradeString + "B");
        } else if (isBetween(studentInputTotal, 90, 100)) {
            System.out.println(letterGradeString + "A");
        } else System.out.println("Final Grade is Outside of Allowed Range");

        studentInput.close();
    }
    // this creates a function to check if the final score is in between 2 given numbers
    public static boolean isBetween(int x, int lower, int upper) {
        return lower <= x && x <= upper;
    }
}
