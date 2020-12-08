package per.yyz.single;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: YYZ
 * @date: 2020-12-08 15:24
 * @description 懒汉式——添加synchronized同步方法
 */
public class Singleton04 {

    private static Singleton04 INSTANCE;
    private static ReentrantLock lock = new ReentrantLock();

    private Singleton04() {

    }

    public synchronized static Singleton04 getInstance() {
        lock.lock();
        try {
            if (!Optional.ofNullable(INSTANCE).isPresent()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new Singleton04();
            }
        } finally {
            lock.unlock();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(getInstance().hashCode())).start();
        }
    }
}
