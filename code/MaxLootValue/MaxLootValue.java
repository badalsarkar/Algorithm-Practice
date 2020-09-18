import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 *The goal of this code problem is to implement an algorithm for the fractional knapsack problem.

* Input Format: The first line of the input contains the number n of items and the capacity W of a
* knapsack.The next n lines define the values and weights of the items. The i-th line contains
* integers v i and w i —the value and the weight of i-th item, respectively.
*
* Constraints: 1 ≤ n ≤ 10 3 , 0 ≤ W ≤ 2 · 10 6 ; 0 ≤ v i ≤ 2 · 10 6 , 0 < w i ≤ 2 · 10 6 for all 1 ≤
* i ≤ n. All the numbers are integers.
*
* Output Format: Output the maximal value of fractions of items that fit into the knapsack. The
* absolute value of the difference between the answer of your program and the optimal value should
* be at most 10 −3 . To ensure this, output your answer with at least four digits after the decimal
* point (otherwise your answer, while being computed correctly, can turn out to be wrong because of
* rounding issues).
*/

public class MaxLootValue {
    private static List<Item> allItems;
    private static int maxWeight;
    private static int maxItem;
    private static double maxLootValue;

   static class Item {
       public int value;
       public int weight;
       public double valuePerWeight;

       public Item(int value, int weight){
           this.value = value;
           this.weight = weight;
           this.valuePerWeight = (double)this.value/this.weight;
       }
   }

   public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       try{
           maxItem = in.nextInt();
           maxWeight = in.nextInt();
           allItems = new ArrayList<>(maxItem); 
           for(int i = 0 ; i < maxItem; i++){
               allItems.add(new MaxLootValue.Item(in.nextInt(), in.nextInt()));
           }
           in.nextLine();
           System.out.printf("%.4f\n",getMaxLootValue());
        }
       catch(NumberFormatException ex){
           ex.printStackTrace();
       }
       in.close();
   }

   public static double getMaxLootValue(){
       /*
        * This sort takes O(n log n ) time
        */
       allItems.sort((item1, item2)-> Double.compare(item2.valuePerWeight, item1.valuePerWeight)); 
       /*
        * Loops max n times
        */
       for(int i =0; i< maxItem; i++){
           Item item= allItems.get(i);
           if(maxWeight<=item.weight){
               return maxLootValue+item.valuePerWeight*maxWeight;
           }
           else{
               maxLootValue+=item.value;
               maxWeight-=item.weight;
           }
       }
       return maxLootValue;
    }
}
