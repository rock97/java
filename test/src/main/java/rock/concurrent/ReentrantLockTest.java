package rock.concurrent;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    private final static int threadCount = 1000;
    private  static int count = 0;
    private  final static DateTimeFormatter format = DateTimeFormatter.ofPattern("_yyyy-MM-dd_HH:mm:ss");

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        ReentrantLock reentrantLock = new ReentrantLock();
        GenIdByKey gen = new GenIdByKey();
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();



        for (int i = 0; i < threadCount; i++) {
           // Thread.sleep(100);
            service.execute(()->{
                LocalDateTime arrivalDate  = LocalDateTime.now();
                String landing = arrivalDate.format(format);
                Integer andIncrementByKey = gen.getAndIncrementByKey(landing);
                System.out.println(landing + " = " + andIncrementByKey);
                String s = UUIDUtil.creatUUID();
                System.out.println("s = " + s);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
        }
        service.shutdown();
    }
    private static void  test(int a) throws InterruptedException {
        count++;
        Thread.sleep(1000);
    }
}
