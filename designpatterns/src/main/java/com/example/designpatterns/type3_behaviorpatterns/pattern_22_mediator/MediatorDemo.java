package com.example.designpatterns.type3_behaviorpatterns.pattern_22_mediator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @description: 中介者模式示例类
 * 中介者（Mediator）模式的定义：定义一个中介对象来封装一系列对象之间的交互，
 * 使原有对象之间的耦合松散，且可以独立地改变它们之间的交互。中介者模式又叫调停模式，它是迪米特法则的典型应用。
 *
 * 中介者模式是一种对象行为型模式，其主要优点如下。
 * 类之间各司其职，符合迪米特法则。
 * 降低了对象之间的耦合性，使得对象易于独立地被复用。
 * 将对象间的一对多关联转变为一对一的关联，提高系统的灵活性，使得系统易于维护和扩展。
 *
 * 其主要缺点是：中介者模式将原本多个对象直接的相互依赖变成了中介者和多个同事类的依赖关系。
 * 当同事类越多时，中介者就会越臃肿，变得复杂且难以维护。
 *
 * 中介者模式包含以下主要角色。
 * 抽象中介者（Mediator）角色：它是中介者的接口，提供了同事对象注册与转发同事对象信息的抽象方法。
 * 具体中介者（Concrete Mediator）角色：实现中介者接口，定义一个 List 来管理同事对象，协调各个同事角色之间的交互关系，因此它依赖于同事角色。
 * 抽象同事类（Colleague）角色：定义同事类的接口，保存中介者对象，提供同事对象交互的抽象方法，实现所有相互影响的同事类的公共功能。
 * 具体同事类（Concrete Colleague）角色：是抽象同事类的实现者，当需要与其他同事对象交互时，由中介者对象负责后续的交互。
 * @author: yanxiaotian
 * @create: 2020-11-25 16:13
 **/
public class MediatorDemo {
    public static void main(String[] args) {
        Mediator mediator=new ConcreteMediator();
        Colleague c1=new ColleagueA();
        Colleague c2=new ColleagueB();
        mediator.register(c1);
        mediator.register(c2);
        c1.send();
    }
}
//抽象同事类
abstract class Colleague{
    Mediator mediator;

    void setMediator(Mediator mediator){
        this.mediator=mediator;
    }
    //接收信息
    abstract void receive();
    //发送信息
    abstract void send();
}

//抽象中介类
abstract class Mediator{
    //注册信息
    abstract void register(Colleague colleague);
    //转发信息
    abstract void relay(Colleague colleague);
}

//具体同事类A
class ColleagueA extends Colleague{

    @Override
    void receive() {
        System.out.println("同事A接收到信息");
    }

    @Override
    void send() {
        System.out.println("同事A将自己的信息发送给中介");
        //调用中介将消息发给其他同事
        mediator.relay(this);
    }
}

//具体同事类B
class  ColleagueB extends Colleague{

    @Override
    void receive() {
        System.out.println("同事B接收到信息");
    }

    @Override
    void send() {
        System.out.println("同事B将自己的信息发送给中介");
        //调用中介将消息发给其他同事
        mediator.relay(this);
    }
}

//具体中介类
class ConcreteMediator extends Mediator{

    List<Colleague> list =new ArrayList<>();

    @Override
    void register(Colleague colleague) {
        if(!list.contains(colleague)){
            list.add(colleague);
            colleague.setMediator(this);
        }
    }

    @Override
    void relay(Colleague colleague) {
        Iterator<Colleague> iterator=list.iterator();
        while(iterator.hasNext()){
            Colleague c=iterator.next();
            if(!c.equals(colleague)){
                c.receive();
            }
        }
     }
}
