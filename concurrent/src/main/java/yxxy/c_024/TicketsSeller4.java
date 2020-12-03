package yxxy.c_024;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @description:
 * 有N张火车票，每张票都有一个编号
 * 同时有10个窗口对外售票
 *请写一个模拟程序
 *
 * 使用ConcurrentLinkedQueue
 * @author: yanxiaotian
 * @create: 2020-12-03 13:52
 **/
public class TicketsSeller4 {
    static Queue<String> tickets=new ConcurrentLinkedQueue<>();
    static {
        for(int i=0; i<100; i++){
            tickets.add("ticket"+i);
        }
    }

    public static void main(String[] args) {
        for(int i=0; i<10; i++){
            new Thread(()->{
                while(tickets.size()>0){
                    String ticket=tickets.poll();
                    if(ticket==null) break;
                    System.out.println("销售了"+ticket);
                }
            }).start();
        }
    }

}
