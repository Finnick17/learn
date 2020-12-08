package per.yyz.single;

/**
 * @author: YYZ
 * @date: 2020-12-08 11:26
 * @description 通过静态代码块实现饿汉式单例模式
 */
public class Singleton02 {

    public static final Singleton02 INSTANCE;

    static {
        INSTANCE = new Singleton02();
    }

    private Singleton02() {
    }

    public static Singleton02 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton02.getInstance().hashCode());
            }).start();
        }
    }
}
