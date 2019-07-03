package rock.concurrent;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2019-06-15 9:35
 */
public class ReentrantReadWriteLockTest {
    private final static int threadCount = 200;
    private  static int count = 0;
    private final Map<String , Date> map = new TreeMap<>();
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        ReentrantLock reentrantLock = new ReentrantLock();
        for (int i = 0; i < threadCount; i++) {
            System.out.println("count = " + count);
            service.execute(()->{

                try {
                    reentrantLock.lock();
                    count++;
                    System.out.println("reentrantLock count = " + count);
                } finally {

                    reentrantLock.unlock();
                }

            });
        }
        service.shutdown();
        System.out.println("finish");
    }
    private static void  test(int a) throws InterruptedException {
        count++;
        Thread.sleep(1000);
    }
}
