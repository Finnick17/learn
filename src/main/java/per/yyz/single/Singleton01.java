package per.yyz.single;

/**
 * @author: YYZ
 * @date: 2020-12-08 11:19
 * @description 类加载的时候就实例化一个实例对象，保证JVM线程安全——饿汉式
 */
public class Singleton01 {

    private static final Singleton01 INSTANCE = new Singleton01();

    private Singleton01() {
    }

    public static Singleton01 getInstance() {
        return INSTANCE;
    }


    public static void main(String[] args) {
        Singleton01 instance01 = Singleton01.getInstance();
        Singleton01 instance02 = Singleton01.getInstance();
        System.out.println(instance01 == instance02);
    }
}
