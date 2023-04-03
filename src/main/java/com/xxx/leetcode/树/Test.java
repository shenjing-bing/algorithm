package 树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shenjingbin
 * @date 2021/11/21
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> objects = new ArrayList<>();
        objects.add(1);
        objects.add(2);
        objects.add(3);
        objects.add(4);
        List<Integer> integers = objects.subList(0, 2);
        System.out.println(integers);
        System.out.println(integers.subList(0, 1));
    }
}
