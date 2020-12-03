package yxxy.c_024;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * 有N张火车票，每张票都有一个编号
 * 同时有10个窗口对外售票
 *请写一个模拟程序
 * @author: yanxiaotian
 * @create: 2020-12-03 13:52
 **/
public class TicketsSeller1 {
    static List<String> tickets=new ArrayList<>();
    static {
        for(int i=0; i<100; i++){
            tickets.add("ticket"+i);
        }
    }

    public static void main(String[] args) {
        for(int i=0; i<10; i++){
            new Thread(()->{
                while(tickets.size()>0){
                    System.out.println("销售了"+tickets.remove(0));
                }
            }).start();
        }
    }

}
