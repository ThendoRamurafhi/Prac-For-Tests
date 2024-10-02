import java.util.Scanner;

public class Modulus {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Read input
        int N = input.nextInt();
        int Z = input.nextInt();

        input.close();

        int count = 0;

        // Count pairs
        for (int X = 1; X < N; X++) {
            for (int Y = 1; Y < N; Y++) {
                if ((X * Y) % N == Z) {
                    count++;
                }
            }
        }

        // Output result
        System.out.println(count);
    }
}