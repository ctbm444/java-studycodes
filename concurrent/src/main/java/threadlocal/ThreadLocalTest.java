package threadlocal;

/**
 * @description: threadlocal测试类
 * @author: yanxiaotian
 * @create: 2020-12-01 08:52
 **/
public class ThreadLocalTest {

    static class ResourceClass{
        private static final ThreadLocal<String> resource1=new ThreadLocal<>();
        private static final ThreadLocal<String> resource2=new ThreadLocal<>();
    }

    static class A{
        public void setOne(String value){
            ResourceClass.resource1.set(value);
        }
        public void setTwo(String value){
            ResourceClass.resource2.set(value);
        }
    }

    static class B{
        public void display(){
            System.out.println(ResourceClass.resource1.get()+","+ResourceClass.resource2.get());
        }
    }

    public static void main(String[] args) {
        final A a=new A();
        final B b=new B();
        for(int i=0;i<15;i++){
            final String s1="线程"+i;
            final String s2="value="+i;
            new Thread(){
                @Override
                public void run() {
                    try {
                        a.setOne(s1);
                        a.setTwo(s2);
                        b.display();
                    } finally {
                        ResourceClass.resource1.remove();
                        ResourceClass.resource2.remove();
                    }
                }
            }.start();
        }
    }
}
