package rock.dapper;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2018-12-12 20:43
 */
public class TestThreadLocal {
    public static void main(String[] args) {
        ThreadLocalUtil.setThreadLocal("34");
        TestService ts = new TestService();
        ts.sout();
    }
}
