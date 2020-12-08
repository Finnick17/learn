package per.yyz.single;

/**
 * @author: YYZ
 * @date: 2020-12-08 15:41
 * @description 懒汉式——synchronized同步代码块优化方案
 */
public class Singleton06 {

    public static Singleton06 INSTANCE;

    private Singleton06() {

    }

    public static Singleton06 getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton06.class) {
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Singleton06();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(getInstance().hashCode());
            }).start();
        }
    }
}
