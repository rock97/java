package rock.concurrent;

import java.util.Random;
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
    private final static int threadCount = 2;
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);

            service.execute(()->{
                try {
                    test("A",100000);
                } catch (InterruptedException e) {

                }finally {
                    countDownLatch.countDown();
                }
            });

        service.execute(()->{
            try {
                test("B",10000);
            } catch (InterruptedException e) {

            }finally {
                countDownLatch.countDown();
            }
        });

        countDownLatch.await();
        service.shutdown();
        System.out.println("finish");
    }
    private static void  test(String name, int v) throws InterruptedException {
        for (int j = 0; j <10000;j++) {
            Thread.sleep(1);
            Random random = new Random();
            long ik = random.nextInt(1000);
            long  i= random.nextInt(10);
            v += i*ik;
            System.out.println(name + " = " + v);
        }
    }
}
