package yxxy.c_024;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * 有N张火车票，每张票都有一个编号
 * 同时有10个窗口对外售票
 *请写一个模拟程序
 * 就算A操作和B操作都是同步的，但是不能保证A和B的复合操作也是同步的。所以需要自己进行同步。
 * 本例中判断size和remove操作必须是一个整体的原子操作。
 * @author: yanxiaotian
 * @create: 2020-12-03 13:52
 **/
public class TicketsSeller3 {
    static List<String> tickets=new LinkedList<>();
    static {
        for(int i=0; i<100; i++){
            tickets.add("ticket"+i);
        }
    }

    public static void main(String[] args) {
        for(int i=0; i<10; i++){
            new Thread(()->{
                while(true){
                    synchronized(tickets){
                        if(tickets.size()==0) break;
                        System.out.println("销售了"+tickets.remove(0));
                    }
                }
            }).start();
        }
    }

}
