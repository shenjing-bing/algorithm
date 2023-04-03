package com.xxx.complexity;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

/**
 * @author shenjingbin
 * @date 2021/9/23
 */
public class TimeUtil {
    private static final SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss.SSS");

    public interface Task {
        void execute();
    }

    public static void test(String title, Task task) {
        if (task == null) return;
        title = (title == null) ? "" : ("【" + title + "】");
        System.out.println(title);
        System.out.println("开始：" + fmt.format(LocalDateTime.now()));
        long begin = System.currentTimeMillis();
        task.execute();
        long end = System.currentTimeMillis();
        System.out.println("结束：" + fmt.format(LocalDateTime.now()));
        double delta = (end - begin) / 1000.0;
        System.out.println("耗时：" + delta + "秒");
        System.out.println("-------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-1));
    }
}
