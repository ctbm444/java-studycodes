import java.io.FileInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @description: test类
 * @author: yanxiaotian
 * @create: 2020-11-30 10:44
 **/
public class MyTest {
    public static void main(String[] args) throws Exception {
        int a=1;
        a >>>= 1;
        System.out.println(a);
        int m=0;
        for(;;){
            m++;
            System.out.println(m);
            if(m==10){
                break;
            }
        }
        Comparator comparator
                =(Comparator<Map.Entry<String,Object>> &Serializable) (o1,o2) -> o1.getKey().compareTo(o2.getKey());
        Comparator c=(o1,o2) -> Integer.parseInt(o1.toString())-Integer.parseInt(o2.toString());
    }

    public static Supplier<Integer> method(){
        int m=3;
        return new Supplier<Integer>(){
            @Override
            public Integer get() {
                System.out.println(m);
                return m;
            }
        };
    }

    public static void print(){
        String location="World";
        Runnable r=new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello "+location);
            }
        };
        r.run();
    }

    public static void print1(){
        String location="World";
        Runnable r=()-> System.out.println("Hello "+location);
        r.run();
    }
}
