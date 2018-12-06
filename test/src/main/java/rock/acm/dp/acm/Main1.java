package rock.acm.dp.acm;

import java.util.Scanner;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2018-11-29 20:33
 */
public class Main1 {
    public static void main(String[] args) {
        int[] prime = new int[2800];
        prime[0] = 1;
        for (int i = 3; i < prime.length; i+=2) {
            if (prime[i] == 0) {
                for (int j = i*2; j < prime.length; j += i) {
                    prime[j] = 1;
                }
            }
        }
        int[] length = new int[256];


        Scanner cin = new Scanner(System.in);
        String word = cin.nextLine();
        char[] array = word.toCharArray();
        for (int i = 0; i < array.length; i++) {
            length[array[i]]++;
        }
        int max = -1;
        int min = 999999999;
        for (int i = 0; i < length.length; i++) {
            if(length[i]==0) continue;
            min =  Math.min(length[i],min);
            max = Math.max(length[i],max);
        }
        if((max - min)%2 ==0 && (max - min)!=2){
            System.out.println("No Answer\n" +"0");
        }else if(prime[max - min] == 0){
            System.out.println("Lucky Word");
            System.out.println(max - min);
        }else{
            System.out.println("No Answer\n" +"0");
        }
    }
}
