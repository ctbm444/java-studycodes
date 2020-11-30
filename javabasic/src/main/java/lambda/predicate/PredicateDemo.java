package lambda.predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @description: predicate用法示例
 * @author: yanxiaotian
 * @create: 2020-11-30 12:18
 **/
public class PredicateDemo {
    public static void main(String[] args) {
        List names= Arrays.asList("java","scala","c++","haskell","lisp","hell","opt");
        Predicate<String> length=n-> n.length()==4;
        Predicate<String> startwith=n-> n.startsWith("l");
        Predicate<String> isEqual=n-> Predicate.isEqual("scala").test(n);
        names.stream()
                .filter(length.and(startwith).or(isEqual))
                .forEach(o-> System.out.println(o));
    }
}
