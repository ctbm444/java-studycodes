package yxxy.c_022;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @description: 不使用ThreadLocal时演示类，不同线程会同时更改同一对象的成员变量
 * @author: yanxiaotian
 * @create: 2020-12-03 10:30
 **/
public class ThreadLocal1 {
    volatile static Person person=new Person("张三");

    public static void main(String[] args) {
        new Thread(()->{
            for(int i=0;i<5;i++){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(person.name);
            }
        }).start();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            person.name="李四";
        }).start();
    }
}

class Person{
    String name;

    public Person(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}