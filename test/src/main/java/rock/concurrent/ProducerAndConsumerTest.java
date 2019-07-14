package rock.concurrent;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2019-07-14 14:17
 */
public class ProducerAndConsumerTest {
    private static volatile Integer count = 10;
    private static final  Integer FULL = 10;
    private static  String LOCK = "lock";

    public static void main(String[] args) {
        ProducerAndConsumerTest test = new ProducerAndConsumerTest();
        new  Thread(test.new Producer()).start();
        new  Thread(test.new Consumer()).start();
        new  Thread(test.new Producer()).start();
        new  Thread(test.new Consumer()).start();
    }
    class Producer implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LOCK){
                    while (count == FULL){
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println("Name = " + Thread.currentThread()
                            .getName()+" 生产者 count= "+count);
                    LOCK.notifyAll();
                }
            }
        }
    }

    class Consumer implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LOCK){
                    while (count == 0){
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {

                        }
                    }
                    count--;
                    System.out.println("Name = " + Thread.currentThread()
                            .getName()+" 消费者 count= "+count);
                    LOCK.notifyAll();
                }
            }
        }
    }
}
