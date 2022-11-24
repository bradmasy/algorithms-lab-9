import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Lab 9: Dynamic Programming
 *
 * @name: Bradley Masciotra
 * @student_number: A01247718
 */
public class lab9 {




    static long SW_Recursive(int m, int n) {
        if (m == 0 || n == 0) {
            return 1;
        } else {
            return SW_Recursive(m - 1, n) + SW_Recursive(m, n - 1);
        }
    }

    static long SW_DynamicProg(int m, int n){
        long startTime = System.nanoTime();
        long[][] recorded = new long[m+1][n+1]; // initialize array.

        for(int i = 0; i < recorded.length; i++){ // iterate each row...
            for(int j = 0; j < recorded[i].length; j++){ // iterate each cell..
                recorded[0][j]  = 1;
                recorded[i][0]  = 1;
                if(i > 0  && j > 0){
                    recorded[i][j] = recorded[i][j-1] + recorded[i-1][j];
                }
            }
        }

        long endTime = System.nanoTime();
        long elapse = endTime - startTime;
        System.out.println("Time in milliseconds: " + elapse/1000000);

        return recorded[m][n];
    }


    public static void printGraph(long[][] graph){
        for(long[] num: graph){
            for(long each: num){
                System.out.print(each + " ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]) {
      //  System.out.println(SW_Recursive(3, 2)); // should == 3
//        System.out.println(SW_Recursive(1,2 )); // should == 3
//        System.out.println(SW_Recursive(2,2 )); // should == 3
//        System.out.println(SW_Recursive(3,3 )); // should == 3
//        System.out.println(SW_Recursive(4,4 )); // should == 3
//
//        System.out.println(SW_Recursive(3,2 )); // should == 3
//        System.out.println(SW_DynamicProg(3,3));
//        System.out.println(SW_DynamicProg(4,4));
        System.out.println("--------1---------");

        System.out.println(SW_DynamicProg(1,1));
        System.out.println("--------2---------");

        System.out.println(SW_DynamicProg(2,2));
        System.out.println("---------5--------");

        System.out.println(SW_DynamicProg(5,5));
        System.out.println("--------20---------");

        System.out.println(SW_DynamicProg(20,20));

        System.out.println("--------24---------");

        System.out.println(SW_DynamicProg(24,24));
        System.out.println("--------34---------");

        System.out.println(SW_DynamicProg(34,34));
    }
}
