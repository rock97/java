package rock.leetcode;

import java.io.BufferedReader;
import java.nio.channels.MulticastChannel;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2018-12-04 17:43
 */
public class Main1 {
    public static void main(String[] args) {
        System.out.println(multiply("6547657687685674564354355446546546746453654675765877697698767656546546546546","988749589440450454058877878786785676563443234243245354654657657687686575665435345434968954695486945876859476945897549"));
        System.out.println(reverseWords("   a   b "));
    }
    public static String reverseWords(String s){
        if(" ".equals(s) || "".equals(s)){
            return "";
        }
        String[] array = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--) {
            if(array[i].equals(""))continue;
            sb.append(array[i].trim());
            if(i!=0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
    public static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        char[]arrar_1 =  num1.toCharArray();
        char[]arrar_2 =  num2.toCharArray();
        int[] result_1 = new int[250];
        int[] result_2 = new int[250];
        for (int i = arrar_2.length - 1; i >= 0; i--) {
            for (int j = arrar_1.length - 1; j >= 0; j--) {
                result_2[i+j+1] = result_2[i+j+1]+(arrar_1[j]-'0')*(arrar_2[i]-'0');
                result_2[i+j] = result_2[i+j+1] / 10;
                result_2[i+j+1] = result_2[i+j+1] % 10;

            }
            for (int k = result_2.length - 1; k >= 0; k--) {
                result_1[k] += result_2[k];
                if(k!=0)
                result_1[k-1] += result_1[k]/10;
                result_1[k] = result_1[k] % 10;
                result_2[k] = 0;
            }

        }


        StringBuilder sb = new StringBuilder();

        if(result_1[0]!=0){
            sb.append(result_1[0]);
        }
        for (int i = 1 ; i < arrar_1.length + arrar_2.length; i++) {
            sb.append(result_1[i]);
        }

        return sb.toString();
    }

}
