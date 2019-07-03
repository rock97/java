package rock.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2019-06-14 23:05
 */
public class SemaphoreTest {
    private final static int threadCount = 100;
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(10);//控制只能有20个线程同时处理
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            System.out.println("threadNum = " + threadNum);
            service.execute(()->{
                try {
                    if(semaphore.tryAcquire(5, TimeUnit.MICROSECONDS)) {//控制只能有10个进程进来
                       // semaphore.acquire(2);//获取一个许可
                        test(threadNum);
                        semaphore.release(5);//释放一个许可
                    }
                } catch (InterruptedException e) {

                }finally {
                }
            });
        }
        service.shutdown();
        System.out.println("finish");
    }
    private static void  test(int a) throws InterruptedException {
        Thread.sleep(10);
        System.out.println(a);
        Thread.sleep(10);
    }
}
