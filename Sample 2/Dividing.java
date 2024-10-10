// import java.util.Scanner;

// /**
//  * BinarySearchonAnswerFlavor2
//  */
// public class Dividing {

//     //maxEl
//     static long arrayMaxEl(long[] arr){
//         long maxEl = arr[0];
//         for (long i : arr) maxEl = Math.max(maxEl, i);
//         return maxEl;   
        
//     }

//     static long arrayDivided(long[] planks, long divider){
//         long ans=0;
//         for (long i : planks) {
//             ans+= i/divider;
//         }
//         return ans;
//     }

//     static long planksOrders(long[] planks, long minOrder){
//         long low = 1;
//         long high = arrayMaxEl(planks);

//         //binary search
//         long bestK=0;
//         while (low<=high) {
//             long middle = (low+high)/2;
//             long generatedPlanks = arrayDivided(planks, middle);


//             if (generatedPlanks>=minOrder) {
//                 bestK = middle;
//                 low = middle+1;
//             }
//             else
//                 high = middle-1;

//         }
//         return bestK;
//     }

//     public static void main(String[] args) {
//         // long[] arr = {10,14,15,11};
//         // System.out.println(planksOrders(arr,6));
//         try (Scanner input = new Scanner(System.in)) {
//             long N = input.nextLong();
//             long[] arr = new long[(int) N];
//             for (long i = 0; i < N; i++) {
//                 arr[(int) i] = input.nextLong();
//             }
//             long minOrder = input.nextLong();
//             System.out.println(planksOrders(arr, minOrder));
//         }
//     }
    
// }
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Dividing {

    // Function to find the maximum element in the array
    static long arrayMaxEl(long[] arr) {
        long maxEl = arr[0];
        for (long i : arr) maxEl = Math.max(maxEl, i);
        return maxEl;
    }

    // Function to divide the planks by the divider and return the sum of divisions
    static long arrayDivided(long[] planks, long divider) {
        long ans = 0;
        for (long i : planks) {
            ans += i / divider;
        }
        return ans;
    }

    // Function to perform BFS-based search for the best divider
    static long planksOrders(long[] planks, long minOrder) {
        long low = 1;
        long high = arrayMaxEl(planks);

        // BFS queue for (low, high) pairs
        Queue<long[]> queue = new LinkedList<>();
        queue.add(new long[]{low, high});

        // Best divider (bestK) initialized to 0
        long bestK = 0;

        // Perform BFS
        while (!queue.isEmpty()) {
            long[] range = queue.poll();
            low = range[0];
            high = range[1];

            if (low > high) continue;

            long middle = (low + high) / 2;
            long generatedPlanks = arrayDivided(planks, middle);

            if (generatedPlanks >= minOrder) {
                bestK = middle;
                // Explore the right half of the search space (middle + 1 to high)
                queue.add(new long[]{middle + 1, high});
            } else {
                // Explore the left half of the search space (low to middle - 1)
                queue.add(new long[]{low, middle - 1});
            }
        }

        return bestK;
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            long N = input.nextLong(); // Number of planks
            long[] arr = new long[(int) N]; // Array of plank lengths

            // Input the lengths of the planks
            for (long i = 0; i < N; i++) {
                arr[(int) i] = input.nextLong();
            }

            long minOrder = input.nextLong(); // Minimum number of orders needed

            // Call the planksOrders function and print the result
            System.out.println(planksOrders(arr, minOrder));
        }
    }
}
