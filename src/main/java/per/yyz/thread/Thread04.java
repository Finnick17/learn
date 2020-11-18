package per.yyz.thread;

import lombok.SneakyThrows;

/**
 * @Author: YYZ
 * @CreateTime: 2020-11-18 23:37
 * @Description:
 */
public class Thread04 implements Runnable {

    private int ticket = 10;

    public static void main(String[] args) {
        Thread04 thread04 = new Thread04();

        new Thread(thread04, "张三").start();
        new Thread(thread04, "李四").start();
        new Thread(thread04, "王五").start();
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            if (ticket <= 0) {
                break;
            }
            Thread.sleep(200);
            System.out.println(Thread.currentThread().getName() + "购买了第" + ticket-- + "张票");
        }
    }


}
