package cn.cxnxs.test;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        File file = new File("/home/pi/test/test.java");
        System.out.println("文件路径" + file.getAbsolutePath());
        System.out.println("父目录" + file.getParentFile());
    }
}
