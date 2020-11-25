package com.example.designpatterns.type3_behaviorpatterns.pattern_21_visitor;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 访问者模式示例类
 * 访问者（Visitor）模式的定义：将作用于某种数据结构中的各元素的操作分离出来封装成独立的类，
 * 使其在不改变数据结构的前提下可以添加作用于这些元素的新的操作，为数据结构中的每个元素提供多种访问方式。
 * 它将对数据的操作与数据结构进行分离，是行为类模式中最复杂的一种模式。
 *
 * 访问者（Visitor）模式是一种对象行为型模式，其主要优点如下。
 * 扩展性好。能够在不修改对象结构中的元素的情况下，为对象结构中的元素添加新的功能。
 * 复用性好。可以通过访问者来定义整个对象结构通用的功能，从而提高系统的复用程度。
 * 灵活性好。访问者模式将数据结构与作用于结构上的操作解耦，使得操作集合可相对自由地演化而不影响系统的数据结构。
 * 符合单一职责原则。访问者模式把相关的行为封装在一起，构成一个访问者，使每一个访问者的功能都比较单一。
 *
 * 访问者（Visitor）模式的主要缺点如下。
 * 增加新的元素类很困难。在访问者模式中，每增加一个新的元素类，都要在每一个具体访问者类中增加相应的具体操作，这违背了“开闭原则”。
 * 破坏封装。访问者模式中具体元素对访问者公布细节，这破坏了对象的封装性。
 * 违反了依赖倒置原则。访问者模式依赖了具体类，而没有依赖抽象类。
 *
 *访问者模式包含以下主要角色。
 * 抽象访问者（Visitor）角色：定义一个访问具体元素的接口，为每个具体元素类对应一个访问操作 visit() ，该操作中的参数类型标识了被访问的具体元素。
 * 具体访问者（ConcreteVisitor）角色：实现抽象访问者角色中声明的各个访问操作，确定访问者访问一个元素时该做什么。
 * 抽象元素（Element）角色：声明一个包含接受操作 accept() 的接口，被接受的访问者对象作为 accept() 方法的参数。
 * 具体元素（ConcreteElement）角色：实现抽象元素角色提供的 accept() 操作，其方法体通常都是 visitor.visit(this) ，另外具体元素中可能还包含本身业务逻辑的相关操作。
 * 对象结构（Object Structure）角色：是一个包含元素角色的容器，提供让访问者对象遍历容器中的所有元素的方法，通常由 List、Set、Map 等聚合类实现。
 * @author: yanxiaotian
 * @create: 2020-11-25 15:24
 **/
public class VisitorDemo {
    public static void main(String[] args) {
        ObjectStructure objectStructure=new ObjectStructure();
        objectStructure.add(new ConcreteElementA());
        objectStructure.add(new ConcreteElementB());
        objectStructure.accept(new ConcreteVisitorA());
        objectStructure.accept(new ConcreteVisitorB());
    }

}

//抽象访问者接口
interface Visitor{
    void visit(ConcreteElementA elementA);
    void visit(ConcreteElementB elmenetB);
}

//具体访问者A
class ConcreteVisitorA implements Visitor{

    @Override
    public void visit(ConcreteElementA elementA) {
        System.out.println("具体访问者A访问--"+elementA.operationA());
    }

    @Override
    public void visit(ConcreteElementB elmenetB) {
        System.out.println("具体访问者A访问--"+elmenetB.operationB());
    }
}

//具体访问者B
class ConcreteVisitorB implements Visitor{

    @Override
    public void visit(ConcreteElementA elementA) {
        System.out.println("具体访问者B访问--"+elementA.operationA());
    }

    @Override
    public void visit(ConcreteElementB elmenetB) {
        System.out.println("具体访问者B访问--"+elmenetB.operationB());
    }
}

//抽象元素接口
interface Element{
    void accept(Visitor visitor);
}

//具体元素类A
class ConcreteElementA implements Element{

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    String operationA(){
        return "具体元素A的操作";
    }
}

//具体元素类B
class ConcreteElementB implements Element{

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    String operationB(){
        return "具体元素B的操作";
    }
}


//对象结构类
class ObjectStructure{
    List<Element> list=new LinkedList<>();
    void accept(Visitor visitor){
        Iterator<Element> iterator=list.iterator();
        while (iterator.hasNext()){
            iterator.next().accept(visitor);
        }
    }
    void add(Element element){
        list.add(element);
    }
    void remove(Element element){
        list.remove(element);
    }
}