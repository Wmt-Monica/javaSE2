package IO;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 字节数组流:
 * 1.创建源 ：字节数组流不要太大
 * 2.选择流
 * 3.操作
 * 4.释放资源：可以不用处理，因为此为空方法
 */
public class ByteArrayDemo1 {
    public static void main(String[] args) {
        //1.选择源
        byte[] src = "WMT is very beauty!".getBytes();  //getBytes()将字符串转换成字节数组

        //2.数据流的选择
        InputStream input = null;
        //选择字节数组输入流
        /*注意：使用BufferedInputStream/BufferedOutputStream相当于是属于一种修饰类，
               采取使用JVM虚拟机来通知垃圾回收机制来释放资源，使其性能更好
               运行速度更快
         */
        input = new BufferedInputStream( new ByteArrayInputStream(src));

        int length = -1;
        byte[] flush = new byte[2];
        try {
            while ((length = input.read(flush)) != -1){
                System.out.print(new String(flush,0,length));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
