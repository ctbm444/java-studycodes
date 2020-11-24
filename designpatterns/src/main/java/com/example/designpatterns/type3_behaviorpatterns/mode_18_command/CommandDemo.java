package com.example.designpatterns.type3_behaviorpatterns.mode_18_command;

/**
 * @description: 命令模式示例
 * 客户去餐馆可选择的早餐有肠粉、河粉和馄饨等，客户可向服务员选择以上早餐中的若干种，服务员将客户的请求交给相关的厨师去做。
 * 这里的点早餐相当于“命令”，服务员相当于“调用者”，厨师相当于“接收者”，所以用命令模式实现比较合适。
 * 首先，定义一个早餐类（Breakfast），它是抽象命令类，有抽象方法 cooking()，说明要做什么；
 * 再定义其子类肠粉类（ChangFen）、馄饨类（HunTun）和河粉类（HeFen），它们是具体命令类，实现早餐类的 cooking() 方法，但它们不会具体做，而是交给具体的厨师去做；
 * 具体厨师类有肠粉厨师（ChangFenChef）、馄饨厨师（HunTunChef）和河粉厨师（HeFenChef），他们是命令的接收者。
 * @author: yanxiaotian
 * @create: 2020-11-24 09:45
 **/
public class CommandDemo {
    public static void main(String[] args) {
        Waiter waiter=new Waiter();
        waiter.setChangfen(new Changfen());
        waiter.setHuntun(new Huntun());
        waiter.setHefen(new Hefen());
        waiter.chooseBreakfast("馄饨");
    }
}
//抽象命令类 早餐
abstract class Breakfast{
    abstract void cook();
}

//具体命令类 肠粉
class Changfen extends Breakfast{
    ChangfenChef changfenChef=new ChangfenChef();
    @Override
    void cook() {
        changfenChef.cooking();
    }
}

//具体命令类 馄饨
class Huntun extends Breakfast{
    HuntunChef huntunChef=new HuntunChef();
    @Override
    void cook() {
        huntunChef.cooking();
    }
}

//具体命令类 河粉
class Hefen extends Breakfast{
    HefenChef hefenChef=new HefenChef();
    @Override
    void cook() {
        hefenChef.cooking();
    }
}

//具体厨师类 肠粉厨师
class ChangfenChef{
    void cooking(){
        System.out.println("肠粉厨师开始做肠粉！");
    }
}

//具体厨师类 馄饨厨师
class HuntunChef{
    void cooking(){
        System.out.println("馄饨厨师开始做馄饨！");
    }
}

//具体厨师类 河粉厨师
class  HefenChef{
    void cooking(){
        System.out.println("河粉厨师开始做河粉！");
    }
}

//服务员
class Waiter{
    Changfen changfen=null;
    Huntun huntun=null;
    Hefen hefen=null;

    public void setChangfen(Changfen changfen) {
        this.changfen = changfen;
    }

    public void setHuntun(Huntun huntun) {
        this.huntun = huntun;
    }

    public void setHefen(Hefen hefen) {
        this.hefen = hefen;
    }
    public void chooseBreakfast(String name){
        System.out.println("顾客让服务员点了"+name);
        switch (name){
            case "肠粉": changfen.cook(); break;
            case "馄饨": huntun.cook(); break;
            case "河粉": hefen.cook(); break;
            default:
                System.out.println("本店只能点菜单上的早餐！"); break;
        }
        System.out.println("请用餐（"+name+")");
    }
}

