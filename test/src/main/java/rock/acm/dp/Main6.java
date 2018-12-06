package rock.acm.dp;
import java.util.Scanner;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2018-11-23 18:39
 */
public class Main6 {
    static int array[][] = new int[12][12];
    static int array_[][][][] = new int[12][12][12][12];
    public static void main(String[] args) {

        Scanner cin=new Scanner(System.in);
        int n = cin.nextInt();
        int a =1,b =1,v =1;
        while (a!=0 && b!=0 && v!=0){
            a = cin.nextInt();
            b = cin.nextInt();
            v= cin.nextInt();
            array[a][b] = v;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                for (int k = 1; k < n; k++) {
                    for (int l = 1; l < n; l++) {

                        array_[i][j][k][l] = Math.max(Math.max(array_[i-1][j][k-1][l],array_[i-1][j][k][l-1]),
                                Math.max(array_[i][j-1][k][l-1],array_[i][j-1][k-1][l]))+array[i][j]+array[k][l];

                        if(i==k && j==l){
                            array_[i][j][k][l] -= array[i][j];
                        }
                    }
                }
            }
        }
        System.out.println(array_[n-1][n-1][n-1][n-1]);


    }

}
