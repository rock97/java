package rock.acm.dp;

import java.util.Scanner;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2018-11-23 14:01
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        int n = cin.nextInt();
        int[] array = new int[n+1];
        for (int i = 0; i <= n ; i++) {
            array[i] = cin.nextInt();
        }

        for (int i = 0; i <= n; i++) {


            if(array[i] > 0 ){
                if(i==0) {
                    if(n-i==1){
                        if (array[i] == 1) {
                            System.out.print("x");
                        } else {
                            System.out.print(array[i] + "x");
                        }
                    }
                    else {
                        if (array[i] == 1) {
                            System.out.print("x^" + (n - i));
                        } else {
                            System.out.print(array[i] + "x^" + (n - i));
                        }
                    }
                }else {

                    if (n - i == 0) {
                        System.out.print("+" + array[i]);
                    }else if( n-i == 1){
                        if (array[i] == 1) {
                            System.out.print("+x");
                        } else {
                            System.out.print("+" + array[i] + "x");
                        }
                    } else {
                        if (array[i] == 1) {
                            System.out.print("+x^" + (n - i));
                        } else {
                            System.out.print("+" + array[i] + "x^" + (n - i));
                        }
                    }
                }

            }else if(array[i] < 0){

                if(n-i == 0){
                    System.out.print(array[i]);
                }else if(n-i==1){

                    if(array[i]==-1){
                        System.out.print("-x");
                    }else{
                        System.out.print(array[i]+"x");
                    }

                }else{

                    if(array[i]==-1){
                        System.out.print("-x^"+(n-i));
                    }else{
                        System.out.print(array[i]+"x^"+(n-i));
                    }
                }
            }
        }

    }
}
