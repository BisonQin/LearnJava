package iodemo.Others;

import com.basil.io.util.FileUtil;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 文件的分割思路
 * 1.分割的块数  size
 * 2.每一块的大小  blockSize
 *  最后：总的文件大小 -(n-1)*blockSize
 * Created by Basil on 2016/3/15.
 */
public class RandomDemo01 {

    public static void main(String[] args) throws IOException {
        RandomAccessFile rnd = new RandomAccessFile("e:/test/Demo03.java","r");

        rnd.seek(1000);     //定义跳过的大小
        //定义一个缓冲大小
        byte[] flush = new byte[1024];
        //接收长度
        int len = 0;

        while(-1 != (len = rnd.read(flush))){
            if(len>=200){
                System.out.println(new String(flush,0,200));
                break;
            }else{
                System.out.println(new String(flush,0,len));
            }

        }
        FileUtil.closeAll(rnd);
    }
}
