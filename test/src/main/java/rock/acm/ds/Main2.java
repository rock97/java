package rock.acm.ds;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2018-11-29 19:00
 */
public class Main2 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        System.out.println(sum(6,array,array.length));
    }

    private static int lowbit(int x){
        return x & -x;
    }

    static int sum(int x, int[] c, int n)

    {
        int ret = 0;
        for ( ; x > 0; ret += c[x], x -= lowbit(x));
        return ret;
    }

    static void update(int x, int val, int[] c, int n)
    {
        for ( ; x <= n; c[x] += val, x += lowbit(x));
    }
}
