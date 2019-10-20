package rock.lambda;

import java.util.Arrays;
import java.util.List;

public class StreamTest {
    public static void main(String[] args) {
        //Lists是Guava中的一个工具类
        List<Integer> nums = Arrays.asList(1,null,3,4,null,6);
        long count = nums.stream().filter(num -> num != null && num > 2).count();
        System.out.println("count = " + count);
        final String[] lll = {""};
        nums.forEach(e-> System.out.println(e));
        System.out.println(lll[0]);
    }
}