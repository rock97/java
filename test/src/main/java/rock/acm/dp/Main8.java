package rock.acm.dp;

import com.alibaba.fastjson.JSON;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2018-11-29 21:46
 */
public class Main8 {
    static private int[][] array = new int[8][40];
    public static void main(String[] args) {
        for (int i = 0; i <= 7; i++) {
            array[i][0] = i;
        }
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 28; j++) {
                if( j<i ){
                    array[i][j] = array[i-1][j];
                }else {
                    array[i][j] = array[i-1][j] + array[i-1][j- i];
                }
            }
        }
        for (int i = 0; i <= 7; i++) {
            System.out.println(JSON.toJSONString(array[i]));
        }
    }

}
