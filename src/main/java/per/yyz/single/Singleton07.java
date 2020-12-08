package per.yyz.single;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: YYZ
 * @date: 2020-12-08 15:46
 * @description 懒汉式 使用Reentrant
 */
public class Singleton07 {
    private static ReentrantLock lock = new ReentrantLock();

    private static Singleton07 INSTANCE;

    private Singleton07() {
    }

    public static Singleton07 getInstance() {
        if (INSTANCE == null) {
            lock.lock();
            try {
                if (INSTANCE == null) {
                    Thread.sleep(1000);
                    INSTANCE = new Singleton07();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(getInstance().hashCode())).start();
        }
    }
}
