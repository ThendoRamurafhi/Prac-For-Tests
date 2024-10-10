import java.util.Scanner;

/**
 * BinarySearchonAnswerFlavor2
 */
public class Dividing {

    //maxEl
    static long arrayMaxEl(long[] arr){
        long maxEl = arr[0];
        for (long i : arr) maxEl = Math.max(maxEl, i);
        return maxEl;   
        
    }

    static long arrayDivided(long[] planks, long divider){
        long ans=0;
        for (long i : planks) {
            ans+= i/divider;
        }
        return ans;
    }

    static long planksOrders(long[] planks, long minOrder){
        long low = 1;
        long high = arrayMaxEl(planks);

        //binary search
        long bestK=0;
        while (low<=high) {
            long middle = (low+high)/2;
            long generatedPlanks = arrayDivided(planks, middle);


            if (generatedPlanks>=minOrder) {
                bestK = middle;
                low = middle+1;
            }
            else
                high = middle-1;

        }
        return bestK;
    }

    public static void main(String[] args) {
        // long[] arr = {10,14,15,11};
        // System.out.println(planksOrders(arr,6));
        try (Scanner input = new Scanner(System.in)) {
            long N = input.nextLong();
            long[] arr = new long[(int) N];
            for (long i = 0; i < N; i++) {
                arr[(int) i] = input.nextLong();
            }
            long minOrder = input.nextLong();
            System.out.println(planksOrders(arr, minOrder));
        }
    }
    
}