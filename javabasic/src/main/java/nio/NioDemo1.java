package nio;



import sun.nio.ch.DirectBuffer;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @description:
 * @author: yanxiaotian
 * @create: 2020-12-11 16:17
 **/
public class NioDemo1 {
    public static void main(String[] args) {
        //分配缓存
        ByteBuffer buf= ByteBuffer.allocate(1024);
        System.out.println("初始化");
        System.out.println("position:"+buf.position());
        System.out.println("limit:"+buf.limit());
        System.out.println("capacity:"+buf.capacity());

        //将数据存入缓冲区
        String str="abcde";
        buf.put(str.getBytes());
        System.out.println("存入数据");
        System.out.println("position:"+buf.position());
        System.out.println("limit:"+buf.limit());
        System.out.println("capacity:"+buf.capacity());

        //切换到读取模式
        buf.flip();
        System.out.println("切换到读取模式");
        System.out.println("position:"+buf.position());
        System.out.println("limit:"+buf.limit());
        System.out.println("capacity:"+buf.capacity());

        //开始读取数据
        System.out.println("开始读取数据");
        byte[] dst= new byte[buf.limit()];
        buf.get(dst);
        System.out.println(new String(dst));

        System.out.println("数据读取完毕");
        System.out.println("position:"+buf.position());
        System.out.println("limit:"+buf.limit());
        System.out.println("capacity:"+buf.capacity());

        //rewind表示重复读
        buf.rewind();
        System.out.println("rewind");
        dst=new byte[buf.limit()];
        buf.get(dst);
        System.out.println(new String(dst,0,dst.length));
        System.out.println("position:"+buf.position());
        System.out.println("limit:"+buf.limit());
        System.out.println("capacity:"+buf.capacity());

        //清空缓存区
        buf.clear();
        System.out.println("clear");
        System.out.println("position:"+buf.position());
        System.out.println("limit:"+buf.limit());
        System.out.println("capacity:"+buf.capacity());

        System.out.println(buf.isDirect());

        ByteBuffer buff= ByteBuffer.allocateDirect(1024);
    }
}
