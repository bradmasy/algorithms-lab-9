/**
 * Lab 9: Dynamic Programming
 *
 * @version: 1.0
 * @lab: Lab 9
 * @subject: Dynamic Programming
 * @name: Bradley Masciotra
 * @student_number: A01247718
 * @date: November 26th 2022
 * @set: G
 *
 * Lab 9 explores dynamic programming algorithms comparing a recursive approach and a dynamic approach. In this lab
 * we were asked to find all the possible paths of getting from point A to point B from a given first index and last
 * index that are the same(ie: (2,2), (4,4), (6,6), etc). From here we use a recursive approach and dynamic approach to visualize
 * the amount of time a recursive function adds as the amount of indices increase(stack builds up). Our dynamic
 * approach utilizes memorization as we store previously calculated values of our path in indices and access those values
 * instead of calculating new ones and therefore generating our solution.
 */
public class Lab9 {


    public static int CONVERT_TO_MILLISECONDS = 1000000;

    /**
     * Finds the amount of paths of an m x n grid where the first point is (0,0) and last point is (m,n) and returns the
     * amount of paths. Solves the problem using recursion and returning on the base case where m OR n are equivalent
     * to 0.
     *
     * @param m an integer representing the x value of the grid, ie the amount of columns.
     * @param n an integer representing the y value of the grid, ie the amount of cells per column.
     * @return the amount of paths from (0,0) to (m,n)
     */
    static public long SW_Recursive(int m, int n) {
        if (m == 0 || n == 0) {
            return 1;
        } else {
            return SW_Recursive(m - 1, n) + SW_Recursive(m, n - 1);
        }
    }

    /**
     * Runs the recursive function SW_Recursive from first to last and records the times and displays the amount of
     * milliseconds the algorithm takes to run.
     *
     * @param first an integer representing the value of i for our loops starting value.
     * @param last an integer representing the end point of our loop, from first to last.
     */
    static public void RunRecursive(int first, int last) {
        System.out.println("\tRunning Recursive Programming Algorithm...\n");

        for (int i = first; i < last; i++) {
            long startTime = System.nanoTime();
            System.out.println("Number of paths found for "+ i + " by " + i + " grid: " + SW_Recursive(i, i));

            long endTime = System.nanoTime();
            long elapse = endTime - startTime;
            System.out.println("Time in milliseconds to run: " + elapse / CONVERT_TO_MILLISECONDS);
        }
    }

    /**
     *  Finds the amount of paths of an m x n grid where the first point is (0,0) and last point is (m,n) and returns the
     *  amount of paths. Solves the problem using dynamic programming and memorization with iteration versus recursive
     *  calls, storing the values previously calculated in an array and returning the final calculated value of the
     *  array which is the last index of the array ie (m,n)
     *
     * @param m an integer representing the x value of the grid, ie the amount of columns.
     * @param n an integer representing the y value of the grid, ie the amount of cells per column.
     * @return the amount of paths from (0,0) to (m,n)
     */
    static long SW_DynamicProg(int m, int n) {
        long[][] recorded = new long[m + 1][n + 1]; // initialize array.

        for (int i = 0; i < recorded.length; i++) { // iterate each row...
            for (int j = 0; j < recorded[i].length; j++) { // iterate each cell..
                recorded[0][j] = 1; // setting the paths for the first column and first row as there is only one path.
                recorded[i][0] = 1;
                if (i > 0 && j > 0) {
                    recorded[i][j] = recorded[i][j - 1] + recorded[i - 1][j]; // adding the left index of the current row and the current index in the row above.
                }
            }
        }
        return recorded[m][n];
    }

    /**
     * Runs the dynamic function SW_DynamicProg from first to last and records the times and displays the amount of
     * milliseconds the algorithm takes to run.
     *
     * @param first an integer representing the value of i for our loops starting value.
     * @param last an integer representing the end point of our loop, from first to last.
     */
    static public void RunDynamicProg(int first, int last) {

        System.out.println("Running Dynamic Programming Algorithm...\n");
        for(int i = first; i < last;i++ ){
            long startTime = System.nanoTime();

            System.out.println("Number of paths found for "+ i + " by " + i + " grid: " + SW_DynamicProg(i,i));
            long endTime = System.nanoTime();
            long elapse = endTime - startTime;
            System.out.println("\tTime in milliseconds to run: " + elapse / CONVERT_TO_MILLISECONDS);
        }
    }

    /**
     * Drives the program.
     *
     * @param args program arguments.
     */
    public static void main(String[] args) {

        RunRecursive(0, 15); // gets quite slow after 15...
        System.out.println("---------------------------------");
        RunDynamicProg(0,37);
    }
}
