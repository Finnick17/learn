package per.yyz.single;

import java.util.Optional;

/**
 * @author: YYZ
 * @date: 2020-12-08 15:34
 * @description 懒汉式——使用synchronize同步代码块
 */
public class Singleton05 {

    private static Singleton05 INSTANCE;

    private Singleton05() {

    }

    public static Singleton05 getInstance() {
        //这样虽然同步住了，但性能不好，每次访问该方法都会进入同步锁，需要在判断逻辑内部进行同步
        synchronized (Singleton05.class) {
            if (!Optional.ofNullable(INSTANCE).isPresent()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new Singleton05();
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
