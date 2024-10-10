import java.util.*;
public class Farthest{
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        // get inputs
        int rStart = kb.nextInt();
        int cStart = kb.nextInt();
        int rows = kb.nextInt();
        int cols = kb.nextInt();

        String data = "";
        for (int i=0; i<rows; i++){
            data += kb.next();
        }

        //create hashmap
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int j=0; j<(rows*cols); j++){
            if (hasLand(data, j)) {
                graph.put(j, getN(data, j, rows, cols));
            }
        }

        //use bfs
        System.out.println(bfs(graph, (cols*rStart)+cStart));

        //close stuff
        kb.close();

    }

    //get neighbours
    public static List<Integer> getN(String data, int pos, int rows, int cols){
        List<Integer> n = getHN(data, pos, rows, cols);
        n.addAll(getVN(data, pos, rows, cols));
        return n;
    }
    //get vn
    public static List<Integer> getVN(String data, int pos, int rows, int cols){
        List<Integer> vn = new ArrayList<>();
        //if top row
        if (pos<cols) {
            if (hasLand(data, pos+cols)){vn.add(pos+cols);}
        }
        //if bottom row
        else if (pos>=(cols*(rows-1))) {
            if (hasLand(data, pos-cols)){vn.add(pos-cols);}
        }
        //middle
        else{
            if (hasLand(data, pos+cols)){vn.add(pos+cols);}
            if (hasLand(data, pos-cols)){vn.add(pos-cols);}
        }

        return vn;
    }
    //get hn
    public static List<Integer> getHN(String data, int pos, int rows, int cols){
        List<Integer> hn = new ArrayList<>();
        //if left col
        if ((pos%cols)==0) {
            if (hasLand(data, pos+1)){hn.add(pos+1);}
        }
        //if right col
        else if ((pos%cols)==(cols-1)) {
            if (hasLand(data, pos-1)){hn.add(pos-1);}
        }
        //middle
        else{
            if (hasLand(data, pos+1)){hn.add(pos+1);}
            if (hasLand(data, pos-1)){hn.add(pos-1);}
        }

        return hn;
    }

    //check if cell has land
    public static boolean hasLand(String data, int pos){
        if (data.charAt(pos)=='L'){
            return true;
        }
        else{return false;}
    }

    //bfs
    public static int bfs(HashMap<Integer, List<Integer>> graph, int start){
        //create queue and visisted
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        //craete counter to hold perimeter length
        int dist = -1;

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()){
            int qlen = queue.size();
            for (int i=0; i<qlen; i++){
                int node = queue.poll();
                //System.out.println(node);
                

                for (int current : graph.get(node)){
                    if (!visited.contains(current)) {
                        queue.add(current);
                        visited.add(current);
                    }

                }
            }
            dist++;
        }

        return dist;
    }
}