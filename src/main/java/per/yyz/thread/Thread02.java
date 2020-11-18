package per.yyz.thread;

import lombok.AllArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.net.URL;

/**
 * @Author: YYZ
 * @CreateTime: 2020-11-18 23:23
 * @Description:
 */
@AllArgsConstructor
public class Thread02 extends Thread {

    private String url;
    private String name;

    public static void main(String[] args) {
        Thread02 thread01 = new Thread02("http://i0.hdslb.com/bfs/archive/0ae34a0c6347a0fd2ccc7f7f468d551ae4439326.jpg@380w_240h_100Q_1c.webp", "1.jpg");
        Thread02 thread02 = new Thread02("http://i0.hdslb.com/bfs/archive/75b12ea49e8d7cc6cd2d0ada331f9851fe5ad27c.jpg@380w_240h_100Q_1c.webp", "2.jpg");
        Thread02 thread03 = new Thread02("http://i0.hdslb.com/bfs/archive/cff4c19979a824d5aa7118665d858eee8242411d.jpg@380w_240h_100Q_1c.webp", "3.jpg");

        thread01.start();
        thread02.start();
        thread03.start();

    }

    @Override
    public void run() {
        Download download = new Download();
        download.download(url, name);
        System.out.printf("下载了文件为%s \n", name);
    }

    class Download {

        public void download(String url, String name) {
            try {
                FileUtils.copyURLToFile(new URL(url), new File(name));
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("真的回到这里吗");
            }
        }
    }
}
