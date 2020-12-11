package yxxy.c_026;

import java.util.concurrent.Executor;

/**
 * @description: 认识 Executor
 * @author: yanxiaotian
 * @create: 2020-12-08 17:00
 **/
public class T01_Executor implements Executor {
    @Override
    public void execute(Runnable command) {
        command.run();
    }

    public static void main(String[] args) {
        new T01_Executor().execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello executor");
            }
        });
    }
}
