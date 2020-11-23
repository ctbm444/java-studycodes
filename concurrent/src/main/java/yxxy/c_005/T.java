package yxxy.c_005;

import sun.util.logging.resources.logging;

import javax.swing.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Handler;
import java.util.logging.LogManager;

/**
 * @description:
 * @author: yanxiaotian
 * @create: 2020-11-17 16:49
 **/
public class T implements Runnable{
    public int count =0;
    @Override
    public synchronized void run() {
        count++;
        System.out.println(Thread.currentThread().getName()+",count="+count);
    }

    public static void main(String[] args) {
        T t=new T();
        for(int i=0;i<20;i++){
            new Thread(t,"t"+i).start();
        }

    }
}
