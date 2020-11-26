package genericity;

import java.util.Random;

/**
 * @description: 泛型接口
 * @author: yanxiaotian
 * @create: 2020-11-26 10:43
 **/
public interface Generator<N> {
    public N next();
}

//不限制类型的实现类
class FruitGenerator<N> implements Generator<N>{


    public N next() {
        return null;
    }
}
//类型为String的接口的实现类。Generator可以有针对无数种类型的接口，每一种接口都可以有实现类；
class FruitGenerator2 implements Generator<String>{

    private String[] fruits=new String[]{"apple","banana","cherry"};

    public String next() {
        Random random=new Random();
        return fruits[random.nextInt(3)];
    }
}