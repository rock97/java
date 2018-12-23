package rock.dapper;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2018-12-23 22:44
 */
public class TestService {
    public void sout(){
        String value = ThreadLocalUtil.getThreadLocal();
        System.out.println("value = " + value);
    }
}
