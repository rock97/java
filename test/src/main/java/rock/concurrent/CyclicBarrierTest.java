package rock.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2019-06-14 23:19
 */
public class CyclicBarrierTest {
    private final static int threadCount = 100;
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            //System.out.println("threadNum = " + threadNum);
            service.execute(()->{
                try {

                    rece(threadNum);

                } catch (InterruptedException e) {

                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                } finally {
                }
            });
        }
        service.shutdown();
        System.out.println("finish");
    }
    private static void  rece(int threadNum) throws BrokenBarrierException, InterruptedException {
        Thread.sleep(1000);
        System.out.println("cyclicBarrier is rece "+ threadNum);
        cyclicBarrier.await();
        System.out.println("cyclicBarrier is finash "+ threadNum);
    }
}
