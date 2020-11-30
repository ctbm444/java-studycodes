package lambda;

import java.util.function.Function;

/**
 * @description: lambda表达式符合函数  Funtion类的compose,andthen,apply方法的使用
 * @author: yanxiaotian
 * @create: 2020-11-30 15:39
 **/
public class FunctionComplex {
    public static void main(String[] args) {
        String text="我是一个普通的程序员，我喜欢敲代码，它可以让我实现自己的价值，帮助这个社会变得更美好。" +
                "\\n我最近在学习labda表达式，他真是太方便，太强大了！";
        Function<String,String> addHeader=Letter::addHeader;
        Function<String,String> resultFuntion=addHeader.andThen(Letter::addFooter).andThen(Letter::checkSpelling);
        String result=resultFuntion.apply(text);
        System.out.println(result);
    }
}

class Letter{
    public static String addHeader(String text){
        return "亲爱的xxx：\n   "+text;
    }
    public static String addFooter(String text){
        return text+"\n   此致,敬礼！";
    }
    public static String checkSpelling(String text){
        return text.replaceAll("labda","lambda");
    }
}
