import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

// Problem Introduction
// You are organizing a funny competition for children. As a prize fund you have n
// candies. You would like to use these candies for top k places in a competition
// with a natural restriction that a higher place gets a larger number of candies.
// To make as many children happy as possible, you are going to find the largest
// value of k for which it is possible.
//
// Problem Description
// Task: The goal of this problem is to represent a given positive integer n as a sum of as many pairwise
// distinct positive integers as possible. That is, to find the maximum k such that n can be written as
// a 1 + a 2 + · · · + a k where a 1 , . . . , a k are positive integers and a i ̸ = a j for all 1 ≤ i < j ≤ k.
//
// Input Format: The input consists of a single integer n.
//
// Constraints: 1 ≤ n ≤ 10 9 .
// Output Format. In the first line, output the maximum number k such that n can be represented as a sum
// of k pairwise distinct positive integers. In the second line, output k pairwise distinct positive integers
// that sum up to n (if there are many such representations, output any of them).
public class MaxPrize {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try{
            int n = in.nextInt();
            List<Integer> allPrizes = new ArrayList<>();
            allPrizes = getAllPossiblePrizes(n);
            System.out.println(allPrizes.size());
            for(Integer i: allPrizes){
                System.out.print(i + " ");
            }
            System.out.println();
        }
        catch(NumberFormatException ex){
            ex.printStackTrace();
        }
        in.close();
    }

    // What is the Big O time?
    private static List<Integer> getAllPossiblePrizes(int n) {
        List<Integer> allPrizes = new ArrayList<>();
        allPrizes.add(1);
        n--;
        int lastIndex = 0;
        while(n>0){
            int lastSelectedPrize = allPrizes.get(lastIndex);
            int newSelection = lastSelectedPrize+1;
            if(newSelection>n){
                allPrizes.set(lastIndex,lastSelectedPrize+n);
                return allPrizes;
            }
            if(n-newSelection<=newSelection){
                newSelection+=(n-newSelection);
            }
            allPrizes.add(newSelection);
            lastIndex++;
            n-=newSelection;
        }
        return allPrizes;
    }

}
