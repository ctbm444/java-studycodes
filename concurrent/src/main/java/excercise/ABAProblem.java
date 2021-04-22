package excercise;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @description: CAS的ABA问题解决
 * @author: yanxiaotian
 * @create: 2021-04-22 14:43
 **/
public class ABAProblem {
    public static void main(String[] args) {

        AtomicInteger a=new AtomicInteger(1);
        a.compareAndSet(1,2);
        a.compareAndSet(2,1);
        System.out.println("a="+a.get());
        boolean isSuccess=a.compareAndSet(1,2);
        System.out.println(isSuccess);


        //用AtomicStampedReference执行cas操作
        AtomicInteger a1=new AtomicInteger(1);
        AtomicInteger a2=new AtomicInteger(2);
        AtomicStampedReference<AtomicInteger> reference=new AtomicStampedReference<>(a1,0);
        System.out.println(reference.getReference()+","+reference.getStamp());
        reference.compareAndSet(a1,a2,reference.getStamp(),reference.getStamp()+1);
        System.out.println(reference.getReference()+","+reference.getStamp());
        reference.compareAndSet(a2,a1,reference.getStamp(),reference.getStamp()+1);
        System.out.println(reference.getReference()+","+reference.getStamp());
        System.out.println("new value="+reference.getReference());
        boolean flag=reference.compareAndSet(a1,a2,0,1);
        System.out.println(flag);
    }
}
