import java.util.Scanner;
import java.util.ArrayList;
import java.util.Scanner;

public class CoupleSum {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr = scanArray(in);
        int sum = in.nextInt();
        int[] res = new int[2];
    
        res = coupleSum2(arr, sum);
        String index_pair = "" + res[0] + " " + res[1];
        System.out.println(index_pair);
    }

    public static int[] coupleSum1(ArrayList<Integer> arr, int sum) {

        int[] res = new int[2];

        for(int i=0; i<arr.size(); i++) {
            for(int j=i+1; j<arr.size(); j++) {
                if(arr.get(i) + arr.get(j) == sum) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }

        res[0] = -1;
        res[1] = -1;
        return res;
    }

    public static int[] coupleSum2(ArrayList<Integer> arr, int sum) {

        int[] res = new int[2];

        for(int i=0; i<arr.size(); i++) {
            int j = binarySearch(arr, i+1, arr.size()-1, sum-arr.get(i));
            if(j>=0) {
                res[0] = i;
                res[1] = j;
                return res;
            }
        }

        res[0] = -1;
        res[1] = -1;
        return res;
    }

    public static int[] coupleSum3(ArrayList<Integer> arr, int sum) {

        int[] res = new int[2];
        int head = 0, tail = arr.size()-1;

        while(head<tail) {
            if(arr.get(head) + arr.get(tail) == sum) {
                res[0] = head;
                res[1] = tail;
                return res;
            } else if(arr.get(head) + arr.get(tail) > sum) {
                tail--;
            } else {
                head++;
            }
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

    public static int binarySearch(ArrayList<Integer> arr, int head, int tail, int key) {

        if(head>tail) {
            return -1;
        }
            
        int k = (head + tail) / 2;

        if(arr.get(k) == key) {
            return k;
        } else if(key < arr.get(k)) {
            return binarySearch(arr, head, k-1, key);
        } else {
            return binarySearch(arr, k+1, arr.size()-1, key);
        }
    }
}