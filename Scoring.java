import java.util.Scanner;
import java.util.ArrayList;

public class Scoring {
    //@SuppressWarnings("unlikely-arg-type")
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Sample Input:");

        ArrayList<Integer> arrlist = new ArrayList<>();
        // int T = input.nextInt();
        
        while(true){
            String line = input.nextLine().trim();
            

            if(line.isEmpty()){
                break;
            }

            try{
                int n = Integer.parseInt(line);
                if (n >= 1 && n <= 20) {
                    arrlist.add(n);
                } else {
                    System.out.println("Number must be between 1 and 20. Please try again.");
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
        } 
        int T = 0;
        boolean validT = false;
        while (!validT) {
            //System.out.println("Enter an additional number T:");
            try {
                T = Integer.parseInt(input.nextLine().trim());
                validT = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for T. Please enter an integer.");
            }
        }

        System.out.println("Entered numbers: " + arrlist);
        System.out.println("Additional number T: " + T);
        
        input.close();
    }
}
