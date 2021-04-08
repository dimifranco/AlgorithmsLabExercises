import java.util.Scanner;
import java.util.ArrayList;

public class MaxDiff {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayList<Integer> arr = scanArray(in);
        int[] index = new int[2];

        index = maxDiff2(arr);
        System.out.println(index[0] + " " + index[1]);

    }

    public static int[] maxDiff1(ArrayList<Integer> arr) {
        
        int max = 0;
        int[] res = new int[2];

        for(int i=0; i<arr.size(); i++) {
            for(int j=i+1; j<arr.size(); j++) {
                if(arr.get(j) - arr.get(i) >= max ) {
                    max = arr.get(j) - arr.get(i);
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }

    public static int[] maxDiff2(ArrayList<Integer> arr) {

        int min = 0;
        int diff = 0;
        int[] res = new int[2];
 
        for(int i=0; i<arr.size(); i++) {
            if(arr.get(i) < arr.get(min)) {
                min = i;
            } 
            if(diff < arr.get(i) - arr.get(min)) {
                diff = arr.get(i) - arr.get(min);
                res[0] = min;
                res[1] = i;
            }
        }

        return res;
    }

    public static ArrayList<Integer> scanArray(Scanner in) {
        // scan line of text
        String line = in.nextLine();

        // convert line of text into array of strings (tokens)
        String[] tokens = line.split(" ");

        // convert array of strings into array of integers
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (String token : tokens) {
            if (!token.isEmpty()) // some tokens may be empty (e.g. with trailing spaces)
                arr.add(Integer.parseInt(token));
        }

        return arr;
    }
}