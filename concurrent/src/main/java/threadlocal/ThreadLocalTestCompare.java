package threadlocal;

/**
 * @description: 对比类
 * @author: yanxiaotian
 * @create: 2020-12-01 09:12
 **/
public class ThreadLocalTestCompare {

    static class Resource{
        private static String resource1;
        private static String resource2;
    }

    static class A{
        public void set1(String value){
            Resource.resource1=value;
        }
        public void set2(String value){
            Resource.resource2=value;
        }
    }

    static class B{
        public void display(){
            System.out.println(Resource.resource1+","+Resource.resource2);
        }
    }

    public static void main(String[] args) {
        final ThreadLocalTestCompare.A a=new ThreadLocalTestCompare.A();
        final ThreadLocalTestCompare.B b=new ThreadLocalTestCompare.B();
        for(int i=0;i<15;i++){
            final String s1="线程"+i;
            final String s2="value="+i;
            new Thread(){
                @Override
                public void run() {
                    a.set1(s1);
                    a.set2(s2);
                    b.display();
                }
            }.start();
        }
    }
}


