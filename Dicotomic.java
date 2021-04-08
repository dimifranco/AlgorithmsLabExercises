import java.util.ArrayList;
import java.util.Scanner; 

public class Dicotomic {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<Integer>(scanArray(in));
        int key = in.nextInt();

        System.out.println(binarySearch(arr, key));

    }

    public static int binarySearch(ArrayList<Integer> arr, int key) {

        int pos = arr.size() / 2;

        if(arr.size() < 1) {
            if(arr.get(pos) == key) {
                return pos;
            } else {
                System.out.println("-1");
            }
        }

        if(arr.size() == 0) {
            System.out.printl("-1");
        }

        if(arr.get(pos) == key) {
            return pos;
        } else if(arr.get(pos) < key) {
            return (arr.size() / 2) + binarySearch(new ArrayList<Integer>(arr.subList(pos, arr.size())), key);
        } else {
            return binarySearch(new ArrayList<Integer>(arr.subList(0, pos)), key);
        }

    }

    public static ArrayList<Integer> scanArray(Scanner in) {
        
        String line = in.nextLine();

        String[] tokens = line.split(" ");

        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (String token : tokens) {
            if (!token.isEmpty()) 
                arr.add(Integer.parseInt(token));
        }

        return arr;
    }
}