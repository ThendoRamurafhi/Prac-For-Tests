public class simple {
    private static String reveString(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        String str = "Hello";
        String reversedStr = reveString(str);
        System.out.println(reversedStr);
    
    } 
   
}

