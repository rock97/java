package rock.acm.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2018-11-23 14:49
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();
        int t,sum=0;
        List<Integer> list =  new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {

            t = cin.nextInt();

            if(map.get(t)==null){

                if(map.size()==n){
                    map.remove(list.get(0));
                    list.remove(0);
                }

                list.add(t);
                map.put(t,1);
                sum++;
            }
        }
        System.out.print(sum);
    }
}
