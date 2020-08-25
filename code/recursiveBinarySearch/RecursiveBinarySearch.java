
public class RecursiveBinarySearch {
    public static int search(int[] data, int key, int low, int high){
        int index=-1;
        if(high >= low){
            int middle = low+(high - low)/2;
            if(data[middle]==key){
                return middle;
            }

            if(data[middle]>key){
                return search(data,key,low,middle-1);
            }
            return search(data, key, middle+1, high);
        }
        return -1;
    }
}
