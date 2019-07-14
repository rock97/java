package rock.concurrent;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2019-07-14 13:53
 */
public class DealLockTest {
    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();

        Thread threadA = new Thread(){
            @Override
            public void run() {
                synchronized (a){
                    System.out.println("threadA get lock a");
                    try {
                        Thread.sleep(1000L);
                        synchronized (b){
                            System.out.println("threadA get lock b");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };


        Thread threadB = new Thread(){
            @Override
            public void run() {
                synchronized (b){
                    System.out.println("threadB get lock b");
                    try {
                        Thread.sleep(1000L);
                        synchronized (a){
                            System.out.println("threadB get lock a");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        threadA.start();
        threadB.start();
    }
}
