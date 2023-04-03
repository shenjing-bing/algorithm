package com.xxx.数据结构.二叉树.tree;

/**
 * @author shenjingbin
 * @date 2021/11/16
 */
public class Test {
    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();
        student1.a = 1;
        student1.st = student2;
        student2.a = 2;
        student2.st = student3;
        student3.a = 3;
        student2 = null;
        System.out.println(student1.st.a);
    }
}

class Student {
    public int a;
    public Student st;

}
