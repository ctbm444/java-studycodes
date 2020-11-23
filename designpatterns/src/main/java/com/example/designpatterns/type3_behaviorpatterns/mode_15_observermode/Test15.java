package com.example.designpatterns.type3_behaviorpatterns.mode_15_observermode;

/**
 * @description: 观察者模式测试类
 * @author: yanxiaotian
 * @create: 2020-11-23 13:50
 **/
public class Test15 {
    public static void main(String[] args) {
        //公司前台
        Secretary secretary=new Secretary();
        //小明，偷看股市的员工
        StockObserver observer1=new StockObserver("小明",secretary);
        //小东，偷看nba的员工
        NbaObserver observer2=new NbaObserver("小东",secretary);
        //小明请前台帮忙放哨
        secretary.attach(observer1);
        //小东请前台帮忙放哨
        secretary.attach(observer2);

        //secretary.detach(observer1);
        //前台发现老板来了
        secretary.setStatus("老板来了!");
        //前台通知所有观察者
        secretary.notifyObservers();
    }
}
