package per.yyz.thread;

/**
 * @Author: YYZ
 * @CreateTime: 2020-11-18 23:35
 * @Description:
 */
public class Thread03 implements Runnable {

    public static void main(String[] args) {

        Thread03 thread03 = new Thread03();
        new Thread(thread03).start();

        for (int i = 0; i < 1000; i++) {
            System.out.printf("**主线程输出**%d \n", i);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.printf("--子线程输出--%d \n", i);
            ;
        }
    }
}
