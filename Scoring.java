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