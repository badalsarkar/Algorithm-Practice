import java.util.Arrays;
import java.util.Scanner;

/*
 *Task: Given two sequences a 1 , a 2 , . . . , a n (a i is the profit per click of the i-th ad) and
 * b 1 , b 2 , . . . , b n (b i is the average number of clicks per day of the i-th slot), we need
 * to partition them into n pairs (a i , b j ) such that the sum of their products is maximized.
 *
 * Input Format: The first line contains an integer n, the second one contains a sequence of integers
 * a 1 , a 2 , . . . , a n , the third one contains a sequence of integers b 1 , b 2 , . . . , b n .
 *
 * Constraints: 1 ≤ n ≤ 10 3 ; −10 5 ≤ a i , b i ≤ 10 5 for all 1 ≤ i ≤ n
 *
 * Output Format. Output the maximum value of revenue 
 *
 */

public class MaxAddRevenue {
    private static int[] profit;
    private static int[] noOfClick;
    private static int noOfItem;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try{
            noOfItem = in.nextInt();
            profit= new int[noOfItem];
            noOfClick = new int [noOfItem];
            for(int i=0; i< noOfItem; i++){
                profit[i]= in.nextInt();
            }
            for(int i =0; i<noOfItem; i++){
                noOfClick[i]= in.nextInt();
            }
            System.out.println(getMaxRevenue());
        }
        catch(NumberFormatException ex){
            ex.printStackTrace();
        }


        in.close();
    }

    private static long getMaxRevenue() {
        // sorting takes n log n time
        Arrays.sort(profit);
        Arrays.sort(noOfClick);
        long maxValue = 0;
        // loop takes n time
        for(int i =noOfItem-1; i>=0; i--){
            maxValue+=((long)profit[i]*noOfClick[i]);
        }
        return maxValue;
    }
}
