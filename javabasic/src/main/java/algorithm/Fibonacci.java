package algorithm;

/**
 * @description: 斐波那契数列算法
 * @author: yanxiaotian
 * @create: 2020-12-11 11:35
 **/
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(getStairSteps(10));
    }

    /**
     * 有一段楼梯有10级台阶,规定每一步只能跨一级或两级,要登上第10级台阶有几种不同的走法?
     * f(1)=1
     * f(2)=f(1)+f(1)
     * f(3)=f(2)+f(1)
     * f(4)=f(3)+(2)
     * ...
     * f(n)=f(n-1)+f(n-2)
     *
     * m为楼梯阶数 返回值为走法种数
     */
    static int getStairSteps(int m){
        if(m==1){
            return 1;
        }
        if(m==2){
            return 2;
        }
        return getStairSteps(m-1)+getStairSteps(m-2);
    }
}
