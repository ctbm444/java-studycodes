package com.example.designpatterns.type3_behaviorpatterns.pattern_23_interpreter;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 解释器模式示例
 *
 * 解释器（Interpreter）模式的定义：给分析对象定义一个语言，并定义该语言的文法表示，
 * 再设计一个解析器来解释语言中的句子。也就是说，用编译语言的方式来分析应用中的实例。
 * 这种模式实现了文法表达式处理的接口，该接口解释一个特定的上下文。
 *
 * 这里提到的文法和句子的概念同编译原理中的描述相同，“文法”指语言的语法规则，而“句子”是语言集中的元素。
 * 例如，汉语中的句子有很多，“我是中国人”是其中的一个句子，可以用一棵语法树来直观地描述语言中的句子。
 *
 * 解释器模式是一种类行为型模式，其主要优点如下。
 * 扩展性好。由于在解释器模式中使用类来表示语言的文法规则，因此可以通过继承等机制来改变或扩展文法。
 * 容易实现。在语法树中的每个表达式节点类都是相似的，所以实现其文法较为容易。
 *
 * 解释器模式的主要缺点如下。
 * 执行效率较低。解释器模式中通常使用大量的循环和递归调用，当要解释的句子较复杂时，其运行速度很慢，且代码的调试过程也比较麻烦。
 * 会引起类膨胀。解释器模式中的每条规则至少需要定义一个类，当包含的文法规则很多时，类的个数将急剧增加，导致系统难以管理与维护。
 * 可应用的场景比较少。在软件开发中，需要定义语言文法的应用实例非常少，所以这种模式很少被使用到。
 *
 * 解释器模式包含以下主要角色。
 * 抽象表达式（Abstract Expression）角色：定义解释器的接口，约定解释器的解释操作，主要包含解释方法 interpret()。
 * 终结符表达式（Terminal Expression）角色：是抽象表达式的子类，用来实现文法中与终结符相关的操作，
 * 文法中的每一个终结符都有一个具体终结表达式与之相对应。
 * 非终结符表达式（Nonterminal Expression）角色：也是抽象表达式的子类，用来实现文法中与非终结符相关的操作，
 * 文法中的每条规则都对应于一个非终结符表达式。
 * 环境（Context）角色：通常包含各个解释器需要的数据或是公共的功能，一般用来传递被所有解释器共享的数据，后面的解释器可以从这里获取这些值。
 * 客户端（Client）：主要任务是将需要分析的句子或表达式转换成使用解释器对象描述的抽象语法树，然后调用解释器的解释方法，
 * 当然也可以通过环境角色间接访问解释器的解释方法。
 *
 * 用解释器模式设计一个“韶粵通”公交车卡的读卡器程序。
 *
 * 说明：假如“韶粵通”公交车读卡器可以判断乘客的身份，如果是“韶关”或者“广州”的“老人” “妇女”“儿童”就可以免费乘车，其他人员乘车一次扣 2 元。
 *
 * 分析：本实例用“解释器模式”设计比较适合，首先设计其文法规则如下。
 * <expression> ::= <city>的<person>
 * <city> ::= 韶关|广州
 * <person> ::= 老人|妇女|儿童
 *
 *  然后，根据文法规则按以下步骤设计公交车卡的读卡器程序的类图。
 *  定义一个抽象表达式（Expression）接口，它包含了解释方法 interpret(String info)。
 *  定义一个终结符表达式（Terminal Expression）类，它用集合（Set）类来保存满足条件的城市或人，
 * 并实现抽象表达式接口中的解释方法 interpret(Stringinfo)，用来判断被分析的字符串是否是集合中的终结符。
 *  定义一个非终结符表达式（AndExpressicm）类，它也是抽象表达式的子类，它包含满足条件的城市的终结符表达式
 * 对象和满足条件的人员的终结符表达式对象，并实现 interpret(String info) 方法，用来判断被分析的字符串
 * 是否是满足条件的城市中的满足条件的人员。
 * 最后，定义一个环境（Context）类，它包含解释器需要的数据，完成对终结符表达式的初始化，
 * 并定义一个方法 freeRide(String info) 调用表达式对象的解释方法来对被分析的字符串进行解释。其结构图如图 3 所示。
 * @author: yanxiaotian
 * @create: 2020-11-25 17:53
 **/
public class InterpreterDemo {
    public static void main(String[] args) {
        Context bus = new Context();
        bus.freeRide("韶关的老人");
        bus.freeRide("韶关的年轻人");
        bus.freeRide("广州的妇女");
        bus.freeRide("广州的儿童");
        bus.freeRide("山东的儿童");
    }
}
//抽象表达式类
interface Expression {
    public boolean interpret(String info);
}
//终结符表达式类
class TerminalExpression implements Expression {
    private Set<String> set = new HashSet<String>();
    public TerminalExpression(String[] data) {
        for (int i = 0; i < data.length; i++) set.add(data[i]);
    }
    public boolean interpret(String info) {
        if (set.contains(info)) {
            return true;
        }
        return false;
    }
}
//非终结符表达式类
class AndExpression implements Expression {
    private Expression city = null;
    private Expression person = null;
    public AndExpression(Expression city, Expression person) {
        this.city = city;
        this.person = person;
    }
    public boolean interpret(String info) {
        String s[] = info.split("的");
        return city.interpret(s[0]) && person.interpret(s[1]);
    }
}
//环境类
class Context {
    private String[] citys = {"韶关", "广州"};
    private String[] persons = {"老人", "妇女", "儿童"};
    private Expression cityPerson;
    public Context() {
        Expression city = new TerminalExpression(citys);
        Expression person = new TerminalExpression(persons);
        cityPerson = new AndExpression(city, person);
    }
    public void freeRide(String info) {
        boolean ok = cityPerson.interpret(info);
        if (ok) System.out.println("您是" + info + "，您本次乘车免费！");
        else System.out.println(info + "，您不是免费人员，本次乘车扣费2元！");
    }
}
