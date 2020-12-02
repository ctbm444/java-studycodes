package yxxy.c_008;

import java.util.concurrent.TimeUnit;

/**
 * @description: 脏读 对业务写方法加锁，对业务读方法不加锁，会导致dirtyread
 * @author: yanxiaotian
 * @create: 2020-12-01 11:20
 **/
public class Account {
    String name;
    Double balance;

    public synchronized void set(String name,Double balance){
        this.name=name;
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance=balance;
    }

    public Double get(String name){
        return this.balance;
    }

    public static void main(String[] args) {
        Account acount=new Account();
        new Thread(()->acount.set("张三",100d)).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(acount.get("张三"));
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(acount.get("张三"));
    }
}
