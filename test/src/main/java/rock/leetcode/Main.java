package rock.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2018-12-04 17:43
 */
public class Main {
    public static void main(String[] args) {
        LeetCode leetCode = new LeetCode();
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        List<Integer> list3 = new ArrayList<Integer>();
        List<Integer> list4 = new ArrayList<Integer>();
        list1.add(2);
        list2.add(3);
        list2.add(4);
        list3.add(6);
        list3.add(5);
        list3.add(7);
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);

        System.out.println(leetCode.minimumTotal2(lists));
    }
}
