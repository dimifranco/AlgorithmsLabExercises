import java.util.Scanner;
import java.util.ArrayList;

public class IntervalSum {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayList<Integer> arr = scanArray(in);
        int sum = in.nextInt();
        int[] hdtl = new int[2];

        hdtl = findInterval(arr, sum);
        System.out.println(hdtl[0] + " " + hdtl[1]);
    }

    public static int[] findInterval(ArrayList<Integer> arr, int sum) {

        int[] res = new int[2];

        if(arr.size() != 0) {

            int partial_sum = arr.get(0);
            
            int i = 0;
            int j = 0;

            while(j<arr.size()-1) {
                if(partial_sum == sum) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                } else if(partial_sum < sum) {
                    partial_sum += arr.get(++j);
                } else {
                    partial_sum -= arr.get(i++);
                }
            }

            res[0] = -1;
            res[1] = -1;
            return res;
        } 
        

        res[0] = -1;
        res[1] = -1;
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