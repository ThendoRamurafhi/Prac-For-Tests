import java.util.ArrayList;
import java.util.Scanner;

public class Modulus{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Sample Input:");

        int N = input.nextInt();
        int Z = input.nextInt();

        //ArrayList<String> arrlist = new ArrayList<>();

        // int see = (3*5) % 6; //(X * Y) *modulo* N == Z
        // System.out.println(see);

        int count = 0;

        for (int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                int ans = (i*j) % N;
                if (ans == Z){
                   // arrlist.add(pair(i, j));
                    count++;
                } 
            }
        }
        // System.out.println(arrlist);
         System.out.println("Sample output:");
         System.out.println(count);
        // for(String fin: arrlist){
        //     System.out.println(fin);
        // }
    }

    // public static String pair (int x, int y){
    //     return "(" + x + ", "+ y + ")";
    // }
}