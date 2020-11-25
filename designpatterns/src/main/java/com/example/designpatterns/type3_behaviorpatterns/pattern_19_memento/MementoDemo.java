package com.example.designpatterns.type3_behaviorpatterns.pattern_19_memento;

/**
 * @description: 备忘录模式示例类
 * 备忘录（Memento）模式的定义：在不破坏封装性的前提下，捕获一个对象的内部状态，
 * 并在该对象之外保存这个状态，以便以后当需要时能将该对象恢复到原先保存的状态。该模式又叫快照模式。
 *
 * 备忘录模式是一种对象行为型模式，其主要优点如下。
 * 提供了一种可以恢复状态的机制。当用户需要时能够比较方便地将数据恢复到某个历史的状态。
 * 实现了内部状态的封装。除了创建它的发起人之外，其他对象都不能够访问这些状态信息。
 * 简化了发起人类。发起人不需要管理和保存其内部状态的各个备份，所有状态信息都保存在备忘录中，
 * 并由管理者进行管理，这符合单一职责原则。
 *
 * 备忘录模式的主要角色如下。
 * 发起人（Originator）角色：记录当前时刻的内部状态信息，提供创建备忘录和恢复备忘录数据的功能，实现其他业务功能，它可以访问备忘录里的所有信息。
 * 备忘录（Memento）角色：负责存储发起人的内部状态，在需要的时候提供这些内部状态给发起人。
 * 管理者（Caretaker）角色：对备忘录进行管理，提供保存与获取备忘录的功能，但其不能对备忘录的内容进行访问与修改。
 * @author: yanxiaotian
 * @create: 2020-11-25 14:21
 **/
public class MementoDemo {
    public static void main(String[] args) {
        //创建发起人和管理人
        Originator originator=new Originator();
        Caretaker caretaker=new Caretaker();
        originator.setState("S0");
        System.out.println(originator.getState());
        //发起人创建备忘录
        Memento memento0=originator.createMemento();
        //将备忘录交给管理人保管
        caretaker.setMemento(memento0);
        //更新发起人的状态并输出
        originator.setState("S1");
        System.out.println(originator.getState());
        //从管理人那里拿到备忘录，然后恢复给发起人
        originator.restoreMemento(caretaker.getMemento());
        System.out.println(originator.getState());
    }
}
//备忘录类
class Memento{
    String state;
    Memento(String state){
        this.state=state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

//发起人
class Originator{
    String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento createMemento(){
        return new Memento(this.state);
    }

    public void restoreMemento(Memento memento){
        setState(memento.getState());
    }
}

//管理者
class Caretaker{
    Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
