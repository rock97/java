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
        List<Integer> list0 = new ArrayList<Integer>();list0.add(2);
        List<Integer> list1 = new ArrayList<Integer>();list1.add(3);list1.add(4);
        List<Integer> list2 = new ArrayList<Integer>();list2.add(6);list2.add(5);list2.add(7);
        List<Integer> list3 = new ArrayList<Integer>();list3.add(4);list3.add(1);list3.add(8);list3.add(3);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        list.add(list0);
        list.add(list1);
        list.add(list2);
        list.add(list3);
        System.out.println(leetCode.minimumTotal(list));
    }
}
