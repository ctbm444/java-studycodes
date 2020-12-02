package enumdemo;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @description: 用EnumMap代替序数索引 示例herb香草
 * @author: yanxiaotian
 * @create: 2020-12-02 11:28
 **/
public class Herb {
    public enum Type {ANNNUAL,PERENIAL,BIENNIAL}//香草类型枚举 一年生，两年生，三年生
    private final String name;
    private final Type type;
    Herb(String name,Type type){
        this.name=name;
        this.type=type;
    }
    @Override
    public String toString(){
        return this.name;
    }

    public static void main(String[] args) {
        /*
         * 需求：假设花园中有很多种香草，在一个数组里。你想要按照类型（一年生、两年生、三年生）进行组织之后列出来。
         *
         * 分析：最笨的方法是建三个集合，每种类型一个。然后遍历整个花园，将相应的香草放进相应的集合。
         *
         * 这时候有的程序员，会考虑将集合放进按照类型进行索引的数组中。
         * 这种方法确实行，但是隐藏着很多问题。因为数组不能与泛型兼容，
         *  程序需要进行未受检的转换，并且不能正确无误的进行编译。
         * 因为数组不知道他的索引代表着什么，你必须手动标注（label）这些索引的输出。
         * 这种方法最严重的问题在于，当你访问一个按照枚举的序数进行索引的数组时，使用正确的int值就是你的职责了，int不能提供枚举的类型安全。
         **/
        //错误写法。
        Herb[] garden=new Herb[]{new Herb("香草1",Type.ANNNUAL),
                new Herb("香草2",Type.PERENIAL),new Herb("香草3",Type.BIENNIAL),
                new Herb("香草4",Type.PERENIAL)};
        Set<Herb>[] herbsByType=(Set<Herb>[])new Set[Type.values().length];
        for(int i=0;i<herbsByType.length;i++){
            herbsByType[i]=new HashSet<Herb>();
        }
        for(Herb h:garden){
            herbsByType[h.type.ordinal()].add(h);
        }
        for(int i=0;i<herbsByType.length;i++){
            System.out.printf("%s: %s%n",Herb.Type.values()[i],herbsByType[i]);
        }

        //正确写法 使用enumMap
        EnumMap<Herb.Type,Set<Herb>> herbsMap=new EnumMap<Type, Set<Herb>>(Herb.Type.class);
        for(Herb.Type type:Herb.Type.values()){
            herbsMap.put(type,new HashSet<>());
        }
        for(Herb h:garden){
            herbsMap.get(h.type).add(h);
        }
        System.out.println(herbsMap);

    }
}
