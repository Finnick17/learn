package per.yyz.single;

/**
 * @author: YYZ
 * @date: 2020-12-08 11:57
 * @description 用到的时候才实例化——懒汉式
 */
public class Singleton03 {

    public static Singleton03 INSTANCE;

    private Singleton03() {

    }

    public static Singleton03 getInstance() {
        if (INSTANCE == null) {
            try {
                //模拟延迟，会出现数据不一致的问题
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Singleton03();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton03.getInstance().hashCode());
            }).start();
        }
    }

}
