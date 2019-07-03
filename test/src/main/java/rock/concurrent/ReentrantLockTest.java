package rock.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2019-06-14 22:41
 */
public class ReentrantLockTest {
    private final static int threadCount = 200;
    private  static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        ReentrantLock reentrantLock = new ReentrantLock();
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
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
