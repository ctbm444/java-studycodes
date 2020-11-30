package lambda.stream;

import com.google.gson.Gson;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @description: lambda表达式stream操作示例类
 * @author: yanxiaotian
 * @create: 2020-11-30 16:23
 **/
public class streamDemo {
    public static void main(String[] args) {
        List<User> list = Arrays.asList(
                new User("李星云", 18, 0, "渝州",new BigDecimal(1000)),
                new User("李星云", 18, 0, "渝州",new BigDecimal(1000)),
                new User("李星云", 18, 0, "渝州",new BigDecimal(1000)),
                new User("陆林轩", 16, 1, "渝州",new BigDecimal(500)),
                new User("姬如雪", 17, 1, "幻音坊",new BigDecimal(800)),
                new User("袁天罡", 99, 0, "藏兵谷",new BigDecimal(100000)),
                new User("张子凡", 19, 0, "天师府",new BigDecimal(900)),
                new User("陆佑劫", 45, 0, "不良人",new BigDecimal(600)),
                new User("张天师", 48, 0, "天师府",new BigDecimal(1100)),
                new User("蚩梦", 18, 1, "万毒窟",new BigDecimal(800))
        );
        System.out.println("---------------------过滤--------------");
        //filter 过滤
        List<User> list1=list.stream()
                .filter(user->user.getAge()>20)
                .collect(Collectors.toList());
        list1.forEach(o-> System.out.println(o.getName()+","+o.getAge()));

        System.out.println("---------------------去重--------------");
        //distinct 去重
        List<User> list2=list.stream().distinct().collect(Collectors.toList());
        list2.forEach(o-> System.out.println(o.getName()+","+o.getAge()));

        System.out.println("---------------------排序--------------");
        List<User> list3=list.stream()
                .sorted(Comparator.comparingInt(user->user.getAge()))
                .collect(Collectors.toList());
        list3.forEach(o-> System.out.println(o.getName()+","+o.getAge()));

        System.out.println("---------------------返回前n个元素--------------");
        List<User> list4=list.stream()
                .sorted(Comparator.comparingInt(user->user.getAge()))
                .limit(5)
                .collect(Collectors.toList());
        list4.forEach(o-> System.out.println(o.getName()+","+o.getAge()));

        System.out.println("---------------------跳过前n个元素--------------");
        List<User> list5=list.stream()
                .sorted(Comparator.comparingInt(user->user.getAge()))
                .skip(3)
                .collect(Collectors.toList());
        list5.forEach(o-> System.out.println(o.getName()+","+o.getAge()));

        System.out.println("---------------------取单个字段到一个list--------------");
        List<String> list6=list.stream().map(User::getName).distinct().collect(Collectors.toList());
        list6.forEach(System.out::println);

        System.out.println("---------------------拆分字符串--------------");
        /*
            这里原集合中的数据由逗号分割，使用split进行拆分后，得到的是Stream<String[]>，
            字符串数组组成的流，要使用flatMap的Arrays::stream
            将Stream<String[]>转为Stream<String>,然后把流相连接
        */
        List<String> flatMap=new ArrayList<>();
        flatMap.add("常宣灵,常昊灵");
        flatMap.add("孟婆,判官红,判官蓝");
        List list7=flatMap.stream()
                .map(s->s.split(","))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        list7.forEach(System.out::println);

        System.out.println("---------------------检查是否全部满足某条件--------------");
        boolean flag1=list.stream().allMatch(user -> user.getAge()>10);
        System.out.println(flag1);

        System.out.println("---------------------检查是否有一条满足某条件--------------");
        boolean flag2=list.stream().anyMatch(user -> user.getAge()>60);
        System.out.println(flag2);

        System.out.println("---------------------检查是否没有一条满足给定条件--------------");
        boolean flag3=list.stream().noneMatch(user -> user.getName().contains("天师"));
        System.out.println(flag3);

        System.out.println("---------------------找到第一条--------------");
        Optional<User> optionalUser1=list.stream().findFirst();
        System.out.println(optionalUser1.toString());

        System.out.println("---------------------找到任意一条--------------");
        //使用findAny()是为了更高效的性能。如果是数据较少，串行地情况下，一般会返回第一个结果，如果是并行的情况，那就不能确保是第一个。
        Optional<User> optionalUser2=list.parallelStream().findAny();
        System.out.println(optionalUser2.get().toString());

        System.out.println("---------------------计算总数--------------");
        Long count=list.stream().count();
        System.out.println(count);

        System.out.println("---------------------找到最大值最小值--------------");
        User max=list.stream().collect(Collectors.minBy(Comparator.comparingInt(User::getAge))).get();
        System.out.println(max.toString());

        System.out.println("---------------------求和，求平均值--------------");
        int ages=list.stream().collect(Collectors.summingInt(User::getAge));
        System.out.println("总岁数为"+ages);
        BigDecimal totalMoney=list.stream().map(User::getMoney).reduce(BigDecimal.ZERO,BigDecimal::add);
        System.out.println("总金额为："+totalMoney);
        double averageAge=list.stream().collect(Collectors.averagingInt(User::getAge));
        System.out.println("平均年龄："+averageAge);

        System.out.println("---------------------一次性获取个数、总数、最大值、最小值--------------");
        IntSummaryStatistics statistics =list.stream().collect(Collectors.summarizingInt(User::getAge));
        System.out.println(statistics);

        System.out.println("---------------------拼接--------------");
        String names=list.stream().map(User::getName).distinct().collect(Collectors.joining(","));
        System.out.println(names);

        System.out.println("---------------------分组--------------");
        Map<Integer,List<User>> ageMap=list.stream().collect(Collectors.groupingBy(User::getAge));
        System.out.println(new Gson().toJson(ageMap));
        Map<Integer,Map<Integer,List<User>>> sexMap
                =list.stream()
                .collect(Collectors.groupingBy(User::getSex,Collectors.groupingBy(User::getAge)));
        System.out.println(new Gson().toJson(sexMap));

        System.out.println("---------------------分组合计--------------");
        Map<Integer,Long> countMap=list.stream().collect(Collectors.groupingBy(User::getSex,Collectors.counting()));
        System.out.println(countMap);


        System.out.println("---------------------list转map--------------");
        Map<String,Integer> map1=list.stream().distinct().collect((Collectors.toMap(User::getName,User::getAge)));
        Map<String,User> map2= list.stream().distinct().collect(Collectors.toMap(User::getName,User->User));
        Map<String,User> map3=list.stream().distinct().collect(Collectors.toMap(User::getName, Function.identity()));
        Map<String,User> map4=list.stream().collect(Collectors.toMap(User::getName,Function.identity(),(k1,k2)->k2));
        //map4.forEach((s,v)-> System.out.println(v));
    }
}
