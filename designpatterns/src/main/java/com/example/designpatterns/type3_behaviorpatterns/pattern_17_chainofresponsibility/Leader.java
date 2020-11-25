package com.example.designpatterns.type3_behaviorpatterns.pattern_17_chainofresponsibility;

/**
 * @description: 责任链模式
 * 假如规定学生请假小于或等于 2 天，班主任可以批准；小于或等于 7 天，系主任可以批准；小于或等于 10 天，
 * 院长可以批准；其他情况不予批准；这个实例适合使用职责链模式实现。
 * @author: yanxiaotian
 * @create: 2020-11-24 09:08
 **/
//测试类
class Test{
    public static void main(String[] args) {
        ClassAdviser classAdviser=new ClassAdviser();
        DepartmentHead departmentHead=new DepartmentHead();
        Dean dean=new Dean();
        //设置责任链
        classAdviser.setNext(departmentHead);
        departmentHead.setNext(dean);
        //向班主任请假1、3、8、12天
        classAdviser.handleRequest(12);
    }
}
//抽象处理者类
abstract class Leader {
    private Leader next;

    public Leader getNext() {
        return next;
    }

    public void setNext(Leader next) {
        this.next = next;
    }

    public abstract void handleRequest(int leaveDays);
}
//班主任实现类
class ClassAdviser extends Leader{

    @Override
    public void handleRequest(int leaveDays) {
        if(leaveDays<=2){
            System.out.println("班主任批准请假"+leaveDays+"天！");
        }else{
            if(getNext()!=null){
                getNext().handleRequest(leaveDays);
            }else{
                System.out.println("没有指定审批人员！");
            }
        }
    }
}
//系主任实现类
class DepartmentHead extends Leader{

    @Override
    public void handleRequest(int leaveDays) {
        if(leaveDays<=7){
            System.out.println("系主任批准请假"+leaveDays+"天！");
        }else{
            if(getNext()!=null){
                getNext().handleRequest(leaveDays);
            }else{
                System.out.println("没有指定审批人员");
            }
        }
    }
}
//院长实现类
class Dean extends Leader{

    @Override
    public void handleRequest(int leaveDays) {
        if(leaveDays<10){
            System.out.println("院长批准请假"+leaveDays+"天！");
        }else{
            if(getNext()!=null){
                getNext().handleRequest(leaveDays);
            }else{
                System.out.println("没有指定审批人员！");
            }
        }
    }
}
