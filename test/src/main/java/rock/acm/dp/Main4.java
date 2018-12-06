package rock.acm.dp;


import java.util.Arrays;

import java.util.Scanner;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2018-11-23 15:13
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        int n = cin.nextInt();
        int array[] = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = cin.nextInt();
        }
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            if(i != n-1) {
                System.out.print(array[i] + " ");
            }else{
                System.out.print(array[i]);
            }
        }
    }
}
