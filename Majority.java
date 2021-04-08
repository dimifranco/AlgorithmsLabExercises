import java.util.Scanner;
import java.util.ArrayList;

public class Majority {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        ArrayList<Integer> arr = scanArray(in);

        int res = majority2(arr);
        if(res == -1) {
            System.out.println("No majority");
        } else
            System.out.println(res);
    }

    public static int majority1(ArrayList<Integer> arr) {

        int counter = 1;
        int length = arr.size();

        for(Integer i: arr) {
            for(int j=arr.indexOf(i)+1; j<length; j++) {
                if(arr.get(j).equals(i)) {
                    counter++;
                }
            }
            if(counter > length/2) {
                return i;
            } else {
                counter = 1;
            }
        }
        
        return -1;
    }

    public static int majority2(ArrayList<Integer> arr) {

        int counter = 1;
        int control = 0;
        int candidate = arr.get(0);

        for(int i=1; i<arr.size(); i++) {
            if(arr.get(i) == candidate) {
                counter++;
            } else {
                counter--;
            }
            if(counter == 0) {
                candidate = arr.get(i);
                counter = 1;
            }
        }

        for(int i=0; i<arr.size(); i++) {
            if(arr.get(i) == candidate) {
                control++;
            }
        }

        if(control > arr.size()/2) {
            return candidate;
        } else
            return -1;

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