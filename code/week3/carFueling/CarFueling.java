import java.util.Scanner;

/*
 * Input Format: The first line contains an integer d. The second line contains an integer m. The
 * third line specifies an integer n. Finally, the last line contains integers stop 1,stop 2,..,
 * stop n .
 *
 * Output Format: Assuming that the distance between the cities is d miles, a car can travel at most
 * m miles on a full tank, and there are gas stations at distances stop 1 , stop 2,...,stop n
 * along the way, output the minimum number of refills needed. Assume that the car starts with a
 * full tank. If it is not possible to reach the destination, output −1.  
 * 
 * Constraints: 1 ≤ d ≤ 10 5 . 1 ≤ m ≤ 400. 1 ≤ n ≤ 300. 0 < stop 1 < stop 2 < · · · < stop n < d.
 *
 */

class CarFueling {
    private static int destination;
    private static int millage;
    private static int totalStop;
    private static int[] stopDistance;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try{
            destination = in.nextInt();
            millage = in.nextInt();
            totalStop = in.nextInt();
            stopDistance = new int[totalStop];
            for(int i =0; i< totalStop; i++){
                stopDistance[i]=in.nextInt();
            }
            System.out.println(getRefillNumber());
        }
        catch(NumberFormatException ex){
            ex.printStackTrace();
        }
    }

    private static int getRefillNumber(){
        int currentPos =0;
        int remainingMillage=millage;
        int noOfRefill=0;
        // not possible if distance between last stop and destination
        // is more than millage
        if(destination-stopDistance[totalStop-1]>millage){
            return -1;
        }
        // otherwise check all the stops
        for(int i =0; i<= totalStop; i++){
            int nextPos = i==totalStop?destination:stopDistance[i];
            if(destination<=currentPos){
                return noOfRefill;
            }

            if(nextPos - currentPos>millage){
                return -1;
            }
            else if(nextPos-currentPos<=remainingMillage){
                // no refill, go to next stop
                remainingMillage-=(nextPos-currentPos);
                currentPos=nextPos;
            }
            else{
                //refill and go
                noOfRefill++; 
                remainingMillage=millage-nextPos+currentPos;
                currentPos= nextPos;
            }
        }
        return noOfRefill;
    }
}
