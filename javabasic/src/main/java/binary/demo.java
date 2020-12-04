package binary;

/**
 * @description:
 * @author: yanxiaotian
 * @create: 2020-12-04 10:51
 **/
public class demo {
    public static void main(String[] args) {
        Integer m=80;
        System.out.println(Integer.toBinaryString(m));
        Integer n=m>>3;
        System.out.println(Integer.toBinaryString(n));

        Integer m1=-80;
        System.out.println(Integer.toBinaryString(m1));
        Integer n1=m1>>3;
        System.out.println(Integer.toBinaryString(n1));
    }
}
