package per.yyz.single;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: YYZ
 * @date: 2020-12-08 15:57
 * @description
 */
public enum Singleton09 {
    INSTANCE;

    @Getter
    @Setter
    private Integer number;

    private Singleton09() {
        number = 12;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Singleton09.INSTANCE.getNumber().hashCode())).start();
        }
    }


}
