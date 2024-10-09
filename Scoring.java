import java.util.Scanner;
import java.util.ArrayList;

public class Scoring {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Integer> arrlist = new ArrayList<>();

        // Read N (number of integers in the list)
        int N = input.nextInt();

        // Read N integers
        for (int i = 0; i < N; i++) {
            int num = input.nextInt();
            arrlist.add(num);
        }

        // Read T (target score)
        int T = input.nextInt();

        input.close();

        // Convert ArrayList to array
        int[] numbers = arrlist.stream().mapToInt(Integer::intValue).toArray();

        // Calculate max score
        int maxScore = calculateMaxScore(numbers, T);

        // Output result
        System.out.println(maxScore);
    }

    private static int calculateMaxScore(int[] numbers, int T) {
        int N = numbers.length;
        boolean[] possible = new boolean[T];
        possible[1] = true; // Start with 1 point
        int maxScore = 1;

        for (int num : numbers) {
            for (int score = T - 1; score >= 1; score--) {
                if (possible[score]) {
                    // Addition
                    if (score + num < T) {
                        possible[score + num] = true;
                        maxScore = Math.max(maxScore, score + num);
                    }
                    // Multiplication
                    if (score * num < T) {
                        possible[score * num] = true;
                        maxScore = Math.max(maxScore, score * num);
                    }
                }
            }
        }

        return maxScore;
    }
}
/*    public static void swapRows(double[][] matrix, int row1, int row2) {
        if (row1 == row2) {
            return; // No need to swap if the rows are the same
        }

        double[] temp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = temp;
    }

    public static void main(String[] args) {
        double[][] matrix = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0, 6.0},
            {7.0, 8.0, 9.0}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        // Swap row 0 and row 2
        swapRows(matrix, 0, 2);

        System.out.println("Matrix after swapping row 0 and row 2:");
        printMatrix(matrix);
    }

    /**
     * Prints the given 2D matrix.
     *
     * @param matrix The 2D matrix to print.
     */
   /* public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
         public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int number = 29;
        if (isPrime(number)) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }
    }
}
    
     public static boolean[] sieveOfEratosthenes(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

    public static void main(String[] args) {
        int limit = 50;
        boolean[] primes = sieveOfEratosthenes(limit);

        System.out.println("Prime numbers up to " + limit + ":");
        for (int i = 2; i <= limit; i++) {
            if (primes[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
 */