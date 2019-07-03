package rock.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: lizhihua16
 * @Email: lizhihua6@jd.com
 * @Create: 2019-01-14 17:16
 */
public class LongAdderTest {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        ReentrantLock reentrantLock1 = new ReentrantLock();
        reentrantLock.tryLock();
        reentrantLock1.tryLock();
        reentrantLock.tryLock();
        System.out.println("tryLock");
        reentrantLock.unlock();
        reentrantLock1.unlock();
    }
}
