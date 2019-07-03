package rock.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2019-06-14 22:53
 */
public class CountDownLatchTest {
    private final static int threadCount = 200;
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            System.out.println("threadNum = " + threadNum);
            service.execute(()->{
                try {
                    test(threadNum);
                } catch (InterruptedException e) {

                }finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        service.shutdown();
        System.out.println("finish");
    }
    private static void  test(int a) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(a);
        Thread.sleep(1000);
    }
}
