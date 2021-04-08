import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        System.out.println(Reverse.reverse(str));
    }

    /*
    returns reversed string given
    @param string
    @return reversed string
    */

    public static String reverse(String str) {

        String reverse = "";

        for(int i = str.length()-1; i>=0; i--) {

            reverse += str.charAt(i);
        }

        return reverse;
    }


}
