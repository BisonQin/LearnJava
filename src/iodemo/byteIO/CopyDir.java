package iodemo.byteIO;

import com.basil.io.util.FileUtil;

import java.io.File;
import java.io.IOException;

/**
 * 拷贝文件夹
 * 拷贝文件夹时，要确认父目录不拷贝在字目录中，否则会出现超长文件夹
 * Created by Basil on 2016/3/13.
 */
public class CopyDir {

    public static void main(String[] args) {
        String srcPath = "e:/test/test";//源目录
        String destPath = "e:/test/dir";//目标文件
        File src = new File(srcPath);
        File dest = new File(destPath);
        try {
            FileUtil.copyDir(src,dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
