package rock.acm.dp;

import com.alibaba.fastjson.JSON;
import com.sun.deploy.util.StringUtils;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2018-11-23 23:04
 */
public class Main7 {
    private String str = "1231";
    public static void main(String[] args) {

        Scanner cin=new Scanner(System.in);
        int n = cin.nextInt();
        int[]array = new int[10];
        int[]length = new int[10];


        for (int i = 0; i < n; i++) {
            array[i] = cin.nextInt();
        }


        int len = 0;
        length[len] = array[0];

        for (int i1 = 1; i1 < n; i1++) {
            if(array[i1] >= length[len]){
                length[++len] = array[i1];
            }else{
               // int a = Arrays.binarySearch(length,length[len]);
                for (int i = 0; i <= len; i++) {
                  //

                }
            }
        }

        System.out.println(JSON.toJSONString(length));

    }

}
