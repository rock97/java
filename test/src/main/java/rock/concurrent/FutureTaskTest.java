package rock.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2019-06-15 9:52
 */
public class FutureTaskTest {
    static class myCallAble implements Callable<String>{

        @Override
        public String call() throws Exception {
            Thread.sleep(1000);
            System.out.println("call runing");
            return "myCallAble";
        }

    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
       ExecutorService executorService =  Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new myCallAble());
        Thread.sleep(9000);
        String result =  future.get();
        executorService.shutdown();
        System.out.println(result);
    }
}
