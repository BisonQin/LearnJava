package iodemo.Others;

import iodemo.util.FileUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by Basil on 2016/3/15.
 */
public class SplitFile {
    //文件的路径
    private String filePath;
    //文件名
    private String fileName;
    //文件大小
    private long length;
    //块数
    private int size;
    //每块的大小
    private long blockSize;
    //分割后存放的目录
    private String destBlockPath;
    //每块的名称
    private List<String> blockPath;

    public SplitFile() {
        blockPath = new ArrayList<String>();
    }

    public SplitFile(String filePath,String destBlockPath) {
        this(filePath,destBlockPath,1024);
    }

    public SplitFile(String filePath,String destBlockPath, long blockSize) {
        this();
        this.filePath = filePath;       //得到文件路径
        this.blockSize = blockSize;     //得到每块的大小
        this.destBlockPath = destBlockPath;
        init();
    }

    /**
     * 初始化操作  计算块数 确定文件名
     */
   public void init(){
       File src = null;
       //健壮性
        if(null == filePath ||!(((src = new File(filePath)).exists()))){        //文件路径为空或者不存在
            return;
        }
       if(src.isDirectory()){           //不能分割文件夹
            return;
       }
       //计算块数  实际大小 与每块大小
       this.length = src.length();      //得到文件的大小
       //修正每块大小
       if(this.blockSize>length){
            this.blockSize = length;        //每块的大小比文件大小还大的话，缩小分割块的大小
       }
       //确定块数
       size = (int)Math.ceil(length*1.0/this.blockSize);        //大小除以每块的大小，得到块数，取整
       //确定文件路径
       initPathName();
    }

    private void initPathName(){
        for(int i = 0;i<size;i++){
            this.blockPath.add(destBlockPath+"/"+this.fileName+".path"+i);        //往容器中添加每一块的名称
        }
   }

    /**
     * 文件的分割
     * 0.第几块
     * 1.起始位置
     * 2.实际大小
     * @param
     */
    public void split(String destPath){
        long beginPos = 0;//起始点
        long actualBlockSize = blockSize;       //实际大小等于每一块的大小
        //计算所有块的大小
        for(int i = 0;i<size;i++){          //遍历每一块
            if(i==size-1){
                actualBlockSize = this.length - beginPos;
            }
            splitDetail(i,beginPos,actualBlockSize);
            beginPos += actualBlockSize;    //起始位置移动，以实际大小为间隔
        }
    }

    /**
     * 文件的分割
     * @param index
     * @param beginPos
     * @param actualBlockSize
     */
    public void splitDetail(int index,long beginPos,long actualBlockSize){
        //创建源
        File src = new File(this.filePath); //源文件
        File dest = new File(this.blockPath.get(index));
        //选择流
        RandomAccessFile raf = null;
        BufferedOutputStream bos = null;
        try {
            raf = new RandomAccessFile(src,"r");
            bos = new BufferedOutputStream(
                    new FileOutputStream(dest)
            );

            //读取文件
            raf.seek(beginPos);
            //缓冲区
            byte[] flush = new byte[1024];
            //接收长度
            int len = 0;
            while(-1 != (len = raf.read(flush))){
                if(actualBlockSize - len>=0){       //查看是否足够写出
                    //写出
                    bos.write(flush,0,len);
                    actualBlockSize -= len;         //剩余量
                }else{      //写出最后一次的剩余量
                    bos.write(flush,0,(int)actualBlockSize);
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            FileUtil.closeAll(bos,raf);
        }
    }

    /**
     * 流的合并
     */
    public void merge(String destPath){
        //创建源
        File dest = new File(destPath);
        BufferedOutputStream bos = null;    //输出流
        SequenceInputStream sis = null;     //输入流
        //创建一个容器
        Vector<InputStream> vi = new Vector<InputStream>();
        try {
            for(int i=0;i<this.blockPath.size();i++){
                vi.add(new BufferedInputStream(new FileInputStream(new File(this.blockPath.get(i)))));//从容器中读取每个已经分割的文件名称并加到流中
            }
            bos = new BufferedOutputStream(new FileOutputStream(dest,true));        //追加
            sis = new SequenceInputStream(vi.elements());
                //缓冲区
                byte[] flush = new byte[1024];
                //接收长度
                int len = 0;
                while(-1 != (len = sis.read(flush))){
                    bos.write(flush,0,len);
                }
                bos.flush();
                FileUtil.closeAll(sis);
            } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally{
            FileUtil.closeAll(bos);
        }
    }
    /**
     * 文件的合并
     * @param
     */
    public void mergeFile(String destPath){
        //创建源
        File dest = new File(destPath);
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bos = new BufferedOutputStream(new FileOutputStream(dest,true));        //追加
        for(int i=0;i<this.blockPath.size();i++){
                bis = new BufferedInputStream(
                        new FileInputStream(
                        new File(this.blockPath.get(i))
                ));
            //缓冲区
            byte[] flush = new byte[1024];
            //接收长度
            int len = 0;
            while(-1 != (len = bis.read(flush))){
                bos.write(flush,0,len);
            }
            bos.flush();
            FileUtil.closeAll(bis);
        }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            FileUtil.closeAll(bos);
        }
    }

    public static void main(String[] args) {
        SplitFile split = new SplitFile("e:/test/Demo03.java","e:/test/split",500);
      //  System.out.println(split.size);
       // split.split("e:/test/split");

        split.merge("e:/test/merge/mergeTest.java");
    }
}
