// import java.util.Scanner;

// /**
//  * BinarySearchonAnswerFlavor1
//  */
// public class Pricing {

//     //price
//     static long price(long k){
//         if (k<=1) return 0;

//         long sum =0;
//         for (long i = 1; i < k; i++) {
//             sum+= i*(k/i);
//         }
//         return sum;
            
//     }


//     //pricing
//     public static long pricing(long currency){

//         long low = 0;
//         long high = 1000000;


//         //binary search
//         long bestK =0;

//         while (low<=high) {
//             long middle = (low+high)/2;
//             long cost = price(middle);

//             if (cost <= currency) {
//                 bestK = middle;
//                 low = middle + 1;
//             }
//             else
//                 high = middle - 1;

//         }

//         return bestK;

//         // implement Breadth First Search on binary tree

//     }

//     //main
//     public static void main(String[] args) {
//         try (Scanner input = new Scanner(System.in)) {
//             long currency = input.nextLong();
//             System.out.println(pricing(currency));
//         }
        
//     }
    
// }
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Pricing {

    // Function to calculate the price
    static long price(long k) {
        if (k <= 1) return 0;

        long sum = 0;
        for (long i = 1; i < k; i++) {
            sum += i * (k / i);
        }
        return sum;
    }

    // Function to perform BFS-based binary search
    public static long pricing(long currency) {
        long low = 0;
        long high = 1000000;

        // BFS queue for (low, high) pairs
        Queue<long[]> queue = new LinkedList<>();
        queue.add(new long[]{low, high});

        long bestK = 0;

        // Perform BFS
        while (!queue.isEmpty()) {
            long[] range = queue.poll();
            low = range[0];
            high = range[1];

            if (low > high) continue;

            long middle = (low + high) / 2;
            long cost = price(middle);

            if (cost <= currency) {
                bestK = middle;
                // Explore the right half of the search space
                queue.add(new long[]{middle + 1, high});
            } else {
                // Explore the left half of the search space
                queue.add(new long[]{low, middle - 1});
            }
        }

        return bestK;
    }

    // Main method to get input and run the pricing function
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            long currency = input.nextLong();
            System.out.println(pricing(currency));
        }
    }
}
