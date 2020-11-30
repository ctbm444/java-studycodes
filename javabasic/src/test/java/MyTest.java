import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @description: test类
 * @author: yanxiaotian
 * @create: 2020-11-30 10:44
 **/
public class MyTest {
    public static void main(String[] args) throws Exception {
        /*Runnable r1=()-> System.out.println("abc");
        try(FileInputStream input=new FileInputStream("file.txt")){
            int data=input.read();
            while (data!=-1){
                System.out.println((char)data);
                data=input.read();
            }
        }*/
        /*Predicate<MyTest> predicate=(MyTest m)->m.equals(null);
        System.out.println(MyTest.method().get());*/
        MyTest.print1();
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
