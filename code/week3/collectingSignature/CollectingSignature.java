import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

//Problem Introduction
//You are responsible for collecting signatures from all tenants of a certain building. For each
//tenant, you know a period of time when he or she is at home.  You would like to collect all
//signatures by visiting the building as few times as
//possible.
//The mathematical model for this problem is the following. You are given a set
//of segments on a line and your goal is to mark as few points on a line as possible
//so that each segment contains at least one marked point.
//
//Problem Description
//Task: Given a set of n segments {[a 0 , b 0 ], [a 1 , b 1 ], . . . , [a n−1 , b n−1 ]} with integer coordinates on a line, find
//the minimum number m of points such that each segment contains at least one point. That is, find a
//set of integers X of the minimum size such that for any segment [a i , b i ] there is a point x ∈ X such
//that a i ≤ x ≤ b i .
//
//Input Format: The first line of the input contains the number n of segments. Each of the following n lines
//contains two integers a i and b i (separated by a space) defining the coordinates of endpoints of the i-th
//segment.
//
//Constraints: 1 ≤ n ≤ 100; 0 ≤ a i ≤ b i ≤ 10^9 for all 0 ≤ i < n.
//Output Format. Output the minimum number m of points on the first line and the integer coordinates
//of m points (separated by spaces) on the second line. You can output the points in any order. If there
//are many such sets of points, you can output any set. (It is not difficult to see that there always exist
//a set of points of the minimum size such that all the coordinates of the points are integers.)
//
//The runtime of the following solution is O(nlogn)
public class CollectingSignature {
    
    private static class Segment {
        private int start;
        private int end;

        public Segment(int start, int end){
            this.start = start;
            this.end= end;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try{
            int n = in.nextInt();
            List<Segment> allSegments = new ArrayList<Segment>(n);
            // O(n) time
            for(int i =0; i<n; i++){
                int start = in.nextInt();
                int end = in.nextInt();
                allSegments.add(new Segment(start, end));
            }
            Deque<Integer> optimumPoints = getOptimumPoints(allSegments);
            System.out.println(optimumPoints.size());
            optimumPoints.forEach(point->System.out.print(point + " "));
            System.out.println();
        }
        catch(NumberFormatException ex){
            ex.printStackTrace();
        }
        in.close();
    }

    // O(nlogn) runtime
    private static Deque<Integer> getOptimumPoints(List<Segment> allSegments){
        Deque<Integer> optimumPoints = new ArrayDeque<>();
        // O(nlogn) time
        allSegments.sort((a,b)->Integer.compare(a.end, b.end));
        // The first optimum point is the earliest end time
        optimumPoints.add(allSegments.get(0).end);
        // O(n) time complexity
        int size = allSegments.size();
        for(int i=1; i<size; i++){
            if(allSegments.get(i).start> optimumPoints.getLast()){
                optimumPoints.add(allSegments.get(i).end);
            }
        }
        return optimumPoints;
    }
}

