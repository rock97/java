package rock.acm.dp;


import java.util.Scanner;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2018-11-23 13:42
 */
public class Main {
    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        int n = cin.nextInt();
        int[][] array = new int[n][4];
        int a,b;
        for (int i = 0; i < n; i++) {
            array[i][0] = cin.nextInt();
            array[i][1] = cin.nextInt();
            array[i][2] = cin.nextInt();
            array[i][3] = cin.nextInt();
        }
         a = cin.nextInt();
         b = cin.nextInt();

        boolean flag = false;
        for (int i = n-1; i >=0 ; i--) {
            if( 0 <= a - array[i][0] && a - array[i][0] <= array[i][2] && 0 <= b - array[i][1] && b - array[i][1] <= array[i][3]){
                flag = true;
                System.out.println(i+1);
                break;
            }
        }
        if(!flag){
            System.out.println("-1");
        }
    }
}
