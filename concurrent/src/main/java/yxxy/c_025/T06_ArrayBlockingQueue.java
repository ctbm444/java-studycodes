package yxxy.c_025;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @description: ArrayBlockingQueue
 * @author: yanxiaotian
 * @create: 2020-12-08 16:25
 **/
public class T06_ArrayBlockingQueue {
    static BlockingQueue<String> strs = new ArrayBlockingQueue<>(10);
    static Random random = new Random();

    public static void main(String[] args) throws Exception{
        for(int i=0; i<10; i++){
            strs.put("a" + random.nextInt(100));
        }

        strs.put("abc");//放满以后就会阻塞，所以不会执行下面的语句
        System.out.println(strs);
    }
}
