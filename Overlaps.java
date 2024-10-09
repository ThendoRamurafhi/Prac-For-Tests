import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Overlaps{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the name of the circles data file:");
        String input = scan.nextLine();
        File file = new File(input);
        ArrayList<String> arrlist = new ArrayList<>();
        System.out.println("Enter the circle details (x, y and r separated by spaces):");
        String userinput = scan.nextLine();
        try{
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while((line = br.readLine())!= null){
                arrlist.add(line);
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        int i = 0;
        double a = 0;
        double b = 0;
        double r = 0;
        double c= 0;
        double d = 0;
        double rad= 0;
        double dis= 0;
        int num = 0;
       
        ArrayList<String> arr = new ArrayList<>();

        for( i = 0; i < arrlist.size(); i++){
             a = Double.parseDouble(arrlist.get(i).split(" ")[0]);
             b = Double.parseDouble(arrlist.get(i).split(" ")[1]);
             r = Double.parseDouble(arrlist.get(i).split(" ")[2]);

            
             c = Double.parseDouble(userinput.split(" ")[0]);
             d = Double.parseDouble(userinput.split(" ")[1]);
             rad = Double.parseDouble(userinput.split(" ")[2]);
            
             dis = Math.sqrt(Math.pow((a - c),2) + Math.pow((b - d), 2));
           
            
            if(dis < (r + rad)){
                num ++;
                arr.add(arrlist.get(i));
            }
        }
        //System.out.println(num);
        if(num == 0){
            System.out.println("There are no overlaps.");
        }
        else{
            System.out.println("Number of overlaps: "+ num);
            for(String out: arr){
                System.out.println(out);
            }
        }
        System.out.println("Done");
       
    }
}
