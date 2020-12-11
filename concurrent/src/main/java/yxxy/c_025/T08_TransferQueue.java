package yxxy.c_025;

import java.util.concurrent.LinkedTransferQueue;

/**
 * @description:
 * @author: yanxiaotian
 * @create: 2020-12-08 16:49
 **/
public class T08_TransferQueue {
    public static void main(String[] args) {
        LinkedTransferQueue<String> strs=new LinkedTransferQueue();
        strs.put("aaa");
        new Thread(() -> {
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

