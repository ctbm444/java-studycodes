package yxxy.c_018;

/**
 * @description: 不要用字符串常量作为锁定对象,下面的例子中m1和m2锁定的是同一个对象。
 * 而且如果类库里如果锁定了"abc"，而你的代码也锁定了"abc",会导致死锁阻塞。
 * @author: yanxiaotian
 * @create: 2020-12-01 17:16
 **/
public class T {
    String s1="abc";
    String s2="abc";
    void m1(){
        synchronized (s1){

        }
    }
    void m2(){
        synchronized (s2){

        }
    }
}
