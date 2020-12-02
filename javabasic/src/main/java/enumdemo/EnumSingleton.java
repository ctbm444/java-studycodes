package enumdemo;

/**
 * @description: 单例模式的枚举写法
 * @author: yanxiaotian
 * @create: 2020-12-02 09:24
 **/
public enum EnumSingleton {
    INSTANCE;

    public static void main(String[] args) {
        EnumSingleton a=EnumSingleton.INSTANCE;
        EnumSingleton b=EnumSingleton.INSTANCE;
        System.out.println(a==b);
    }
}
