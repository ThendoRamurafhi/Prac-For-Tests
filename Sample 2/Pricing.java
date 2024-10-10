import java.util.Scanner;

/**
 * BinarySearchonAnswerFlavor1
 */
public class Pricing {

    //price
    static long price(long k){
        if (k<=1) return 0;

        long sum =0;
        for (long i = 1; i < k; i++) {
            sum+= i*(k/i);
        }
        return sum;
            
    }


    //pricing
    public static long pricing(long currency){

        long low = 0;
        long high = 1000000;


        //binary search
        long bestK =0;

        while (low<=high) {
            long middle = (low+high)/2;
            long cost = price(middle);

            if (cost <= currency) {
                bestK = middle;
                low = middle + 1;
            }
            else
                high = middle - 1;

        }

        return bestK;
        
    }

    //main
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            long currency = input.nextLong();
            System.out.println(pricing(currency));
        }
        
    }
    
}