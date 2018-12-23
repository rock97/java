package rock.dapper;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2018-12-23 21:24
 */
public class ThreadLocalUtil {
    public static ThreadLocal<String> threadLocal = new ThreadLocal();

    public static String getThreadLocal() {
        return threadLocal.get();
    }

    public static void setThreadLocal(String trachId) {
        if(threadLocal.get()==null){
            threadLocal.set(trachId);
        }
    }
}
