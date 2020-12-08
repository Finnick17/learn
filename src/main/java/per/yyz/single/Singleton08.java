package per.yyz.single;

/**
 * @author: YYZ
 * @date: 2020-12-08 15:55
 * @description 懒汉式——通过静态内部类的方式实现
 */
public class Singleton08 {

    private Singleton08() {
    }

    public static Singleton08 getInstance() {
        return Singleton08Holder.INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(getInstance().hashCode())).start();
        }
    }

    static class Singleton08Holder {
        private static final Singleton08 INSTANCE = new Singleton08();
    }

}
