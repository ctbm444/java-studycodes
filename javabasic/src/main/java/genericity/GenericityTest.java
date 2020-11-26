package genericity;

import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @description: 泛型demo示例类
 * @author: yanxiaotian
 * @create: 2020-11-26 10:56
 **/
public class GenericityTest<T> {

    public static void main(String[] args) {
        Generic<Number> g1=new Generic<Number>(1);
        Generic<Integer> g2=new Generic<Integer>(2);
        //showValue(Generic<U> obj)会导致两种对象不兼容。改为showValue(Generic<?> obj)就可以了
        g2.showKeyValue2(g1);

        Apple apple=new Apple();
        Person person=new Person();
        GenericityTest<Fruit> g3=new GenericityTest<Fruit>();
        //apple为fruit的子类，所以可以
        g3.show_1(apple);
        //这里编译出错，因为泛型已经指定了fruit。方法g3的show_1也要传入fruit类型
        //g3.show_1(person);

        //泛型方法的泛型和类的泛型无关。两种都可以
        g3.show_2(apple);
        g3.show_2(person);
        //泛型方法的泛型和类的泛型无关。两种都可以
        g3.show_3(apple);
        g3.show_3(person);

        //super 只能是Number及其父类型
        List<? super Number> list1=new ArrayList<Object>();
        //List<? super Number> list2=new ArrayList<Integer>();
        //extends 只能是Number子类型
        List<? extends Number> list3=new ArrayList<Integer>();
        //List<? extends Number> list4=new ArrayList<Object>();

        GenericityTest<BigDecimal> t1=new GenericityTest<BigDecimal>();
        System.out.println(t1.action(new Integer(1)));
        System.out.println(t1.action(new Double(3.4d)));
        //System.out.println(t1.action(new Object()));

        //Test<A,B extends A> 后面的泛型必须是前面的子类
        //Test<Apple,Fruit> m0=new Test<Apple, Fruit>();
        Test<Fruit,Apple> m1=new Test<Fruit, Apple>(new Fruit(),new Apple());
        System.out.println(m1.name);
    }

    public void show_1(T t){
        System.out.println(t.toString());
    }

    //在泛型类中声明一个泛型方法，使用泛型E，这种泛型E可以是任意类型。可以与T类型相同，也可以不同
    //由于泛型方法在声明时会声明泛型E，因此即使泛型类并未声明泛型，编译器也能正常识别泛型方法中的泛型。
    public <E> void show_3(E e){
        System.out.println(e.toString());
    }
    //泛型方法中声明的泛型T与泛型类中的T无关，可以是同种类型，也可以是不同类型。
    public <T> void show_2(T t){
        System.out.println(t.toString());
    }

    public <A extends Number& Serializable> Class action(A a){
       return a.getClass();
    }

}
class Fruit{
    public String toString(){
        return "fruit";
    }
}

class Apple extends Fruit{
    public String toString(){
        return "apple";
    }
}

class Person{
    public String toString(){
        return "person";
    }
}

class Test<A,B extends A>{
    String name;
    Test(A a,B b){
        name=a.toString()+b.toString();
    }
}
