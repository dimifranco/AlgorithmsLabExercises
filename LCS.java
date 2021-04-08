import java.util.Scanner;

public class LCS {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String x, y;
        StringBuilder z = new StringBuilder();

        System.out.println("Insert two strings:");
        x = in.next();
        y = in.next();

        String res = LCS(x, y, z);
        System.out.println("The longest common subsequence is: " + res);
        
    }

    public static String LCS(String x, String y, StringBuilder z) {
        //compute string lengths
        int n = x.length();
        int m = y.length();

        //memo initialization
        int memo[][] = new int[n+1][m+1];
        for (int h=0; h<=n; h++) {
            for(int k=0; k<=m; k++) {
                 memo[h][k] = -1;
            }
        }
        

        //cases initialization
        int cases[][] = new int[n+1][m+1];
        for (int h=0; h<=n; h++) {
            for(int k=0; k<=m; k++) {
                    cases[h][k] = -1;
                }
            }

        int l = LCS(x, y, n, m, memo, cases);

        //use cases to construct the maximum common subsequence
        int i = n;
        int j = m;
        int k = l - 1; //position in which I am going to write in z

        do {
            while(cases[i][j] != 1) {
                if(cases[i][j] == 2) {
                    i--;
                } else { // if cases[i][j] == 3
                    j--;
                }
            }
            z.append(x.charAt(i-1));
            k--;
            i--;
            j--;
        } while (k >= 0);

        return z.reverse().toString();
    }

    public static int LCS(String x, String y, int i, int j, int memo[][], int cases[][]) {

        if(memo[i][j] < 0) {// if not yet defined
            if( (i==0) || (j==0) ) {
                memo[i][j] = 0;
                cases[i][j] = -1;
            } else if (x.charAt(i-1) == y.charAt(j-1)) { // simple case
                memo[i][j] = LCS(x, y, i-1, j-1, memo, cases) + 1;
                cases[i][j] = 1; //first case
            } else { // complex case
                int l1 = LCS(x, y, i-1, j, memo, cases);
                int l2 = LCS(x, y, i, j-1, memo, cases);
                if(l1 > l2) {
                    memo[i][j] = l1;
                    cases[i][j] = 2; //case 2a
                } else {
                    memo[i][j] = l2;
                    cases[i][j] = 3; //case 2b
                }
            }
        }

        //I have the correct solution in memo[i][j]
        return memo[i][j];
    }

}