package yxxy.c_004;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @author: yanxiaotian
 * @create: 2020-11-17 16:15
 **/
public class RunnableTest implements Runnable {

    private static boolean flag = true;

//    private static synchronized void testSyncMethod() { // 注意static修改的同步方法，监视器=class
//        for (int i = 0; i < 100; i++) {
//            System.out.println("testSyncMethod:" + i);
//        }
//    }

    private void testSyncMethod() {
        /*synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.println("testSyncMethod:" + i);
            }
        }*/

        synchronized (RunnableTest.class) {
            for (int i = 0; i < 100; i++) {
                System.out.println("testSyncMethod:" + i);
            }
        }
    }

    private void testSyncBlock() {

        /*synchronized (this) { // 注意this做为监视器．它与class分别是二个不同监视器．不会存在class被获取，this就要等的现象．这也是我以前关于监视器的一个误区．
            for (int i = 0; i < 100; i++) {
                System.out.println("testSyncBlock:" + i);
            }
        }
*/
         synchronized (RunnableTest.class) { // 显示使用获取class做为监视器．它与static synchronized method隐式获取class监视器一样．
            for (int i = 0; i < 100; i++) {
                System.out.println("testSyncBlock:" + i);
            }
         }
    }

    public void run() {

        // flag是static的变量．所以，不同的线程会执行不同的方法,只有这样才能看到不同的锁定效果．
        if (flag) {
            flag = false;
            testSyncMethod();
        } else {
            flag = true;
            testSyncBlock();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(2);
        RunnableTest rt = new RunnableTest();
        RunnableTest rt1 = new RunnableTest();
        exec.execute(rt);
        exec.execute(rt1);
        exec.shutdown();
    }
}